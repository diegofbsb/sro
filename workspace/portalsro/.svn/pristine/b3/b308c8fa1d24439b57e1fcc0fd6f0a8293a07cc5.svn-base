package br.com.correios.sromonitor.ui;

import java.util.HashMap;
import java.util.Map;

import javax.faces.model.SelectItem;

public class SelectItemsTipoEstacao {
	private final String[] value = {"1", "6"};
	private final String[] title = {"Concentrador", "Operacional"};
	private final SelectItem[] estacoesLista = new SelectItem[value.length];
	private Map<String, String> mapNome;
	
	public SelectItemsTipoEstacao(){
		

		for(int i=0; i < value.length; i++) {
			mapNome = new HashMap<String, String>();
			mapNome.put(value[i], title[i]);

			estacoesLista[i] = new SelectItem(value[i], title[i]);
		}
	}

	public SelectItem[] getEstacoesLista() {
		return estacoesLista;
	}
	
	public Map<String, String> getMapNome() {
		return mapNome;
	}
}
