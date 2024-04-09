package App;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main2 extends JFrame {
    private JTextField inputField;
    private JButton cloneButton;
    private JPanel panelContainer;

    public Main2() {
        setTitle("Panel Cloning Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        panelContainer = new JPanel();
        panelContainer.setLayout(new BoxLayout(panelContainer, BoxLayout.Y_AXIS));

        
                int numPanels = 2;
                clonePanels(numPanels);
        

        getContentPane().setLayout(new BorderLayout());
        
        getContentPane().add(panelContainer, BorderLayout.SOUTH);
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void clonePanels(int numPanels) {
        panelContainer.removeAll();
        for (int i = 0; i < numPanels; i++) {
            CloneablePanel newPanel = new CloneablePanel();
            panelContainer.add(newPanel);
        }
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main2();
            }
        });
    }
}