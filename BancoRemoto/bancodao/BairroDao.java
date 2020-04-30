/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exercicio3.bancodao;

import exercicio3.bancobean.BairroBean;
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
public class BairroDao {
        public void insert(BairroBean bairro,String lConexao) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = ConectarBancoLocal.conectar(lConexao);
            String sql = "insert into Bairros (idBairro, nomeBairro) values(bairros_seq.nextval,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, bairro.getBairro());
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

    
    public List<BairroBean> getAll() {
        List<BairroBean> lista = new ArrayList<BairroBean>();
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = ConectarBancoLocal.conectar("localhost");
            String sql = "select idBairro, nomeBairro from Bairros";
            ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer codigo = rs.getInt(1);
                String descricao = rs.getString(2);
                BairroBean bairro = new BairroBean();
                bairro.setCodigo(codigo);
                bairro.setBairro(descricao);
                lista.add(bairro);
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
            String sql = "select max(idBairro) as codigo from Bairros";
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
