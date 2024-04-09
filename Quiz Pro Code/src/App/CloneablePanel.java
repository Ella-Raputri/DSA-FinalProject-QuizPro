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
public class CloneablePanel extends JPanel{ 
    private static int panelCount = 0; 

    public CloneablePanel() {
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 100;
        gbc.gridy = 100;
        gbc.weightx = 50;
        gbc.weighty = 50;
        gbc.fill = GridBagConstraints.BOTH;
        
                
        // Example content - you can add whatever components you need
        JLabel label = new JLabel("Panel " + panelCount++);
        add(label, gbc);
    }

    // Method to clone the panel
    public CloneablePanel clonePanel() {
        CloneablePanel clonedPanel = new CloneablePanel();
        
        // Additional setup for cloned panel if needed
        
        return clonedPanel;
    }
}

