/*
 * ObjetoIrregularManagedBean.java
 *
 * Created on 12 de Julho de 2007, 15:13
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

import br.com.correios.sromonitor.managers.GerenteObjetoIrregular;
import br.com.correios.sromonitor.managers.ManagementException;
import br.com.correios.sromonitor.vos.ObjetoIrregular;

/**
 *
 * @author Jean Clay Souza da Silva - Analista - DESUN/DSGL/CRO
 */
public class ObjetoIrregularManagedBean extends AbstractManagedBean {
    private List<ObjetoIrregular> irregulares = Collections.emptyList();
    private String dr;
    private GerenteObjetoIrregular gerente;
    
    /** Creates a new instance of ObjetoIrregularManagedBean */
    public ObjetoIrregularManagedBean() {
        gerente = new GerenteObjetoIrregular();
    }

    public String pesquisar() {
        String d = getDr();
        if ( d == null ) {
            this.setMessage("DR nula.", FacesMessage.SEVERITY_ERROR);
        } else {
            try {
                irregulares = new ArrayList<ObjetoIrregular>(
                        gerente.getObjetosIrregulares(dr));
                if ( irregulares == null || irregulares.size() == 0 ) {
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

    public List<ObjetoIrregular> getTransmissoes() {
        return irregulares;
    }

    public String getDr() {
        return dr;
    }

    public void setDr(String dr) {
        this.dr = dr;
    }
    
}
