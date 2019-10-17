package tcpserver;

import java.awt.*; 
import java.awt.event.*; 
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*; 


/**
 *
 * @author Stefano Valloncini
 */

public class tcpsever extends javax.swing.JFrame 
{   
    static ServerSocket ss; 
    static Socket s; 
    static DataInputStream din; 
    static DataOutputStream dout; 
    
    public tcpsever() 
    {
        this.setTitle("TCP client is running");
        this.setResizable(false);
        
        
        initComponents();
        this.centreWindow(this);
        
        sendMessageField.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                sendMessageField.setEditable(true);
                sendMessageField.setText("");
            }
        });
        
    }

    public void centreWindow(Window frame)
    {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea("                                                           " + "Messages" + "\n");
        sendMessageField = new javax.swing.JTextField();
        sendMessageButton = new javax.swing.JButton();
        serverTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        sendMessageField.setEditable(false);
        sendMessageField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sendMessageField.setText("Scrivi un messaggio");

        sendMessageButton.setText("");
        sendMessageButton.setIcon(new ImageIcon(new ImageIcon("send.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
        sendMessageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendMessageButtonActionPerformed(evt);
            }
        });

        serverTitle.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        serverTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        serverTitle.setText("TCP Server");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(serverTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(0, 10, Short.MAX_VALUE)
                        .addComponent(sendMessageField, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sendMessageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(serverTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sendMessageField, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendMessageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendMessageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendMessageButtonActionPerformed
        String messageout = ""; 
        
        if(sendMessageField.getText().trim().length() > 0 || !sendMessageField.getText().equalsIgnoreCase("Scrivi un messaggio"))
        {
            try
            {   
                DateFormat df = new SimpleDateFormat("HH:mm");
                Date dateobj = new Date();
                
                messageout = sendMessageField.getText().trim(); 
                System.out.println(messageout);
                dout.writeUTF(messageout);
                jTextArea1.setText(dateobj + " YOU: " + messageout + "\n");
            }
            catch(Exception e)
            {
                // TO DO: HANDLE EXCEPTION
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Inserire un messaggio valido!", "Attenzione", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_sendMessageButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException 
    {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(tcpsever.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tcpsever.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tcpsever.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tcpsever.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tcpsever().setVisible(true);
            }
        });
        
        String msgin = ""; 
        try
        {
            ss = new ServerSocket(1201); // il sever inizia ad ascoltare sulla porta 1201
            s = ss.accept(); // il server accetta la connessione
            din = new DataInputStream(s.getInputStream()); 
            dout = new DataOutputStream(s.getOutputStream());
            
            while(!msgin.equals("exit"))
            {
                msgin = din.readUTF(); 
                
                DateFormat df = new SimpleDateFormat("HH:mm:ss");
                Date dateobj = new Date();
                
                jTextArea1.append("\n" + dateobj + " client: " + msgin);
            }
            
        }
        catch(Exception e)
        {
            // TO DO handle exception
        }
        

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    static javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton sendMessageButton;
    private javax.swing.JTextField sendMessageField;
    private javax.swing.JLabel serverTitle;
    // End of variables declaration//GEN-END:variables
}
