/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import BO.Estoque;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Renan
 */
public class ConsultaEstoque extends javax.swing.JFrame {

    /**
     * Creates new form ConsultaEstoque
     */
    public ConsultaEstoque() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        lbconsultaestoque = new javax.swing.JLabel();
        lbpesquisa = new javax.swing.JLabel();
        rbnome = new javax.swing.JRadioButton();
        rbid = new javax.swing.JRadioButton();
        txtpesquisa = new javax.swing.JTextField();
        btpesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbestoque = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Estoque");
        setMaximumSize(new java.awt.Dimension(642, 486));
        setMinimumSize(new java.awt.Dimension(642, 486));
        setResizable(false);

        lbconsultaestoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/fornecimento2.png"))); // NOI18N
        lbconsultaestoque.setText("Consulta de Estoque");

        lbpesquisa.setText("Pesquisa");

        buttonGroup1.add(rbnome);
        rbnome.setSelected(true);
        rbnome.setText("Nome");

        buttonGroup1.add(rbid);
        rbid.setText("ID");

        btpesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pesquisar.png"))); // NOI18N
        btpesquisar.setText("Pesquisar");
        btpesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btpesquisarActionPerformed(evt);
            }
        });

        tbestoque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Quantidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbestoque);
        if (tbestoque.getColumnModel().getColumnCount() > 0) {
            tbestoque.getColumnModel().getColumn(0).setResizable(false);
            tbestoque.getColumnModel().getColumn(1).setResizable(false);
            tbestoque.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(lbconsultaestoque))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbpesquisa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbnome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbid)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btpesquisar)))))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lbconsultaestoque)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbpesquisa)
                    .addComponent(rbnome)
                    .addComponent(txtpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btpesquisar)
                    .addComponent(rbid))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btpesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btpesquisarActionPerformed
        // TODO add your handling code here:
        if(!txtpesquisa.getText().isEmpty()){
            List estoque = null;
            if(rbnome.isSelected()){
                estoque=new Estoque().consultarEstoquePorProdutoNome(txtpesquisa.getText());
            }
            else{
                try{
                    estoque=new Estoque().consultarEstoquePorProdutoId(Integer.parseInt(txtpesquisa.getText()));//EstoquePorProdutoId(Integer.parseInt(txtpesquisa.getText()));
                }
                catch(Exception e){
                    estoque=null;
                }
            }
            if(estoque!=null){
                tbestoque.setModel(getModelo(estoque));
            }
        }
        
    }//GEN-LAST:event_btpesquisarActionPerformed

    
    
    
    public DefaultTableModel getModelo(List lista){
        Vector<String> headers=new Vector<String>();
        headers.add("ID");
        headers.add("Nome");
        headers.add("Quantidade");
        Vector<Object> vetorvalores=new Vector<Object>();
        //System.out.println(lista.get(0));
        for(Object o:lista){
            Object[] obj=(Object[])o;
            Vector vetor=new Vector();
            vetor.add(obj[0]);
            vetor.add(obj[1]);
            vetor.add(obj[2]);
            
            
            /*Object[] o1=(Object[])o;
            Vector vetor=new Vector();
            vetor.add(o1[0].toString());
            vetor.add(o1[1].toString());
            vetor.add(o1[2].toString());*/
            vetorvalores.add(vetor);
        }
        return new DefaultTableModel(vetorvalores, headers);
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
            java.util.logging.Logger.getLogger(ConsultaEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaEstoque().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btpesquisar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbconsultaestoque;
    private javax.swing.JLabel lbpesquisa;
    private javax.swing.JRadioButton rbid;
    private javax.swing.JRadioButton rbnome;
    private javax.swing.JTable tbestoque;
    private javax.swing.JTextField txtpesquisa;
    // End of variables declaration//GEN-END:variables
}