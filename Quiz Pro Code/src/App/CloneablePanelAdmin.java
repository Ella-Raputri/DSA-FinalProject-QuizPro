/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;
import DatabaseConnection.ConnectionProvider;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.LinkedList;
/**
 *
 * @author asus
 */
public class CloneablePanelAdmin extends JPanel{ 
    private static int panelCount = 0; 
    private static int borderRadius;
    private static Color bgColor;
    private static int borderWidth;
    private String id;
    private String titleInput;
    private String durationInput;

    public CloneablePanelAdmin(int borderRadius, Color bgColor, int borderWidth, String id, String titleInput, String durationInput) {
        setLayout(null);
        this.borderRadius = borderRadius;
        this.bgColor = bgColor;
        this.borderWidth = borderWidth;
        this.id = id;
        this.titleInput = titleInput;
        this.durationInput = durationInput;
        setOpaque(false);
             
                
        // Example content - you can add whatever components you need
        WrappedLabel title = new WrappedLabel(250);
        title.setText(titleInput);
        title.setFont(new Font("Montserrat SemiBold", 0, 30));
        setComponentBounds(title, 40, 60, title.getPreferredSize().width, title.getPreferredSize().height);
        add(title);
        
        
        JLabel duration = new JLabel();
        duration.setFont(new Font("Montserrat", 0, 24));
        duration.setText(durationInput + " minutes");
        setComponentBounds(duration, 40, title.getY()+title.getHeight()+15, duration.getPreferredSize().width+10, duration.getPreferredSize().height);
        add(duration);
        
        ButtonCustom deleteButton = new App.ButtonCustom();
        deleteButton.setBorder(null);
        deleteButton.setBorderColor(bgColor);
        deleteButton.setBorderColorOver(bgColor);
        deleteButton.setBorderColorNotOver(bgColor);
        deleteButton.setText("–");
        deleteButton.setColor2(new Color(57, 129, 247));
        deleteButton.setColor(bgColor);
        deleteButton.setColorClick2(new Color(54,96,160));
        deleteButton.setColorClick(Color.white);
        deleteButton.setColorOver(Color.white);
        deleteButton.setColorOver2(new Color(54,96,160));
        deleteButton.setForeground(new Color(57, 129, 247));
        deleteButton.setFont(new java.awt.Font("Montserrat Black", 0, 44)); 
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        setComponentBounds(deleteButton, 280, 10, deleteButton.getPreferredSize().width, deleteButton.getPreferredSize().height);
        add(deleteButton);
        
        
        ButtonCustom editButton = new App.ButtonCustom();
        editButton.setForeground(new java.awt.Color(255, 255, 255));
        editButton.setText("Edit");
        editButton.setBorderColorNotOver(new java.awt.Color(57, 129, 247));
        editButton.setBorderColor(new java.awt.Color(57, 129, 247));
        editButton.setBorderColorOver(new java.awt.Color(57, 158, 255));
        editButton.setColor(new java.awt.Color(57, 129, 247));
        editButton.setColorClick(new java.awt.Color(57, 158, 255));
        editButton.setColorOver(new java.awt.Color(57, 158, 255));
        editButton.setColor2(Color.white);
        editButton.setColorOver2(Color.white);
        editButton.setColorClick2(Color.white);
        editButton.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); 
        editButton.setRadius(30);
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        setComponentBounds(editButton, 210, 250, editButton.getPreferredSize().width+25, editButton.getPreferredSize().height+7);
        add(editButton);
        
    }
    
    public void setComponentBounds(Component component, int x, int y, int width, int height) {
        component.setBounds(x, y, width, height); // Set the position and size of the component
    }
    
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String str = "Do you really want to delete " + titleInput + "?";
        AdminHome home = (AdminHome) SwingUtilities.getWindowAncestor(this);
        
        int a = JOptionPane.showConfirmDialog(home.getContentPane(), str, "SELECT", JOptionPane.YES_OPTION);
        if(a==0){
            try{
                Connection con = ConnectionProvider.getCon();
                PreparedStatement ps = con.prepareStatement("delete from quiz where id=?");
                ps.setString(1, id);
                ps.executeUpdate();

                JOptionPane.showMessageDialog(home.getContentPane(), "Successfully deleted");
                home.reloadSelf();
            
            }catch(Exception e){
                JOptionPane.showMessageDialog(home.getContentPane(), e);
            }
        }
    }
    
    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        AdminHome home = (AdminHome) SwingUtilities.getWindowAncestor(this);
        home.goToEdit(id);
    }
    
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(bgColor); // Set background color
        // Fill the area inside the border with the background color
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), borderRadius, borderRadius);
        g2d.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        super.paintBorder(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.BLACK); // Set border color
        g2d.setStroke(new BasicStroke(borderWidth)); // Set border width
        g2d.drawRoundRect(borderWidth / 2, borderWidth / 2, getWidth() - borderWidth, getHeight() - borderWidth, borderRadius, borderRadius); // Adjust position and size based on border width
        g2d.dispose();
    }
}

