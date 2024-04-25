/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import DatabaseConnection.ConnectionProvider;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.KeyStroke;

/**
 *
 * @author Asus
 */
public class ChangeOrder extends javax.swing.JFrame {
    private LinkedlistBenchmark quizList;
    private String quizid;
    private static Question current_question;
    /**
     * Creates new form ChangeOrder
     */
    public ChangeOrder() {
        initComponents();
        myinit();
    }
    
    public ChangeOrder(LinkedlistBenchmark list, String quizid) {
        this.quizList = list;
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
        setTitle("Change Order of Questions");
        getContentPane().setBackground(Color.white);
        setResizable(false);
        
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        radio4 = new javax.swing.JRadioButton();
        radio3 = new javax.swing.JRadioButton();
        radio1 = new javax.swing.JRadioButton();
        radio2 = new javax.swing.JRadioButton();
        backButton = new App.ButtonCustom();
        OKbutton = new App.ButtonCustom();
        idField = new RoundJTextField(15);
        search_id = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        orderField = new RoundJTextField(15);
        txtnum = new javax.swing.JLabel();
        txtopt1 = new javax.swing.JLabel();
        txtquestion = new javax.swing.JLabel();
        txtopt2 = new javax.swing.JLabel();
        txtopt3 = new javax.swing.JLabel();
        txtopt4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnGrp = new javax.swing.ButtonGroup();
        
        //set checkmark image
        checkmark = new javax.swing.JLabel();
        checkmarkIcon = new javax.swing.ImageIcon("src/App/img/checkmark.png");
        checkmark.setIcon(checkmarkIcon);
        
        btnGrp.add(radio1);
        btnGrp.add(radio2);
        btnGrp.add(radio3);
        btnGrp.add(radio4);
        
        radio1.setEnabled(false);
        radio2.setEnabled(false);
        radio3.setEnabled(false);
        radio4.setEnabled(false);
        
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
        jLabel1.setText("<html><u>CHANGE ORDER</u></html>");

        jLabel3.setFont(new java.awt.Font("Montserrat SemiBold", 0, 22)); // NOI18N
        jLabel3.setText("Input Question ID");

        jLabel6.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        jLabel6.setText("Question");

        jLabel7.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        jLabel7.setText("Options");

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
        idField.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enterPressed");
        idField.getActionMap().put("enterPressed", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                handleSearchID();
            }
        });

        jLabel4.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        jLabel4.setText("Question");

        orderField.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N

        txtnum.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        txtnum.setText("[num]");

        txtopt1.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        txtopt1.setText("[option 1]");
        txtopt1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        txtquestion.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        txtquestion.setText("[question]");
        txtquestion.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        txtopt2.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        txtopt2.setText("[option 2]");
        txtopt2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        txtopt3.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        txtopt3.setText("[option 3]");
        txtopt3.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        txtopt4.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        txtopt4.setText("[option 4]");
        txtopt4.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel5.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        jLabel5.setText("Change Order to");

        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(16, 16, 16)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(18, 18, 18)
                                            .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(search_id, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtnum, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txtquestion, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(113, 113, 113)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(4, 4, 4))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(radio2)
                                .addComponent(radio1)
                                .addComponent(radio3)
                                .addComponent(radio4))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtopt1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtopt2, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtopt3, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtopt4, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(orderField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(OKbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtnum))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtquestion, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtopt1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(radio1)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtopt2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(radio2)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtopt3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radio3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtopt4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radio4))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(orderField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OKbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );
        
        
        search_id.setIcon(new javax.swing.ImageIcon("src/App/img/search_id.png"));
        search_id.addMouseListener(new MouseAdapter() {           
            @Override
            public void mouseClicked(MouseEvent e) {
                handleSearchID();
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
    
    
    private void handleSearchID(){
        String idStr = idField.getText();
        Linkedlist.Node current_node = quizList.quiz.getNode(idStr);

        if(current_node != null){
           current_question = current_node.data; 
           txtnum.setText(Integer.toString(current_question.getQuestionNumber()));
           txtquestion.setText(current_question.getQuestion());
           txtopt1.setText(current_question.getOption1());
           txtopt2.setText(current_question.getOption2());
           txtopt3.setText(current_question.getOption3());
           txtopt4.setText(current_question.getOption4());

           if (current_question.getOption1().equals(current_question.getCorrectAnswer())){
                radio1.setSelected(true);
                drawCheckmark(radio1, checkmark, checkmarkIcon);
            }
            else if (current_question.getOption2().equals(current_question.getCorrectAnswer())){
                radio2.setSelected(true);
                drawCheckmark(radio2, checkmark, checkmarkIcon);
            }
            else if (current_question.getOption3().equals(current_question.getCorrectAnswer())){
                radio3.setSelected(true);
                drawCheckmark(radio3, checkmark, checkmarkIcon);
            }
            else if (current_question.getOption4().equals(current_question.getCorrectAnswer())){
                radio4.setSelected(true);
                drawCheckmark(radio4, checkmark, checkmarkIcon);
            }

        }else{
            String message = "There is no question with the ID of " + idStr;
            JOptionPane.showMessageDialog(getContentPane(), message);
        }
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
                                       

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        int option = JOptionPane.showConfirmDialog(getContentPane(), "Are you sure you want to end editing? Your changes will not be saved.", null, JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            setVisible(false);
            EditQuiz.open = 0;
        }
    }      
    
    private boolean isNumeric(String strNum) {
        //to check whether some string is numeric
        if (strNum == null) {
            //if the string is null, then return false
            return false;
        }
        //if not null, then try to parse the string to integer
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            //if exception happens, then return false
            return false;
        }
        return true; //if not, return true
    }

    private void OKbuttonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        String numStr = orderField.getText();
        String idStr = "";
        
        if (current_question != null){
            idStr = current_question.getQuestionID();
        }else{
            JOptionPane.showMessageDialog(getContentPane(), "Please fill in the correct ID.");
        }

        if (isNumeric(numStr)) {
            //update linked list
            int newNum = Integer.parseInt(numStr);
            int oldNum = current_question.getQuestionNumber();
            EditQuiz.quizlist.changeOrder(idStr, newNum); 
            
            if (newNum == oldNum){
                JOptionPane.showMessageDialog(getContentPane(), "The new number is the same as the old number. Changes are not applied.");
                return;
            }
            else if (newNum < 0 || newNum > EditQuiz.quizlist.quiz.countNodes()){
                JOptionPane.showMessageDialog(getContentPane(), "The number "+newNum+" is not in the range of question numbers in this quiz. Please try again.");
                return;
            }

            String updateQuery = "UPDATE question SET number = ? WHERE id = ?";

            try (Connection conn = ConnectionProvider.getCon();
                PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {
                
                Linkedlist.Node curr_node = EditQuiz.quizlist.quiz.head;
                // Iterate over each record and update values
                while (curr_node != null) {
                    
                    pstmt.setInt(1, curr_node.data.getQuestionNumber());
                    pstmt.setString(2, curr_node.data.getQuestionID());
                    
                    // Execute the update statement
                    pstmt.executeUpdate();
                    curr_node = curr_node.next;
                }

                JOptionPane.showMessageDialog(getContentPane(), "The order has been successfully changed.");
                setVisible(false);
                EditQuiz.open = 0;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(getContentPane(), "New number input is not valid. Please try again.");
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
            java.util.logging.Logger.getLogger(ChangeOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangeOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangeOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangeOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChangeOrder().setVisible(true);
            }
        });
    }

    
    private App.ButtonCustom OKbutton;
    private App.ButtonCustom backButton;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField orderField;
    private javax.swing.JRadioButton radio4;
    private javax.swing.JRadioButton radio3;
    private javax.swing.JRadioButton radio1;
    private javax.swing.JRadioButton radio2;
    private javax.swing.JLabel search_id;
    private javax.swing.JLabel txtnum;
    private javax.swing.JLabel txtopt1;
    private javax.swing.JLabel txtopt2;
    private javax.swing.JLabel txtopt3;
    private javax.swing.JLabel txtopt4;
    private javax.swing.JLabel txtquestion;
    private javax.swing.ButtonGroup btnGrp;
    private javax.swing.JLabel checkmark;
    private javax.swing.ImageIcon checkmarkIcon;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
