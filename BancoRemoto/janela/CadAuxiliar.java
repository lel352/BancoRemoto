/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio3.janela;

import exercicio3.bancobean.BairroBean;
import exercicio3.bancobean.CidadeBean;
import exercicio3.bancobean.EstadoBean;
import exercicio3.bancobean.LogradouroBean;
import exercicio3.bancobean.PaisBean;
import exercicio3.bancodao.BairroDao;
import exercicio3.bancodao.CidadeDao;
import exercicio3.bancodao.EstadoDao;
import exercicio3.bancodao.LogradouroDao;
import exercicio3.bancodao.PaisDao;
import exercicio3.metodos.RandomBanco;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cassio / Leandro
 */
public class CadAuxiliar extends javax.swing.JFrame {

    /**
     * Creates new form JanelaPessoa
     */
    private Integer origem;
    private Integer codigo;
    private String nome;
    private ArrayList<String> caminhobanco = new ArrayList<String>();
    private List<PaisBean> paisBeanArray = new ArrayList<PaisBean>();
    private List<EstadoBean> estadoBeanArray = new ArrayList<EstadoBean>();
    private List<CidadeBean> cidadeBeanArray = new ArrayList<CidadeBean>();
    private List<BairroBean> bairroBeanArray = new ArrayList<BairroBean>();
    private List<LogradouroBean> logradouroBeanArray = new ArrayList<LogradouroBean>();
    private int[] ordem = null;

    public CadAuxiliar() {
        initComponents();
    }

    public void cadAuxiliarD(String titulo, Integer origem, ArrayList<String> caminhobanco) { //origem do cadastro 1 - paises, 2 - Estado, 3-Cidade,4-Bairro ,5-logradouro
        jLabeltitulo.setText("Cadastro de " + titulo);
        this.origem = origem;
        this.caminhobanco = caminhobanco;
        MostrarDados(origem, 0);
        jTextNome.setText("");
    }

    public void LimparJtable() {
        ((DefaultTableModel) jTabledados.getModel()).setNumRows(0);
        jTabledados.updateUI();
    }

    private void MostrarDados(Integer origem, Integer novo) {
        DefaultTableModel model = (DefaultTableModel) jTabledados.getModel();
        switch (origem) {
            case 1: //paises
                if (novo == 0) {
                    PaisDao paisdao = new PaisDao();
                    paisBeanArray = paisdao.getAll();
                }
                for (int i = 0; i < paisBeanArray.size(); i++) {
                    PaisBean pais = paisBeanArray.get(i);
                    model.addRow(new Object[]{"", "", ""});
                    model.setValueAt((i + 1), i, 0);
                    model.setValueAt(pais.getCodigo(), i, 1);
                    model.setValueAt(pais.getPais(), i, 2);
                }
                break;
            case 2://Estado
                if (novo == 0) {
                    EstadoDao estadodao = new EstadoDao();
                    estadoBeanArray = estadodao.getAll();
                }
                for (int i = 0; i < estadoBeanArray.size(); i++) {
                    model.addRow(new Object[]{"", "", ""});
                    EstadoBean estado = estadoBeanArray.get(i);
                    model.setValueAt((i + 1), i, 0);
                    model.setValueAt(estado.getCodigo(), i, 1);
                    model.setValueAt(estado.getEstado(), i, 2);
                }
                break;
            case 3://Cidade
                if (novo == 0) {
                    CidadeDao cidadedao = new CidadeDao();
                    cidadeBeanArray = cidadedao.getAll();
                }
                for (int i = 0; i < cidadeBeanArray.size(); i++) {
                    CidadeBean cidade = cidadeBeanArray.get(i);
                    model.addRow(new Object[]{"", "", ""});
                    model.setValueAt((i + 1), i, 0);
                    model.setValueAt(cidade.getCodigo(), i, 1);
                    model.setValueAt(cidade.getCidade(), i, 2);
                }
                break;
            case 4: //Bairro
                if (novo == 0) {
                    BairroDao bairrodao = new BairroDao();
                    bairroBeanArray = bairrodao.getAll();
                }
                for (int i = 0; i < bairroBeanArray.size(); i++) {
                    BairroBean bairro = bairroBeanArray.get(i);
                    model.addRow(new Object[]{"", "", ""});
                    model.setValueAt((i + 1), i, 0);
                    model.setValueAt(bairro.getCodigo(), i, 1);
                    model.setValueAt(bairro.getBairro(), i, 2);
                    
                }
                break;
            case 5: //logradouro
                if (novo == 0) {
                    LogradouroDao logradourodao = new LogradouroDao();
                    logradouroBeanArray = logradourodao.getAll();
                }
                for (int i = 0; i < logradouroBeanArray.size(); i++) {
                    LogradouroBean logradouro = logradouroBeanArray.get(i);
                    model.addRow(new Object[]{"", "", ""});
                    model.setValueAt((i + 1), i, 0);
                    model.setValueAt(logradouro.getCodigo(), i, 1);
                    model.setValueAt(logradouro.getLogradouro(), i, 2);
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "Erro na origem do Cadastro !!!");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTabledados = new javax.swing.JTable();
        jLabeltitulo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextNome = new javax.swing.JTextField();
        jButtonGravar = new javax.swing.JButton();
        jButtonOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTabledados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ordem", "Código", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabledados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabledadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabledados);

        jLabeltitulo.setFont(new java.awt.Font("Arial Unicode MS", 0, 24)); // NOI18N
        jLabeltitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabeltitulo.setText("Cadastros Auxiliares");

        jLabel3.setText("Nome");

        jButtonGravar.setText("Gravar");
        jButtonGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGravarActionPerformed(evt);
            }
        });

        jButtonOk.setText("Ok");
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabeltitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(65, 65, 65)
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(jTextNome, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButtonGravar))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(32, 32, 32)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButtonOk))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabeltitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jButtonGravar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonOk)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGravarActionPerformed
        // TODO add your handling code here:
        if (("").equals(jTextNome.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Digite um nome Valido");
            jTextNome.requestFocus();
            return;
        }

        ordem = new RandomBanco().RandomBancoOrdem();
        int codi = 0;
        switch (origem) {
            case 1: //paises
                PaisBean pais = new PaisBean();

                pais.setPais(jTextNome.getText());
                PaisDao paisDao = new PaisDao();
                paisDao.insert(pais, "localhost");
                codigo = paisDao.UltimoCodigo();
                nome = pais.getPais();
                pais.setCodigo(codigo);
                paisBeanArray.add(pais);
                MostrarDados(origem, 1);
                CadPessoa.jTextPais.setText(nome);
                CadPessoa.codPais = codigo;

                for (int i = 0; i < ordem.length; i++) {
                    paisDao.insert(pais, caminhobanco.get(ordem[i]));
                }

                break;
            case 2: //Estado
                EstadoBean estado = new EstadoBean();

                estado.setEstado(jTextNome.getText());
                EstadoDao estadoDao = new EstadoDao();
                estadoDao.insert(estado, "localhost");
                codigo = estadoDao.UltimoCodigo();
                nome = estado.getEstado();
                estado.setCodigo(codigo);
                estadoBeanArray.add(estado);
                MostrarDados(origem, 1);
                CadPessoa.jTextEstado.setText(nome);
                CadPessoa.codEstado = codigo;

                for (int i = 0; i < ordem.length; i++) {
                    estadoDao.insert(estado, caminhobanco.get(ordem[i]));
                }

                break;
            case 3: // Cidade
                CidadeBean cidade = new CidadeBean();

                cidade.setCidade(jTextNome.getText());
                CidadeDao cidadeDao = new CidadeDao();
                cidadeDao.insert(cidade, "localhost");
                codigo = cidadeDao.UltimoCodigo();
                nome = cidade.getCidade();
                cidade.setCodigo(codigo);
                cidadeBeanArray.add(cidade);
                MostrarDados(origem, 1);
                CadPessoa.jTextCidade.setText(nome);
                CadPessoa.codCidade = codigo;

                for (int i = 0; i < ordem.length; i++) {
                    cidadeDao.insert(cidade,caminhobanco.get(ordem[i]));
                }

                break;
            case 4: //Bairro
                BairroBean bairro = new BairroBean();

                bairro.setBairro(jTextNome.getText());
                BairroDao bairroDao = new BairroDao();
                bairroDao.insert(bairro, "localhost");
                codigo = bairroDao.UltimoCodigo();
                nome = bairro.getBairro();
                bairro.setCodigo(codigo);
                bairroBeanArray.add(bairro);
                MostrarDados(origem, 1);
                CadPessoa.jTextBairro.setText(nome);
                CadPessoa.codBairro = codigo;

                for (int i = 0; i < ordem.length; i++) {
                   bairroDao.insert(bairro,caminhobanco.get(ordem[i]));
                }
                
                break;
            case 5: //Logradouro
                LogradouroBean logradouro = new LogradouroBean();

                logradouro.setLogradouro(jTextNome.getText());
                LogradouroDao logradouroDao = new LogradouroDao();
                logradouroDao.insert(logradouro, "localhost");
                codigo = logradouroDao.UltimoCodigo();
                nome = logradouro.getLogradouro();
                logradouro.setCodigo(codigo);
                logradouroBeanArray.add(logradouro);
                MostrarDados(origem, 1);
                CadPessoa.jTextLogradouro.setText(nome);
                CadPessoa.codLogradouro = codigo;
                
                for (int i = 0; i < ordem.length; i++) {
                   logradouroDao.insert(logradouro, caminhobanco.get(ordem[i]));
                }
                
                break;
            default:
                JOptionPane.showMessageDialog(null, "Erro na origem do Cadastro !!!");
        }

        jTextNome.setText("");
        jTextNome.requestFocus();
    }//GEN-LAST:event_jButtonGravarActionPerformed

    private void jTabledadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabledadosMouseClicked
        // TODO add your handling code here:
        int linha = jTabledados.getSelectedRow();
        codigo = Integer.valueOf(String.valueOf(jTabledados.getValueAt(linha, 1)));
        nome = String.valueOf(jTabledados.getValueAt(linha, 2));
        switch (origem) {
            case 1: //paises
                CadPessoa.jTextPais.setText(nome);
                CadPessoa.codPais = codigo;
                break;
            case 2: //Estado
                CadPessoa.jTextEstado.setText(nome);
                CadPessoa.codEstado = codigo;
                break;
            case 3: // Cidade
                CadPessoa.jTextCidade.setText(nome);
                CadPessoa.codCidade = codigo;
                break;
            case 4: //Bairro
                CadPessoa.jTextBairro.setText(nome);
                CadPessoa.codBairro = codigo;
                break;
            case 5: //Logradouro
                CadPessoa.jTextLogradouro.setText(nome);
                CadPessoa.codLogradouro = codigo;
                break;
        }
    }//GEN-LAST:event_jTabledadosMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:

        CadPessoa.cadAuxiliar = null;
        dispose();
    }//GEN-LAST:event_formWindowClosing

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed
        // TODO add your handling code here:
        CadPessoa.cadAuxiliar = null;
        dispose();
    }//GEN-LAST:event_jButtonOkActionPerformed

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
            java.util.logging.Logger.getLogger(CadAuxiliar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadAuxiliar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadAuxiliar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadAuxiliar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadAuxiliar().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGravar;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabeltitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabledados;
    private javax.swing.JTextField jTextNome;
    // End of variables declaration//GEN-END:variables
}
