/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.MebUsuarios;
import dao.UsuariosDAO;
import java.util.List;

/**
 *
 * @author maria
 */
public class JDlgUsuarioPesquisa extends javax.swing.JDialog {
    
    private JDlgUsuarios jDlgUsuarios; //metodo privado
    
    private  UsuariosController usuariosController = new UsuariosController(); //deixou como global

    UsuariosDAO usuariosDAO;    


    /**
     * Creates new form jDlgUsuarioPesquisa
     */
    public JDlgUsuarioPesquisa(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
         setTitle("Pesquisar Usuarios");
        setLocationRelativeTo(null);
        
        UsuariosDAO usuariosDAO = new UsuariosDAO();
        List lista = usuariosDAO.listAll();
        usuariosController.setList(lista);
        jTable1.setModel(usuariosController); //esta falando que o usuariosControle possui o controle da tabela lá
        
    }
    public void setTelaAnterior(JDlgUsuarios jDlgUsuarios){// Atribui a instância recebida como parâmetro à variável de instância local
        this.jDlgUsuarios = jDlgUsuarios;
        
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
                {null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Apelido", "Cpf"
            }
        ));
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
       
        int rowSel = jTable1.getSelectedRow(); //pegar a linah selecionada
        MebUsuarios mebUsuarios = usuariosController.getBean(rowSel);// Utiliza usuariosController pra ter o objeto MebUsuarios associado à linha selecionada
        jDlgUsuarios.beanView(mebUsuarios);// Chama um método beanView na instância jDlgUsuarios, passando o objeto MebUsuarios para ser exibido 
        setVisible(false);// Oculta a janela atual 
        
      
         
    }//GEN-LAST:event_jBtn_Meb_ConfirmarActionPerformed

    private void jBtn_Meb_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_Meb_CancelarActionPerformed
        // TODO add your handling code here:
        
        System.exit(0);
    }//GEN-LAST:event_jBtn_Meb_CancelarActionPerformed

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
            java.util.logging.Logger.getLogger(JDlgUsuarioPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgUsuarioPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgUsuarioPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgUsuarioPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgUsuarioPesquisa dialog = new JDlgUsuarioPesquisa(new javax.swing.JFrame(), true);
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
