/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package biblioteca;

import tabelas.*;
import JanelasModais.AlterarLivro;
import JanelasModais.NovoRegistroLivro;
import conexao.Conexao;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gabriel Oliveira
 */
public class LivroUser extends javax.swing.JPanel {

    /**
     * Creates new form TabelaLivro
     */
    String codLivro = "";
    String titulo = "";
    String autor = "";
    String dataLacamento = "";
    String genero = "";
    String qtdePag = "";
    String exemplares = "";
    String editora = "";
    String isbn = "";
    String codSetor = "";
    String [] listaCod;
    Conexao con_cliente;
    public LivroUser() {
        initComponents();
        
        con_cliente = new Conexao(); // inicialização do objeto
        con_cliente.conecta(); // chama o método que conecta
        
        livro1.setShowHorizontalLines(true);
        livro1.setGridColor(new Color(230, 230, 230));
        livro1.setRowHeight(40);
        livro1.getTableHeader().setReorderingAllowed(false);
        
        con_cliente.executaSQL("select * from livro order by Cod_Livro");
        preencherTabela();
    }
    
    private void preencherTabela() {
        livro1.getColumnModel().getColumn(0);
        livro1.getColumnModel().getColumn(1);
        livro1.getColumnModel().getColumn(2);
        livro1.getColumnModel().getColumn(3);
        livro1.getColumnModel().getColumn(4);
        livro1.getColumnModel().getColumn(5);
        livro1.getColumnModel().getColumn(6);
        livro1.getColumnModel().getColumn(7);
        
        DefaultTableModel modelo = (DefaultTableModel) livro1.getModel();
        modelo.setNumRows(0);
        
        try {
            con_cliente.resultset.beforeFirst();
            while(con_cliente.resultset.next()) {
                modelo.addRow(new Object[]{
                    con_cliente.resultset.getString("Titulo"),
                    con_cliente.resultset.getString("Nome_Autor"),
                    con_cliente.resultset.getString("Data_Lancamento"),
                    con_cliente.resultset.getString("Genero"),
                    con_cliente.resultset.getString("Qtde_Pagina"),
                    con_cliente.resultset.getString("Exemplares"),
                    con_cliente.resultset.getString("Editora"),
                    con_cliente.resultset.getString("ISBN"),
                });
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "\n Erro ao listar dados da tabela!!:\n" + erro,"Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        livro1 = new tabelas.Tabela();
        barraPesquisa = new javax.swing.JTextField();
        btnPesquisa = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(923, 529));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Livros disponiveis na biblioteca:");

        livro1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Titulo", "Autor", "Data_Lancamento", "Genero", "Qtde_Pagina", "Exemplares", "Editora", "ISBN"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        livro1.setSelectionBackground(new java.awt.Color(0, 102, 102));
        jScrollPane1.setViewportView(livro1);
        if (livro1.getColumnModel().getColumnCount() > 0) {
            livro1.getColumnModel().getColumn(0).setPreferredWidth(140);
            livro1.getColumnModel().getColumn(1).setPreferredWidth(100);
            livro1.getColumnModel().getColumn(5).setPreferredWidth(70);
        }

        barraPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barraPesquisaActionPerformed(evt);
            }
        });

        btnPesquisa.setText("Pesquisar");
        btnPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaActionPerformed(evt);
            }
        });

        jLabel2.setText("Titulo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(barraPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisa)))
                .addContainerGap(196, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 894, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(barraPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisa)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(210, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void barraPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barraPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_barraPesquisaActionPerformed

    private void btnPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaActionPerformed
        // TODO add your handling code here:
        if (livro1.isEditing()) {
                livro1.getCellEditor().stopCellEditing();
        }
        try {
                String pesquisa = "select * from livro where Titulo like '" + barraPesquisa.getText() + "%'";
                con_cliente.executaSQL(pesquisa);

                if (con_cliente.resultset.first()) {
                    preencherTabela();
                }
                else {
                    JOptionPane.showMessageDialog(null, "\n Não existe dados com este paramêtro!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }
        } catch (Exception errosql) {
            JOptionPane.showMessageDialog(null, "\n Os dados digitados não foram localizados!! :\n" + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnPesquisaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField barraPesquisa;
    private javax.swing.JButton btnPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private tabelas.Tabela livro1;
    // End of variables declaration//GEN-END:variables
}
