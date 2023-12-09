/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import tools.Util;
import bean.MebProdutos;
import dao.ProdutosDAO;
import java.util.List;


/**
 *
 * @author maria
 */
public class JDlgProdutosNovoIA extends javax.swing.JDialog {

ProdutosController produtosController;

JDlgProdutosNovo jDlgProdutosNovo;
    
    public JDlgProdutosNovoIA(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Inclusão");
        setLocationRelativeTo(null);
       
    }

    public MebProdutos viewBean(){
       MebProdutos mebProdutos = new MebProdutos();
       mebProdutos.setIdMebProdutos(Util.strInt(jTxt_Meb_Codigo.getText()));
       mebProdutos.setMebNomeProduto(jTxt_Meb_Nome.getText());
       mebProdutos.setMebCategoria(jCbo_Meb_Categoria.getSelectedIndex());
       mebProdutos.setMebQuantidade(jTxt_Meb_Quantidade.getText());     
       mebProdutos.setMebEntrega(jChb_Meb_Entrega.isSelected() == true ? "S" : "N");
       mebProdutos.setMebComplemento(jTxt_Meb_Complemento.getText());  
       mebProdutos.setMebValorUnitario(Util.strDouble(jTxt_Meb_Valor.getText()));
        return mebProdutos;

    }
    
    public void beanView(MebProdutos mebProdutos) {
    String codigo = String.valueOf(mebProdutos.getIdMebProdutos());
    jTxt_Meb_Codigo.setText(codigo);
    jTxt_Meb_Nome.setText(mebProdutos.getMebNomeProduto()); 
    jCbo_Meb_Categoria.setSelectedIndex(mebProdutos.getMebCategoria()); 
    jTxt_Meb_Quantidade.setText(mebProdutos.getMebQuantidade()); 
    jTxt_Meb_Valor.setText(Util.doubleStr(mebProdutos.getMebValorUnitario()));

    if (jChb_Meb_Entrega.isSelected() == true) {
            mebProdutos.setMebEntrega("S");
        } else {
            mebProdutos.setMebEntrega("N");
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jBtn_Meb_Incluir = new javax.swing.JButton();
        jBtn_Meb_Cancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTxt_Meb_Valor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTxt_Meb_Nome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTxt_Meb_Quantidade = new javax.swing.JTextField();
        jCbo_Meb_Categoria = new javax.swing.JComboBox<>();
        jChb_Meb_Entrega = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTxt_Meb_Complemento = new javax.swing.JTextField();
        jTxt_Meb_Codigo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jBtn_Meb_Incluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-divisa-circulada-acima-24 (1).png"))); // NOI18N
        jBtn_Meb_Incluir.setText("Incluir");
        jBtn_Meb_Incluir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jBtn_Meb_Incluir.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jBtn_Meb_Incluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_Meb_IncluirActionPerformed(evt);
            }
        });
        jPanel1.add(jBtn_Meb_Incluir);

        jBtn_Meb_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-alterar-25.png"))); // NOI18N
        jBtn_Meb_Cancelar.setText("Cancelar");
        jBtn_Meb_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_Meb_CancelarActionPerformed(evt);
            }
        });
        jPanel1.add(jBtn_Meb_Cancelar);

        jLabel1.setText("Código");

        jTxt_Meb_Valor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxt_Meb_ValorActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome");

        jTxt_Meb_Nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxt_Meb_NomeActionPerformed(evt);
            }
        });

        jLabel3.setText("Categoria");

        jCbo_Meb_Categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pizzas", "Bebidas", "Pizza e Bebida" }));

        jChb_Meb_Entrega.setText("Entrega");
        jChb_Meb_Entrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChb_Meb_EntregaActionPerformed(evt);
            }
        });

        jLabel4.setText("Quantidade");

        jLabel5.setText("Descrição");

        jTxt_Meb_Complemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxt_Meb_ComplementoActionPerformed(evt);
            }
        });

        jTxt_Meb_Codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxt_Meb_CodigoActionPerformed(evt);
            }
        });

        jLabel7.setText("Valor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jTxt_Meb_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCbo_Meb_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTxt_Meb_Quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jChb_Meb_Entrega))))
                    .addComponent(jLabel5)
                    .addComponent(jTxt_Meb_Complemento, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(293, 293, 293))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jTxt_Meb_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jTxt_Meb_Valor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTxt_Meb_Valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxt_Meb_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxt_Meb_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxt_Meb_Quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jChb_Meb_Entrega)
                    .addComponent(jCbo_Meb_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxt_Meb_Complemento, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtn_Meb_IncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_Meb_IncluirActionPerformed
        MebProdutos mebProdutos = viewBean(); //tem um objeto atraves do viewBean
      ProdutosDAO produtosDAO = new ProdutosDAO();
      if(getTitle().toUpperCase().substring(0 ,1).equals("I")){//ve se o titulo comeca com I
          produtosDAO.insert(mebProdutos);//se for, insere o produto
      }else{
          produtosDAO.update(mebProdutos);//senão, altera
      }
        setVisible(false);
            
        //atualizar a lista no jtable
          List lista = produtosDAO.listAll();
          produtosController.setList(lista);
        
        Util.limparCampos(jTxt_Meb_Codigo, jTxt_Meb_Nome,jCbo_Meb_Categoria, jTxt_Meb_Quantidade, jChb_Meb_Entrega, jTxt_Meb_Complemento, jTxt_Meb_Valor );
    }//GEN-LAST:event_jBtn_Meb_IncluirActionPerformed

    private void jBtn_Meb_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_Meb_CancelarActionPerformed
        Util.limparCampos(jTxt_Meb_Codigo, jTxt_Meb_Nome,jCbo_Meb_Categoria, jTxt_Meb_Quantidade, jChb_Meb_Entrega, jTxt_Meb_Complemento, jTxt_Meb_Valor );
        Util.mensagem("Operação cancelada");
//fazer um limpar campos aqui
    }//GEN-LAST:event_jBtn_Meb_CancelarActionPerformed

    private void jTxt_Meb_ValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxt_Meb_ValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxt_Meb_ValorActionPerformed

    private void jTxt_Meb_NomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxt_Meb_NomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxt_Meb_NomeActionPerformed

    private void jChb_Meb_EntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChb_Meb_EntregaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jChb_Meb_EntregaActionPerformed

    private void jTxt_Meb_ComplementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxt_Meb_ComplementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxt_Meb_ComplementoActionPerformed

    private void jTxt_Meb_CodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxt_Meb_CodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxt_Meb_CodigoActionPerformed

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
            java.util.logging.Logger.getLogger(JDlgProdutosNovoIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgProdutosNovoIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgProdutosNovoIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgProdutosNovoIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgProdutosNovoIA dialog = new JDlgProdutosNovoIA(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jBtn_Meb_Incluir;
    private javax.swing.JComboBox<String> jCbo_Meb_Categoria;
    private javax.swing.JCheckBox jChb_Meb_Entrega;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTxt_Meb_Codigo;
    private javax.swing.JTextField jTxt_Meb_Complemento;
    private javax.swing.JTextField jTxt_Meb_Nome;
    private javax.swing.JTextField jTxt_Meb_Quantidade;
    private javax.swing.JTextField jTxt_Meb_Valor;
    // End of variables declaration//GEN-END:variables
}
