/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import DatabaseConnection.ConnectionProvider;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class QuizSummary extends javax.swing.JFrame {
    private String studentId;
    private int score;
    private int totalQuestions;
    private String username;
    private String[] highMarks = {"You nailed it, ", "Impressive work, ", "Fantastic performance, "};
    private String[] averageMarks = {"Keep it up, ", "Well done, ", "Keep advancing, "};
    private String[] lowMarks = {"Better luck next time, ", "Failure is just a detour, ", "Nail it next time, "};
    
    /**
     * Creates new form QuizSummary
     */
    public QuizSummary() {
        initComponents();
    }
    
    public QuizSummary(int score, String studentId, int totalQuestions) {
        initComponents();
        this.studentId = studentId;
        this.score = score;
        this.totalQuestions = totalQuestions;
        
        try{
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("select username from student where id='" + studentId + "'");
            if(rs.first()){
                this.username = rs.getString(1);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(getContentPane(), e);
        }
        
        setTextLabel();
        scoreLabel.setText("Your Score: " + score + "/" + totalQuestions);
        
        double score2 = (double)score;
        Double newData = Double.valueOf((score2/totalQuestions) * 910);
        System.out.print(newData);
        int greenWidth = newData.intValue();
        System.out.print(greenWidth);
        greenBar.setPreferredSize(new Dimension(greenWidth, greenBar.getHeight()));
        greenBar.revalidate();
        greenBar.repaint();
    }
    
    
    private void setTextLabel(){
        double score2 = (double)score;
        double finalScore = (score2/totalQuestions) * 100;
        Random rand = new Random();
        int index = rand.nextInt(3);
        
        String text="";
        if(finalScore >=90){
            text = highMarks[index];
        }
        else if (finalScore < 65){
            text = lowMarks[index];
        }
        else{
            text = averageMarks[index];
        }
        textLabel.setText(text + username + "!");
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
        LogoutButton = new App.buttonCustom();
        scoreLabel = new javax.swing.JLabel();
        textLabel = new javax.swing.JLabel();
        greenBar = new javax.swing.JTextField();
        redBar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backButton.setBackground(new java.awt.Color(57, 129, 247));
        backButton.setForeground(new java.awt.Color(255, 255, 255));
        backButton.setText("Back to Home   >");
        backButton.setBorderColor(new java.awt.Color(57, 129, 247));
        backButton.setBorderColorNotOver(new java.awt.Color(57, 129, 247));
        backButton.setBorderColorOver(new java.awt.Color(57, 158, 255));
        backButton.setColor(new java.awt.Color(57, 129, 247));
        backButton.setColor2(java.awt.Color.white);
        backButton.setColorClick(new java.awt.Color(57, 158, 255));
        backButton.setColorClick2(java.awt.Color.white);
        backButton.setColorOver(new java.awt.Color(57, 158, 255));
        backButton.setColorOver2(java.awt.Color.white);
        backButton.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        backButton.setMaximumSize(new java.awt.Dimension(143, 68));
        backButton.setMinimumSize(new java.awt.Dimension(143, 68));
        backButton.setPreferredSize(new java.awt.Dimension(143, 68));
        backButton.setRadius(30);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 600, 250, 60));

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
        getContentPane().add(LogoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 20, 180, 60));

        scoreLabel.setFont(new java.awt.Font("Montserrat Medium", 0, 36)); // NOI18N
        scoreLabel.setText("Your Score: 50/50");
        getContentPane().add(scoreLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, -1, -1));

        textLabel.setFont(new java.awt.Font("Montserrat Medium", 0, 36)); // NOI18N
        textLabel.setText("Good job/better luck next time, name!");
        getContentPane().add(textLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, -1, -1));

        greenBar.setBackground(new java.awt.Color(108, 207, 160));
        greenBar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(greenBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, -1, 50));

        redBar.setBackground(new java.awt.Color(251, 106, 106));
        redBar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(redBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 910, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/background_quizsummary.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        setVisible(false);
        new StudentHome(studentId).setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void LogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutButtonActionPerformed
        int a = JOptionPane.showConfirmDialog(getContentPane(), "Do you really want to log out?", "SELECT", JOptionPane.YES_OPTION);
        if(a==0){
            setVisible(false);
            new WelcomePage().setVisible(true);
        }
    }//GEN-LAST:event_LogoutButtonActionPerformed

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
            java.util.logging.Logger.getLogger(QuizSummary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuizSummary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuizSummary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuizSummary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuizSummary().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private App.buttonCustom LogoutButton;
    private App.buttonCustom backButton;
    private javax.swing.JTextField greenBar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField redBar;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JLabel textLabel;
    // End of variables declaration//GEN-END:variables
}
