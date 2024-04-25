/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import DatabaseConnection.ConnectionProvider;
import java.sql.*;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Asus
 */
public class QuizResult extends javax.swing.JFrame {
    private String quizid;
    int totalElement = 0;
    LinkedList<Student> studentList = new LinkedList<>();
    private JPanel contentPane;
    private JPanel cloneablePanel;
    private JScrollPane scrollPane;
    
    
    public QuizResult() {
        initComponents();
        myinit();
    }
    
    public QuizResult(String quizID){
        initComponents();
        this.quizid = quizID;
        myinit();        
    }
    
    private void myinit(){
        setResizable(false);
        setTitle("Students Result");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        //get the total element
        try {
            Connection con = ConnectionProvider.getCon();

            // Query to retrieve non-null values in the specified quizid column
            String selectQuery = "SELECT * FROM student WHERE " + quizid + " IS NOT NULL";
            try (PreparedStatement selectStmt = con.prepareStatement(selectQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
                ResultSet rs = selectStmt.executeQuery();
                while (rs.next()) {
                    String student_name = rs.getString("username");
                    double student_score = rs.getDouble(quizid);
                    
                    Student student1 = new Student (student_name, student_score);
                    studentList.add(student1);
                }
            } catch (SQLException selectEx) {
                JOptionPane.showMessageDialog(getContentPane(), "Error while retrieving non-null values: " + selectEx.getMessage());
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(getContentPane(), "General error: " + e.getMessage());
        }

        totalElement = studentList.size();
        
        // Create the content pane
        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load the background image
                ImageIcon bgImage = new ImageIcon("src/App/img/background_result.png");
                // Draw the background image
                g.drawImage(bgImage.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };
        contentPane.setLayout(null); // Use absolute layout
        setContentPane(contentPane);

        // Create the scroll pane
        scrollPane = new JScrollPane();
        scrollPane.setBounds(85, 220, 1100, 440); // Set bounds for the scroll pane
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);
        contentPane.add(scrollPane);

        // Create the cloneable panel
        cloneablePanel = new JPanel(); // The initial panel inside scroll pane
        cloneablePanel.setLayout(null); // Use absolute layout
        cloneablePanel.setPreferredSize(new Dimension(400, 200)); // Set initial size
        cloneablePanel.setBounds(85, 220, 1100, 440); // Set bounds for the initial panel
        cloneablePanel.setBackground(new Color(224, 237, 255));
        scrollPane.setViewportView(cloneablePanel); // Set this panel as viewport's view
        
        
        int x=10;
        int prevPanelHeight=0;
        int prevY=0;
        for(int i=1; i<totalElement+1;i++){
            String username = studentList.get(i-1).getUsername();
            double score = studentList.get(i-1).getGrade();
            
            // Create a new cloned panel
            CloneablePanelQuizResult clonedPanel = new CloneablePanelQuizResult(40, Color.white, 2, username, score);
            // Set your custom width and height for the cloned panel
            int panelWidth = 1040;
            int panelHeight = clonedPanel.returnLabelHeight();
            
            int y;
            if(i==1){
                y=10;
                prevY=10;
            }
            else{
                int newY = prevY + prevPanelHeight +30;
                y = newY;
                prevY = newY;
            }
            
            prevPanelHeight = panelHeight;

            // Set the bounds for the cloned panel with your custom size
            clonedPanel.setBounds(x, y, panelWidth, panelHeight);
            clonedPanel.setBackground(Color.white);
            
            // Add the cloned panel to the initial panel
            cloneablePanel.add(clonedPanel);
            // Adjust preferred size of initial panel to include new panel
            Dimension newSize = new Dimension(cloneablePanel.getWidth(), y + panelHeight + 20); // Adjusted size
            cloneablePanel.setPreferredSize(newSize);
            // Ensure the scroll pane updates its viewport
            scrollPane.revalidate();
            scrollPane.repaint();
            // Scroll to show the new panel
            scrollPane.getVerticalScrollBar().setValue(0);
            
        }
        

        ImageIcon bgImage = new ImageIcon("src/App/img/background_result.png");
        contentPane.setPreferredSize(new Dimension(bgImage.getIconWidth(), bgImage.getIconHeight()));
        
        
        backButton = new App.ButtonCustom();
        LogoutButton = new App.ButtonCustom();
        jLabel1 = new javax.swing.JLabel();

        
        backButton.setText("< Back");
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
        backButton.setBounds(40,20,120,60);
        contentPane.add(backButton);

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
        LogoutButton.setBounds(1090,20, LogoutButton.getPreferredSize().width, 60);
        contentPane.add(LogoutButton);
        
        
        contentPane.revalidate();
        contentPane.repaint();
        pack();
        setLocationRelativeTo(null);
    }
    
    
    private void LogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        int a = JOptionPane.showConfirmDialog(getContentPane(), "Do you really want to log out?", "SELECT", JOptionPane.YES_OPTION);
        if(a==0){
            studentList.clear();
            setVisible(false);
            new WelcomePage().setVisible(true);
        }
    }
    
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        studentList.clear();
        setVisible(false);
        new EditQuiz(quizid).setVisible(true);
    } 
    
   
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
            java.util.logging.Logger.getLogger(QuizResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuizResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuizResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuizResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuizResult().setVisible(true);
            }
        });
    }
    
    
    private App.ButtonCustom LogoutButton;
    private App.ButtonCustom backButton;
    private javax.swing.JLabel jLabel1;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
