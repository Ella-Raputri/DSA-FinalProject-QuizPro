/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import java.awt.*;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

/**
 *
 * @author asus
 */
public class AdminHome22 extends javax.swing.JFrame {
    
    
    private JPanel contentPane;


    public AdminHome22() {
        initComponents();    
        myinit();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void myinit(){
        setTitle("Cloneable Panel Example");

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
        
               
        int x = 100;
        int y = 100;
        for(int i=1; i<=10; i++){
            CloneablePanel clonedPanel = new CloneablePanel();
            // Set bounds for the cloned panel
            clonedPanel.setBounds(x*i, y*i, clonedPanel.getPreferredSize().width, clonedPanel.getPreferredSize().height);
            // Add the cloned panel to the content pane
            contentPane.add(clonedPanel);
            // Ensure panel visibility
            clonedPanel.setVisible(true);
            // Revalidate and repaint to update the layout
            contentPane.revalidate();
            contentPane.repaint();
        }
            

//        // Create the button
//        cloneButton = new JButton("Clone Panel");
//        cloneButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                CloneablePanel clonedPanel = new CloneablePanel();
//                // Set bounds for the cloned panel
//                clonedPanel.setBounds(100, 100, clonedPanel.getPreferredSize().width, clonedPanel.getPreferredSize().height);
//                // Add the cloned panel to the content pane
//                contentPane.add(clonedPanel);
//                // Ensure panel visibility
//                clonedPanel.setVisible(true);
//                // Revalidate and repaint to update the layout
//                contentPane.revalidate();
//                contentPane.repaint();
//            }
//        });
//        
//        cloneButton.setBounds(10, 10, 120, 30); // Set button bounds
//        contentPane.add(cloneButton);
        
        
        ImageIcon bgImage = new ImageIcon("src/App/img/background_adminhome.png");
        contentPane.setPreferredSize(new Dimension(bgImage.getIconWidth(), bgImage.getIconHeight()));
        
        
        buttonCustom logoutButton = new App.buttonCustom();
        logoutButton.setBorder(null);
        logoutButton.setForeground(new java.awt.Color(255, 255, 255));
        logoutButton.setText("Log out");
        logoutButton.setBorderColor(new java.awt.Color(57, 129, 247));
        logoutButton.setColor(new java.awt.Color(57, 129, 247));
        logoutButton.setColorClick(new java.awt.Color(57, 158, 255));
        logoutButton.setColorOver(new java.awt.Color(57, 158, 255));
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
            java.util.logging.Logger.getLogger(AdminHome22.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminHome22.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminHome22.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminHome22.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminHome22().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
