/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import javax.swing.JOptionPane;
import DatabaseConnection.ConnectionProvider;
import java.awt.Color;
import java.sql.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author asus
 */
public class LoginPage extends javax.swing.JFrame {

    /**
     * Creates new form loginPage
     */
    public LoginPage() {
        initComponents();
        myinit();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backButton = new App.ButtonCustom();
        jLabel2 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        showPassword = new App.ButtonCustom();
        hidePassword = new App.ButtonCustom();
        password = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        studentRole = new javax.swing.JRadioButton();
        teacherRole = new javax.swing.JRadioButton();
        submitButton = new App.ButtonCustom();
        jLabel6 = new javax.swing.JLabel();
        signupButton = new App.ButtonCustom();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backButton.setBackground(new java.awt.Color(255, 255, 255));
        backButton.setForeground(new java.awt.Color(57, 129, 247));
        backButton.setText("< Back");
        backButton.setBorderColor(new java.awt.Color(255, 255, 255));
        backButton.setBorderColorNotOver(java.awt.Color.white);
        backButton.setBorderColorOver(new java.awt.Color(235, 235, 235));
        backButton.setColor(java.awt.Color.white);
        backButton.setColor2(new java.awt.Color(57, 129, 247));
        backButton.setColorClick(new java.awt.Color(235, 235, 235));
        backButton.setColorClick2(new java.awt.Color(54, 96, 160));
        backButton.setColorOver(new java.awt.Color(235, 235, 235));
        backButton.setColorOver2(new java.awt.Color(54, 96, 160));
        backButton.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        backButton.setRadius(50);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 650, 130, 50));

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel2.setText("Username");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, -1, -1));

        username.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        username.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 14, 1, 1));
        username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                usernameFocusLost(evt);
            }
        });
        getContentPane().add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, 610, 40));

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel3.setText("Password");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, -1, -1));

        showPassword.setForeground(new java.awt.Color(46, 92, 175));
        showPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/show_password.png"))); // NOI18N
        showPassword.setToolTipText("");
        showPassword.setBorderColor(new java.awt.Color(255, 255, 255));
        showPassword.setBorderColorNotOver(java.awt.Color.white);
        showPassword.setBorderColorOver(java.awt.Color.white);
        showPassword.setColor(java.awt.Color.white);
        showPassword.setColor2(java.awt.Color.white);
        showPassword.setColorClick(new java.awt.Color(255, 255, 255));
        showPassword.setColorClick2(java.awt.Color.white);
        showPassword.setColorOver(new java.awt.Color(255, 255, 255));
        showPassword.setColorOver2(java.awt.Color.white);
        showPassword.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        showPassword.setMargin(new java.awt.Insets(0, 0, 0, 0));
        showPassword.setRadius(30);
        showPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(showPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 380, 30, 20));

        hidePassword.setForeground(new java.awt.Color(46, 92, 175));
        hidePassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/hide_password.png"))); // NOI18N
        hidePassword.setToolTipText("");
        hidePassword.setBorderColor(new java.awt.Color(255, 255, 255));
        hidePassword.setBorderColorNotOver(java.awt.Color.white);
        hidePassword.setBorderColorOver(java.awt.Color.white);
        hidePassword.setColor(java.awt.Color.white);
        hidePassword.setColor2(java.awt.Color.white);
        hidePassword.setColorClick(new java.awt.Color(255, 255, 255));
        hidePassword.setColorClick2(java.awt.Color.white);
        hidePassword.setColorOver(new java.awt.Color(255, 255, 255));
        hidePassword.setColorOver2(java.awt.Color.white);
        hidePassword.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        hidePassword.setMargin(new java.awt.Insets(0, 0, 0, 0));
        hidePassword.setRadius(30);
        hidePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hidePasswordActionPerformed(evt);
            }
        });
        getContentPane().add(hidePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 380, 30, 20));

        password.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        password.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 14, 1, 1));
        password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordFocusLost(evt);
            }
        });
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 370, 610, 40));

        jLabel5.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel5.setText("Role");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 440, -1, -1));

        studentRole.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        studentRole.setText("Student");
        studentRole.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                studentRoleFocusLost(evt);
            }
        });
        studentRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentRoleActionPerformed(evt);
            }
        });
        getContentPane().add(studentRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 480, -1, -1));

        teacherRole.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        teacherRole.setText("Teacher");
        teacherRole.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                teacherRoleFocusLost(evt);
            }
        });
        teacherRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacherRoleActionPerformed(evt);
            }
        });
        getContentPane().add(teacherRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 480, -1, -1));

        submitButton.setForeground(new java.awt.Color(255, 255, 255));
        submitButton.setText("Submit");
        submitButton.setBorderColor(new java.awt.Color(0, 0, 0));
        submitButton.setBorderColorNotOver(java.awt.Color.black);
        submitButton.setBorderColorOver(new java.awt.Color(72, 72, 72));
        submitButton.setColor(new java.awt.Color(0, 0, 0));
        submitButton.setColor2(java.awt.Color.white);
        submitButton.setColorClick(new java.awt.Color(72, 72, 72));
        submitButton.setColorClick2(java.awt.Color.white);
        submitButton.setColorOver(new java.awt.Color(72, 72, 72));
        submitButton.setColorOver2(java.awt.Color.white);
        submitButton.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        submitButton.setRadius(50);
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(submitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 490, 130, 50));

        jLabel6.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Don’t have an account?");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 580, -1, -1));

        signupButton.setBackground(new java.awt.Color(237, 242, 248));
        signupButton.setForeground(new java.awt.Color(46, 92, 175));
        signupButton.setText("Sign Up");
        signupButton.setBorderColor(new java.awt.Color(237, 242, 248));
        signupButton.setBorderColorNotOver(new java.awt.Color(237, 242, 248));
        signupButton.setBorderColorOver(java.awt.Color.white);
        signupButton.setColor(new java.awt.Color(237, 242, 248));
        signupButton.setColor2(new java.awt.Color(46, 92, 175));
        signupButton.setColorClick(new java.awt.Color(255, 255, 255));
        signupButton.setColorClick2(new java.awt.Color(100, 140, 211));
        signupButton.setColorOver(new java.awt.Color(255, 255, 255));
        signupButton.setColorOver2(new java.awt.Color(100, 140, 211));
        signupButton.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        signupButton.setRadius(30);
        signupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupButtonActionPerformed(evt);
            }
        });
        getContentPane().add(signupButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 580, -1, -1));

        jLabel8.setBackground(new java.awt.Color(227, 237, 254));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/warning_icon.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 380, -1, -1));

        jLabel9.setBackground(new java.awt.Color(227, 237, 254));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/warning_icon.png"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 270, -1, -1));

        jLabel7.setBackground(new java.awt.Color(227, 237, 254));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/warning_icon2.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 440, -1, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/background_login.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void myinit(){
        setTitle("Login Page");
        setResizable(false);
        hidePassword.setVisible(false);
        password.setEchoChar('*');
        jLabel7.setVisible(false);
        jLabel8.setVisible(false);
        jLabel9.setVisible(false);
        
        username.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateSelfStatusUsername();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateSelfStatusUsername();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateSelfStatusUsername();
            }
        });
        
        password.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateSelfStatusPassword();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateSelfStatusPassword();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateSelfStatusPassword();
            }
        });
    }
    
    private void updateSelfStatusUsername(){
        String text = username.getText();
        if(text.equals("")){
            jLabel9.setVisible(true);
            username.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(Color.red), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));
            username.setForeground(Color.red);
        }
        else{
            jLabel9.setVisible(false);
            username.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 14, 1, 1));
            username.setForeground(Color.black);
        }
    }
    
    private void updateSelfStatusPassword(){
        String text = password.getText();
        if(text.equals("")){
            jLabel8.setVisible(true);
            password.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(Color.red), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));
            password.setForeground(Color.red);
        }
        else{
            jLabel8.setVisible(false);
            password.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 14, 1, 1));
            password.setForeground(Color.black);
        }
    }
    
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        setVisible(false);
        new WelcomePage().setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void showPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPasswordActionPerformed
        showPassword.setVisible(false);
        hidePassword.setVisible(true);
        password.setEchoChar((char)0);
    }//GEN-LAST:event_showPasswordActionPerformed

    private void hidePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hidePasswordActionPerformed
        showPassword.setVisible(true);
        hidePassword.setVisible(false);
        password.setEchoChar('*');
    }//GEN-LAST:event_hidePasswordActionPerformed

    private void studentRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentRoleActionPerformed
        if(studentRole.isSelected()){
            teacherRole.setSelected(false);
        }
    }//GEN-LAST:event_studentRoleActionPerformed

    private void teacherRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacherRoleActionPerformed
        if(teacherRole.isSelected()){
            studentRole.setSelected(false);
        }
    }//GEN-LAST:event_teacherRoleActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        String usernameStr = username.getText();
        String passwordStr = password.getText();
        String role = "";

        if(studentRole.isSelected()){
            role="Student";
        }
        else if(teacherRole.isSelected()){
            role="Teacher";
        }

        if(usernameStr.equals("")){
            JOptionPane.showMessageDialog(getContentPane(), "Username is still empty.");
        }
        else if(passwordStr.equals("")){
            JOptionPane.showMessageDialog(getContentPane(), "Password is still empty.");
        }
        else if(role.equals("")){
            JOptionPane.showMessageDialog(getContentPane(), "Please select a role.");
        }
        else{
            if(role.equals("Student")){
                String passwordConfirmation ="";
                String idStr = "";
                try{
                    Connection con = ConnectionProvider.getCon();
                    Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    ResultSet rs = st.executeQuery("select * from student where username='"+usernameStr+"'");
                    if(rs.first()){
                        idStr = rs.getString(1);
                        passwordConfirmation = rs.getString(4);
                        
                        if(passwordConfirmation.equals(passwordStr)){
                            setVisible(false);
                            new StudentHome(idStr).setVisible(true);
                        }
                        else{
                            JOptionPane.showMessageDialog(getContentPane(), "Incorrect Password");
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(getContentPane(), "Invalid Username");
                    }
                    
                    
   
                }catch(Exception e){
                    JOptionPane.showMessageDialog(getContentPane(), e);
                }
            }

            if(role.equals("Teacher")){
                String passwordConfirmation ="";
                try{
                    Connection con = ConnectionProvider.getCon();
                    Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    ResultSet rs = st.executeQuery("select * from admin where username='"+usernameStr+"'");
                    if(rs.first()){
                        passwordConfirmation = rs.getString(4);
                        if(passwordConfirmation.equals(passwordStr)){
                            setVisible(false);
                            new AdminHome().setVisible(true);
                        }
                        else{
                            JOptionPane.showMessageDialog(getContentPane(), "Incorrect Password");
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(getContentPane(), "Invalid Username");
                    }
   
                }catch(Exception e){
                    JOptionPane.showMessageDialog(getContentPane(), e);
                }
            }

        }

    }//GEN-LAST:event_submitButtonActionPerformed

    private void signupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupButtonActionPerformed
        setVisible(false);
        new SignUpPage().setVisible(true);
    }//GEN-LAST:event_signupButtonActionPerformed

    private void usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameFocusLost
        String text = username.getText();
        if(text.equals("")){
            jLabel9.setVisible(true);
            username.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(Color.red), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));
            username.setForeground(Color.red);
        }
        else{
            jLabel9.setVisible(false);
            username.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 14, 1, 1));
            username.setForeground(Color.black);
        }
    }//GEN-LAST:event_usernameFocusLost

    private void passwordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFocusLost
        String text = password.getText();
        if(text.equals("")){
            jLabel8.setVisible(true);
            password.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(Color.red), javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1)));
            password.setForeground(Color.red);
        }
        else{
            jLabel8.setVisible(false);
            password.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 14, 1, 1));
            password.setForeground(Color.black);
        }
    }//GEN-LAST:event_passwordFocusLost

    private void studentRoleFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_studentRoleFocusLost
        if(!(studentRole.isSelected()) && !(teacherRole.isSelected())){
            jLabel7.setVisible(true);
            jLabel5.setForeground(Color.red);
        }
        else{
            jLabel7.setVisible(false);
            jLabel5.setForeground(Color.black);
        }
    }//GEN-LAST:event_studentRoleFocusLost

    private void teacherRoleFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_teacherRoleFocusLost
        if(!(studentRole.isSelected()) && !(teacherRole.isSelected())){
            jLabel7.setVisible(true);
            jLabel5.setForeground(Color.red);
        }
        else{
            jLabel7.setVisible(false);
            jLabel5.setForeground(Color.black);
        }
    }//GEN-LAST:event_teacherRoleFocusLost

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
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private App.ButtonCustom backButton;
    private App.ButtonCustom hidePassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField password;
    private App.ButtonCustom showPassword;
    private App.ButtonCustom signupButton;
    private javax.swing.JRadioButton studentRole;
    private App.ButtonCustom submitButton;
    private javax.swing.JRadioButton teacherRole;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}