/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import BO.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author Renan 2016
 */
public class AlterarSenha extends javax.swing.JFrame {

    /**
     * Creates new form AlterarUsuario
     */
    public AlterarSenha() {
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

        lbinfo = new javax.swing.JLabel();
        lbid = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        lbnome = new javax.swing.JLabel();
        txtnome = new javax.swing.JTextField();
        lbsenhaantiga = new javax.swing.JLabel();
        txtsenhaantiga = new javax.swing.JPasswordField();
        lbnovasenha = new javax.swing.JLabel();
        txtnovasenha = new javax.swing.JPasswordField();
        btconfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alterar Senha");
        setMaximumSize(new java.awt.Dimension(345, 363));
        setMinimumSize(new java.awt.Dimension(345, 363));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lbinfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/funcionario.png"))); // NOI18N
        lbinfo.setText("Informações do Usuário");

        lbid.setText("ID");

        txtid.setEditable(false);
        txtid.setEnabled(false);

        lbnome.setText("Nome");

        txtnome.setEditable(false);
        txtnome.setEnabled(false);

        lbsenhaantiga.setText("Senha antiga");

        lbnovasenha.setText("Nova senha");

        btconfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/entrar.png"))); // NOI18N
        btconfirmar.setText("Confirmar");
        btconfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btconfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbinfo)
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbid)
                                        .addComponent(lbnome))
                                    .addGap(50, 50, 50))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbsenhaantiga)
                                    .addGap(14, 14, 14)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbnovasenha)
                                .addGap(20, 20, 20)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btconfirmar)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtnovasenha)
                                .addComponent(txtid)
                                .addComponent(txtnome)
                                .addComponent(txtsenhaantiga, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lbinfo)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbid)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbnome)
                    .addComponent(txtnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbsenhaantiga)
                    .addComponent(txtsenhaantiga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbnovasenha)
                    .addComponent(txtnovasenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btconfirmar)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        Usuario u=MenuPrincipal.funcionario.getUsuarioId();
    }//GEN-LAST:event_formWindowOpened

    private void btconfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btconfirmarActionPerformed
        // TODO add your handling code here:
        if(verificarCamposVazios()){
            if(txtsenhaantiga.getText().equals(MenuPrincipal.funcionario.getUsuarioId().getSenha())){
                Usuario u=new Usuario(Integer.parseInt(txtid.getText()), txtnome.getText(), txtnovasenha.getText(), MenuPrincipal.funcionario.getUsuarioId().getEmail());
                if(u.alterar()){
                    MenuPrincipal.funcionario.setUsuarioId(u);
                    JOptionPane.showMessageDialog(rootPane, "Senha alterada com sucesso!","Operação Efetuada", JOptionPane.INFORMATION_MESSAGE);
                    txtsenhaantiga.setText("");
                    txtnovasenha.setText("");
                }
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Senha antiga incorreta","Erro ao confirmar usuário",JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Preencha todos os campos", "Campos em branco", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btconfirmarActionPerformed

    public Boolean verificarCamposVazios(){
        return !txtid.getText().isEmpty()&&!txtnome.getText().isEmpty()&&!txtsenhaantiga.getText().isEmpty()&&!txtnovasenha.getText().isEmpty();
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
            java.util.logging.Logger.getLogger(AlterarSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlterarSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlterarSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlterarSenha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlterarSenha().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btconfirmar;
    private javax.swing.JLabel lbid;
    private javax.swing.JLabel lbinfo;
    private javax.swing.JLabel lbnome;
    private javax.swing.JLabel lbnovasenha;
    private javax.swing.JLabel lbsenhaantiga;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnome;
    private javax.swing.JPasswordField txtnovasenha;
    private javax.swing.JPasswordField txtsenhaantiga;
    // End of variables declaration//GEN-END:variables
}
