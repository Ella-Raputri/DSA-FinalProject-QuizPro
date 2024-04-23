/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import java.awt.Color;
import java.sql.*;
import DatabaseConnection.ConnectionProvider;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author asus
 */
public class AddQuizttt extends javax.swing.JFrame {

    /**
     * Creates new form AddQuiz
     */
    public AddQuizttt() {
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

        jLabel8 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        titleField = new javax.swing.JTextField();
        titleField1 = new javax.swing.JTextField();
        backButton = new App.buttonCustom();
        okButton = new App.buttonCustom();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Montserrat SemiBold", 0, 36)); // NOI18N
        jLabel8.setText("<html><u>Search Question</u></html>");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 330, 60));

        id.setFont(new java.awt.Font("Montserrat SemiBold", 0, 28)); // NOI18N
        id.setText("Id");
        getContentPane().add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 100, -1));

        jLabel9.setFont(new java.awt.Font("Montserrat SemiBold", 0, 28)); // NOI18N
        jLabel9.setText("Duration:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));

        jLabel10.setFont(new java.awt.Font("Montserrat SemiBold", 0, 28)); // NOI18N
        jLabel10.setText("ID:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jLabel11.setFont(new java.awt.Font("Montserrat SemiBold", 0, 28)); // NOI18N
        jLabel11.setText("Title:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        jLabel1.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel1.setText("minutes");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 380, -1, -1));

        jLabel2.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel2.setText("(maximum 40 characters)");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, -1, -1));

        titleField.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        getContentPane().add(titleField, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 150, 50));

        titleField1.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        titleField1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEmptyBorder(1, 1, 14, 1)));
        titleField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                titleField1FocusLost(evt);
            }
        });
        titleField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                titleField1KeyTyped(evt);
            }
        });
        getContentPane().add(titleField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 450, 50));

        backButton.setBackground(new java.awt.Color(255, 255, 255));
        backButton.setForeground(new java.awt.Color(57, 129, 247));
        backButton.setText("< Back");
        backButton.setBorderColor(new java.awt.Color(57, 129, 247));
        backButton.setBorderColorNotOver(new java.awt.Color(57, 129, 247));
        backButton.setBorderColorOver(new java.awt.Color(13, 72, 170));
        backButton.setColor(java.awt.Color.white);
        backButton.setColor2(new java.awt.Color(57, 129, 247));
        backButton.setColorClick(new java.awt.Color(235, 235, 235));
        backButton.setColorClick2(new java.awt.Color(13, 72, 170));
        backButton.setColorOver(new java.awt.Color(235, 235, 235));
        backButton.setColorOver2(new java.awt.Color(13, 72, 170));
        backButton.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        backButton.setRadius(10);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 100, 50));

        okButton.setBackground(new java.awt.Color(57, 129, 247));
        okButton.setForeground(new java.awt.Color(255, 255, 255));
        okButton.setText("OK");
        okButton.setBorderColor(java.awt.Color.white);
        okButton.setBorderColorNotOver(java.awt.Color.white);
        okButton.setBorderColorOver(new java.awt.Color(255, 255, 255));
        okButton.setColor(new java.awt.Color(57, 129, 247));
        okButton.setColor2(java.awt.Color.white);
        okButton.setColorClick(new java.awt.Color(57, 158, 255));
        okButton.setColorClick2(java.awt.Color.white);
        okButton.setColorOver(new java.awt.Color(57, 158, 255));
        okButton.setColorOver2(java.awt.Color.white);
        okButton.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        okButton.setRadius(10);
        getContentPane().add(okButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 490, 100, 50));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/background_addquiz.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 4, 540, 570));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        int a = JOptionPane.showConfirmDialog(null, "Do you really want to go back?", "SELECT", JOptionPane.YES_OPTION);
        if(a==0){
            setVisible(false);
            AdminHome.open = 1;
        }
    }//GEN-LAST:event_backButtonActionPerformed

    private void titleField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_titleField1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_titleField1KeyTyped

    private void titleField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_titleField1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_titleField1FocusLost

    
    private void myinit(){
        
    }                                   
                                                                                  

//    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
//        int a = JOptionPane.showConfirmDialog(null, "Do you really want to go back?", "SELECT", JOptionPane.YES_OPTION);
//        if(a==0){
//            setVisible(false);
//            new SignUpPage().setVisible(true);
//        }
//    }
//    
//    private static boolean checkInt(String str){
//        try{
//            Integer.parseInt(str);
//            return true;
//        }
//        catch(Exception e){
//            return false;
//        }
//    }
//
//    private void OKbuttonActionPerformed(java.awt.event.ActionEvent evt) {
//        String idInput = id.getText();
//        String titleInput = titleField.getText();
//        String durationInput = durationField.getText();
//        
//        if(titleInput.equals("")){
//            JOptionPane.showMessageDialog(null, "Your title is still empty");
//        }
//        else if(durationInput.equals("")){
//            JOptionPane.showMessageDialog(null, "Your duration field is still empty");
//        }
//        else if(titleInput.length() > 40){
//            JOptionPane.showMessageDialog(null, "Your title has exceeded 40 characters.");            
//        }
//        else if(checkInt(durationInput) == false){
//            JOptionPane.showMessageDialog(null, "Duration input must be a number");
//        }
//        else{
//            try{
//                Connection con = ConnectionProvider.getCon();
//                Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
//                
//                PreparedStatement ps = con.prepareStatement("insert into quiz values(?,?,?)");
//                ps.setString(1, idInput);
//                ps.setString(2, titleInput);
//                ps.setString(3, durationInput);
//                ps.executeUpdate();
//                setVisible(false);
//                AdminHome home = (AdminHome) SwingUtilities.getWindowAncestor(this);
//                home.goToEdit(idInput);
//
//            }catch(Exception e){
//                JOptionPane.showMessageDialog(null, e);
//            }
//        }
//        
//        
//    }
    
    
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
            java.util.logging.Logger.getLogger(AddQuizttt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddQuizttt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddQuizttt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddQuizttt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddQuizttt().setVisible(true);
            }
        });
    }
    
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private App.buttonCustom backButton;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private App.buttonCustom okButton;
    private javax.swing.JTextField titleField;
    private javax.swing.JTextField titleField1;
    // End of variables declaration//GEN-END:variables
}
