/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import DatabaseConnection.ConnectionProvider;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

/**
 *
 * @author asus
 */
public class ExamPage extends javax.swing.JFrame {
    private String quizId;
    private String studentId;
    private int totalTime =0;
    private int min=0;
    private int sec=0;
    Timer time;
    private int questionNumber = 1;
    private int quizTotalQuestions;
    private String answer;
    private LinkedList<JRadioButton> answerList = new LinkedList<>();
    private LinkedList<String> correctAnswersList = new LinkedList<>();
    private LinkedList<String> studentAnswerList = new LinkedList<>();
    
    /**
     * Creates new form ExamPage
     */
    public ExamPage() {
        initComponents();
    }
    
    public ExamPage(String quizId, String studentId) {
        this.quizId = quizId;
        this.studentId = studentId;
        
        initComponents();
        myinit();
    }
    
    private void myinit(){
        backButton.setVisible(false);
        submitButton.setVisible(false);
        
        time = new Timer(1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                if(sec==60){
                    sec=0;
                    min++;
                    if(min==totalTime){
                        time.stop();
                        submit();
                    }
                }
                
                String minutes = String.valueOf(min);
                if(minutes.length() < 2){
                    minutes = "0" + minutes;
                }
                
                String seconds = String.valueOf(sec);
                if(seconds.length()<2){
                    seconds = "0" + seconds;
                }
                
                String str = minutes + "." + seconds;
                timeTakenLabel.setText(str);
                
                
                sec++;
            }
        });
        time.start();
        
        
        try{
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("select * from quiz where id='" + quizId + "'");
            if(rs.first()){
                quizTitleLabel.setText(rs.getString(2));
                
                String totalTimeStr = rs.getString(3);
                this.totalTime = Integer.parseInt(totalTimeStr);
                totalTimeLabel.setText(totalTimeStr + ".00");
            }
            
            ResultSet rs1 = st.executeQuery("select count(id) from question where quizID='" + quizId + "'");
            if(rs1.first()){
                String temp = rs1.getString(1);
                quizTotalQuestions = Integer.parseInt(temp);
            }
            else{
                quizTotalQuestions = 0;
            }
            
            
            for(int i=1; i<=quizTotalQuestions; i++){
                String str = "select answer from question where quizID='" + quizId + "' and number=";
                str = str + i;
                ResultSet rs2 = st.executeQuery(str);
                if(rs2.first()){
                    String ans = rs2.getString(1);
                    correctAnswersList.add(ans);
                }
            }
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(getContentPane(), e);
        }
        
        for(int i=0; i<quizTotalQuestions; i++){
            answerList.add(null);
            studentAnswerList.add(null);
        }
        
        displayQuestion();
        displayAnswer();
        
        
    }
    
    
    private void displayAnswer(){
        if(!(answerList.get(questionNumber-1)==null)){
            answerList.get(questionNumber-1).setSelected(true);
        }
        
    }
    
  
    private void displayQuestion(){
        
        if(questionNumber == quizTotalQuestions){
            nextButton.setVisible(false);
            submitButton.setVisible(true);
        }
        else if(questionNumber ==1){
            backButton.setVisible(false);
            
        }
        else{
            nextButton.setVisible(true);
            backButton.setVisible(true);
        }
        
        try{
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                        
            ResultSet rs2 = st.executeQuery("select * from question where quizID='" + quizId + "' and number=" + questionNumber);
            while(rs2.next()){
                questionNumberLabel.setText("Question " + questionNumber + " of " + quizTotalQuestions);
                String question = rs2.getString(2);
                setLabelTextWithLineBreaks(questionLabel, question, 984);
                option1Label.setText(rs2.getString(4));
                option2Label.setText(rs2.getString(5));
                option3Label.setText(rs2.getString(6));
                option4Label.setText(rs2.getString(7));
                answer = rs2.getString(3);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(getContentPane(), e);
        }
    }
    
    private void setLabelTextWithLineBreaks(JLabel label, String text, int maxWidth) {
        // Split the text into words
        String[] words = text.split(" ");
        StringBuilder newText = new StringBuilder();
        int currentWidth = 0;
        int lineHeight = label.getFontMetrics(label.getFont()).getHeight(); // Get the height of each line

        // Iterate through words
        for (String word : words) {
            // Get the width of the current text with the new word
            int wordWidth = label.getFontMetrics(label.getFont()).stringWidth(word + " ");

            // If adding the new word exceeds the maximum width, add a line break
            if (currentWidth + wordWidth > maxWidth) {
                newText.append("<br>");
                currentWidth = 0;
            }

            // Add the word to the text
            newText.append(word).append(" ");
            currentWidth += wordWidth;
        }

        // Set the label text with line breaks
        label.setText("<html>" + newText.toString() + "</html>");

        // Adjust label bounds based on the wrapped text
        int labelWidth = Math.max(label.getPreferredSize().width, maxWidth); // Limit the width to maxWidth
        int labelHeight = ((int) Math.ceil((double) label.getPreferredSize().height / lineHeight) * lineHeight) + 40; // Adjust height to fit lines
        setComponentBounds(label, 40, 50, labelWidth, labelHeight); // Set new bounds for the label
    }
    
    private void setComponentBounds(Component component, int x, int y, int width, int height) {
        component.setBounds(x, y, width, height); // Set the position and size of the component
    }
    
    
    private int checkAnswer(){
        int marks=0;
        for(int i=0; i<quizTotalQuestions; i++){
            String studentAnswer = studentAnswerList.get(i);
            String correctAnswer = correctAnswersList.get(i);
            if(studentAnswer == null){
                continue;
            }
            else if(studentAnswer.equals(correctAnswer)){
                marks+=1;
            }
        }
        
        double marks2 = (double) marks;
        double finalScore = (marks2/quizTotalQuestions) * 100;
        
        try{
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            PreparedStatement ps = con.prepareStatement("update student set " + quizId +  "=? where id=?");
            ps.setDouble(1, finalScore);
            ps.setString(2, studentId);
            ps.executeUpdate();

        }catch(Exception e){
            JOptionPane.showMessageDialog(getContentPane(), e);
        }
        
        return marks;
    }
    
    private void submit(){
        int score = checkAnswer();
        setVisible(false);
        new QuizSummary(score, studentId, quizTotalQuestions).setVisible(true);
    }

    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        nextButton = new App.buttonCustom();
        quizTitleLabel = new javax.swing.JLabel();
        totalTimeLabel = new javax.swing.JLabel();
        questionNumberLabel = new javax.swing.JLabel();
        questionLabel = new javax.swing.JLabel();
        option2Label = new javax.swing.JRadioButton();
        option3Label = new javax.swing.JRadioButton();
        option4Label = new javax.swing.JRadioButton();
        option1Label = new javax.swing.JRadioButton();
        timeTakenLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        LogoutButton = new App.buttonCustom();
        backButton = new App.buttonCustom();
        submitButton = new App.buttonCustom();
        asterisks = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nextButton.setBackground(new java.awt.Color(57, 129, 247));
        nextButton.setForeground(new java.awt.Color(255, 255, 255));
        nextButton.setText("Next   >");
        nextButton.setBorderColor(new java.awt.Color(57, 129, 247));
        nextButton.setBorderColorNotOver(new java.awt.Color(57, 129, 247));
        nextButton.setBorderColorOver(new java.awt.Color(57, 158, 255));
        nextButton.setColor(new java.awt.Color(57, 129, 247));
        nextButton.setColor2(java.awt.Color.white);
        nextButton.setColorClick(new java.awt.Color(57, 158, 255));
        nextButton.setColorClick2(java.awt.Color.white);
        nextButton.setColorOver(new java.awt.Color(57, 158, 255));
        nextButton.setColorOver2(java.awt.Color.white);
        nextButton.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        nextButton.setMaximumSize(new java.awt.Dimension(143, 68));
        nextButton.setMinimumSize(new java.awt.Dimension(143, 68));
        nextButton.setPreferredSize(new java.awt.Dimension(143, 68));
        nextButton.setRadius(30);
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });
        getContentPane().add(nextButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 630, 140, 50));

        quizTitleLabel.setFont(new java.awt.Font("Montserrat SemiBold", 0, 45)); // NOI18N
        quizTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        quizTitleLabel.setText("quiz title");
        quizTitleLabel.setMaximumSize(new Dimension(1039, 59));
        quizTitleLabel.setPreferredSize(getMinimumSize());
        getContentPane().add(quizTitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 880, 60));

        totalTimeLabel.setFont(new java.awt.Font("Montserrat Medium", 0, 28)); // NOI18N
        totalTimeLabel.setText("00.00");
        getContentPane().add(totalTimeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 110, -1, -1));

        questionNumberLabel.setFont(new java.awt.Font("Montserrat Medium", 0, 28)); // NOI18N
        questionNumberLabel.setText("Question 1 of 50");
        getContentPane().add(questionNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, -1));

        questionLabel.setFont(new java.awt.Font("Montserrat SemiBold", 0, 32)); // NOI18N
        questionLabel.setText("What is the meaning of this sentence of the answer?");
        getContentPane().add(questionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 1030, -1));

        buttonGroup1.add(option2Label);
        option2Label.setFont(new java.awt.Font("Montserrat Medium", 0, 24)); // NOI18N
        option2Label.setText("jRadioButton1");
        option2Label.setIconTextGap(8);
        option2Label.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option2LabelActionPerformed(evt);
            }
        });
        getContentPane().add(option2Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, -1, -1));

        buttonGroup1.add(option3Label);
        option3Label.setFont(new java.awt.Font("Montserrat Medium", 0, 24)); // NOI18N
        option3Label.setText("jRadioButton1");
        option3Label.setIconTextGap(8);
        option3Label.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option3LabelActionPerformed(evt);
            }
        });
        getContentPane().add(option3Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, -1, -1));

        buttonGroup1.add(option4Label);
        option4Label.setFont(new java.awt.Font("Montserrat Medium", 0, 24)); // NOI18N
        option4Label.setText("jRadioButton1");
        option4Label.setIconTextGap(8);
        option4Label.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option4LabelActionPerformed(evt);
            }
        });
        getContentPane().add(option4Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 500, -1, -1));

        buttonGroup1.add(option1Label);
        option1Label.setFont(new java.awt.Font("Montserrat Medium", 0, 24)); // NOI18N
        option1Label.setText("jRadioButton1");
        option1Label.setIconTextGap(8);
        option1Label.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option1LabelActionPerformed(evt);
            }
        });
        getContentPane().add(option1Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, -1, -1));

        timeTakenLabel.setFont(new java.awt.Font("Montserrat Medium", 0, 28)); // NOI18N
        timeTakenLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeTakenLabel.setText("00.00");
        getContentPane().add(timeTakenLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 110, 110, -1));

        jLabel2.setFont(new java.awt.Font("Montserrat Medium", 0, 28)); // NOI18N
        jLabel2.setText("Time:               / ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 110, -1, -1));

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
        LogoutButton.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        LogoutButton.setMaximumSize(new java.awt.Dimension(143, 68));
        LogoutButton.setMinimumSize(new java.awt.Dimension(143, 68));
        LogoutButton.setPreferredSize(new java.awt.Dimension(143, 68));
        LogoutButton.setRadius(30);
        LogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutButtonActionPerformed(evt);
            }
        });
        getContentPane().add(LogoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 20, 140, 50));

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
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 630, 140, 50));

        submitButton.setBackground(new java.awt.Color(0, 0, 0));
        submitButton.setForeground(new java.awt.Color(255, 255, 255));
        submitButton.setText("Submit");
        submitButton.setBorderColor(new java.awt.Color(0, 0, 0));
        submitButton.setBorderColorNotOver(new java.awt.Color(0, 0, 0));
        submitButton.setBorderColorOver(new java.awt.Color(72, 72, 72));
        submitButton.setColor(new java.awt.Color(0, 0, 0));
        submitButton.setColor2(java.awt.Color.white);
        submitButton.setColorClick(new java.awt.Color(72, 72, 72));
        submitButton.setColorClick2(java.awt.Color.white);
        submitButton.setColorOver(new java.awt.Color(72, 72, 72));
        submitButton.setColorOver2(java.awt.Color.white);
        submitButton.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        submitButton.setMaximumSize(new java.awt.Dimension(143, 68));
        submitButton.setMinimumSize(new java.awt.Dimension(143, 68));
        submitButton.setPreferredSize(new java.awt.Dimension(143, 68));
        submitButton.setRadius(30);
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(submitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 630, 140, 50));

        asterisks.setFont(new java.awt.Font("Montserrat SemiBold", 0, 48)); // NOI18N
        asterisks.setForeground(new java.awt.Color(255, 0, 0));
        asterisks.setText("*");
        getContentPane().add(asterisks, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/background_exam.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1280, 730));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        questionNumber+=1;
        buttonGroup1.clearSelection();
        
        displayQuestion();
        displayAnswer();
    }//GEN-LAST:event_nextButtonActionPerformed

    private void LogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutButtonActionPerformed
        int a = JOptionPane.showConfirmDialog(getContentPane(), "Do you really want to log out?", "SELECT", JOptionPane.YES_OPTION);
        if(a==0){
            setVisible(false);
            new WelcomePage().setVisible(true);
        }
    }//GEN-LAST:event_LogoutButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        questionNumber-=1;
        buttonGroup1.clearSelection();
        
        displayQuestion();
        displayAnswer();
    }//GEN-LAST:event_backButtonActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        int a = JOptionPane.showConfirmDialog(getContentPane(), "Do you really want to submit?", "SELECT", JOptionPane.YES_OPTION);
        if(a==0){
            int empty=0;
            int[]arr = new int[answerList.size()];
            for(int i=0; i<answerList.size(); i++){
                if(answerList.get(i) == null){
                    arr[empty] = i+1;
                    empty++;
                }
            }
            
            if(empty==0){
                submit();
            }
            else{
                String str="Number " + arr[0];
                for(int j=1; j<arr.length; j++){
                    if(arr[j] != 0){
                        str = str + ", " + arr[j];
                    }
                }
                str = str + " is still empty. \nPlease fill it before submitting.";
                
                JOptionPane.showMessageDialog(getContentPane(), str);
            }
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void option1LabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option1LabelActionPerformed
        answerList.set(questionNumber-1, option1Label);
        
        String ans = option1Label.getText();
        studentAnswerList.set(questionNumber-1, ans);
    }//GEN-LAST:event_option1LabelActionPerformed

    private void option2LabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option2LabelActionPerformed
        answerList.set(questionNumber-1, option2Label);
        
        String ans = option2Label.getText();
        studentAnswerList.set(questionNumber-1, ans);
    }//GEN-LAST:event_option2LabelActionPerformed

    private void option3LabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option3LabelActionPerformed
        answerList.set(questionNumber-1, option3Label);
        
        String ans = option3Label.getText();
        studentAnswerList.set(questionNumber-1, ans);
    }//GEN-LAST:event_option3LabelActionPerformed

    private void option4LabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option4LabelActionPerformed
        answerList.set(questionNumber-1, option4Label);
        
        String ans = option4Label.getText();
        studentAnswerList.set(questionNumber-1, ans);
    }//GEN-LAST:event_option4LabelActionPerformed

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
            java.util.logging.Logger.getLogger(ExamPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExamPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExamPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExamPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExamPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private App.buttonCustom LogoutButton;
    private javax.swing.JLabel asterisks;
    private App.buttonCustom backButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private App.buttonCustom nextButton;
    private javax.swing.JRadioButton option1Label;
    private javax.swing.JRadioButton option2Label;
    private javax.swing.JRadioButton option3Label;
    private javax.swing.JRadioButton option4Label;
    private javax.swing.JLabel questionLabel;
    private javax.swing.JLabel questionNumberLabel;
    private javax.swing.JLabel quizTitleLabel;
    private App.buttonCustom submitButton;
    private javax.swing.JLabel timeTakenLabel;
    private javax.swing.JLabel totalTimeLabel;
    // End of variables declaration//GEN-END:variables
}
