/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import DatabaseConnection.ConnectionProvider;
import java.util.LinkedList;


/**
 *
 * @author asus
 */
public class AdminHome extends javax.swing.JFrame {
    private JPanel contentPane;
    private JPanel cloneablePanel;
    private JScrollPane scrollPane;


    public AdminHome() {
        initComponents();    
        myinit();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void myinit(){
        setResizable(false);
        setTitle("Admin Home Page");
        int totalElement = 0;
        LinkedList<String> idList = new LinkedList<>();
        
        try{
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("select count(id) from quiz");
            if(rs.first()){
                String temp = rs.getString(1);
                totalElement = Integer.parseInt(temp);
            }
            else{
                totalElement = 0;
            }
            
            
            ResultSet rs1 = st.executeQuery("select id from quiz");
            while(rs1.next()){
                String id = rs1.getString("id");
                idList.add(id);
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
                ImageIcon bgImage = new ImageIcon("src/App/img/background_adminhome.png");
                // Draw the background image
                g.drawImage(bgImage.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };
        contentPane.setLayout(null); // Use absolute layout
        setContentPane(contentPane);

        // Create the scroll pane
        scrollPane = new JScrollPane();
        scrollPane.setBounds(80, 200, 1180, 480); // Set bounds for the scroll pane
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);
        contentPane.add(scrollPane);

        // Create the cloneable panel
        cloneablePanel = new JPanel(); // The initial panel inside scroll pane
        cloneablePanel.setLayout(null); // Use absolute layout
        cloneablePanel.setPreferredSize(new Dimension(400, 200)); // Set initial size
        cloneablePanel.setBounds(80, 200, 1200, 1500); // Set bounds for the initial panel
        cloneablePanel.setBackground(new Color(224, 237, 255));
        scrollPane.setViewportView(cloneablePanel); // Set this panel as viewport's view

        
        int row=0, column=0;

        for(int i=0; i<totalElement;i++){
            String title = "";
            String duration = "";
            String id="";
            
            try{
                Connection con = ConnectionProvider.getCon();
                Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs1 = st.executeQuery("select * from quiz where id='"+idList.get(i)+"'");
                if(rs1.first()){
                    id = rs1.getString(1);
                    title = rs1.getString(2);
                    duration = rs1.getString(3);
                }
                else{
                    JOptionPane.showMessageDialog(getContentPane(), "null");
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(getContentPane(), e);
            }
            
            
            
            // Create a new cloned panel
            // Cloneable Panel
            CloneablePanelAdmin clonedPanel = new CloneablePanelAdmin(40, Color.white, 2,id, title, duration);
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
        

        ImageIcon bgImage = new ImageIcon("src/App/img/background_adminhome.png");
        contentPane.setPreferredSize(new Dimension(bgImage.getIconWidth(), bgImage.getIconHeight()));
        
        
        buttonCustom logoutButton = new App.buttonCustom();
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
        
        
        buttonCustom addButton = new App.buttonCustom();
        addButton.setBorder(null);
        addButton.setBorderColor(new Color(224, 237, 255));
        addButton.setBorderColorOver(new Color(224, 237, 255));
        addButton.setBorderColorNotOver(new Color(224, 237, 255));
        addButton.setText("+");
        addButton.setColor2(new Color(57, 129, 247));
        addButton.setColor(new Color(224, 237, 255));
        addButton.setColorClick2(new Color(54,96,160));
        addButton.setColorClick(new Color(224, 237, 255));
        addButton.setColorOver(new Color(224, 237, 255));
        addButton.setColorOver2(new Color(54,96,160));
        addButton.setForeground(new Color(57, 129, 247));
        addButton.setFont(new java.awt.Font("Montserrat Bold", 0, 70)); 
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        addButton.setBounds(1160, 110, 50, 50);
        contentPane.add(addButton);
        
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
    
    public static int open = 0;
    AdminHome home = (AdminHome) SwingUtilities.getRoot(this);
    
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if(open==0){
            new AddQuiz(home).setVisible(true);
            open=1;
        }
        else{
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf,"One form is already opened");
        }
    }
    
    public void reloadSelf(){
        setVisible(false);
        new AdminHome().setVisible(true);
    }
    
    public void goToEdit(String id){
        setVisible(false);
        new EditQuiz(id).setVisible(true);
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
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
