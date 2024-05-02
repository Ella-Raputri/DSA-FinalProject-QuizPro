/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import DatabaseConnection.ConnectionProvider;
import java.sql.*;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class QuizDetails extends javax.swing.JFrame {
    private String quizTitle;
    private String quizDuration;
    private int quizTotalQuestions=0;
    private int requiredQuestions=0;
    private String studentId;
    private String quizId;
    /**
     * Creates new form QuizDetails
     */
    public QuizDetails() {        
        setTitle("Quiz Details Page");
        initComponents();
        setResizable(false);
    }
    
    public QuizDetails(String quizId, String studentId) {
        setTitle("Quiz Details Page");
        setResizable(false);
        this.quizId = quizId;
        this.studentId = studentId;
        
        try{
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs1 = st.executeQuery("select * from quiz where id='" + quizId + "'");
            if(rs1.first()){
                quizTitle = rs1.getString(2);
                quizDuration = rs1.getString(3);
            }
            else{
                JOptionPane.showMessageDialog(getContentPane(), "null");
            }
            
            ResultSet rs2 = st.executeQuery("select required from question where quizID='" + quizId + "'");
            while(rs2.next()){
                quizTotalQuestions+=1;
                
                boolean required = rs2.getBoolean("required");
                if(required==true){
                    requiredQuestions+=1;
                }
            }

        }catch(Exception e){
            JOptionPane.showMessageDialog(getContentPane(), e);
        }
        
        initComponents();
        

        title.setText(quizTitle);
        duration.setText(quizDuration + " minutes");
        
        if(quizTotalQuestions==1){
            totalQuestions.setText(quizTotalQuestions + " question");
        }
        else{
            totalQuestions.setText(quizTotalQuestions + " questions");
        }
        
        if(requiredQuestions == quizTotalQuestions){
            jLabel3.setText("Make sure to answer all the questions before submitting");
        }
        else if(requiredQuestions == 0){
            jLabel3.setText("All the questions are not required to be filled");
        }
        else{
            if(requiredQuestions==1){
                jLabel3.setText("Make sure to answer the 1 question marked with a red asterisk");
            }
            else{
                jLabel3.setText("Make sure to answer the " + requiredQuestions + " questions marked with a red asterisk");
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

        startButton = new App.ButtonCustom();
        LogoutButton = new App.ButtonCustom();
        backButton = new App.ButtonCustom();
        duration = new javax.swing.JLabel();
        totalQuestions = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        title1 = new javax.swing.JLabel();
        duration1 = new javax.swing.JLabel();
        totalQuestions1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        startButton.setBackground(new java.awt.Color(57, 129, 247));
        startButton.setForeground(new java.awt.Color(255, 255, 255));
        startButton.setText("Start   >");
        startButton.setBorderColor(new java.awt.Color(57, 129, 247));
        startButton.setBorderColorNotOver(new java.awt.Color(57, 129, 247));
        startButton.setBorderColorOver(new java.awt.Color(57, 158, 255));
        startButton.setColor(new java.awt.Color(57, 129, 247));
        startButton.setColor2(java.awt.Color.white);
        startButton.setColorClick(new java.awt.Color(57, 158, 255));
        startButton.setColorClick2(java.awt.Color.white);
        startButton.setColorOver(new java.awt.Color(57, 158, 255));
        startButton.setColorOver2(java.awt.Color.white);
        startButton.setFont(new java.awt.Font("Montserrat SemiBold", 0, 30)); // NOI18N
        startButton.setMaximumSize(new java.awt.Dimension(143, 68));
        startButton.setMinimumSize(new java.awt.Dimension(143, 68));
        startButton.setPreferredSize(new java.awt.Dimension(143, 68));
        startButton.setRadius(30);
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });
        getContentPane().add(startButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 630, 170, 60));

        LogoutButton.setBackground(new java.awt.Color(57, 129, 247));
        LogoutButton.setForeground(new java.awt.Color(255, 255, 255));
        LogoutButton.setText("Log Out");
        LogoutButton.setBorderColor(new java.awt.Color(57, 129, 247));
        LogoutButton.setBorderColorNotOver(new java.awt.Color(57, 129, 247));
        LogoutButton.setBorderColorOver(new java.awt.Color(57, 158, 255));
        LogoutButton.setColor(new java.awt.Color(57, 129, 247));
        LogoutButton.setColor2(java.awt.Color.white);
        LogoutButton.setColorClick(new java.awt.Color(57, 158, 255));
        LogoutButton.setColorClick2(java.awt.Color.white);
        LogoutButton.setColorOver(new java.awt.Color(57, 158, 255));
        LogoutButton.setColorOver2(java.awt.Color.white);
        LogoutButton.setFont(new java.awt.Font("Montserrat SemiBold", 0, 30)); // NOI18N
        LogoutButton.setMaximumSize(new java.awt.Dimension(143, 68));
        LogoutButton.setMinimumSize(new java.awt.Dimension(143, 68));
        LogoutButton.setPreferredSize(new java.awt.Dimension(143, 68));
        LogoutButton.setRadius(30);
        LogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutButtonActionPerformed(evt);
            }
        });
        getContentPane().add(LogoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 20, 170, 60));

        backButton.setBackground(new java.awt.Color(57, 129, 247));
        backButton.setForeground(new java.awt.Color(255, 255, 255));
        backButton.setText("<   Back");
        backButton.setBorderColor(new java.awt.Color(57, 129, 247));
        backButton.setBorderColorNotOver(new java.awt.Color(57, 129, 247));
        backButton.setBorderColorOver(new java.awt.Color(57, 158, 255));
        backButton.setColor(new java.awt.Color(57, 129, 247));
        backButton.setColor2(java.awt.Color.white);
        backButton.setColorClick(new java.awt.Color(57, 158, 255));
        backButton.setColorClick2(java.awt.Color.white);
        backButton.setColorOver(new java.awt.Color(57, 158, 255));
        backButton.setColorOver2(java.awt.Color.white);
        backButton.setFont(new java.awt.Font("Montserrat SemiBold", 0, 30)); // NOI18N
        backButton.setMaximumSize(new java.awt.Dimension(143, 68));
        backButton.setMinimumSize(new java.awt.Dimension(143, 68));
        backButton.setPreferredSize(new java.awt.Dimension(143, 68));
        backButton.setRadius(30);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 640, 170, 60));

        duration.setFont(new java.awt.Font("Montserrat", 0, 32)); // NOI18N
        duration.setText("Duration: ");
        getContentPane().add(duration, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 320, -1, -1));

        totalQuestions.setFont(new java.awt.Font("Montserrat", 0, 32)); // NOI18N
        totalQuestions.setText("Total Questions:");
        getContentPane().add(totalQuestions, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 390, -1, -1));

        title.setFont(new java.awt.Font("Montserrat", 0, 32)); // NOI18N
        title.setText("Title:");
        getContentPane().add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, -1, -1));

        title1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 32)); // NOI18N
        title1.setText("Title:");
        getContentPane().add(title1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, -1, -1));

        duration1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 32)); // NOI18N
        duration1.setText("Duration: ");
        getContentPane().add(duration1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, -1, -1));

        totalQuestions1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 32)); // NOI18N
        totalQuestions1.setText("Total Questions:");
        getContentPane().add(totalQuestions1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, -1, -1));

        jLabel3.setFont(new java.awt.Font("Montserrat Medium", 0, 28)); // NOI18N
        jLabel3.setText("Make sure to fill all the questions before submitting.");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 450, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/background_quizdetails.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        int a = JOptionPane.showConfirmDialog(getContentPane(), "Do you really want to start?", "SELECT", JOptionPane.YES_OPTION);
        if(a==0){
            setVisible(false);
            new ExamPage(quizId, studentId).setVisible(true);
        }
    }//GEN-LAST:event_startButtonActionPerformed

    private void LogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutButtonActionPerformed
        int a = JOptionPane.showConfirmDialog(getContentPane(), "Do you really want to log out?", "SELECT", JOptionPane.YES_OPTION);
        if(a==0){
            setVisible(false);
            new WelcomePage().setVisible(true);
        }
    }//GEN-LAST:event_LogoutButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        int a = JOptionPane.showConfirmDialog(getContentPane(), "Do you really want to go back?", "SELECT", JOptionPane.YES_OPTION);
        if(a==0){
            setVisible(false);
            new StudentHome().setVisible(true);
        }
    }//GEN-LAST:event_backButtonActionPerformed

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
            java.util.logging.Logger.getLogger(QuizDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuizDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuizDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuizDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuizDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private App.ButtonCustom LogoutButton;
    private App.ButtonCustom backButton;
    private javax.swing.JLabel duration;
    private javax.swing.JLabel duration1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private App.ButtonCustom startButton;
    private javax.swing.JLabel title;
    private javax.swing.JLabel title1;
    private javax.swing.JLabel totalQuestions;
    private javax.swing.JLabel totalQuestions1;
    // End of variables declaration//GEN-END:variables
}