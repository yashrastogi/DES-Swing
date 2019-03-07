import java.math.BigInteger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author niit
 */
public class Encrypt extends javax.swing.JFrame {

    /**
     * Creates new form Encrypt
     */
    public Encrypt() {
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

        jLabel1 = new javax.swing.JLabel();
        PlaintextTextField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        KeyTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        IVTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        OutputTextField = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DES Encryptor");
        setResizable(false);

        jLabel1.setText("Text (Hex):");

        PlaintextTextField.setText("02468aceeca86420");
        PlaintextTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlaintextTextFieldActionPerformed(evt);
            }
        });

        jButton1.setText("Encrypt");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Key (Hex):");

        KeyTextField.setText("0f1571c947d9e859");
        KeyTextField.setToolTipText("");
        KeyTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KeyTextFieldActionPerformed(evt);
            }
        });

        jLabel3.setText("Output:");

        jLabel4.setText("IV (Hex):");

        IVTextField.setText("0000000000000000");
        IVTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IVTextFieldActionPerformed(evt);
            }
        });

        OutputTextField.setEditable(false);
        OutputTextField.setColumns(20);
        OutputTextField.setLineWrap(true);
        OutputTextField.setRows(5);
        OutputTextField.setWrapStyleWord(true);
        jScrollPane1.setViewportView(OutputTextField);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(KeyTextField)
                                    .addComponent(IVTextField)
                                    .addComponent(PlaintextTextField)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PlaintextTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(KeyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IVTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PlaintextTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlaintextTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PlaintextTextFieldActionPerformed

    private void KeyTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KeyTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_KeyTextFieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        KeyTextField.setText(KeyTextField.getText().toUpperCase());
        PlaintextTextField.setText(PlaintextTextField.getText().toUpperCase());
        StringBuilder inputbin = new StringBuilder("");
        
        if(IVTextField.getText().length() > 16 || KeyTextField.getText().length() > 16) {
            JOptionPane.showMessageDialog(rootPane, "Please enter only 8 bytes of data in Key/IV");
            this.dispose();
            JFrame encrypt = new Encrypt();
            encrypt.setVisible(true);
            return; 
        }
        
        // Cipher Block Chaining
        // No. of blocks required to be encrypted
        int blocks = (int) Math.ceil((double) PlaintextTextField.getText().length()/16);
        for(int i=0; i<blocks; i++) {
            BigInteger temp;
            // If last block and last block length < 64 take whatever left
            if(i == (blocks-1) && PlaintextTextField.getText().length()<(i+1)*16) {
                temp = new BigInteger(PlaintextTextField.getText().substring(i*16, PlaintextTextField.getText().length()), 16);
            } else {
                temp = new BigInteger(PlaintextTextField.getText().substring(i*16, (i+1)*16), 16);
            }
            // Take 16 hex chars at a time and append its 64 bit binary
            // (filled with 0's to the left if required)
            inputbin.append(Functions.fillZeroBin(new StringBuilder(temp.toString(2)),64));
        }
        
        BigInteger key = new BigInteger(KeyTextField.getText(), 16);
        BigInteger iv = new BigInteger(IVTextField.getText(), 16);
        StringBuilder keybin = Functions.fillZeroBin(new StringBuilder(key.toString(2)), 64);
        StringBuilder ivbin = Functions.fillZeroBin(new StringBuilder(iv.toString(2)), 64);
        
        String outputRound="";
        String output="";
        StringBuilder xorInput;
        StringBuilder inputSubStr;
        for(int i=0; i<blocks; i++) {
            inputSubStr = new StringBuilder(inputbin.substring(i*64, (i+1)*64));
            if(i == 0) {
                xorInput = Functions.XOR(inputSubStr, ivbin);
                outputRound = SingleBlockEncryptor(xorInput, keybin).toString(2);
                output = output + SingleBlockEncryptor(xorInput, keybin).toString(16);
            } else {
                xorInput = Functions.XOR(inputSubStr, Functions.fillZeroBin(new StringBuilder(outputRound), 64));
                outputRound = SingleBlockEncryptor(xorInput, keybin).toString(2);
                output = output + " " + SingleBlockEncryptor(xorInput, keybin).toString(16);
            }
        }
        OutputTextField.setText(output.toUpperCase());
    }//GEN-LAST:event_jButton1ActionPerformed

    private BigInteger SingleBlockEncryptor(StringBuilder inputbin, StringBuilder keybin) {
        int output[][] = null;
        for(int round=1; round<=16; round++) {
            if(round == 1) {
                output = SingleRoundEncryption.initializeDES(inputbin, keybin);
            }
            output = SingleRoundEncryption.nRoundDES(round, output);
        }
        
        int binOutput[] = SingleRoundEncryption.finalizeDES(output);
       
        StringBuilder binOut = new StringBuilder();
        for(int i=0; i<binOutput.length; i++) {
            binOut.append(binOutput[i]);
        }
        return new BigInteger(""+binOut, 2);
    }
    
    private void IVTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IVTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IVTextFieldActionPerformed

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
                    javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Encrypt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Encrypt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Encrypt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Encrypt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Encrypt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IVTextField;
    private javax.swing.JTextField KeyTextField;
    private javax.swing.JTextArea OutputTextField;
    private javax.swing.JTextField PlaintextTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
