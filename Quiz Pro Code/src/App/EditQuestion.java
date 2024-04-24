/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import DatabaseConnection.ConnectionProvider;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author Asus
 */
public class EditQuestion extends javax.swing.JFrame {
    private LinkedlistBenchmark quizList;
    private String quizid;
    private static Question current_question;
    /**
     * Creates new form AddQuest
     */
    public EditQuestion() {
        initComponents();
        myinit();
    }
    
    public EditQuestion(LinkedlistBenchmark quizList, String quizid) {
        this.quizList = quizList;
        this.quizid = quizid;
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void myinit(){
        getContentPane().setBackground(Color.white);
        
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        opt4Field = new RoundJTextField(15);
        jLabel7 = new javax.swing.JLabel();
        rad1 = new javax.swing.JRadioButton();
        rad2 = new javax.swing.JRadioButton();
        rad3 = new javax.swing.JRadioButton();
        rad4 = new javax.swing.JRadioButton();
        questionField = new RoundJTextField(15);
        opt2Field = new RoundJTextField(15);
        opt1Field = new RoundJTextField(15);
        opt3Field = new RoundJTextField(15);
        backButton = new App.buttonCustom();
        OKbutton = new App.buttonCustom();
        idField = new RoundJTextField(15);
        search_id = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtnum = new javax.swing.JLabel();
        btnGrp = new javax.swing.ButtonGroup();
        
        btnGrp.add(rad1);
        btnGrp.add(rad2);
        btnGrp.add(rad3);
        btnGrp.add(rad4);
        
        checkmark = new javax.swing.JLabel();
        checkmarkIcon = new javax.swing.ImageIcon("src/App/img/checkmark.png");
        checkmark.setIcon(checkmarkIcon);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Custom close operation logic
                int option = JOptionPane.showConfirmDialog(getContentPane(), "Are you sure you want to end editing? Your changes will not be saved.", null, JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    setVisible(false);
                    EditQuiz.open = 0;
                } 
            }
        });
        
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 540, 600));
        setFocusable(false);
        setForeground(java.awt.Color.white);
        setMaximumSize(new java.awt.Dimension(540, 600));
        setMinimumSize(new java.awt.Dimension(540, 600));

        jLabel1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 36)); // NOI18N
        jLabel1.setText("<html><u>EDIT QUESTION</u></html>");

        jLabel3.setFont(new java.awt.Font("Montserrat SemiBold", 0, 22)); // NOI18N
        jLabel3.setText("Input Question ID");

        jLabel6.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        jLabel6.setText("Question");

        opt4Field.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        opt4Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt4FieldActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        jLabel7.setText("Options");

        rad1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad1ActionPerformed(evt);
            }
        });

        rad2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad2ActionPerformed(evt);
            }
        });

        rad3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad3ActionPerformed(evt);
            }
        });

        rad4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad4ActionPerformed(evt);
            }
        });

        questionField.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        questionField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionFieldActionPerformed(evt);
            }
        });

        opt2Field.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        opt2Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt2FieldActionPerformed(evt);
            }
        });

        opt1Field.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        opt1Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt1FieldActionPerformed(evt);
            }
        });

        opt3Field.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        opt3Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt3FieldActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.setBackground(new java.awt.Color(255, 255, 255));
        backButton.setForeground(new java.awt.Color(57, 129, 247));
        backButton.setBorderColor(new java.awt.Color(57,129,247));
        backButton.setBorderColorNotOver(new java.awt.Color(57,129,247));
        backButton.setBorderColorOver(new java.awt.Color(41, 103, 197));
        backButton.setColor(java.awt.Color.white);
        backButton.setColor2(new java.awt.Color(57, 129, 247));
        backButton.setColorClick(new java.awt.Color(235, 235, 235));
        backButton.setColorClick2(new java.awt.Color(41, 103, 197));
        backButton.setColorOver(new java.awt.Color(235, 235, 235));
        backButton.setColorOver2(new java.awt.Color(41, 103, 197));
        backButton.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        backButton.setMaximumSize(new java.awt.Dimension(143, 68));
        backButton.setMinimumSize(new java.awt.Dimension(143, 68));
        backButton.setPreferredSize(new java.awt.Dimension(143, 68));
        backButton.setRadius(10);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        OKbutton.setBackground(new java.awt.Color(57, 129, 247));
        OKbutton.setForeground(new java.awt.Color(255, 255, 255));
        OKbutton.setText("OK");
        OKbutton.setBorderColor(new java.awt.Color(57, 129, 247));
        OKbutton.setBorderColorNotOver(new java.awt.Color(57, 129, 247));
        OKbutton.setBorderColorOver(new java.awt.Color(57, 158, 255));
        OKbutton.setColor(new java.awt.Color(57, 129, 247));
        OKbutton.setColor2(java.awt.Color.white);
        OKbutton.setColorClick(new java.awt.Color(57, 158, 255));
        OKbutton.setColorClick2(java.awt.Color.white);
        OKbutton.setColorOver(new java.awt.Color(57, 158, 255));
        OKbutton.setColorOver2(java.awt.Color.white);
        OKbutton.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        OKbutton.setMaximumSize(new java.awt.Dimension(143, 68));
        OKbutton.setMinimumSize(new java.awt.Dimension(143, 68));
        OKbutton.setPreferredSize(new java.awt.Dimension(143, 68));
        OKbutton.setRadius(10);
        OKbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKbuttonActionPerformed(evt);
            }
        });

        idField.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        idField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idFieldActionPerformed(evt);
            }
        });
        
        jLabel4.setFont(new java.awt.Font("Montserrat SemiBold", 0, 22)); // NOI18N
        jLabel4.setText("Question");

        txtnum.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        txtnum.setText("[num]");

        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(search_id, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(OKbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(rad4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                    .addComponent(opt4Field, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(rad3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(opt3Field, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(rad2)
                                        .addComponent(rad1))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(opt1Field, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(opt2Field, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(questionField, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtnum, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_id))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtnum))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(questionField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(opt1Field, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(rad1)
                        .addGap(44, 44, 44)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(opt2Field, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(rad2)
                        .addGap(39, 39, 39)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(opt3Field, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(rad3)
                        .addGap(39, 39, 39)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(rad4)
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(opt4Field, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OKbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );
        
        
        search_id.setIcon(new javax.swing.ImageIcon("src/App/img/search_id.png"));
        search_id.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String idStr = idField.getText();
                Linkedlist.Node current_node = quizList.quiz.getNode(idStr);
        
                if(current_node != null){
                   current_question = current_node.data; 
                   txtnum.setText(Integer.toString(current_question.getQuestionNumber()));
                   questionField.setText(current_question.getQuestion());
                   opt1Field.setText(current_question.getOption1());
                   opt2Field.setText(current_question.getOption2());
                   opt3Field.setText(current_question.getOption3());
                   opt4Field.setText(current_question.getOption4());
                   
                   if (current_question.getOption1().equals(current_question.getCorrectAnswer())){
                        rad1.setSelected(true);
                        drawCheckmark(rad1, checkmark, checkmarkIcon);
                    }
                    else if (current_question.getOption2().equals(current_question.getCorrectAnswer())){
                        rad2.setSelected(true);
                        drawCheckmark(rad2, checkmark, checkmarkIcon);
                    }
                    else if (current_question.getOption3().equals(current_question.getCorrectAnswer())){
                        rad3.setSelected(true);
                        drawCheckmark(rad3, checkmark, checkmarkIcon);
                    }
                    else if (current_question.getOption4().equals(current_question.getCorrectAnswer())){
                        rad4.setSelected(true);
                        drawCheckmark(rad4, checkmark, checkmarkIcon);
                    }                  
                
                }else{
                    String message = "There is no question with the ID of " + idStr;
                    JOptionPane.showMessageDialog(getContentPane(), message);
                }
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                search_id.setIcon(new javax.swing.ImageIcon("src/App/img/search_id_hover.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                search_id.setIcon(new javax.swing.ImageIcon("src/App/img/search_id.png"));
            }
        }); 
        
        pack();
        setLocationRelativeTo(null);
    }
    
    private void drawCheckmark(JRadioButton radio, JLabel checkmark, ImageIcon checkmarkIcon){
        //set the previous checkmark (if any) to false first
        checkmark.setVisible(false);
        
        //find radio button location
        Point radioLocation = radio.getLocation();
        int checkmarkX = radioLocation.x; 
        int checkmarkY = radioLocation.y; 

        // Set the bounds of the checkmark label
        checkmark.setBounds(checkmarkX, checkmarkY, checkmarkIcon.getIconWidth(), checkmarkIcon.getIconHeight());

        // Add the checkmark label to the parent container of the radio button
        getContentPane().add(checkmark);
        
        //set the checkmark z index to be the top layer
        getContentPane().setComponentZOrder(checkmark, 0);
        //set the checkmark to be visible in the new location
        checkmark.setVisible(true);        
        getContentPane().repaint();
    }
        
        
    private void opt4FieldActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void rad1ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        drawCheckmark(rad1, checkmark, checkmarkIcon);
    }                                    

    private void rad2ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        drawCheckmark(rad2, checkmark, checkmarkIcon);
    }                                    

    private void rad3ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        drawCheckmark(rad3, checkmark, checkmarkIcon);
    }                                    

    private void rad4ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        drawCheckmark(rad4, checkmark, checkmarkIcon);
    }                                    

    private void questionFieldActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void opt2FieldActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void opt1FieldActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void opt3FieldActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        int option = JOptionPane.showConfirmDialog(getContentPane(), "Are you sure you want to end editing? Your changes will not be saved.", null, JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            setVisible(false);
            EditQuiz.open = 0;
        }        
    }                                          

    private void OKbuttonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        String questionStr = questionField.getText();
        String opt1Str = opt1Field.getText();
        String opt2Str = opt2Field.getText();
        String opt3Str = opt3Field.getText();
        String opt4Str = opt4Field.getText();      
        String answerStr = "";
        
        if (rad1.isSelected()){
            answerStr = opt1Str;
        }
        else if (rad2.isSelected()){
            answerStr = opt2Str;
        } 
        else if (rad3.isSelected()){
            answerStr = opt3Str;
        }
        else if (rad4.isSelected()){
            answerStr = opt4Str;
        }
        
        
        if(questionStr.equals("")){
            JOptionPane.showMessageDialog(getContentPane(), "Question is still empty.");
        }
        else if (opt1Str.equals("")){
            JOptionPane.showMessageDialog(getContentPane(), "Option 1 is still empty.");
        }
        else if (opt2Str.equals("")){
            JOptionPane.showMessageDialog(getContentPane(), "Option 2 is still empty.");
        }
        else if (opt3Str.equals("")){
            JOptionPane.showMessageDialog(getContentPane(), "Option 3 is still empty.");
        }
        else if (opt4Str.equals("")){
            JOptionPane.showMessageDialog(getContentPane(), "Option 4 is still empty.");
        }
        else if (answerStr.equals("")){
            JOptionPane.showMessageDialog(getContentPane(),"Please choose the correct answer.");
        }
        else{
            try{
                //edit in linkedlist
                String idStr = current_question.getQuestionID();
                EditQuiz.quizlist.editQuestion(idStr, questionStr, answerStr, opt1Str, opt2Str, opt3Str, opt4Str);
                
                //edit in database
                Connection con = ConnectionProvider.getCon();
                String query = "UPDATE question SET question = ?, answer = ?, option1 = ?, option2 = ?, option3 = ?, option4 = ? WHERE id = ?";
                PreparedStatement ps = con.prepareStatement(query);
                
                ps.setString(1, questionStr);
                ps.setString(2, answerStr);
                ps.setString(3, opt1Str);
                ps.setString(4, opt2Str);
                ps.setString(5, opt3Str);
                ps.setString(6, opt4Str);
                ps.setString(7, idStr);
                
                ps.executeUpdate();
                
                //show message and close menu
                System.out.println("==========================================");
                EditQuiz.quizlist.printQuestions();
                String message = "Question with the ID of "+ idStr +" edited successfully.";
                JOptionPane.showMessageDialog(getContentPane(), message);
                
                current_question = null;
                setVisible(false);
                EditQuiz.open = 0;
                

            }catch(Exception e){
                JOptionPane.showMessageDialog(getContentPane(), e);
            }                 
            
        }
        
    }
    
    private void idFieldActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }
    
    
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
            java.util.logging.Logger.getLogger(EditQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditQuestion().setVisible(true);
            }
        });
    }
    
    private App.buttonCustom OKbutton;
    private App.buttonCustom backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField opt1Field;
    private javax.swing.JTextField opt2Field;
    private javax.swing.JTextField opt3Field;
    private javax.swing.JTextField opt4Field;
    private javax.swing.JTextField questionField;
    private javax.swing.JRadioButton rad1;
    private javax.swing.JRadioButton rad2;
    private javax.swing.JRadioButton rad3;
    private javax.swing.JRadioButton rad4;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel search_id;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel txtnum;
    private javax.swing.ButtonGroup btnGrp;
    private javax.swing.JLabel checkmark;
    private javax.swing.ImageIcon checkmarkIcon;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
