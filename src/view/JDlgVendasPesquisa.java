/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.MebVendas;
import dao.VendasDAO;
import java.util.List;

/**
 *
 * @author maria
 */
public class JDlgVendasPesquisa extends javax.swing.JDialog {
    
    private JDlgVendas jDlgVendas; //metodo privado
    private  VendasController vendasController = new VendasController(); //deixou como global
    VendasDAO vendasDAO;
    

    /**
     * Creates new form jDlgUsuarioPesquisa
     */
    public JDlgVendasPesquisa(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
         setTitle("Pesquisar Usuarios");
        setLocationRelativeTo(null);
        
        vendasController = new VendasController();
        vendasDAO = new VendasDAO();
        List lista = vendasDAO.listAll();
        vendasController.setList(lista);
        jTable1.setModel(vendasController); //esta falando que o ....Controle possui o controle da tabela lá
        
    }
    public void setTelaAnterior(JDlgVendas jDlgVendas){// Atribui a instância recebida como parâmetro à variável de instância local
        this.jDlgVendas = jDlgVendas;
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jBtn_Meb_Cancelar = new javax.swing.JButton();
        jBtn_Meb_Confirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Clientes", "Data", "Total"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jBtn_Meb_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-cancelar-24.png"))); // NOI18N
        jBtn_Meb_Cancelar.setText("Cancelar");
        jBtn_Meb_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_Meb_CancelarActionPerformed(evt);
            }
        });

        jBtn_Meb_Confirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-ok-24.png"))); // NOI18N
        jBtn_Meb_Confirmar.setText("Confirmar");
        jBtn_Meb_Confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_Meb_ConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(569, 569, 569)
                        .addComponent(jBtn_Meb_Confirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtn_Meb_Cancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtn_Meb_Cancelar)
                    .addComponent(jBtn_Meb_Confirmar))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtn_Meb_ConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_Meb_ConfirmarActionPerformed
        // TODO add your handling code here:
       
        int rowSel = jTable1.getSelectedRow(); //pegar a linha selecionada
        MebVendas mebVendas = vendasController.getBean(rowSel);// Utiliza vendasController pra ter o objeto MebVendas associado à linha selecionada
        jDlgVendas.mebVendas = mebVendas;// Chama um método beanView na instância jDlgVendas, passando o objeto MebVendas para ser exibido 
        jDlgVendas.beanView(mebVendas);// Oculta a janela atual 
        setVisible(false);

         
    }//GEN-LAST:event_jBtn_Meb_ConfirmarActionPerformed

    private void jBtn_Meb_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_Meb_CancelarActionPerformed
        // TODO add your handling code here:
        
        setVisible(false);
    }//GEN-LAST:event_jBtn_Meb_CancelarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount() == 2){
            jBtn_Meb_ConfirmarActionPerformed(null);
        }
        
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(JDlgVendasPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgVendasPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgVendasPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgVendasPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                JDlgVendasPesquisa dialog = new JDlgVendasPesquisa(new javax.swing.JFrame(), true);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
