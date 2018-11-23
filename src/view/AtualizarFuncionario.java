/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import DAO.FuncionarioDAO;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.Funcionario;

/**
 *
 * @author gabri
 */
public class AtualizarFuncionario extends javax.swing.JInternalFrame {

    /**
     * Creates new form AtualizarFuncionario
     */
    public AtualizarFuncionario() {
        initComponents();
        this.exibir();
    }
    
    public void exibir(){
     try {
            FuncionarioDAO dao = new FuncionarioDAO();
            Funcionario func = new Funcionario();

            Connection con = ConnectionFactory.getConnection();
            String query = ("SELECT * FROM  funcionario");
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setNumRows(0);

            while (rs.next()) {
                model.addRow(
                    new Object[]{
                        rs.getInt("cpf"),
                        rs.getString("nome"),
                        rs.getString("endereco"),
                        rs.getString("telefone"),
                        rs.getString("cidade"),
                        rs.getString("email")
                      
                    }
                );

               

            }

         
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaRem.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nomeTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        telefoneTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cidadeTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        enderecoTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        emailTxt = new javax.swing.JTextField();
        Canc = new javax.swing.JButton();
        Att = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Nome");

        jLabel3.setText("Telefone");

        telefoneTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefoneTxtActionPerformed(evt);
            }
        });

        jLabel5.setText("Cidade");

        cidadeTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cidadeTxtActionPerformed(evt);
            }
        });

        jLabel4.setText("Endereço");

        jLabel2.setText("E-mail");

        Canc.setBackground(new java.awt.Color(204, 255, 204));
        Canc.setText("Cancelar");
        Canc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancActionPerformed(evt);
            }
        });

        Att.setBackground(new java.awt.Color(204, 255, 204));
        Att.setText("Atualizar");
        Att.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AttActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cpf", "Nome", "Endereço", "Telefone", "Cidade", "E-mail"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Atualizar Dados dos Funcionários");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Canc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Att))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nomeTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                                    .addComponent(enderecoTxt))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(telefoneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cidadeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(emailTxt)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(275, 275, 275)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(114, 114, 114)
                                        .addComponent(jLabel5)))
                                .addGap(0, 188, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(240, 240, 240)))
                        .addContainerGap(54, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telefoneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cidadeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enderecoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Canc)
                    .addComponent(Att))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void telefoneTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefoneTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefoneTxtActionPerformed

    private void cidadeTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cidadeTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cidadeTxtActionPerformed

    private void CancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancActionPerformed
        dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_CancActionPerformed

    private void AttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AttActionPerformed
        if(jTable1.getSelectedRow() != -1){

            Funcionario func = new Funcionario();
            FuncionarioDAO dao = new FuncionarioDAO();

            func.setNome(nomeTxt.getText());
            func.setEndereco(enderecoTxt.getText());
            func.setTelefone(telefoneTxt.getText());
            func.setCidade(cidadeTxt.getText());
            func.setEmail(emailTxt.getText());
            func.setCpf( jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
            dao.update(func);
            this.exibir();

        }
    }//GEN-LAST:event_AttActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        if(jTable1.getSelectedRow() != -1){
            nomeTxt.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
            enderecoTxt.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
            telefoneTxt.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
            cidadeTxt.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
            emailTxt.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString());

        }

    }//GEN-LAST:event_jTable1KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Att;
    private javax.swing.JButton Canc;
    private javax.swing.JTextField cidadeTxt;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JTextField enderecoTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nomeTxt;
    private javax.swing.JTextField telefoneTxt;
    // End of variables declaration//GEN-END:variables
}