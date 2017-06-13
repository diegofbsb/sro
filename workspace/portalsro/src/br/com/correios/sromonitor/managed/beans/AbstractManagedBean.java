/*
 * AbstractManagedBean.java
 *
 * Created on 28 de Setembro de 2006, 08:49
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.correios.sromonitor.managed.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Classe abstrata que serve de base para os beans gerenciados pelo JSF.
 * @author Jean Clay Souza da Silva - Analista POLITEC - DESUN/DSGL
 */
public abstract class AbstractManagedBean implements Serializable {
    /**
     * Status de erro.
     */
    public static final String ERROR = "error";
    /**
     * Status de sucesso.
     */
    public static final String SUCCESS = "success";
    
    private boolean rendered;
    
    private FacesContext context;
    
    /** Creates a new instance of AbstractManagedBean */
    public AbstractManagedBean() {
        context = FacesContext.getCurrentInstance();
    }
    
    /**
     * Efetua a pesquisa dos dados.
     * @return Status de erro ou sucesso.
     */
    public abstract String pesquisar();
    
    /**
     * Define uma mensagem a ser exibida pela tag &lt;h:messages&gt; e sua severidade.
     * @param message Mensagem a ser exibida.
     * @param severity Severidade da mensagem.
     */
    public void setMessage(String message, FacesMessage.Severity severity) {
        FacesMessage msg = new FacesMessage();
        msg.setSeverity(severity);
        msg.setSummary(message);
        msg.setDetail(message);
        context.addMessage(null, msg);
    }

    /**
     * Verifica se o resultado ser&aacute; renderizado.
     * @return <CODE>true</CODE> ou <CODE>false</CODE>.
     */
    
    public boolean isRendered() {
        return rendered;
    }

    /**
     * Define se o resultado ser&aacute; renderizado.
     * @param rendered Booleano definindo se o resultado ser&aacute; renderizado.
     */
    public void setRendered(boolean rendered) {
        this.rendered = rendered;
    }
    
    /**
     * Retorna os resultados.
     * @return Resultado da pesquisa.
     */
    public abstract List<?> getTransmissoes();
    
    public Object getBean(String beanName) {
        /*
         *PersonnelBean personnelBean = (PersonnelBean)
            FacesContext.getCurrentInstance().getRequestMap().get("PersonnelBean");
         */
        return context.getExternalContext().getRequestMap().get(beanName);
        
    }
    
}
