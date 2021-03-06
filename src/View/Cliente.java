/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerCliente;
import Model.ModelCliente;
import java.awt.FontMetrics;
import outstok.conectaBanco;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumn;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import outstok.ModeloTabela;

/**
 *
 * @author lukaa
 */
public class Cliente extends javax.swing.JInternalFrame {

    conectaBanco conecta = new conectaBanco();
    ModelCliente mod = new ModelCliente();
    ControllerCliente con = new ControllerCliente();
    String preenche = "SELECT * FROM cliente, cidade WHERE Cidade_id = cidade.id";

    /**
     * Creates new form NovoJInternalFrame
     */
    public Cliente() {
        initComponents();
        try {
            MaskFormatter tf = new MaskFormatter("##/##/####");
            Nascimento.setFormatterFactory(new DefaultFormatterFactory(tf));
        } catch (ParseException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            MaskFormatter tf = new MaskFormatter("(##)####-####");
            Telefone.setFormatterFactory(new DefaultFormatterFactory(tf));
        } catch (ParseException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            MaskFormatter cl = new MaskFormatter("(##)#####-####");
            Celular.setFormatterFactory(new DefaultFormatterFactory(cl));
        } catch (ParseException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            MaskFormatter rg = new MaskFormatter("##.###.###-#");
            RG.setFormatterFactory(new DefaultFormatterFactory(rg));
        } catch (ParseException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            MaskFormatter cpf = new MaskFormatter("###.###.###-##");
            CPF.setFormatterFactory(new DefaultFormatterFactory(cpf));
        } catch (ParseException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }        
        conecta.conexao();
        preencherTabela(preenche);
        conecta.executaSQL("SELECT * FROM cidade ORDER BY nome");
        jComboBoxCidade.removeAllItems();
        try {
            conecta.rs.first();
            do {
                jComboBoxCidade.addItem(conecta.rs.getString("nome"));
            } while (conecta.rs.next());
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro a preencher lista");
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Novo = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Name = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxCidade = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxSexo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Endereco = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        Bairro = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        Email = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        Observacao = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        Nascimento = new javax.swing.JFormattedTextField();
        Celular = new javax.swing.JFormattedTextField();
        Telefone = new javax.swing.JFormattedTextField();
        RG = new javax.swing.JFormattedTextField();
        CPF = new javax.swing.JFormattedTextField();
        Save = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaestado = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setClosable(true);
        setForeground(java.awt.Color.white);
        setTitle("Cadastro de Clientes");
        setToolTipText("");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/16/team.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel1.setText("Cadastro de Clientes");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/64/website.png"))); // NOI18N
        Novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NovoActionPerformed(evt);
            }
        });

        Update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/64/rotate.png"))); // NOI18N
        Update.setEnabled(false);
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/64/bin.png"))); // NOI18N
        delete.setEnabled(false);
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel2.setText("Nome:");

        Name.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        Name.setEnabled(false);
        Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameActionPerformed(evt);
            }
        });

        id.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        id.setEnabled(false);
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel4.setText("Codigo:");

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel5.setText("Cidade:");

        jComboBoxCidade.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jComboBoxCidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxCidade.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel3.setText("Nascimento:");

        jComboBoxSexo.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jComboBoxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino", " " }));
        jComboBoxSexo.setEnabled(false);
        jComboBoxSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSexoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel7.setText("Sexo:");

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel6.setText("Telefone:");

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel9.setText("Endereço:");

        Endereco.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        Endereco.setEnabled(false);
        Endereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnderecoActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel10.setText("Bairro:");

        Bairro.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        Bairro.setEnabled(false);
        Bairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BairroActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel11.setText("E-mail:");

        Email.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        Email.setEnabled(false);
        Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel14.setText("Observação:");

        Observacao.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        Observacao.setEnabled(false);
        Observacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ObservacaoActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel12.setText("Celular:");

        jLabel13.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel13.setText("CPF:");

        jLabel17.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel17.setText("RG:");

        Nascimento.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        Celular.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        Telefone.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        RG.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        CPF.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Observacao)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Bairro)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxCidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addComponent(Endereco)
                            .addComponent(Email)
                            .addComponent(Name)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel14))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(Nascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Celular, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CPF, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RG, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel7)
                                .addComponent(jLabel12))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel13)
                                .addComponent(jLabel17)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Celular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(RG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(CPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Nascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(33, 33, 33)))
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Bairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Observacao, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
        );

        Save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/64/save.png"))); // NOI18N
        Save.setEnabled(false);
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Novo)
                    .addComponent(Update)
                    .addComponent(delete)
                    .addComponent(Save))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Novo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Save)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Update)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delete)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabelaestado.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        tabelaestado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabelaestado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaestadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaestado);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(333, 333, 333)
                        .addComponent(jLabel1)))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(0, 0, 995, 837);
    }// </editor-fold>//GEN-END:initComponents

    private void NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        mod.setNome(Name.getText());
        mod.setNascimento(Nascimento.getText());
        mod.setSexo((String) jComboBoxSexo.getSelectedItem());
        mod.setTelefone(Telefone.getText());
        mod.setCelular(Celular.getText());
        mod.setCpf(CPF.getText());
        mod.setRg(RG.getText());
        mod.setEndereco(Endereco.getText());
        mod.setBairro(Bairro.getText());
        mod.setEmail(Email.getText());
        mod.setObservacao(Observacao.getText());
        try {
            conecta.executaSQL("SELECT * FROM cidade where nome='" + jComboBoxCidade.getSelectedItem() + "'");
            conecta.rs.first();
            mod.setCidade_id(conecta.rs.getInt("id"));
            con.Save(mod);
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        Name.setText("");
        Nascimento.setText("");
        Telefone.setText("");
        Celular.setText("");
        RG.setText("");
        CPF.setText("");
        Endereco.setText("");
        Bairro.setText("");
        Email.setText("");
        Observacao.setText("");
        Name.setEnabled(false);
        Nascimento.setEnabled(false);
        Telefone.setEnabled(false);
        Celular.setEnabled(false);
        RG.setEnabled(false);
        CPF.setEnabled(false);
        Endereco.setEnabled(false);
        Bairro.setEnabled(false);
        Email.setEnabled(false);
        Observacao.setEnabled(false);
        jComboBoxCidade.setEnabled(false);
        jComboBoxSexo.setEnabled(false);
        Save.setEnabled(false);
        delete.setEnabled(false);
        Update.setEnabled(false);
        Novo.setEnabled(true);
        preencherTabela(preenche);
    }//GEN-LAST:event_SaveActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        mod.setId(Integer.parseInt(id.getText()));
        con.Delete(mod);
        Name.setText("");
        Nascimento.setText("");
        Telefone.setText("");
        Celular.setText("");
        RG.setText("");
        CPF.setText("");
        Endereco.setText("");
        Bairro.setText("");
        Email.setText("");
        Observacao.setText("");
        Name.setEnabled(false);
        Nascimento.setEnabled(false);
        Telefone.setEnabled(false);
        Celular.setEnabled(false);
        RG.setEnabled(false);
        CPF.setEnabled(false);
        Endereco.setEnabled(false);
        Bairro.setEnabled(false);
        Email.setEnabled(false);
        Observacao.setEnabled(false);
        jComboBoxCidade.setEnabled(false);
        jComboBoxSexo.setEnabled(false);
        Save.setEnabled(false);
        delete.setEnabled(false);
        Update.setEnabled(false);
        Novo.setEnabled(true);
        preencherTabela(preenche);
    }//GEN-LAST:event_deleteActionPerformed

    private void NovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NovoActionPerformed
        // TODO add your handling code here:
        Name.setText("");
        Nascimento.setText("");
        Telefone.setText("");
        Celular.setText("");
        RG.setText("");
        CPF.setText("");
        Endereco.setText("");
        Bairro.setText("");
        Email.setText("");
        Observacao.setText("");
        Name.setEnabled(true);
        Nascimento.setEnabled(true);
        Telefone.setEnabled(true);
        Celular.setEnabled(true);
        RG.setEnabled(true);
        CPF.setEnabled(true);
        Endereco.setEnabled(true);
        Bairro.setEnabled(true);
        Email.setEnabled(true);
        Observacao.setEnabled(true);
        jComboBoxCidade.setEnabled(true);
        jComboBoxSexo.setEnabled(true);
        Save.setEnabled(true);
        delete.setEnabled(true);
        Update.setEnabled(true);
        Novo.setEnabled(false);
        preencherTabela(preenche);
    }//GEN-LAST:event_NovoActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        mod.setNome(Name.getText());
        mod.setNascimento(Nascimento.getText());
        mod.setSexo((String) jComboBoxSexo.getSelectedItem());
        mod.setTelefone(Telefone.getText());
        mod.setCelular(Celular.getText());
        mod.setEndereco(Endereco.getText());
        mod.setBairro(Bairro.getText());
        mod.setEmail(Email.getText());
        mod.setRg(RG.getText());
        mod.setCpf(CPF.getText());
        mod.setObservacao(Observacao.getText());
        try {
            conecta.executaSQL("SELECT * FROM cidade where nome='" + jComboBoxCidade.getSelectedItem() + "'");
            conecta.rs.first();
            mod.setCidade_id(conecta.rs.getInt("id"));
            mod.setId(Integer.parseInt(id.getText()));
            con.Update(mod);
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        Name.setText("");
        Nascimento.setText("");
        Telefone.setText("");
        Celular.setText("");
        RG.setText("");
        CPF.setText("");
        Endereco.setText("");
        Bairro.setText("");
        Email.setText("");
        Observacao.setText("");
        Name.setEnabled(false);
        Nascimento.setEnabled(false);
        Telefone.setEnabled(false);
        Celular.setEnabled(false);
        RG.setEnabled(false);
        CPF.setEnabled(false);
        Endereco.setEnabled(false);
        Bairro.setEnabled(false);
        Email.setEnabled(false);
        Observacao.setEnabled(false);
        jComboBoxCidade.setEnabled(false);
        jComboBoxSexo.setEnabled(false);
        Save.setEnabled(false);
        delete.setEnabled(false);
        Update.setEnabled(false);
        Novo.setEnabled(true);
        preencherTabela(preenche);
    }//GEN-LAST:event_UpdateActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void EnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EnderecoActionPerformed

    private void BairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BairroActionPerformed

    private void EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailActionPerformed

    private void ObservacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ObservacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ObservacaoActionPerformed

    private void tabelaestadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaestadoMouseClicked
        // TODO add your handling code here:
        String n = "" + tabelaestado.getValueAt(tabelaestado.getSelectedRow(), 0);
        conecta.conexao();
        conecta.executaSQL("SELECT * FROM cliente WHERE id ='" + n + "'");
        try {
            conecta.rs.first();
            id.setText(String.valueOf(conecta.rs.getInt("id")));
            Name.setText(conecta.rs.getString("nome"));
            Nascimento.setText(conecta.rs.getString("data_nascimento"));
            jComboBoxSexo.setSelectedItem(conecta.rs.getString("sexo"));
            Telefone.setText(conecta.rs.getString("telefone"));
            Celular.setText(conecta.rs.getString("celular"));
            Endereco.setText(conecta.rs.getString("endereco"));
            Bairro.setText(conecta.rs.getString("bairro"));
            Email.setText(conecta.rs.getString("email"));
            RG.setText(conecta.rs.getString("rg"));
            CPF.setText(conecta.rs.getString("cpf"));
            Observacao.setText(conecta.rs.getString("observacao"));
            int id = conecta.rs.getInt("Cidade_id");
            conecta.executaSQL("SELECT * FROM cidade where'" + id + "'");
            conecta.rs.first();
            jComboBoxCidade.setSelectedItem(conecta.rs.getString("cidade.nome"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher os campos!" + ex);
        }
        Name.setEnabled(true);
        Nascimento.setEnabled(true);
        Telefone.setEnabled(true);
        Celular.setEnabled(true);
        RG.setEnabled(true);
        CPF.setEnabled(true);
        Endereco.setEnabled(true);
        Bairro.setEnabled(true);
        Email.setEnabled(true);
        Observacao.setEnabled(true);
        jComboBoxCidade.setEnabled(true);
        jComboBoxSexo.setEnabled(true);
        Save.setEnabled(true);
        delete.setEnabled(true);
        Update.setEnabled(true);
        Novo.setEnabled(false);
        preencherTabela(preenche);
    }//GEN-LAST:event_tabelaestadoMouseClicked

    private void jComboBoxSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxSexoActionPerformed
    public void preencherTabela(String SQL) {
        ArrayList dados = new ArrayList();

        String[] Colunas = new String[]{"ID", "Nome", "Data Nascimento", "Sexo", "Telefone",
            "Celular", "Endereço", "Bairro", "Cidade", "E-mail", "RG", "CPF", "Observação"
        };

        conecta.executaSQL(SQL);
        try {
            conecta.rs.first();
            do {
                dados.add(new Object[]{
                    conecta.rs.getInt("id"),
                    conecta.rs.getString("cliente.nome"),
                    conecta.rs.getString("cliente.data_nascimento"),
                    conecta.rs.getString("cliente.sexo"),
                    conecta.rs.getString("cliente.telefone"),
                    conecta.rs.getString("cliente.celular"),
                    conecta.rs.getString("cliente.endereco"),
                    conecta.rs.getString("cliente.bairro"),
                    conecta.rs.getString("cidade.nome"),
                    conecta.rs.getString("cliente.email"),
                    conecta.rs.getString("cliente.rg"),
                    conecta.rs.getString("cliente.cpf"),
                    conecta.rs.getString("cliente.observacao")});
            } while (conecta.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro preencher a tabela" + ex);
        }
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        tabelaestado.setModel(modelo);
        tabelaestado.setAutoResizeMode(tabelaestado.AUTO_RESIZE_ALL_COLUMNS);
        tabelaestado.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
          
        
        
        
    }
			
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Bairro;
    private javax.swing.JFormattedTextField CPF;
    private javax.swing.JFormattedTextField Celular;
    private javax.swing.JTextField Email;
    private javax.swing.JTextField Endereco;
    private javax.swing.JTextField Name;
    private javax.swing.JFormattedTextField Nascimento;
    private javax.swing.JButton Novo;
    private javax.swing.JTextField Observacao;
    private javax.swing.JFormattedTextField RG;
    private javax.swing.JButton Save;
    private javax.swing.JFormattedTextField Telefone;
    private javax.swing.JButton Update;
    private javax.swing.JButton delete;
    private javax.swing.JTextField id;
    private javax.swing.JComboBox<String> jComboBoxCidade;
    private javax.swing.JComboBox<String> jComboBoxSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaestado;
    // End of variables declaration//GEN-END:variables

    private void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
