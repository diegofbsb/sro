/*
 * GerentePendenciaBaixa.java
 *
 * Created on 19 de Outubro de 2006, 10:21
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

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
import br.com.correios.sromonitor.vos.DetalhePendenciaBaixa;
import br.com.correios.sromonitor.vos.PendenciaBaixa2;

/**
 * Facade para PendenciaBaixaDAO.
 * @author jeans
*/
public class GerentePendenciaBaixa2 {
    private PendenciaBaixa2DAO pendenciaBaixaDAO;
    /** Creates a new instance of GerentePendenciaBaixa */
    public GerentePendenciaBaixa2() {
        pendenciaBaixaDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getPendenciaBaixaDAO2();
    }
    
    /**
     * Retorna uma lista de pend&ecirc;ncias.
     * @param dr DR
     * @param reop REOP
     * @param tipoUnidade Tipo de unidade.
     * @return Lista de pend&ecirc;ncias.
     * @throws br.com.correios.sromonitor.managers.ManagementException Caso haja algum problema na obten&ccedil;&atilde;o dos resultados.
     */
    public List<PendenciaBaixa2> getPendencias(String dr, Integer tipoUnidade, String uniName, Date dataInicio, Date dataFinal) throws ManagementException {
        List<PendenciaBaixa2> result = null;
        SimpleDateFormat dateFormatadada = new SimpleDateFormat("ddMMyyyyHHmmss");
                
        String dtInicialPesquisa = dateFormatadada.format(dataInicio);

        String dtFinalPesquisa = dateFormatadada.format(dataFinal);
        String dtInicialPesquisat = dateFormatadada.format(dataInicio);

        try {
        	//Se DR não é nula e os outros dois são nulos
        	if ((dr != null && !dr.equals("") && !dr.equals("0")) && tipoUnidade==0 && (uniName == null || "".equals(uniName))) {
        		try {
        			result = pendenciaBaixaDAO.getPendenciaPorDR(dr, dtInicialPesquisa, dtFinalPesquisa);
        		} catch (DAOException ex) {
        			ex.printStackTrace();
        			throwError();
        		}
        		//Se DR e TipoUnidade não são nulos e nome unidade nulo
        	} else if ((dr != null && !dr.equals("") && !dr.equals("0")) && tipoUnidade > 0 && (uniName == null || "".equals(uniName))){
        		try {
        			result = pendenciaBaixaDAO.getPendenciaPorDRTipo(dr, tipoUnidade, dtInicialPesquisa, dtFinalPesquisa);
        		} catch (DAOException ex) {
        			ex.printStackTrace();
        			throwError();
        		}
        		//Se DR, TipoUnidade e NomeUnidade não são nulos
        	} else if ((dr != null && !dr.equals("") && !dr.equals("0")) && tipoUnidade > 0 && (uniName != null || !"".equals(uniName))){
        		try {
        			result = pendenciaBaixaDAO.getPendenciaPorDRTipoUNidadeNomeUnidade(dr, tipoUnidade, uniName, dtInicialPesquisa, dtFinalPesquisa);
        		} catch (DAOException ex) {
        			ex.printStackTrace();
        			throwError();
        		}
        	} else if ((dr == null || dr.equals("") || dr.equals("0")) && tipoUnidade == 0 && (uniName == null || "".equals(uniName))) {
        		result = pendenciaBaixaDAO.getPendenciaDRs(dtInicialPesquisa, dtFinalPesquisa);
        	} else {
        		try {
        			result = pendenciaBaixaDAO.getPendenciaPorTipoUNidadeNome(dr, tipoUnidade, uniName, dtInicialPesquisa, dtFinalPesquisa);
        		} catch (DAOException ex) {
        			ex.printStackTrace();
        			throwError();
        		}
        	}
        } catch (DAOException ex) {
        	Logger.getLogger(GerentePendenciaBaixa2.class.getName()).log(Level.SEVERE, null, ex);
        }

        if ( result == null || result.isEmpty() || result.size() == 0) {
        	result = Collections.emptyList();
        }

        return result;
    }
    
    private void throwError() throws ManagementException {
        ResourceBundle b = ResourceBundle.getBundle("resources.messages");
        throw new ManagementException(b.getString("db.error"));
    }
    
    public List<DetalhePendenciaBaixa> getDetalhes(String codigoUnidade) throws ManagementException  {
        List<DetalhePendenciaBaixa> result = null;
        try {
            result = pendenciaBaixaDAO.getDetalhe(codigoUnidade);
        } catch (DAOException ex) {
            throwError();
        }
        
        return result;
    }
    
}
