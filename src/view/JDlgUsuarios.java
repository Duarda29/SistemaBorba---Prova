/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.MebUsuarios;
import dao.UsuariosDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import tools.Util;

/**
 *
 * @author maria
 */
public class JDlgUsuarios extends javax.swing.JDialog {

    //variavel
    //toda vez que declarar uma claase ou variavel, tem que ser local/global e declarar em cima do construtor
    private boolean incluindo;
    MaskFormatter mascaraCpf;
    MaskFormatter mascaraDataDeNascimento;
    public MebUsuarios mebUsuarios;
    public UsuariosDAO usuariosDAO;

    //construtor 
    public JDlgUsuarios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        setTitle("Usuários");
        setLocationRelativeTo(null);

        usuariosDAO = new UsuariosDAO();

        Util.habilitar(false, jTxt_Meb_Codigo, jTxt_Meb_Nome, jTxt_Meb_Apelido, jFmt_Meb_Cpf, jFmt_Meb_DataDeNascimento,
                jPwf_Meb_Senha, jCbo_Meb_Nivel, jChb_Meb_Ativo, jBtn_Meb_Cancelar, jBtn_Meb_Confirmar);
        Util.habilitar(true, jBtn_Meb_Incluir, jBtn_Meb_Alterar, jBtn_Meb_Excluir, jBtn_Meb_Pesquisar);

        try {
            mascaraCpf = new MaskFormatter("###.###.###-##");
            mascaraDataDeNascimento = new MaskFormatter("##/##/####");
        } catch (ParseException ex) {
            Logger.getLogger(JDlgUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        jFmt_Meb_Cpf.setFormatterFactory(new DefaultFormatterFactory(mascaraCpf));
        jFmt_Meb_DataDeNascimento.setFormatterFactory(new DefaultFormatterFactory(mascaraDataDeNascimento));
    }

    public MebUsuarios viewBean() {
        //pega da tela e joga para o bean
        //aqui está criando um bean, pegando as informações das telas e joga no bean para o dao
        //do view pro bean para o dao, depois quando retorna é ao contrário
        //cria o bean e retorna o bean lá em baixo da função. --> do view pro bean para o dao, depois quando retorna é ao contrário --> do dao para o bean e view
        MebUsuarios mebUsuarios = new MebUsuarios(); //criei um bean// estrutura padrão de um método
        mebUsuarios.setIdMebUsuarios(Util.strInt(jTxt_Meb_Codigo.getText()));
        mebUsuarios.setMebNome(jTxt_Meb_Nome.getText());// pegando o que esta na tela e está joganfdo para dentro do  bean
        mebUsuarios.setMebApelido(jTxt_Meb_Apelido.getText());
        mebUsuarios.setMebCpf(jFmt_Meb_Cpf.getText());
        mebUsuarios.setMebDataNascimento(Util.strDate(jFmt_Meb_DataDeNascimento.getText()));
        mebUsuarios.setMebSenha(jPwf_Meb_Senha.getText());
        mebUsuarios.setMebNivel(jCbo_Meb_Nivel.getSelectedIndex());
        mebUsuarios.setMebAtivo(jChb_Meb_Ativo.isSelected() == true ? "S" : "N");
        mebUsuarios.setMebNivel(jCbo_Meb_Nivel.getSelectedIndex());

        if (jChb_Meb_Ativo.isSelected() == true) {// se esta selecionado, manda o sim 
            mebUsuarios.setMebAtivo("S");

        } else {// senão, manda não
            mebUsuarios.setMebAtivo("N");

        }
        return mebUsuarios;
    }

    //Usuarios(Classe?), objeto(bean?)
    public void beanView(MebUsuarios mebUsuarios) {//para pesquisar criamos esse método.

        //pega do bd, traz do bean e mostra na tela
        //set espera string e o idUsuarios é um inteiro, então temos que  "converter"
        String valor = String.valueOf(mebUsuarios.getIdMebUsuarios());
        jTxt_Meb_Codigo.setText(valor);
        jTxt_Meb_Nome.setText(mebUsuarios.getMebNome()); //não precisa converter porque já esta em string
        jTxt_Meb_Apelido.setText(mebUsuarios.getMebApelido());
        jFmt_Meb_Cpf.setText(mebUsuarios.getMebCpf());
        //convertendo de data para string
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        jFmt_Meb_DataDeNascimento.setText(formato.format(mebUsuarios.getMebDataNascimento()));
        jPwf_Meb_Senha.setText(mebUsuarios.getMebSenha());
        jCbo_Meb_Nivel.setSelectedIndex(mebUsuarios.getMebNivel()); //inteiro
        if (mebUsuarios.getMebAtivo().equals("S") == true) {
            jChb_Meb_Ativo.setSelected(true);

        } else {
            jChb_Meb_Ativo.setSelected(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTxt_Meb_Codigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTxt_Meb_Nome = new javax.swing.JTextField();
        jTxt_Meb_Apelido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jFmt_Meb_Cpf = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jFmt_Meb_DataDeNascimento = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jPwf_Meb_Senha = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jCbo_Meb_Nivel = new javax.swing.JComboBox<>();
        jChb_Meb_Ativo = new javax.swing.JCheckBox();
        jBtn_Meb_Incluir = new javax.swing.JButton();
        jBtn_Meb_Alterar = new javax.swing.JButton();
        jBtn_Meb_Excluir = new javax.swing.JButton();
        jBtn_Meb_Confirmar = new javax.swing.JButton();
        jBtn_Meb_Pesquisar = new javax.swing.JButton();
        jBtn_Meb_Cancelar = new javax.swing.JButton();

        jButton5.setText("Confirmar");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Código");

        jLabel2.setText("Nome");

        jLabel4.setText("Apelido");

        jLabel5.setText("CPF");

        jFmt_Meb_Cpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFmt_Meb_CpfActionPerformed(evt);
            }
        });

        jLabel6.setText("Data de Nascimento");

        jFmt_Meb_DataDeNascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFmt_Meb_DataDeNascimentoActionPerformed(evt);
            }
        });

        jLabel3.setText("Senha");

        jLabel7.setText("Nível");

        jCbo_Meb_Nivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escolher", "Administrador", "Convidado", "Finaceiro", " " }));
        jCbo_Meb_Nivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbo_Meb_NivelActionPerformed(evt);
            }
        });

        jChb_Meb_Ativo.setText("Ativo");

        jBtn_Meb_Incluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-divisa-circulada-acima-24 (1).png"))); // NOI18N
        jBtn_Meb_Incluir.setText("Incluir");
        jBtn_Meb_Incluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_Meb_IncluirActionPerformed(evt);
            }
        });

        jBtn_Meb_Alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-alterar-25.png"))); // NOI18N
        jBtn_Meb_Alterar.setText("Alterar");
        jBtn_Meb_Alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_Meb_AlterarActionPerformed(evt);
            }
        });

        jBtn_Meb_Excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-excluir-24.png"))); // NOI18N
        jBtn_Meb_Excluir.setText("Excluir");
        jBtn_Meb_Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_Meb_ExcluirActionPerformed(evt);
            }
        });

        jBtn_Meb_Confirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-ok-24.png"))); // NOI18N
        jBtn_Meb_Confirmar.setText("Confirmar");
        jBtn_Meb_Confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_Meb_ConfirmarActionPerformed(evt);
            }
        });

        jBtn_Meb_Pesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-lupa-24.png"))); // NOI18N
        jBtn_Meb_Pesquisar.setText("Pesquisar");
        jBtn_Meb_Pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_Meb_PesquisarActionPerformed(evt);
            }
        });

        jBtn_Meb_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-cancelar-24.png"))); // NOI18N
        jBtn_Meb_Cancelar.setText("Cancelar");
        jBtn_Meb_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_Meb_CancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jTxt_Meb_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jPwf_Meb_Senha)
                            .addComponent(jFmt_Meb_Cpf))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCbo_Meb_Nivel, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jChb_Meb_Ativo))
                            .addComponent(jLabel7)
                            .addComponent(jFmt_Meb_DataDeNascimento)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtn_Meb_Incluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtn_Meb_Alterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtn_Meb_Excluir)
                        .addGap(14, 14, 14)
                        .addComponent(jBtn_Meb_Confirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtn_Meb_Cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtn_Meb_Pesquisar))
                    .addComponent(jTxt_Meb_Apelido)
                    .addComponent(jTxt_Meb_Nome))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxt_Meb_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxt_Meb_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxt_Meb_Apelido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFmt_Meb_Cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFmt_Meb_DataDeNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPwf_Meb_Senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCbo_Meb_Nivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jChb_Meb_Ativo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtn_Meb_Incluir)
                    .addComponent(jBtn_Meb_Alterar)
                    .addComponent(jBtn_Meb_Excluir)
                    .addComponent(jBtn_Meb_Confirmar)
                    .addComponent(jBtn_Meb_Cancelar)
                    .addComponent(jBtn_Meb_Pesquisar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFmt_Meb_CpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFmt_Meb_CpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFmt_Meb_CpfActionPerformed

    private void jFmt_Meb_DataDeNascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFmt_Meb_DataDeNascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFmt_Meb_DataDeNascimentoActionPerformed

    private void jBtn_Meb_IncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_Meb_IncluirActionPerformed
        //chamei o evento para poder ativar a função habilitar e liberar com campos para preencher
        Util.habilitar(true, jTxt_Meb_Codigo, jTxt_Meb_Apelido, jTxt_Meb_Nome, jFmt_Meb_Cpf, jFmt_Meb_DataDeNascimento, jPwf_Meb_Senha, jCbo_Meb_Nivel, jChb_Meb_Ativo, jBtn_Meb_Cancelar, jBtn_Meb_Confirmar);
        Util.habilitar(false, jBtn_Meb_Incluir, jBtn_Meb_Alterar, jBtn_Meb_Pesquisar, jBtn_Meb_Excluir);
        Util.limparCampos(jTxt_Meb_Codigo, jTxt_Meb_Apelido, jTxt_Meb_Nome, jFmt_Meb_Cpf, jFmt_Meb_DataDeNascimento, jPwf_Meb_Senha, jCbo_Meb_Nivel, jChb_Meb_Ativo);

        incluindo = true;

    }//GEN-LAST:event_jBtn_Meb_IncluirActionPerformed

    private void jBtn_Meb_AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_Meb_AlterarActionPerformed
        // TODO add your handling code here:
        Util.habilitar(true, jTxt_Meb_Codigo, jTxt_Meb_Apelido, jTxt_Meb_Nome, jFmt_Meb_Cpf, jFmt_Meb_DataDeNascimento, jPwf_Meb_Senha, jCbo_Meb_Nivel, jChb_Meb_Ativo, jBtn_Meb_Cancelar, jBtn_Meb_Confirmar);
        Util.habilitar(false, jBtn_Meb_Incluir, jBtn_Meb_Alterar, jBtn_Meb_Excluir, jBtn_Meb_Pesquisar);
        //indica que está no meio de uma alteração
        incluindo = false;
    }//GEN-LAST:event_jBtn_Meb_AlterarActionPerformed

    private void jBtn_Meb_ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_Meb_ExcluirActionPerformed

        int resp =  JOptionPane.showConfirmDialog(null, "Deseja excluir o registro?","Confirmar", JOptionPane.YES_NO_OPTION);// configura qual botão eu quero
        if (resp == JOptionPane.YES_OPTION){// confirma que é a opção sim
                           
        MebUsuarios mebUsuarios = viewBean();
        UsuariosDAO usuariosDAO = new UsuariosDAO();
        usuariosDAO.delete(mebUsuarios); 
        
        }else {
        JOptionPane.showMessageDialog(null, "Exclusão cancelada.","Alerta", 2 );
        
        }
        Util.limparCampos(jTxt_Meb_Codigo, jTxt_Meb_Apelido, jTxt_Meb_Nome, jFmt_Meb_Cpf, jFmt_Meb_DataDeNascimento, jPwf_Meb_Senha, jCbo_Meb_Nivel, jChb_Meb_Ativo);
    }//GEN-LAST:event_jBtn_Meb_ExcluirActionPerformed

    private void jBtn_Meb_ConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_Meb_ConfirmarActionPerformed
        mebUsuarios = viewBean();
        if (incluindo == true) {
            usuariosDAO.insert(mebUsuarios);
        } else {
            usuariosDAO.update(mebUsuarios);
        }
        //pegou o que estava do view passou para o bean, do bean passou para o DAO e do DAO para o banco de dados// apagou os campos e habiliotu e desabilitou
        Util.limparCampos(jTxt_Meb_Codigo, jTxt_Meb_Apelido, jTxt_Meb_Nome, jFmt_Meb_Cpf, jFmt_Meb_DataDeNascimento, jPwf_Meb_Senha, jCbo_Meb_Nivel, jChb_Meb_Ativo);
        Util.habilitar(true, jBtn_Meb_Incluir, jBtn_Meb_Alterar, jBtn_Meb_Excluir, jBtn_Meb_Pesquisar);
        Util.habilitar(false, jTxt_Meb_Codigo, jTxt_Meb_Apelido, jTxt_Meb_Nome, jFmt_Meb_Cpf, jFmt_Meb_DataDeNascimento, jPwf_Meb_Senha, jCbo_Meb_Nivel, jChb_Meb_Ativo, jBtn_Meb_Cancelar, jBtn_Meb_Confirmar);
    }//GEN-LAST:event_jBtn_Meb_ConfirmarActionPerformed

    private void jBtn_Meb_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_Meb_CancelarActionPerformed
        Util.habilitar(true, jBtn_Meb_Incluir, jBtn_Meb_Alterar, jBtn_Meb_Excluir, jBtn_Meb_Pesquisar);
        Util.habilitar(false, jTxt_Meb_Codigo, jTxt_Meb_Apelido, jTxt_Meb_Nome, jFmt_Meb_Cpf, jFmt_Meb_DataDeNascimento, jPwf_Meb_Senha, jCbo_Meb_Nivel, jChb_Meb_Ativo, jBtn_Meb_Cancelar, jBtn_Meb_Confirmar);
        Util.limparCampos(jTxt_Meb_Codigo, jTxt_Meb_Apelido, jTxt_Meb_Nome, jFmt_Meb_Cpf, jFmt_Meb_DataDeNascimento, jPwf_Meb_Senha, jCbo_Meb_Nivel, jChb_Meb_Ativo);
        Util.mensagem("Operação cancelada");
    }//GEN-LAST:event_jBtn_Meb_CancelarActionPerformed

    private void jBtn_Meb_PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_Meb_PesquisarActionPerformed

        //chamei a tela de usuario pesquisa
        JDlgUsuarioPesquisa jDlgUsuarioPesquisa = new JDlgUsuarioPesquisa(null, true);
        jDlgUsuarioPesquisa.setTelaAnterior(this); //esta chamando o metodo do usuario pesquisa
        jDlgUsuarioPesquisa.setVisible(true);


    }//GEN-LAST:event_jBtn_Meb_PesquisarActionPerformed

    private void jCbo_Meb_NivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbo_Meb_NivelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCbo_Meb_NivelActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgUsuarios dialog = new JDlgUsuarios(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jBtn_Meb_Cancelar;
    private javax.swing.JButton jBtn_Meb_Confirmar;
    private javax.swing.JButton jBtn_Meb_Excluir;
    private javax.swing.JButton jBtn_Meb_Incluir;
    private javax.swing.JButton jBtn_Meb_Pesquisar;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jCbo_Meb_Nivel;
    private javax.swing.JCheckBox jChb_Meb_Ativo;
    private javax.swing.JFormattedTextField jFmt_Meb_Cpf;
    private javax.swing.JFormattedTextField jFmt_Meb_DataDeNascimento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField jPwf_Meb_Senha;
    private javax.swing.JTextField jTxt_Meb_Apelido;
    private javax.swing.JTextField jTxt_Meb_Codigo;
    private javax.swing.JTextField jTxt_Meb_Nome;
    // End of variables declaration//GEN-END:variables
}
