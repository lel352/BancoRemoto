/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio3.janela;

import exercicio3.bancobean.MovimentoBean;
import exercicio3.bancobean.PessoaBean;
import exercicio3.bancodao.MovimentoDao;
import exercicio3.bancodao.PessoaDao;
import exercicio3.conectarbanco.ConectarTodos;
import exercicio3.metodos.RandomBanco;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;

/**
 *
 * @author Cassio / Leandro
 */
public class CadPessoa extends javax.swing.JFrame {

    public static CadAuxiliar cadAuxiliar;
    public static Consultar consultar;
    public static Integer codLogradouro;
    public static Integer codBairro;
    public static Integer codCidade;
    public static Integer codEstado;
    public static Integer codPais;
    private boolean novo = true;
    private ArrayList<String> caminhobanco = new ArrayList<String>();

    /**
     * Creates new form CadAuxiliar
     */
    public CadPessoa() {
        initComponents();

        ConectarTodos conectar = new ConectarTodos();
        //conectar.local();
        caminhobanco = conectar.getCaminhoBancos();

    }

    public void ChamaAuxiliar(String busca, Integer origem) {
        if (cadAuxiliar == null) {
            cadAuxiliar = new CadAuxiliar();
        }
        cadAuxiliar.cadAuxiliarD(busca, origem, caminhobanco);  //origem do cadastro 1 - paises, 2 - Estado, 3-Cidade,4-Bairro ,5-logradouro
        cadAuxiliar.setVisible(true);
        cadAuxiliar.setDefaultCloseOperation(HIDE_ON_CLOSE);
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
        jButtonNovo = new javax.swing.JButton();
        jButtonGravar = new javax.swing.JButton();
        jButtonConsulta = new javax.swing.JButton();
        jTextNome = new javax.swing.JTextField();
        jButtonLogrado = new javax.swing.JButton();
        jButtonBairro = new javax.swing.JButton();
        jButtonCidade = new javax.swing.JButton();
        jButtonEstado = new javax.swing.JButton();
        jButtonPais = new javax.swing.JButton();
        jTextPais = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabeltitulo = new javax.swing.JLabel();
        jTextCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextLogradouro = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextBairro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextEstado = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextCidade = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonNovo.setText("Novo");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jButtonGravar.setText("Gravar");
        jButtonGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGravarActionPerformed(evt);
            }
        });

        jButtonConsulta.setText("Consulta");
        jButtonConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonConsulta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                    .addComponent(jButtonGravar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                    .addComponent(jButtonNovo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonGravar)
                .addGap(18, 18, 18)
                .addComponent(jButtonConsulta)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonLogrado.setText("jButton1");
        jButtonLogrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogradoActionPerformed(evt);
            }
        });

        jButtonBairro.setText("jButton2");
        jButtonBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBairroActionPerformed(evt);
            }
        });

        jButtonCidade.setText("jButton5");
        jButtonCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCidadeActionPerformed(evt);
            }
        });

        jButtonEstado.setText("jButton6");
        jButtonEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEstadoActionPerformed(evt);
            }
        });

        jButtonPais.setText("jButton7");
        jButtonPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPaisActionPerformed(evt);
            }
        });

        jTextPais.setEditable(false);

        jLabel2.setText("Codigo");

        jLabel1.setText("Pais");

        jLabeltitulo.setFont(new java.awt.Font("Arial Unicode MS", 0, 24)); // NOI18N
        jLabeltitulo.setText("Cadastro de Pessoas");

        jTextCodigo.setEditable(false);

        jLabel3.setText("Nome");

        jTextLogradouro.setEditable(false);

        jLabel4.setText("Logradouro");

        jTextBairro.setEditable(false);

        jLabel5.setText("Bairro");

        jLabel6.setText("Estado");

        jTextEstado.setEditable(false);

        jLabel7.setText("Cidade");

        jTextCidade.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jTextCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(243, 243, 243))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(154, 154, 154)
                                    .addComponent(jLabeltitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(66, 66, 66)
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTextNome, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(66, 66, 66))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jTextPais, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jTextEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jTextCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jTextBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jTextLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonLogrado, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(jButtonEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(jButtonPais, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabeltitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jTextLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jTextBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonBairro)))
                            .addComponent(jButtonLogrado))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonCidade))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonEstado))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonPais)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultaActionPerformed
        // TODO add your handling code here:
        consultar = new Consultar();
        consultar.Consultar(caminhobanco);
        consultar.setVisible(true);
        consultar.setDefaultCloseOperation(HIDE_ON_CLOSE);
    }//GEN-LAST:event_jButtonConsultaActionPerformed

    private void jButtonLogradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogradoActionPerformed
        // TODO add your handling code here:
        ChamaAuxiliar("Logradouro", 5);//origem do cadastro 1 - paises, 2 - Estado, 3-Cidade,4-Bairro ,5-logradouro
    }//GEN-LAST:event_jButtonLogradoActionPerformed

    private void jButtonBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBairroActionPerformed
        // TODO add your handling code here:
        ChamaAuxiliar("Bairro", 4);//origem do cadastro 1 - paises, 2 - Estado, 3-Cidade,4-Bairro ,5-logradouro
    }//GEN-LAST:event_jButtonBairroActionPerformed

    private void jButtonCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCidadeActionPerformed
        // TODO add your handling code here:
        ChamaAuxiliar("Cidade", 3);//origem do cadastro 1 - paises, 2 - Estado, 3-Cidade,4-Bairro ,5-logradouro
    }//GEN-LAST:event_jButtonCidadeActionPerformed

    private void jButtonEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEstadoActionPerformed
        // TODO add your handling code here:
        ChamaAuxiliar("Estado", 2);//origem do cadastro 1 - paises, 2 - Estado, 3-Cidade,4-Bairro ,5-logradouro
    }//GEN-LAST:event_jButtonEstadoActionPerformed

    private void jButtonPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPaisActionPerformed
        // TODO add your handling code here:
        ChamaAuxiliar("Pais", 1);//origem do cadastro 1 - paises, 2 - Estado, 3-Cidade,4-Bairro ,5-logradouro
    }//GEN-LAST:event_jButtonPaisActionPerformed

    private void jButtonGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGravarActionPerformed
        // TODO add your handling code here:
        if (("").equals(jTextNome.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Digite um nome Valido!!!");
            jTextNome.requestFocus();
            return;
        }

        PessoaBean pessoa = new PessoaBean();
        PessoaDao pessoadao = new PessoaDao();
        MovimentoDao movimentoDao = new MovimentoDao();
        MovimentoBean movimento = new MovimentoBean();
        pessoa.setNomePessoa(jTextNome.getText());
        pessoa.setCodLogradouro(codLogradouro);
        pessoa.setCodBairro(codBairro);
        pessoa.setCodCidade(codCidade);
        pessoa.setCodEstado(codEstado);
        pessoa.setCodPais(codPais);
        int[] ordem = new RandomBanco().RandomBancoOrdem();

        if (novo == true) {
            pessoadao.insert(pessoa, "localhost");
            novo = false;

            jTextCodigo.setText(String.valueOf(pessoadao.UltimoCodigo()));
            pessoa.setCodigo(Integer.valueOf(jTextCodigo.getText()));

            for (int i = 0; i < ordem.length; i++) { //replicando pessoa
                String site = caminhobanco.get(ordem[i]).replace(".", "");
                pessoadao.insert(pessoa, caminhobanco.get(ordem[i]));
            }

            movimento.setDataMovimento(converteData(new java.text.SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date())));
            movimento.setIdPessoa(pessoa.getCodigo());
            movimento.setOperacaoMovimento(1);

            movimento.setSiteMovimento(0);
            movimentoDao.insert(movimento, "localhost");
            for (int i = 0; i < ordem.length; i++) {
                String site = caminhobanco.get(ordem[i]).replace(".", "");
                movimento.setSiteMovimento(Integer.valueOf(site));
                movimentoDao.insert(movimento, "localhost");
            }

            for (int i = 0; i < ordem.length; i++) {
                for (int j = 0; j <= ordem.length; j++) {
                    if (j == 0) {
                        movimento.setSiteMovimento(j);
                        movimentoDao.insert(movimento, caminhobanco.get(ordem[i]));
                    } else {
                        String site = caminhobanco.get(ordem[j - 1]).replace(".", "");
                        movimento.setSiteMovimento(Integer.valueOf(site));
                        movimentoDao.insert(movimento, caminhobanco.get(ordem[i]));
                    }
                }
            }

        } else {
            pessoa.setCodigo(Integer.valueOf(jTextCodigo.getText()));
            pessoadao.update(pessoa, "localhost");

            for (int i = 0; i < ordem.length; i++) { //replicando pessoa
                String site = caminhobanco.get(ordem[i]).replace(".", "");
                pessoadao.update(pessoa, caminhobanco.get(ordem[i]));
            }

            movimento.setDataMovimento(converteData(new java.text.SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date())));
            movimento.setIdPessoa(pessoa.getCodigo());
            movimento.setOperacaoMovimento(2);
            

            movimento.setSiteMovimento(0);
            movimentoDao.insert(movimento, "localhost");
            for (int i = 0; i < ordem.length; i++) {
                String site = caminhobanco.get(ordem[i]).replace(".", "");
                movimento.setSiteMovimento(Integer.valueOf(site));
                movimentoDao.insert(movimento, "localhost");
            }

            for (int i = 0; i < ordem.length; i++) {
                for (int j = 0; j <= ordem.length; j++) {
                    if (j == 0) {
                        movimento.setSiteMovimento(j);
                        movimentoDao.insert(movimento, caminhobanco.get(ordem[i]));
                    } else {
                        String site = caminhobanco.get(ordem[j - 1]).replace(".", "");
                        movimento.setSiteMovimento(Integer.valueOf(site));
                        movimentoDao.insert(movimento, caminhobanco.get(ordem[i]));
                    }
                }
            }
        } 
    }//GEN-LAST:event_jButtonGravarActionPerformed

    

    private Date converteData(String mydata) {
        Date data = null;
        try {
            DateFormat dtOutput = new SimpleDateFormat("dd/MM/yyyy");
            data = dtOutput.parse(mydata);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return data;
    }
    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        // TODO add your handling code here:
        novo = true;
        jTextBairro.setText("");
        jTextCidade.setText("");
        jTextCodigo.setText("");
        jTextEstado.setText("");
        jTextLogradouro.setText("");
        jTextNome.setText("");
        jTextPais.setText("");

        jTextNome.requestFocus();
    }//GEN-LAST:event_jButtonNovoActionPerformed

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
            java.util.logging.Logger.getLogger(CadPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadPessoa().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBairro;
    private javax.swing.JButton jButtonCidade;
    private javax.swing.JButton jButtonConsulta;
    private javax.swing.JButton jButtonEstado;
    private javax.swing.JButton jButtonGravar;
    private javax.swing.JButton jButtonLogrado;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonPais;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabeltitulo;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JTextField jTextBairro;
    public static javax.swing.JTextField jTextCidade;
    public static javax.swing.JTextField jTextCodigo;
    public static javax.swing.JTextField jTextEstado;
    public static javax.swing.JTextField jTextLogradouro;
    public static javax.swing.JTextField jTextNome;
    public static javax.swing.JTextField jTextPais;
    // End of variables declaration//GEN-END:variables
}
