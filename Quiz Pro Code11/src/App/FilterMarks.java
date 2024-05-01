/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
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
public class FilterMarks extends javax.swing.JFrame {
    private LinkedList<Student> studentList = new LinkedList<>();
    /**
     * Creates new form FilterMarks
     */
    public FilterMarks() {
        initComponents();
        myinit();
    }
    
    public FilterMarks(LinkedList<Student> studentList) {
        initComponents();
        this.studentList = studentList;
        myinit();
    }
    
    private void myinit(){
        field1 = new App.RoundJTextField(10);
        field1.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        getContentPane().add(field1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 55, 140, -1));
        getContentPane().setComponentZOrder(field1, 0);
        field1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                field1FocusLost(evt);
            }
        });
        field1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateField1CharacterCount();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateField1CharacterCount();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateField1CharacterCount();
            }
        });
        ((AbstractDocument) field1.getDocument()).setDocumentFilter(new DocumentFilter() {
            Pattern regex = Pattern.compile("\\d*\\.?\\d{0,2}"); // Regular expression to match numbers

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String newText = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
                Matcher matcher = regex.matcher(newText);
                if (matcher.matches() && newText.length()<10 && !newText.contains("..")) {
                    double value = Double.parseDouble(newText);
                    if (value >= 0 && value <= 100) { // Check if value is between 0 and 100
                        super.replace(fb, offset, length, text, attrs);
                    }
                }
            }
        });
        field1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // When "Enter" is pressed in textField1, move focus to textField2
                field2.requestFocusInWindow();
            }
        });
        
        
        
        field2 = new App.RoundJTextField(10);
        field2.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        getContentPane().add(field2, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 55, 140, -1));
        getContentPane().setComponentZOrder(field2, 0);
        field2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                field2FocusLost(evt);
            }
        });
        field2.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateField2CharacterCount();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateField2CharacterCount();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateField2CharacterCount();
            }
        });
        ((AbstractDocument) field2.getDocument()).setDocumentFilter(new DocumentFilter() {
            Pattern regex = Pattern.compile("\\d*\\.?\\d{0,2}"); // Regular expression to match numbers

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String newText = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
                Matcher matcher = regex.matcher(newText);
                if (matcher.matches() && newText.length()<10 && !newText.contains("..")) {
                    double value = Double.parseDouble(newText);
                    if (value >= 0 && value <= 100) { // Check if value is between 0 and 100
                        super.replace(fb, offset, length, text, attrs);
                    }
                }
            }
        }); 
        field2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // When "Enter" is pressed in textField1, move focus to textField2
                okButtonActionPerformed(e);
            }
        });
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cancelButton = new App.ButtonCustom();
        okButton = new App.ButtonCustom();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setLocation(new java.awt.Point(920, 300));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 24)); // NOI18N
        jLabel1.setText("Filter Marks");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 150, -1));

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        jLabel2.setText("to");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, -1, -1));

        cancelButton.setForeground(new java.awt.Color(57, 129, 247));
        cancelButton.setText("Cancel");
        cancelButton.setBorderColor(java.awt.Color.white);
        cancelButton.setBorderColorNotOver(java.awt.Color.white);
        cancelButton.setBorderColorOver(java.awt.Color.white);
        cancelButton.setColor(java.awt.Color.white);
        cancelButton.setColor2(new java.awt.Color(57, 129, 247));
        cancelButton.setColorClick(java.awt.Color.white);
        cancelButton.setColorClick2(new java.awt.Color(0, 67, 178));
        cancelButton.setColorOver(java.awt.Color.white);
        cancelButton.setColorOver2(new java.awt.Color(0, 67, 178));
        cancelButton.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        jPanel1.add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, -1, -1));

        okButton.setForeground(new java.awt.Color(57, 129, 247));
        okButton.setText("OK");
        okButton.setBorderColor(java.awt.Color.white);
        okButton.setBorderColorNotOver(java.awt.Color.white);
        okButton.setBorderColorOver(java.awt.Color.white);
        okButton.setColor(java.awt.Color.white);
        okButton.setColor2(new java.awt.Color(57, 129, 247));
        okButton.setColorClick(java.awt.Color.white);
        okButton.setColorClick2(new java.awt.Color(0, 67, 178));
        okButton.setColorOver(java.awt.Color.white);
        okButton.setColorOver2(new java.awt.Color(0, 67, 178));
        okButton.setFont(new java.awt.Font("Montserrat SemiBold", 0, 18)); // NOI18N
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        jPanel1.add(okButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 140));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        setVisible(false);
        QuizResult.open = 0;
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        String startStr = field1.getText();
        double startNumber = Double.parseDouble(startStr);
        String endStr = field2.getText();
        double endNumber = Double.parseDouble(endStr);
        
        if(startStr.trim().isEmpty()){
            JOptionPane.showMessageDialog(getContentPane(), "Your starting range is still empty");
        }
        else if(endStr.trim().isEmpty()){
            JOptionPane.showMessageDialog(getContentPane(), "Your end range is still empty");
        }
        else if(endNumber < startNumber){
            JOptionPane.showMessageDialog(getContentPane(), "Ending range cannot be smaller than starting range");
        }
        else{
            LinkedList<Student> newStudentList = new LinkedList<>();
            for(Student i: studentList){
                if(i.getGrade()>=startNumber && i.getGrade()<=endNumber){
                    newStudentList.add(i);
                }
            }
            QuizResult.showCloneablePanel(newStudentList.size(), newStudentList);
            
            QuizResult.open=0;
            setVisible(false);
        }
    }//GEN-LAST:event_okButtonActionPerformed
    
    private double checkDouble(String s){
        double num;
        try{
            num = Double.parseDouble(s);
        }
        catch(Exception e){
            num=0;
        }
        return num;
    }
    
    private void updateField1CharacterCount() {
        String text1 = field1.getText();
        double txtDouble1 = checkDouble(text1);
        int length = text1.length();

        if(length>0 && length<10 && txtDouble1<=100){
            field1.setForeground(Color.black);
        }
        else{
            field1.setForeground(Color.red);
        }
    }
    
    private void updateField2CharacterCount() {
        String text2 = field2.getText();
        double txtDouble2 = checkDouble(text2);
        int length = text2.length();

        if(length>0 && length<10 && txtDouble2<=100){
            field2.setForeground(Color.black);
        }
        else{
            field2.setForeground(Color.red);
        }
    }
       

    private void field1FocusLost(java.awt.event.FocusEvent evt) {                                      
        String text = field1.getText();
        
        if(text.trim().isEmpty()){
            field1.setForeground(Color.red);
        }
        else{
            field1.setForeground(Color.black);
        }
    }
    
    private void field2FocusLost(java.awt.event.FocusEvent evt) {                                      
        String text = field2.getText();
        
        if(text.trim().isEmpty()){
            field2.setForeground(Color.red);
        }
        else{
            field2.setForeground(Color.black);
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
            java.util.logging.Logger.getLogger(FilterMarks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FilterMarks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FilterMarks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FilterMarks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FilterMarks().setVisible(true);
            }
        });
    }
    
    private App.RoundJTextField field1;
    private App.RoundJTextField field2;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private App.ButtonCustom cancelButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private App.ButtonCustom okButton;
    // End of variables declaration//GEN-END:variables
}
