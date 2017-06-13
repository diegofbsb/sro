package br.com.correios.sromonitor.managers;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.correios.sromonitor.dao.DAOException;
import br.com.correios.sromonitor.dao.DAOFactory;
import br.com.correios.sromonitor.dao.PendenciaBaixa2DAO;
import br.com.correios.sromonitor.vos.PendenciaBaixaDiaria;

/**
 * Facade para o relatório diário de pendências de baixa.
 * 
 * @author Paulo Henrique Mendes
 */
public class GerentePendenciaBaixaDiaria {

	private PendenciaBaixa2DAO pendenciaBaixa2DAO;

	public GerentePendenciaBaixaDiaria() {
		pendenciaBaixa2DAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getPendenciaBaixaDAO2();
	}

	public List<PendenciaBaixaDiaria> getPendenciaDiaria(Date hoje) throws ManagementException {
		List<PendenciaBaixaDiaria> result = null;
		
		try {
			result = pendenciaBaixa2DAO.getPendenciaDiaria(new SimpleDateFormat("ddMMyyyyHHmmss").format(hoje));
		} catch (DAOException e) {
			Logger.getLogger(GerentePendenciaBaixaDiaria.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
			throwError();
		}
		
		if (result == null || result.isEmpty() || result.size() == 0) {
			result = Collections.emptyList();
		}

		return result;
	}

	private void throwError() throws ManagementException {
		ResourceBundle b = ResourceBundle.getBundle("resources.messages");
		throw new ManagementException(b.getString("db.error"));
	}

}
