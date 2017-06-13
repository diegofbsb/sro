/*
 * ControleTransmissao.java
 *
 * Created on 8 de Setembro de 2006, 15:22
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.correios.sromonitor.vos;

import java.util.Date;

/**
 * VO para Controle de Transmiss&atilde;o.
 * @author Jean Clay Souza da Silva - Analista POLITEC - DESUN/DSGL
 */
public class ControleTransmissao implements java.io.Serializable {
    
    private String nomeArquivo;
    private Date transmitido;
    private Date gravado;
    private String evento;
    private Integer registros;
    private Integer rejeitados;
    
    /** Creates a new instance of ControleTransmissao */
    public ControleTransmissao() {
    }

    /**
     * Retorna o nome do arquivo.
     * @return Nome do arquivo.
     */
    public String getNomeArquivo() {
        return nomeArquivo;
    }

    /**
     * Define o nome do arquivo.
     * @param nomeArquivo Novo nome do arquivo.
     */
    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    /**
     * Retorna a data de transmiss&atilde;o.
     * @return Data de transmiss&atilde;o.
     */
    public Date getTransmitido() {
        return transmitido;
    }

    /**
     * Define a data de transmiss&atilde;o.
     * @param transmitido Nova data de transmiss&atilde;o.
     */
    public void setTransmitido(Date transmitido) {
        this.transmitido = transmitido;
    }

    /**
     * Retorna a data de grava&ccedil;&atilde;o.
     * @return Data de grava&ccedil;&atilde;o.
     */
    public Date getGravado() {
        return gravado;
    }

    /**
     * Define a data de grava&ccedil;&atilde;o.
     * @param gravado Nova data de grava&ccedil;&atilde;o.
     */
    public void setGravado(Date gravado) {
        this.gravado = gravado;
    }

    /**
     * Retorna o tipo de evento.
     * @return Tipo de evento.
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
     * Retorna a quantidade de registros.
     * @return Quantidade de registros.
     */
    public Integer getRegistros() {
        return registros;
    }

    /**
     * Define a quantidade de registros.
     * @param registros Nova quantidade de registros.
     */
    public void setRegistros(Integer registros) {
        this.registros = registros;
    }

    /**
     * Retorna a quantidade de registros rejeitados.
     * @return Quantidade de registros rejeitados.
     */
    public Integer getRejeitados() {
        return rejeitados;
    }

    /**
     * Define a quantidade de registros rejeitados.
     * @param rejeitados Nova quantidade de registros rejeitados.
     */
    public void setRejeitados(Integer rejeitados) {
        this.rejeitados = rejeitados;
    }
    
}
