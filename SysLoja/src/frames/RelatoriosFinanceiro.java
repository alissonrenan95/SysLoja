/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import relatorios.RelatoriosPadrao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Renan 2016
 */
public class RelatoriosFinanceiro extends javax.swing.JFrame {

    /**
     * Creates new form RelatórioFinanceiro
     */
    public RelatoriosFinanceiro() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbrelatoriovendas = new javax.swing.JLabel();
        btgerarrelatorio = new javax.swing.JButton();
        txtdtfim = new javax.swing.JFormattedTextField(pegarFormatterDate());
        lbdatafim = new javax.swing.JLabel();
        txtdtinicio = new javax.swing.JFormattedTextField(pegarFormatterDate());
        lbdataini = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatórios Financeiros");

        lbrelatoriovendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/relatorios.png"))); // NOI18N
        lbrelatoriovendas.setText("Relatório Financeiros");

        btgerarrelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/entrar.png"))); // NOI18N
        btgerarrelatorio.setText("Gerar Relatório");
        btgerarrelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btgerarrelatorioActionPerformed(evt);
            }
        });

        lbdatafim.setText("Data Fim");

        lbdataini.setText("Data Inicio");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbdataini)
                            .addComponent(lbdatafim))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btgerarrelatorio)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtdtfim)
                                .addComponent(txtdtinicio, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(lbrelatoriovendas)))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lbrelatoriovendas)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbdataini)
                    .addComponent(txtdtinicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbdatafim)
                    .addComponent(txtdtfim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(btgerarrelatorio)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    SimpleDateFormat formatador=new SimpleDateFormat("dd/MM/yyyy");
    private void btgerarrelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btgerarrelatorioActionPerformed
        if(!txtdtinicio.getText().isEmpty() && !txtdtfim.getText().isEmpty()){
            try {
                RelatoriosPadrao.gerarRelatoriosFinanceiro(formatador.parse(txtdtinicio.getText()), formatador.parse(txtdtfim.getText()));
            } catch(Exception e){
                JOptionPane.showMessageDialog(rootPane, "Preencha os campos com datas validas(DD/MM/AAAA)", "Campos Inválidos", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Preencha os campos com datas validas(DD/MM/AAAA)", "Campos em Branco", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btgerarrelatorioActionPerformed

    public MaskFormatter pegarFormatterDate(){
        MaskFormatter mformat = null;
        try{
            mformat=new MaskFormatter("##/##/####");
            mformat.setPlaceholderCharacter('_');
        }
        catch(ParseException e){
            
        }
        return mformat;
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
            java.util.logging.Logger.getLogger(RelatoriosFinanceiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelatoriosFinanceiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelatoriosFinanceiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelatoriosFinanceiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelatoriosFinanceiro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btgerarrelatorio;
    private javax.swing.JLabel lbdatafim;
    private javax.swing.JLabel lbdataini;
    private javax.swing.JLabel lbrelatoriovendas;
    private javax.swing.JTextField txtdtfim;
    private javax.swing.JTextField txtdtinicio;
    // End of variables declaration//GEN-END:variables
}
