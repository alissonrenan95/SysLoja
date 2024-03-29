/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import relatorios.RelatoriosPadrao;
import BO.Funcionario;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Renan
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
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

        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menucadastro = new javax.swing.JMenu();
        menuitemcliente = new javax.swing.JMenuItem();
        menuitemproduto = new javax.swing.JMenuItem();
        menuitemcategoria = new javax.swing.JMenuItem();
        menuitemfornecedor = new javax.swing.JMenuItem();
        menuitemfuncionario = new javax.swing.JMenuItem();
        menuitemcargo = new javax.swing.JMenuItem();
        menuitemformapag = new javax.swing.JMenuItem();
        menuestoque = new javax.swing.JMenu();
        menuitemconsultaestoque = new javax.swing.JMenuItem();
        menuitemfornecimento = new javax.swing.JMenuItem();
        menuvendas = new javax.swing.JMenu();
        menurelatorios = new javax.swing.JMenu();
        menuitemrelfinanceiro = new javax.swing.JMenuItem();
        menuitemvendasperiodo = new javax.swing.JMenuItem();
        menuitemvendasporcliente = new javax.swing.JMenuItem();
        menuitemestoquecritico = new javax.swing.JMenuItem();
        menuitempatrimonioestoque = new javax.swing.JMenuItem();
        menuitemprodutosmaisvendidos = new javax.swing.JMenuItem();
        menucontabil = new javax.swing.JMenu();
        menuitempagfunc = new javax.swing.JMenuItem();
        menumovcaixa = new javax.swing.JMenu();
        menuconfiguracoes = new javax.swing.JMenu();
        menuitemalterarsenha = new javax.swing.JMenuItem();
        menuitembackup = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SysLoja - Menu Principal");
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 1600, 900));
        setMaximumSize(new java.awt.Dimension(1600, 900));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/logoo2.png"))); // NOI18N

        menucadastro.setText("Cadastro");

        menuitemcliente.setText("Cliente");
        menuitemcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitemclienteActionPerformed(evt);
            }
        });
        menucadastro.add(menuitemcliente);

        menuitemproduto.setText("Produto");
        menuitemproduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitemprodutoActionPerformed(evt);
            }
        });
        menucadastro.add(menuitemproduto);

        menuitemcategoria.setText("Categoria de Produto");
        menuitemcategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitemcategoriaActionPerformed(evt);
            }
        });
        menucadastro.add(menuitemcategoria);

        menuitemfornecedor.setText("Fornecedor");
        menuitemfornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitemfornecedorActionPerformed(evt);
            }
        });
        menucadastro.add(menuitemfornecedor);

        menuitemfuncionario.setText("Funcionário");
        menuitemfuncionario.setEnabled(false);
        menuitemfuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitemfuncionarioActionPerformed(evt);
            }
        });
        menucadastro.add(menuitemfuncionario);

        menuitemcargo.setText("Cargo");
        menuitemcargo.setEnabled(false);
        menuitemcargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitemcargoActionPerformed(evt);
            }
        });
        menucadastro.add(menuitemcargo);

        menuitemformapag.setText("Forma de Pagamento");
        menuitemformapag.setEnabled(false);
        menuitemformapag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitemformapagActionPerformed(evt);
            }
        });
        menucadastro.add(menuitemformapag);

        jMenuBar1.add(menucadastro);

        menuestoque.setText("Estoque");

        menuitemconsultaestoque.setText("Consulta");
        menuitemconsultaestoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitemconsultaestoqueActionPerformed(evt);
            }
        });
        menuestoque.add(menuitemconsultaestoque);

        menuitemfornecimento.setText("Fornecimento");
        menuitemfornecimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitemfornecimentoActionPerformed(evt);
            }
        });
        menuestoque.add(menuitemfornecimento);

        jMenuBar1.add(menuestoque);

        menuvendas.setText("Vendas");
        menuvendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuvendasMouseClicked(evt);
            }
        });
        menuvendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuvendasActionPerformed(evt);
            }
        });
        jMenuBar1.add(menuvendas);

        menurelatorios.setText("Relatórios");

        menuitemrelfinanceiro.setText("Financeiro");
        menuitemrelfinanceiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitemrelfinanceiroActionPerformed(evt);
            }
        });
        menurelatorios.add(menuitemrelfinanceiro);

        menuitemvendasperiodo.setText("Vendas por Período");
        menuitemvendasperiodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitemvendasperiodoActionPerformed(evt);
            }
        });
        menurelatorios.add(menuitemvendasperiodo);

        menuitemvendasporcliente.setText("Vendas por Cliente");
        menuitemvendasporcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitemvendasporclienteActionPerformed(evt);
            }
        });
        menurelatorios.add(menuitemvendasporcliente);

        menuitemestoquecritico.setText("Estoque Crítico");
        menuitemestoquecritico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitemestoquecriticoActionPerformed(evt);
            }
        });
        menurelatorios.add(menuitemestoquecritico);

        menuitempatrimonioestoque.setText("Patrimônio em Estoque");
        menuitempatrimonioestoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitempatrimonioestoqueActionPerformed(evt);
            }
        });
        menurelatorios.add(menuitempatrimonioestoque);

        menuitemprodutosmaisvendidos.setText("Produtos mais Vendidos");
        menuitemprodutosmaisvendidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitemprodutosmaisvendidosActionPerformed(evt);
            }
        });
        menurelatorios.add(menuitemprodutosmaisvendidos);

        jMenuBar1.add(menurelatorios);

        menucontabil.setText("Contábil");

        menuitempagfunc.setText("Pagamento de Funcionários");
        menuitempagfunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitempagfuncActionPerformed(evt);
            }
        });
        menucontabil.add(menuitempagfunc);

        jMenuBar1.add(menucontabil);

        menumovcaixa.setText("Movimentações de Caixa");
        menumovcaixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menumovcaixaMouseClicked(evt);
            }
        });
        menumovcaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menumovcaixaActionPerformed(evt);
            }
        });
        jMenuBar1.add(menumovcaixa);

        menuconfiguracoes.setText("Configurações");

        menuitemalterarsenha.setText("Usuário (alteração de senha)");
        menuitemalterarsenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitemalterarsenhaActionPerformed(evt);
            }
        });
        menuconfiguracoes.add(menuitemalterarsenha);

        menuitembackup.setText("Backup");
        menuitembackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitembackupActionPerformed(evt);
            }
        });
        menuconfiguracoes.add(menuitembackup);

        jMenuBar1.add(menuconfiguracoes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public static Funcionario funcionario=null;
    private void menuitemvendasporclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitemvendasporclienteActionPerformed
        // TODO add your handling code here:
        new RelatoriosVendasPorCliente().setVisible(true);
    }//GEN-LAST:event_menuitemvendasporclienteActionPerformed

    private void menuitemclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitemclienteActionPerformed
        // TODO add your handling code here:
        new CadCliente().setVisible(true);
        
    }//GEN-LAST:event_menuitemclienteActionPerformed

    private void menuvendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuvendasActionPerformed
        // TODO add your handling code here:
        new Vendas().setVisible(true);
        
    }//GEN-LAST:event_menuvendasActionPerformed

    private void menuvendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuvendasMouseClicked
        // TODO add your handling code here:
        new Vendas().setVisible(true);
    }//GEN-LAST:event_menuvendasMouseClicked

    private void menuitemfuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitemfuncionarioActionPerformed
        // TODO add your handling code here:
        new CadFuncionario().setVisible(true);
    }//GEN-LAST:event_menuitemfuncionarioActionPerformed

    private void menuitemfornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitemfornecedorActionPerformed
        // TODO add your handling code here:
        new CadFornecedor().setVisible(true);
    }//GEN-LAST:event_menuitemfornecedorActionPerformed

    private void menuitemprodutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitemprodutoActionPerformed
        // TODO add your handling code here:
        new CadProduto().setVisible(true);
    }//GEN-LAST:event_menuitemprodutoActionPerformed

    private void menuitemcategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitemcategoriaActionPerformed
        // TODO add your handling code here:
        new CadCategoriaProduto().setVisible(true);
    }//GEN-LAST:event_menuitemcategoriaActionPerformed

    private void menuitemformapagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitemformapagActionPerformed
        // TODO add your handling code here:
        new CadFormaPagamento().setVisible(true);
    }//GEN-LAST:event_menuitemformapagActionPerformed

    private void menuitemcargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitemcargoActionPerformed
        // TODO add your handling code here:
        new CadCargo().setVisible(true);
    }//GEN-LAST:event_menuitemcargoActionPerformed

    private void menumovcaixaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menumovcaixaMouseClicked
        // TODO add your handling code here:
        new MovimentacaoCaixa().setVisible(true);
    }//GEN-LAST:event_menumovcaixaMouseClicked

    private void menuitempagfuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitempagfuncActionPerformed
        // TODO add your handling code here:
        new FramePagFuncionario().setVisible(true);
    }//GEN-LAST:event_menuitempagfuncActionPerformed

    private void menuitembackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitembackupActionPerformed
        
        //final List<String> lista=new ArrayList<String>();
        //lista.add("C:\\Program Files (x86)\\PostgreSQL\\8.4\\bin\\pg_dump.exe -i -h 127.0.0.1 -p 5432 -U postgres -F c -b -v -f \"C:\\Temp\\SysLoja.backup\" Loja");
        /*
        try{  
            ProcessBuilder pb;  
            Process p;  
            pb = new ProcessBuilder("C:\\Program Files (x86)\\PostgreSQL\\8.4\\bin\\pg_dump.exe -i -h localhost -p 5432 -U postgres -F c -b -v -f  \"C:\\Temp\\SysLoja.backup\" Loja");
            pb.environment().put("PGPASSWORD", "123456");  
            //pb.redirectErrorStream(true);  
               p = pb.start();
        }catch(Exception ex){  
            JOptionPane.showMessageDialog(null, ex);
            ex.printStackTrace();
        }
        */
        
        try {
            // TODO add your handling code here:
            
            Runtime.getRuntime().exec("\"Program Files (x86)/PostgreSQL/8.4/bin/pg_dump.exe -i -h localhost -p 5432 -U postgres -F c -b -v -f \"C:/Temp/SysLoja.backup\" Loja");
            Runtime.getRuntime().exec("SET PGPASSWORD=123456");
            //System.out.println(process.getErrorStream().);
            JOptionPane.showMessageDialog(rootPane, "Arquivo de backup SysLoja.backup criado no Disco Local C");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, "Permissão negada", "Falha ao realizar Backup", JOptionPane.ERROR_MESSAGE);
        }
        
        
        
    }//GEN-LAST:event_menuitembackupActionPerformed

    private void menuitemconsultaestoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitemconsultaestoqueActionPerformed
        // TODO add your handling code here:
        new ConsultaEstoque().setVisible(true);
    }//GEN-LAST:event_menuitemconsultaestoqueActionPerformed

    private void menuitemfornecimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitemfornecimentoActionPerformed
        // TODO add your handling code here:
        new FrameFornecimento().setVisible(true);
    }//GEN-LAST:event_menuitemfornecimentoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        if(funcionario.getCargoId().getNivelAcesso()==3){
            menuitemfuncionario.setEnabled(true);
            menuitemcargo.setEnabled(true);
            menuitemformapag.setEnabled(true);
        }
    }//GEN-LAST:event_formWindowOpened

    private void menumovcaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menumovcaixaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_menumovcaixaActionPerformed

    private void menuitemalterarsenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitemalterarsenhaActionPerformed
        // TODO add your handling code here:
        new AlterarSenha().setVisible(true);
    }//GEN-LAST:event_menuitemalterarsenhaActionPerformed

    private void menuitemestoquecriticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitemestoquecriticoActionPerformed
        // TODO add your handling code here:
        RelatoriosPadrao.gerarRelatoriosEstoqueCritico();
    }//GEN-LAST:event_menuitemestoquecriticoActionPerformed

    private void menuitempatrimonioestoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitempatrimonioestoqueActionPerformed
        // TODO add your handling code here:
        RelatoriosPadrao.gerarRelatoriosPatrimonioEstoque();
    }//GEN-LAST:event_menuitempatrimonioestoqueActionPerformed

    private void menuitemprodutosmaisvendidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitemprodutosmaisvendidosActionPerformed
        // TODO add your handling code here:
        new RelatoriosProdutosMaisVendidos().setVisible(true);
    }//GEN-LAST:event_menuitemprodutosmaisvendidosActionPerformed

    private void menuitemvendasperiodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitemvendasperiodoActionPerformed
        // TODO add your handling code here:
        new RelatoriosVendasPorPeriodo().setVisible(true);
    }//GEN-LAST:event_menuitemvendasperiodoActionPerformed

    private void menuitemrelfinanceiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitemrelfinanceiroActionPerformed
        // TODO add your handling code here:
        new RelatoriosFinanceiro().setVisible(true);
    }//GEN-LAST:event_menuitemrelfinanceiroActionPerformed

    
    
    
    
    
     /*
    ((DefaultTableModel)tbfornecimento.getModel()).setRowCount(0);
     if(indice!=null){
     ((DefaultTableModel)tbproduto.getModel()).removeRow(indice);
     }
     ((DefaultTableModel)tbproduto.getModel()).insertRow(0, new Object[]{txtcodbarra.getText(), cbnomeproduto.getSelectedItem(), formatnumber.format(estoque.getProduto().getValorUnitario()).replaceAll(",", "."), qtdprodutototal, formatnumber.format(estoque.getProduto().getValorUnitario()*qtdprodutototal).replaceAll(",","."),"",""});
     */
    
    
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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menucadastro;
    private javax.swing.JMenu menuconfiguracoes;
    private javax.swing.JMenu menucontabil;
    private javax.swing.JMenu menuestoque;
    private javax.swing.JMenuItem menuitemalterarsenha;
    private javax.swing.JMenuItem menuitembackup;
    private javax.swing.JMenuItem menuitemcargo;
    private javax.swing.JMenuItem menuitemcategoria;
    private javax.swing.JMenuItem menuitemcliente;
    private javax.swing.JMenuItem menuitemconsultaestoque;
    private javax.swing.JMenuItem menuitemestoquecritico;
    private javax.swing.JMenuItem menuitemformapag;
    private javax.swing.JMenuItem menuitemfornecedor;
    private javax.swing.JMenuItem menuitemfornecimento;
    private javax.swing.JMenuItem menuitemfuncionario;
    private javax.swing.JMenuItem menuitempagfunc;
    private javax.swing.JMenuItem menuitempatrimonioestoque;
    private javax.swing.JMenuItem menuitemproduto;
    private javax.swing.JMenuItem menuitemprodutosmaisvendidos;
    private javax.swing.JMenuItem menuitemrelfinanceiro;
    private javax.swing.JMenuItem menuitemvendasperiodo;
    private javax.swing.JMenuItem menuitemvendasporcliente;
    private javax.swing.JMenu menumovcaixa;
    private javax.swing.JMenu menurelatorios;
    private javax.swing.JMenu menuvendas;
    // End of variables declaration//GEN-END:variables
}
