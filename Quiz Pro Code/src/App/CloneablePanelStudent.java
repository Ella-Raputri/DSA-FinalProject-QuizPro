/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;
import DatabaseConnection.ConnectionProvider;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
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
        JLabel title = new JLabel();
        title.setFont(new Font("Montserrat SemiBold", 0, 30));
        int titleHeight = setLabelTextWithLineBreaks(title, titleInput, 280);
        add(title);
        
        JLabel duration = new JLabel();
        duration.setFont(new Font("Montserrat", 0, 24));
        duration.setText(durationInput + " minutes");
        setComponentBounds(duration, 40, titleHeight+90, duration.getPreferredSize().width+10, duration.getPreferredSize().height);
        add(duration);
        
        
        buttonCustom startButton = new App.buttonCustom();
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
    
    
    public int setLabelTextWithLineBreaks(JLabel label, String text, int maxWidth) {
        // Split the text into words
        String[] words = text.split(" ");
        StringBuilder newText = new StringBuilder();
        int currentWidth = 0;
        int lineHeight = label.getFontMetrics(label.getFont()).getHeight(); // Get the height of each line

        // Iterate through words
        for (String word : words) {
            // Get the width of the current text with the new word
            int wordWidth = label.getFontMetrics(label.getFont()).stringWidth(word + " ");

            // If adding the new word exceeds the maximum width, add a line break
            if (currentWidth + wordWidth > maxWidth) {
                newText.append("<br>");
                currentWidth = 0;
            }

            // Add the word to the text
            newText.append(word).append(" ");
            currentWidth += wordWidth;
        }

        // Set the label text with line breaks
        label.setText("<html>" + newText.toString() + "</html>");

        // Adjust label bounds based on the wrapped text
        int labelWidth = Math.min(label.getPreferredSize().width, maxWidth); // Limit the width to maxWidth
        int labelHeight = (int) Math.ceil((double) label.getPreferredSize().height / lineHeight) * lineHeight; // Adjust height to fit lines
        setComponentBounds(label, 40, 70, labelWidth, labelHeight); // Set new bounds for the label
        return labelHeight;
    }
    
    public void setComponentBounds(Component component, int x, int y, int width, int height) {
        component.setBounds(x, y, width, height); // Set the position and size of the component
    }
    
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String str = "Do you really want to delete " + titleInput + "?";
        int a = JOptionPane.showConfirmDialog(null, str, "SELECT", JOptionPane.YES_OPTION);
        if(a==0){
            try{
                Connection con = ConnectionProvider.getCon();
                PreparedStatement ps = con.prepareStatement("delete from quiz where id=?");
                ps.setString(1, id);
                ps.executeUpdate();

                JOptionPane.showMessageDialog(null, "Successfully deleted");
                AdminHome home = (AdminHome) SwingUtilities.getWindowAncestor(this);
                home.reloadSelf();
            
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    
    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
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

