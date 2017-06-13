/*
 * PendenciaBaixa2.java
 *
 * Created on 21 de Janeiro de 2011, 10:18
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.correios.sromonitor.vos;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * VO para as pend&ecirc;ncias de baixa.
 * @author Avila
 */
public class PendenciaBaixa2 implements java.io.Serializable {
	
	private static final long serialVersionUID = -2524208103120788256L;
	
	private String codigo;
    private String siglaDr;
    private String nome;
    private String nomePesquisa;
    private String codigoSro;
    private String codigoMCMCU;
    private String tipoUnidade;
    private String lancado;
    private String baixado;
    private Date dataInicio;
    private Date dataFinal;
    private String dataPesquisada;
    private String percentualBaixado;
    private DecimalFormat df = new DecimalFormat("0.00");
   
    /** Creates a new instance of PendenciaBaixa */
    public PendenciaBaixa2() {
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
        setNomePesquisa(nome);
        this.nome = nome;
    }

    /**
     * @return the dataInicio
     */
    public Date getDataInicio() {
        return dataInicio;
    }

    /**
     * @param dataInicio the dataInicio to set
     */
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * @return the dataFinal
     */
    public Date getDataFinal() {
        return dataFinal;
    }

    /**
     * @param dataFinal the dataFinal to set
     */
    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    /**
     * @return the lancado
     */
    public String getLancado() {
        return lancado;
    }

    /**
     * @param lancado the lancado to set
     */
    public void setLancado(String lancado) {
        this.lancado = lancado;
    }

    /**
     * @return the pendente
     */
    public String getBaixado() {
        return baixado;
    }

    /**
     * @param baixado the baixado to set
     */
    public void setBaixado(String baixado) {
        this.baixado = baixado;
    }

    /**
     * @return the codigoSro
     */
    public String getCodigoSro() {
        return codigoSro;
    }

    /**
     * @param codigoSro the codigoSro to set
     */
    public void setCodigoSro(String codigoSro) {
        this.codigoSro = codigoSro;
    }

    /**
     * @return the tipoUnidade
     */
    public String getTipoUnidade() {
        return tipoUnidade;
    }

    /**
     * @param tipoUnidade the tipoUnidade to set
     */
    public void setTipoUnidade(String tipoUnidade) {
        this.tipoUnidade = tipoUnidade;
    }

    /**
     * @return the dataPesquisada
     */
    public String getDataPesquisada() {
        return dataPesquisada;
    }

    /**
     * @param dataPesquisada the dataPesquisada to set
     */
    public void setDataPesquisada(Date dataPesquisada) {

        SimpleDateFormat dateFormatadada = new SimpleDateFormat("dd-MM-yyyy");
        this.dataPesquisada = dateFormatadada.format(dataPesquisada);
    }

    /**
     * @return the percentualBaixado
     */
    public String getPercentualBaixado() {
        return percentualBaixado;
    }

    /**
     * @param percentualBaixado the percentualBaixado to set
     */
    public void setPercentualBaixado(String percentualBaixado) {
        this.percentualBaixado = percentualBaixado;
    }

     /**
     *
     * @param baixado
     * @param lancado
     * @throws br.com.correios.sromonitor.vos.PendenciaBaixa2
     * @return
     */
    public void calculaPercentualBaixado() {
        double baix = Double.parseDouble(baixado);
        double lanc = Double.parseDouble(lancado);
        double perc = 100;
                
        if (lanc > 0) {
            perc = (100 * baix) / lanc;
        }
        
        setPercentualBaixado(df.format(perc));
    }

    /**
     * @return the nomePesquisa
     */
    public String getNomePesquisa() {
        return nomePesquisa;
    }

    /**
     * @param nomePesquisa the nomePesquisa to set
     */
    public void setNomePesquisa(String nomePesquisa) {

        this.nomePesquisa = nomePesquisa+"%";
    }

    /**
     * @return the siglaDr
     */
    public String getSiglaDr() {
        return siglaDr;
    }

    /**
     * @param siglaDr the siglaDr to set
     */
    public void setSiglaDr(String siglaDr) {
        this.siglaDr = siglaDr;
    }
    
    /**
     * @param codigoMCMCU the codigoMCMCU to set
     */
    public void setCodigoMCMCU(String codigoMCMCU) {
		this.codigoMCMCU = codigoMCMCU;
	}
    
    /**
     * @return the codigoMCMCU
     */
	public String getCodigoMCMCU() {
		return codigoMCMCU;
	}

	

  
}
