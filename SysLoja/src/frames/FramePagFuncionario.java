/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import BO.Cliente;
import BO.Funcionario;
import BO.PagamentoFuncionario;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Renan
 */
public class FramePagFuncionario extends javax.swing.JFrame {

    /**
     * Creates new form FramePagFuncionario
     */
    public FramePagFuncionario() {
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

        lbpesquisa = new javax.swing.JLabel();
        txtpesquisa = new javax.swing.JTextField();
        lbvalorpago = new javax.swing.JLabel();
        txtsalario = new javax.swing.JTextField();
        lbsalario = new javax.swing.JLabel();
        txtvalorpago = new javax.swing.JTextField();
        lbidfunc = new javax.swing.JLabel();
        txtidfunc = new javax.swing.JTextField();
        lbdtpagamento = new javax.swing.JLabel();
        lbpagcontas = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbpagfunc = new javax.swing.JTable();
        lbid = new javax.swing.JLabel();
        txtdtpagamento = new javax.swing.JFormattedTextField(pegarFormatterDate());
        txtid = new javax.swing.JTextField();
        btefetuarpag = new javax.swing.JButton();
        lbnomefunc = new javax.swing.JLabel();
        txtnomefunc = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pagamento de Funcionários");
        setMaximumSize(new java.awt.Dimension(581, 489));
        setMinimumSize(new java.awt.Dimension(581, 489));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lbpesquisa.setText("Pesquisa (Nome do Funcionário)");

        txtpesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpesquisaKeyReleased(evt);
            }
        });

        lbvalorpago.setText("Valor Pago");

        txtsalario.setEditable(false);
        txtsalario.setEnabled(false);

        lbsalario.setText("Salário");

        lbidfunc.setText("ID Funcionário");

        txtidfunc.setEditable(false);
        txtidfunc.setEnabled(false);

        lbdtpagamento.setText("Data Pagamento");

        lbpagcontas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/dinheiro.png"))); // NOI18N
        lbpagcontas.setText("Pagamento de Funcionários");

        tbpagfunc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID Funcionário", "Nome", "Salário"
            }
        ));
        tbpagfunc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbpagfuncMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbpagfunc);

        lbid.setText("ID Pagamento");

        txtid.setEditable(false);
        txtid.setEnabled(false);

        btefetuarpag.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/entrar.png"))); // NOI18N
        btefetuarpag.setText("Efetuar Pagamento");
        btefetuarpag.setEnabled(false);
        btefetuarpag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btefetuarpagActionPerformed(evt);
            }
        });

        lbnomefunc.setText("Nome do Funcionário");

        txtnomefunc.setEditable(false);
        txtnomefunc.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(lbpagcontas))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lbpesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbid)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbidfunc)
                                .addGap(18, 18, 18)
                                .addComponent(txtidfunc))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbnomefunc)
                                    .addComponent(lbdtpagamento))
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtnomefunc, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbsalario))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtdtpagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbvalorpago)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtvalorpago, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtsalario, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(btefetuarpag)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lbpagcontas)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbpesquisa)
                    .addComponent(txtpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbid)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbidfunc)
                    .addComponent(txtidfunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbnomefunc)
                    .addComponent(txtnomefunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbsalario)
                    .addComponent(txtsalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtvalorpago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbvalorpago)
                    .addComponent(lbdtpagamento)
                    .addComponent(txtdtpagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(btefetuarpag)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    DecimalFormat formatnumber=new DecimalFormat("#0.00");
    SimpleDateFormat formatador=new SimpleDateFormat("dd/MM/yyyy");
    private void txtpesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpesquisaKeyReleased
        // TODO add your handling code here:
        List<Funcionario> lista=new Funcionario().listarFuncionariosParaPagamentoPorNome(txtpesquisa.getText());
        tbpagfunc.setModel(getModelo(lista));
    }//GEN-LAST:event_txtpesquisaKeyReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        List<Funcionario> lista=new Funcionario().listarFuncionariosParaPagamentoPorNome(txtpesquisa.getText());
        tbpagfunc.setModel(getModelo(lista));
    }//GEN-LAST:event_formWindowOpened

    private void tbpagfuncMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbpagfuncMouseClicked
        // TODO add your handling code here:
        Integer linha=tbpagfunc.getSelectedRow();
        Funcionario f=new Funcionario();
        f.setId(Integer.parseInt(tbpagfunc.getValueAt(linha, 0).toString()));
        f.setClienteId(new Cliente(tbpagfunc.getValueAt(linha, 1).toString(), ""));
        f.setSalario(Double.parseDouble(tbpagfunc.getValueAt(linha, 2).toString()));
        inserirValoresFuncionario(f);
        txtdtpagamento.requestFocus();
    }//GEN-LAST:event_tbpagfuncMouseClicked

    private void btefetuarpagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btefetuarpagActionPerformed
        // TODO add your handling code here:
        PagamentoFuncionario pf=pegarDadosCampos();
        if(pf!=null){
            if(pf.salvar()){
                JOptionPane.showMessageDialog(rootPane, "Pagamento realizado com sucesso", "Operação efetuada", JOptionPane.INFORMATION_MESSAGE);
                limparCampos();
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Verifique se você está conectado ao servidor de banco de dados", "Operação não efetuada", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Verifique se os campos foram preenchidos corretamente", "Campos inválidos", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btefetuarpagActionPerformed

    public void inserirValoresFuncionario(Funcionario f){
        txtid.setText("");
        txtidfunc.setText(f.getId().toString());
        txtnomefunc.setText(f.getClienteId().getNome());
        txtsalario.setText(formatnumber.format(f.getSalario()));
        txtdtpagamento.setText("");
        txtvalorpago.setText("");
        modoalteracao(true);
    }
    public void modoalteracao(Boolean b){
        btefetuarpag.setEnabled(b);
    }
    
    public void limparCampos(){
        txtpesquisa.setText("");
        txtid.setText("");
        txtidfunc.setText("");
        txtnomefunc.setText("");
        txtdtpagamento.setText("");
        txtsalario.setText("");
        txtvalorpago.setText("");
        modoalteracao(false);
        txtpesquisa.requestFocus();
    }
    
    public DefaultTableModel getModelo(List<Funcionario> lista){
        Vector<String> headers=new Vector<String>();
        headers.add("ID Funcionário");
        headers.add("Nome");
        headers.add("Salário");
        Vector<Object> vetorvalores=new Vector<Object>();
        for(Funcionario f:lista){
            Vector vetor=new Vector();
            vetor.add(f.getId());
            vetor.add(f.getClienteId().getNome());
            vetor.add(f.getSalario());
            vetorvalores.add(vetor);
        }
        return new DefaultTableModel(vetorvalores, headers);
    }
    
    public Boolean verificarCampos(){
        Double valor=0.0;
        try{
            valor=Double.parseDouble(txtvalorpago.getText().replaceAll(",", "."));
        }
        catch(Exception e){
            return null;
        }
        return !txtidfunc.getText().isEmpty()&&
               !txtdtpagamento.getText().isEmpty()&&
                txtdtpagamento.getText().length()==10&&
               !txtsalario.getText().isEmpty()&&
               !txtvalorpago.getText().isEmpty()&&
               valor>0.0;
    }
    
    
    
    PagamentoFuncionario pegarDadosCampos(){
        if(verificarCampos()){
            
            PagamentoFuncionario pf=new PagamentoFuncionario();
            Integer id;
            try{
                id=Integer.parseInt(txtid.getText());
            }
            catch(Exception e){
                id=null;
            }
            try{
                pf.setId(id);
                pf.setUsuarioId(MenuPrincipal.funcionario.getUsuarioId());
                pf.setFuncionarioId(new Funcionario().listarPorId(Integer.parseInt(txtidfunc.getText())).get(0));
                pf.setDataPago(formatador.parse(txtdtpagamento.getText()));
                pf.setValor(Double.parseDouble(txtvalorpago.getText()));
                return pf;
            }
            catch(Exception e){
                return null;
            }
        }
        return null;
    }
    
    
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
            java.util.logging.Logger.getLogger(FramePagFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePagFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePagFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePagFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FramePagFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btefetuarpag;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbdtpagamento;
    private javax.swing.JLabel lbid;
    private javax.swing.JLabel lbidfunc;
    private javax.swing.JLabel lbnomefunc;
    private javax.swing.JLabel lbpagcontas;
    private javax.swing.JLabel lbpesquisa;
    private javax.swing.JLabel lbsalario;
    private javax.swing.JLabel lbvalorpago;
    private javax.swing.JTable tbpagfunc;
    private javax.swing.JTextField txtdtpagamento;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtidfunc;
    private javax.swing.JTextField txtnomefunc;
    private javax.swing.JTextField txtpesquisa;
    private javax.swing.JTextField txtsalario;
    private javax.swing.JTextField txtvalorpago;
    // End of variables declaration//GEN-END:variables
}
