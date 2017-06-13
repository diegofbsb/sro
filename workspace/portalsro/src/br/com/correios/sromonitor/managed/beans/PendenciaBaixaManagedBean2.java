/*
 * PendenciaBaixaManagedBean.java
 *
 * Created on 26 de Setembro de 2006, 11:18
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.correios.sromonitor.managed.beans;

import java.text.Collator;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.correios.sromonitor.managers.GerentePendenciaBaixa2;
import br.com.correios.sromonitor.managers.ManagementException;
import br.com.correios.sromonitor.util.Calendario;
import br.com.correios.sromonitor.vos.PendenciaBaixa2;

/**
 * ManagedBean para a pend&ecirc;ncia de baixa.
 * @author Jean Clay Souza da Silva - Analista POLITEC - DESUN/DSGL
 */
public class PendenciaBaixaManagedBean2  extends MonitorManagedBean {
    
    private String codigoUnidade;
    private List<PendenciaBaixa2> transmissoes;
    private GerentePendenciaBaixa2 gerente;
    private String uniName;
    private Date startDate;
    private Date endDate;
    private String dtInicialMostrarTela = "";
    private String dtFinalMostrarTela = "";
    private static boolean drMostra = false;
    static boolean nomeUniMostra = false;
    private int numeroObjLancados = 0;
    private int numeroObjbaixados = 0;
    private String codigodr = "";
    
        
    
    /**
     * Creates a new instance of PendenciaBaixaManagedBean
     */
    public PendenciaBaixaManagedBean2() {
        
        gerente = new GerentePendenciaBaixa2();
        
        /*
        transmissoes = new ArrayList<PendenciaBaixa>();
        PendenciaBaixa p = new PendenciaBaixa();
        p.setCodigo("88888888");
        p.setNome("Unidade Inexistente");
        p.setQuantidade(3);
        transmissoes.add(p);
         
        p = new PendenciaBaixa();
        p.setCodigo("0000000");
        p.setNome("Unidade Ficticia");
        p.setQuantidade(5);
        transmissoes.add(p);
         
        p = new PendenciaBaixa();
        p.setCodigo("11111111");
        p.setNome("Unidade de Teste");
        p.setQuantidade(50);
        transmissoes.add(p);
         
        p = new PendenciaBaixa();
        p.setCodigo("9999999");
        p.setNome("Unidade Desconhecida");
        p.setQuantidade(100);
        transmissoes.add(p);
         
        p = new PendenciaBaixa();
        p.setCodigo("77777777");
        p.setNome("Unidade Extraterrestre");
        p.setQuantidade(1000);
        transmissoes.add(p);
         */
    }
    

    /**
     * C&oacute;digo da unidade.
     * @return C&oacute;digo da unidade.
     */
    public String getCodigoUnidade() {
        return codigoUnidade;
    }
    
    /**
     * C&oacute;digo da unidade.
     * @param codigoUnidade C&oacute;digo da unidade.
     */
    public void setCodigoUnidade(String codigoUnidade) {
        this.codigoUnidade = codigoUnidade;
    }

   

   
    /**
     *
     * @return
     */
    public String pesquisar() {

        SimpleDateFormat dateFormatadada = new SimpleDateFormat("EEEE, dd 'de' MMMM 'de' yyyy");
        setDtInicialMostrarTela(dateFormatadada.format(startDate));
        setDtFinalMostrarTela(dateFormatadada.format(endDate));
        PendenciaBaixa2 pendencia = null;
        numeroObjLancados = 0;
        numeroObjbaixados = 0;

        if ( getDr() != null ) {
            try {
                transmissoes = gerente.getPendencias(getDr(), getTipoUnidadeInt(), getUniName(),getStartDate(), getEndDate());
                if ( transmissoes == null || transmissoes.size() == 0 ) {
                    setRendered(false);
                    ResourceBundle b = ResourceBundle.getBundle("resources.messages");
                    setMessage(b.getString("no.result"), FacesMessage.SEVERITY_INFO);
                } else {
                    Collections.sort(transmissoes, new ComparaQuantidadeNome());
                    for(int i = 0 ; i < transmissoes.size(); i++){
                        pendencia = transmissoes.get(i);
                        setNumeroObjLancados(Integer.parseInt(pendencia.getLancado()));
                        setNumeroObjbaixados(Integer.parseInt(pendencia.getBaixado()));
                    }

                    setRendered(true);
                }
                return AbstractManagedBean.SUCCESS;
            } catch (ManagementException ex) {
                this.setMessage(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
                ex.printStackTrace();
            }
        }
        return AbstractManagedBean.ERROR;
    }

    

    
    /**
     *
     * @return
     */
    public List<PendenciaBaixa2> getTransmissoes() {
        return transmissoes;
    }
    
    public String detalhe() {
        DetalhePendenciaBaixaManagedBean detalhePendencia =
                (DetalhePendenciaBaixaManagedBean) getBean("detalhePendencia");
        
        
        return "detail";
    }

    /**
     * @return the dataInicio
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param dataInicio the dataInicio to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the dataFinal
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param dataFinal the dataFinal to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the dtMostrarTela
     */
    public String getDtInicialMostrarTela() {
        return dtInicialMostrarTela;
    }

    /**
     * @param dtMostrarTela the dtMostrarTela to set
     */
    public void setDtInicialMostrarTela(String dtMostrarTela) {
        this.dtInicialMostrarTela = dtMostrarTela;
    }

    /**
     * @return the dtFinalMostrarTela
     */
    public String getDtFinalMostrarTela() {
        return dtFinalMostrarTela;
    }

    /**
     * @param dtFinalMostrarTela the dtFinalMostrarTela to set
     */
    public void setDtFinalMostrarTela(String dtFinalMostrarTela) {
        this.dtFinalMostrarTela = dtFinalMostrarTela;
    }

    /**
     * @return the numeroObjLancados
     */
    public int getNumeroObjLancados() {
        return numeroObjLancados;
    }

    /**
     * @param numeroObjLancados the numeroObjLancados to set
     */
    public void setNumeroObjLancados(int numeroObjLancados) {
        this.numeroObjLancados = this.numeroObjLancados + numeroObjLancados;
    }

    /**
     * @return the numeroObjpendentes
     */
    public int getNumeroObjbaixados() {
        return numeroObjbaixados;
    }

    /**
     * @param numeroObjbaixados the numeroObjpendentes to set
     */
    public void setNumeroObjbaixados(int numeroObjbaixados) {
        this.numeroObjbaixados = this.numeroObjbaixados + numeroObjbaixados;
    }

      /**
     * @return the codigodr
     */
    public String getCodigodr() {
        return codigodr;
    }

    /**
     * @param codigodr the codigodr to set
     */
    public void setCodigodr(String codigodr) {
        
        this.codigodr = codigodr;
    }
    
    private class ComparaQuantidadeNome implements Comparator<PendenciaBaixa2> {
        
        public int compare(PendenciaBaixa2 o1, PendenciaBaixa2 o2) {
            
            
            Collator c = Collator.getInstance(
                    FacesContext.getCurrentInstance()
                    .getApplication().getDefaultLocale());
            
            return c.compare(o1.getCodigo(), o2.getCodigo());
        }
        
    }

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

        /**
     * @return the drMostra
     */
    public boolean isDrMostra() {
        return drMostra;
    }

    /**
     * @param drMostra the drMostra to set
     */
    public static void setDrMostra(boolean drMostra) {
        PendenciaBaixaManagedBean2.drMostra = drMostra;
    }

    /**
     * @return the nomeUniMostra
     */
    public boolean isNomeUniMostra() {
        return nomeUniMostra;
    }

    /**
     * @param nomeUniMostra the nomeUniMostra to set
     */
    public static void setNomeUniMostra(boolean nomeUniMostra) {
        PendenciaBaixaManagedBean2.nomeUniMostra = nomeUniMostra;
    }
    
    public String buscaDataHora(){
    
        return " Data: "+Calendario.obterDataAtual()+ " Hora: "+Calendario.obterHoraAtual();
    
    }


    
}
