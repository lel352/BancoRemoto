/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio3.bancodao;

import exercicio3.bancobean.MovimentoBean;
import exercicio3.conectarbanco.ConectarBancoLocal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 *
 * @author Leandro
 */
public class MovimentoDao {
        public void insert(MovimentoBean movimento, String lConexao) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = ConectarBancoLocal.conectar(lConexao);
            String sql = "insert into Movimentos (idMovimento, OperacaoMovimento, siteMovimento, dataMovimento, Pessoas_idPessoa) values(movimentos_seq.nextval,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, movimento.getOperacaoMovimento());
            ps.setInt(2, movimento.getSiteMovimento()); 
            java.sql.Date sqlDate = new java.sql.Date(movimento.getDataMovimento().getTime());  
            ps.setDate(3,sqlDate);            
            ps.setInt(4, movimento.getIdPessoa());            
            ps.execute();

            conn.commit();

        } catch(SQLException e) {
            System.out.println("ERRO: " + e.getMessage());

            if(conn != null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }

        } finally {
            if( ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println("ERRO: " + ex.getMessage());
                }
            }
        }
    }
    
    public Integer UltimoCodigo() {
        Connection conn = null;
        PreparedStatement ps = null;
        Integer codigo = 0;
        try {
            conn = ConectarBancoLocal.conectar("localhost");
            String sql = "select max(idMovimento) as codigo from Movimentos";
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
