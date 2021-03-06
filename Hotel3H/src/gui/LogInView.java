package gui;

import java.awt.event.KeyEvent;
import java.util.Arrays;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * @author Soley
 * 
 * Window with a username and password field to allow login
 */
public class LogInView extends javax.swing.JDialog {
    String user[],username[];
    char[][] password;
    int n;
    int wtev;
    String selected;
    /**
     * Creates new form LogInView
     * @param parent
     * @param modal
     */
    public LogInView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //existing usersnames
        user = new String[]{"notandi","soley","omar","snaevar","helgi"};
        //existing users
        username = new String[]{"Notandi","Sóley","Ómar","Snævar","Helgi"};
        //existing passwords
        char[] p0 = {'l','y','k','i','l','o','r','d'};
        char[] p1 = {'s','b','2','2'};
        char[] p2 = {'o','p','a','0','4'};
        char[] p3 = {'s','t','h','g','2','6'};
        char[] p4 = {'h','f','h','2','4'};
        password = new char[][]{p0,p1,p2,p3,p4};
        n = user.length;
    }
    
    //checking if username and password match
    private void logInCheck(){
        String u = jUserName.getText();
        char[] p = jPassword.getPassword();
        for(int i=0;i<n;i++){
            if(u.equals(user[i]) && Arrays.equals(p, password[i])){
                System.out.print("Login successful");
                selected = username[i];
                i=n;
                wtev = 1;
                this.dispose();
            }
            else{
                if(i==n-1){ //if the last string does not work show error message
                    String[] tmp = {"Try Again", "Quit"};
                    int j = JOptionPane.showOptionDialog(null, "Your username or password is incorrect.", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, tmp, tmp);
                    if(j==1){
                        this.dispose();
                    }
                }
            }
        }        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPassword = new javax.swing.JPasswordField();
        jUserName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLogIn = new javax.swing.JButton();
        jSignUp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("User Name:");

        jPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPasswordKeyTyped(evt);
            }
        });

        jLabel2.setText("Password:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Please log in to continue");

        jLogIn.setText("Log in");
        jLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLogInActionPerformed(evt);
            }
        });

        jSignUp.setText("Sign Up");
        jSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSignUpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLogIn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSignUp))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(jUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLogIn)
                    .addComponent(jSignUp))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLogInActionPerformed
        // TODO add your handling code here:
        logInCheck();
    }//GEN-LAST:event_jLogInActionPerformed

    private void jSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSignUpActionPerformed
        // TODO add your handling code here:
        String[] tmp = {"OK"};
        int i = JOptionPane.showOptionDialog(null, new JLabel("Sorry, you cannot sign up.", null, JLabel.LEFT), "Error request", JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE, null, tmp, tmp);
    }//GEN-LAST:event_jSignUpActionPerformed

    private void jPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordKeyTyped

    }//GEN-LAST:event_jPasswordKeyTyped

    //enables the user to sign in using the enter key instead of pressing the login button
    private void jPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            logInCheck();
        }
    }//GEN-LAST:event_jPasswordKeyPressed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LogInView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogInView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogInView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogInView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LogInView dialog = new LogInView(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jLogIn;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JButton jSignUp;
    private javax.swing.JTextField jUserName;
    // End of variables declaration//GEN-END:variables
}
