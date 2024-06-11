/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;


import DatabaseConnection.ConnectionProvider;
import java.sql.Connection;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
/**
 *
 * @author asus
 */
public class EditQuiz extends javax.swing.JFrame {
    public static int open = 0;
    public static LinkedlistBenchmark quizlist = new LinkedlistBenchmark();
    public static String quizID;
    private JPanel contentPane;
    public static JPanel cloneablePanel;
    public static JScrollPane scrollPane;
    
    /**
     * Creates new form WelcomePage
     */
    public EditQuiz() {
        updateLinkedList(EditQuiz.quizlist);
        initComponents();        
    }
    
    public EditQuiz(String quizId){
        EditQuiz.quizID = quizId;
        updateLinkedList(EditQuiz.quizlist);
        initComponents();
        myinit();
    }
    
    //to ensure the linked list is up to date after many operations
    private void updateLinkedList(LinkedlistBenchmark list){
        quizlist.quiz.clearNodes();     //clear current linked list
        
        //retrieve new data from database
        try{
            Connection con = ConnectionProvider.getCon();
            String query = "SELECT * FROM question WHERE quizID = ? ORDER BY number ASC";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, EditQuiz.quizID);
            
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                String qID = rs.getString("id");
                String quest = rs.getString("question");
                String ans = rs.getString("answer");
                String opt1 = rs.getString("option1");
                String opt2 = rs.getString("option2");
                String opt3 = rs.getString("option3");
                String opt4 = rs.getString("option4");
                boolean required = rs.getBoolean("required");
                
                list.addQuestionUpdate(quest, ans, EditQuiz.quizID, opt1, opt2, opt3, opt4, required);
                Linkedlist.Node tail_node = list.quiz.tail;
                tail_node.data.setQuestionID(qID);
            }
        }
        catch(Exception e){
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, e);
        }
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void myinit(){
        //set frame
        setResizable(false);
        setTitle("Edit Quiz Page");
        int totalElement = 0;
        
        //get total element from the linked list
        Linkedlist.Node current = EditQuiz.quizlist.quiz.head;
        while(current!=null){
            totalElement++;
            current = current.next;
        }    

        // Create the content pane
        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load the background image
                ImageIcon bgImage = new ImageIcon("src/App/img/background_edit_quiz.png");
                // Draw the background image
                g.drawImage(bgImage.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };
        contentPane.setLayout(null); // Use absolute layout
        setContentPane(contentPane);
        
        noQuestion = new JLabel();
        clickToAdd = new JLabel();
        plane_icon = new JLabel();
        
        plane_icon.setIcon(new javax.swing.ImageIcon("src/App/img/paperplane1.png"));
        plane_icon.setBounds(130,300,plane_icon.getPreferredSize().width+30,plane_icon.getPreferredSize().height);
        contentPane.add(plane_icon);

        noQuestion.setText("No question is available.");
        noQuestion.setFont(new java.awt.Font("Montserrat", 0, 20)); 
        noQuestion.setForeground(Color.black);
        noQuestion.setBounds(530,430, noQuestion.getPreferredSize().width+30,noQuestion.getPreferredSize().height);
        contentPane.add(noQuestion);

        clickToAdd.setText("Click to add questions");
        clickToAdd.setFont(new java.awt.Font("Montserrat", 0, 20)); 
        clickToAdd.setForeground(Color.gray);
        clickToAdd.setBounds(530,460, clickToAdd.getPreferredSize().width+30,clickToAdd.getPreferredSize().height);
        contentPane.add(clickToAdd);
        showEmptyIcon(totalElement);
        
        // Create the scroll pane
        scrollPane = new JScrollPane();
        scrollPane.setBounds(60, 300, 1180, 390); // Set bounds for the scroll pane
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        contentPane.add(scrollPane);

        // Create the cloneable panel
        cloneablePanel = new JPanel(); // The initial panel inside scroll pane
        cloneablePanel.setLayout(null); // Use absolute layout
        cloneablePanel.setPreferredSize(new Dimension(400, 200)); // Set initial size
        cloneablePanel.setBounds(60, 300, 1200, 1500); // Set bounds for the initial panel
        cloneablePanel.setBackground(new Color(224, 237, 255));
        scrollPane.setViewportView(cloneablePanel); // Set this panel as viewport's view

        
        showCloneablePanel(totalElement);
        
        // set background
        ImageIcon bgImage = new ImageIcon("src/App/img/background_edit_quiz.png");
        contentPane.setPreferredSize(new Dimension(bgImage.getIconWidth(), bgImage.getIconHeight()));
        
        //initialize components
        backButton = new App.ButtonCustom();
        changeOrder_icon = new javax.swing.JLabel();
        result_icon = new javax.swing.JLabel();
        changeOrderButton = new App.ButtonCustom();
        resultButton = new App.ButtonCustom();
        LogoutButton = new App.ButtonCustom();
        search_icon = new javax.swing.JLabel();
        searchButton = new App.ButtonCustom();
        edit_icon = new javax.swing.JLabel();
        editButton = new App.ButtonCustom();
        delete_icon = new javax.swing.JLabel();
        deleteButton = new App.ButtonCustom();
        add_icon = new javax.swing.JLabel();
        addButton = new App.ButtonCustom();
        jLabel3 = new javax.swing.JLabel();
        titleField = new javax.swing.JTextField();
        editTitle = new App.ButtonCustom();
        editTitleDone = new App.ButtonCustom();
        editTitleCancel = new App.ButtonCustom();
        durationField = new javax.swing.JTextField();
        editDuration = new App.ButtonCustom();
        editDurationDone = new App.ButtonCustom();
        editDurationCancel = new App.ButtonCustom();
        minuteLabel = new javax.swing.JLabel();
        
        backButton.setBackground(new java.awt.Color(255, 255, 255));
        backButton.setForeground(new java.awt.Color(57, 129, 247));
        backButton.setBorderColor(new java.awt.Color(248, 248, 248));
        backButton.setBorderColorNotOver(java.awt.Color.white);
        backButton.setBorderColorOver(new java.awt.Color(242, 242, 242));
        backButton.setColor(java.awt.Color.white);
        backButton.setColor2(new java.awt.Color(57, 129, 247));
        backButton.setColorClick(new java.awt.Color(235, 235, 235));
        backButton.setColorClick2(new java.awt.Color(41, 103, 197));
        backButton.setColorOver(new java.awt.Color(235, 235, 235));
        backButton.setColorOver2(new java.awt.Color(41, 103, 197));
        backButton.setFont(new java.awt.Font("Montserrat SemiBold", 0, 32)); // NOI18N
        backButton.setText("< Back");
        backButton.setMaximumSize(new java.awt.Dimension(143, 68));
        backButton.setMinimumSize(new java.awt.Dimension(143, 68));
        backButton.setPreferredSize(new java.awt.Dimension(143, 68));
        backButton.setRadius(30);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        backButton.setBounds(20, 20, 160,60);
        contentPane.add(backButton);
        
        
        changeOrder_icon.setFont(new java.awt.Font("Montserrat", 1, 48)); // NOI18N
        changeOrder_icon.setForeground(new java.awt.Color(255, 255, 255));
        changeOrder_icon.setIcon(new javax.swing.ImageIcon("src/App/img/change_order.png"));
        changeOrder_icon.setBounds(500, 230, 40, 40);
        contentPane.add(changeOrder_icon);

        result_icon.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        result_icon.setForeground(new java.awt.Color(255, 255, 255));
        result_icon.setIcon(new javax.swing.ImageIcon("src/App/img/result.png"));
        result_icon.setText("sss");
        result_icon.setBounds(1070,230,30,40);
        contentPane.add(result_icon);

        changeOrderButton.setBackground(new java.awt.Color(57, 129, 247));
        changeOrderButton.setForeground(new java.awt.Color(255, 255, 255));
        changeOrderButton.setText("Change Order");
        changeOrderButton.setBorderColor(new java.awt.Color(57, 129, 247));
        changeOrderButton.setBorderColorNotOver(new java.awt.Color(57, 129, 247));
        changeOrderButton.setBorderColorOver(new java.awt.Color(57, 158, 255));
        changeOrderButton.setColor(new java.awt.Color(57, 129, 247));
        changeOrderButton.setColor2(java.awt.Color.white);
        changeOrderButton.setColorClick(new java.awt.Color(57, 158, 255));
        changeOrderButton.setColorClick2(java.awt.Color.white);
        changeOrderButton.setColorOver(new java.awt.Color(57, 158, 255));
        changeOrderButton.setColorOver2(java.awt.Color.white);
        changeOrderButton.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        changeOrderButton.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        changeOrderButton.setMaximumSize(new java.awt.Dimension(143, 68));
        changeOrderButton.setMinimumSize(new java.awt.Dimension(143, 68));
        changeOrderButton.setPreferredSize(new java.awt.Dimension(143, 68));
        changeOrderButton.setRadius(60);
        changeOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeOrderButtonActionPerformed(evt);
            }
        });
        changeOrderButton.setBounds(480,220,240,60);
        contentPane.add(changeOrderButton);

        resultButton.setBackground(new java.awt.Color(255, 255, 255));
        resultButton.setForeground(new java.awt.Color(57, 129, 247));
        resultButton.setText("Result");
        resultButton.setBorderColor(new java.awt.Color(255, 255, 255));
        resultButton.setBorderColorNotOver(java.awt.Color.white);
        resultButton.setBorderColorOver(new java.awt.Color(235, 235, 235));
        resultButton.setColor(java.awt.Color.white);
        resultButton.setColor2(new java.awt.Color(57, 129, 247));
        resultButton.setColorClick(new java.awt.Color(235, 235, 235));
        resultButton.setColorClick2(new java.awt.Color(54, 96, 160));
        resultButton.setColorOver(new java.awt.Color(235, 235, 235));
        resultButton.setColorOver2(new java.awt.Color(54, 96, 160));
        resultButton.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        resultButton.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        resultButton.setMaximumSize(new java.awt.Dimension(143, 68));
        resultButton.setMinimumSize(new java.awt.Dimension(143, 68));
        resultButton.setPreferredSize(new java.awt.Dimension(143, 68));
        resultButton.setRadius(60);
        resultButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultButtonActionPerformed(evt);
            }
        });
        resultButton.setBounds(1050,220,150,60);
        contentPane.add(resultButton);

        LogoutButton.setBackground(new java.awt.Color(57, 129, 247));
        LogoutButton.setForeground(new java.awt.Color(255, 255, 255));
        LogoutButton.setText("Log Out");
        LogoutButton.setBorderColor(new java.awt.Color(57, 129, 247));
        LogoutButton.setBorderColorNotOver(new java.awt.Color(57, 129, 247));
        LogoutButton.setBorderColorOver(new java.awt.Color(57, 158, 255));
        LogoutButton.setColor(new java.awt.Color(57, 129, 247));
        LogoutButton.setColor2(java.awt.Color.white);
        LogoutButton.setColorClick(new java.awt.Color(57, 158, 255));
        LogoutButton.setColorClick2(java.awt.Color.white);
        LogoutButton.setColorOver(new java.awt.Color(57, 158, 255));
        LogoutButton.setColorOver2(java.awt.Color.white);
        LogoutButton.setFont(new java.awt.Font("Montserrat SemiBold", 0, 30)); // NOI18N
        LogoutButton.setMaximumSize(new java.awt.Dimension(143, 68));
        LogoutButton.setMinimumSize(new java.awt.Dimension(143, 68));
        LogoutButton.setPreferredSize(new java.awt.Dimension(143, 68));
        LogoutButton.setRadius(30);
        LogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutButtonActionPerformed(evt);
            }
        });
        LogoutButton.setBounds(1070, 20,170,60);
        contentPane.add(LogoutButton);

        search_icon.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        search_icon.setForeground(new java.awt.Color(57, 129, 247));
        search_icon.setIcon(new javax.swing.ImageIcon("src/App/img/search.png"));
        search_icon.setBounds(740,230,30,40);
        contentPane.add(search_icon);

        searchButton.setBackground(new java.awt.Color(57, 129, 247));
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setText("Search");
        searchButton.setBorderColor(new java.awt.Color(57, 129, 247));
        searchButton.setBorderColorNotOver(new java.awt.Color(57, 129, 247));
        searchButton.setBorderColorOver(new java.awt.Color(57, 158, 255));
        searchButton.setColor(new java.awt.Color(57, 129, 247));
        searchButton.setColor2(java.awt.Color.white);
        searchButton.setColorClick(new java.awt.Color(57, 158, 255));
        searchButton.setColorClick2(java.awt.Color.white);
        searchButton.setColorOver(new java.awt.Color(57, 158, 255));
        searchButton.setColorOver2(java.awt.Color.white);
        searchButton.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        searchButton.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        searchButton.setMaximumSize(new java.awt.Dimension(143, 68));
        searchButton.setMinimumSize(new java.awt.Dimension(143, 68));
        searchButton.setPreferredSize(new java.awt.Dimension(143, 68));
        searchButton.setRadius(60);
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        searchButton.setBounds(730,220,150,60);
        contentPane.add(searchButton);
        
        edit_icon.setForeground(new java.awt.Color(57, 129, 247));
        edit_icon.setIcon(new javax.swing.ImageIcon("src/App/img/edit.png"));
        edit_icon.setText("ddd");
        edit_icon.setBounds(211,240,30,20);
        contentPane.add(edit_icon);
        edit_icon.getAccessibleContext().setAccessibleDescription("");

        editButton.setBackground(new java.awt.Color(57, 129, 247));
        editButton.setForeground(new java.awt.Color(255, 255, 255));
        editButton.setText("Edit");
        editButton.setToolTipText("");
        editButton.setBorderColor(new java.awt.Color(57, 129, 247));
        editButton.setBorderColorNotOver(new java.awt.Color(57, 129, 247));
        editButton.setBorderColorOver(new java.awt.Color(57, 158, 255));
        editButton.setColor(new java.awt.Color(57, 129, 247));
        editButton.setColor2(java.awt.Color.white);
        editButton.setColorClick(new java.awt.Color(57, 158, 255));
        editButton.setColorClick2(java.awt.Color.white);
        editButton.setColorOver(new java.awt.Color(57, 158, 255));
        editButton.setColorOver2(java.awt.Color.white);
        editButton.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        editButton.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        editButton.setMaximumSize(new java.awt.Dimension(143, 68));
        editButton.setMinimumSize(new java.awt.Dimension(143, 68));
        editButton.setPreferredSize(new java.awt.Dimension(143, 68));
        editButton.setRadius(60);
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        editButton.setBounds(200,220,110,60);
        contentPane.add(editButton);

        delete_icon.setFont(new java.awt.Font("Montserrat", 1, 48)); // NOI18N
        delete_icon.setForeground(new java.awt.Color(255, 255, 255));
        delete_icon.setText("-");
        delete_icon.setBounds(340,230,30,30);
        contentPane.add(delete_icon);

        deleteButton.setBackground(new java.awt.Color(57, 129, 247));
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("Delete");
        deleteButton.setBorderColor(new java.awt.Color(57, 129, 247));
        deleteButton.setBorderColorNotOver(new java.awt.Color(57, 129, 247));
        deleteButton.setBorderColorOver(new java.awt.Color(57, 158, 255));
        deleteButton.setColor(new java.awt.Color(57, 129, 247));
        deleteButton.setColor2(java.awt.Color.white);
        deleteButton.setColorClick(new java.awt.Color(57, 158, 255));
        deleteButton.setColorClick2(java.awt.Color.white);
        deleteButton.setColorOver(new java.awt.Color(57, 158, 255));
        deleteButton.setColorOver2(java.awt.Color.white);
        deleteButton.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        deleteButton.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        deleteButton.setMaximumSize(new java.awt.Dimension(143, 68));
        deleteButton.setMinimumSize(new java.awt.Dimension(143, 68));
        deleteButton.setPreferredSize(new java.awt.Dimension(143, 68));
        deleteButton.setRadius(60);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        deleteButton.setBounds(320,220,150,60);
        contentPane.add(deleteButton);

        add_icon.setFont(new java.awt.Font("Montserrat", 1, 40)); // NOI18N
        add_icon.setForeground(new java.awt.Color(255, 255, 255));
        add_icon.setText("+");
        add_icon.setBounds(90,230,30,40);
        contentPane.add(add_icon);

        addButton.setBackground(new java.awt.Color(57, 129, 247));
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("Add");
        addButton.setBorderColor(new java.awt.Color(57, 129, 247));
        addButton.setBorderColorNotOver(new java.awt.Color(57, 129, 247));
        addButton.setBorderColorOver(new java.awt.Color(57, 158, 255));
        addButton.setColor(new java.awt.Color(57, 129, 247));
        addButton.setColor2(java.awt.Color.white);
        addButton.setColorClick(new java.awt.Color(57, 158, 255));
        addButton.setColorClick2(java.awt.Color.white);
        addButton.setColorOver(new java.awt.Color(57, 158, 255));
        addButton.setColorOver2(java.awt.Color.white);
        addButton.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        addButton.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        addButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        addButton.setMaximumSize(new java.awt.Dimension(143, 68));
        addButton.setMinimumSize(new java.awt.Dimension(143, 68));
        addButton.setPreferredSize(new java.awt.Dimension(143, 68));
        addButton.setRadius(60);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        addButton.setBounds(70,220,120,60);
        contentPane.add(addButton);
        
        titleField.setFont(new java.awt.Font("Montserrat SemiBold", 0, 42)); // NOI18N   
        titleField.setEditable(false);
        titleField.setFocusable(false);
        titleField.setBackground(new Color(224, 237, 255));
        titleField.setBorder(null);
        titleField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateTitleCharacterCount();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateTitleCharacterCount();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateTitleCharacterCount();
            }
        });

        // Create a DocumentFilter to limit the text length
        ((AbstractDocument) titleField.getDocument()).setDocumentFilter(new DocumentFilter() {
            int maxLength = 30; // Set the maximum length

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                // Get the current length of the text
                int currentLength = fb.getDocument().getLength();

                // Calculate the length of the text after replacement
                int newLength = currentLength - length + (text == null ? 0 : text.length());

                // If the new length exceeds the maximum length, do not perform the replacement
                if (newLength <= maxLength) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
        contentPane.add(titleField);
       
        Runnable enableTitleField = () -> {
            titleField.setEnabled(true);
            titleField.setCursor(new Cursor(Cursor.TEXT_CURSOR));
            titleField.requestFocusInWindow();
        };
        
        Runnable disableTitleField = () ->{
            titleField.setEditable(false);
            titleField.setFocusable(false);
            titleField.setBackground(new Color(224, 237, 255));
            titleField.setBorder(null);
            titleField.setCursor(null);
            titleField.setForeground(Color.black);
        };
        
        editTitle.setBackground(new java.awt.Color(224, 237, 255));
        editTitle.setForeground(new java.awt.Color(0,0,0));
        editTitle.setIcon(new javax.swing.ImageIcon("src/App/img/edit_quiz_title.png")); // NOI18N
        editTitle.setToolTipText("");
        editTitle.setBorderColor(new java.awt.Color(224, 237, 255));
        editTitle.setBorderColorNotOver(new java.awt.Color(224, 237, 255));
        editTitle.setBorderColorOver(new java.awt.Color(224, 237, 255));
        editTitle.setColor(new java.awt.Color(224, 237, 255));
        editTitle.setColor2(new java.awt.Color(224, 237, 255));
        editTitle.setColorClick(new java.awt.Color(224, 237, 255));
        editTitle.setColorClick2(new java.awt.Color(224, 237, 255));
        editTitle.setColorOver(new java.awt.Color(224, 237, 255));
        editTitle.setColorOver2(new java.awt.Color(224, 237, 255));
        editTitle.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        editTitle.setMargin(new java.awt.Insets(0, 0, 0, 0));
        editTitle.setRadius(30);
        editTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTitleActionPerformed(evt);
                enableTitleField.run();
            }
        });
        editTitle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                editTitle.setIcon(new javax.swing.ImageIcon("src/App/img/edit_quiz_title_hover.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                editTitle.setIcon(new javax.swing.ImageIcon("src/App/img/edit_quiz_title.png"));
            }
        });
        contentPane.add(editTitle);
        
        editTitleDone.setVisible(false);
        editTitleDone.setBackground(new java.awt.Color(224, 237, 255));
        editTitleDone.setForeground(new java.awt.Color(0,0,0));
        editTitleDone.setIcon(new javax.swing.ImageIcon("src/App/img/edit_title_done.png")); // NOI18N
        editTitleDone.setToolTipText("");
        editTitleDone.setBorderColor(new java.awt.Color(224, 237, 255));
        editTitleDone.setBorderColorNotOver(new java.awt.Color(224, 237, 255));
        editTitleDone.setBorderColorOver(new java.awt.Color(224, 237, 255));
        editTitleDone.setColor(new java.awt.Color(224, 237, 255));
        editTitleDone.setColor2(new java.awt.Color(224, 237, 255));
        editTitleDone.setColorClick(new java.awt.Color(224, 237, 255));
        editTitleDone.setColorClick2(new java.awt.Color(224, 237, 255));
        editTitleDone.setColorOver(new java.awt.Color(224, 237, 255));
        editTitleDone.setColorOver2(new java.awt.Color(224, 237, 255));
        editTitleDone.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        editTitleDone.setMargin(new java.awt.Insets(0, 0, 0, 0));
        editTitleDone.setRadius(30);
        editTitleDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boolean run = editTitleDoneActionPerformed(evt);
                if(run){
                    disableTitleField.run();
                }
            }
        });
        editTitleDone.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                editTitleDone.setIcon(new javax.swing.ImageIcon("src/App/img/edit_title_done_hover.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                editTitleDone.setIcon(new javax.swing.ImageIcon("src/App/img/edit_title_done.png"));
            }
        }); 
        contentPane.add(editTitleDone);
        
        editTitleCancel.setVisible(false);
        editTitleCancel.setBackground(new java.awt.Color(224, 237, 255));
        editTitleCancel.setForeground(new java.awt.Color(0,0,0));
        editTitleCancel.setIcon(new javax.swing.ImageIcon("src/App/img/edit_title_cancel.png")); // NOI18N
        editTitleCancel.setToolTipText("");
        editTitleCancel.setBorderColor(new java.awt.Color(224, 237, 255));
        editTitleCancel.setBorderColorNotOver(new java.awt.Color(224, 237, 255));
        editTitleCancel.setBorderColorOver(new java.awt.Color(224, 237, 255));
        editTitleCancel.setColor(new java.awt.Color(224, 237, 255));
        editTitleCancel.setColor2(new java.awt.Color(224, 237, 255));
        editTitleCancel.setColorClick(new java.awt.Color(224, 237, 255));
        editTitleCancel.setColorClick2(new java.awt.Color(224, 237, 255));
        editTitleCancel.setColorOver(new java.awt.Color(224, 237, 255));
        editTitleCancel.setColorOver2(new java.awt.Color(224, 237, 255));
        editTitleCancel.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        editTitleCancel.setMargin(new java.awt.Insets(0, 0, 0, 0));
        editTitleCancel.setRadius(30);
        editTitleCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTitleCancelActionPerformed(evt);
                disableTitleField.run();
            }
        });
        editTitleCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                editTitleCancel.setIcon(new javax.swing.ImageIcon("src/App/img/edit_title_cancel_hover.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                editTitleCancel.setIcon(new javax.swing.ImageIcon("src/App/img/edit_title_cancel.png"));
            }
        }); 
        contentPane.add(editTitleCancel);
        
        
        
        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jLabel3.setText("Duration:");
        jLabel3.setBounds(80,160, jLabel3.getPreferredSize().width,jLabel3.getPreferredSize().height);
        contentPane.add(jLabel3);
        
        minuteLabel.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        minuteLabel.setText("minutes");
        contentPane.add(minuteLabel);

        
        durationField.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N   
        durationField.setEditable(false);
        durationField.setFocusable(false);
        durationField.setBackground(new Color(224, 237, 255));
        durationField.setBorder(null);

        // Create a DocumentFilter to limit the text length
        ((AbstractDocument) durationField.getDocument()).setDocumentFilter(new DocumentFilter() {
            Pattern regex = Pattern.compile("\\d*"); // Regular expression to match numbers

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String newText = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
                Matcher matcher = regex.matcher(newText);
                if (matcher.matches() && newText.length()<10) {
                    super.replace(fb, offset, length, text, attrs);
                }
   
            }
        });
        
        durationField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateDurationCharacterCount();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateDurationCharacterCount();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateDurationCharacterCount();
            }
        });
        
        contentPane.add(durationField);

        
        Runnable enableDurationField = () -> {
            durationField.setEnabled(true);
            durationField.setCursor(new Cursor(Cursor.TEXT_CURSOR));
            durationField.requestFocusInWindow();
        };
        
        Runnable disableDurationField = () ->{
            durationField.setEditable(false);
            durationField.setFocusable(false);
            durationField.setBackground(new Color(224, 237, 255));
            durationField.setBorder(null);
            durationField.setCursor(null);
            durationField.setForeground(Color.black);
        };
        
        
        editDuration.setBackground(new java.awt.Color(224, 237, 255));
        editDuration.setForeground(new java.awt.Color(0,0,0));
        editDuration.setIcon(new javax.swing.ImageIcon("src/App/img/edit_duration.png")); // NOI18N
        editDuration.setToolTipText("");
        editDuration.setBorderColor(new java.awt.Color(224, 237, 255));
        editDuration.setBorderColorNotOver(new java.awt.Color(224, 237, 255));
        editDuration.setBorderColorOver(new java.awt.Color(224, 237, 255));
        editDuration.setColor(new java.awt.Color(224, 237, 255));
        editDuration.setColor2(new java.awt.Color(224, 237, 255));
        editDuration.setColorClick(new java.awt.Color(224, 237, 255));
        editDuration.setColorClick2(new java.awt.Color(224, 237, 255));
        editDuration.setColorOver(new java.awt.Color(224,237,255));
        editDuration.setColorOver2(new java.awt.Color(224, 237, 255));
        editDuration.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        editDuration.setMargin(new java.awt.Insets(0, 0, 0, 0));
        editDuration.setRadius(30);
        editDuration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editDurationActionPerformed(evt);
                enableDurationField.run();
            }
        });
        editDuration.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                editDuration.setIcon(new javax.swing.ImageIcon("src/App/img/edit_duration_hover.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                editDuration.setIcon(new javax.swing.ImageIcon("src/App/img/edit_duration.png"));
            }
        });
        contentPane.add(editDuration);
        
        editDurationDone.setVisible(false);
        editDurationDone.setBackground(new java.awt.Color(224, 237, 255));
        editDurationDone.setForeground(new java.awt.Color(0,0,0));
        editDurationDone.setIcon(new javax.swing.ImageIcon("src/App/img/edit_duration_done.png")); // NOI18N
        editDurationDone.setToolTipText("");
        editDurationDone.setBorderColor(new java.awt.Color(224, 237, 255));
        editDurationDone.setBorderColorNotOver(new java.awt.Color(224, 237, 255));
        editDurationDone.setBorderColorOver(new java.awt.Color(224, 237, 255));
        editDurationDone.setColor(new java.awt.Color(224, 237, 255));
        editDurationDone.setColor2(new java.awt.Color(224, 237, 255));
        editDurationDone.setColorClick(new java.awt.Color(224, 237, 255));
        editDurationDone.setColorClick2(new java.awt.Color(224, 237, 255));
        editDurationDone.setColorOver(new java.awt.Color(224, 237, 255));
        editDurationDone.setColorOver2(new java.awt.Color(224, 237, 255));
        editDurationDone.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        editDurationDone.setMargin(new java.awt.Insets(0, 0, 0, 0));
        editDurationDone.setRadius(30);
        editDurationDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boolean run = editDurationDoneActionPerformed(evt);
                if(run){
                    disableDurationField.run();
                }
            }
        });
        editDurationDone.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                editDurationDone.setIcon(new javax.swing.ImageIcon("src/App/img/edit_duration_done_hover.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                editDurationDone.setIcon(new javax.swing.ImageIcon("src/App/img/edit_duration_done.png"));
            }
        });
        contentPane.add(editDurationDone);
        
        editDurationCancel.setVisible(false);
        editDurationCancel.setBackground(new java.awt.Color(224, 237, 255));
        editDurationCancel.setForeground(new java.awt.Color(0,0,0));
        editDurationCancel.setIcon(new javax.swing.ImageIcon("src/App/img/edit_duration_cancel.png")); // NOI18N
        editDurationCancel.setToolTipText("");
        editDurationCancel.setBorderColor(new java.awt.Color(224, 237, 255));
        editDurationCancel.setBorderColorNotOver(new java.awt.Color(224, 237, 255));
        editDurationCancel.setBorderColorOver(new java.awt.Color(224, 237, 255));
        editDurationCancel.setColor(new java.awt.Color(224, 237, 255));
        editDurationCancel.setColor2(new java.awt.Color(224, 237, 255));
        editDurationCancel.setColorClick(new java.awt.Color(224, 237, 255));
        editDurationCancel.setColorClick2(new java.awt.Color(224, 237, 255));
        editDurationCancel.setColorOver(new java.awt.Color(224, 237, 255));
        editDurationCancel.setColorOver2(new java.awt.Color(224, 237, 255));
        editDurationCancel.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        editDurationCancel.setMargin(new java.awt.Insets(0, 0, 0, 0));
        editDurationCancel.setRadius(30);
        editDurationCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editDurationCancelActionPerformed(evt);
                disableDurationField.run();
            }
        });
        editDurationCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                editDurationCancel.setIcon(new javax.swing.ImageIcon("src/App/img/edit_duration_cancel_hover.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                editDurationCancel.setIcon(new javax.swing.ImageIcon("src/App/img/edit_duration_cancel.png"));
            }
        });
        contentPane.add(editDurationCancel);

        
        contentPane.revalidate();
        contentPane.repaint();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        
        setTitleAndDuration();
    }
    
    
    //if no question in that quiz, show some icons
    public static void showEmptyIcon(int totalElement){
        if(totalElement ==0){
            plane_icon.setVisible(true);
            noQuestion.setVisible(true);
            clickToAdd.setVisible(true);
        }
        else{
            plane_icon.setVisible(false);
            noQuestion.setVisible(false);
            clickToAdd.setVisible(false);
        }
    }
    
    
    //show question panels 
    public static void showCloneablePanel(int totalElement){
        cloneablePanel.removeAll();
        
        int x=10;
        Linkedlist.Node currentQuestion = EditQuiz.quizlist.quiz.head;
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
            CloneablePanelEditQuiz clonedPanel = new CloneablePanelEditQuiz(40, Color.white, 2,id, questionNumber, question, option1, option2, option3, option4, answer, required);
            // Set your custom width and height for the cloned panel
            int panelWidth = 1100;
            int panelHeight = 370;
            
            
            int y;
            if (i == 1) {
                y = 10; // If it's the first cloned panel, start at y = 10
            } else {
                y = 10 + (i - 1) * (panelHeight + 50); // Adjusted position for subsequent panels
            }

            // Set the bounds for the cloned panel with your custom size
            clonedPanel.setBounds(x, y, panelWidth, panelHeight);
            clonedPanel.setBackground(Color.white);
            
            // Add the cloned panel to the initial panel
            cloneablePanel.add(clonedPanel);
            // Adjust preferred size of initial panel to include new panel
            Dimension newSize = new Dimension(cloneablePanel.getWidth(), y + panelHeight + 10); // Adjusted size
            cloneablePanel.setPreferredSize(newSize);
            // Ensure the scroll pane updates its viewport
            scrollPane.revalidate();
            scrollPane.repaint();
            // Scroll to show the new panel
            scrollPane.getVerticalScrollBar().setValue(0);
            
            currentQuestion = currentQuestion.next;
        }
        cloneablePanel.revalidate();
        cloneablePanel.repaint();
    }
    
    
    //update the quiz title and duration based on database
    private void setTitleAndDuration(){
        try{
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("select * from quiz where id='" + EditQuiz.quizID + "'");
            if(rs.first()){
                String title = rs.getString(2);
                String duration = rs.getString(3);
                
                titleField.setText(title);
                titleField.setBounds(80,100, titleField.getPreferredSize().width, titleField.getPreferredSize().height);
                editTitle.setBounds(titleField.getWidth()+titleField.getX(), 108, editTitle.getPreferredSize().width, editTitle.getPreferredSize().height);

                durationField.setText(duration);
                durationField.setBounds(jLabel3.getWidth()+jLabel3.getX()+10, 160, durationField.getPreferredSize().width, durationField.getPreferredSize().height);
                minuteLabel.setBounds(durationField.getWidth()+durationField.getX()+3, 160, minuteLabel.getPreferredSize().width, minuteLabel.getPreferredSize().height);
                editDuration.setBounds(minuteLabel.getWidth()+minuteLabel.getX()+5, 155, editDuration.getPreferredSize().width, editDuration.getPreferredSize().height);
                
            }
            else{
                JOptionPane.showMessageDialog(getContentPane(), "ID invalid");
            }
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(getContentPane(), e);
        }
    }
    
    
    //if quiz title is 0, field become red 
    private void updateTitleCharacterCount() {
        String text = titleField.getText();
        int length = text.length();
        
        if(length==0){
            titleField.setForeground(Color.red);
            titleField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)), javax.swing.BorderFactory.createEmptyBorder(2, 14, 2, 3)));
        }
        else{
            if(titleField.getBackground().equals(Color.white)){
               titleField.setForeground(Color.black);  
               titleField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEmptyBorder(2, 14, 2, 3)));   
            }
        }
        
        titleField.setBounds(80, 100, titleField.getPreferredSize().width+30, titleField.getPreferredSize().height);
        editTitleDone.setBounds(titleField.getWidth()+titleField.getX()+5, 108, editTitleDone.getPreferredSize().width, editTitleDone.getPreferredSize().height);
        editTitleCancel.setBounds(titleField.getWidth()+titleField.getX()+editTitleDone.getPreferredSize().width+5, 108, editTitleCancel.getPreferredSize().width, editTitleCancel.getPreferredSize().height);
    
    }
    
    
    //when editing quiz title
    private void editTitleActionPerformed(java.awt.event.ActionEvent evt) {                                          
        titleField.setEditable(true);
        titleField.setFocusable(true);
        titleField.setBackground(new Color(255,255,255));
        titleField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEmptyBorder(2, 14, 2, 3)));
        titleField.setBounds(80,100, titleField.getPreferredSize().width, titleField.getPreferredSize().height);
        editTitle.setVisible(false);
        editTitleDone.setVisible(true);
        editTitleDone.setBounds(titleField.getWidth()+titleField.getX()+5, 108, editTitleDone.getPreferredSize().width, editTitleDone.getPreferredSize().height);
        editTitleCancel.setVisible(true);
        editTitleCancel.setBounds(titleField.getWidth()+titleField.getX()+editTitleDone.getPreferredSize().width+5, 108, editTitleCancel.getPreferredSize().width, editTitleCancel.getPreferredSize().height);
    }
    
    
    private boolean editTitleDoneActionPerformed(java.awt.event.ActionEvent evt) {
        boolean run = false;
        
        if(titleField.getForeground().equals(Color.red)){
            JOptionPane.showMessageDialog(getContentPane(), "Title is empty");
        }
        else{
            //set the component to become as before
            editTitle.setVisible(true);
            editTitleDone.setVisible(false);
            editTitleCancel.setVisible(false);
            
            //update the database
            try{
                Connection con = ConnectionProvider.getCon();
                String str = "update quiz set title='" + titleField.getText() + "' where id='" + EditQuiz.quizID + "'";
                PreparedStatement ps = con.prepareStatement(str);
                ps.executeUpdate();
                run = true;
            }catch(Exception e){
                JOptionPane.showMessageDialog(getContentPane(), e);
            }
            setTitleAfterChange();
        }
        return run;
    }
    
    private void editTitleCancelActionPerformed(java.awt.event.ActionEvent evt) {  
        editTitle.setVisible(true);
        editTitleDone.setVisible(false);
        editTitleCancel.setVisible(false);
        setTitleAfterChange();
    }
    
    //set title based on database
    private void setTitleAfterChange(){
        try{
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("select * from quiz where id='" + EditQuiz.quizID + "'");
            if(rs.first()){
                String title = rs.getString(2);
                titleField.setText(title);
                titleField.setBounds(80,100, titleField.getPreferredSize().width-17, titleField.getPreferredSize().height);
                editTitle.setBounds(titleField.getWidth()+titleField.getX(), 108, editTitle.getPreferredSize().width, editTitle.getPreferredSize().height);
            }
            else{
                JOptionPane.showMessageDialog(getContentPane(), "ID invalid");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(getContentPane(), e);
        }
    }
    
    //if out of range, field become red
    private void updateDurationCharacterCount() {
        String text = durationField.getText();
        int length = text.length();
        
        if(length==0){
            durationField.setForeground(Color.red);
            durationField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)), javax.swing.BorderFactory.createEmptyBorder(2, 9, 2, 9)));
        }
        else{
            if(durationField.getBackground().equals(Color.white)){
                durationField.setForeground(Color.black);  
                durationField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEmptyBorder(2, 9, 2, 8)));
            }
        }
        
        durationField.setBounds(jLabel3.getWidth()+jLabel3.getX()+10,160, durationField.getPreferredSize().width+30, durationField.getPreferredSize().height);
        editDurationDone.setBounds(durationField.getWidth()+durationField.getX()+5, 160, editDurationDone.getPreferredSize().width, editDurationDone.getPreferredSize().height);
        editDurationCancel.setBounds(editDurationDone.getX()+editDurationDone.getPreferredSize().width, 158, editDurationCancel.getPreferredSize().width, editDurationCancel.getPreferredSize().height);
    
    }
    
    //when editing the quiz duration
    private void editDurationActionPerformed(java.awt.event.ActionEvent evt) {                                          
        durationField.setEditable(true);
        durationField.setFocusable(true);
        durationField.setBackground(new Color(255,255,255));
        durationField.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEmptyBorder(2, 9, 2, 8)));
        durationField.setBounds(jLabel3.getWidth()+jLabel3.getX()+10,160, durationField.getPreferredSize().width+30, durationField.getPreferredSize().height);
        editDuration.setVisible(false);
        minuteLabel.setVisible(false);
        editDurationDone.setVisible(true);
        editDurationDone.setBounds(durationField.getWidth()+durationField.getX()+5, 160, editDurationDone.getPreferredSize().width, editDurationDone.getPreferredSize().height);
        editDurationCancel.setVisible(true);
        editDurationCancel.setBounds(editDurationDone.getX()+editDurationDone.getPreferredSize().width, 158, editDurationCancel.getPreferredSize().width, editDurationCancel.getPreferredSize().height);
    }
    
    
    private boolean editDurationDoneActionPerformed(java.awt.event.ActionEvent evt) {
        boolean run = false;
        
        if(durationField.getForeground().equals(Color.red)){
            JOptionPane.showMessageDialog(getContentPane(), "Duration is empty");
        }
        else{
            //update database
            try{
                Connection con = ConnectionProvider.getCon();
                String str = "update quiz set duration='" + durationField.getText() + "' where id='" + EditQuiz.quizID + "'";
                PreparedStatement ps = con.prepareStatement(str);
                ps.executeUpdate();
                run = true;
            }catch(Exception e){
                JOptionPane.showMessageDialog(getContentPane(), e);
            }
            setDurationAfterChange();
        }
        return run;
    }
    
    private void editDurationCancelActionPerformed(java.awt.event.ActionEvent evt) {  
        setDurationAfterChange();
    }
    
    //set duration based on database
    private void setDurationAfterChange(){
        editDuration.setVisible(true);
        editDurationDone.setVisible(false);
        editDurationCancel.setVisible(false);
        minuteLabel.setVisible(true);
        
        try{
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("select * from quiz where id='" + EditQuiz.quizID + "'");
            if(rs.first()){
                String duration = rs.getString(3);
                durationField.setText(duration);
                durationField.setBounds(jLabel3.getWidth()+jLabel3.getX()+10,158, durationField.getPreferredSize().width-17, durationField.getPreferredSize().height);
                minuteLabel.setBounds(durationField.getWidth()+durationField.getX()+3, 160, minuteLabel.getPreferredSize().width, minuteLabel.getPreferredSize().height);
                editDuration.setBounds(minuteLabel.getWidth()+minuteLabel.getX()+5, 155, editDuration.getPreferredSize().width, editDuration.getPreferredSize().height);
            }
            else{
                JOptionPane.showMessageDialog(getContentPane(), "ID invalid");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(getContentPane(), e);
        }
    }
    
    
    
    EditQuiz editquiz = (EditQuiz) SwingUtilities.getRoot(this);

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {                                          
        if(open==0){
            new AddQuestion(quizlist, quizID).setVisible(true);
            open=1;
        }
        else{
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf,"One form is already opened");
        }
    }                                         

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        EditQuiz.quizlist.quiz.clearNodes();
        setVisible(false);
        new AdminHome().setVisible(true);
    }                                          

    private void changeOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        if(open==0){
            new ChangeOrder(quizlist, quizID).setVisible(true);
            open=1;
        }
        else{
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf,"One form is already opened");
        }
    }                                                 

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        if(open==0){
            new DeleteQuestion(quizlist, quizID).setVisible(true);
            open=1;
        }
        else{
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf,"One form is already opened");
        }
    }                                            

    private void resultButtonActionPerformed(java.awt.event.ActionEvent evt) { 
        EditQuiz.quizlist.quiz.clearNodes();
        setVisible(false);
        new QuizResult(quizID).setVisible(true);
    }                                            

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        if(open==0){
            new SearchQuestion(quizlist, quizID).setVisible(true);
            open=1;
        }
        else{
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf,"One form is already opened");
        }
    }                                            

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        if(open==0){
            new EditQuestion(quizlist, quizID).setVisible(true);
            open=1;
        }
        else{
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf,"One form is already opened");
        }
    }                                          

    private void LogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        EditQuiz.quizlist.quiz.clearNodes();
        int a = JOptionPane.showConfirmDialog(null, "Do you really want to log out?", "SELECT", JOptionPane.YES_OPTION);
        if(a==0){
            setVisible(false);
            new WelcomePage().setVisible(true);
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
            java.util.logging.Logger.getLogger(EditQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditQuiz().setVisible(true);
            }
        });
    }
    
    private static JLabel noQuestion;
    private static JLabel clickToAdd;
    private static JLabel plane_icon;
    private App.ButtonCustom LogoutButton;
    private App.ButtonCustom addButton;
    private javax.swing.JLabel add_icon;
    private App.ButtonCustom backButton;
    private App.ButtonCustom changeOrderButton;
    private javax.swing.JLabel changeOrder_icon;
    private App.ButtonCustom deleteButton;
    private javax.swing.JLabel delete_icon;
    private App.ButtonCustom editButton;
    private javax.swing.JLabel edit_icon;
    private javax.swing.JLabel jLabel3;
    private App.ButtonCustom resultButton;
    private javax.swing.JLabel result_icon;
    private App.ButtonCustom searchButton;
    private javax.swing.JLabel search_icon;
    private javax.swing.JTextField titleField;
    private App.ButtonCustom editTitle;
    private App.ButtonCustom editTitleDone;
    private App.ButtonCustom editTitleCancel;
    private javax.swing.JTextField durationField;
    private App.ButtonCustom editDuration;
    private App.ButtonCustom editDurationDone;
    private App.ButtonCustom editDurationCancel;
    private javax.swing.JLabel minuteLabel;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
