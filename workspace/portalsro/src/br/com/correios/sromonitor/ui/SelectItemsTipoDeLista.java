/*
 * SelectItemsDR.java
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
 * @author wmt
 */
public class SelectItemsTipoDeLista {

    private final Map<String, String> mapSiglas;
    private final Map<String, String> mapNomes;

    private final Map<String, String> mapSiglas1;
    private final Map<String, String> mapNomes1;

	private final String[] nomes = { "LOEC",
			"LDI"
			};

	private final String[] nomes1 = {"",
			"LOEC",
			"LDI" };

    private final String[] codigos = {"OEC","LDI"};

    private final String[] codigos1 = {"0","OEC","LDI"};

    private final String[] siglas = {"LOEC","LDI"};

    private final String[] siglas1 = {"TODAS","LOEC","LDI"};

    private final SelectItem[] tipoDeListas = new SelectItem[codigos.length];
    private final SelectItem[] tipoDeListas1 = new SelectItem[codigos1.length];

    /** Creates a new instance of SelectItemsDR */
    public SelectItemsTipoDeLista() {
        mapSiglas = new HashMap<String, String>();
        mapNomes = new HashMap<String, String>();

        mapSiglas1 = new HashMap<String, String>();
        mapNomes1 = new HashMap<String, String>();

        for (int i = 0; i < codigos.length; i++) {
            mapSiglas.put(codigos[i], siglas[i]);
            mapNomes.put(codigos[i], nomes[i]);
            tipoDeListas[i] = new SelectItem(codigos[i], siglas[i]);
        }

        for (int i = 0; i < codigos1.length; i++) {
            mapSiglas.put(codigos1[i], siglas1[i]);
            mapNomes.put(codigos1[i], nomes1[i]);
            tipoDeListas1[i] = new SelectItem(codigos1[i], siglas1[i]);

        }
    }

    /**
     * Retorna um array de <CODE>javax.faces.model.SelectItem</CODE> contendo todas as DRs.
     * @return Array de <CODE>javax.faces.model.SelectItem</CODE> contendo todas as DRs.
     */
    public SelectItem[] getTipoDeListas() {
        return tipoDeListas;
    }

    public Map<String, String> getMapSiglas() {
        return mapSiglas;
    }

    public Map<String, String> getMapNomes() {
        return mapNomes;
    }

    /**
     * Retorna um array de <CODE>javax.faces.model.SelectItem</CODE> contendo todas as DRs.
     * @return Array de <CODE>javax.faces.model.SelectItem</CODE> contendo todas as DRs.
     */
    public SelectItem[] getTipoDeListas1() {
        return tipoDeListas1;
    }

    public Map<String, String> getMapSiglas1() {
        return mapSiglas1;
    }

    public Map<String, String> getMapNomes1() {
        return mapNomes1;
    }

}