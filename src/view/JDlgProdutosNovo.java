/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import bean.MebProdutos;
import dao.ProdutosDAO;
import java.util.List;
import tools.Util;

/**
 *
 * @author maria
 */
public class JDlgProdutosNovo extends javax.swing.JDialog {

ProdutosDAO produtosDAO;    
MebProdutos mebProdutos;
ProdutosController produtosController;
JDlgProdutosNovoIA jDlgProdutosNovoIA;//declarou a variavel para tudo, global    

private boolean incluindo;


    public JDlgProdutosNovo(java.awt.Frame parent, boolean modal) {
      super(parent, modal);
        initComponents();
        setTitle("Cadastro de produto");
        setLocationRelativeTo(null);
        jDlgProdutosNovoIA = new JDlgProdutosNovoIA(null, true);//ele esta chamando a variavel lá de cima, e atribuindo. Mesmo que que tenha a chave, não vai quebrar, vai continuar existendo.
       //se não tivesse global, quebraria
       
       
       jDlgProdutosNovoIA = new JDlgProdutosNovoIA(null, true);
        produtosController = new ProdutosController();
        produtosDAO = new ProdutosDAO();
        List lista = produtosDAO.listAll();
        produtosController.setList(lista);
        jTable1.setModel(produtosController);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jBtn_Meb_Incluir = new javax.swing.JButton();
        jBtn_Meb_Alterar = new javax.swing.JButton();
        jBtn_Meb_Excluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Valor", "Nome", "Quantidade", "Categoria"
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtn_Meb_IncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_Meb_IncluirActionPerformed
        // TODO add your handling code here:
        jDlgProdutosNovoIA.setTitle("Inclusão");
        jDlgProdutosNovoIA.setVisible(true);
        //atualizar a lista no jtable
        
          List lista = produtosDAO.listAll();
          produtosController.setList(lista);
          
    }//GEN-LAST:event_jBtn_Meb_IncluirActionPerformed

    private void jBtn_Meb_AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_Meb_AlterarActionPerformed
     jDlgProdutosNovoIA.setTitle("Alterar");
     jDlgProdutosNovoIA.setVisible(true);
     
     int sel = jTable1.getSelectedRow();//linha selecionada
     MebProdutos mebProdutos = produtosController.getBean(sel);//pega os beans da linha
     jDlgProdutosNovoIA.beanView(mebProdutos); //chamaa a tela IA
     
     //atualizar a lista no jtable
          List lista = produtosDAO.listAll();
          produtosController.setList(lista);
        
    }//GEN-LAST:event_jBtn_Meb_AlterarActionPerformed

    private void jBtn_Meb_ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_Meb_ExcluirActionPerformed
        if(Util.perguntar("Deseja excluir o registro?") == true){
            int sel = jTable1.getSelectedRow();
            mebProdutos = produtosController.getBean(sel);
            produtosDAO.delete(mebProdutos);
            //atualizar a lista no jtable
            List lista = produtosDAO.listAll();
            produtosController.setList(lista);
            
            Util.mensagem("Exclusão feita com sucesso");
        }else{
          Util.mensagem("Exclusao cancelada");
        }
        //atualizar a lista no jtable
          List lista = produtosDAO.listAll();
          produtosController.setList(lista);
    }//GEN-LAST:event_jBtn_Meb_ExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(JDlgProdutosNovo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgProdutosNovo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgProdutosNovo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgProdutosNovo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgProdutosNovo dialog = new JDlgProdutosNovo(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jBtn_Meb_Alterar;
    private javax.swing.JButton jBtn_Meb_Excluir;
    private javax.swing.JButton jBtn_Meb_Incluir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
