/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exercicio3.bancodao;

import exercicio3.bancobean.ConsultaPessoaBean;
import exercicio3.bancobean.PessoaBean;
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
public class PessoaDao {
    
    public void insert(PessoaBean pessoa,String lConexao) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = ConectarBancoLocal.conectar(lConexao);
            String sql = "insert into Pessoas (idPessoa, nomePessoa, Logradouros_idLogradouro, Bairros_idBairro, Cidades_idCidade, Estados_idEstado, Paises_idPais) values(pessoas_seq.nextval,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, pessoa.getNomePessoa());
            ps.setInt(2, pessoa.getCodLogradouro());           
            ps.setInt(3, pessoa.getCodBairro());            
            ps.setInt(4, pessoa.getCodCidade());            
            ps.setInt(5, pessoa.getCodEstado());            
            ps.setInt(6, pessoa.getCodPais());                        
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
    
    public void update(PessoaBean pessoa, String lConexao) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = ConectarBancoLocal.conectar(lConexao);
            String sql = "update Pessoas set nomePessoa = ?, Logradouros_idLogradouro = ?, Bairros_idBairro =?, Cidades_idCidade = ?, Estados_idEstado = ?, Paises_idPais = ? where idPessoa = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, pessoa.getNomePessoa());
            ps.setInt(2, pessoa.getCodLogradouro());
            ps.setInt(3, pessoa.getCodBairro());
            ps.setInt(4, pessoa.getCodCidade());
            ps.setInt(5, pessoa.getCodEstado());
            ps.setInt(6, pessoa.getCodPais());
            ps.setInt(7, pessoa.getCodigo());
            
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
        Integer codigo =0; 
        try {
            conn = ConectarBancoLocal.conectar("localhost");
            String sql = "select Max(idPessoa) from Pessoas";
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
    
    
    public List<ConsultaPessoaBean> selectPessoa(String textBusca, Integer origemBusca ) { //origemBusca 1 - codigo 2 - nome
        List<ConsultaPessoaBean> lista = new ArrayList<ConsultaPessoaBean>();
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = ConectarBancoLocal.conectar("localhost");
            String sql = " SELECT pessoas.idPessoa, pessoas.nomePessoa, pessoas.Logradouros_idlogradouro, logradouros.nomeLogradouro, pessoas.Bairros_idBairro, "
                    + " bairros.nomeBairro, pessoas.Cidades_idCidade, cidades.nomeCidade, pessoas.Estados_idEstado, estados.nomeEstado, pessoas.paises_idPais, paises.nomePais " 
                    + " FROM Pessoas JOIN logradouros ON(logradouros.idlogradouro = pessoas.Logradouros_idlogradouro) JOIN bairros ON ( bairros.idBairro = pessoas.Bairros_idBairro)"
                    + " JOIN cidades ON(cidades.idCidade = pessoas.Cidades_idCidade) JOIN estados ON(estados.idEstado = pessoas.Estados_idEstado) "
                    + " JOIN paises ON (paises.idPais = pessoas.paises_idPais)";
            if (origemBusca == 1) {
                sql = sql + " WHERE pessoas.idPessoa = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1,Integer.valueOf(textBusca));
            }
            else{
                sql = sql + " WHERE pessoas.nomePessoa like '%" + textBusca + "%'";
                ps = conn.prepareStatement(sql);
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                rs.getString(2);
                ConsultaPessoaBean consultaPessoa = new ConsultaPessoaBean();
                consultaPessoa.setCodiPessoa(rs.getInt(1)); //pessoas.idPessoa
                consultaPessoa.setNomePessoa(rs.getString(2)); //pessoas.nomePessoa
                consultaPessoa.setCodiLogradouro(rs.getInt(3)); // pessoas.Logradouros_idlogradouro
                consultaPessoa.setNomeLogradouro(rs.getString(4)); //logradouros.nomeLogradouro
                consultaPessoa.setCodiBairro(rs.getInt(5)); // pessoas.Bairros_idBairro, 
                consultaPessoa.setNomeBairro(rs.getString(6)); // bairros.nomeBairro, 
                consultaPessoa.setCodiCidade(rs.getInt(7)); // pessoas.Cidades_idCidade
                consultaPessoa.setNomeCidade(rs.getString(8)); // cidades.nomeCidade, 
                consultaPessoa.setCodiEstado(rs.getInt(9)); // pessoas.Estados_idEstado
                consultaPessoa.setNomeEstado(rs.getString(10)); // stados.nomeEstado, 
                consultaPessoa.setCodiPais(rs.getInt(11)); //pessoas.paises_idPais
                consultaPessoa.setNomePais(rs.getString(12)); // paises.nomePais  
                lista.add(consultaPessoa);
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
    
}
