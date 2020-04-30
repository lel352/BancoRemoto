/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio3.bancobean;

import java.util.Date;

/**
 *
 * @author Leandro
 */
public class MovimentoBean {

    private Integer idMovimento;
    private Integer operacaoMovimento;
    private Integer siteMovimento;
    private Date dataMovimento;
    private Integer idPessoa;

    public Integer getIdMovimento() {
        return idMovimento;
    }

    public void setIdMovimento(Integer idMovimento) {
        this.idMovimento = idMovimento;
    }

    public Integer getOperacaoMovimento() {
        return operacaoMovimento;
    }

    public void setOperacaoMovimento(Integer operacaoMoviemento) {
        this.operacaoMovimento = operacaoMoviemento;
    }

    public Integer getSiteMovimento() {
        return siteMovimento;
    }

    public void setSiteMovimento(Integer siteMovimento) {
        this.siteMovimento = siteMovimento;
    }

    public Date getDataMovimento() {
        return dataMovimento;
    }

    public void setDataMovimento(Date dataMovimento) {
        this.dataMovimento = dataMovimento;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }
    
    
}
