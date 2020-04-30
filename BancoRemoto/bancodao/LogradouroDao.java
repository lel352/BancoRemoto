/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio3.bancodao;

import exercicio3.bancobean.LogradouroBean;
import exercicio3.conectarbanco.ConectarBancoLocal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cassio / Leandro
 */
public class LogradouroDao {

    public void insert(LogradouroBean logradouro,String lConexao) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = ConectarBancoLocal.conectar(lConexao);
            String sql = "insert into Logradouros (idLogradouro, nomeLogradouro) values(logradouros_seq.nextval,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, logradouro.getLogradouro());
            ps.execute();

            conn.commit();

        } catch (SQLException e) {
            System.out.println("ERRO: " + e.getMessage());

            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }

        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
        }
    }

    public List<LogradouroBean> getAll() {
        List<LogradouroBean> lista = new ArrayList<LogradouroBean>();
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = ConectarBancoLocal.conectar("localhost");
            String sql = "select idLogradouro, nomeLogradouro from Logradouros";
            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer codigo = rs.getInt(1);
                String descricao = rs.getString(2);
                LogradouroBean logradouro = new LogradouroBean();
                logradouro.setCodigo(codigo);
                logradouro.setLogradouro(descricao);
                lista.add(logradouro);
            }
        } catch (SQLException e) {
            System.out.println("ERRO: " + e.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
        }
        return lista;
    }
    
    public Integer UltimoCodigo() {
        Connection conn = null;
        PreparedStatement ps = null;
        Integer codigo = 0;
        try {
            conn = ConectarBancoLocal.conectar("localhost");
            String sql = "select max(idLogradouro) as codigo from Logradouros";
            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            rs.next();
            codigo = rs.getInt(1);
           
        } catch (SQLException e) {
            System.out.println("ERRO: " + e.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
        }
        return codigo;
    }
     
}
