/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;
import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
/**
 *
 * @author asus
 */
public class CloneablePanelSearchQuestion extends JPanel{ 
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
    private JRadioButton opt4Label;
    private boolean required;

    public CloneablePanelSearchQuestion(int borderRadius, Color bgColor, int borderWidth, String id, int qNumber, String question, String opt1, String opt2, String opt3, String opt4, String answer, boolean required) {
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

                
        // Example content - you can add whatever components you need
        JLabel qNumLabel = new JLabel();
        qNumLabel.setFont(new Font("Montserrat SemiBold", 0, 22));
        qNumLabel.setText("QUESTION " +  qNumber);
        setComponentBounds(qNumLabel, 15, 15, qNumLabel.getPreferredSize().width+30, qNumLabel.getPreferredSize().height);
        add(qNumLabel);
        
        JLabel qidLabel = new JLabel();
        qidLabel.setFont(new Font("Montserrat", 0, 18));
        qidLabel.setText("ID: " +  id);
        setComponentBounds(qidLabel, (400-qidLabel.getPreferredSize().width-35), 18, qidLabel.getPreferredSize().width+30, qidLabel.getPreferredSize().height);
        add(qidLabel);
        
        WrappedLabel questionLabel = new WrappedLabel(360);
        questionLabel.setText(question);
        questionLabel.setFont(new Font("Montserrat SemiBold", 0, 20));
        setComponentBounds(questionLabel, 15, 55, questionLabel.getPreferredSize().width, questionLabel.getPreferredSize().height);
        add(questionLabel);
        
        JLabel requiredLabel = new JLabel();
        requiredLabel.setFont(new Font("Montserrat SemiBold", 0, 24));
        requiredLabel.setText("*");
        requiredLabel.setForeground(Color.red);
        setComponentBounds(requiredLabel, qNumLabel.getX()+qNumLabel.getPreferredSize().width+8, 15, requiredLabel.getPreferredSize().width+30, requiredLabel.getPreferredSize().height);
        requiredLabel.setVisible(required);
        add(requiredLabel);
        
        
        int opt1Height = questionLabel.getHeight()+70;
        int opt2Height = opt1Height+40;
        int opt3Height = opt2Height + 40;
        int opt4Height = opt3Height +40;

        
        JLabel checkmark1 = new JLabel();
        checkmark1.setIcon(new javax.swing.ImageIcon("src/App/img/checkmark2.png"));
        setComponentBounds(checkmark1, 15, opt1Height+4, checkmark1.getPreferredSize().width+30, checkmark1.getPreferredSize().height);
        add(checkmark1);
        checkmark1.setVisible(false);
        
        JLabel checkmark2 = new JLabel();
        checkmark2.setIcon(new javax.swing.ImageIcon("src/App/img/checkmark2.png"));
        setComponentBounds(checkmark2, 15, opt2Height+4, checkmark2.getPreferredSize().width+30, checkmark2.getPreferredSize().height);
        add(checkmark2);
        checkmark2.setVisible(false);
        
        JLabel checkmark3 = new JLabel();
        checkmark3.setIcon(new javax.swing.ImageIcon("src/App/img/checkmark2.png"));
        setComponentBounds(checkmark3, 15, opt3Height+4, checkmark3.getPreferredSize().width+30, checkmark3.getPreferredSize().height);
        add(checkmark3);
        checkmark3.setVisible(false);
        
        JLabel checkmark4 = new JLabel();
        checkmark4.setIcon(new javax.swing.ImageIcon("src/App/img/checkmark2.png"));
        setComponentBounds(checkmark4, 15, opt4Height+4, checkmark4.getPreferredSize().width+30, checkmark4.getPreferredSize().height);
        add(checkmark4);
        checkmark4.setVisible(false);
        
        
        JRadioButton opt1Label = new JRadioButton();
        opt1Label.setEnabled(false);
        opt1Label.setForeground(Color.black);
        opt1Label.setFont(new Font("Montserrat", 0, 18));
        opt1Label.setText(opt1);
        setComponentBounds(opt1Label, 15, opt1Height, opt1Label.getPreferredSize().width+30, opt1Label.getPreferredSize().height);
        add(opt1Label);
        
        JRadioButton opt2Label = new JRadioButton();
        opt2Label.setEnabled(false);
        opt2Label.setForeground(Color.black);
        opt2Label.setFont(new Font("Montserrat", 0, 18));
        opt2Label.setText(opt2);
        setComponentBounds(opt2Label, 15, opt2Height, opt2Label.getPreferredSize().width+30, opt2Label.getPreferredSize().height);
        add(opt2Label);
        
        JRadioButton opt3Label = new JRadioButton();
        opt3Label.setEnabled(false);
        opt3Label.setForeground(Color.black);
        opt3Label.setFont(new Font("Montserrat", 0, 18));
        opt3Label.setText(opt3);
        setComponentBounds(opt3Label, 15, opt3Height, opt3Label.getPreferredSize().width+30, opt3Label.getPreferredSize().height);
        add(opt3Label);
        
        JRadioButton opt4Label = new JRadioButton();
        opt4Label.setEnabled(false);
        opt4Label.setForeground(Color.black);
        opt4Label.setFont(new Font("Montserrat", 0, 18));
        opt4Label.setText(opt4);
        setComponentBounds(opt4Label, 15, opt4Height, opt4Label.getPreferredSize().width+30, opt4Label.getPreferredSize().height);
        add(opt4Label);
        this.opt4Label = opt4Label;
        
        
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
    
    public int returnHeight(){
        int lastHeight = opt4Label.getY() + opt4Label.getHeight() + 40;
        return lastHeight;
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

