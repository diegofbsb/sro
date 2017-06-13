/*
 * ControleTransmissaoManagedBean.java
 *
 * Created on 8 de Setembro de 2006, 15:05
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.correios.sromonitor.managed.beans;

import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;

import br.com.correios.sromonitor.managers.GerenteControleTransmissao;
import br.com.correios.sromonitor.managers.ManagementException;
import br.com.correios.sromonitor.vos.ControleTransmissao;

/**
 * ManagedBean para o controle de transmiss&otilde;es.
 * @author Jean Clay Souza da Silva - Analista POLITEC - DESUN/DSGL
 */
public class ControleTransmissaoManagedBean extends AbstractManagedBean {
    private String codigoUnidade;
    private Date startDate;
    private Date endDate;
    private GerenteControleTransmissao gerente;
    private List<ControleTransmissao> transmissoes;
    
    /** Creates a new instance of ControleTransmissaoManagedBean */
    public ControleTransmissaoManagedBean() {
        gerente = new GerenteControleTransmissao();
    }
    
    /**
     * Retorna o c&oacute;digo da unidade.
     * @return C&oacute;digo da unidade.
     */
    public String getCodigoUnidade() {
        return codigoUnidade;
    }
    
    /**
     * Define o c&oacute;digo da unidade.
     * @param codigoUnidade Novo c&oacute;digo da unidade.
     */
    public void setCodigoUnidade(String codigoUnidade) {
        this.codigoUnidade = codigoUnidade;
    }
    
    /**
     * Data inicial.
     * @return Data inicial.
     */
    public Date getStartDate() {
        return startDate;
    }
    
    /**
     * Define a data inicial.
     * @param startDate Data inicial.
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    
    /**
     * Data final.
     * @return Data final.
     */
    public Date getEndDate() {
        return endDate;
    }
    
    /**
     * Define a data final.
     * @param endDate Data final.
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    /**
     * 
     * @return 
     */
    public String pesquisar() {
        
        
        try {
            transmissoes = gerente.getTransmissoes(getCodigoUnidade(), getStartDate(), getEndDate());
            if ( transmissoes == null || transmissoes.size() == 0 ) {
                setRendered(false);
                ResourceBundle b = ResourceBundle.getBundle("resources.messages");
                setMessage(b.getString("no.result"), FacesMessage.SEVERITY_INFO);
            } else {
                setRendered(true);
            }
            return AbstractManagedBean.SUCCESS;
        } catch (ManagementException ex) {
            this.setMessage(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
            ex.printStackTrace();
        }
        return AbstractManagedBean.ERROR;
    }
    
    /**
     * 
     * @return 
     */
    public List<ControleTransmissao> getTransmissoes() {
        
        return transmissoes;
    }
    
    public String getNomeUnidade() {
        String nomeUnidade = null;
        try {
            
            nomeUnidade = gerente.getNomeUnidade(this.getCodigoUnidade());
        } catch (ManagementException ex) {
            setMessage(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
            nomeUnidade = "";
        }
        
        return nomeUnidade;
    }

    
}
