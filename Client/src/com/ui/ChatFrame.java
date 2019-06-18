package com.ui;

import com.socket.Message;
import com.socket.SocketClient;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.io.File;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.DefaultListModel;
import java.awt.Dimension;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.BadLocationException;;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.regex.Matcher;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.JLayer;
import javax.swing.JViewport;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.LayerUI;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import javax.swing.JFrame;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.net.URL;
import javax.swing.JDialog;
import javax.swing.JOptionPane;




public class ChatFrame extends javax.swing.JFrame {
   

    private static final Color WARNING_COLOR = new Color(255, 200, 200);
    private final transient Highlighter.HighlightPainter currentPainter   = new DefaultHighlighter.DefaultHighlightPainter(Color.LIGHT_GRAY);
    private final transient Highlighter.HighlightPainter highlightPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.CYAN);
 
    protected int current;
     

    public SocketClient client,sc;
    public int port;
    public String serverAddr, username, password;
    public Thread clientThread;
    public DefaultListModel model;
    public File file;
    public Discussion des;
    public String ip="192.168.1.5";
    public JDialog dialog = new JDialog();
    
  
    public ChatFrame() {
 
         ChatFrame frame=this;
         this.pack();
         this.setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("1.jpg"))));
         this.getContentPane().setPreferredSize(new Dimension(1135,770));
         dialog.setLocation(this.getLocation());
         dialog.setAlwaysOnTop(true);
          
        initComponents(); 
        model.addElement("All");
        jList1.setSelectedIndex(0);
        jButton4.setText("\u22C0");  
        jButton5.setText("\u22C1");   
        jButton4.setActionCommand("prev");
        jButton5.setActionCommand("next");
        jButton6.setVisible(false);
        
        HighlightHandler handler = new HighlightHandler();
        jTextField1.getDocument().addDocumentListener(handler);
        for (AbstractButton b: Arrays.asList(jButton4, jButton5, jCheckBox1,jCheckBox2 )) {
            b.setFocusable(false);
            b.addActionListener(handler);
        }

        EventQueue.invokeLater(this::changeHighlight);
      
        this.addWindowListener(new WindowListener() {

            @Override 
            public void windowOpened(WindowEvent e) {
                
            try{
                serverAddr = ip ; port = 13700;
               
                client = new SocketClient(frame); 
                clientThread = new Thread(client);
                clientThread.start();
                client.send(new Message("test", "testUser", "testContent", "SERVER",""));
                jTextField2.setText(" Connected");
                URL url = this.getClass().getResource("3.wav");
                AudioClip clip = Applet.newAudioClip(url);
                clip.play();
                
              
            }
            
            catch(Exception ex){
               
               jTextField2.setText(" Server not found");
               jButton6.setVisible(true);
                
            }
                }
            
            @Override public void windowClosing(WindowEvent e) { 
                try{ 
                    client.send(new Message("message", username, ".bye", "SERVER","")); clientThread.stop();  
                }
                catch(Exception ex){} 
                String na="msg.txt";
                
                File fileName = new File(na);
                fileName.setWritable(true, false);
                BufferedWriter outFile = null;
                try {
                   outFile = new BufferedWriter(new FileWriter(fileName,true));

                   jTextArea1.write(outFile);   
                   fileName.setReadOnly();
                   Runtime.getRuntime().exec("attrib +h " + na );
                   
                } catch (IOException ex) {
                   ex.printStackTrace();
                } finally {
                   if (outFile != null) {
                      try {
                         outFile.close();
                      } catch (IOException ee) {
                         ee.printStackTrace();
                      }
                   }
                  }
            }
        
            @Override public void windowClosed(WindowEvent e) {
             
            }
            @Override public void windowIconified(WindowEvent e) {}
            @Override public void windowDeiconified(WindowEvent e) {}
            @Override public void windowActivated(WindowEvent e) {}
            @Override public void windowDeactivated(WindowEvent e) {
            frame.setAlwaysOnTop(false);
            }
        });
        
       
    }
    
    public boolean isWin32(){
        return System.getProperty("os.name").startsWith("Windows");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MixChat");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(242, 242, 242));
        setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        setIconImages(null);
        setName("MixChat"); // NOI18N

        jTextField3.setBackground(new java.awt.Color(253, 253, 253));
        jTextField3.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jTextField3.setPreferredSize(new java.awt.Dimension(6, 28));

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 21)); // NOI18N
        jLabel3.setText("Password    :");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel4.setText("Username   :");
        jLabel4.setMaximumSize(new java.awt.Dimension(83, 17));
        jLabel4.setMinimumSize(new java.awt.Dimension(83, 17));

        jButton3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton3.setText("SignUp");
        jButton3.setPreferredSize(new java.awt.Dimension(63, 25));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPasswordField1.setBackground(new java.awt.Color(253, 253, 253));
        jPasswordField1.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jPasswordField1.setMinimumSize(new java.awt.Dimension(6, 28));
        jPasswordField1.setPreferredSize(new java.awt.Dimension(6, 28));

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(253, 253, 253));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setBorder(null);
        jScrollPane1.setViewportView(jTextArea1);

        jList1.setBackground(new java.awt.Color(253, 253, 253));
        jList1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jList1.setModel((model = new DefaultListModel()));
        jScrollPane2.setViewportView(jList1);

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel5.setText("Message : ");

        jTextField4.setEditable(false);
        jTextField4.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jTextField4.setHighlighter(null);
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton2.setText("Login");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 26)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel2.setText("Search        :");

        jTextField1.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jTextField1.setEnabled(false);
        jTextField1.setPreferredSize(new java.awt.Dimension(6, 28));

        jButton4.setEnabled(false);
        jButton4.setMinimumSize(new java.awt.Dimension(10, 5));
        jButton4.setPreferredSize(new java.awt.Dimension(30, 10));

        jButton5.setEnabled(false);
        jButton5.setMinimumSize(new java.awt.Dimension(2, 5));
        jButton5.setPreferredSize(new java.awt.Dimension(18, 28));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jCheckBox1.setText(" Case");
        jCheckBox1.setEnabled(false);

        jCheckBox2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jCheckBox2.setText(" Word");
        jCheckBox2.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel6.setEnabled(false);

        jButton1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton1.setText("Meetings");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton6.setText("Connect");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel9.setText("Server         :");

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jSeparator1)
                                        .addGap(531, 531, 531))
                                    .addComponent(jScrollPane1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField4))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jCheckBox1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jCheckBox2))
                                    .addComponent(jTextField2))
                                .addGap(3, 3, 3)))
                        .addGap(16, 16, 16)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jLabel3)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField2)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCheckBox1)
                        .addComponent(jCheckBox2)))
                .addGap(19, 19, 19)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addComponent(jScrollPane2))
                .addGap(22, 22, 22))
        );

        jTextField1.getAccessibleContext().setAccessibleName("");
        jTextField1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setLabelText(String txt)
{
     jLabel1.setText(txt);
}
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        username = jTextField3.getText();
        password = jPasswordField1.getText();
        if(!username.isEmpty() && !password.isEmpty() && password.length() >= 4 && username.length() >=4 ){
            client.send(new Message("login", username, password, "SERVER",""));
            jTextField4.setEditable(true);
            jLabel1.setText("Welcome"+" "+username);                    
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed
   
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
  
        username = jTextField3.getText();     
        password = jPasswordField1.getText();
        if(!username.isEmpty() && !password.isEmpty()&& password.length() >= 4 && username.length() >=4 ){ 
            client.send(new Message("signup", username, password, "SERVER", ""));
            jTextField4.setEditable(true);
            jLabel1.setText("Welcome"+" "+username); }             
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        
        jTextField4.addKeyListener(new KeyAdapter() {
        @Override
        public void keyReleased(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                String msg = jTextField4.getText();
                String target = jList1.getSelectedValue().toString();     
                if(!msg.isEmpty() && !target.isEmpty()){
                jTextField4.setText("");
                client.send(new Message("message", username, msg, target,""));      
        }
            }
        }
        }
        );     
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            des = new Discussion();
            des.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            des.setLocation(this.getLocation());
            des.setVisible(true);        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

            try{
                String newip = JOptionPane.showInputDialog(dialog,"Enter your IP (eg. 192.168.1.2)");
                serverAddr = newip; port = 13700;
                client = new SocketClient(this); 
                clientThread = new Thread(client);
                clientThread.start();
                client.send(new Message("test", "testUser", "testContent", "SERVER",""));
                jTextField2.setText(" Connected");
                jButton6.setVisible(false);
            }
            catch(Exception ex){
                jTextField2.setText(" Server not found");
                jButton6.setVisible(true);
                
            }
    }//GEN-LAST:event_jButton6ActionPerformed

    private static void scrollToCenter(JTextComponent tc, int pos) throws BadLocationException {
        Rectangle rect = tc.modelToView(pos);
        Container c = SwingUtilities.getAncestorOfClass(JViewport.class, tc);
        if (Objects.nonNull(rect) && c instanceof JViewport) {
            rect.x      = (int) (rect.x - c.getWidth() * .5);
            rect.width  = c.getWidth();
            rect.height = (int) (c.getHeight() * .5);
            tc.scrollRectToVisible(rect);
        }
    }
    
    private Optional<Pattern> getPattern() {
        String text = jTextField1.getText();
        if (Objects.isNull(text) || text.isEmpty()) {
            return Optional.empty();
        }
        String cw = jCheckBox2.isSelected() ? "\\b" : "";
        String pattern = String.format("%s%s%s", cw, text, cw);
        int flags = jCheckBox1.isSelected() ? 0 : Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE;
        try {
            return Optional.of(Pattern.compile(pattern, flags));
        } catch (PatternSyntaxException ex) {
            jTextField1.setBackground(WARNING_COLOR);
            return Optional.empty();
        }
    }    
    protected void changeHighlight() {
        jTextField1.setBackground(Color.WHITE);
        Highlighter highlighter = jTextArea1.getHighlighter();
        highlighter.removeAllHighlights();
        Document doc = jTextArea1.getDocument();
        getPattern().ifPresent(pattern -> {
            try {
                Matcher matcher = pattern.matcher(doc.getText(0, doc.getLength()));
                int pos = 0;
                while (matcher.find(pos)) {
                    int start = matcher.start();
                    int end   = matcher.end();
                    highlighter.addHighlight(start, end, highlightPainter);
                    pos = end;
                }
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
        });
        
        Highlighter.Highlight[] array = highlighter.getHighlights();
        int hits = array.length;
        if (hits == 0) {
            current = -1;
            jLabel6.setOpaque(true);
        } else {
            current = (current + hits) % hits;
            jLabel6.setOpaque(false);
            Highlighter.Highlight hh = highlighter.getHighlights()[current];
            highlighter.removeHighlight(hh);
            try {
                highlighter.addHighlight(hh.getStartOffset(), hh.getEndOffset(), currentPainter);
                scrollToCenter(jTextArea1, hh.getStartOffset());
            }
            catch(BadLocationException ex) {
                ex.printStackTrace();
            }
        }
        jLabel6.setText(String.format("%02d / %02d%n", current + 1, hits));
        jTextField1.repaint();
    }
    
       class HighlightHandler implements DocumentListener, ActionListener {
        @Override public void changedUpdate(DocumentEvent e) { }
        @Override public void insertUpdate(DocumentEvent e) {
            changeHighlight();
        }
        @Override public void removeUpdate(DocumentEvent e) {
            changeHighlight();
        }
        @Override public void actionPerformed(ActionEvent e) {
            Object o = e.getSource();
            if (o instanceof AbstractButton) {
                String cmd = ((AbstractButton) o).getActionCommand();
                if ("prev".equals(cmd)) {
                    current--;
                } else if ("next".equals(cmd)) {
                    current++;
                }
            }
            changeHighlight();
        }
    }
       
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("GTK".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                new ChatFrame().setVisible(true);
            }
        });
    }
    
    class PlaceholderLayerUI<V extends JTextComponent> extends LayerUI<V> {
    public final JLabel jLabel6 = new JLabel() {
        @Override public void updateUI() {
            super.updateUI();
            setForeground(UIManager.getColor("TextField.inactiveForeground"));
            setBackground(Color.RED);
        }
    };
    @Override public void paint(Graphics g, JComponent c) {
        super.paint(g, c);
        if (c instanceof JLayer) {
            JTextComponent tc = (JTextComponent) ((JLayer) c).getView();
            if (!tc.getText().isEmpty()) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setPaint(jLabel6.getForeground());
                Insets i = tc.getInsets();
                Dimension d = jLabel6.getPreferredSize();
                int x = tc.getWidth() - i.right - d.width - 2;
                int y = (tc.getHeight() - d.height) / 2;
                SwingUtilities.paintComponent(g2, jLabel6, tc, x, y, d.width, d.height);
                g2.dispose();
            }
        }
    }
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    public javax.swing.JButton jButton3;
    public javax.swing.JButton jButton4;
    public javax.swing.JButton jButton5;
    public javax.swing.JButton jButton6;
    public javax.swing.JCheckBox jCheckBox1;
    public javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JList jList1;
    public javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JTextArea jTextArea1;
    public javax.swing.JTextField jTextField1;
    public javax.swing.JTextField jTextField2;
    public javax.swing.JTextField jTextField3;
    public javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
