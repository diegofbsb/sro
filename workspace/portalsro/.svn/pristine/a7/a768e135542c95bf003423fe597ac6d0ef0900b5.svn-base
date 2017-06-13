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
 * @author Jean Clay Souza da Silva - Analista POLITEC - DESUN/DSGL
 */
public class SelectItemsDR {

    private final Map<String, String> mapSiglas;
    private final Map<String, String> mapNomes;

    private final Map<String, String> mapSiglas1;
    private final Map<String, String> mapNomes1;

	private final String[] nomes = { "ADMINISTRAÇÃO CENTRAL",
			"DIRETORIA REGIONAL DO ACRE",
			"DIRETORIA REGIONAL DE ALAGOAS",
			"DIRETORIA REGIONAL DO AMAZONAS",
			"DIRETORIA REGIONAL DO AMAPÁ",
			"DIRETORIA REGIONAL DA BAHIA",
			"DIRETORIA REGIONAL DE BRASILIA",
			"DIRETORIA REGIONAL DO CEARA",
			"DIRETORIA REGIONAL DO ESPIRITO SANTO",
			"DIRETORIA REGIONAL EXTERIOR",
			"DIRETORIA REGIONAL DE GOIAS",
			"DIRETORIA REGIONAL DO MARANHAO",
			"DIRETORIA REGIONAL DE MINAS GERAIS",
			"DIRETORIA REGIONAL DE MATO GROSSO DO SUL",
			"DIRETORIA REGIONAL DE MATO GROSSO",
			"DIRETORIA REGIONAL DO PARA",
			"DIRETORIA REGIONAL DA PARAIBA",
			"DIRETORIA REGIONAL DE PERNAMBUCO",
			"DIRETORIA REGIONAL DO PIAUI",
			"DIRETORIA REGIONAL DO PARANA",
			"DIRETORIA REGIONAL DO RIO DE JANEIRO",
			"DIRETORIA REGIONAL DO R. GRANDE DO NORTE",
			"DIRETORIA REGIONAL DE RONDONIA",
			"DIRETORIA REGIONAL DE RORAIMA",
			"DIRETORIA REGIONAL DO RIO GRANDE DO SUL",
			"DIRETORIA REGIONAL DE SANTA CATARINA",
			"DIRETORIA REGIONAL DE SERGIPE",
			"DIRETORIA REGIONAL DE SP INTERIOR",
			"DIRETORIA REGIONAL DE SP METROPOLITANA",
			"DIRETORIA REGIONAL DE TOCANTINS"};
	

	
	
	

	
			

	private final String[] nomes1 = {"",
			"ADMINISTRAÇÃO CENTRAL",
			"DIRETORIA REGIONAL DO ACRE",
			"DIRETORIA REGIONAL DE ALAGOAS",
			"DIRETORIA REGIONAL DO AMAZONAS",
			"DIRETORIA REGIONAL DO AMAPÁ",
			"DIRETORIA REGIONAL DA BAHIA",
			"DIRETORIA REGIONAL DE BRASILIA",
			"DIRETORIA REGIONAL DO CEARA",
			"DIRETORIA REGIONAL DO ESPIRITO SANTO",
			"DIRETORIA REGIONAL EXTERIOR",
			"DIRETORIA REGIONAL DE GOIAS",
			"DIRETORIA REGIONAL DO MARANHAO",
			"DIRETORIA REGIONAL DE MINAS GERAIS",
			"DIRETORIA REGIONAL DE MATO GROSSO DO SUL",
			"DIRETORIA REGIONAL DE MATO GROSSO",
			"DIRETORIA REGIONAL DO PARA",
			"DIRETORIA REGIONAL DA PARAIBA",
			"DIRETORIA REGIONAL DE PERNAMBUCO",
			"DIRETORIA REGIONAL DO PIAUI",
			"DIRETORIA REGIONAL DO PARANA",
			"DIRETORIA REGIONAL DO RIO DE JANEIRO",
			"DIRETORIA REGIONAL DO R. GRANDE DO NORTE",
			"DIRETORIA REGIONAL DE RONDONIA",
			"DIRETORIA REGIONAL DE RORAIMA",
			"DIRETORIA REGIONAL DO RIO GRANDE DO SUL",
			"DIRETORIA REGIONAL DE SANTA CATARINA",
			"DIRETORIA REGIONAL DE SERGIPE",
			"DIRETORIA REGIONAL DE SP INTERIOR",
			"DIRETORIA REGIONAL DE SP METROPOLITANA",
			"DIRETORIA REGIONAL DE TOCANTINS" };
	
		

	
	private final String[] codigos = {"01","03","04","06","05","08","10","12","14","99","16","18","20","22","24","28","30","32","34","36","50","60","26","65","64","68","70","74","72","75"};

    private final String[] codigos1 = {"0","01","03","04","06","05","08","10","12","14","99","16","18","20","22","24","28","30","32","34","36","50","60","26","65","64","68","70","74","72","75"};
    
    private final String[] siglas = {"AC","ACR","AL","AM","AP","BA","BSB","CE","ES","EXT","GO","MA","MG","MS","MT","PA","PB","PE","PI","PR","RJ","RN","RO","RR","RS","SC","SE","SPI","SPM","TO"};

    private final String[] siglas1 = {"TODAS","AC","ACR","AL","AM","AP","BA","BSB","CE","ES","EXT","GO","MA","MG","MS","MT","PA","PB","PE","PI","PR","RJ","RN","RO","RR","RS","SC","SE","SPI","SPM","TO",};

    private final SelectItem[] drs = new SelectItem[codigos.length];
    private final SelectItem[] drs1 = new SelectItem[codigos1.length];

    /** Creates a new instance of SelectItemsDR */
    public SelectItemsDR() {
        mapSiglas = new HashMap<String, String>();
        mapNomes = new HashMap<String, String>();

        mapSiglas1 = new HashMap<String, String>();
        mapNomes1 = new HashMap<String, String>();

        for (int i = 0; i < codigos.length; i++) {
            mapSiglas.put(codigos[i], siglas[i]);
            mapNomes.put(codigos[i], nomes[i]);
            drs[i] = new SelectItem(codigos[i], siglas[i]);
        }

        for (int i = 0; i < codigos1.length; i++) {
            mapSiglas.put(codigos1[i], siglas1[i]);
            mapNomes.put(codigos1[i], nomes1[i]);
            drs1[i] = new SelectItem(codigos1[i], siglas1[i]);

        }
    }

    /**
     * Retorna um array de <CODE>javax.faces.model.SelectItem</CODE> contendo todas as DRs.
     * @return Array de <CODE>javax.faces.model.SelectItem</CODE> contendo todas as DRs.
     */
    public SelectItem[] getDrs() {
        return drs;
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
    public SelectItem[] getDrs1() {
        return drs1;
    }

    public Map<String, String> getMapSiglas1() {
        return mapSiglas1;
    }

    public Map<String, String> getMapNomes1() {
        return mapNomes1;
    }

}


