package br.com.correios.sromonitor.managed.beans;

import java.util.List;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;

import br.com.correios.sromonitor.managers.GerenteFaixaCep;
import br.com.correios.sromonitor.managers.ManagementException;
import br.com.correios.sromonitor.vos.FaixaCepUnidadeOperacional;

/**
 * @author Paulo Henrique Mendes
 */
public class FaixaCepManagedBean extends MonitorManagedBean {

	private static final long serialVersionUID = 1L;
	
	private GerenteFaixaCep gerenteFaixaCep;
	private ResourceBundle messages;
	
	private List<FaixaCepUnidadeOperacional> listaFaixas;
	private String codigoUnidade;

	public FaixaCepManagedBean() {
		gerenteFaixaCep = new GerenteFaixaCep();
		messages = ResourceBundle.getBundle("resources.messages");
	}
	
	public String pesquisar() {
		if (getDr() != null) {
			try {
				listaFaixas = gerenteFaixaCep.pesquisarPorFiltros(this.getDr(), this.getTipoUnidade());
				
				if (listaFaixas != null && listaFaixas.size() != 0) {
					setRendered(true);
                } else {
                	setRendered(false);
                	setMessage(messages.getString("no.result"), FacesMessage.SEVERITY_INFO);
                }
				
				return SUCCESS;
			} catch (ManagementException e) {
				this.setMessage(e.getMessage(), FacesMessage.SEVERITY_ERROR);
	            e.printStackTrace();
			}
		}
		
		return ERROR;
	}
	
	public String abrirInclusao() {
		return "inclusao";
	}
	
	public String incluir() {
		try {
			gerenteFaixaCep.incluir(codigoUnidade);
			setMessage(messages.getString("sucesso.inclusao.faixa"), FacesMessage.SEVERITY_INFO);
			
			return SUCCESS;
		} catch (ManagementException e) {
			this.setMessage(e.getMessage(), FacesMessage.SEVERITY_ERROR);
            e.printStackTrace();
		}
		
		return ERROR;
	}
	
	public String abrirExclusao() {
		return "exclusao";
	}
	
	public String excluir() {
		try {
			gerenteFaixaCep.excluir(codigoUnidade);
			setMessage(messages.getString("sucesso.exclusao.faixa"), FacesMessage.SEVERITY_INFO);
			
			return SUCCESS;
		} catch (ManagementException e) {
			this.setMessage(e.getMessage(), FacesMessage.SEVERITY_ERROR);
            e.printStackTrace();
		}
		
		return ERROR;
	}
	
	// Não utilizado
	public List<?> getTransmissoes() {
		return null;
	}
	
	public List<FaixaCepUnidadeOperacional> getListaFaixas() {
		return listaFaixas;
	}

	public void setListaFaixas(List<FaixaCepUnidadeOperacional> listaFaixas) {
		this.listaFaixas = listaFaixas;
	}
	
	public String getCodigoUnidade() {
		return codigoUnidade;
	}

	public void setCodigoUnidade(String codigoUnidade) {
		this.codigoUnidade = codigoUnidade;
	}

}
