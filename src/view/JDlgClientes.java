package view;

import bean.MebClientes;
import dao.ClientesDAO;
import java.text.ParseException;
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
public class JDlgClientes extends javax.swing.JDialog {

     //variavel
    //toda vez que declarar uma claase ou variavel, tem que ser local/global e declarar em cima do construtor
    private boolean incluindo;
    MaskFormatter mascaraCpf; 
    MaskFormatter mascaraRg;
    MaskFormatter mascaraCep;
    MaskFormatter mascaraCelular;
    MaskFormatter mascaraTelefoneResidencial;
    public MebClientes mebClientes;
    public ClientesDAO clientesDAO;
    
    public JDlgClientes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
         setTitle("Clientes");
        setLocationRelativeTo(null);
        
                clientesDAO = new ClientesDAO();

        
        Util.habilitar(false, jTxt_Meb_Codigo, jTxt_Meb_Nome, jTxt_Meb_Sobrenome, jFmt_Meb_Cpf, jTxt_Meb_Genero,jFmt_Meb_Rg,
        jTxt_Meb_Endereco,jTxt_Meb_Bairro,jFmt_Meb_Cep, jTxt_Meb_NumCasa,jFmt_Meb_Celular, jCbo_Meb_Estado, jCbo_Meb_Pais,
        jFmt_Meb_TelefoneResidencial,jTxt_Meb_Email,jBtn_Meb_Cancelar, jBtn_Meb_Confirmar);
        Util.habilitar(true, jBtn_Meb_Incluir, jBtn_Meb_Alterar, jBtn_Meb_Excluir, jBtn_Meb_Pesquisar);
        
        
         try {
            mascaraCpf = new MaskFormatter("###.###.###-##");
            mascaraRg = new MaskFormatter("#.###.###");
            mascaraCep = new MaskFormatter("#####-###");
            mascaraCelular = new MaskFormatter("+## (##) # ####-####");
            mascaraTelefoneResidencial = new MaskFormatter("#####-####");
            
        } catch (ParseException ex) {
            Logger.getLogger(JDlgUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        jFmt_Meb_Cpf.setFormatterFactory(new DefaultFormatterFactory(mascaraCpf));
        jFmt_Meb_Rg.setFormatterFactory(new DefaultFormatterFactory(mascaraRg));
        jFmt_Meb_Cep.setFormatterFactory(new DefaultFormatterFactory(mascaraCep));
        jFmt_Meb_Celular.setFormatterFactory(new DefaultFormatterFactory(mascaraCelular));
        jFmt_Meb_TelefoneResidencial.setFormatterFactory(new DefaultFormatterFactory(mascaraTelefoneResidencial));
       

    }

    public  MebClientes viewBean(){
        //pega da tela e joga para o bean
        //aqui está criando um bean, pegando as informações das telas e joga no bean para o dao
        //do view pro bean para o dao, depois quando retorna é ao contrário
        //cria o bean e retorna o bean lá em baixo da função. --> do view pro bean para o dao, depois quando retorna é ao contrário --> do dao para o bean e view
          MebClientes clientes = new MebClientes(); //criei um bean// estrutura padrão de um método
        int id = Integer.valueOf(jTxt_Meb_Codigo.getText() );// converteu porque id não é string
        clientes.setIdMebClientes(id);
        clientes.setMebNome(jTxt_Meb_Nome.getText() );// pegando o que esta na tela e está joganfdo para dentro do  bean
        clientes.setMebSobrenome(jTxt_Meb_Sobrenome.getText() );
        clientes.setMebGenero(jTxt_Meb_Genero.getText() );
        clientes.setMebCpf(jFmt_Meb_Cpf.getText());
        clientes.setMebRg(jFmt_Meb_Rg.getText());
        clientes.setMebEndereco(jTxt_Meb_Endereco.getText() );
        clientes.setMebBairro(jTxt_Meb_Bairro.getText() );
        clientes.setMebCep(jFmt_Meb_Cep.getText());
        clientes.setMebNumCasa(jTxt_Meb_NumCasa.getText() );
        clientes.setMebPais( jCbo_Meb_Pais.getSelectedIndex());        
        clientes.setMebEstado( jCbo_Meb_Estado.getSelectedIndex());
        clientes.setMebCelular(jFmt_Meb_Celular.getText());
        clientes.setMebTelefoneResidencial(jFmt_Meb_TelefoneResidencial.getText());
        clientes.setMebEmail(jTxt_Meb_Email.getText() );

        return clientes;
    }
    
                         //Clientes(Classe?), objeto(bean?)
    public void beanView(MebClientes clientes){//para pesquisar criamos esse método.
        
            //pega do bd, traz do bean e mostra na tela
                   
            //set espera string e o idUsuarios é um inteiro, então temos que  "converter"
            String valor = String .valueOf(clientes.getIdMebClientes());
            jTxt_Meb_Codigo.setText(valor); 
            jTxt_Meb_Nome.setText(clientes.getMebNome()); //não precisa converter porque já esta em string
            jTxt_Meb_Sobrenome.setText(clientes.getMebSobrenome());
            jTxt_Meb_Genero.setText(clientes.getMebGenero());
            jFmt_Meb_Cpf.setText(clientes.getMebCpf());
            jFmt_Meb_Rg.setText(clientes.getMebRg());
            jTxt_Meb_Endereco.setText(clientes.getMebEndereco());
            jTxt_Meb_Bairro.setText(clientes.getMebBairro());
            jFmt_Meb_Cep.setText(clientes.getMebCep());
            jTxt_Meb_NumCasa.setText(clientes.getMebNumCasa());
            jCbo_Meb_Pais.setSelectedIndex(clientes.getMebPais()); //inteiro
            jCbo_Meb_Estado.setSelectedIndex(clientes.getMebEstado()); //inteiro
            jFmt_Meb_Celular.setText(clientes.getMebCelular());
            jFmt_Meb_TelefoneResidencial.setText(clientes.getMebTelefoneResidencial());
            jTxt_Meb_Email.setText(clientes.getMebEmail());
           
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTxt_Meb_Codigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTxt_Meb_Nome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTxt_Meb_Sobrenome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTxt_Meb_Genero = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jFmt_Meb_Rg = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jFmt_Meb_Cpf = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jTxt_Meb_Endereco = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTxt_Meb_Bairro = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jFmt_Meb_Cep = new javax.swing.JFormattedTextField();
        jTxt_Meb_NumCasa = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jCbo_Meb_Pais = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jCbo_Meb_Estado = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jFmt_Meb_Celular = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        jFmt_Meb_TelefoneResidencial = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        jTxt_Meb_Email = new javax.swing.JTextField();
        jBtn_Meb_Incluir = new javax.swing.JButton();
        jBtn_Meb_Alterar = new javax.swing.JButton();
        jBtn_Meb_Excluir = new javax.swing.JButton();
        jBtn_Meb_Confirmar = new javax.swing.JButton();
        jBtn_Meb_Pesquisar = new javax.swing.JButton();
        jBtn_Meb_Cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Código");

        jTxt_Meb_Codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxt_Meb_CodigoActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome");

        jLabel3.setText("Sobrenome");

        jLabel4.setText("Gênero");

        jLabel5.setText("RG");

        jLabel6.setText("CPF");

        jLabel7.setText("Endereço");

        jTxt_Meb_Endereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxt_Meb_EnderecoActionPerformed(evt);
            }
        });

        jLabel8.setText("Bairro");

        jLabel9.setText("CEP");

        jLabel10.setText("Nº da Casa");

        jLabel11.setText("Pais");

        jCbo_Meb_Pais.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Brasil", "Paraguai" }));

        jLabel12.setText("Estados");

        jCbo_Meb_Estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO", "DF", "PJC - Paraguai" }));
        jCbo_Meb_Estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbo_Meb_EstadoActionPerformed(evt);
            }
        });

        jLabel13.setText("Celular");

        jLabel14.setText("Telefone Residencial");

        jLabel15.setText("E-mail");

        jBtn_Meb_Incluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-divisa-circulada-acima-24.png"))); // NOI18N
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtn_Meb_Incluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtn_Meb_Alterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtn_Meb_Excluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtn_Meb_Confirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtn_Meb_Cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtn_Meb_Pesquisar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel15)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jTxt_Meb_Genero, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jFmt_Meb_Rg))
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTxt_Meb_Nome, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(79, 79, 79)
                                        .addComponent(jLabel5))
                                    .addComponent(jTxt_Meb_Endereco, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jTxt_Meb_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9)
                                            .addComponent(jFmt_Meb_Cep, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTxt_Meb_NumCasa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10))))
                                .addComponent(jLabel7)
                                .addComponent(jLabel13)
                                .addComponent(jFmt_Meb_Celular, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(61, 61, 61)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jFmt_Meb_Cpf)
                                .addComponent(jTxt_Meb_Sobrenome)
                                .addComponent(jFmt_Meb_TelefoneResidencial)
                                .addComponent(jTxt_Meb_Bairro)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jCbo_Meb_Pais, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11))
                                    .addGap(41, 41, 41)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel12)
                                        .addComponent(jCbo_Meb_Estado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel14)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel3))
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addComponent(jTxt_Meb_Email)))
                .addGap(9, 9, 9))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxt_Meb_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxt_Meb_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTxt_Meb_Genero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFmt_Meb_Rg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxt_Meb_Endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFmt_Meb_Cep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxt_Meb_NumCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFmt_Meb_Celular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxt_Meb_Sobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFmt_Meb_Cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxt_Meb_Bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCbo_Meb_Pais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCbo_Meb_Estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jFmt_Meb_TelefoneResidencial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(29, 29, 29)))))
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxt_Meb_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtn_Meb_Incluir)
                    .addComponent(jBtn_Meb_Alterar)
                    .addComponent(jBtn_Meb_Excluir)
                    .addComponent(jBtn_Meb_Confirmar)
                    .addComponent(jBtn_Meb_Cancelar)
                    .addComponent(jBtn_Meb_Pesquisar))
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxt_Meb_CodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxt_Meb_CodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxt_Meb_CodigoActionPerformed

    private void jTxt_Meb_EnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxt_Meb_EnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxt_Meb_EnderecoActionPerformed

    private void jBtn_Meb_IncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_Meb_IncluirActionPerformed
        //chamei o evento para poder ativar a função habilitar e liberar com campos para preencher
        Util.habilitar(true, jTxt_Meb_Codigo, jTxt_Meb_Nome, jTxt_Meb_Sobrenome,jTxt_Meb_Genero, jFmt_Meb_Cpf, jFmt_Meb_Rg, jTxt_Meb_Endereco, jTxt_Meb_Bairro, jFmt_Meb_Cep, jTxt_Meb_NumCasa, jCbo_Meb_Pais, jCbo_Meb_Estado, jFmt_Meb_Celular, jFmt_Meb_TelefoneResidencial,jTxt_Meb_Email, jBtn_Meb_Cancelar, jBtn_Meb_Confirmar );
        Util.habilitar(false, jBtn_Meb_Incluir, jBtn_Meb_Alterar, jBtn_Meb_Pesquisar, jBtn_Meb_Excluir);
        Util.limparCampos(jTxt_Meb_Codigo, jTxt_Meb_Nome, jTxt_Meb_Sobrenome,jTxt_Meb_Genero, jFmt_Meb_Cpf, jFmt_Meb_Rg, jTxt_Meb_Endereco, jTxt_Meb_Bairro, jFmt_Meb_Cep, jTxt_Meb_NumCasa, jCbo_Meb_Pais, jCbo_Meb_Estado, jFmt_Meb_Celular, jFmt_Meb_TelefoneResidencial,jTxt_Meb_Email);

        incluindo = true;

    }//GEN-LAST:event_jBtn_Meb_IncluirActionPerformed

    private void jBtn_Meb_AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_Meb_AlterarActionPerformed
        // TODO add your handling code here:
        Util.habilitar(true, jTxt_Meb_Codigo, jTxt_Meb_Nome, jTxt_Meb_Sobrenome,jTxt_Meb_Genero, jFmt_Meb_Cpf, jFmt_Meb_Rg, jTxt_Meb_Endereco, jTxt_Meb_Bairro, jFmt_Meb_Cep, jTxt_Meb_NumCasa, jCbo_Meb_Pais, jCbo_Meb_Estado, jFmt_Meb_Celular, jFmt_Meb_TelefoneResidencial,jTxt_Meb_Email, jBtn_Meb_Cancelar, jBtn_Meb_Confirmar );
        Util.habilitar(false, jBtn_Meb_Incluir, jBtn_Meb_Alterar, jBtn_Meb_Excluir, jBtn_Meb_Pesquisar);
        //indica que está no meio de uma alteração
        incluindo = false;

    }//GEN-LAST:event_jBtn_Meb_AlterarActionPerformed

    private void jBtn_Meb_ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_Meb_ExcluirActionPerformed

          int resp =  JOptionPane.showConfirmDialog(null, "Deseja excluir o registro?","Confirmar", JOptionPane.YES_NO_OPTION);// configura qual botão eu quero
        if (resp == JOptionPane.YES_OPTION){// confirma que é a opção sim
                           
        MebClientes mebClientes = viewBean();
        ClientesDAO clientesDAO = new ClientesDAO();
        clientesDAO.delete(mebClientes); 
        
        }else {
        JOptionPane.showMessageDialog(null, "Exclusão cancelada.","Alerta", 2 );
        
        }
        Util.limparCampos(jTxt_Meb_Codigo, jTxt_Meb_Nome, jTxt_Meb_Sobrenome,jTxt_Meb_Genero, jFmt_Meb_Cpf, jFmt_Meb_Rg, jTxt_Meb_Endereco, jTxt_Meb_Bairro, jFmt_Meb_Cep, jTxt_Meb_NumCasa, jCbo_Meb_Pais, jCbo_Meb_Estado, jFmt_Meb_Celular, jFmt_Meb_TelefoneResidencial,jTxt_Meb_Email);

    }//GEN-LAST:event_jBtn_Meb_ExcluirActionPerformed

    private void jBtn_Meb_ConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_Meb_ConfirmarActionPerformed
        //Aqui o beansta recebendo um bean
        //declarou um obejto/ bean no Usuarios e transaforma no viewBean();
         mebClientes = viewBean();
        if (incluindo == true) {
            clientesDAO.insert(mebClientes);
        } else {
            clientesDAO.update(mebClientes);
        }
        //pegou o que estava do view passou para o bean, do bean passou para o DAO e do DAO para o banco de dados// apagou os campos e habiliotu e desabilitou

        Util.limparCampos(jTxt_Meb_Codigo, jTxt_Meb_Nome, jTxt_Meb_Sobrenome,jTxt_Meb_Genero, jFmt_Meb_Cpf, jFmt_Meb_Rg, jTxt_Meb_Endereco, jTxt_Meb_Bairro, jFmt_Meb_Cep, jTxt_Meb_NumCasa, jCbo_Meb_Pais, jCbo_Meb_Estado, jFmt_Meb_Celular, jFmt_Meb_TelefoneResidencial,jTxt_Meb_Email);

        Util.habilitar(true, jBtn_Meb_Incluir, jBtn_Meb_Alterar, jBtn_Meb_Excluir, jBtn_Meb_Pesquisar );
        Util.habilitar(false, jTxt_Meb_Codigo, jTxt_Meb_Nome, jTxt_Meb_Sobrenome,jTxt_Meb_Genero, jFmt_Meb_Cpf, jFmt_Meb_Rg, jTxt_Meb_Endereco, jTxt_Meb_Bairro, jFmt_Meb_Cep, jTxt_Meb_NumCasa, jCbo_Meb_Pais, jCbo_Meb_Estado, jFmt_Meb_Celular, jFmt_Meb_TelefoneResidencial,jTxt_Meb_Email, jBtn_Meb_Cancelar, jBtn_Meb_Confirmar );
    }//GEN-LAST:event_jBtn_Meb_ConfirmarActionPerformed

    private void jBtn_Meb_PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_Meb_PesquisarActionPerformed

        //chamei a tela de usuario pesquisa
        JDlgClientesPesquisa jDlgClientesPesquisa= new  JDlgClientesPesquisa (null, true);
        jDlgClientesPesquisa.setTelaAnterior(this); //esta chamando o metodo do usuario pesquisa
        jDlgClientesPesquisa.setVisible(true);

    }//GEN-LAST:event_jBtn_Meb_PesquisarActionPerformed

    private void jBtn_Meb_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_Meb_CancelarActionPerformed
        Util.habilitar(true, jBtn_Meb_Incluir, jBtn_Meb_Alterar, jBtn_Meb_Excluir, jBtn_Meb_Pesquisar );

        Util.habilitar(false, jTxt_Meb_Codigo, jTxt_Meb_Nome, jTxt_Meb_Sobrenome,jTxt_Meb_Genero, jFmt_Meb_Cpf, jFmt_Meb_Rg, jTxt_Meb_Endereco, jTxt_Meb_Bairro, jFmt_Meb_Cep, jTxt_Meb_NumCasa, jCbo_Meb_Pais, jCbo_Meb_Estado, jFmt_Meb_Celular, jFmt_Meb_TelefoneResidencial,jTxt_Meb_Email, jBtn_Meb_Cancelar, jBtn_Meb_Confirmar );
        Util.limparCampos(jTxt_Meb_Codigo, jTxt_Meb_Nome, jTxt_Meb_Sobrenome,jTxt_Meb_Genero, jFmt_Meb_Cpf, jFmt_Meb_Rg, jTxt_Meb_Endereco, jTxt_Meb_Bairro, jFmt_Meb_Cep, jTxt_Meb_NumCasa, jCbo_Meb_Pais, jCbo_Meb_Estado, jFmt_Meb_Celular, jFmt_Meb_TelefoneResidencial,jTxt_Meb_Email);
        Util.mensagem("Operação cancelada");

    }//GEN-LAST:event_jBtn_Meb_CancelarActionPerformed

    private void jCbo_Meb_EstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbo_Meb_EstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCbo_Meb_EstadoActionPerformed

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
            java.util.logging.Logger.getLogger(JDlgClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgClientes dialog = new JDlgClientes(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> jCbo_Meb_Estado;
    private javax.swing.JComboBox<String> jCbo_Meb_Pais;
    private javax.swing.JFormattedTextField jFmt_Meb_Celular;
    private javax.swing.JFormattedTextField jFmt_Meb_Cep;
    private javax.swing.JFormattedTextField jFmt_Meb_Cpf;
    private javax.swing.JFormattedTextField jFmt_Meb_Rg;
    private javax.swing.JFormattedTextField jFmt_Meb_TelefoneResidencial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTxt_Meb_Bairro;
    private javax.swing.JTextField jTxt_Meb_Codigo;
    private javax.swing.JTextField jTxt_Meb_Email;
    private javax.swing.JTextField jTxt_Meb_Endereco;
    private javax.swing.JTextField jTxt_Meb_Genero;
    private javax.swing.JTextField jTxt_Meb_Nome;
    private javax.swing.JTextField jTxt_Meb_NumCasa;
    private javax.swing.JTextField jTxt_Meb_Sobrenome;
    // End of variables declaration//GEN-END:variables
}
