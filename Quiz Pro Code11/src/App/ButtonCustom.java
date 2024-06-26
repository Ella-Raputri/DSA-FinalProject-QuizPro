package App;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class ButtonCustom extends JButton {
    
    //determine whether a button is being hovered or not
    public boolean isOver() {
        return over;
    }
    public void setOver(boolean over) {
        this.over = over;
    }
    
    //get background color
    public Color getColor() {
        return color;
    }
    
    //set background color
    public void setColor(Color color) {
        this.color = color;
        setBackground(color);
    }
    
    //get background color when being hovered
    public Color getColorOver() {
        return colorOver;
    }
    
    //set background color when being hovered
    public void setColorOver(Color colorOver) {
        this.colorOver = colorOver;
    }
    
    //get background color when being clicked
    public Color getColorClick() {
        return colorClick;
    }
    
    //set background color when being clicked
    public void setColorClick(Color colorClick) {
        this.colorClick = colorClick;
    }
    
    //get border color when is not being hovered
    public Color getBorderColorNotOver() {
        return borderColorNotOver;
    }
    
    //get text color
    public Color getColor2() {
        return color2;
    }
    
    //set text color
    public void setColor2(Color color2) {
        this.color2 = color2;
    }
    
    //get text color when being hovered
    public Color getColorOver2() {
        return colorOver2;
    }

    //set text color when being hovered
    public void setColorOver2(Color colorOver2) {
        this.colorOver2 = colorOver2;
    }
    
    //get text color when being clicked
    public Color getColorClick2() {
        return colorClick2;
    }
    
    //set text color when being clicked
    public void setColorClick2(Color colorClick2) {
        this.colorClick2 = colorClick2;
    }
    
    //get border color when being hovered
    public Color getBorderColorOver() {
        return borderColorOver;
    }
    
    //set border color when being hovered
    public void setBorderColorOver(Color borderColorOver) {
        this.borderColorOver = borderColorOver;
    }
    
    //set border color when not being hovered
    public void setBorderColorNotOver(Color borderColor) {
        this.borderColorNotOver = borderColor;
    }
    
    //set border color default
    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }
    
    //get radius for button
    public int getRadius() {
        return radius;
    }
    
    //set button radius
    public void setRadius(int radius) {
        this.radius = radius;
    }
    
    
    public ButtonCustom() {
        //  Init Color
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setColor(null);
        colorOver = null;
        colorClick = null;
        borderColorNotOver = null;
        color2 = null;
        colorOver2 = null;
        colorClick2 = null;
        borderColorOver = null;
        setContentAreaFilled(false);
        
        
        //  Add event mouse
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                setBackground(colorOver);
                setForeground(colorOver2);
                setBorderColor(borderColorOver);
                over = true;
            }

            @Override
            public void mouseExited(MouseEvent me) {
                setBackground(color);
                setForeground(color2);
                setBorderColor(borderColorNotOver);
                over = false;
            }

            @Override
            public void mousePressed(MouseEvent me) {
                setBackground(colorClick);
                setForeground(colorClick2);
                setBorderColor(borderColorOver);
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                if (over) {
                    setBackground(colorOver);
                    setForeground(colorOver2);
                    setBorderColor(borderColorOver);
                } else {
                    setBackground(color);
                    setForeground(color2);
                    setBorderColor(borderColorNotOver);
                }
            }
        });
    }

    private boolean over;
    private Color color;
    private Color colorOver;
    private Color colorClick;
    private Color color2;
    private Color colorOver2;
    private Color colorClick2;
    private Color borderColorOver;
    private Color borderColorNotOver;
    private Color borderColor;    
    private int radius = 0;

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //  Paint Border
        g2.setColor(borderColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        g2.setColor(getBackground());
        //  Border set 2 Pix
        g2.fillRoundRect(2, 2, getWidth() - 4, getHeight() - 4, radius, radius);
        super.paintComponent(grphcs);
    }
}
