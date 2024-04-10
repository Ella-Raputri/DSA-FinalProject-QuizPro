/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package App;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class EditQuiz extends javax.swing.JFrame {
    public static int open = 0;
    public static LinkedlistBenchmark quizlist = new LinkedlistBenchmark();
    public String quizID;
    /**
     * Creates new form WelcomePage
     */
    public EditQuiz() {
        initComponents();
    }
    
    public EditQuiz(String quizId){
        this.quizID = quizId;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backButton = new App.buttonCustom();
        changeOrder_icon = new javax.swing.JLabel();
        result_icon = new javax.swing.JLabel();
        changeOrderButton = new App.buttonCustom();
        resultButton = new App.buttonCustom();
        LogoutButton = new App.buttonCustom();
        search_icon = new javax.swing.JLabel();
        searchButton = new App.buttonCustom();
        edit_icon = new javax.swing.JLabel();
        editButton = new App.buttonCustom();
        delete_icon = new javax.swing.JLabel();
        deleteButton = new App.buttonCustom();
        add_icon = new javax.swing.JLabel();
        addButton = new App.buttonCustom();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        edit_quiz_title_icon = new javax.swing.JLabel();
        edit_duration_icon = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bg1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        backButton.setLabel("< Back");
        backButton.setMaximumSize(new java.awt.Dimension(143, 68));
        backButton.setMinimumSize(new java.awt.Dimension(143, 68));
        backButton.setPreferredSize(new java.awt.Dimension(143, 68));
        backButton.setRadius(30);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 160, 60));

        changeOrder_icon.setFont(new java.awt.Font("Montserrat", 1, 48)); // NOI18N
        changeOrder_icon.setForeground(new java.awt.Color(255, 255, 255));
        changeOrder_icon.setIcon(new javax.swing.ImageIcon("src/App/img/change_order.png"));
        getContentPane().add(changeOrder_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 230, 40, 40));

        result_icon.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        result_icon.setForeground(new java.awt.Color(255, 255, 255));
        result_icon.setIcon(new javax.swing.ImageIcon("src/App/img/result.png"));
        result_icon.setText("sss");
        getContentPane().add(result_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 230, 30, 40));

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
        getContentPane().add(changeOrderButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, 240, 60));

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
        getContentPane().add(resultButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 220, 150, 60));

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
        getContentPane().add(LogoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 20, 170, 60));

        search_icon.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        search_icon.setForeground(new java.awt.Color(57, 129, 247));
        search_icon.setIcon(new javax.swing.ImageIcon("src/App/img/search.png"));
        getContentPane().add(search_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 230, -1, 40));

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
        getContentPane().add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 220, 150, 60));

        edit_icon.setForeground(new java.awt.Color(57, 129, 247));
        edit_icon.setIcon(new javax.swing.ImageIcon("src/App/img/edit.png"));
        edit_icon.setText("ddd");
        getContentPane().add(edit_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 240, 30, 20));
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
        getContentPane().add(editButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 110, 60));

        delete_icon.setFont(new java.awt.Font("Montserrat", 1, 48)); // NOI18N
        delete_icon.setForeground(new java.awt.Color(255, 255, 255));
        delete_icon.setText("-");
        getContentPane().add(delete_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, -1, 30));

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
        getContentPane().add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 150, 60));

        add_icon.setFont(new java.awt.Font("Montserrat", 1, 40)); // NOI18N
        add_icon.setForeground(new java.awt.Color(255, 255, 255));
        add_icon.setText("+");
        getContentPane().add(add_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, -1, 40));

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
        getContentPane().add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 120, 60));

        jLabel1.setFont(new java.awt.Font("Montserrat SemiBold", 0, 42)); // NOI18N
        jLabel1.setText("[Quiz Title]");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jLabel3.setText("Duration:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 100, -1));

        edit_quiz_title_icon.setIcon(new javax.swing.ImageIcon("src/App/img/edit_quiz_title.png"));
        getContentPane().add(edit_quiz_title_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, -1, 40));

        edit_duration_icon.setIcon(new javax.swing.ImageIcon("src/App/img/edit_duration.png"));
        getContentPane().add(edit_duration_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, -1, -1));

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 20)); // NOI18N
        jLabel2.setText("[Duration]");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 150, -1));

        bg1.setForeground(new java.awt.Color(57, 129, 247));
        bg1.setIcon(new javax.swing.ImageIcon("src/App/img/background_edit_quiz.png"));
        bg1.setText("jLabel1");
        getContentPane().add(bg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        if(open==0){
            new AddQuestion(quizlist, quizID).setVisible(true);
            open=1;
        }
        else{
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf,"One form is already opened");
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        setVisible(false);
        new AdminHome().setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void changeOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeOrderButtonActionPerformed
        if(open==0){
            new ChangeOrder().setVisible(true);
            open=1;
        }
        else{
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf,"One form is already opened");
        }
    }//GEN-LAST:event_changeOrderButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if(open==0){
            new DeleteQuestion().setVisible(true);
            open=1;
        }
        else{
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf,"One form is already opened");
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void resultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resultButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        if(open==0){
            new EditQuestion().setVisible(true);
            open=1;
        }
        else{
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(jf,"One form is already opened");
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void LogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutButtonActionPerformed
        int a = JOptionPane.showConfirmDialog(null, "Do you really want to log out?", "SELECT", JOptionPane.YES_OPTION);
        if(a==0){
            setVisible(false);
            new WelcomePage().setVisible(true);
        }
    }//GEN-LAST:event_LogoutButtonActionPerformed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditQuiz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private App.buttonCustom LogoutButton;
    private App.buttonCustom addButton;
    private javax.swing.JLabel add_icon;
    private App.buttonCustom backButton;
    private javax.swing.JLabel bg1;
    private App.buttonCustom changeOrderButton;
    private javax.swing.JLabel changeOrder_icon;
    private App.buttonCustom deleteButton;
    private javax.swing.JLabel delete_icon;
    private App.buttonCustom editButton;
    private javax.swing.JLabel edit_duration_icon;
    private javax.swing.JLabel edit_icon;
    private javax.swing.JLabel edit_quiz_title_icon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private App.buttonCustom resultButton;
    private javax.swing.JLabel result_icon;
    private App.buttonCustom searchButton;
    private javax.swing.JLabel search_icon;
    // End of variables declaration//GEN-END:variables
}
