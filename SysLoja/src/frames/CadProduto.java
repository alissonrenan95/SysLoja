/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import BO.CategoriaProduto;
import BO.Estoque;
import BO.Produto;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Renan
 */
public class CadProduto extends javax.swing.JFrame {

    /**
     * Creates new form CadProduto
     */
    public CadProduto() {
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
        lbproduto = new javax.swing.JLabel();
        lbpesquisa = new javax.swing.JLabel();
        rbnome = new javax.swing.JRadioButton();
        rbid = new javax.swing.JRadioButton();
        rbcodbarra = new javax.swing.JRadioButton();
        txtpesquisa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbproduto = new javax.swing.JTable();
        lbid = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        lbcodbarras = new javax.swing.JLabel();
        txtcodbarra = new javax.swing.JTextField();
        lbnome = new javax.swing.JLabel();
        txtnome = new javax.swing.JTextField();
        lbcategoria = new javax.swing.JLabel();
        txtcategoria = new javax.swing.JTextField();
        cbcategoria = new javax.swing.JComboBox();
        lbvalor = new javax.swing.JLabel();
        txtvalor = new javax.swing.JTextField();
        btsalvar = new javax.swing.JButton();
        btalterar = new javax.swing.JButton();
        btcancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Produto");
        setMaximumSize(new java.awt.Dimension(521, 526));
        setMinimumSize(new java.awt.Dimension(521, 526));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lbproduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/categoria.png"))); // NOI18N
        lbproduto.setText("Produto");

        lbpesquisa.setText("Pesquisa");

        buttonGroup1.add(rbnome);
        rbnome.setSelected(true);
        rbnome.setText("Nome");

        buttonGroup1.add(rbid);
        rbid.setText("ID");

        buttonGroup1.add(rbcodbarra);
        rbcodbarra.setText("Cod Barra");

        txtpesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpesquisaKeyReleased(evt);
            }
        });

        jScrollPane1.setFocusable(false);

        tbproduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod Barra", "ID", "Nome", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbproduto.setFocusable(false);
        tbproduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbprodutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbproduto);
        if (tbproduto.getColumnModel().getColumnCount() > 0) {
            tbproduto.getColumnModel().getColumn(1).setResizable(false);
            tbproduto.getColumnModel().getColumn(1).setPreferredWidth(30);
            tbproduto.getColumnModel().getColumn(2).setResizable(false);
            tbproduto.getColumnModel().getColumn(3).setResizable(false);
            tbproduto.getColumnModel().getColumn(3).setPreferredWidth(30);
        }

        lbid.setText("ID");

        txtid.setEditable(false);
        txtid.setEnabled(false);

        lbcodbarras.setText("Codigo de Barras");

        lbnome.setText("Nome");

        lbcategoria.setText("Categoria");

        txtcategoria.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcategoriaFocusLost(evt);
            }
        });
        txtcategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcategoriaKeyReleased(evt);
            }
        });

        cbcategoria.setFocusable(false);

        lbvalor.setText("Valor Unitário (R$)");

        btsalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/salvar.jpeg"))); // NOI18N
        btsalvar.setText("Salvar");
        btsalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsalvarActionPerformed(evt);
            }
        });

        btalterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/alterar.jpg"))); // NOI18N
        btalterar.setText("Alterar");
        btalterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btalterarActionPerformed(evt);
            }
        });

        btcancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancelar.png"))); // NOI18N
        btcancelar.setText("Cancelar");
        btcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(lbproduto)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtcategoria)
                                .addGap(18, 18, 18)
                                .addComponent(cbcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbvalor)
                                .addGap(18, 18, 18)
                                .addComponent(txtvalor))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbnome)
                                .addGap(18, 18, 18)
                                .addComponent(txtnome))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbid)
                                        .addGap(30, 30, 30)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btsalvar)
                                                .addGap(18, 18, 18)
                                                .addComponent(btalterar)
                                                .addGap(18, 18, 18)
                                                .addComponent(btcancelar))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lbcodbarras))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(lbpesquisa)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbnome)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rbid)
                                        .addGap(6, 6, 6)
                                        .addComponent(rbcodbarra)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txtcodbarra, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lbproduto)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbpesquisa)
                    .addComponent(rbnome)
                    .addComponent(rbid)
                    .addComponent(rbcodbarra)
                    .addComponent(txtpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbid)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcodbarras)
                    .addComponent(txtcodbarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbnome)
                    .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbcategoria)
                    .addComponent(txtcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbvalor)
                    .addComponent(txtvalor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btsalvar)
                    .addComponent(btalterar)
                    .addComponent(btcancelar))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btsalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsalvarActionPerformed
        // TODO add your handling code here:
        Estoque e=pegarDadosCampos();
        if(e!=null){
            if(e.salvar()){
                JOptionPane.showMessageDialog(rootPane, "Produto salvo com sucesso!", "Operação efetuada", JOptionPane.INFORMATION_MESSAGE);
                limparCampos();
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Verifique se esse código de barras já está cadastrado no sistema", "Operação não efetuada", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Verifique se os campos foram preenchidos corretamente", "Campos inválidos", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btsalvarActionPerformed

    private void btalterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btalterarActionPerformed
        // TODO add your handling code here:
        Estoque e=pegarDadosCampos();
        if(e!=null){
            if(e.alterar()){
                JOptionPane.showMessageDialog(rootPane, "Produto alterado com sucesso", "Operação efetuada", JOptionPane.INFORMATION_MESSAGE);
                limparCampos();
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Verifique se esse código de barras já está cadastrado no sistema", "Operação não efetuada", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Verifique se os campos foram preenchidos corretamente", "Campos inválidos", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btalterarActionPerformed

    private void btcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcancelarActionPerformed
        // TODO add your handling code here:
        limparCampos();
    }//GEN-LAST:event_btcancelarActionPerformed

    private void txtpesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpesquisaKeyReleased
        // TODO add your handling code here:
        if(!txtpesquisa.getText().isEmpty()){
            List<Estoque> estoque;
            if(rbnome.isSelected()){
                estoque=new Estoque().listarCodbarraIdNomeValorPorNome(txtpesquisa.getText());
                tbproduto.setModel(getModelo(estoque));
            }
            else if(rbid.isSelected()){
                Integer id=null;
                try{
                    id=Integer.parseInt(txtpesquisa.getText());
                    estoque=new Estoque().listarCodbarraIdNomeValorPorId(id);
                    tbproduto.setModel(getModelo(estoque));
                }
                catch(Exception e){
                
                }
            }
            else if(rbcodbarra.isSelected()){
                Long codbarra=null;
                try{
                    codbarra=Long.parseLong(txtpesquisa.getText());
                    estoque=new Estoque().listarCodbarraIdNomeValorPorCodbarra(codbarra);
                    tbproduto.setModel(getModelo(estoque));
                }
                catch(Exception e){
                
                }
            }
        }
    }//GEN-LAST:event_txtpesquisaKeyReleased

    private void tbprodutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbprodutoMouseClicked
        // TODO add your handling code here:
        Integer linha=tbproduto.getSelectedRow();
        //List<Produto> produtos=new Produto().listarPorId(Integer.parseInt(tbproduto.getValueAt(linha, 0).toString()));
        List<Estoque> estoque=new Estoque().listarPorCodBarra(Long.parseLong(tbproduto.getValueAt(linha, 0).toString()));
        if(estoque.size()>0){
            inserirValoresEstoque(estoque.get(0));
            //inserirValoresProduto(produtos.get(0));
        }
        txtnome.requestFocus();
    }//GEN-LAST:event_tbprodutoMouseClicked

    private void txtcategoriaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcategoriaKeyReleased
        // TODO add your handling code here:
        preencherModelCategoria();
    }//GEN-LAST:event_txtcategoriaKeyReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        modoalteracao(false);
    }//GEN-LAST:event_formWindowOpened

    private void txtcategoriaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcategoriaFocusLost
        // TODO add your handling code here:
        txtcategoria.setText(cbcategoria.getSelectedItem().toString());
    }//GEN-LAST:event_txtcategoriaFocusLost

    public void preencherModelCategoria(){
        cbcategoria.setModel(new DefaultComboBoxModel(new CategoriaProduto().listarPorNome(txtcategoria.getText()).toArray()));
    }
    
    
    public void inserirValoresEstoque(Estoque e){
        txtcodbarra.setText(e.getCodBarra().toString());
        inserirValoresProduto(e.getProduto());
    }
    
    public void inserirValoresProduto(Produto p){
        txtid.setText(Integer.toString(p.getId()));
        txtnome.setText(p.getNome());
        txtcategoria.setText(p.getCategoriaProduto().getNome());
        cbcategoria.setModel(new DefaultComboBoxModel(new Object[]{p.getCategoriaProduto()}));
        txtvalor.setText(Double.toString(p.getValorUnitario()));
        modoalteracao(true);
    }
    public void modoalteracao(Boolean b){
        btsalvar.setEnabled(!b);
        btalterar.setEnabled(b);
    }
    
    public void limparCampos(){
        rbnome.setSelected(true);
        txtpesquisa.setText("");
        txtid.setText("");
        txtcodbarra.setText("");
        txtnome.setText("");
        txtcategoria.setText("");
        cbcategoria.setModel(new DefaultComboBoxModel());
        txtvalor.setText("");
        modoalteracao(false);
        txtpesquisa.requestFocus();
        preencherModelCategoria();
        List<Estoque> estoque=new Estoque().listarCodbarraIdNomeValorPorNome(txtpesquisa.getText());
        tbproduto.setModel(getModelo(estoque));
    }
    
    public DefaultTableModel getModelo(List<Estoque> lista){
        Vector<String> headers=new Vector<String>();
        headers.add("Cod Barra");
        headers.add("ID");
        headers.add("Nome");
        headers.add("Valor");
        Vector<Object> vetorvalores=new Vector<Object>();
        for(Estoque e:lista){
            Vector vetor=new Vector();
            vetor.add(e.getCodBarra());
            vetor.add(e.getProduto().getId());
            vetor.add(e.getProduto().getNome());
            vetor.add(e.getProduto().getValorUnitario());
            vetorvalores.add(vetor);
        }
        return new DefaultTableModel(vetorvalores, headers);
    }
    
    public Boolean verificarCampos(){
        return !txtnome.getText().isEmpty()&&
               !cbcategoria.getSelectedItem().toString().isEmpty()&&
               !txtvalor.getText().isEmpty();
    }
    
    public Estoque pegarDadosCampos(){
        if(verificarCampos()){
            Integer id = null;
            Double valorunitario = null;
            CategoriaProduto categoriaProduto = null;
            try {
                id=Integer.parseInt(txtid.getText());
            } 
            catch (Exception e) {
                //caracteres invalidos ou campo vazio
            }
            try{
                valorunitario = Double.parseDouble(txtvalor.getText().replaceAll(",", "."));
                categoriaProduto=(CategoriaProduto)cbcategoria.getSelectedItem();
                Produto p = new Produto(id, txtnome.getText(), valorunitario, categoriaProduto);
                Estoque e=new Estoque();
                if(!txtcodbarra.getText().isEmpty()){
                    e.setCodBarra(Long.parseLong(txtcodbarra.getText()));
                }
                e.setQuantidade(0);
                e.setDisponivelVenda(true);
                e.setProduto(p);
                return e;
            }
            catch(Exception e){
                
            }
        }
        return null;
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
            java.util.logging.Logger.getLogger(CadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btalterar;
    private javax.swing.JButton btcancelar;
    private javax.swing.JButton btsalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbcategoria;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbcategoria;
    private javax.swing.JLabel lbcodbarras;
    private javax.swing.JLabel lbid;
    private javax.swing.JLabel lbnome;
    private javax.swing.JLabel lbpesquisa;
    private javax.swing.JLabel lbproduto;
    private javax.swing.JLabel lbvalor;
    private javax.swing.JRadioButton rbcodbarra;
    private javax.swing.JRadioButton rbid;
    private javax.swing.JRadioButton rbnome;
    private javax.swing.JTable tbproduto;
    private javax.swing.JTextField txtcategoria;
    private javax.swing.JTextField txtcodbarra;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnome;
    private javax.swing.JTextField txtpesquisa;
    private javax.swing.JTextField txtvalor;
    // End of variables declaration//GEN-END:variables
}