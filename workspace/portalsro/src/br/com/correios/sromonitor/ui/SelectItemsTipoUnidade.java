/*
 * SelectItemsTipoUnidade.java
 *
 * Created on 30 de Agosto de 2006, 16:20
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.correios.sromonitor.ui;

import java.util.HashMap;
import java.util.Map;

import javax.faces.model.SelectItem;

/**
 * Define um array de <CODE>javax.faces.model.SelectItem</CODE> contendo todas as DRs<br/>
 * para evitar a busca desta informa&ccedil;&atilde;o no banco de dados.
 * @author Jean Clay Souza da Silva - Analista POLITEC - DESUN/DSGL
 */
public class SelectItemsTipoUnidade {
    
    private final Map<Integer, String> mapSiglas;
    private final Map<Integer, String> mapNomes;
    
    private final String[] nomes = {"TODAS","Agência de Correios","Centro de Distribuição Domiciliar","Centro de Entrega de Encomendas", "Unidade de Distribuição", "Unidade Virtual","Cetro de Tratamento de Encomendas","Cetro de Tratamento de Cartas e Encomendas"};
    
    private final Integer[] codigos = {0,9,4,28,32,80,37,27};
    
    private final String[] siglas = {"TODAS","ACs","CDDs","CEEs","UDs","UVTs","CTEs","CTCEs"};
    
    private final SelectItem[] tipoUnidade = new SelectItem[codigos.length];
    /** Creates a new instance of SelectItemsDR */
    public SelectItemsTipoUnidade() {
        mapSiglas = new HashMap<Integer, String>();
        mapNomes = new HashMap<Integer, String>();
        
        for (int i = 0; i < codigos.length; i++) {
            mapSiglas.put(codigos[i], siglas[i]);
            mapNomes.put(codigos[i], nomes[i]);
            tipoUnidade[i] = new SelectItem(codigos[i], siglas[i]);
        }
    }

    /**
     * Retorna um array de <CODE>javax.faces.model.SelectItem</CODE> contendo todas as DRs.
     * @return Array de <CODE>javax.faces.model.SelectItem</CODE> contendo todas as DRs.
     */
    public SelectItem[] getTipoUnidade() {
        return tipoUnidade;
    }

    public Map<Integer, String> getMapSiglas() {
        return mapSiglas;
    }

    public Map<Integer, String> getMapNomes() {
        return mapNomes;
    }
    
}