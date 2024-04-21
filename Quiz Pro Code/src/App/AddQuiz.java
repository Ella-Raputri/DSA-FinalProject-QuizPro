/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import java.awt.Color;
import java.sql.*;
import DatabaseConnection.ConnectionProvider;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author asus
 */
public class AddQuiz extends javax.swing.JFrame {
    private AdminHome home;
   
    /**
     * Creates new form AddQuiz
     */
    public AddQuiz() {
        initComponents();
        myinit();
    }
    
    public AddQuiz(AdminHome home) {
        this.home = home;
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
        setAlwaysOnTop(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    int totalElement =0;
    LinkedList<String> allIdList = new LinkedList<>();
    private void myinit(){

        getContentPane().setBackground(Color.white);
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Custom close operation logic
                int option = JOptionPane.showConfirmDialog(getContentPane(), "Do you really want to go back?", null, JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    setVisible(false);
                    AdminHome.open=0;
                } 
            }
        });
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 540, 570));
        setFocusable(false);
        setForeground(java.awt.Color.white);
        setMinimumSize(new java.awt.Dimension(540, 570));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        backButton = new App.buttonCustom();
        OKbutton = new App.buttonCustom();
        jLabel2 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        titleField = new RoundJTextField(16);
        durationField = new RoundJTextField(4);
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        
        try{
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("select count(id) from quiz");
            if(rs.first()){
                String temp = rs.getString(1);
                totalElement = Integer.parseInt(temp);
            }
            else{
                totalElement = 0;
            }
            
            if(totalElement==0){
                id.setText("z1");
            }
            else{
                ResultSet rs1 = st.executeQuery("select id from quizID");
                while(rs1.next()){
                    String text = rs1.getString("id");
                    allIdList.add(text);
                }
                
                String lastId = allIdList.getLast();
                String temp = "";
                for(int i=1; i<lastId.length(); i++){
                    temp = temp + lastId.charAt(i);
                }
                int idnow = Integer.parseInt(temp);
                idnow++;
                String str = "z" + String.valueOf(idnow);
                id.setText(str); 
                
            }
            
            
           
         
            
        } catch(Exception e){
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf, e);
        }
        
        
        jLabel1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 48)); // NOI18N
        jLabel1.setText("<html><u>ADD QUIZ</u></html>");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Montserrat SemiBold", 0, 28)); // NOI18N
        jLabel3.setText("ID:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        
        backButton.setText("Back");
        backButton.setBorderColor(new java.awt.Color(57, 129, 247));
        backButton.setBorderColorNotOver(new java.awt.Color(57, 129, 247));
        backButton.setBorderColorOver(new java.awt.Color(13, 72, 170));
        backButton.setColorClick(new java.awt.Color(235, 235, 235));
        backButton.setColorClick2(new java.awt.Color(13, 72, 170));
        backButton.setColorOver(new java.awt.Color(235, 235, 235));
        backButton.setColorOver2(new java.awt.Color(13, 72, 170));
        backButton.setColor2(new java.awt.Color(57, 129, 247));
        backButton.setForeground(new java.awt.Color(57, 129, 247));
        backButton.setColor(new java.awt.Color(255,255,255));
        backButton.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        backButton.setMaximumSize(new java.awt.Dimension(143, 68));
        backButton.setMinimumSize(new java.awt.Dimension(143, 68));
        backButton.setPreferredSize(new java.awt.Dimension(143, 68));
        backButton.setRadius(10);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 84, 50));

        OKbutton.setForeground(new java.awt.Color(255, 255, 255));
        OKbutton.setColor(new java.awt.Color(57, 129, 247));
        OKbutton.setColor2(new java.awt.Color(255, 255, 255));
        OKbutton.setText("OK");
        OKbutton.setBorderColor(new java.awt.Color(255, 255, 255));
        OKbutton.setBorderColorNotOver(new java.awt.Color(255, 255, 255));
        OKbutton.setBorderColorOver(new java.awt.Color(255, 255, 255));
        OKbutton.setColorClick(new java.awt.Color(57, 158, 255));
        OKbutton.setColorClick2(new java.awt.Color(255, 255, 255));
        OKbutton.setColorOver(new java.awt.Color(57, 158, 255));
        OKbutton.setColorOver2(new java.awt.Color(255, 255, 255));
        OKbutton.setFont(new java.awt.Font("Montserrat SemiBold", 0, 20)); // NOI18N
        OKbutton.setMaximumSize(new java.awt.Dimension(143, 68));
        OKbutton.setMinimumSize(new java.awt.Dimension(143, 68));
        OKbutton.setPreferredSize(new java.awt.Dimension(143, 68));
        OKbutton.setRadius(10);
        OKbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKbuttonActionPerformed(evt);
            }
        });
        getContentPane().add(OKbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 440, 80, 50));

        jLabel2.setFont(new java.awt.Font("Montserrat SemiBold", 0, 28)); // NOI18N
        jLabel2.setText("Duration");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        id.setFont(new java.awt.Font("Montserrat SemiBold", 0, 28)); // NOI18N
        getContentPane().add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Montserrat SemiBold", 0, 28)); // NOI18N
        jLabel4.setText("Title");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));
        
        jLabel6.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel6.setText("(0 / 30)");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 193, -1, -1));
        
        jLabel7.setIcon(new javax.swing.ImageIcon("src/App/img/warning_icon.png")); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 230, -1, -1));
        jLabel7.setVisible(false);
        
        titleField.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        getContentPane().add(titleField, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 225, -1, -1));
        titleField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                titleFieldFocusLost(evt);
            }
        });
        titleField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateCharacterCount();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateCharacterCount();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateCharacterCount();
            }
        });
        
        jLabel8.setIcon(new javax.swing.ImageIcon("src/App/img/warning_icon.png")); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 343, -1, -1));
        jLabel8.setVisible(false);
        
        durationField.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        getContentPane().add(durationField, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 335, -1, -1));
        durationField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateCheckDigit();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateCheckDigit();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateCheckDigit();
            }
        });
        durationField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                durationFieldFocusLost(evt);
            }
        });
        
        jLabel5.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel5.setText("minutes");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 340, -1, -1));
        
        

        pack();
        setLocationRelativeTo(null);
    }
    
    private void updateCharacterCount() {
        String text = titleField.getText();
        int length = text.length();
        jLabel6.setText("(" + length + " / 30)");
        
        if(length > 30 || length==0){
            jLabel7.setVisible(true);
            titleField.setForeground(Color.red);
            jLabel6.setForeground(Color.red);
        }
        else{
            jLabel7.setVisible(false);
            titleField.setForeground(Color.black);
            jLabel6.setForeground(Color.black);
        }
    }
       

    private void titleFieldFocusLost(java.awt.event.FocusEvent evt) {                                      
        String title = titleField.getText();
        
        if(title.equals("")){
            jLabel7.setVisible(true);
            titleField.setForeground(Color.red);
            jLabel6.setForeground(Color.red);
        }
        else{
            jLabel7.setVisible(false);
            titleField.setForeground(Color.black);
            jLabel6.setForeground(Color.black);
        }
    }
                                                                                  

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int a = JOptionPane.showConfirmDialog(getContentPane(), "Do you really want to go back?", "SELECT", JOptionPane.YES_OPTION);
        if(a==0){
            setVisible(false);
            AdminHome.open=0;
        }
    }
    
    private static boolean checkInt(String str){
        try{
            Integer.parseInt(str);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    
    private void updateCheckDigit(){
        String text = durationField.getText();
        boolean check = checkInt(text);
        if(check){
            jLabel8.setVisible(false);
            durationField.setForeground(Color.black);
            jLabel5.setForeground(Color.black);
        }
        else{
            jLabel8.setVisible(true);
            durationField.setForeground(Color.red);
            jLabel5.setForeground(Color.red);
        }
    }
    
    private void durationFieldFocusLost(java.awt.event.FocusEvent evt) {                                      
        String duration = durationField.getText();
        
        if(duration.equals("")){
            jLabel8.setVisible(true);
            durationField.setForeground(Color.red);
            jLabel5.setForeground(Color.red);
        }
        else{
            jLabel8.setVisible(false);
            durationField.setForeground(Color.black);
            jLabel5.setForeground(Color.black);
        }
    }

    private void OKbuttonActionPerformed(java.awt.event.ActionEvent evt) {
        String idInput = id.getText();
        String titleInput = titleField.getText();
        String durationInput = durationField.getText();
        
        if(titleInput.equals("")){
            JOptionPane.showMessageDialog(getContentPane(), "Your title is still empty");
        }
        else if(durationInput.equals("")){
            JOptionPane.showMessageDialog(getContentPane(), "Your duration field is still empty");
        }
        else if(titleInput.length() > 30){
            JOptionPane.showMessageDialog(getContentPane(), "Your title has exceeded 30 characters.");            
        }
        else if(checkInt(durationInput) == false){
            JOptionPane.showMessageDialog(getContentPane(), "Duration input must be a number");
        }
        else{
            try{
                Connection con = ConnectionProvider.getCon();
                Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                
                PreparedStatement ps = con.prepareStatement("insert into quiz values(?,?,?)");
                ps.setString(1, idInput);
                ps.setString(2, titleInput);
                ps.setString(3, durationInput);
                ps.executeUpdate();
                
                PreparedStatement ps2 = con.prepareStatement("insert into quizID values(?)");
                ps2.setString(1, idInput);
                ps2.executeUpdate();
                
                JOptionPane.showMessageDialog(getContentPane(), "Successfully added");
                AdminHome.open=0;
                setVisible(false);
                home.goToEdit(idInput);

            }catch(Exception e){
                JOptionPane.showMessageDialog(getContentPane(), e);
            }
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
            java.util.logging.Logger.getLogger(AddQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddQuiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddQuiz().setVisible(true);
            }
        });
    }
    
    private App.buttonCustom OKbutton;
    private App.buttonCustom backButton;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private RoundJTextField titleField;
    private RoundJTextField durationField;


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
