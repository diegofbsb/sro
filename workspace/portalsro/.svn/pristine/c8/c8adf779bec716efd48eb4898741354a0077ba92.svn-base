/*
 * Transmissao.java
 *
 * Created on 30 de Agosto de 2006, 18:47
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.correios.sromonitor.vos;

import java.util.Date;

/**
 * VO para op controle de transmiss&otilde;es.
 * @author Jean Clay Souza da Silva - Analista POLITEC - DESUN/DSGL
 */
public class Transmissao implements java.io.Serializable {
    private String codigo;
    private String nome;
    private String evento;
    private Integer reop;
    private Date data;
    private String tempo;
    private String dr;
    private String codigoMCU;
    private String sistemaGerador;

    /**
     * Creates a new instance of Transmissao
     */
    public Transmissao() {
    }

    /**
     * Retorna o c&oacute;digo da unidade.
     * @return O c&oacute;digo da unidade.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Define o c&oacute;digo da unidade.
     * @param codigo Novo c&oacute;digo da unidade.
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Retorna o nome da unidade.
     * @return O nome da unidade.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da unidade.
     * @param nome Novo nome da unidade.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
    
	public String getCodigoMCU() {
		return codigoMCU;
	}

	public void setCodigoMCU(String codigoMCU) {
		this.codigoMCU = codigoMCU;
	}
	
	public String getSistemaGerador() {
		return sistemaGerador;
	}
	
	public void setSistemaGerador(String sistemaGerador) {
		this.sistemaGerador = sistemaGerador;
	}

    /**
     * Retorna o tipo de evento.
     * @return O tipo de evento.
     */
    public String getEvento() {
        return evento;
    }

    /**
     * Define o tipo de evento.
     * @param evento Novo tipo de evento.
     */
    public void setEvento(String evento) {
        this.evento = evento;
    }

    /**
     * Retorna o n&uacute;mero da REOP.
     * @return O n&uacute;mero da REOP.
     */
    public Integer getReop() {
        return reop;
    }

    /**
     * Define o n&uacute;mero da REOP.
     * @param reop O n&uacute;mero da REOP.
     */
    public void setReop(Integer reop) {
        this.reop = reop;
    }

    /**
     * Retorna o tempo de transmiss&atilde;o.
     * @return O tempo de transmiss&atilde;o.
     */
    public String getTempo() {
        return tempo;
    }

    /**
     * Define o tempo de transmiss&atilde;o.
     * @param tempo Novo tempo de transmiss&atilde;o.
     */
    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    /**
     * Retorna a data em que houve a transmiss&atilde;o.
     * @return A data em que houve a transmiss&atilde;o.
     */
    public Date getData() {
        return data;
    }

    /**
     * Define a data em que houve a transmiss&atilde;o.
     * @param data Nova data em que houve a transmiss&atilde;o.
     */
    public void setData(Date data) {
        this.data = data;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return getCodigo() + " " + getData() + " " + getEvento() +
                " " + getNome() + " " + getReop() + " " + getTempo();
    }

    /**
     * Retorna a DR.
     * @return DR.
     */
    public String getDr() {
        return dr;
    }

    /**
     * Define a DR.
     * @param dr Nova DR.
     */
    public void setDr(String dr) {
        this.dr = dr;
    }


    
}
