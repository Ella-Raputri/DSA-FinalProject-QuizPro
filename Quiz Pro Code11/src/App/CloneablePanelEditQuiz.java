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
    private boolean required;

    public CloneablePanelEditQuiz(int borderRadius, Color bgColor, int borderWidth, String id, int qNumber, String question, String opt1, String opt2, String opt3, String opt4, String answer, boolean required) {
        //set up the panel
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
        this.required = required;
        setOpaque(false);

                
        // set components
        JLabel qNumLabel = new JLabel();
        qNumLabel.setFont(new Font("Montserrat SemiBold", 0, 30));
        qNumLabel.setText("QUESTION " +  qNumber);
        setComponentBounds(qNumLabel, 40, 20, qNumLabel.getPreferredSize().width+30, qNumLabel.getPreferredSize().height);
        add(qNumLabel);
        
        JLabel requiredLabel = new JLabel();
        requiredLabel.setFont(new Font("Montserrat SemiBold", 0, 32));
        requiredLabel.setText("*");
        requiredLabel.setForeground(Color.red);
        setComponentBounds(requiredLabel, qNumLabel.getX()+qNumLabel.getPreferredSize().width+8, 15, requiredLabel.getPreferredSize().width+30, requiredLabel.getPreferredSize().height);
        requiredLabel.setVisible(required);
        add(requiredLabel);
        
        JLabel qidLabel = new JLabel();
        qidLabel.setFont(new Font("Montserrat", 0, 24));
        qidLabel.setText("ID: " +  id);
        setComponentBounds(qidLabel, (1050-qidLabel.getPreferredSize().width), 22, qidLabel.getPreferredSize().width+30, qidLabel.getPreferredSize().height);
        add(qidLabel);
        
        WrappedLabel questionLabel = new WrappedLabel(1000);
        questionLabel.setText(question);
        questionLabel.setFont(new Font("Montserrat SemiBold", 0, 24));
        setComponentBounds(questionLabel, 40, 70, questionLabel.getPreferredSize().width+5, questionLabel.getPreferredSize().height);
        add(questionLabel);
        
        int opt1Height = questionLabel.getHeight()+questionLabel.getY()+30;
        int opt2Height = opt1Height+50;
        int opt3Height = opt2Height + 50;
        int opt4Height = opt3Height +50;

        JLabel checkmark1 = new JLabel();
        checkmark1.setIcon(new javax.swing.ImageIcon("src/App/img/checkmark.png"));
        setComponentBounds(checkmark1, 40, opt1Height+6, checkmark1.getPreferredSize().width+30, checkmark1.getPreferredSize().height);
        add(checkmark1);
        checkmark1.setVisible(false);
        
        JLabel checkmark2 = new JLabel();
        checkmark2.setIcon(new javax.swing.ImageIcon("src/App/img/checkmark.png"));
        setComponentBounds(checkmark2, 40, opt2Height+6, checkmark2.getPreferredSize().width+30, checkmark2.getPreferredSize().height);
        add(checkmark2);
        checkmark2.setVisible(false);
        
        JLabel checkmark3 = new JLabel();
        checkmark3.setIcon(new javax.swing.ImageIcon("src/App/img/checkmark.png"));
        setComponentBounds(checkmark3, 40, opt3Height+6, checkmark3.getPreferredSize().width+30, checkmark3.getPreferredSize().height);
        add(checkmark3);
        checkmark3.setVisible(false);
        
        JLabel checkmark4 = new JLabel();
        checkmark4.setIcon(new javax.swing.ImageIcon("src/App/img/checkmark.png"));
        setComponentBounds(checkmark4, 40, opt4Height+6, checkmark4.getPreferredSize().width+30, checkmark4.getPreferredSize().height);
        add(checkmark4);
        checkmark4.setVisible(false);
        
        JRadioButton opt1Label = new JRadioButton();
        opt1Label.setEnabled(false);
        opt1Label.setForeground(Color.black);
        opt1Label.setFont(new Font("Montserrat", 0, 22));
        opt1Label.setText(" " + opt1);
        setCircleRadio(opt1Label, 40, opt1Height);
        setComponentBounds(opt1Label, 40, opt1Height, opt1Label.getPreferredSize().width+30, opt1Label.getPreferredSize().height);
        add(opt1Label);
        
        JRadioButton opt2Label = new JRadioButton();
        opt2Label.setEnabled(false);
        opt2Label.setForeground(Color.black);
        opt2Label.setFont(new Font("Montserrat", 0, 22));
        opt2Label.setText(" " + opt2);
        setCircleRadio(opt2Label, 40, opt2Height);
        setComponentBounds(opt2Label, 40, opt2Height, opt2Label.getPreferredSize().width+30, opt2Label.getPreferredSize().height);
        add(opt2Label);
        
        JRadioButton opt3Label = new JRadioButton();
        opt3Label.setEnabled(false);
        opt3Label.setForeground(Color.black);
        opt3Label.setFont(new Font("Montserrat", 0, 22));
        opt3Label.setText(" " + opt3);
        setCircleRadio(opt3Label, 40, opt3Height);
        setComponentBounds(opt3Label, 40, opt3Height, opt3Label.getPreferredSize().width+30, opt3Label.getPreferredSize().height);
        add(opt3Label);
        
        JRadioButton opt4Label = new JRadioButton();
        opt4Label.setEnabled(false);
        opt4Label.setForeground(Color.black);
        opt4Label.setFont(new Font("Montserrat", 0, 22));
        opt4Label.setText(" " + opt4);
        setCircleRadio(opt4Label, 40, opt4Height);
        setComponentBounds(opt4Label, 40, opt4Height, opt4Label.getPreferredSize().width+30, opt4Label.getPreferredSize().height);
        add(opt4Label);
        
        
       //draw checkmark based on what option that is the answer
        if(answer.equals(opt1)){
            checkmark1.setVisible(true);
        }
        else if(answer.equals(opt2)){
            checkmark2.setVisible(true);
        }
        else if(answer.equals(opt3)){
            checkmark3.setVisible(true);
        }
        else if(answer.equals(opt4)){
            checkmark4.setVisible(true);
        }
        
    }
    
    //draw the radio button 
    private void setCircleRadio(JRadioButton rad, int xPos, int yPos){
        JLabel radIcon = new JLabel();
        radIcon.setIcon(new ImageIcon("src/App/img/circle_default.png"));
        
        setComponentBounds(radIcon, xPos, yPos+6, radIcon.getPreferredSize().width, radIcon.getPreferredSize().height);
        add(radIcon);
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

