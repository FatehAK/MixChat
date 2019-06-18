
package com.ui;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.io.FileOutputStream;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import javax.swing.JOptionPane;
import javax.swing.JDialog;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

public class Discussion extends javax.swing.JFrame {

    public JDialog dialog = new JDialog();
    
    public Discussion() {
        this.setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("1.jpg"))));
        this.getContentPane().setPreferredSize(new Dimension(950,700));   
        dialog.setLocation(this.getLocation());
        dialog.setAlwaysOnTop(true);
        
        Discussion fr=this;
            
        initComponents();
        
        this.addWindowListener(new WindowListener() {

            @Override 
            public void windowOpened(WindowEvent e) {  }
            @Override public void windowClosing(WindowEvent e) {  }
            @Override public void windowClosed(WindowEvent e) {}
            @Override public void windowIconified(WindowEvent e) {}
            @Override public void windowDeiconified(WindowEvent e) {}
            @Override public void windowActivated(WindowEvent e) {}
            @Override public void windowDeactivated(WindowEvent e) {
            fr.setAlwaysOnTop(false);
            dialog.setAlwaysOnTop(false);}
        });               
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 35)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Team Discussion");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 21)); // NOI18N
        jLabel2.setText("Title                           :");

        jTextField1.setFont(new java.awt.Font("Calibri", 0, 21)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 21)); // NOI18N
        jLabel3.setText("Date     :");

        jTextField2.setFont(new java.awt.Font("Calibri", 0, 21)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 21)); // NOI18N
        jLabel4.setText("Location   :");

        jTextField3.setFont(new java.awt.Font("Calibri", 0, 21)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 21)); // NOI18N
        jLabel5.setText("Participants              :");

        jTextField4.setFont(new java.awt.Font("Calibri", 0, 21)); // NOI18N
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 21)); // NOI18N
        jLabel6.setText("Topics Discussed      :");

        jTextField5.setFont(new java.awt.Font("Calibri", 0, 21)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 21)); // NOI18N
        jLabel7.setText("Brief Discussion        :");

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Calibri", 0, 21)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 21)); // NOI18N
        jLabel8.setText("Chaired by  :");

        jTextField6.setFont(new java.awt.Font("Calibri", 0, 21)); // NOI18N
        jTextField6.setPreferredSize(new java.awt.Dimension(6, 20));
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Calibri", 0, 21)); // NOI18N
        jButton1.setText("Export");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 21)); // NOI18N
        jLabel10.setText("Action Event            :");

        jTextField7.setFont(new java.awt.Font("Calibri", 0, 21)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField4)
                            .addComponent(jTextField5)
                            .addComponent(jTextField1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
                            .addComponent(jTextField7)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       try{
           
           String name=JOptionPane.showInputDialog(dialog,"Enter File name") +".docx"; 
           String na="D:/"+name;
           String path= na.replace("/","\\");
           File file = new File(na);
           FileOutputStream outStream=new FileOutputStream(file);
           XWPFDocument doc =new XWPFDocument();
           
           
           XWPFParagraph para1=doc.createParagraph();
           para1.setAlignment(ParagraphAlignment.CENTER);
           XWPFRun pararun1= para1.createRun();
           pararun1.setBold(true);
           pararun1.setFontSize(16);
           pararun1.setText(jLabel1.getText());
           pararun1.addBreak();
           
           XWPFParagraph para2=doc.createParagraph();
           para2.setAlignment(ParagraphAlignment.LEFT);
           XWPFRun pararun2= para2.createRun();
           pararun2.setFontSize(13);
           pararun2.setText("Date          :  ");
           pararun2.setBold(true);
           XWPFRun pararun3= para2.createRun();
           pararun3.setFontSize(13);
           pararun3.setText(jTextField2.getText());
           pararun3.addBreak();
           pararun3.addBreak();
           
           XWPFRun pararun4= para2.createRun();
           pararun4.setText("Location   :  ");
           pararun4.setFontSize(13);
           pararun4.setBold(true);
           XWPFRun pararun5= para2.createRun();
           pararun5.setFontSize(13);
           pararun5.setText(jTextField3.getText());
           pararun5.addBreak();
           
           
           XWPFParagraph para3=doc.createParagraph();
           para3.setAlignment(ParagraphAlignment.LEFT);
           XWPFRun pararun6= para3.createRun();
           pararun6.setFontSize(13);
           pararun6.setText("Chaired By   :  ");
           pararun6.setBold(true);
           XWPFRun pararun7= para3.createRun();
           pararun7.setFontSize(13);
           pararun7.setText(jTextField6.getText());
           pararun7.addBreak();
           pararun7.addBreak();
           pararun7.addBreak();
           
           XWPFRun pararun8= para3.createRun();
           pararun8.setFontSize(13);
           pararun8.setBold(true);
           pararun8.setText("Title   :  ");
           XWPFRun pararun9= para3.createRun();
           pararun9.setFontSize(13);
           pararun9.setText(jTextField1.getText());
           pararun9.addBreak();
           pararun9.addBreak();
           
           XWPFRun pararun10= para3.createRun();
           pararun10.setFontSize(13);
           pararun10.setBold(true);
           pararun10.setText("Participants   :  ");
           XWPFRun pararun11= para3.createRun();
           pararun11.setFontSize(13);
           pararun11.setText(jTextField4.getText());
           pararun11.addBreak();
           pararun11.addBreak();
           
           XWPFRun pararun12= para3.createRun();
           pararun12.setFontSize(13);
           pararun12.setBold(true);
           pararun12.setText("Topics discussed   :  ");
           XWPFRun pararun13= para3.createRun();
           pararun13.setFontSize(13);
           pararun13.setText(jTextField5.getText());
           pararun13.addBreak();
          
           
           XWPFParagraph para4=doc.createParagraph();
           para4.setAlignment(ParagraphAlignment.LEFT);
           XWPFRun pararun14= para4.createRun();
           pararun14.setFontSize(13);
           pararun14.setBold(true);
           pararun14.setText("Brief discussion   :  ");
          
           
           XWPFParagraph para5=doc.createParagraph();
           para5.setAlignment(ParagraphAlignment.LEFT);
           XWPFRun pararun15= para5.createRun();
           pararun15.setFontSize(13);
         
              for (String line : jTextArea1.getText().split("\\n"))
              {
                  pararun15.setText(line);
                  pararun15.addBreak();
              }
                  
           XWPFParagraph para6=doc.createParagraph();
           XWPFRun pararun16= para6.createRun();
           pararun16.setFontSize(13);
           pararun16.setBold(true);
           pararun16.setText("Actions   :  ");
           XWPFRun pararun17= para6.createRun();
           pararun17.setFontSize(13);
           pararun17.setText(jTextField7.getText());
           pararun17.addBreak();
           
    
           doc.write(outStream);
           outStream.close();
           file.setReadOnly();
           Runtime.getRuntime().exec("explorer.exe /select," + path);
       }catch(Exception e){
           e.printStackTrace();
           
       }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public static void main(String args[]) {
        try {

            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("GTK".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Discussion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Discussion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Discussion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Discussion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Discussion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
