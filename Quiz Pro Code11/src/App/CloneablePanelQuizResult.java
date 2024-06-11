/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author asus
 */
public class CloneablePanelQuizResult extends JPanel{ 
    private static int panelCount = 0; 
    private static int borderRadius;
    private static Color bgColor;
    private static int borderWidth;
    private String username;
    private double score;
    private int labelHeight;

    public CloneablePanelQuizResult(int borderRadius, Color bgColor, int borderWidth, String username, double score) {
        //set panel
        setLayout(null);
        this.borderRadius = borderRadius;
        this.bgColor = bgColor;
        this.borderWidth = borderWidth;
        this.username = username;
        this.score = score;
        setOpaque(false);

                
        // set component
        WrappedLabel usernameLabel = new WrappedLabel(750);
        usernameLabel.setFont(new Font("Montserrat SemiBold", 0, 30));
        usernameLabel.setText(username);
        int lines = usernameLabel.getPreferredSize().height/37;
        setComponentBounds(usernameLabel, 50, 15*lines, usernameLabel.getPreferredSize().width+10, usernameLabel.getPreferredSize().height);
        add(usernameLabel);
        
        ButtonCustom scoreLabelSquare = new ButtonCustom();
        scoreLabelSquare.setBackground(new java.awt.Color(57, 129, 247));
        scoreLabelSquare.setForeground(new java.awt.Color(255, 255, 255));
        scoreLabelSquare.setText(String.valueOf(score));
        scoreLabelSquare.setBorderColor(new java.awt.Color(57, 129, 247));
        scoreLabelSquare.setBorderColorNotOver(new java.awt.Color(57, 129, 247));
        scoreLabelSquare.setBorderColorOver(new java.awt.Color(57, 129, 247));
        scoreLabelSquare.setColor(new java.awt.Color(57, 129, 247));
        scoreLabelSquare.setColor2(java.awt.Color.white);
        scoreLabelSquare.setColorClick(new java.awt.Color(57, 129, 247));
        scoreLabelSquare.setColorClick2(java.awt.Color.white);
        scoreLabelSquare.setColorOver(new java.awt.Color(57, 129, 247));
        scoreLabelSquare.setColorOver2(java.awt.Color.white);
        scoreLabelSquare.setFont(new java.awt.Font("Montserrat SemiBold", 0, 30)); 
        scoreLabelSquare.setRadius(30);
        labelHeight = (usernameLabel.getHeight()/37)*70;
        scoreLabelSquare.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        setComponentBounds(scoreLabelSquare, 800, 0, 240, labelHeight);
        add(scoreLabelSquare);    
    }
    
    
    public int returnLabelHeight(){
        return this.labelHeight;
    }
    
    
    public void setComponentBounds(Component component, int x, int y, int width, int height) {
        component.setBounds(x, y, width, height); // Set the position and size of the component
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

