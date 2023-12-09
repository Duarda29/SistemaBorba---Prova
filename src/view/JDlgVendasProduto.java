/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.MebProdutos;
import bean.MebVendasProduto;
import dao.ProdutosDAO;
import java.util.List;
import tools.Util;

/**
 *
 * @author maria
 */
public class JDlgVendasProduto extends javax.swing.JDialog {
    
    JDlgVendas jDlgVendas;
    int numVendaId;
    ProdutosDAO produtosDAO;
    MebProdutos mebProdutos;
   
    public JDlgVendasProduto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Produtos de Vendas");

        
          produtosDAO = new ProdutosDAO();
          
        List lista = (List) produtosDAO.listAll();

   for (int i = 0; i < lista.size(); i++) {
             mebProdutos= (MebProdutos) lista.get(i);
            jCbo_Meb_Produto.addItem(mebProdutos);
        }


    }

    public void setTelaAnterior(JDlgVendas jDlgVendas) {// Atribui a instância recebida como parâmetro à variável de instância local
        this.jDlgVendas = jDlgVendas;
    }
    
       public MebVendasProduto beanView(MebVendasProduto mebVendasProduto){
        
        jCbo_Meb_Produto.setSelectedItem(mebVendasProduto.getMebProdutos());
        jTxt_Meb_Quantidade.setText(String.valueOf(mebVendasProduto.getMebQuantidade()));
        jTxt_Meb_ValorUnitario.setText(String.valueOf(mebVendasProduto.getMebValorUni()));
        return mebVendasProduto;

       }
       

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jCbo_Meb_Produto = new javax.swing.JComboBox<MebProdutos>();
        jTxt_Meb_Quantidade = new javax.swing.JTextField();
        jTxt_Meb_ValorUnitario = new javax.swing.JTextField();
        jBtn_Meb_Confirmar = new javax.swing.JButton();
        jBtn_Meb_Cancelar = new javax.swing.JButton();
        jTxt_Meb_Total = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel5.setText("Produto");

        jLabel6.setText("Valor Unitário");

        jLabel8.setText("Quantidade");

        jCbo_Meb_Produto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCbo_Meb_ProdutoItemStateChanged(evt);
            }
        });
        jCbo_Meb_Produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbo_Meb_ProdutoActionPerformed(evt);
            }
        });

        jTxt_Meb_Quantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxt_Meb_QuantidadeActionPerformed(evt);
            }
        });
        jTxt_Meb_Quantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTxt_Meb_QuantidadeKeyReleased(evt);
            }
        });

        jTxt_Meb_ValorUnitario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxt_Meb_ValorUnitarioActionPerformed(evt);
            }
        });
        jTxt_Meb_ValorUnitario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTxt_Meb_ValorUnitarioKeyReleased(evt);
            }
        });

        jBtn_Meb_Confirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-ok-30.png"))); // NOI18N
        jBtn_Meb_Confirmar.setText("Confirmar");
        jBtn_Meb_Confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_Meb_ConfirmarActionPerformed(evt);
            }
        });

        jBtn_Meb_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-cancelar-30.png"))); // NOI18N
        jBtn_Meb_Cancelar.setText("Cancelar");
        jBtn_Meb_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_Meb_CancelarActionPerformed(evt);
            }
        });

        jTxt_Meb_Total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxt_Meb_TotalActionPerformed(evt);
            }
        });

        jLabel7.setText("Total");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jBtn_Meb_Confirmar)
                        .addGap(40, 40, 40)
                        .addComponent(jBtn_Meb_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jCbo_Meb_Produto, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTxt_Meb_Quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTxt_Meb_ValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(jTxt_Meb_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel5)
                .addGap(13, 13, 13)
                .addComponent(jCbo_Meb_Produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxt_Meb_Quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxt_Meb_ValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxt_Meb_Total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtn_Meb_Confirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jBtn_Meb_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxt_Meb_QuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxt_Meb_QuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxt_Meb_QuantidadeActionPerformed

    private void jTxt_Meb_ValorUnitarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxt_Meb_ValorUnitarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxt_Meb_ValorUnitarioActionPerformed

    private void jBtn_Meb_ConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_Meb_ConfirmarActionPerformed
        // TODO add your handling code here:

        MebVendasProduto mebVendasProduto = new MebVendasProduto();
        mebVendasProduto.setMebProdutos( (MebProdutos) jCbo_Meb_Produto.getSelectedItem() );// Define o produto selecionado no JComboBox como o produto associado à venda
        mebVendasProduto.setMebQuantidade(Util.strDouble(jTxt_Meb_Quantidade.getText() ));// Converte qunatidade para um valor double 
        mebVendasProduto.setMebValorUni(Util.strDouble(jTxt_Meb_ValorUnitario.getText()));
        if (getTitle().toUpperCase().substring(0, 1).equals("I")) {// Verifica se o título começa com a letra 'I' em maiúsculo
         jDlgVendas.vendasProdutoController.addBean(mebVendasProduto);
        } else {            
         jDlgVendas.vendasProdutoController.updateBean(jDlgVendas.getSelectedRowProd(), mebVendasProduto);
        }
        setVisible(false);
    }//GEN-LAST:event_jBtn_Meb_ConfirmarActionPerformed

    private void jBtn_Meb_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_Meb_CancelarActionPerformed
        // TODO add your handling code here:
      //   desabilitar();
        setVisible(false);
    }//GEN-LAST:event_jBtn_Meb_CancelarActionPerformed

    private void jTxt_Meb_QuantidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxt_Meb_QuantidadeKeyReleased
        // TODO add your handling code here:
        
          if (jTxt_Meb_Quantidade.getText().isEmpty() == false) {
            double unitario = Util.strDouble(jTxt_Meb_ValorUnitario.getText());
            double quantidade = Util.strDouble(jTxt_Meb_Quantidade.getText());
              jTxt_Meb_Total.setText(Util.doubleStr(quantidade * unitario));
        } else {
              jTxt_Meb_Total.setText("0");
        }
        
    }//GEN-LAST:event_jTxt_Meb_QuantidadeKeyReleased

    private void jCbo_Meb_ProdutoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCbo_Meb_ProdutoItemStateChanged
        // TODO add your handling code here:
        jTxt_Meb_Quantidade.setText( "1" ); //define 1 no campo de texto 
        MebProdutos mebProdutos = (MebProdutos) jCbo_Meb_Produto.getSelectedItem();// Obtém o item selecionado do JComboBox produto e o converte para um objeto MebProdutos
        jTxt_Meb_ValorUnitario.setText( Util.doubleStr(mebProdutos.getMebValorUnitario()));// Define o valor unitário do produto no campo de texto jdo valor Uni após converter para string usando o método  Util
        jTxt_Meb_Total.setText(jTxt_Meb_ValorUnitario.getText());// Define o mesmo valor do campo valor Uni no campo do total
    }//GEN-LAST:event_jCbo_Meb_ProdutoItemStateChanged

    private void jTxt_Meb_TotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxt_Meb_TotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxt_Meb_TotalActionPerformed

    private void jTxt_Meb_ValorUnitarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxt_Meb_ValorUnitarioKeyReleased
        // TODO add your handling code here:
        
     if(jTxt_Meb_ValorUnitario.getText().isEmpty() == false){// Verifica se o campo de texto  não está vazio
     double unitario = Util.strDouble(jTxt_Meb_ValorUnitario.getText());// Converte o texto do campo  para um valor double usando o método strDouble da classe Util
     double quantidade = Util.strDouble(jTxt_Meb_Quantidade.getText());
     jTxt_Meb_Total.setText(Util.doubleStr(quantidade*unitario)); // Calcula o total * a quantidade pelo valor unitário, converte o resultado para uma string e define no campo total
     }
     else{
     jTxt_Meb_Total.setText("0");// se tiver vaziu, coloca o 0 no campo
     
     
     }

    }//GEN-LAST:event_jTxt_Meb_ValorUnitarioKeyReleased

    private void jCbo_Meb_ProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbo_Meb_ProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCbo_Meb_ProdutoActionPerformed

    
    

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
            java.util.logging.Logger.getLogger(JDlgVendasProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgVendasProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgVendasProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgVendasProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgVendasProduto dialog = new JDlgVendasProduto(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jBtn_Meb_Cancelar;
    private javax.swing.JButton jBtn_Meb_Confirmar;
    private javax.swing.JComboBox<MebProdutos> jCbo_Meb_Produto;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTxt_Meb_Quantidade;
    private javax.swing.JTextField jTxt_Meb_Total;
    private javax.swing.JTextField jTxt_Meb_ValorUnitario;
    // End of variables declaration//GEN-END:variables

}