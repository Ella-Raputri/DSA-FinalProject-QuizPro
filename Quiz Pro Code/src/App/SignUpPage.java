/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;
import java.sql.*;
import DatabaseConnection.ConnectionProvider;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

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
        hidePassword.setVisible(false);
        hidePassword1.setVisible(false);
        password.setEchoChar('*');
        passwordConfirm.setEchoChar('*');
        
    }
    
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.matches();
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
        jLabel5 = new javax.swing.JLabel();
        studentRole = new javax.swing.JRadioButton();
        teacherRole = new javax.swing.JRadioButton();
        submitButton = new App.buttonCustom();
        jLabel6 = new javax.swing.JLabel();
        showPassword = new App.buttonCustom();
        loginButton2 = new App.buttonCustom();
        hidePassword = new App.buttonCustom();
        showPassword1 = new App.buttonCustom();
        hidePassword1 = new App.buttonCustom();
        passwordConfirm = new javax.swing.JPasswordField();
        password = new javax.swing.JPasswordField();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backButton.setForeground(new java.awt.Color(57, 129, 247));
        backButton.setText("< Back");
        backButton.setBorderColor(new java.awt.Color(255, 255, 255));
        backButton.setBorderColorNotOver(new java.awt.Color(255, 255, 255));
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
        username.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 14, 1, 1));
        getContentPane().add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, 610, 40));

        email.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        email.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 14, 1, 1));
        getContentPane().add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, 610, 40));

        jLabel5.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel5.setText("Role");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 500, -1, -1));

        studentRole.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        studentRole.setText("Student");
        studentRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentRoleActionPerformed(evt);
            }
        });
        getContentPane().add(studentRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 540, -1, -1));

        teacherRole.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        teacherRole.setText("Teacher");
        teacherRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacherRoleActionPerformed(evt);
            }
        });
        getContentPane().add(teacherRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 540, -1, -1));

        submitButton.setForeground(new java.awt.Color(255, 255, 255));
        submitButton.setText("Submit");
        submitButton.setBorderColor(new java.awt.Color(0, 0, 0));
        submitButton.setBorderColorNotOver(java.awt.Color.black);
        submitButton.setBorderColorOver(new java.awt.Color(72, 72, 72));
        submitButton.setColor(new java.awt.Color(0, 0, 0));
        submitButton.setColor2(java.awt.Color.white);
        submitButton.setColorClick(new java.awt.Color(72, 72, 72));
        submitButton.setColorClick2(new java.awt.Color(255, 255, 255));
        submitButton.setColorOver(new java.awt.Color(72, 72, 72));
        submitButton.setColorOver2(java.awt.Color.white);
        submitButton.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        submitButton.setRadius(50);
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(submitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 560, 130, 50));

        jLabel6.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Already have an account?");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 640, -1, -1));

        showPassword.setBackground(new java.awt.Color(255, 255, 255));
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
        getContentPane().add(showPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 360, 30, 20));

        loginButton2.setBackground(new java.awt.Color(237, 242, 248));
        loginButton2.setForeground(new java.awt.Color(46, 92, 175));
        loginButton2.setText("Login");
        loginButton2.setBorderColor(new java.awt.Color(237, 242, 248));
        loginButton2.setBorderColorNotOver(new java.awt.Color(237, 242, 248));
        loginButton2.setBorderColorOver(java.awt.Color.white);
        loginButton2.setColor(new java.awt.Color(237, 242, 248));
        loginButton2.setColor2(new java.awt.Color(46, 92, 175));
        loginButton2.setColorClick(new java.awt.Color(255, 255, 255));
        loginButton2.setColorClick2(new java.awt.Color(100, 140, 211));
        loginButton2.setColorOver(new java.awt.Color(255, 255, 255));
        loginButton2.setColorOver2(new java.awt.Color(100, 140, 211));
        loginButton2.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        loginButton2.setRadius(30);
        loginButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(loginButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 640, -1, -1));

        hidePassword.setBackground(new java.awt.Color(255, 255, 255));
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
        getContentPane().add(hidePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 360, 30, 20));

        showPassword1.setBackground(new java.awt.Color(255, 255, 255));
        showPassword1.setForeground(new java.awt.Color(46, 92, 175));
        showPassword1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/show_password.png"))); // NOI18N
        showPassword1.setToolTipText("");
        showPassword1.setBorderColor(new java.awt.Color(255, 255, 255));
        showPassword1.setBorderColorNotOver(java.awt.Color.white);
        showPassword1.setBorderColorOver(java.awt.Color.white);
        showPassword1.setColor(java.awt.Color.white);
        showPassword1.setColor2(java.awt.Color.white);
        showPassword1.setColorClick(new java.awt.Color(255, 255, 255));
        showPassword1.setColorClick2(java.awt.Color.white);
        showPassword1.setColorOver(new java.awt.Color(255, 255, 255));
        showPassword1.setColorOver2(java.awt.Color.white);
        showPassword1.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        showPassword1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        showPassword1.setRadius(30);
        showPassword1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPassword1ActionPerformed(evt);
            }
        });
        getContentPane().add(showPassword1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 450, 30, 20));

        hidePassword1.setBackground(new java.awt.Color(255, 255, 255));
        hidePassword1.setForeground(new java.awt.Color(46, 92, 175));
        hidePassword1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/hide_password.png"))); // NOI18N
        hidePassword1.setToolTipText("");
        hidePassword1.setBorderColor(new java.awt.Color(255, 255, 255));
        hidePassword1.setBorderColorNotOver(java.awt.Color.white);
        hidePassword1.setBorderColorOver(java.awt.Color.white);
        hidePassword1.setColor(java.awt.Color.white);
        hidePassword1.setColor2(java.awt.Color.white);
        hidePassword1.setColorClick(new java.awt.Color(255, 255, 255));
        hidePassword1.setColorClick2(java.awt.Color.white);
        hidePassword1.setColorOver(new java.awt.Color(255, 255, 255));
        hidePassword1.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        hidePassword1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        hidePassword1.setRadius(30);
        hidePassword1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hidePassword1ActionPerformed(evt);
            }
        });
        getContentPane().add(hidePassword1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 450, 30, 20));

        passwordConfirm.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        passwordConfirm.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 14, 1, 1));
        getContentPane().add(passwordConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 440, 610, 40));

        password.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        password.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 14, 1, 1));
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 350, 610, 40));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/background_signup.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, -1, 720));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void showPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPasswordActionPerformed
        showPassword.setVisible(false);
        hidePassword.setVisible(true);
        password.setEchoChar((char)0);
    }//GEN-LAST:event_showPasswordActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        setVisible(false);
        new WelcomePage().setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void loginButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButton2ActionPerformed
        setVisible(false);
        new loginPage().setVisible(true);
    }//GEN-LAST:event_loginButton2ActionPerformed

    private void hidePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hidePasswordActionPerformed
        showPassword.setVisible(true);
        hidePassword.setVisible(false);
        password.setEchoChar('*');
    }//GEN-LAST:event_hidePasswordActionPerformed

    private void showPassword1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPassword1ActionPerformed
        showPassword1.setVisible(false);
        hidePassword1.setVisible(true);
        passwordConfirm.setEchoChar((char)0);
    }//GEN-LAST:event_showPassword1ActionPerformed

    private void hidePassword1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hidePassword1ActionPerformed
        showPassword1.setVisible(true);
        hidePassword1.setVisible(false);
        passwordConfirm.setEchoChar('*');
    }//GEN-LAST:event_hidePassword1ActionPerformed

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
        String emailStr = email.getText();
        String passwordStr = password.getText();
        String passwordConfirmStr = passwordConfirm.getText();
        String role = "";
        
        if(studentRole.isSelected()){
            role="Student";
        }
        else if(teacherRole.isSelected()){
            role="Teacher";
        }
        
        
        if(usernameStr.equals("")){
            JOptionPane.showMessageDialog(null, "Username is still empty.");
        }
        else if(emailStr.equals("")){
            JOptionPane.showMessageDialog(null, "Email is still empty.");
        }
        else if(passwordStr.equals("")){
            JOptionPane.showMessageDialog(null, "Password is still empty.");
        }
        else if(passwordConfirmStr.equals("")){
            JOptionPane.showMessageDialog(null, "Confirm Password is still empty.");
        }
        else if(role.equals("")){
            JOptionPane.showMessageDialog(null, "Please select a role.");
        }
        else{
           if(!(validate(emailStr))){
                JOptionPane.showMessageDialog(null, "Please input a correct email.");
           }
           
           if(!(passwordStr.equals(passwordConfirmStr))){
               JOptionPane.showMessageDialog(null, "Password and Confirm Password is not the same.");
           }
           
           
           if(role.equals("Student") && passwordStr.equals(passwordConfirmStr) && validate(emailStr)){
               try{
                    Connection con = ConnectionProvider.getCon();
                    Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    ResultSet rs = st.executeQuery("select count(id) from student");
                    String idStr ="";
                    if(rs.first()){
                        String id = rs.getString(1);
                        int idInt = Integer.parseInt(id);
                        idInt = idInt+1;
                        idStr = String.valueOf(idInt);
                    }
                    else{
                        idStr = "1";
                    }
                    
                    PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?,?)");
                    ps.setString(1, idStr);
                    ps.setString(2, usernameStr);
                    ps.setString(3, emailStr);
                    ps.setString(4, passwordStr);
                    ps.executeUpdate();
                    setVisible(false);
                    new StudentHome().setVisible(true);
                    
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }
           }
           
           if(role.equals("Teacher") && passwordStr.equals(passwordConfirmStr) && validate(emailStr)){
               try{
                    Connection con = ConnectionProvider.getCon();
                    Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    ResultSet rs = st.executeQuery("select count(id) from admin");
                    String idStr ="";
                    if(rs.first()){
                        String id = rs.getString(1);
                        int idInt = Integer.parseInt(id);
                        idInt = idInt+1;
                        idStr = String.valueOf(idInt);
                    }
                    else{
                        idStr = "1";
                    }
                        
                    
                    PreparedStatement ps = con.prepareStatement("insert into admin values(?,?,?,?)");
                    ps.setString(1, idStr);
                    ps.setString(2, usernameStr);
                    ps.setString(3, emailStr);
                    ps.setString(4, passwordStr);
                    ps.executeUpdate();
                    setVisible(false);
                    new AdminHome().setVisible(true);
                    
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }
           }
           
        }
        
        
        
        
        
        
        
    }//GEN-LAST:event_submitButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //System.out.println(new java.io.File("src/App/img/background_welcome.png").exists());
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
    private javax.swing.JTextField email;
    private App.buttonCustom hidePassword;
    private App.buttonCustom hidePassword1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private App.buttonCustom loginButton2;
    private javax.swing.JPasswordField password;
    private javax.swing.JPasswordField passwordConfirm;
    private App.buttonCustom showPassword;
    private App.buttonCustom showPassword1;
    private javax.swing.JRadioButton studentRole;
    private App.buttonCustom submitButton;
    private javax.swing.JRadioButton teacherRole;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
