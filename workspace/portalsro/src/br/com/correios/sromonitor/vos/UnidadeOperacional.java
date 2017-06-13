package br.com.correios.sromonitor.vos;

import java.io.Serializable;

public class UnidadeOperacional implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String codigoSRO;
	private String nome;
	private String uf;

	public UnidadeOperacional() {
	}

	public UnidadeOperacional(String codigoSRO, String nome, String uf) {
		this.codigoSRO = codigoSRO;
		this.nome = nome;
		setUf(uf);
	}

	public String getCodigoSRO() {
		return this.codigoSRO;
	}

	public void setCodigoSRO(String codigoSRO) {
		this.codigoSRO = codigoSRO;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUf() {
		return this.uf;
	}

	public void setUf(String uf) {
		if ((uf != null) && (!uf.equals(""))) {
			if ((uf.equalsIgnoreCase("AC")) || (uf.equalsIgnoreCase("BSB"))) {
				this.uf = "DF";
			} else if ((uf.equalsIgnoreCase("SPM")) || (uf.equalsIgnoreCase("SPI"))) {
				this.uf = "SP";
			} else if (uf.equalsIgnoreCase("ACR")) {
				this.uf = "AC";
			} else {
				this.uf = uf;
			}
		}
	}
	
}
