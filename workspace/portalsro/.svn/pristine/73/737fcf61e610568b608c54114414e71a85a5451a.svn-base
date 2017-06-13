/*
 * DetalhePendenciaBaixa.java
 *
 * Created on 8 de Novembro de 2006, 12:59
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.correios.sromonitor.vos;

import java.util.Date;

/**
 *
 * @author jeans
 */
public class DetalhePendenciaBaixa {
    private String objeto;
    private Date dataCriacao;
    private Date datInsercao;
    private String tempo;
    private String prazo;
    
    /** Creates a new instance of DetalhePendenciaBaixa */
    public DetalhePendenciaBaixa() {
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }
    
    
    
    
    public String getPrazo() {
		return prazo;
	}

	public void setPrazo(String prazo) {
		this.prazo = prazo;
	}

	@Override
    public boolean equals(Object o) {
        boolean status = false;
        
        if ( o instanceof DetalhePendenciaBaixa ) {
            DetalhePendenciaBaixa det = (DetalhePendenciaBaixa) o;
            status = this.objeto.equals(det.getObjeto()) &&
                    this.dataCriacao.equals(det.getDataCriacao());
        }
        
        return status;
    }
    
    @Override
    public int hashCode() {
        return this.objeto.hashCode()*13 + this.dataCriacao.hashCode()*7;
    }
    
    @Override
    public String toString() {
        return '{' + this.objeto + ',' + this.dataCriacao + ',' + this.tempo + '}';
    }

    public Date getDatInsercao() {
        return datInsercao;
    }

    public void setDatInsercao(Date datInsercao) {
        this.datInsercao = datInsercao;
    }
    
}
