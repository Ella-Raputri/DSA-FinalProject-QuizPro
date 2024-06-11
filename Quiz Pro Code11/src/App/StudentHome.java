/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import DatabaseConnection.ConnectionProvider;
import java.awt.*;
import java.sql.*;
import java.util.LinkedList;
import javax.swing.*;

/**
 *
 * @author asus
 */
public class StudentHome extends javax.swing.JFrame {
    private String studentId;
    /**
     * Creates new form StudentHome
     */
    public StudentHome() {
        initComponents();
        myinit();
    }
    
    public StudentHome(String studentId) {
        this.studentId = studentId;
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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    
    private JPanel contentPane;
    private JPanel cloneablePanel;
    private JScrollPane scrollPane;
    
    private void myinit(){
        //set frame
        setTitle("Student Home Page");
        setResizable(false);
        LinkedList<String> idList = new LinkedList<>();
        LinkedList<Quiz> listOfQuizzes = new LinkedList<>();
        
        try{
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            //select only quiz ID that has question
            ResultSet rs1 = st.executeQuery("select quizID from question");
            while(rs1.next()){
                String id = rs1.getString("quizID");
                if(!(idList.contains(id))){
                    idList.add(id);
                }
            }
            
            //retrieve all information about the quizzes
            for(int i=0; i<idList.size(); i++){
                ResultSet rs2 = st.executeQuery("select * from quiz where id='" + idList.get(i) + "'");
                if(rs2.first()){
                    String id = rs2.getString("id");
                    String title = rs2.getString("title");
                    String duration = rs2.getString("duration");
                    Quiz quiz = new Quiz(title, duration, id);
                    listOfQuizzes.add(quiz);
                }   
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(getContentPane(), e);
        }
        

        // Create the content pane
        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load the background image
                ImageIcon bgImage = new ImageIcon("src/App/img/background_studenthome.png");
                // Draw the background image
                g.drawImage(bgImage.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };
        contentPane.setLayout(null); // Use absolute layout
        setContentPane(contentPane);
        
        //if no quiz, then display these components
        JLabel nothing_here = new JLabel();
        JLabel check_later = new JLabel();
        JLabel empty_box = new JLabel();
        
        if(listOfQuizzes.isEmpty()){
            empty_box.setIcon(new javax.swing.ImageIcon("src/App/img/empty_box.png"));
            empty_box.setBounds(76,203,empty_box.getPreferredSize().width+30,empty_box.getPreferredSize().height);
            contentPane.add(empty_box);
            
            nothing_here.setText("Nothing Here Yet!");
            nothing_here.setFont(new java.awt.Font("Montserrat", 0, 58)); 
            nothing_here.setForeground(Color.black);
            nothing_here.setBounds(504,333, nothing_here.getPreferredSize().width+30,nothing_here.getPreferredSize().height);
            contentPane.add(nothing_here);
            
            check_later.setText("Check it out later");
            check_later.setFont(new java.awt.Font("Montserrat", 0, 40)); 
            check_later.setForeground(Color.gray);
            check_later.setBounds(575,433, check_later.getPreferredSize().width+30,check_later.getPreferredSize().height);
            contentPane.add(check_later);
        }        
        
        // Create the scroll pane
        scrollPane = new JScrollPane();
        scrollPane.setBounds(80, 200, 1180, 480); // Set bounds for the scroll pane
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        contentPane.add(scrollPane);

        // Create the cloneable panel
        cloneablePanel = new JPanel(); // The initial panel inside scroll pane
        cloneablePanel.setLayout(null); // Use absolute layout
        cloneablePanel.setPreferredSize(new Dimension(400, 200)); // Set initial size
        cloneablePanel.setBounds(80, 200, 1200, 1500); // Set bounds for the initial panel
        cloneablePanel.setBackground(new Color(241, 241, 241));
        scrollPane.setViewportView(cloneablePanel); // Set this panel as viewport's view

        
        int row=0, column=0;

        for(int i=0; i<listOfQuizzes.size();i++){
            String id = listOfQuizzes.get(i).getId();
            String title = listOfQuizzes.get(i).getTitle();
            String duration = listOfQuizzes.get(i).getDuration();
            
            // Create a new cloned panel
            CloneablePanelStudent clonedPanel = new CloneablePanelStudent(40, Color.white, 2,id, title, duration);
            // Set your custom width and height for the cloned panel
            int panelWidth = 330;
            int panelHeight = 330;
            
            
            // Calculate the row and column indices
            row = i / 3;
            column = i % 3;

            // Calculate the x and y positions based on row and column indices
            int x = 10 + column * (panelWidth + 50);
            int y = 10 + row * (panelHeight + 50);

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
        }
        

        ImageIcon bgImage = new ImageIcon("src/App/img/background_studenthome.png");
        contentPane.setPreferredSize(new Dimension(bgImage.getIconWidth(), bgImage.getIconHeight()));
        
        //set components
        ButtonCustom logoutButton = new App.ButtonCustom();
        logoutButton.setForeground(new java.awt.Color(255, 255, 255));
        logoutButton.setText("Log out");
        logoutButton.setBorderColorNotOver(new java.awt.Color(57, 129, 247));
        logoutButton.setBorderColor(new java.awt.Color(57, 129, 247));
        logoutButton.setBorderColorOver(new java.awt.Color(57, 158, 255));
        logoutButton.setColor(new java.awt.Color(57, 129, 247));
        logoutButton.setColorClick(new java.awt.Color(57, 158, 255));
        logoutButton.setColorOver(new java.awt.Color(57, 158, 255));
        logoutButton.setColor2(Color.white);
        logoutButton.setColorOver2(Color.white);
        logoutButton.setColorClick2(Color.white);
        logoutButton.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        logoutButton.setRadius(30);
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
        logoutButton.setBounds(1120, 20, 130, 50);
        contentPane.add(logoutButton);
        
        
        contentPane.revalidate();
        contentPane.repaint();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        int a = JOptionPane.showConfirmDialog(getContentPane(), "Do you really want to log out?", "SELECT", JOptionPane.YES_OPTION);
        if(a==0){
            setVisible(false);
            new WelcomePage().setVisible(true);
        }
    }
    
    public void goToDetails(String quizId){
        setVisible(false);
        new QuizDetails(quizId, studentId).setVisible(true);
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
            java.util.logging.Logger.getLogger(StudentHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
