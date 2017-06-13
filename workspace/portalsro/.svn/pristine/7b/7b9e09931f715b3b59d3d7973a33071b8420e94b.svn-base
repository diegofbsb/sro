/*
 * ArquivoRepetidoManagedBean.java
 *
 * Created on 29 de Maio de 2007, 16:17
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.correios.sromonitor.managed.beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;

import br.com.correios.sromonitor.managers.GerenteArquivoRepetido;
import br.com.correios.sromonitor.managers.ManagementException;
import br.com.correios.sromonitor.vos.ArquivoRepetido;

/**
 *
 * @author jeans
 */
public class ArquivoRepetidoManagedBean extends AbstractManagedBean {
    private List<ArquivoRepetido> repetidos = Collections.emptyList();
    private GerenteArquivoRepetido gerente;
    private String dr;
    /** Creates a new instance of ArquivoRepetidoManagedBean */
    public ArquivoRepetidoManagedBean() {
        gerente = new GerenteArquivoRepetido();
    }
    
    public String pesquisar() {
        String d = getDr();
        if ( d == null ) {
            this.setMessage("DR nula.", FacesMessage.SEVERITY_ERROR);
        } else {
            try {
                repetidos = new ArrayList<ArquivoRepetido>(
                        gerente.getArquivosRepetidos(d));
                if ( repetidos == null || repetidos.size() == 0 ) {
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
    
    public List<ArquivoRepetido> getTransmissoes() {
        return Collections.unmodifiableList(repetidos);
    }
    
    public String getDr() {
        return dr;
    }
    
    public void setDr(String dr) {
        this.dr = dr;
    }
    
}
