/*
 * MonitorManagedBean.java
 *
 * Created on 13 de Novembro de 2006, 08:58
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.correios.sromonitor.managed.beans;

/**
 *
 * @author jeans
 */
public abstract class MonitorManagedBean extends AbstractManagedBean {
    
    private String dr;
    private Integer reop;
    private String tipoUnidade;
    private Integer tipoUnidadeInt;
    private String uniName;
    private String uniVersao;
    private String tipoEstacao;
    
    /** Creates a new instance of MonitorManagedBean */
    public MonitorManagedBean() {
    }

    public String getDr() {
        return dr;
    }

    public void setDr(String dr) {
        this.dr = dr;
    }

    public Integer getReop() {
        return reop;
    }

    public void setReop(Integer reop) {
        this.reop = reop;
    }

    public String getTipoUnidade() {
        return tipoUnidade;
    }

    public void setTipoUnidade(String tipoUnidade) {
        if ( tipoUnidade != null ) {
            this.tipoUnidade = tipoUnidade.toUpperCase();
        }
    }
    
    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }
    
    public String getUniVersao() {
    	return uniVersao;
    }
    
    public void setUniVersao(String uniVersao){
    	this.uniVersao = uniVersao;
    }
    
    public String getTipoEstacao(){
    	return tipoEstacao;
    }
    
    public void setTipoEstacao(String tipoEstacao){
    	this.tipoEstacao = tipoEstacao;
    }

    /**
     * @return the tipoUnidadeInt
     */
    public Integer getTipoUnidadeInt() {
        return tipoUnidadeInt;
    }

    /**
     * @param tipoUnidadeInt the tipoUnidadeInt to set
     */
    public void setTipoUnidadeInt(Integer tipoUnidadeInt) {
        this.tipoUnidadeInt = tipoUnidadeInt;
    }
}
