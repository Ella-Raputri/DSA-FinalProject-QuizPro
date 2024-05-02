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
public class CloneablePanelStudent extends JPanel{ 
    private static int panelCount = 0; 
    private static int borderRadius;
    private static Color bgColor;
    private static int borderWidth;
    private String id;
    private String titleInput;
    private String durationInput;

    public CloneablePanelStudent(int borderRadius, Color bgColor, int borderWidth, String id, String titleInput, String durationInput) {
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
        
        
        ButtonCustom startButton = new App.ButtonCustom();
        startButton.setForeground(new java.awt.Color(255, 255, 255));
        startButton.setText("Start");
        startButton.setBorderColorNotOver(new java.awt.Color(57, 129, 247));
        startButton.setBorderColor(new java.awt.Color(57, 129, 247));
        startButton.setBorderColorOver(new java.awt.Color(57, 158, 255));
        startButton.setColor(new java.awt.Color(57, 129, 247));
        startButton.setColorClick(new java.awt.Color(57, 158, 255));
        startButton.setColorOver(new java.awt.Color(57, 158, 255));
        startButton.setColor2(Color.white);
        startButton.setColorOver2(Color.white);
        startButton.setColorClick2(Color.white);
        startButton.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); 
        startButton.setRadius(30);
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });
        setComponentBounds(startButton, 200, 250, startButton.getPreferredSize().width+25, startButton.getPreferredSize().height+7);
        add(startButton);
        
    }

    
    public void setComponentBounds(Component component, int x, int y, int width, int height) {
        component.setBounds(x, y, width, height); // Set the position and size of the component
    }
    
    private static boolean checkColumn(StudentHome home, String quizID){
        try{
            Connection con = ConnectionProvider.getCon();
            DatabaseMetaData md = con.getMetaData();
            ResultSet rs = md.getColumns(null, null, "student", quizID);
            if (rs.next()) {
                return true;
            }
            else{
                return false;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(home.getContentPane(), e);
        }
        return false;
    }
    
    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        StudentHome home = (StudentHome) SwingUtilities.getWindowAncestor(this);
        boolean check = checkColumn(home, id);
        
        if(!check){
            try{
                Connection con = ConnectionProvider.getCon();

                PreparedStatement ps = con.prepareStatement("ALTER TABLE student ADD " + id + " double(10,2)"); 
                ps.executeUpdate();

            }catch(Exception e){
                JOptionPane.showMessageDialog(home.getContentPane(), e);
            }
        }
        
        home.goToDetails(id);

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

