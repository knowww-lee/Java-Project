/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Noli Licudo
 */
public class PaymentWindow extends javax.swing.JFrame {
     private double totalCost;

    /**
     * Creates new form PaymentWindow
     */
    public PaymentWindow() {
        initComponents();
        addDocumentListenerToCashDisplay();
    }
    
    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
    private void handleTenderSelection() {
        String selectedTender = (String) tenders.getSelectedItem();
        if ("Cash".equals(selectedTender)) {
            cashLabel.setText("Cash:");
            cashDisplay.setEditable(true);
        } else {
            cashLabel.setText("Code:");
            cashDisplay.setEditable(false);
            cashDisplay.setText("");
            changeDisplay.setText("");
        }
    }

   private boolean cashInputValidated = false;

private void validateCashInput() {
    if ("Cash".equals(tenders.getSelectedItem())) {
        try {
            double cash = Double.parseDouble(cashDisplay.getText());
            if (cash < totalCost)  {
                JOptionPane.showMessageDialog(this, "Cash amount is less than total cost.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                cashDisplay.requestFocus();
                double change = cash - totalCost;
                changeDisplay.setText(String.format("%.2f", change));
                cashInputValidated = false; // Cash input not validated
            } else {
                double change = cash - totalCost;
                changeDisplay.setText(String.format("%.2f", change));
                cashInputValidated = true; // Cash input validated successfully
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid cash amount.", "Error", JOptionPane.ERROR_MESSAGE);
            cashInputValidated = false; // Cash input not validated
        }
    } else {
        // For other payment methods like Maya or QRPh, assume input is validated
        cashInputValidated = true;
    }
}


      private void addDocumentListenerToCashDisplay() {
        cashDisplay.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                updateChangeDisplay();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                updateChangeDisplay();
            }
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateChangeDisplay();
            }
        });
    }

    private void updateChangeDisplay() {
        try {
            double cash = Double.parseDouble(cashDisplay.getText());
            double change = cash - totalCost;
            changeDisplay.setText(String.format("%.2f", change));
        } catch (NumberFormatException e) {
            changeDisplay.setText("0.00");
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cashLabel = new javax.swing.JLabel();
        changeLabel = new javax.swing.JLabel();
        tendersLabel = new javax.swing.JLabel();
        cashDisplay = new javax.swing.JTextField();
        changeDisplay = new javax.swing.JTextField();
        confirmButton = new javax.swing.JButton();
        tenders = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        cashLabel.setBackground(new java.awt.Color(204, 255, 255));
        cashLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        cashLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cashLabel.setText("CASH");
        cashLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        changeLabel.setBackground(new java.awt.Color(204, 255, 255));
        changeLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        changeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        changeLabel.setText("CHANGE");
        changeLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        tendersLabel.setBackground(new java.awt.Color(204, 255, 255));
        tendersLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        tendersLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tendersLabel.setText("TENDERS");
        tendersLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        cashDisplay.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        cashDisplay.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cashDisplay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cashDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashDisplayActionPerformed(evt);
            }
        });

        changeDisplay.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        changeDisplay.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        changeDisplay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        changeDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeDisplayActionPerformed(evt);
            }
        });

        confirmButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        confirmButton.setText("CONFIRM");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        tenders.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        tenders.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "CC/DC", "QRPH" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tendersLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cashLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(changeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cashDisplay)
                            .addComponent(changeDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                            .addComponent(tenders, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(188, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tendersLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                    .addComponent(tenders))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cashDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addComponent(cashLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(changeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                    .addComponent(changeDisplay))
                .addGap(53, 53, 53)
                .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void changeDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeDisplayActionPerformed
  
        // Get the text from cashDisplay and parse it to a double
        double cash = Double.parseDouble(cashDisplay.getText());

        // Calculate the change
        double Totalchange = cash - totalCost;

        // Set the text in changeDisplay
        changeDisplay.setText(String.format("%.2f", Totalchange));
  
    
    }//GEN-LAST:event_changeDisplayActionPerformed

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        // Validate cash input before confirming
    validateCashInput();

    // Check if cash input is validated before showing confirmation
    if (cashInputValidated) {
        // Example: Perform additional actions upon confirmation
        JOptionPane.showMessageDialog(this, "Payment confirmed!");

        // Close the PaymentWindow after confirmation
        dispose();
    }
    }//GEN-LAST:event_confirmButtonActionPerformed

    private void cashDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashDisplayActionPerformed
          
    }//GEN-LAST:event_cashDisplayActionPerformed

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
            java.util.logging.Logger.getLogger(PaymentWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaymentWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaymentWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaymentWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaymentWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cashDisplay;
    private javax.swing.JLabel cashLabel;
    private javax.swing.JTextField changeDisplay;
    private javax.swing.JLabel changeLabel;
    private javax.swing.JButton confirmButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> tenders;
    private javax.swing.JLabel tendersLabel;
    // End of variables declaration//GEN-END:variables

   
}
