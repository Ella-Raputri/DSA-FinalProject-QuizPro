/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

/**
 *
 * @author asus
 */
public class SignUpPage extends javax.swing.JFrame {

    /**
     * Creates new form SignUpPage
     */
    public SignUpPage() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backButton = new App.buttonCustom();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        confirmPassword = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        studentRole = new javax.swing.JRadioButton();
        teacherRole = new javax.swing.JRadioButton();
        submitButton = new App.buttonCustom();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backButton.setForeground(new java.awt.Color(57, 129, 247));
        backButton.setText("< Back");
        backButton.setBorderColor(new java.awt.Color(102, 102, 102));
        backButton.setColorClick(new java.awt.Color(235, 235, 235));
        backButton.setColorOver(new java.awt.Color(235, 235, 235));
        backButton.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        backButton.setRadius(50);
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 650, 130, 50));

        jLabel1.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel1.setText("Username");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, -1, -1));

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel2.setText("Email");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, -1, -1));

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel3.setText("Password");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 310, -1, -1));

        jLabel4.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel4.setText("Confirm Password");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 400, -1, -1));

        username.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        username.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 8, 1, 1));
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        getContentPane().add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, 610, 40));

        email.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        email.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 8, 1, 1));
        getContentPane().add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, 610, 40));

        password.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        password.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 8, 1, 1));
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 350, 610, 40));

        confirmPassword.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        confirmPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 8, 1, 1));
        getContentPane().add(confirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 440, 610, 40));

        jLabel5.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel5.setText("Role");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 500, -1, -1));

        studentRole.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        studentRole.setText("Student");
        getContentPane().add(studentRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 540, -1, -1));

        teacherRole.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        teacherRole.setText("Teacher");
        getContentPane().add(teacherRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 540, -1, -1));

        submitButton.setForeground(new java.awt.Color(255, 255, 255));
        submitButton.setText("Submit");
        submitButton.setBorderColor(new java.awt.Color(0, 0, 0));
        submitButton.setColor(new java.awt.Color(0, 0, 0));
        submitButton.setColorClick(new java.awt.Color(72, 72, 72));
        submitButton.setColorOver(new java.awt.Color(72, 72, 72));
        submitButton.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        submitButton.setRadius(50);
        getContentPane().add(submitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 560, 130, 50));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/background_signup.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

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
            java.util.logging.Logger.getLogger(SignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUpPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private App.buttonCustom backButton;
    private javax.swing.JLabel bg;
    private javax.swing.JTextField confirmPassword;
    private javax.swing.JTextField email;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField password;
    private javax.swing.JRadioButton studentRole;
    private App.buttonCustom submitButton;
    private javax.swing.JRadioButton teacherRole;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
