package com.socket;

import com.ui.ChatFrame;
import java.io.IOException;
import java.net.Socket;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.InetAddress;
import java.net.URL;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.LinkedHashSet;


public class SocketClient implements Runnable{
    
    public int port;
    public String serverAddr;
    public Socket socket;
    public ChatFrame ui;
    public ObjectInputStream In;
    public ObjectOutputStream Out;
    

    public SocketClient(ChatFrame frame) throws IOException{
       
        ui = frame; 
        this.serverAddr = ui.serverAddr;
        this.port = ui.port;
        socket = new Socket(InetAddress.getByName(serverAddr), port); 
        Out = new ObjectOutputStream(socket.getOutputStream());
        Out.flush();
        In = new ObjectInputStream(socket.getInputStream());
       
    }

    @Override
    public void run() {

        boolean keepRunning = true;
        while(keepRunning){
            try {
                Message msg = (Message) In.readObject();
                System.out.println("Incoming : "+msg.toString());
 
                if(msg.type.equals("message") && ui.jButton2.isEnabled() == false ){
                    if(msg.recipient.equals(ui.username)){
                       
                         ui.jTextArea1.append("[ "+msg.sender +" ] " + "[ "+ msg.fd +" ] : " + msg.content +"\n");
                         scrollDown();
                         URL url = this.getClass().getResource("2.wav");
                         AudioClip clip = Applet.newAudioClip(url);
                         clip.play();
                         ui.requestFocus();
                         ui.jTextField4.requestFocusInWindow();
                       
                    }
                    else
                    {
                        ui.jTextArea1.append("[ "+msg.sender +" ] " + "[ "+ msg.fd +" ] : " + msg.content + "\n");
                        scrollDown();
                        URL url = this.getClass().getResource("2.wav");
                        AudioClip clip = Applet.newAudioClip(url);
                        clip.play();
                        ui.requestFocus();
                        ui.jTextField4.requestFocusInWindow();
                       
                    }
                }
                else if(msg.type.equals("login")){
                    if(msg.content.equals("TRUE")){
                        
                        ui.jButton2.setEnabled(false); ui.jButton3.setEnabled(false);                                            
                        ui.jTextField2.setText(" login successful");
                        buf();
                        ui.jTextField3.setEnabled(false); ui.jPasswordField1.setEnabled(false);
                        ui.jTextField1.setEnabled(true);
                        ui.jLabel6.setEnabled(true);
                        ui.jButton4.setEnabled(true);
                        ui.jButton5.setEnabled(true);
                        ui.jCheckBox1.setEnabled(true);
                        ui.jCheckBox2.setEnabled(true);
                    }
                    else{
                        ui.jTextField2.setText(" login failed"); 
                        ui.jTextField4.setEditable(false);              
                        ui.setLabelText("");
                    }
                }
                else if(msg.type.equals("test")){
                    
                    ui.jButton2.setEnabled(true); ui.jButton3.setEnabled(true);
                    ui.jTextField3.setEnabled(true); ui.jPasswordField1.setEnabled(true); 
                }
                else if(msg.type.equals("newuser")){
                    if(!msg.content.equals(ui.username)){
                        boolean exists = false;
                        for(int i = 0; i < ui.model.getSize(); i++){
                            if(ui.model.getElementAt(i).equals(msg.content)){
                                exists = true; break;
                            }
                        }
                        if(!exists){ ui.model.addElement(msg.content); }
                    }
                }
                else if(msg.type.equals("signup")){
                    if(msg.content.equals("TRUE")){
                      
                        ui.jButton2.setEnabled(false); ui.jButton3.setEnabled(false);                  
                        ui.jTextField2.setText(" signup successful"); 
                        ui.jTextField1.setEnabled(true);
                        ui.jLabel6.setEnabled(true);
                        ui.jButton4.setEnabled(true);
                        ui.jButton5.setEnabled(true);
                        ui.jCheckBox1.setEnabled(true);
                        ui.jCheckBox2.setEnabled(true);
   
                    }
                    else{
                        ui.jTextField2.setText(" signup failed");
                        ui.jTextField4.setEditable(false);
                        ui.setLabelText("");
                    }
                }
                else if(msg.type.equals("signout")){
                    if(msg.content.equals(ui.username)){
                        ui.jTextArea1.append("[ "+ msg.sender +" ] : Bye\n");
                        for(int i = 1; i < ui.model.size(); i++){
                            ui.model.removeElementAt(i);
                        } 
                        ui.clientThread.stop();
                    }
                    else if(ui.jButton2.isEnabled() == false){
                        ui.model.removeElement(msg.content); 
                    }
                }
            }
            catch(Exception ex) {
                keepRunning = false;
                ui.jTextField2.setText(" Connection failure");
                ui.jButton6.setEnabled(true);
                for(int i = 1; i < ui.model.size(); i++){
                    ui.model.removeElementAt(i);
                }
                ui.clientThread.stop();
                System.out.println("Exception SocketClient run()");
                ex.printStackTrace();
            }
        }
    }
    
            public void scrollDown(){
            ui.jTextArea1.setCaretPosition(ui.jTextArea1.getText().length());}
                                                                             
            public void buf()
            {
                  try {
                     BufferedReader br = new BufferedReader(new FileReader(new File("msg.txt")));    
                     String readLine = "";
                     LinkedHashSet<String> lh = new LinkedHashSet<String>();
                     while ((readLine = br.readLine()) != null) {       
                      lh.add(readLine);
                    }
                      for(String s : lh) {
                      ui.jTextArea1.append(s +"\n");
                      }
                      scrollDown();

                } catch (IOException exp) {
                    exp.printStackTrace();
                }
            }

            public void send(Message msg){
                try {
                    Out.writeObject(msg);
                    Out.flush();
                    System.out.println("Outgoing : "+msg.toString());   
                } 
                catch (IOException ex) {
                    System.out.println("Exception SocketClient send()");
                }
            }

            public void closeThread(Thread t){
                t = null;
            }
        }
