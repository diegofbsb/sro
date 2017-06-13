package br.com.correios.sromonitor.managed.beans;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;

import br.com.correios.sromonitor.managers.GerentePendenciaBaixaDiaria;
import br.com.correios.sromonitor.managers.ManagementException;
import br.com.correios.sromonitor.vos.PendenciaBaixaDiaria;

/**
 * Managed Bean para o relatório diário de pendências de baixa.
 * 
 * @author Paulo Henrique Mendes
 */
public class PendenciaBaixaDiariaManagedBean extends MonitorManagedBean {
    
	private static final long serialVersionUID = 4337412840592150641L;
	
	private List<PendenciaBaixaDiaria> transmissoes;
    private GerentePendenciaBaixaDiaria gerente;
    
    public PendenciaBaixaDiariaManagedBean() {
    	gerente = new GerentePendenciaBaixaDiaria();
    }
    
	@Override
	public String pesquisar() {
		return null;
	}

	public List<PendenciaBaixaDiaria> getTransmissoes() {
		try {
			transmissoes = gerente.getPendenciaDiaria(getOntem());
			
			if (transmissoes == null || transmissoes.size() == 0) {
				ResourceBundle b = ResourceBundle.getBundle("resources.messages");
				setMessage(b.getString("no.result"), FacesMessage.SEVERITY_INFO);
			}
		} catch (ManagementException ex) {
			this.setMessage(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
			ex.printStackTrace();
		}
		
		return transmissoes;
	}
	
	public String getData() {
		return new SimpleDateFormat("EEEE, dd 'de' MMMM 'de' yyyy").format(getOntem());
	}
	
	private Date getOntem() {
		Calendar cal = Calendar.getInstance();
		
		// Busca sempre para o dia anterior
		cal.roll(Calendar.DATE, false);
		
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		
		return cal.getTime();
	}
	
}
