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
public class CloneablePanelEditQuiz extends JPanel{ 
    private static int panelCount = 0; 
    private static int borderRadius;
    private static Color bgColor;
    private static int borderWidth;
    private String id;
    private int qNumber;
    private String question;
    private String opt1;
    private String opt2;
    private String opt3;
    private String opt4;
    private String answer;

    public CloneablePanelEditQuiz(int borderRadius, Color bgColor, int borderWidth, String id, int qNumber, String question, String opt1, String opt2, String opt3, String opt4, String answer) {
        setLayout(null);
        this.borderRadius = borderRadius;
        this.bgColor = bgColor;
        this.borderWidth = borderWidth;
        this.id = id;
        this.qNumber = qNumber;
        this.question = question;
        this.opt1 = opt1;
        this.opt2 = opt2;
        this.opt3 = opt3;
        this.opt4 = opt4;
        this.answer = answer;
        setOpaque(false);
             
                
        // Example content - you can add whatever components you need
        JLabel qNumLabel = new JLabel();
        qNumLabel.setFont(new Font("Montserrat SemiBold", 0, 32));
        qNumLabel.setText("QUESTION " +  qNumber);
        setComponentBounds(qNumLabel, 40, 20, qNumLabel.getPreferredSize().width+30, qNumLabel.getPreferredSize().height);
        add(qNumLabel);
        
        JLabel qidLabel = new JLabel();
        qidLabel.setFont(new Font("Montserrat", 0, 28));
        qidLabel.setText("ID: " +  id);
        setComponentBounds(qidLabel, (1050-qidLabel.getPreferredSize().width), 25, qidLabel.getPreferredSize().width+30, qidLabel.getPreferredSize().height);
        add(qidLabel);
        
        JLabel questionLabel = new JLabel();
        questionLabel.setFont(new Font("Montserrat", 0, 28));
        int questionLabelHeight = setLabelTextWithLineBreaks(questionLabel, question, 1020);
        add(questionLabel);
        
        JRadioButton opt1Label = new JRadioButton();
        opt1Label.setEnabled(false);
        opt1Label.setForeground(Color.black);
        opt1Label.setFont(new Font("Montserrat", 0, 24));
        opt1Label.setText(opt1);
        setComponentBounds(opt1Label, 40, questionLabelHeight+70, opt1Label.getPreferredSize().width+30, opt1Label.getPreferredSize().height);
        add(opt1Label);
        
        JRadioButton opt2Label = new JRadioButton();
        opt2Label.setEnabled(false);
        opt2Label.setForeground(Color.black);
        opt2Label.setFont(new Font("Montserrat", 0, 24));
        opt2Label.setText(opt2);
        setComponentBounds(opt2Label, 40, questionLabelHeight+127, opt2Label.getPreferredSize().width+30, opt2Label.getPreferredSize().height);
        add(opt2Label);
        
        JRadioButton opt3Label = new JRadioButton();
        opt3Label.setEnabled(false);
        opt3Label.setForeground(Color.black);
        opt3Label.setFont(new Font("Montserrat", 0, 24));
        opt3Label.setText(opt3);
        setComponentBounds(opt3Label, 40, questionLabelHeight+184, opt3Label.getPreferredSize().width+30, opt3Label.getPreferredSize().height);
        add(opt3Label);
        
        JRadioButton opt4Label = new JRadioButton();
        opt4Label.setEnabled(false);
        opt4Label.setForeground(Color.black);
        opt4Label.setFont(new Font("Montserrat", 0, 24));
        opt4Label.setText(opt4);
        setComponentBounds(opt4Label, 40, questionLabelHeight+241, opt4Label.getPreferredSize().width+30, opt4Label.getPreferredSize().height);
        add(opt4Label);
        
        
        if(answer.equals(opt1)){
            opt1Label.setSelected(true);
        }
        else if(answer.equals(opt2)){
            opt2Label.setSelected(true);
        }
        else if(answer.equals(opt3)){
            opt3Label.setSelected(true);
        }
        else if(answer.equals(opt4)){
            opt4Label.setSelected(true);
        }
        
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
        setComponentBounds(label, 40, 60, labelWidth, labelHeight); // Set new bounds for the label
        return labelHeight;
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

