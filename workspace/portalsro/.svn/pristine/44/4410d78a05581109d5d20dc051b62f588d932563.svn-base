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

import br.com.correios.sromonitor.managers.GerenteDifusaoWebSROIIWebSphere;
import br.com.correios.sromonitor.managers.ManagementException;
import br.com.correios.sromonitor.vos.DifusaoWebSROIIWebSphere;


/**
 * ManagedBean para a pend&ecirc;ncia de baixa.
 * @author Jean Clay Souza da Silva - Analista POLITEC - DESUN/DSGL
 */
public class DifusaoWebSROIIWebSphereManagedBean  extends AbstractManagedBean {
    
    private String codigoUnidade;
    private List<DifusaoWebSROIIWebSphere> unidades;
    private GerenteDifusaoWebSROIIWebSphere gerente;
    private String uniName;
    private boolean resultado = false;
    
    
    /**
     * Creates a new instance of PendenciaBaixaManagedBean
     */
    public DifusaoWebSROIIWebSphereManagedBean() {
        
        gerente = new GerenteDifusaoWebSROIIWebSphere();
        
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
    public String updateUnidade() {
        boolean resultado = false;
        if ( getCodigoUnidade() != null ) {
            try {
                resultado = gerente.getUpdateUniRunningdateUnidade(codigoUnidade);
                if (!resultado) {
                    setRendered(false);
                    setRendered(resultado);
                    ResourceBundle b = ResourceBundle.getBundle("resources.messages");
                    setMessage(b.getString("no.result"), FacesMessage.SEVERITY_INFO);
                } else {
                    mostrar(codigoUnidade);
                    setResultado(resultado);
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
    public String pesquisar() {
        if ( getUniName() != null ) {
            try {
                unidades = gerente.getUnidades(getUniName());
                if ( unidades == null || unidades.size() == 0 ) {
                    setRendered(false);
                    ResourceBundle b = ResourceBundle.getBundle("resources.messages");
                    setMessage(b.getString("no.result"), FacesMessage.SEVERITY_INFO);
                } else {
                    Collections.sort(unidades, new ComparaQuantidadeNome());
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
    
        public void mostrar(String codigo) {
        if ( codigo != null ) {
            try {
                setUnidades(gerente.getUnidadesCodigo(codigo));
                if ( getUnidades() == null || getUnidades().size() == 0 ) {
                    setRendered(false);
                    ResourceBundle b = ResourceBundle.getBundle("resources.messages");
                    setMessage(b.getString("no.result"), FacesMessage.SEVERITY_INFO);
                } else {
                    Collections.sort(getUnidades(), new ComparaQuantidadeNome());
                    setRendered(true);
                }
                
            } catch (ManagementException ex) {
                this.setMessage(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
                ex.printStackTrace();
            }
        }
       
    }
    
    /**
     *
     * @return
     */
    public List<DifusaoWebSROIIWebSphere> getUnidades() {
        return unidades;
    }

    public void setUnidades(List<DifusaoWebSROIIWebSphere> unidades) {
        this.unidades = unidades;
    }

    @Override
    public List<?> getTransmissoes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    private class ComparaQuantidadeNome implements Comparator<DifusaoWebSROIIWebSphere> {
        
        public int compare(DifusaoWebSROIIWebSphere o1, DifusaoWebSROIIWebSphere o2) {
            
            
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
    
    public boolean getResultado() {
        return resultado;
    }

    public void setResultado(boolean resultado) {
        this.resultado = resultado;
    }


    
}
