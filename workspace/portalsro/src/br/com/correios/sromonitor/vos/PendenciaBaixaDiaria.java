package br.com.correios.sromonitor.vos;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 * VO para o relatório diário de pendências de baixa.
 * 
 * @author Paulo Henrique Mendes
 */
public class PendenciaBaixaDiaria implements Serializable {

	private static final long serialVersionUID = 1L;

	private String dr;
	private String lancado;
	private String pendencia;

	public PendenciaBaixaDiaria() {
	}
	
	public String getPercentual() {
		double lanc = Double.parseDouble(lancado);
		double pend = Double.parseDouble(pendencia);
        double perc = 100;
                
        if (lanc > 0) {
            perc = (100 * pend) / lanc;
        }
        
        return new DecimalFormat("0.00").format(perc);
	}
	
	public String getDr() {
		return dr;
	}

	public void setDr(String dr) {
		this.dr = dr;
	}

	public String getLancado() {
		return lancado;
	}

	public void setLancado(String lancado) {
		this.lancado = lancado;
	}

	public String getPendencia() {
		return pendencia;
	}

	public void setPendencia(String baixado) {
		this.pendencia = baixado;
	}

}
