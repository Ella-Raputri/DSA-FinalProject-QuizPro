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
    private static String quizId;
    private String studentId;
    private int totalTime =0;
    private int min=0;
    private int sec=0;
    Timer time;
    private int questionNumber = 1;
    private int quizTotalQuestions;
    private LinkedList<JRadioButton> optionList = new LinkedList<>();
    private LinkedList<String> correctAnswersList = new LinkedList<>();
    private LinkedList<String> studentAnswerList = new LinkedList<>();
    private LinkedList<Boolean> requiredList = new LinkedList<>();
    public static LinkedlistBenchmark quizlist2 = new LinkedlistBenchmark();
    
    /**
     * Creates new form ExamPage
     */
    public ExamPage() {
        setTitle("Quiz Exam Page");
        initComponents();
        setResizable(false);
        updateLinkedList(ExamPage.quizlist2);
    }
    
    public ExamPage(String quizId, String studentId) {
        this.studentId = studentId;
        ExamPage.quizId = quizId;
        updateLinkedList(ExamPage.quizlist2);
        initComponents();
        myinit();
    }
    
    
    //make sure that the linked list is up to date
    private void updateLinkedList(LinkedlistBenchmark list){
        quizlist2.quiz.clearNodes();        //clear current linked list
        
        //retrieve new data from the databse
        try{
            Connection con = ConnectionProvider.getCon();
            String query = "SELECT * FROM question WHERE quizID = ? ORDER BY number ASC";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, ExamPage.quizId);
            
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                String qID = rs.getString("id");
                String quest = rs.getString("question");
                String ans = rs.getString("answer");
                String opt1 = rs.getString("option1");
                String opt2 = rs.getString("option2");
                String opt3 = rs.getString("option3");
                String opt4 = rs.getString("option4");
                boolean required = rs.getBoolean("required");
                
                list.addQuestionUpdate(quest, ans, ExamPage.quizId, opt1, opt2, opt3, opt4, required);
                Linkedlist.Node tail_node = list.quiz.tail;
                tail_node.data.setQuestionID(qID);
            }
        }
        catch(Exception e){
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, e);
        }
    }
    
    
    
    private void myinit(){
        //set frame
        setTitle("Quiz Exam Page");
        backButton.setVisible(false);
        submitButton.setVisible(false);
        setResizable(false);
        
        //setting the timer for the exam
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
        
        
        //set quiz details
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

        }catch(Exception e){
            JOptionPane.showMessageDialog(getContentPane(), e);
        }
        
        quizTotalQuestions = quizlist2.quiz.countNodes();
            
        Linkedlist.Node current = quizlist2.quiz.head;
        while(current!=null){
            correctAnswersList.add(" " + current.data.getCorrectAnswer());
            requiredList.add(current.data.getRequired());
            current = current.next;
        }
           
        for(int i=0; i<quizTotalQuestions; i++){
            optionList.add(null);
            studentAnswerList.add(null);
        }
        
        questionLabel = new WrappedLabel(980);
        questionLabel.setFont(new java.awt.Font("Montserrat SemiBold", 0, 30));  
        
        displayQuestion();
        displayAnswer(); 
    }
    
    
    //show the circle_clicked icon when an option is clicked
    private void displayAnswer(){
        if(!(optionList.get(questionNumber-1)==null)){
            optionList.get(questionNumber-1).setSelected(true);
            optionList.get(questionNumber-1).setIcon(new ImageIcon("src/App/img/circle_clicked.png"));
        }    
    }
    
    
    private void displayQuestion(){ 
        //set the next, back, and submit button accordingly
        //if last question, then next button become submit button
        if(questionNumber == quizTotalQuestions){
            nextButton.setVisible(false);
            submitButton.setVisible(true);
            backButton.setVisible(true);
        }
        //if first question, only show the next button
        else if(questionNumber ==1){
            backButton.setVisible(false); 
            nextButton.setVisible(true);
            submitButton.setVisible(false);
        }
        //for other questions, show only next and back button
        else{
            nextButton.setVisible(true);
            backButton.setVisible(true);
            submitButton.setVisible(false);
        }
        
        
        //set question number, question, option contents, and asterisks (for required question)
        String id = quizlist2.quiz.getIDFromNumber(questionNumber);
        Linkedlist.Node currentQuestion = quizlist2.quiz.getNode(id);
        
        questionNumberLabel.setText("Question " + questionNumber + " of " + quizTotalQuestions);
        questionLabel.setText(currentQuestion.data.getQuestion());

        int questionHeight = (111 - questionLabel.getPreferredSize().height)/2;
        getContentPane().add(questionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180+questionHeight, questionLabel.getPreferredSize().width, questionLabel.getPreferredSize().height));
        getContentPane().setComponentZOrder(questionLabel, 0);
        revalidate();
        repaint();

        option1Label.setText(" " + currentQuestion.data.getOption1());
        option2Label.setText(" " + currentQuestion.data.getOption2());
        option3Label.setText(" " + currentQuestion.data.getOption3());
        option4Label.setText(" " + currentQuestion.data.getOption4());
        
        asterisks.setVisible(currentQuestion.data.getRequired());
    }
    
    
    private int checkAnswer(){
        int marks=0;
        
        //check student answer with the correct answer
        for(int i=0; i<quizTotalQuestions; i++){
            String studentAnswer = studentAnswerList.get(i);
            String correctAnswer = correctAnswersList.get(i);
            if(studentAnswer == null){
                continue;
            }
            else if(studentAnswer.equals(correctAnswer)){
                marks +=1;
            }
        }
        
        //calculate the score
        double marks2 = (double) marks;
        double finalScore = (marks2/quizTotalQuestions) * 100;
        
        //update student database
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
        nextButton = new App.ButtonCustom();
        quizTitleLabel = new javax.swing.JLabel();
        totalTimeLabel = new javax.swing.JLabel();
        questionNumberLabel = new javax.swing.JLabel();
        option2Label = new javax.swing.JRadioButton();
        option3Label = new javax.swing.JRadioButton();
        option4Label = new javax.swing.JRadioButton();
        option1Label = new javax.swing.JRadioButton();
        timeTakenLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        LogoutButton = new App.ButtonCustom();
        backButton = new App.ButtonCustom();
        submitButton = new App.ButtonCustom();
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

        option2Label.setFont(new java.awt.Font("Montserrat Medium", 0, 24)); // NOI18N
        option2Label.setText("jRadioButton1");
        option2Label.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        option2Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/circle_default.png"))); // NOI18N
        option2Label.setIconTextGap(8);
        option2Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                option2LabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                option2LabelMouseExited(evt);
            }
        });
        option2Label.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option2LabelActionPerformed(evt);
            }
        });
        getContentPane().add(option2Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, -1, -1));

        option3Label.setFont(new java.awt.Font("Montserrat Medium", 0, 24)); // NOI18N
        option3Label.setText("jRadioButton1");
        option3Label.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        option3Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/circle_default.png"))); // NOI18N
        option3Label.setIconTextGap(8);
        option3Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                option3LabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                option3LabelMouseExited(evt);
            }
        });
        option3Label.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option3LabelActionPerformed(evt);
            }
        });
        getContentPane().add(option3Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 450, -1, -1));

        option4Label.setFont(new java.awt.Font("Montserrat Medium", 0, 24)); // NOI18N
        option4Label.setText("jRadioButton1");
        option4Label.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        option4Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/circle_default.png"))); // NOI18N
        option4Label.setIconTextGap(8);
        option4Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                option4LabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                option4LabelMouseExited(evt);
            }
        });
        option4Label.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option4LabelActionPerformed(evt);
            }
        });
        getContentPane().add(option4Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 520, -1, -1));

        option1Label.setFont(new java.awt.Font("Montserrat Medium", 0, 24)); // NOI18N
        option1Label.setText("jRadioButton1");
        option1Label.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        option1Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/App/img/circle_default.png"))); // NOI18N
        option1Label.setIconTextGap(8);
        option1Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                option1LabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                option1LabelMouseExited(evt);
            }
        });
        option1Label.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option1LabelActionPerformed(evt);
            }
        });
        getContentPane().add(option1Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, -1, -1));

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
        clearSelection();
        
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
        clearSelection();
        
        displayQuestion();
        displayAnswer();
    }//GEN-LAST:event_backButtonActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        int a = JOptionPane.showConfirmDialog(getContentPane(), "Do you really want to submit?", "SELECT", JOptionPane.YES_OPTION);
        if(a==0){
           LinkedList<Integer> numRequiredButEmpty = new LinkedList<>();
           
           //check whether there are required questions that have not been filled
            for(int i=0; i<quizTotalQuestions; i++){
                String studentAnswer = studentAnswerList.get(i);
                boolean required = requiredList.get(i);

                if(required){
                    if(studentAnswer == null){
                        numRequiredButEmpty.add(i+1);
                    }
                }
            }
            
            //if every required question is filled, then submit
            if(numRequiredButEmpty.isEmpty()){
                submit();
            }
            
            //else, show error message
            else{
                String str="Number " + numRequiredButEmpty.get(0);
                for(int j=1; j<numRequiredButEmpty.size(); j++){
                    str = str + ", " + numRequiredButEmpty.get(j);
                }
                str = str + " is still empty. \nPlease fill it before submitting.";
                
                JOptionPane.showMessageDialog(getContentPane(), str);
            }
        }
    }//GEN-LAST:event_submitButtonActionPerformed
    
    //clear radio button selection
    private void clearSelection(){
        option1Label.setSelected(false);
        option1Label.setIcon(new ImageIcon("src/App/img/circle_default.png"));
        option2Label.setSelected(false);
        option2Label.setIcon(new ImageIcon("src/App/img/circle_default.png"));
        option3Label.setSelected(false);
        option3Label.setIcon(new ImageIcon("src/App/img/circle_default.png"));
        option4Label.setSelected(false);
        option4Label.setIcon(new ImageIcon("src/App/img/circle_default.png"));
    }
    
    //draw suitable image based on each radio button selection
    private void radioButtonSelection(JRadioButton radNow, JRadioButton radInactive1, JRadioButton radInactive2, JRadioButton radInactive3, boolean active){
        if(active){
            radNow.setIcon(new ImageIcon("src/App/img/circle_clicked.png"));
            radInactive1.setSelected(false);
            radInactive1.setIcon(new ImageIcon("src/App/img/circle_default.png"));
            radInactive2.setSelected(false);
            radInactive2.setIcon(new ImageIcon("src/App/img/circle_default.png"));
            radInactive3.setSelected(false);
            radInactive3.setIcon(new ImageIcon("src/App/img/circle_default.png")); 
        }
        else{
            radNow.setSelected(false);
            radNow.setIcon(new ImageIcon("src/App/img/circle_default.png"));
        }
        
    }
    
    private void option1LabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option1LabelActionPerformed
        if(option1Label.isSelected()){
            radioButtonSelection(option1Label, option2Label, option3Label, option4Label, true);
            optionList.set(questionNumber-1, option1Label);
        
            String ans = option1Label.getText();
            studentAnswerList.set(questionNumber-1, ans);

        }
        else{
            radioButtonSelection(option1Label, option2Label, option3Label, option4Label, false); 
        }
    }//GEN-LAST:event_option1LabelActionPerformed

    private void option2LabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option2LabelActionPerformed
       
        if(option2Label.isSelected()){
            radioButtonSelection(option2Label, option1Label, option3Label, option4Label, true);
            optionList.set(questionNumber-1, option2Label);
        
            String ans = option2Label.getText();
            studentAnswerList.set(questionNumber-1, ans);
        }
        else{
            radioButtonSelection(option2Label, option1Label, option3Label, option4Label, false); 
        }
    }//GEN-LAST:event_option2LabelActionPerformed

    private void option3LabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option3LabelActionPerformed
        
        
        if(option3Label.isSelected()){
            radioButtonSelection(option3Label, option2Label, option1Label, option4Label, true);
            optionList.set(questionNumber-1, option3Label);
        
            String ans = option3Label.getText();
            studentAnswerList.set(questionNumber-1, ans);
        }
        else{
            radioButtonSelection(option3Label, option2Label, option1Label, option4Label, false); 
        }
    }//GEN-LAST:event_option3LabelActionPerformed

    private void option4LabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option4LabelActionPerformed
        
        
        if(option4Label.isSelected()){
            radioButtonSelection(option4Label, option2Label, option3Label, option1Label, true);
            optionList.set(questionNumber-1, option4Label);
        
            String ans = option4Label.getText();
            studentAnswerList.set(questionNumber-1, ans);
        }
        else{
            radioButtonSelection(option4Label, option2Label, option3Label, option1Label, false); 
        }
    }//GEN-LAST:event_option4LabelActionPerformed

    private void option1LabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_option1LabelMouseEntered
        if(option1Label.isSelected()){
            option1Label.setIcon(new ImageIcon("src/App/img/circle_hover_clicked.png"));
        }
        else{
            option1Label.setIcon(new ImageIcon("src/App/img/circle_hover_default.png"));
        }
    }//GEN-LAST:event_option1LabelMouseEntered

    private void option1LabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_option1LabelMouseExited
        if(option1Label.isSelected()){
            option1Label.setIcon(new ImageIcon("src/App/img/circle_clicked.png"));
        }
        else{
            option1Label.setIcon(new ImageIcon("src/App/img/circle_default.png"));
        }
    }//GEN-LAST:event_option1LabelMouseExited

    private void option2LabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_option2LabelMouseEntered
        if(option2Label.isSelected()){
            option2Label.setIcon(new ImageIcon("src/App/img/circle_hover_clicked.png"));
        }
        else{
            option2Label.setIcon(new ImageIcon("src/App/img/circle_hover_default.png"));
        }
    }//GEN-LAST:event_option2LabelMouseEntered

    private void option2LabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_option2LabelMouseExited
        if(option2Label.isSelected()){
            option2Label.setIcon(new ImageIcon("src/App/img/circle_clicked.png"));
        }
        else{
            option2Label.setIcon(new ImageIcon("src/App/img/circle_default.png"));
        }
    }//GEN-LAST:event_option2LabelMouseExited

    private void option3LabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_option3LabelMouseEntered
        if(option3Label.isSelected()){
            option3Label.setIcon(new ImageIcon("src/App/img/circle_hover_clicked.png"));
        }
        else{
            option3Label.setIcon(new ImageIcon("src/App/img/circle_hover_default.png"));
        }
    }//GEN-LAST:event_option3LabelMouseEntered

    private void option3LabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_option3LabelMouseExited
        if(option3Label.isSelected()){
            option3Label.setIcon(new ImageIcon("src/App/img/circle_clicked.png"));
        }
        else{
            option3Label.setIcon(new ImageIcon("src/App/img/circle_default.png"));
        }
    }//GEN-LAST:event_option3LabelMouseExited

    private void option4LabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_option4LabelMouseEntered
        if(option4Label.isSelected()){
            option4Label.setIcon(new ImageIcon("src/App/img/circle_hover_clicked.png"));
        }
        else{
            option4Label.setIcon(new ImageIcon("src/App/img/circle_hover_default.png"));
        }
    }//GEN-LAST:event_option4LabelMouseEntered

    private void option4LabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_option4LabelMouseExited
        if(option4Label.isSelected()){
            option4Label.setIcon(new ImageIcon("src/App/img/circle_clicked.png"));
        }
        else{
            option4Label.setIcon(new ImageIcon("src/App/img/circle_default.png"));
        }
    }//GEN-LAST:event_option4LabelMouseExited

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
    
    private App.WrappedLabel questionLabel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private App.ButtonCustom LogoutButton;
    private javax.swing.JLabel asterisks;
    private App.ButtonCustom backButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private App.ButtonCustom nextButton;
    private javax.swing.JRadioButton option1Label;
    private javax.swing.JRadioButton option2Label;
    private javax.swing.JRadioButton option3Label;
    private javax.swing.JRadioButton option4Label;
    private javax.swing.JLabel questionNumberLabel;
    private javax.swing.JLabel quizTitleLabel;
    private App.ButtonCustom submitButton;
    private javax.swing.JLabel timeTakenLabel;
    private javax.swing.JLabel totalTimeLabel;
    // End of variables declaration//GEN-END:variables
}
