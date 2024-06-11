/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
/**
 *
 * @author Asus
 */
public class SearchQuestion extends javax.swing.JFrame {
    private LinkedlistBenchmark quizList;
    private String quizid;
    private static Question current_question;
    private JPanel contentPane;
    private JPanel cloneablePanel;
    private JScrollPane scrollPane;
    private Linkedlist results = new Linkedlist();

    /**
     * Creates new form SearchQuestion
     */
    public SearchQuestion() {
        initComponents();
        myinit();
    }
    
    public SearchQuestion(LinkedlistBenchmark quizList, String quizid) {
        this.quizList = quizList;
        this.quizid = quizid;
        initComponents();
        myinit();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void myinit(){
        //set frame
        setResizable(false);
        setTitle("Search Question");
        
        //set background color
        getContentPane().setBackground(Color.white);
        
        //set components
        jLabel1 = new javax.swing.JLabel();
        backButton = new App.ButtonCustom();
        stringField = new RoundJTextField(15);
        search_icon = new javax.swing.JLabel();
        
        //set frame
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Custom close operation logic
                int option = JOptionPane.showConfirmDialog(getContentPane(), "Are you sure you want to end searching?", null, JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    setVisible(false);
                    EditQuiz.open = 0;
                } 
            }
        });
        setAlwaysOnTop(true);
        
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 540, 600));
        setFocusable(false);
        setForeground(java.awt.Color.white);
        setMaximumSize(new java.awt.Dimension(540, 600));
        setMinimumSize(new java.awt.Dimension(540, 600));
        
        // Create the content pane
        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load the background image
                ImageIcon bgImage = new ImageIcon("src/App/img/background_search_question.png");
                // Draw the background image
                g.drawImage(bgImage.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };
        contentPane.setLayout(null); // Use absolute layout
        setContentPane(contentPane);
        
        // Create the scroll pane
        scrollPane = new JScrollPane();
        scrollPane.setBounds(40, 130, 450, 370); // Set bounds for the scroll pane
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        contentPane.add(scrollPane);

        // Create the cloneable panel
        cloneablePanel = new JPanel(); // The initial panel inside scroll pane
        cloneablePanel.setLayout(null); // Use absolute layout
        cloneablePanel.setPreferredSize(new Dimension(400, 200)); // Set initial size
        cloneablePanel.setBounds(40, 130, 450, 400); // Set bounds for the initial panel
        cloneablePanel.setBackground(new Color(255,255,255));
        scrollPane.setViewportView(cloneablePanel); // Set this panel as viewport's view
        
        ImageIcon bgImage = new ImageIcon("src/App/img/background_search_question.png");
        contentPane.setPreferredSize(new Dimension(bgImage.getIconWidth(), bgImage.getIconHeight()));
        
        
        jLabel1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 36)); // NOI18N
        jLabel1.setText("<html><u>SEARCH QUESTION</u></html>");
        jLabel1.setBounds(80, 10, jLabel1.getPreferredSize().width+20, jLabel1.getPreferredSize().height);
        contentPane.add(jLabel1);

        backButton.setText("Back");
        backButton.setBackground(new java.awt.Color(255, 255, 255));
        backButton.setForeground(new java.awt.Color(57, 129, 247));
        backButton.setBorderColor(new java.awt.Color(57,129,247));
        backButton.setBorderColorNotOver(new java.awt.Color(57,129,247));
        backButton.setBorderColorOver(new java.awt.Color(41, 103, 197));
        backButton.setColor(java.awt.Color.white);
        backButton.setColor2(new java.awt.Color(57, 129, 247));
        backButton.setColorClick(new java.awt.Color(235, 235, 235));
        backButton.setColorClick2(new java.awt.Color(41, 103, 197));
        backButton.setColorOver(new java.awt.Color(235, 235, 235));
        backButton.setColorOver2(new java.awt.Color(41, 103, 197));
        backButton.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        backButton.setRadius(10);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        backButton.setBounds(30, 530, backButton.getPreferredSize().width+10, backButton.getPreferredSize().height+10);
        contentPane.add(backButton);

        stringField.setFont(new java.awt.Font("Montserrat", 0, 16)); // NOI18N
        stringField.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enterPressed");
        stringField.getActionMap().put("enterPressed", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                handleSearchID();
            }
        });
        stringField.setBounds(40, 75, 430, stringField.getPreferredSize().height+5);
        contentPane.add(stringField);

        search_icon.setIcon(new javax.swing.ImageIcon("src/App/img/search_id.png"));
        search_icon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleSearchID();
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                search_icon.setIcon(new javax.swing.ImageIcon("src/App/img/search_id_hover.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                search_icon.setIcon(new javax.swing.ImageIcon("src/App/img/search_id.png"));                
            }
        }); 
        search_icon.setBounds(stringField.getX()+stringField.getWidth()+5, 75, search_icon.getPreferredSize().width, search_icon.getPreferredSize().height);
        search_icon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        contentPane.add(search_icon);
        

        pack();
        setLocationRelativeTo(null);
    }
    
    
    //search id
    private void handleSearchID(){
        if (results != null && !results.isEmpty()){
            results.clearNodes();   //clear current result
        }
        
        //search for the substring
        String substr = stringField.getText();
        results = EditQuiz.quizlist.questionSearch(substr);
        
        //repaint the panels
        cloneablePanel.removeAll();
        scrollPane.revalidate();
        scrollPane.repaint();
        if (results == null){
            JOptionPane.showMessageDialog(getContentPane(), "Questions or answers that contain the inputted substring not found.");
        }
        else{
            showCloneablePanel(results);
        }
    }
    
    private void showCloneablePanel(Linkedlist result){
        int x=10;
        Linkedlist.Node currentQuestion = result.head;
        
        int totalElement = result.countNodes();

        int prevPanelHeight = 0;
        int prevY =0;
        
        for(int i=1; i<totalElement+1;i++){
            String id = currentQuestion.data.getQuestionID();
            int questionNumber = currentQuestion.data.getQuestionNumber();
            String question = currentQuestion.data.getQuestion();
            String option1 = currentQuestion.data.getOption1();
            String option2 = currentQuestion.data.getOption2();
            String option3 = currentQuestion.data.getOption3();
            String option4 = currentQuestion.data.getOption4();
            String answer = currentQuestion.data.getCorrectAnswer();
            boolean required = currentQuestion.data.getRequired();
            
            // Create a new cloned panel
            CloneablePanelSearchQuestion clonedPanel = new CloneablePanelSearchQuestion(40, Color.white, 2,id, questionNumber, question, option1, option2, option3, option4, answer, required);
            // Set your custom width and height for the cloned panel
            int panelWidth = 400;
            int panelHeight = clonedPanel.returnHeight();
            
            int y;
            if(i==1){
                y=5;
                prevY=5;
            }
            else{
                int newY = prevY + prevPanelHeight +40;
                y = newY;
                prevY = newY;
            }
            
            
            prevPanelHeight = panelHeight;
            
            // Set the bounds for the cloned panel with your custom size
            clonedPanel.setBounds(x, y, panelWidth, panelHeight);
            clonedPanel.setBackground(Color.white);
            
            // Add the cloned panel to the initial panel
            cloneablePanel.add(clonedPanel);
            // Adjust preferred size of initial panel to include new panel
            Dimension newSize = new Dimension(cloneablePanel.getWidth(), y + panelHeight + 20); // Adjusted size
            cloneablePanel.setPreferredSize(newSize);
            // Ensure the scroll pane updates its viewport
            scrollPane.revalidate();
            scrollPane.repaint();
            // Scroll to show the new panel
            scrollPane.getVerticalScrollBar().setValue(0);
            
            currentQuestion = currentQuestion.next;
        }
    }
    
    
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        int option = JOptionPane.showConfirmDialog(getContentPane(), "Are you sure you want to end searching?", null, JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            setVisible(false);
            EditQuiz.open = 0;
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SearchQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchQuestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchQuestion().setVisible(true);
            }
        });
    }
    
    
    private App.ButtonCustom backButton;
    private javax.swing.JTextField stringField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel search_icon;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
