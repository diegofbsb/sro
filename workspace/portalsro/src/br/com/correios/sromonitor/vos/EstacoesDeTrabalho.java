/*
 * PendenciaBaixa.java
 *
 * Created on 28 de Setembro de 2006, 15:18
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.correios.sromonitor.vos;

import java.sql.Date;

import javax.xml.crypto.Data;

/**
 * VO para as pend&ecirc;ncias de baixa.
 * @author jeans
 */
public class EstacoesDeTrabalho implements java.io.Serializable {
    
    private String RD_ACRONYM; 
    private String EST_CO_UNICEP; 
    private String UNI_NAME; 
    private String out_acronym;
    private String EST_NO; 
    private String EST_CO_IP; 
    private String tipoEstacao; 
    private String INS_NU; 
    private String INS_TX_DIRETORIO; 
    private String INS_NO_VERSAO; 
    private Date EST_DH_INSERCAO_SRO;
    private String UNI_CODE;
 
    
    
	
	
	public String getUNI_CODE() {
		return UNI_CODE;
	}
	public void setUNI_CODE(String uNI_CODE) {
		UNI_CODE = uNI_CODE;
	}

	public String getRD_ACRONYM() {
		return RD_ACRONYM;
	}
	public void setRD_ACRONYM(String rD_ACRONYM) {
		RD_ACRONYM = rD_ACRONYM;
	}
	public String getEST_CO_UNICEP() {
		return EST_CO_UNICEP;
	}
	public void setEST_CO_UNICEP(String eST_CO_UNICEP) {
		EST_CO_UNICEP = eST_CO_UNICEP;
	}
	public String getUNI_NAME() {
		return UNI_NAME;
	}
	public void setUNI_NAME(String uNI_NAME) {
		UNI_NAME = uNI_NAME;
	}
	public String getOut_acronym() {
		return out_acronym;
	}
	public void setOut_acronym(String out_acronym) {
		this.out_acronym = out_acronym;
	}
	public String getEST_NO() {
		return EST_NO;
	}
	public void setEST_NO(String eST_NO) {
		EST_NO = eST_NO;
	}
	public String getEST_CO_IP() {
		return EST_CO_IP;
	}
	public void setEST_CO_IP(String eST_CO_IP) {
		EST_CO_IP = eST_CO_IP;
	}
	public String getTipoEstacao() {
		return tipoEstacao;
	}
	public void setTipoEstacao(String tipoEstacao) {
		this.tipoEstacao = tipoEstacao;
	}
	public String getINS_NU() {
		return INS_NU;
	}
	public void setINS_NU(String iNS_NU) {
		INS_NU = iNS_NU;
	}
	public String getINS_TX_DIRETORIO() {
		return INS_TX_DIRETORIO;
	}
	public void setINS_TX_DIRETORIO(String iNS_TX_DIRETORIO) {
		INS_TX_DIRETORIO = iNS_TX_DIRETORIO;
	}
	public String getINS_NO_VERSAO() {
		return INS_NO_VERSAO;
	}
	public void setINS_NO_VERSAO(String iNS_NO_VERSAO) {
		INS_NO_VERSAO = iNS_NO_VERSAO;
	}
	public Date getEST_DH_INSERCAO_SRO() {
		return EST_DH_INSERCAO_SRO;
	}
	public void setEST_DH_INSERCAO_SRO(Date eST_DH_INSERCAO_SRO) {
		EST_DH_INSERCAO_SRO = eST_DH_INSERCAO_SRO;
	}


    
    
    
    
    
    
    
    
}
