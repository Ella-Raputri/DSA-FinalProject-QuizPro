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
        JLabel title = new JLabel();
        title.setFont(new Font("Montserrat SemiBold", 0, 30));
        int titleHeight = setLabelTextWithLineBreaks(title, titleInput, 280);
        add(title);
        
        JLabel duration = new JLabel();
        duration.setFont(new Font("Montserrat", 0, 24));
        duration.setText(durationInput + " minutes");
        setComponentBounds(duration, 40, titleHeight+50, duration.getPreferredSize().width+10, duration.getPreferredSize().height);
        add(duration);
        
        buttonCustom deleteButton = new App.buttonCustom();
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
        
        
        buttonCustom editButton = new App.buttonCustom();
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
    
    public String[] splitWord(String str){
        int len = str.length()/10;
        if(str.length()%10 != 0){
            len+=1;
        }
        String[]wordCut = new String[len];
        
        for(int i=0; i<wordCut.length; i++){
            if(i==wordCut.length-1){
                wordCut[i] = str.substring(0+(10*i));
            }
            else{
                wordCut[i] = str.substring(0+(10*i), 9+(10*i));
            }
        }
        return wordCut;
    }

    
    public int setLabelTextWithLineBreaks(JLabel label, String text, int maxWidth) {
        // Split the text into words
        String[] wordsTemp = text.split(" ");
        StringBuilder newText = new StringBuilder();
        int currentWidth = 0;
        int lineHeight = label.getFontMetrics(label.getFont()).getHeight(); // Get the height of each line
        
        LinkedList<String> words = new LinkedList<>();
        for(int i=0; i<wordsTemp.length; i++){
            if(wordsTemp[i].length() > 10){
                String[]wordCut = splitWord(wordsTemp[i]);
                for(String w:wordCut){
                    words.add(w);
                }
            }
            else{
                words.add(wordsTemp[i]);
            }
        }
        
        // Iterate through words
        for (String word : words) {
            // Get the width of the current text with the new word
            int wordWidth = label.getFontMetrics(label.getFont()).stringWidth(word + " ");

            // Check if adding the new word exceeds the maximum width, including a space
            if (currentWidth + wordWidth > maxWidth) {
                // If the current word exceeds the maximum width, add a line break and start a new line
                newText.append("<br>").append(word).append(" ");
                currentWidth = wordWidth;
            } else {
                // Otherwise, add the word to the current line
                newText.append(word).append(" ");
                currentWidth += wordWidth;
            }
        }

        // Set the label text with line breaks
        label.setText("<html>" + newText.toString() + "</html>");

        // Adjust label bounds based on the wrapped text
        int labelWidth = Math.max(label.getPreferredSize().width, maxWidth); // Limit the width to maxWidth
        int labelHeight = ((int) Math.ceil((double) label.getPreferredSize().height / lineHeight) * lineHeight) + 40; // Adjust height to fit lines
        setComponentBounds(label, 40, 50, labelWidth, labelHeight); // Set new bounds for the label
        return labelHeight;
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

