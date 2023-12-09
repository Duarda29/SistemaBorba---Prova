/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.MebClientes;
import bean.MebVendas;
import bean.MebVendasProduto;
import bean.MebUsuarios;
import dao.ClientesDAO;
import dao.UsuariosDAO;
import dao.VendasDAO;
import dao.VendasProdutoDAO;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import tools.Util;

/**
 *
 * @author maria
 */
public class JDlgVendas extends javax.swing.JDialog {

     MaskFormatter mascaraData;
     private boolean incluindo;
     
     
   public VendasDAO vendasDAO;
   MebVendas mebVendas;
   VendasProdutoController vendasProdutoController;
   public JDlgVendasProduto jDlgVendasProduto;
   MebVendasProduto mebVendasProduto;
   

    /**
     * Creates new form JDlgPedidos
     */
    public JDlgVendas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
          setTitle("Vendas");
        setLocationRelativeTo(null);

       vendasDAO = new VendasDAO();
        List lista = new ArrayList();
        
        
        ClientesDAO clientesDAO = new ClientesDAO();
        List listaCli = clientesDAO.listAll();
        for (int i = 0; i < listaCli.size(); i++) {
            jCbo_Meb_Clientes.addItem((MebClientes) listaCli.get(i));
        }
        
        UsuariosDAO usuariosDAO = new UsuariosDAO();
        List listaVend = usuariosDAO.listAll();
        for (int i = 0; i < listaVend.size(); i++) {
            jCbo_Meb_Vendedor.addItem((MebUsuarios) listaVend.get(i));
        }
        
        
        
        
        vendasProdutoController = new VendasProdutoController();
        jTable1.setModel(vendasProdutoController);
       
        Util.habilitar(false, jTxt_Meb_NumVendas, jFmt_Meb_Data, jTxt_Meb_Total, jCbo_Meb_Clientes, jCbo_Meb_Vendedor, jBtn_Meb_Cancelar, jBtn_Meb_Confirmar);
        Util.habilitar(true, jBtn_Meb_Incluir, jBtn_Meb_Alterar, jBtn_Meb_Excluir, jBtn_Meb_Pesquisar);
        

        try {
            mascaraData = new MaskFormatter("##/##/####");
        } catch (ParseException ex) {
            Logger.getLogger(JDlgVendas.class.getName()).log(Level.SEVERE, null, ex);
        }
        jFmt_Meb_Data.setFormatterFactory(new DefaultFormatterFactory(mascaraData));
    }
    
    
    
     public MebVendas viewBean() {
        MebVendas mebVendas = new MebVendas();
        mebVendas.setIdMebVendas(Util.strInt(jTxt_Meb_NumVendas.getText()));
        mebVendas.setMebData(Util.strDate(jFmt_Meb_Data.getText()));
        mebVendas.setMebClientes((MebClientes) jCbo_Meb_Clientes.getSelectedItem());
        mebVendas.setMebUsuarios((MebUsuarios)jCbo_Meb_Vendedor.getSelectedItem());
        mebVendas.setMebTotal(Util.strDouble(jTxt_Meb_Total.getText()));
        
             return mebVendas;
  
    }
   
    
    public void beanView(MebVendas mebVendas){
        jTxt_Meb_NumVendas.setText(String.valueOf(mebVendas.getIdMebVendas()));
        jFmt_Meb_Data.setText(Util.dateStr(mebVendas.getMebData()));
        jCbo_Meb_Clientes.setSelectedItem(mebVendas.getMebClientes());
        jCbo_Meb_Vendedor.setSelectedItem(mebVendas.getMebUsuarios());
        jTxt_Meb_Total.setText(Util.doubleStr(mebVendas.getMebTotal()));
       
        VendasProdutoDAO vendasProdutoDAO = new VendasProdutoDAO();
        List listaProd = (List) vendasProdutoDAO.listProdutos(mebVendas);

        vendasProdutoController.setList(listaProd);
        
             }
    
    
    public int getSelectedRowProd() {
        return jTable1.getSelectedRow();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTxt_Meb_NumVendas = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jCbo_Meb_Clientes = new javax.swing.JComboBox<MebClientes>();
        jLabel4 = new javax.swing.JLabel();
        jCbo_Meb_Vendedor = new javax.swing.JComboBox<MebUsuarios>();
        jLabel5 = new javax.swing.JLabel();
        jTxt_Meb_Total = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jBtn_Meb_Incluir = new javax.swing.JButton();
        jBtn_Meb_Alterar = new javax.swing.JButton();
        jBtn_Meb_Excluir = new javax.swing.JButton();
        jBtn_Meb_Confirmar = new javax.swing.JButton();
        jBtn_Meb_Cancelar = new javax.swing.JButton();
        jBtn_Meb_Pesquisar = new javax.swing.JButton();
        jBtnIncluirProd = new javax.swing.JButton();
        jBtnAlterarProd = new javax.swing.JButton();
        jBtnExcluirProd = new javax.swing.JButton();
        jFmt_Meb_Data = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Num. Vendas");

        jLabel2.setText("Data");

        jLabel3.setText("Clientes");

        jLabel4.setText("Vendedor");

        jCbo_Meb_Vendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbo_Meb_VendedorActionPerformed(evt);
            }
        });

        jLabel5.setText("Total");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Produto", "Quantidade", "Valor Unitário"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jBtn_Meb_Incluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-divisa-circulada-acima-24.png"))); // NOI18N
        jBtn_Meb_Incluir.setText("Incluir");
        jBtn_Meb_Incluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_Meb_IncluirActionPerformed(evt);
            }
        });
        jPanel1.add(jBtn_Meb_Incluir);

        jBtn_Meb_Alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-alterar-25.png"))); // NOI18N
        jBtn_Meb_Alterar.setText("Alterar");
        jBtn_Meb_Alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_Meb_AlterarActionPerformed(evt);
            }
        });
        jPanel1.add(jBtn_Meb_Alterar);

        jBtn_Meb_Excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-excluir-24.png"))); // NOI18N
        jBtn_Meb_Excluir.setText("Excluir");
        jBtn_Meb_Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_Meb_ExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(jBtn_Meb_Excluir);

        jBtn_Meb_Confirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-ok-24.png"))); // NOI18N
        jBtn_Meb_Confirmar.setText("  Confirmar");
        jBtn_Meb_Confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_Meb_ConfirmarActionPerformed(evt);
            }
        });
        jPanel1.add(jBtn_Meb_Confirmar);

        jBtn_Meb_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-cancelar-24.png"))); // NOI18N
        jBtn_Meb_Cancelar.setText("Cancelar");
        jBtn_Meb_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_Meb_CancelarActionPerformed(evt);
            }
        });
        jPanel1.add(jBtn_Meb_Cancelar);

        jBtn_Meb_Pesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-lupa-24.png"))); // NOI18N
        jBtn_Meb_Pesquisar.setText("Pesquisar");
        jBtn_Meb_Pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_Meb_PesquisarActionPerformed(evt);
            }
        });
        jPanel1.add(jBtn_Meb_Pesquisar);

        jBtnIncluirProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ok.png"))); // NOI18N
        jBtnIncluirProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluirProdActionPerformed(evt);
            }
        });

        jBtnAlterarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/alterar.png"))); // NOI18N
        jBtnAlterarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarProdActionPerformed(evt);
            }
        });

        jBtnExcluirProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit.png"))); // NOI18N
        jBtnExcluirProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirProdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxt_Meb_NumVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jFmt_Meb_Data, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCbo_Meb_Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCbo_Meb_Vendedor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxt_Meb_Total)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBtnAlterarProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtnIncluirProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtnExcluirProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxt_Meb_NumVendas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCbo_Meb_Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCbo_Meb_Vendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxt_Meb_Total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFmt_Meb_Data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jBtnIncluirProd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnAlterarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnExcluirProd, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtn_Meb_IncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_Meb_IncluirActionPerformed
        // TODO add your handling code here:
        
        Util.habilitar(true, jTxt_Meb_NumVendas, jFmt_Meb_Data, jTxt_Meb_Total, jCbo_Meb_Clientes, jCbo_Meb_Vendedor, jBtn_Meb_Cancelar, jBtn_Meb_Confirmar);
        Util.habilitar(false, jBtn_Meb_Incluir, jBtn_Meb_Alterar, jBtn_Meb_Pesquisar, jBtn_Meb_Excluir);
        Util.limparCampos(jTxt_Meb_NumVendas, jFmt_Meb_Data, jTxt_Meb_Total, jCbo_Meb_Clientes, jCbo_Meb_Vendedor);

       vendasProdutoController.setList(new ArrayList());// Limpa a lista de itens do controller de vendasProduto
        jTxt_Meb_NumVendas.grabFocus();// Define o foco para o campo de texto 
        incluindo = true;
        mebVendas = new MebVendas();
    }//GEN-LAST:event_jBtn_Meb_IncluirActionPerformed

    private void jBtn_Meb_AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_Meb_AlterarActionPerformed
        // TODO add your handling code here:
        Util.habilitar(true, jTxt_Meb_NumVendas, jFmt_Meb_Data, jTxt_Meb_Total, jCbo_Meb_Clientes, jCbo_Meb_Vendedor, jBtn_Meb_Cancelar, jBtn_Meb_Confirmar);
        Util.habilitar(false, jBtn_Meb_Incluir, jBtn_Meb_Alterar, jBtn_Meb_Pesquisar);
         if (mebVendas != null) {
        //    habilitar(true);
            incluindo = false;
        } else {
            Util.mensagem("Deve ser realizada uma pesquisa antes");
        }
        
    }//GEN-LAST:event_jBtn_Meb_AlterarActionPerformed

    private void jBtn_Meb_ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_Meb_ExcluirActionPerformed
       
         if (mebVendas != null) {//verifica se não é nulo
            if (Util.perguntar("Deseja excluir o pedido?") == true){// Se o usuário confirmar a exclusão do pedido {
                VendasProdutoDAO pedidosProdutosDAO = new VendasProdutoDAO();
                MebVendasProduto mebVendasProduto;// Declaração da variável para armazenar cada produto em uma venda
                for (int linha = 0; linha < jTable1.getRowCount(); linha++) {
                    mebVendasProduto = vendasProdutoController.getBean(linha);//pega o bean da linha
                    pedidosProdutosDAO.delete(mebVendasProduto);//exclui o produto
                }
                vendasDAO.delete(mebVendas);// exclui a venda
            }
        } else {
            Util.mensagem("Deve ser realizada uma pesquisa antes");
        }
        

        Util.limparCampos(jTxt_Meb_NumVendas, jFmt_Meb_Data, jTxt_Meb_Total, jCbo_Meb_Clientes, jCbo_Meb_Vendedor);
        mebVendas= null;
    }//GEN-LAST:event_jBtn_Meb_ExcluirActionPerformed

    private void jBtn_Meb_ConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_Meb_ConfirmarActionPerformed
        // TODO add your handling code here:
                  mebVendas = viewBean();
        if (incluindo == true) {//verifica se é inclusão
            vendasDAO.insert(mebVendas);//insere no banco
            VendasProdutoDAO vendasProdutoDAO = new VendasProdutoDAO();
            MebVendasProduto mebVendasProduto;// Declaração da variável para armazenar cada produto em uma venda
            for (int linha = 0; linha < jTable1.getRowCount(); linha++) {
                mebVendasProduto = vendasProdutoController.getBean(linha);//pega a linha selecionada
                mebVendasProduto.setMebVendas(mebVendas);
                vendasProdutoDAO.insert(mebVendasProduto);//insere o produto no banco
            }
        } else {
            vendasDAO.update(mebVendas);//se não for inclusão, é alteração
            
            //remover todos os vendas produtos desta vendas
             VendasProdutoDAO vendasProdutoDAO = new VendasProdutoDAO();
                for (int linha = 0; linha < jTable1.getRowCount(); linha++) {
                mebVendasProduto = vendasProdutoController.getBean(linha);
                mebVendasProduto.setMebVendas(mebVendas);//coloca o vendas no vendas produto
                vendasProdutoDAO.delete(mebVendasProduto);
                }
            //incluir todos os vendasProduto que estao no jtable
            
            for (int linha = 0; linha < jTable1.getRowCount(); linha++) {
                mebVendasProduto = vendasProdutoController.getBean(linha);
                mebVendasProduto.setMebVendas(mebVendas);//coloca o vendas no vendas produto
                vendasProdutoDAO.insert(mebVendasProduto);
            }
        }
        //pegou o que estava do view passou para o bean, do bean passou para o DAO e do DAO para o banco de dados// apagou os campos e habiliotu e desabilitou
        Util.limparCampos(jTxt_Meb_NumVendas, jTxt_Meb_Total, jCbo_Meb_Clientes, jCbo_Meb_Vendedor,jFmt_Meb_Data);
        Util.habilitar(true, jBtn_Meb_Incluir, jBtn_Meb_Alterar, jBtn_Meb_Excluir, jBtn_Meb_Pesquisar);
        Util.habilitar(false, jTxt_Meb_NumVendas, jFmt_Meb_Data, jTxt_Meb_Total, jCbo_Meb_Clientes, jCbo_Meb_Vendedor, jBtn_Meb_Cancelar, jBtn_Meb_Confirmar);
        vendasProdutoController.setList(new ArrayList());

        mebVendas = null;                   

    }//GEN-LAST:event_jBtn_Meb_ConfirmarActionPerformed

    private void jBtn_Meb_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_Meb_CancelarActionPerformed
        // TODO add your handling code here:
             Util.habilitar(true, jBtn_Meb_Incluir, jBtn_Meb_Alterar, jBtn_Meb_Excluir, jBtn_Meb_Pesquisar);
        Util.habilitar(false, jTxt_Meb_NumVendas, jFmt_Meb_Data, jTxt_Meb_Total, jCbo_Meb_Clientes, jCbo_Meb_Vendedor, jBtn_Meb_Cancelar, jBtn_Meb_Confirmar);
        Util.limparCampos(jTxt_Meb_NumVendas, jFmt_Meb_Data, jTxt_Meb_Total, jCbo_Meb_Clientes, jCbo_Meb_Vendedor);
        Util.mensagem("Operação cancelada");
        vendasProdutoController.setList(new ArrayList());

               mebVendas = null;                   

    }//GEN-LAST:event_jBtn_Meb_CancelarActionPerformed

    private void jBtn_Meb_PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_Meb_PesquisarActionPerformed
        JDlgVendasPesquisa jDlgVendasPesquisa = new JDlgVendasPesquisa(null, true); 
        jDlgVendasPesquisa.setTelaAnterior(this);
        jDlgVendasPesquisa.setVisible(true);
        
   Util.habilitar(true, jTxt_Meb_NumVendas, jFmt_Meb_Data, jTxt_Meb_Total, jCbo_Meb_Clientes, jCbo_Meb_Vendedor, jBtn_Meb_Cancelar, jBtn_Meb_Confirmar);
   Util.habilitar(false,  jBtn_Meb_Pesquisar, jBtn_Meb_Incluir);


    }//GEN-LAST:event_jBtn_Meb_PesquisarActionPerformed

    
 //////////////////////////////////////////////////////////////////////////////////////////   
    
 
    private void jBtnIncluirProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirProdActionPerformed
        // TODO add your handling code here:
        
        jDlgVendasProduto = new JDlgVendasProduto(null, true);
        jDlgVendasProduto.setTitle("Inclusão de produtos");
        jDlgVendasProduto.setTelaAnterior(this);
        jDlgVendasProduto.setVisible(true);
               
         
    }//GEN-LAST:event_jBtnIncluirProdActionPerformed

    private void jBtnAlterarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarProdActionPerformed

       int rowSel = jTable1.getSelectedRow(); //pegar a linha selecionada
        if (rowSel != -1){//veririca se a alguma linha foi selecionada
          mebVendasProduto = vendasProdutoController.getBean(rowSel);
          
          jDlgVendasProduto = new JDlgVendasProduto(new javax.swing.JFrame(), true);// Cria uma instância do formulário de alteração de produtos em vendas
          incluindo = false;//define que não é inclusão
          jDlgVendasProduto.setTitle("Alteração de Produtos");
          jDlgVendasProduto.setTelaAnterior(this);
          jDlgVendasProduto.beanView(mebVendasProduto);//pega as informações da tala 
          
          jDlgVendasProduto.setVisible(true);
        Util.habilitar(true, jBtn_Meb_Incluir, jBtn_Meb_Alterar, jBtn_Meb_Excluir, jBtn_Meb_Pesquisar);
        Util.habilitar(false, jTxt_Meb_NumVendas, jFmt_Meb_Data, jTxt_Meb_Total, jCbo_Meb_Clientes, jCbo_Meb_Vendedor, jBtn_Meb_Cancelar, jBtn_Meb_Confirmar);
     
        } else{
            Util.mensagem("Selecione um registro para fazer alteração");
        }
    }//GEN-LAST:event_jBtnAlterarProdActionPerformed

    private void jBtnExcluirProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirProdActionPerformed
        // TODO add your handling code here:
        if(getSelectedRowProd() == -1){// Verifica se nenhuma linha foi selecionada na tabela
            Util.mensagem("Nenhuma linha selecionada");
        }else{
            if(Util.perguntar("Confrima a exclusão do produto??") == true){
           ((VendasProdutoController) jTable1.getModel()).removeBean(getSelectedRowProd());

            }
        }
    }//GEN-LAST:event_jBtnExcluirProdActionPerformed

    private void jCbo_Meb_VendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbo_Meb_VendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCbo_Meb_VendedorActionPerformed

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
            java.util.logging.Logger.getLogger(JDlgVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgVendas dialog = new JDlgVendas(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAlterarProd;
    private javax.swing.JButton jBtnExcluirProd;
    private javax.swing.JButton jBtnIncluirProd;
    private javax.swing.JButton jBtn_Meb_Alterar;
    private javax.swing.JButton jBtn_Meb_Cancelar;
    private javax.swing.JButton jBtn_Meb_Confirmar;
    private javax.swing.JButton jBtn_Meb_Excluir;
    private javax.swing.JButton jBtn_Meb_Incluir;
    private javax.swing.JButton jBtn_Meb_Pesquisar;
    private javax.swing.JComboBox<MebClientes> jCbo_Meb_Clientes;
    private javax.swing.JComboBox<MebUsuarios> jCbo_Meb_Vendedor;
    private javax.swing.JFormattedTextField jFmt_Meb_Data;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTxt_Meb_NumVendas;
    private javax.swing.JTextField jTxt_Meb_Total;
    // End of variables declaration//GEN-END:variables
}
