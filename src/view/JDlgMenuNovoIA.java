/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.MebMenu;
import dao.MenuDAO;
import tools.Util;

/**
 *
 * @author maria
 */
public class JDlgMenuNovoIA extends javax.swing.JDialog {

JDlgMenuNovo jDlgMenuNovo;
  public MebMenu mebMenu;
    public MenuDAO menuDAO;
        
    public JDlgMenuNovoIA(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Inclusão");
        setLocationRelativeTo(null);

    }

   public MebMenu viewBean(){
       MebMenu mebMenu = new MebMenu();
       mebMenu.setIdMebMenu(Util.strInt(jTxt_Meb_Codigo.getText()));
       mebMenu.setMebPizza(jCbo_Meb_Pizza.getSelectedIndex());
       mebMenu.setMebBebidas(jCbo_Meb_Bebidas.getSelectedIndex());
       mebMenu.setMebTamanhos(jCbo_Meb_tamanhos.getSelectedIndex());
       mebMenu.setMebBorda(jTxt_Meb_Bordas.getText());     
       mebMenu.setMebPorcao(jTxt_Meb_Porcao.getText());

        return mebMenu;

   }
    
    public void beanView(MebMenu mebMenu) {
    String valor = String.valueOf(mebMenu.getIdMebMenu());
    jTxt_Meb_Codigo.setText(valor);
    jCbo_Meb_Pizza.setSelectedIndex(mebMenu.getMebPizza()); 
    jCbo_Meb_Bebidas.setSelectedIndex(mebMenu.getMebBebidas()); 
    jCbo_Meb_tamanhos.setSelectedIndex(mebMenu.getMebTamanhos()); 
    jTxt_Meb_Bordas.setText(mebMenu.getMebBorda()); 
    jTxt_Meb_Porcao.setText(mebMenu.getMebPorcao()); 
        
    }
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTxt_Meb_Codigo = new javax.swing.JTextField();
        jCbo_Meb_Pizza = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jCbo_Meb_Bebidas = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jCbo_Meb_tamanhos = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTxt_Meb_Bordas = new javax.swing.JTextField();
        jTxt_Meb_Porcao = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jBtn_Meb_Incluir = new javax.swing.JButton();
        jBtn_Meb_Cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Código");

        jTxt_Meb_Codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxt_Meb_CodigoActionPerformed(evt);
            }
        });

        jCbo_Meb_Pizza.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Calabresa", "Frango c/ Catupity", "Napolitano", "Abacaxi", "Portuguesa", "4 Queijos", "Moda da casa", " Brigadeiro" }));
        jCbo_Meb_Pizza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbo_Meb_PizzaActionPerformed(evt);
            }
        });

        jLabel3.setText("Pizza");

        jCbo_Meb_Bebidas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Suco de Laranja", "Suco de Abacaxi ", "Suco de Uva", "Suco de Acerola", "Fanta Uva", "Fanta Laranja", "Fanta Guarana", "Cola-Cola", "Pepsi", "Conti-Cola", "Água", " " }));

        jLabel4.setText("Bebidas");

        jCbo_Meb_tamanhos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pequena", "Média", "Grande", "Extra Grande" }));

        jLabel5.setText("Tamanhos");

        jLabel2.setText("Bordas");

        jLabel6.setText("Porção");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jBtn_Meb_Incluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-divisa-circulada-acima-24.png"))); // NOI18N
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jTxt_Meb_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCbo_Meb_Bebidas, 0, 200, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addComponent(jCbo_Meb_tamanhos, 0, 200, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addComponent(jCbo_Meb_Pizza, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTxt_Meb_Porcao, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTxt_Meb_Bordas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6))
                .addGap(33, 33, 33))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxt_Meb_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCbo_Meb_Pizza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxt_Meb_Bordas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCbo_Meb_Bebidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jTxt_Meb_Porcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCbo_Meb_tamanhos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxt_Meb_CodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxt_Meb_CodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxt_Meb_CodigoActionPerformed

    private void jBtn_Meb_IncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_Meb_IncluirActionPerformed
     
      MebMenu mebMenu = viewBean();//tem um objeto atraves do viewBean
      MenuDAO menuDAO = new MenuDAO();
      if(getTitle().toUpperCase().substring(0 ,1).equals("I")){//ve se o titulo comeca com I
          menuDAO.insert(mebMenu);//se for, insere o menu
      }else{
          menuDAO.update(mebMenu);//senão, altera
      }
        setVisible(false);
              
            Util.limparCampos(jTxt_Meb_Codigo, jCbo_Meb_Pizza,jCbo_Meb_Bebidas, jCbo_Meb_tamanhos, jTxt_Meb_Bordas,jTxt_Meb_Porcao);

    }//GEN-LAST:event_jBtn_Meb_IncluirActionPerformed

    private void jBtn_Meb_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_Meb_CancelarActionPerformed

    Util.limparCampos(jTxt_Meb_Codigo, jCbo_Meb_Pizza,jCbo_Meb_Bebidas, jCbo_Meb_tamanhos, jTxt_Meb_Bordas,jTxt_Meb_Porcao);
    Util.mensagem("Operação cancelada");

    }//GEN-LAST:event_jBtn_Meb_CancelarActionPerformed

    private void jCbo_Meb_PizzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbo_Meb_PizzaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCbo_Meb_PizzaActionPerformed

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
            java.util.logging.Logger.getLogger(JDlgMenuNovoIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgMenuNovoIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgMenuNovoIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgMenuNovoIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgMenuNovoIA dialog = new JDlgMenuNovoIA(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> jCbo_Meb_Bebidas;
    private javax.swing.JComboBox<String> jCbo_Meb_Pizza;
    private javax.swing.JComboBox<String> jCbo_Meb_tamanhos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTxt_Meb_Bordas;
    private javax.swing.JTextField jTxt_Meb_Codigo;
    private javax.swing.JTextField jTxt_Meb_Porcao;
    // End of variables declaration//GEN-END:variables

    void setMebMenu(MebMenu mebMenu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
