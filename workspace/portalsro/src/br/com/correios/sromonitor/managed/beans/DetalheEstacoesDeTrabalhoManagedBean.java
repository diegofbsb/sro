/*
 * DetalhePendenciaBaixaManagedBean.java
 *
 * Created on 8 de Novembro de 2006, 09:19
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
import br.com.correios.sromonitor.managers.ManagementException;
import br.com.correios.sromonitor.vos.DetalheEstacoesDeTrabalho;

/**
 *
 * @author jeans
 */
public class DetalheEstacoesDeTrabalhoManagedBean extends AbstractManagedBean {

    private String codigo;
    private String nome;
    private GerenteEstacoesDeTrabalho manager = new GerenteEstacoesDeTrabalho();
    private Integer numObjetos = 0;


    /** Creates a new instance of DetalhePendenciaBaixaManagedBean */
    public DetalheEstacoesDeTrabalhoManagedBean() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String pesquisar() {
        return null;
    }

    public List<DetalheEstacoesDeTrabalho> getEstacoesDeTrabalho() {
        List<DetalheEstacoesDeTrabalho> result = null;
        try {
            result = manager.getDetalhes(this.getCodigo());

            if ( result == null || result.size() == 0) {
                setRendered(false);
                ResourceBundle b = ResourceBundle.getBundle("resources.messages");
                setMessage(b.getString("no.result"), FacesMessage.SEVERITY_INFO);
            } else {
                Collections.sort(result, new ComparaTempoData());
                setNumObjetos(result.size());
                setRendered(true);
            }

        } catch (ManagementException ex) {
            ex.printStackTrace();
            setMessage(ex.getMessage(), FacesMessage.SEVERITY_INFO);
        }

        return result;
    }

    private class ComparaTempoData implements Comparator<DetalheEstacoesDeTrabalho> {

        public int compare(DetalheEstacoesDeTrabalho o1, DetalheEstacoesDeTrabalho o2) {


            Collator c = Collator.getInstance(
                    FacesContext.getCurrentInstance()
                    .getApplication().getDefaultLocale());

            int result = c.compare(o1.getTempo(), o2.getTempo());

            if ( result == 0 ) {
                result = o1.getDataCriacao().compareTo(o2.getDataCriacao());
            }

            return result;
        }

    }

    public Integer getNumObjetos() {
        return numObjetos;
    }

    public void setNumObjetos(Integer numObjetos) {
        this.numObjetos = numObjetos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

	@Override
	public List<?> getTransmissoes() {
		
		return null;
	}


    
}