/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorios;

import dao.Conect;
import frames.RelatoriosVendasPorCliente;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Renan 2016
 */
public class RelatoriosPadrao {
    public static void gerarRelatoriosEstoqueCritico(){
        try {
            // TODO add your handling code here:
            Session sessao = Conect.getSessionFactory();
            List estoques;
            Query q = sessao.createQuery("SELECT estoque.codBarra AS estoque_cod_barra, produto.nome AS produto_nome, estoque.quantidade AS estoque_quantidade FROM Produto produto, Estoque estoque WHERE produto.id = estoque.produtoId.id AND estoque.disponivelVenda=TRUE ORDER BY estoque.quantidade ASC, produto.nome ASC");
            q.setMaxResults(20);
            estoques = q.list();
            sessao.close();
            List<Map<String, Object>> listmap = new ArrayList<>();
            for (Object o : estoques) {
                Object[] o1 = (Object[]) o;
                Map<String, Object> map1 = new HashMap();
                map1.put("estoque_cod_barra", o1[0]);
                map1.put("produto_nome", o1[1]);
                map1.put("estoque_quantidade", o1[2]);
                listmap.add(map1);
            }

            JasperReport pathjrxml = JasperCompileManager.compileReport(new RelatoriosPadrao().getClass().getResourceAsStream("RelEstoqueCritico.jrxml"));
            JasperPrint printReport = JasperFillManager.fillReport(pathjrxml, null, new JRBeanCollectionDataSource(listmap));
            //JasperExportManager.exportReportToPdfFile(printReport, "src/relatorios/RelVendasCliente.pdf");
            JasperViewer viewer = new JasperViewer(printReport, false);
                //JRViewer viewer = new JRViewer(printReport, false);
            //viewer.setOpaque(true);
            viewer.setVisible(true);
            viewer.setExtendedState(6);
        } catch (JRException ex) {
            Logger.getLogger(RelatoriosVendasPorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void gerarRelatoriosPatrimonioEstoque() {
        try {
            // TODO add your handling code here:
            Session sessao = Conect.getSessionFactory();
            List estoques;
            Query q = sessao.createQuery("SELECT estoque.codBarra AS estoque_cod_barra, produto.nome AS produto_nome, estoque.quantidade AS estoque_quantidade FROM Produto produto, Estoque estoque WHERE produto.id = estoque.produtoId.id AND estoque.disponivelVenda=TRUE ORDER BY produto.nome ASC");
            estoques = q.list();
            sessao.close();
            List<Map<String, Object>> listmap = new ArrayList<>();
            for (Object o : estoques) {
                Object[] o1 = (Object[]) o;
                Map<String, Object> map1 = new HashMap();
                map1.put("estoque_cod_barra", o1[0]);
                map1.put("produto_nome", o1[1]);
                map1.put("estoque_quantidade", o1[2]);
                listmap.add(map1);
            }

            JasperReport pathjrxml = JasperCompileManager.compileReport(new RelatoriosPadrao().getClass().getResourceAsStream("RelPatrimonioEstoque.jrxml"));
            JasperPrint printReport = JasperFillManager.fillReport(pathjrxml, null, new JRBeanCollectionDataSource(listmap));
            //JasperExportManager.exportReportToPdfFile(printReport, "src/relatorios/RelVendasCliente.pdf");
            JasperViewer viewer = new JasperViewer(printReport, false);
                //JRViewer viewer = new JRViewer(printReport, false);
            //viewer.setOpaque(true);
            viewer.setVisible(true);
            viewer.setExtendedState(6);
        } catch (JRException ex) {
            Logger.getLogger(RelatoriosVendasPorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void gerarRelatoriosProdutosMaisVendidos(Date datainicio, Date datafim) {
        
        try {
            // TODO add your handling code here:
            Session sessao = Conect.getSessionFactory();
            List vendas;
            Query q = sessao.createQuery("SELECT sum(ev.quantidade) AS estoque_venda_quantidade, e.codBarra AS estoque_cod_barra, p.nome AS produto_nome FROM Produto p, Estoque e, EstoqueVenda ev, Venda v WHERE p.id = e.produtoId.id AND e.codBarra = ev.estoque.codBarra AND ev.venda.id = v.id AND e.disponivelVenda = TRUE AND v.dataVenda BETWEEN :pdata_inicio AND :pdata_fim GROUP BY e.codBarra, p.nome, ev.quantidade ORDER BY ev.quantidade DESC, p.nome ASC");
            q.setParameter("pdata_inicio", datainicio);
            q.setParameter("pdata_fim", datafim);
            vendas = q.list();
            sessao.close();
            List<Map<String, Object>> listmap = new ArrayList<>();
            for (Object o : vendas) {
                Object[] o1 = (Object[]) o;
                Map<String, Object> map1 = new HashMap();
                map1.put("estoque_venda_quantidade", o1[0]);
                map1.put("estoque_cod_barra", o1[1]);
                map1.put("produto_nome", o1[2]);
                listmap.add(map1);
            }
            Map<String, Object> map=new HashMap();
            map.put("pdata_inicio", datainicio);
            map.put("pdata_fim", datafim);

            //JasperReport pathjrxml = JasperCompileManager.compileReport("src/relatorios/RelProdutosMaisVendidos.jrxml");
            JasperReport pathjrxml = JasperCompileManager.compileReport(new RelatoriosPadrao().getClass().getResourceAsStream("RelProdutosMaisVendidos.jrxml"));
            JasperPrint printReport = JasperFillManager.fillReport(pathjrxml, map, new JRBeanCollectionDataSource(listmap));
            //JasperExportManager.exportReportToPdfFile(printReport, "src/relatorios/RelVendasCliente.pdf");
            JasperViewer viewer = new JasperViewer(printReport, false);
                //JRViewer viewer = new JRViewer(printReport, false);
            //viewer.setOpaque(true);
            viewer.setVisible(true);
            viewer.setExtendedState(6);
        } catch (JRException ex) {
            Logger.getLogger(RelatoriosVendasPorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }        
                
                
        
    }

    public static void gerarRelatoriosVendasPorPeriodo(Date datainicio, Date datafim) {
        try {
            // TODO add your handling code here:
            Session sessao = Conect.getSessionFactory();
            List vendas;
            Query q = sessao.createQuery("SELECT sum(ev.quantidade) AS total_itens, v.id AS venda_id, v.dataVenda AS venda_data_venda, fp.cartao AS forma_pagamento_cartao, v.valorTotal AS venda_valor_total FROM Venda v, EstoqueVenda ev, FormaPagamento fp WHERE v.id = ev.venda.id AND v.formaPagamentoId.id = fp.id AND v.dataVenda BETWEEN :pdata_inicio AND :pdata_fim GROUP BY v.id, v.dataVenda, fp.cartao, v.valorTotal ORDER BY v.id DESC");
            q.setParameter("pdata_inicio", datainicio);
            q.setParameter("pdata_fim", datafim);
            vendas = q.list();
            sessao.close();
            List<Map<String, Object>> listmap = new ArrayList<>();
            for (Object o : vendas) {
                Object[] o1 = (Object[]) o;
                Map<String, Object> map1 = new HashMap();
                map1.put("total_itens", o1[0]);
                map1.put("venda_id", o1[1]);
                map1.put("venda_data_venda", o1[2]);
                map1.put("forma_pagamento_cartao", o1[3]);
                map1.put("venda_valor_total", o1[4]);
                listmap.add(map1);
            }
            Map<String, Object> map=new HashMap();
            map.put("pdata_inicio", datainicio);
            map.put("pdata_fim", datafim);

            JasperReport pathjrxml = JasperCompileManager.compileReport(new RelatoriosPadrao().getClass().getResourceAsStream("RelVendasPorPeriodo.jrxml"));
            JasperPrint printReport = JasperFillManager.fillReport(pathjrxml, map, new JRBeanCollectionDataSource(listmap));
            //JasperExportManager.exportReportToPdfFile(printReport, "src/relatorios/RelVendasCliente.pdf");
            JasperViewer viewer = new JasperViewer(printReport, false);
                //JRViewer viewer = new JRViewer(printReport, false);
            //viewer.setOpaque(true);
            viewer.setVisible(true);
            viewer.setExtendedState(6);
        } catch (JRException ex) {
            Logger.getLogger(RelatoriosVendasPorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    public static void gerarRelatoriosFinanceiro(Date datainicio, Date datafim) {
        try {
            // TODO add your handling code here:
            Session sessao = Conect.getSessionFactory();
            List movs;
            Query q = sessao.createQuery("SELECT m.descricao AS descricao, m.dataMov AS data, m.entradaOuSaida AS entrada_ou_saida, m.valor AS valor FROM Movimentacao m WHERE m.dataMov BETWEEN  :pdata_inicio AND :pdata_fim ORDER BY m.dataMov DESC, m.id ASC");
            q.setParameter("pdata_inicio", datainicio);
            q.setParameter("pdata_fim", datafim);
            movs = q.list();
            List vendas;
            Query qvenda = sessao.createQuery("SELECT v.id AS id, v.dataVenda AS data, v.valorTotal AS valor FROM Venda v WHERE v.dataVenda BETWEEN  :pdata_inicio AND :pdata_fim ORDER BY v.dataVenda DESC, v.id ASC");
            qvenda.setParameter("pdata_inicio", datainicio);
            qvenda.setParameter("pdata_fim", datafim);
            vendas = qvenda.list();
            List pagamentos;
            Query qpagfunc = sessao.createQuery("SELECT f.clienteId.nome, pf.dataPago, pf.valor FROM PagamentoFuncionario pf, Funcionario f WHERE f.id = pf.funcionarioId.id AND pf.dataPago BETWEEN :pdata_inicio AND :pdata_fim ORDER BY pf.dataPago DESC, f.clienteId.nome ASC");
            qpagfunc.setParameter("pdata_inicio", datainicio);
            qpagfunc.setParameter("pdata_fim", datafim);
            pagamentos = qpagfunc.list();
            List fornecimentos;
            Query qfornecimentos = sessao.createQuery("SELECT f.id, f.dataPedido, f.valorTotal FROM Fornecimento f WHERE f.dataPedido BETWEEN :pdata_inicio AND :pdata_fim ORDER BY f.dataPedido DESC, f.id ASC");
            qfornecimentos.setParameter("pdata_inicio", datainicio);
            qfornecimentos.setParameter("pdata_fim", datafim);
            fornecimentos = qfornecimentos.list();
            sessao.close();
            List<Map<String, Object>> listmap = new ArrayList<>();
            for (Object o : movs) {
                Object[] o1 = (Object[]) o;
                Map<String, Object> map1 = new HashMap();
                map1.put("descricao", o1[0]);
                map1.put("data", o1[1]);
                map1.put("entrada_ou_saida", o1[2]);
                map1.put("valor", o1[3]);
                listmap.add(map1);
            }
            for (Object o : vendas) {
                Object[] o1 = (Object[]) o;
                Map<String, Object> map1 = new HashMap();
                map1.put("descricao", "Venda id: "+o1[0]);
                map1.put("data", o1[1]);
                map1.put("entrada_ou_saida", 'E');
                map1.put("valor", o1[2]);
                listmap.add(map1);
            }
            for (Object o : pagamentos) {
                Object[] o1 = (Object[]) o;
                Map<String, Object> map1 = new HashMap();
                map1.put("descricao", "Pagamento do Funcionário "+o1[0]);
                map1.put("data", o1[1]);
                map1.put("entrada_ou_saida", 'S');
                map1.put("valor", o1[2]);
                listmap.add(map1);
            }
            for (Object o : fornecimentos) {
                Object[] o1 = (Object[]) o;
                Map<String, Object> map1 = new HashMap();
                map1.put("descricao", "Fornecimento id: "+o1[0]);
                map1.put("data", o1[1]);
                map1.put("entrada_ou_saida", 'S');
                map1.put("valor", o1[2]);
                listmap.add(map1);
            }
            Collections.sort(listmap, new Comparator<Map<String,Object>>(){
                public int compare(Map<String,Object> arg1, Map<String,Object> arg2){
                    return ((Date)arg1.get("data")).compareTo((Date)arg2.get("data"));
                }
            });
            
            
            Map<String, Object> map=new HashMap();
            map.put("pdata_inicio", datainicio);
            map.put("pdata_fim", datafim);
            
            JasperReport pathjrxml = JasperCompileManager.compileReport(new RelatoriosPadrao().getClass().getResourceAsStream("RelFinanceiro.jrxml"));
            JasperPrint printReport = JasperFillManager.fillReport(pathjrxml, map, new JRBeanCollectionDataSource(listmap));
            //JasperExportManager.exportReportToPdfFile(printReport, "src/relatorios/RelVendasCliente.pdf");
            JasperViewer viewer = new JasperViewer(printReport, false);
                //JRViewer viewer = new JRViewer(printReport, false);
            //viewer.setOpaque(true);
            viewer.setVisible(true);
            viewer.setExtendedState(6);
        } catch (JRException ex) {
            Logger.getLogger(RelatoriosVendasPorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
    }

    public static void gerarRelatoriosVendasPorCliente(String nomecli, String cpf) {
        try {
            // TODO add your handling code here:
            Session session = Conect.getSessionFactory();
            Map<String, Object> map = new HashMap();
            map.put("pcliente_nome", nomecli);
            map.put("pcliente_cpf", cpf);
            List vendas1 = new ArrayList();
            Query q = session.createQuery("SELECT cliente.nome AS cliente_nome, estoque.codBarra AS estoque_cod_barra, produto.nome AS produto_nome, estoque_venda.valorUnitario AS produto_valor, venda.valorTotal AS venda_valor_total, venda.id AS venda_id, estoque_venda.quantidade FROM Cliente cliente, Venda venda, EstoqueVenda estoque_venda, Estoque estoque, Produto produto WHERE cliente.id = venda.clienteId AND venda.id = estoque_venda.estoqueVendaPK.vendaId AND estoque_venda.estoqueVendaPK.estoqueCodBarra = estoque.codBarra AND estoque.produtoId.id = produto.id AND UPPER(cliente.nome)=UPPER(:pcliente_nome) AND cliente.cpf=:pcliente_cpf ORDER BY venda.dataVenda DESC");
            for (Map.Entry<String, Object> pair : map.entrySet()) {
                q.setParameter(pair.getKey(), pair.getValue());
            }
            vendas1 = q.list();
            List<Map<String, Object>> listmap = new ArrayList<>();
            for (Object o : vendas1) {
                Object[] o1 = (Object[]) o;
                Map<String, Object> map1 = new HashMap();
                map1.put("cliente_nome", o1[0]);
                map1.put("estoque_cod_barra", o1[1]);
                map1.put("produto_nome", o1[2]);
                map1.put("produto_valor", o1[3]);
                map1.put("venda_valor_total", o1[4]);
                map1.put("venda_id", o1[5]);
                map1.put("quantidade", o1[6]);
                map1.put("subtotal", Double.parseDouble(o1[6].toString())*Double.parseDouble(o1[3].toString()));
                listmap.add(map1);
            }

            JasperReport pathjrxml = JasperCompileManager.compileReport(new RelatoriosPadrao().getClass().getResourceAsStream("RelVendasCliente.jrxml"));
            JasperPrint printReport = JasperFillManager.fillReport(pathjrxml, map, new JRBeanCollectionDataSource(listmap));
            //JasperExportManager.exportReportToPdfFile(printReport, "src/relatorios/RelVendasCliente.pdf");
            JasperViewer viewer = new JasperViewer(printReport, false);
                //JRViewer viewer = new JRViewer(printReport, false);
            //viewer.setOpaque(true);
            viewer.setVisible(true);
            viewer.setExtendedState(6);
        } catch (JRException ex) {
            Logger.getLogger(RelatoriosVendasPorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
