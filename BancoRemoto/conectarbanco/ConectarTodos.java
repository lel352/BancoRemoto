/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio3.conectarbanco;

import exercicio3.metodos.Arquivos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Leandro
 */
public class ConectarTodos {

    private ArrayList<String> caminhobanco = new ArrayList<String>();

    public ArrayList<String> getCaminhoBancos() {
        return caminhobanco;
    }

    public ConectarTodos() {
        Arquivos caminho = new Arquivos();
        String lConexao = caminho.pegarinformacao("banco1");
        caminhobanco.add(lConexao);
        lConexao = caminho.pegarinformacao("banco2");
        caminhobanco.add(lConexao);
        lConexao = caminho.pegarinformacao("banco3");
        caminhobanco.add(lConexao);
        String criarBanco = caminho.pegarinformacao("criar_banco");
       /* local();
        /*
        for (int i=0;i<caminhobanco.size();i++){
             Banco1(caminhobanco.get(i));
        }*/


       /* if (criarBanco.equals("1")) {
           local();
           for (int i=0;i<caminhobanco.size();i++){
             Banco1(caminhobanco.get(i));
           }
           caminho.regravarLinha("criar_banco=2;", "criar_banco=1;");
        }*/
    }

    public void local() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = ConectarBancoLocal.conectar("localhost");
            for (int i = 0; i <= 13; i++) {
               // conn = ConectarBancoLocal.conectar("localhost");
                deletetable(conn, i);
            }
            for (int i = 0; i <= 13; i++) {
                //conn = ConectarBancoLocal.conectar("localhost");
                criartables(conn, i);
            }
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());

            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "ERRO: " + ex.getMessage());
                }
            }

        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "ERRO: " + ex.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "ERRO: " + ex.getMessage());
                }
            }
        }

    }

    private void Banco1(String lConexao) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {

            for (int i = 0; i <= 13; i++) {
                conn = ConectarBancoLocal.conectar(lConexao);
                deletetable(conn, i);
            }
            for (int i = 0; i <= 13; i++) {
                conn = ConectarBancoLocal.conectar(lConexao);
                criartables(conn, i);
            }
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());

            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "ERRO: " + ex.getMessage());
                }
            }

        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "ERRO: " + ex.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "ERRO: " + ex.getMessage());
                }
            }
        }
    }

    public void deletetable(Connection conn, Integer ordem) {

        PreparedStatement ps = null;
        String sql = "begin";
        try {
            switch (ordem) {
                case 0:
                    sql = sql + " execute immediate ('drop table Movimentos'); "
                            + " exception when others then null;"
                            + " end;";
                    break;
                case 1:
                    sql = sql + " execute immediate ('drop table Pessoas');"
                            + " exception when others then null;"
                            + " end;";
                    break;
                case 2:
                    sql = sql + " execute immediate ('drop table Logradouros');"
                            + " exception when others then null;"
                            + " end;";
                    break;
                case 3:
                    sql = sql + " execute immediate ('drop table Bairros');"
                            + " exception when others then null;"
                            + " end;";
                    break;
                case 4:
                    sql = sql + " execute immediate ('drop table Cidades');"
                            + " exception when others then null;"
                            + " end;";
                    break;
                case 5:
                    sql = sql + " execute immediate ('drop table Estados');"
                            + " exception when others then null;"
                            + " end;";
                    break;
                case 6:
                    sql = sql + " execute immediate ('drop table Paises');"
                            + " exception when others then null;"
                            + " end;";
                    break;
                case 7:
                    sql = sql + " execute immediate ('drop sequence logradouros_seq');"
                            + " exception when others then null;"
                            + " end;";
                    break;
                case 8:
                    sql = sql + " execute immediate ('drop sequence cidades_seq');"
                            + " exception when others then null;"
                            + " end;";
                    break;
                case 9:
                    sql = sql + " execute immediate ('drop sequence bairros_seq');"
                            + " exception when others then null;"
                            + " end;";
                    break;
                case 10:
                    sql = sql + " execute immediate ('drop sequence estados_seq');"
                            + " exception when others then null;"
                            + " end;";
                    break;
                case 11:
                    sql = sql + " execute immediate ('drop sequence paises_seq');"
                            + " exception when others then null;"
                            + " end;";
                    break;
                case 12:
                    sql = sql + " execute immediate ('drop sequence pessoas_seq');"
                            + " exception when others then null;"
                            + " end;";
                    break;
                case 13:
                    sql = sql + " execute immediate ('drop sequence movimentos_seq');"
                            + " exception when others then null;"
                            + " end;";
                    break;
            }
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            conn.setAutoCommit(true);

            conn.commit();
        } catch (SQLException e) {
        } finally {
        }
    }

    public void criartables(Connection conn, Integer ordem) {
        PreparedStatement ps = null;
        String sql = null;
        try {
            switch (ordem) {
                case 0:
                    sql = "CREATE TABLE Paises(idPais NUMBER NOT NULL PRIMARY KEY,  nomePais VARCHAR2(30) NOT NULL)  ";
                    break;
                case 1:
                    sql = "CREATE TABLE Estados(idEstado NUMBER NOT NULL PRIMARY KEY, nomeEstado VARCHAR2(30) NOT NULL) ";
                    break;
                case 2:
                    sql = "CREATE TABLE Cidades(idCidade NUMBER NOT NULL PRIMARY KEY, nomeCidade VARCHAR2(30) NOT NULL) ";
                    break;
                case 3:
                    sql = "CREATE TABLE Bairros(idBairro NUMBER NOT NULL PRIMARY KEY, nomeBairro VARCHAR2(30) NOT NULL) ";
                    break;
                case 4:
                    sql = "CREATE TABLE Logradouros(idLogradouro NUMBER NOT NULL PRIMARY KEY, nomeLogradouro VARCHAR2(30) NOT NULL)";
                    break;
                case 5:
                    sql = "CREATE TABLE Pessoas (idPessoa NUMBER NOT NULL PRIMARY KEY, nomePessoa VARCHAR2(50) NOT NULL, Logradouros_idLogradouro NUMBER,  "
                            + "Bairros_idBairro NUMBER, Cidades_idCidade NUMBER, Estados_idEstado NUMBER, Paises_idPais NUMBER,"
                            + "CONSTRAINT fk_logradouros FOREIGN KEY (Logradouros_idLogradouro) REFERENCES Logradouros(idLogradouro),"
                            + "CONSTRAINT fk_bairros FOREIGN KEY (Bairros_idBairro) REFERENCES Bairros(idBairro),"
                            + "CONSTRAINT fk_cidades FOREIGN KEY (Cidades_idCidade) REFERENCES Cidades(idCidade),"
                            + "CONSTRAINT fk_estados FOREIGN KEY (Estados_idEstado) REFERENCES Estados(idEstado),"
                            + "CONSTRAINT fk_paises FOREIGN KEY (Paises_idPais) REFERENCES Paises(idPais))";
                    break;
                case 6:
                    sql = " CREATE TABLE Movimentos (idMovimento NUMBER NOT NULL PRIMARY KEY, OperacaoMovimento NUMBER NOT NULL, siteMovimento NUMBER NOT NULL,"
                            + " dataMovimento VARCHAR2(10), Pessoas_idPessoa, CONSTRAINT fk_pessoas FOREIGN KEY (Pessoas_idPessoa) REFERENCES Pessoas(idPessoa)) ";
                    break;
                case 7:
                    sql = " CREATE SEQUENCE logradouros_seq"
                            + " START WITH     1"
                            + " INCREMENT BY   1"
                            + " NOCACHE"
                            + " NOCYCLE";
                    break;
                case 8:
                    sql = " CREATE SEQUENCE bairros_seq"
                            + " START WITH     1"
                            + " INCREMENT BY   1"
                            + " NOCACHE"
                            + " NOCYCLE";
                    break;
                case 9:
                    sql = " CREATE SEQUENCE cidades_seq"
                            + " START WITH     1"
                            + " INCREMENT BY   1"
                            + " NOCACHE"
                            + " NOCYCLE";
                    break;
                case 10:
                    sql = " CREATE SEQUENCE estados_seq"
                            + " START WITH     1"
                            + " INCREMENT BY   1"
                            + " NOCACHE"
                            + " NOCYCLE";
                    break;
                case 11:
                    sql = " CREATE SEQUENCE paises_seq"
                            + " START WITH     1"
                            + " INCREMENT BY   1"
                            + " NOCACHE"
                            + " NOCYCLE";
                    break;
                case 12:
                    sql = " CREATE SEQUENCE pessoas_seq"
                            + " START WITH     1"
                            + " INCREMENT BY   1"
                            + " NOCACHE"
                            + " NOCYCLE";
                    break;
                case 13:
                    sql = " CREATE SEQUENCE movimentos_seq"
                            + " START WITH     1"
                            + " INCREMENT BY   1"
                            + " NOCACHE"
                            + " NOCYCLE";
                    break;
            }
            ps = conn.prepareStatement(sql);
            ps.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());

            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "ERRO: " + ex.getMessage());
                }
            }

        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "ERRO: " + ex.getMessage());
                }
            }
           /* if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "ERRO: " + ex.getMessage());
                }
            }*/
        }
    }
}
