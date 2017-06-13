/*
 * PendenciaBaixaManagedBean.java
 *
 * Created on 26 de Setembro de 2006, 11:18
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.correios.sromonitor.managed.beans;

import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.correios.sromonitor.managers.GerenteEstacoesDeTrabalho;
import br.com.correios.sromonitor.managers.GerentePendenciaBaixa;
import br.com.correios.sromonitor.managers.ManagementException;
import br.com.correios.sromonitor.vos.EstacoesDeTrabalho;


/**
 * ManagedBean para a pend&ecirc;ncia de baixa.
 * @author WMT
 */
public class EstacoesDeTrabalhoManagedBean  extends MonitorManagedBean {
    
    private String codigoUnidade;
    private List<EstacoesDeTrabalho> estacoesDeTrabalho;
    private GerenteEstacoesDeTrabalho gerente;

    
    /**
     * Creates a new instance of PendenciaBaixaManagedBean
     */
    public EstacoesDeTrabalhoManagedBean() {
        
        gerente = new GerenteEstacoesDeTrabalho();
        
      
    }
    

    /**
     * C&oacute;digo da unidade.
     * @return C&oacute;digo da unidade.
     */
    public String getCodigoUnidade() {
        return codigoUnidade;
    }
    
    /**
     * C&oacute;digo da unidade.
     * @param codigoUnidade C&oacute;digo da unidade.
     */
    public void setCodigoUnidade(String codigoUnidade) {
        this.codigoUnidade = codigoUnidade;
    }
    
    /**
     *
     * @return
     */
    public String pesquisar() {
    	
        if ( getDr() != null ) {
            try {
            	//teste Versao
            	estacoesDeTrabalho = gerente.getEstacoesDeTrabalho(getDr(), getTipoUnidade(), getUniName (), getUniVersao(), getTipoEstacao());
            	System.out.println("buscou");
                if ( estacoesDeTrabalho == null || estacoesDeTrabalho.size() == 0 ) {
                    setRendered(false);
                    ResourceBundle b = ResourceBundle.getBundle("resources.messages");
                    setMessage(b.getString("no.result"), FacesMessage.SEVERITY_INFO);
                } else {
                    Collections.sort(estacoesDeTrabalho, new ComparaAcronym());
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
    
    
    
    
    public List<EstacoesDeTrabalho> getEstacoesDeTrabalho() {
		return estacoesDeTrabalho;
	}


	public void setEstacoes(List<EstacoesDeTrabalho> estacoesDeTrabalho) {
		this.estacoesDeTrabalho = estacoesDeTrabalho;
	}



    
    public String detalhe() {
        DetalheEstacoesDeTrabalhoManagedBean detalheEstacoesDeTrabalho =
                (DetalheEstacoesDeTrabalhoManagedBean) getBean("detalheEstacoesDeTrabalho");
        
        
        return "detail";
    }
    
    private class ComparaAcronym implements Comparator<EstacoesDeTrabalho> {
        
        public int compare(EstacoesDeTrabalho o1, EstacoesDeTrabalho o2) {
            
            
            Collator c = Collator.getInstance(
                    FacesContext.getCurrentInstance()
                    .getApplication().getDefaultLocale());
            
            return c.compare(o1.getRD_ACRONYM(), o2.getRD_ACRONYM());
        }
        
    }       
    
	@Override
	public List<?> getTransmissoes() {
		
		return null;
	}  
}
