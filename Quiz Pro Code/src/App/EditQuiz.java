/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;


import DatabaseConnection.ConnectionProvider;
import java.sql.Connection;
import java.sql.*;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author asus
 */
public class EditQuiz extends javax.swing.JFrame {
    public static int open = 0;
    public static LinkedlistBenchmark quizlist = new LinkedlistBenchmark();
    public static String quizID;
    private JPanel contentPane;
    private JPanel cloneablePanel;
    private JScrollPane scrollPane;
    
    /**
     * Creates new form WelcomePage
     */
    public EditQuiz() {
        updateLinkedList(EditQuiz.quizlist);
        initComponents();        
    }
    
    public EditQuiz(String quizId){
        EditQuiz.quizID = quizId;
        updateLinkedList(EditQuiz.quizlist);
        initComponents();
        myinit();
    }
    
    private void updateLinkedList(LinkedlistBenchmark list){
        try{
            Connection con = ConnectionProvider.getCon();
            String query = "SELECT * FROM question WHERE quizID = ? ORDER BY number ASC";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, EditQuiz.quizID);
            
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                String qID = rs.getString("id");
                String quest = rs.getString("question");
                String ans = rs.getString("answer");
                String opt1 = rs.getString("option1");
                String opt2 = rs.getString("option2");
                String opt3 = rs.getString("option3");
                String opt4 = rs.getString("option4");
                
                list.addQuestionUpdate(quest, ans, EditQuiz.quizID, opt1, opt2, opt3, opt4);
                Linkedlist.Node tail_node = list.quiz.tail;
                tail_node.data.setQuestionID(qID);
                list.printQuestions();
            }
        }
        catch(Exception e){
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, e);
        }
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void myinit(){
        setTitle("Edit Quiz Page");
        int totalElement = 0;
        
        Linkedlist.Node current = EditQuiz.quizlist.quiz.head;
        while(current!=null){
            totalElement++;
            current = current.next;
        }
        

        // Create the content pane
        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load the background image
                ImageIcon bgImage = new ImageIcon("src/App/img/background_edit_quiz.png");
                // Draw the background image
                g.drawImage(bgImage.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };
        contentPane.setLayout(null); // Use absolute layout
        setContentPane(contentPane);

        // Create the scroll pane
        scrollPane = new JScrollPane();
        scrollPane.setBounds(60, 300, 1180, 390); // Set bounds for the scroll pane
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);
        contentPane.add(scrollPane);

        // Create the cloneable panel
        cloneablePanel = new JPanel(); // The initial panel inside scroll pane
        cloneablePanel.setLayout(null); // Use absolute layout
        cloneablePanel.setPreferredSize(new Dimension(400, 200)); // Set initial size
        cloneablePanel.setBounds(60, 300, 1200, 1500); // Set bounds for the initial panel
        cloneablePanel.setBackground(new Color(224, 237, 255));
        scrollPane.setViewportView(cloneablePanel); // Set this panel as viewport's view

        System.out.print(totalElement);
        int x=10;
        Linkedlist.Node currentQuestion = EditQuiz.quizlist.quiz.head;
        for(int i=1; i<totalElement+1;i++){
            String id = currentQuestion.data.getQuestionID();
            int questionNumber = currentQuestion.data.getQuestionNumber();
            String question = currentQuestion.data.getQuestion();
            String option1 = currentQuestion.data.getOption1();
            String option2 = currentQuestion.data.getOption2();
            String option3 = currentQuestion.data.getOption3();
            String option4 = currentQuestion.data.getOption4();
            String answer = currentQuestion.data.getCorrectAnswer();

            
            // Create a new cloned panel
            CloneablePanelEditQuiz clonedPanel = new CloneablePanelEditQuiz(40, Color.white, 2,id, questionNumber, question, option1, option2, option3, option4, answer);
            // Set your custom width and height for the cloned panel
            int panelWidth = 1100;
            int panelHeight = 370;
            
            
            int y;
            if (i == 1) {
                y = 10; // If it's the first cloned panel, start at y = 10
            } else {
                y = 10 + (i - 1) * (panelHeight + 50); // Adjusted position for subsequent panels
            }

            // Set the bounds for the cloned panel with your custom size
            clonedPanel.setBounds(x, y, panelWidth, panelHeight);
            clonedPanel.setBackground(Color.white);
            
            // Add the cloned panel to the initial panel
            cloneablePanel.add(clonedPanel);
            // Adjust preferred size of initial panel to include new panel
            Dimension newSize = new Dimension(cloneablePanel.getWidth(), y + panelHeight + 10); // Adjusted size
            cloneablePanel.setPreferredSize(newSize);
            // Ensure the scroll pane updates its viewport
            scrollPane.revalidate();
            scrollPane.repaint();
            // Scroll to show the new panel
            scrollPane.getVerticalScrollBar().setValue(0);
            
            currentQuestion = currentQuestion.next;
        }
        

        ImageIcon bgImage = new ImageIcon("src/App/img/background_edit_quiz.png");
        contentPane.setPreferredSize(new Dimension(bgImage.getIconWidth(), bgImage.getIconHeight()));
        
        backButton = new App.buttonCustom();
        changeOrder_icon = new javax.swing.JLabel();
        result_icon = new javax.swing.JLabel();
        changeOrderButton = new App.buttonCustom();
        resultButton = new App.buttonCustom();
        LogoutButton = new App.buttonCustom();
        search_icon = new javax.swing.JLabel();
        searchButton = new App.buttonCustom();
        edit_icon = new javax.swing.JLabel();
        editButton = new App.buttonCustom();
        delete_icon = new javax.swing.JLabel();
        deleteButton = new App.buttonCustom();
        add_icon = new javax.swing.JLabel();
        addButton = new App.buttonCustom();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        edit_quiz_title_icon = new javax.swing.JLabel();
        edit_duration_icon = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        
        backButton.setBackground(new java.awt.Color(255, 255, 255));
        backButton.setForeground(new java.awt.Color(57, 129, 247));
        backButton.setBorderColor(new java.awt.Color(248, 248, 248));
        backButton.setBorderColorNotOver(java.awt.Color.white);
        backButton.setBorderColorOver(new java.awt.Color(242, 242, 242));
        backButton.setColor(java.awt.Color.white);
        backButton.setColor2(new java.awt.Color(57, 129, 247));
        backButton.setColorClick(new java.awt.Color(235, 235, 235));
        backButton.setColorClick2(new java.awt.Color(41, 103, 197));
        backButton.setColorOver(new java.awt.Color(235, 235, 235));
        backButton.setColorOver2(new java.awt.Color(41, 103, 197));
        backButton.setFont(new java.awt.Font("Montserrat SemiBold", 0, 32)); // NOI18N
        backButton.setText("< Back");
        backButton.setMaximumSize(new java.awt.Dimension(143, 68));
        backButton.setMinimumSize(new java.awt.Dimension(143, 68));
        backButton.setPreferredSize(new java.awt.Dimension(143, 68));
        backButton.setRadius(30);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        backButton.setBounds(20, 20, 160,60);
        contentPane.add(backButton);
        
        
        changeOrder_icon.setFont(new java.awt.Font("Montserrat", 1, 48)); // NOI18N
        changeOrder_icon.setForeground(new java.awt.Color(255, 255, 255));
        changeOrder_icon.setIcon(new javax.swing.ImageIcon("src/App/img/change_order.png"));
        changeOrder_icon.setBounds(500, 230, 40, 40);
        contentPane.add(changeOrder_icon);

        result_icon.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        result_icon.setForeground(new java.awt.Color(255, 255, 255));
        result_icon.setIcon(new javax.swing.ImageIcon("src/App/img/result.png"));
        result_icon.setText("sss");
        result_icon.setBounds(1070,230,30,40);
        contentPane.add(result_icon);

        changeOrderButton.setBackground(new java.awt.Color(57, 129, 247));
        changeOrderButton.setForeground(new java.awt.Color(255, 255, 255));
        changeOrderButton.setText("Change Order");
        changeOrderButton.setBorderColor(new java.awt.Color(57, 129, 247));
        changeOrderButton.setBorderColorNotOver(new java.awt.Color(57, 129, 247));
        changeOrderButton.setBorderColorOver(new java.awt.Color(57, 158, 255));
        changeOrderButton.setColor(new java.awt.Color(57, 129, 247));
        changeOrderButton.setColor2(java.awt.Color.white);
        changeOrderButton.setColorClick(new java.awt.Color(57, 158, 255));
        changeOrderButton.setColorClick2(java.awt.Color.white);
        changeOrderButton.setColorOver(new java.awt.Color(57, 158, 255));
        changeOrderButton.setColorOver2(java.awt.Color.white);
        changeOrderButton.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        changeOrderButton.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        changeOrderButton.setMaximumSize(new java.awt.Dimension(143, 68));
        changeOrderButton.setMinimumSize(new java.awt.Dimension(143, 68));
        changeOrderButton.setPreferredSize(new java.awt.Dimension(143, 68));
        changeOrderButton.setRadius(60);
        changeOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeOrderButtonActionPerformed(evt);
            }
        });
        changeOrderButton.setBounds(480,220,240,60);
        contentPane.add(changeOrderButton);

        resultButton.setBackground(new java.awt.Color(255, 255, 255));
        resultButton.setForeground(new java.awt.Color(57, 129, 247));
        resultButton.setText("Result");
        resultButton.setBorderColor(new java.awt.Color(255, 255, 255));
        resultButton.setBorderColorNotOver(java.awt.Color.white);
        resultButton.setBorderColorOver(new java.awt.Color(235, 235, 235));
        resultButton.setColor(java.awt.Color.white);
        resultButton.setColor2(new java.awt.Color(57, 129, 247));
        resultButton.setColorClick(new java.awt.Color(235, 235, 235));
        resultButton.setColorClick2(new java.awt.Color(54, 96, 160));
        resultButton.setColorOver(new java.awt.Color(235, 235, 235));
        resultButton.setColorOver2(new java.awt.Color(54, 96, 160));
        resultButton.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        resultButton.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        resultButton.setMaximumSize(new java.awt.Dimension(143, 68));
        resultButton.setMinimumSize(new java.awt.Dimension(143, 68));
        resultButton.setPreferredSize(new java.awt.Dimension(143, 68));
        resultButton.setRadius(60);
        resultButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultButtonActionPerformed(evt);
            }
        });
        resultButton.setBounds(1050,220,150,60);
        contentPane.add(resultButton);

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
        LogoutButton.setBounds(1070, 20,170,60);
        contentPane.add(LogoutButton);

        search_icon.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        search_icon.setForeground(new java.awt.Color(57, 129, 247));
        search_icon.setIcon(new javax.swing.ImageIcon("src/App/img/search.png"));
        search_icon.setBounds(740,230,30,40);
        contentPane.add(search_icon);

        searchButton.setBackground(new java.awt.Color(57, 129, 247));
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setText("Search");
        searchButton.setBorderColor(new java.awt.Color(57, 129, 247));
        searchButton.setBorderColorNotOver(new java.awt.Color(57, 129, 247));
        searchButton.setBorderColorOver(new java.awt.Color(57, 158, 255));
        searchButton.setColor(new java.awt.Color(57, 129, 247));
        searchButton.setColor2(java.awt.Color.white);
        searchButton.setColorClick(new java.awt.Color(57, 158, 255));
        searchButton.setColorClick2(java.awt.Color.white);
        searchButton.setColorOver(new java.awt.Color(57, 158, 255));
        searchButton.setColorOver2(java.awt.Color.white);
        searchButton.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        searchButton.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        searchButton.setMaximumSize(new java.awt.Dimension(143, 68));
        searchButton.setMinimumSize(new java.awt.Dimension(143, 68));
        searchButton.setPreferredSize(new java.awt.Dimension(143, 68));
        searchButton.setRadius(60);
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        searchButton.setBounds(730,220,150,60);
        contentPane.add(searchButton);
        
        edit_icon.setForeground(new java.awt.Color(57, 129, 247));
        edit_icon.setIcon(new javax.swing.ImageIcon("src/App/img/edit.png"));
        edit_icon.setText("ddd");
        edit_icon.setBounds(211,240,30,20);
        contentPane.add(edit_icon);
        edit_icon.getAccessibleContext().setAccessibleDescription("");

        editButton.setBackground(new java.awt.Color(57, 129, 247));
        editButton.setForeground(new java.awt.Color(255, 255, 255));
        editButton.setText("Edit");
        editButton.setToolTipText("");
        editButton.setBorderColor(new java.awt.Color(57, 129, 247));
        editButton.setBorderColorNotOver(new java.awt.Color(57, 129, 247));
        editButton.setBorderColorOver(new java.awt.Color(57, 158, 255));
        editButton.setColor(new java.awt.Color(57, 129, 247));
        editButton.setColor2(java.awt.Color.white);
        editButton.setColorClick(new java.awt.Color(57, 158, 255));
        editButton.setColorClick2(java.awt.Color.white);
        editButton.setColorOver(new java.awt.Color(57, 158, 255));
        editButton.setColorOver2(java.awt.Color.white);
        editButton.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        editButton.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        editButton.setMaximumSize(new java.awt.Dimension(143, 68));
        editButton.setMinimumSize(new java.awt.Dimension(143, 68));
        editButton.setPreferredSize(new java.awt.Dimension(143, 68));
        editButton.setRadius(60);
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        editButton.setBounds(200,220,110,60);
        contentPane.add(editButton);

        delete_icon.setFont(new java.awt.Font("Montserrat", 1, 48)); // NOI18N
        delete_icon.setForeground(new java.awt.Color(255, 255, 255));
        delete_icon.setText("-");
        delete_icon.setBounds(340,230,30,30);
        contentPane.add(delete_icon);

        deleteButton.setBackground(new java.awt.Color(57, 129, 247));
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("Delete");
        deleteButton.setBorderColor(new java.awt.Color(57, 129, 247));
        deleteButton.setBorderColorNotOver(new java.awt.Color(57, 129, 247));
        deleteButton.setBorderColorOver(new java.awt.Color(57, 158, 255));
        deleteButton.setColor(new java.awt.Color(57, 129, 247));
        deleteButton.setColor2(java.awt.Color.white);
        deleteButton.setColorClick(new java.awt.Color(57, 158, 255));
        deleteButton.setColorClick2(java.awt.Color.white);
        deleteButton.setColorOver(new java.awt.Color(57, 158, 255));
        deleteButton.setColorOver2(java.awt.Color.white);
        deleteButton.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        deleteButton.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        deleteButton.setMaximumSize(new java.awt.Dimension(143, 68));
        deleteButton.setMinimumSize(new java.awt.Dimension(143, 68));
        deleteButton.setPreferredSize(new java.awt.Dimension(143, 68));
        deleteButton.setRadius(60);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        deleteButton.setBounds(320,220,150,60);
        contentPane.add(deleteButton);

        add_icon.setFont(new java.awt.Font("Montserrat", 1, 40)); // NOI18N
        add_icon.setForeground(new java.awt.Color(255, 255, 255));
        add_icon.setText("+");
        add_icon.setBounds(90,230,30,40);
        contentPane.add(add_icon);

        addButton.setBackground(new java.awt.Color(57, 129, 247));
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("Add");
        addButton.setBorderColor(new java.awt.Color(57, 129, 247));
        addButton.setBorderColorNotOver(new java.awt.Color(57, 129, 247));
        addButton.setBorderColorOver(new java.awt.Color(57, 158, 255));
        addButton.setColor(new java.awt.Color(57, 129, 247));
        addButton.setColor2(java.awt.Color.white);
        addButton.setColorClick(new java.awt.Color(57, 158, 255));
        addButton.setColorClick2(java.awt.Color.white);
        addButton.setColorOver(new java.awt.Color(57, 158, 255));
        addButton.setColorOver2(java.awt.Color.white);
        addButton.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        addButton.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        addButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        addButton.setMaximumSize(new java.awt.Dimension(143, 68));
        addButton.setMinimumSize(new java.awt.Dimension(143, 68));
        addButton.setPreferredSize(new java.awt.Dimension(143, 68));
        addButton.setRadius(60);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        addButton.setBounds(70,220,120,60);
        contentPane.add(addButton);

        jLabel1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 42)); // NOI18N
        jLabel1.setText("[Quiz Title]");
        jLabel1.setBounds(80,100, jLabel1.getPreferredSize().width,jLabel1.getPreferredSize().height);
        contentPane.add(jLabel1);

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jLabel3.setText("Duration:");
        jLabel3.setBounds(90,160, jLabel3.getPreferredSize().width,jLabel3.getPreferredSize().height);
        contentPane.add(jLabel3);
        
        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jLabel2.setText("[Duration]");
        jLabel2.setBounds(200,160, jLabel2.getPreferredSize().width + 40, jLabel2.getPreferredSize().height);
        contentPane.add(jLabel2);

        edit_quiz_title_icon.setIcon(new javax.swing.ImageIcon("src/App/img/edit_quiz_title.png"));
        edit_quiz_title_icon.setBounds(jLabel1.getPreferredSize().width + 90, 110, edit_quiz_title_icon.getPreferredSize().width, edit_quiz_title_icon.getPreferredSize().height);
        contentPane.add(edit_quiz_title_icon);

        edit_duration_icon.setIcon(new javax.swing.ImageIcon("src/App/img/edit_duration.png"));
        edit_duration_icon.setBounds(jLabel2.getPreferredSize().width + 200, 160, edit_duration_icon.getPreferredSize().width, edit_duration_icon.getPreferredSize().height);
        contentPane.add(edit_duration_icon);

        
        contentPane.revalidate();
        contentPane.repaint();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {                                          
        if(open==0){
            new AddQuestion(quizlist, quizID).setVisible(true);
            open=1;
        }
        else{
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf,"One form is already opened");
        }
    }                                         

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        setVisible(false);
        new AdminHome().setVisible(true);
    }                                          

    private void changeOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        if(open==0){
            new ChangeOrder(quizlist, quizID).setVisible(true);
            open=1;
        }
        else{
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf,"One form is already opened");
        }
    }                                                 

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        if(open==0){
            new DeleteQuestion(quizlist, quizID).setVisible(true);
            open=1;
        }
        else{
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf,"One form is already opened");
        }
    }                                            

    private void resultButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        if(open==0){
            new EditQuestion(quizlist, quizID).setVisible(true);
            open=1;
        }
        else{
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf,"One form is already opened");
        }
    }                                          

    private void LogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        int a = JOptionPane.showConfirmDialog(null, "Do you really want to log out?", "SELECT", JOptionPane.YES_OPTION);
        if(a==0){
            setVisible(false);
            new WelcomePage().setVisible(true);
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
            java.util.logging.Logger.getLogger(EditQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditQuiz().setVisible(true);
            }
        });
    }
    
    private App.buttonCustom LogoutButton;
    private App.buttonCustom addButton;
    private javax.swing.JLabel add_icon;
    private App.buttonCustom backButton;
    private App.buttonCustom changeOrderButton;
    private javax.swing.JLabel changeOrder_icon;
    private App.buttonCustom deleteButton;
    private javax.swing.JLabel delete_icon;
    private App.buttonCustom editButton;
    private javax.swing.JLabel edit_duration_icon;
    private javax.swing.JLabel edit_icon;
    private javax.swing.JLabel edit_quiz_title_icon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private App.buttonCustom resultButton;
    private javax.swing.JLabel result_icon;
    private App.buttonCustom searchButton;
    private javax.swing.JLabel search_icon;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
