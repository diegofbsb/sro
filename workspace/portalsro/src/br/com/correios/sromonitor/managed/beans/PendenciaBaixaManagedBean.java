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

import br.com.correios.sromonitor.managers.GerentePendenciaBaixa;
import br.com.correios.sromonitor.managers.ManagementException;
import br.com.correios.sromonitor.vos.PendenciaBaixa;


/**
 * ManagedBean para a pend&ecirc;ncia de baixa.
 * @author Jean Clay Souza da Silva - Analista POLITEC - DESUN/DSGL
 */
public class PendenciaBaixaManagedBean  extends MonitorManagedBean {
    
    private String codigoUnidade;
    private List<PendenciaBaixa> transmissoes;
    private GerentePendenciaBaixa gerente;
    private String uniName;
    private String tipoDeLista;
    
    
    /**
     * Creates a new instance of PendenciaBaixaManagedBean
     */
    public PendenciaBaixaManagedBean() {
        
        gerente = new GerentePendenciaBaixa();
        
        /*
        transmissoes = new ArrayList<PendenciaBaixa>();
        PendenciaBaixa p = new PendenciaBaixa();
        p.setCodigo("88888888");
        p.setNome("Unidade Inexistente");
        p.setQuantidade(3);
        transmissoes.add(p);
         
        p = new PendenciaBaixa();
        p.setCodigo("0000000");
        p.setNome("Unidade Ficticia");
        p.setQuantidade(5);
        transmissoes.add(p);
         
        p = new PendenciaBaixa();
        p.setCodigo("11111111");
        p.setNome("Unidade de Teste");
        p.setQuantidade(50);
        transmissoes.add(p);
         
        p = new PendenciaBaixa();
        p.setCodigo("9999999");
        p.setNome("Unidade Desconhecida");
        p.setQuantidade(100);
        transmissoes.add(p);
         
        p = new PendenciaBaixa();
        p.setCodigo("77777777");
        p.setNome("Unidade Extraterrestre");
        p.setQuantidade(1000);
        transmissoes.add(p);
         */
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
    
    
    public void gerarCodigoBarras(){
    	
    }
    
    public String pesquisar() {
    	
    	System.out.println("TIPO DE LISTA = "+getTipoDeLista());
        if ( getDr() != null ) {
            try {
                transmissoes = gerente.getPendencias(getDr(), getReop(), getTipoUnidade(), getUniName(), getTipoDeLista());
                if ( transmissoes == null || transmissoes.size() == 0 ) {
                    setRendered(false);
                    ResourceBundle b = ResourceBundle.getBundle("resources.messages");
                    setMessage(b.getString("no.result"), FacesMessage.SEVERITY_INFO);
                } else {
                    Collections.sort(transmissoes, new ComparaQuantidadeNome());
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
    public List<PendenciaBaixa> getTransmissoes() {
        return transmissoes;
    }
    
    public String detalhe() {
        DetalhePendenciaBaixaManagedBean detalhePendencia =
                (DetalhePendenciaBaixaManagedBean) getBean("detalhePendencia");
        
        
        return "detail";
    }
    
    private class ComparaQuantidadeNome implements Comparator<PendenciaBaixa> {
        
        public int compare(PendenciaBaixa o1, PendenciaBaixa o2) {
            
            
            Collator c = Collator.getInstance(
                    FacesContext.getCurrentInstance()
                    .getApplication().getDefaultLocale());
            
            return c.compare(o1.getNome(), o2.getNome());
        }
        
    }

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }


	public String getTipoDeLista() {
		return tipoDeLista;
	}


	public void setTipoDeLista(String tipoDeLista) {
		this.tipoDeLista = tipoDeLista;
	}


    
}
