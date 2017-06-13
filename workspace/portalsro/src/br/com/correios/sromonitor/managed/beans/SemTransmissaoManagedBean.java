/*
 * SemTransmissaoManagedBean.java
 *
 * Created on 6 de Setembro de 2006, 09:50
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.correios.sromonitor.managed.beans;

import java.util.List;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;

import br.com.correios.sromonitor.managers.GerenteSemTransmissao;
import br.com.correios.sromonitor.managers.ManagementException;
import br.com.correios.sromonitor.vos.Transmissao;

/**
 * ManagedBean para a aus&ecirc;ncia de trasmiss&ccedil;&atilde;o.
 * @author Jean Clay Souza da Silva - Analista POLITEC - DESUN/DSGL
 */
public class SemTransmissaoManagedBean extends MonitorManagedBean {
    
    private GerenteSemTransmissao gerente;
    
    private List<Transmissao> transmissoes;
    /** Creates a new instance of SemTransmissaoManagedBean */
    public SemTransmissaoManagedBean() {
        gerente = new GerenteSemTransmissao();
    }
    
    
    /**
     *
     * @return
     */
    public String pesquisar() {
        
        if ( getDr() != null ) {
            try {
                transmissoes = gerente.getSemTransmissao(getDr(), getReop(), getTipoUnidade());
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
        }
        return AbstractManagedBean.ERROR;
        
    }
    
    /**
     *
     * @return
     */
    public List<Transmissao> getTransmissoes() {
        return transmissoes;
    }
    
}
