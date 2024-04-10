/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.*;
import DatabaseConnection.ConnectionProvider;

/**
 *
 * @author Asus
 */
public class AddQuestion extends javax.swing.JFrame {
    private LinkedlistBenchmark quizList;
    private String quizid; 
    
    /**
     * Creates new form AddQuest
     */
    public AddQuestion(){
        initComponents();
        myinit();
    }
    
    public AddQuestion(LinkedlistBenchmark quizList, String quizid) {
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
        
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtnum = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtID = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        opt4Field = new RoundJTextField(15);
        jLabel7 = new javax.swing.JLabel();
        rad1 = new javax.swing.JRadioButton();
        rad2 = new javax.swing.JRadioButton();
        rad3 = new javax.swing.JRadioButton();
        rad4 = new javax.swing.JRadioButton();
        buttonGroup = new javax.swing.ButtonGroup();
        questionField = new RoundJTextField(15);
        opt2Field = new RoundJTextField(15);
        opt1Field = new RoundJTextField(15);
        opt3Field = new RoundJTextField(15);
        backButton = new App.buttonCustom();
        OKbutton = new App.buttonCustom();

        jLabel4.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        jLabel4.setText("Question");

       buttonGroup.add(rad1);       
       buttonGroup.add(rad2);
       buttonGroup.add(rad3);
       buttonGroup.add(rad4);
       
       
//       try{
//            Connection con = ConnectionProvider.getCon();
//            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            ResultSet rs = st.executeQuery("SELECT max(id) FROM question;");
//            if(rs.first()){
//                String lastId = rs.getString(1);
//                char[] arr = lastId.toCharArray();
//                String temp = "";
//                for(int i=1; i<arr.length; i++){
//                    temp += arr[i];
//                }
//                int idnow = Integer.parseInt(temp);
//                idnow = idnow+1;
//                String str = "q" + String.valueOf(idnow);
//                txtID.setText(str);
//            }
//            else{
//                txtID.setText("q1");
//            }
//        }
//        catch(Exception e){
//            JFrame jf = new JFrame();
//            jf.setAlwaysOnTop(true);
//            JOptionPane.showMessageDialog(jf, e+"hey ini di id");
//        }
       
       
       try{
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("SELECT count(*) FROM question;");
            if(rs.first()){
                int lastnum = rs.getInt(1);
                txtnum.setText(Integer.toString(lastnum+1));
                txtnum.setVisible(true);
            }
            else{
                txtnum.setText("1");
                txtnum.setVisible(true);
            }
        }
        catch(SQLException e){
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, e);
        }
       

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
        jLabel1.setText("<html><u>ADD QUESTION</u></html>");

        txtnum.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        txtnum.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtnum.setText("[num]");

        jLabel3.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        jLabel3.setText("Question");

        txtID.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        txtID.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtID.setText("[ID]");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtnum)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(questionField, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(OKbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rad1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(opt1Field, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rad4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(opt4Field, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rad3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(opt3Field, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(rad2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(opt2Field, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(13, 13, 13)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtnum)
                    .addComponent(txtID))
                .addGap(26, 26, 26)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(questionField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(rad1)
                        .addGap(46, 46, 46)
                        .addComponent(rad2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(opt1Field, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(opt2Field, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opt3Field, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(rad3)
                        .addGap(10, 10, 10)))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opt4Field, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(rad4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OKbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(27, 27, 27))
        );

        pack();
        setLocationRelativeTo(null);
        
    }
    
    
    private void opt4FieldActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void rad1ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
    }                                    

    private void rad2ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
    }                                    

    private void rad3ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
    }                                    

    private void rad4ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
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
        else{
            JOptionPane.showMessageDialog(getContentPane(),"Please choose the correct answer.");
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
        else{
            try{
                EditQuiz.quizlist.addQuestion(questionStr, answerStr, this.quizid);
                                
                Connection con = ConnectionProvider.getCon();
    
                Linkedlist.Node tail_node = quizList.quiz.tail;
                Question new_question = tail_node.data;
                
                PreparedStatement ps = con.prepareStatement("insert into question values(?,?,?,?,?,?,?,?)");
                ps.setString(1, new_question.getQuestionID());
                ps.setString(2, new_question.getQuestion());
                ps.setString(3, new_question.getCorrectAnswer());
                ps.setString(4, opt1Str);
                ps.setString(5, opt2Str);
                ps.setString(6, opt3Str);
                ps.setString(7, opt4Str);
                ps.setString(8, this.quizid);
                ps.executeUpdate();
                
                setVisible(false);
                EditQuiz.open = 0;

            }catch(Exception e){
                JOptionPane.showMessageDialog(getContentPane(), e);
            }                 
            
        }
        
       
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
            java.util.logging.Logger.getLogger(AddQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddQuestion().setVisible(true);
            }
        });
    }
    
    private App.buttonCustom OKbutton;
    private App.buttonCustom backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JLabel txtID;
    private javax.swing.JLabel txtnum;
    private javax.swing.ButtonGroup buttonGroup;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
