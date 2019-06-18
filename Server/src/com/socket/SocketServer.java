package com.socket;


import java.applet.Applet;
import java.applet.AudioClip;
import java.io.IOException;
import java.net.Socket;
import java.net.InetAddress;
import java.net.URL;
import java.net.ServerSocket;
import java.io.File;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

class ServerThread extends Thread { 
	
    public SocketServer server = null;
    public Socket socket = null;
    public int ID = -1;
    public String username = "";
    public ObjectInputStream streamIn  =  null;
    public ObjectOutputStream streamOut = null;
    public ServerFrame ui;
    
    
    

    public ServerThread(SocketServer _server, Socket _socket){  
    	super();
        server = _server;
        socket = _socket;
        ID     = socket.getPort();
        ui = _server.ui;
        
        
    }
    
    public void send(Message msg){
        try {
            streamOut.writeObject(msg);
            
            streamOut.flush();
        } 
        catch (IOException ex) {
            System.out.println("Exception [SocketClient : send(...)]");
        }
    }
    
    public int getID(){  
	    return ID;
    }
   
    @SuppressWarnings("deprecation")
	public void run(){  
    	ui.jTextArea1.append("\nServer Thread " + ID + " running.");
        while (true){  
    	    try{  
                Message msg = (Message) streamIn.readObject();
                
    	    	server.handle(ID, msg);
                
            }
            catch(Exception ioe){  
            	System.out.println(ID + " ERROR reading: " + ioe.getMessage());
                server.remove(ID);
                stop();
            }
            
        }
    }
    
    public void open() throws IOException {  
        streamOut = new ObjectOutputStream(socket.getOutputStream());
        streamOut.flush();
        streamIn = new ObjectInputStream(socket.getInputStream());
    }
    
    public void close() throws IOException {  
    	if (socket != null)    socket.close();
        if (streamIn != null)  streamIn.close();
        if (streamOut != null) streamOut.close();
    }
}

public class SocketServer implements Runnable {
    
    public History hist;
    
    public ServerThread clients[];
    public ServerSocket server = null;
    public Thread       thread = null;
    public int clientCount = 0, port = 13700;
    public ServerFrame ui;
    public Database db;
    public String con;
    public String sen;
    public String rec;
    public String ip;
    public String fp;
    

    public SocketServer(ServerFrame frame){
        

        clients = new ServerThread[100];
        ui = frame;
        db = new Database(ui.filePath);
         try{
                InetAddress localhost = InetAddress.getLocalHost();
                ip=localhost.getHostAddress().trim();
                
                }catch(Exception ep){ }
	try{  
            
	    server = new ServerSocket(port);
            port = server.getLocalPort();
	    ui.jTextArea1.append("Server started. IP : " + InetAddress.getLocalHost() + ", Port : " + server.getLocalPort());
	    start(); 
        }
	catch(IOException ioe){  
            ui.jTextArea1.append("Cannot bind to port : " + port + "\nRetrying"); 
            ui.RetryStart(0);
	}
    }
    
    public SocketServer(ServerFrame frame, int Port){
       
        clients = new ServerThread[100];
        ui = frame;
        port = Port;
        db = new Database(ui.filePath);
        
	try{  
	    server = new ServerSocket(port);
            port = server.getLocalPort();
	    ui.jTextArea1.append("Server started. IP : " + InetAddress.getLocalHost() + ", Port : " + server.getLocalPort());
	    start(); 
        }
	catch(IOException ioe){  
            ui.jTextArea1.append("\nCannot bind to port " + port + ": " + ioe.getMessage()); 
	}
    }
	
    public void run(){ 
        
	while (thread != null){  
            try{  
                
		ui.jTextArea1.append("\nWaiting for a client ..."); 
                
                
	        addThread(server.accept()); 
	    }
	    catch(Exception ioe){ 
                ui.jTextArea1.append("\nServer accept error: \n");
                ui.RetryStart(0);
	    }
        }
    }
	
    public void start(){  
    	if (thread == null){  
            thread = new Thread(this); 
	    thread.start();
	}
    }
    
    @SuppressWarnings("deprecation")
    public void stop(){  
        if (thread != null){  
            thread.stop(); 
	    thread = null;
	}
    }
    
    private int findClient(int ID){  
    	for (int i = 0; i < clientCount; i++){
        	if (clients[i].getID() == ID){
                    return i;
                }
	}
	return -1;
    }
    
    public void addMessage(Message msg, String time){
        
        try {
            
 
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse("History.xml");
 
            Node data = doc.getFirstChild();
            
            Element message = doc.createElement("message");
            Element _sender = doc.createElement("sender"); _sender.setTextContent(sen);
            Element _content = doc.createElement("content"); _content.setTextContent(con);
            Element _recipient = doc.createElement("recipient"); _recipient.setTextContent(rec);
            Element _time = doc.createElement("time"); _time.setTextContent(time);
            
            message.appendChild(_sender); message.appendChild(_content); message.appendChild(_recipient); message.appendChild(_time);
            data.appendChild(message);
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("History.xml"));
            transformer.transform(source, result);
 
	   } 
           catch(Exception ex){
		System.out.println("Exceptionmodify xml");
	   }
	}
	
    public synchronized void handle(int ID, Message msg){  
	if (msg.content.equals(".bye")){
            Announce("signout", "SERVER", msg.sender,msg.fd);
            remove(ID); 
	}
	else{
            if(msg.type.equals("login")){
                
                
                if(findUserThread(msg.sender) == null){
                    
                    if(db.checkLogin(msg.sender, msg.content)){
                        clients[findClient(ID)].username = msg.sender;
                        clients[findClient(ID)].send(new Message("login", "SERVER", "TRUE", msg.sender, msg.fd));
                        Announce("newuser", "SERVER", msg.sender,msg.fd);
                        SendUserList(msg.sender);
                    }
                    else{
                        clients[findClient(ID)].send(new Message("login", "SERVER", "FALSE", msg.sender, msg.fd));
                    } 
                }
                else{
                    clients[findClient(ID)].send(new Message("login", "SERVER", "FALSE", msg.sender, msg.fd));
                }
            }
            else if(msg.type.equals("message")){
                
                sen = msg.sender;
                con = msg.content;
                rec = msg.recipient;
                
                DateFormat df = new SimpleDateFormat("d-MMM-yyyy, EEE, hh:mm a");
                String msgTime = df.format(new Date());
                try{
                addMessage(msg, msgTime);               
                }catch(Exception ex)
                {
                    ex.printStackTrace();
                }
                
               
                
                if(msg.recipient.equals("All")){
                    Announce("message", msg.sender, msg.content,msg.fd);
                }
                else{
                    findUserThread(msg.recipient).send(new Message(msg.type, msg.sender, msg.content, msg.recipient , msg.fd));
                    clients[findClient(ID)].send(new Message(msg.type, msg.sender, msg.content, msg.recipient, msg.fd));
                }
                
            }
            else if(msg.type.equals("test")){
                clients[findClient(ID)].send(new Message("test", "SERVER", "OK", msg.sender, msg.fd));
            }
            else if(msg.type.equals("signup")){
                if(findUserThread(msg.sender) == null){
                    if(!db.userExists(msg.sender)){
                        db.addUser(msg.sender, msg.content);
                        clients[findClient(ID)].username = msg.sender;
                        clients[findClient(ID)].send(new Message("signup", "SERVER", "TRUE", msg.sender, msg.fd));
                        clients[findClient(ID)].send(new Message("login", "SERVER", "TRUE", msg.sender, msg.fd));
                        Announce("newuser", "SERVER", msg.sender,msg.fd);
                        SendUserList(msg.sender);
                    }
                    else{
                        clients[findClient(ID)].send(new Message("signup", "SERVER", "FALSE", msg.sender, msg.fd));
                    }
                }
                else{
                    clients[findClient(ID)].send(new Message("signup", "SERVER", "FALSE", msg.sender, msg.fd));
                }
            }    
	}
    }
    
    
    
    public void Announce(String type, String sender, String content, String fd){
        Message msg = new Message(type, sender, content, "All", fd);
        for(int i = 0; i < clientCount; i++){
            clients[i].send(msg);
        }
    }
    
    public void SendUserList(String toWhom){
        
        for(int i = 0; i < clientCount; i++){
            findUserThread(toWhom).send(new Message("newuser", "SERVER", clients[i].username, toWhom, ""));
        }
    }
    
   
    public ServerThread findUserThread(String usr){

        for(int i = 0; i < clientCount; i++){
            if(clients[i].username.equals(usr)){
                return clients[i];
            }
        }
        return null;
    }
	
    @SuppressWarnings("deprecation")
    public synchronized void remove(int ID){  
    int pos = findClient(ID);
        if (pos >= 0){  
            ServerThread toTerminate = clients[pos];
            ui.jTextArea1.append("\nRemoving client thread " + ID + " at " + pos);
	    if (pos < clientCount-1){
                for (int i = pos+1; i < clientCount; i++){
                    clients[i-1] = clients[i];
	        }
	    }
	    clientCount--;
	    try{  
	      	toTerminate.close(); 
	    }
	    catch(IOException ioe){  
	      	ui.jTextArea1.append("\nError closing thread: " + ioe); 
	    }
	    toTerminate.stop(); 
	}
    }
    
    private void addThread(Socket socket){  
        
	if (clientCount < clients.length){  
            ui.jTextArea1.append("\nClient accepted: " + socket);
            ui.requestFocus();
            URL url = this.getClass().getResource("2.wav");
            AudioClip clip = Applet.newAudioClip(url);
            clip.play();
	    clients[clientCount] = new ServerThread(this, socket);
	    try{  
	      	clients[clientCount].open(); 
	        clients[clientCount].start();  
	        clientCount++; 
	    }
	    catch(IOException ioe){  
	      	ui.jTextArea1.append("\nError opening thread: " + ioe); 
	    } 
	}
	else{
            ui.jTextArea1.append("\nClient refused: maximum " + clients.length + " reached.");
	}
    }
}
