/*
 * GerenteControleTransmissao.java
 *
 * Created on 8 de Setembro de 2006, 17:01
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.correios.sromonitor.managers;

import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import br.com.correios.sromonitor.dao.ControleTransmissaoDAO;
import br.com.correios.sromonitor.dao.DAOException;
import br.com.correios.sromonitor.dao.DAOFactory;
import br.com.correios.sromonitor.vos.ControleTransmissao;

/**
 * Facade para o DAO de controle de transmiss&atilde;o.
 * @author Jean Clay Souza da Silva - Analista POLITEC - DESUN/DSGL
 */
public class GerenteControleTransmissao {
    private ControleTransmissaoDAO controleDAO;
    /** Creates a new instance of GerenteControleTransmissao */
    public GerenteControleTransmissao() {
        controleDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getControleTransmissaoDAO();
    }
    
    /**
     * Retorna uma lista de <CODE>br.com.correios.sromonitor.vos.ControleTransmissao</CODE>.
     * @param codigoUnidade C&oacute;digo da unidade.
     * @param startDate Data inicial.
     * @param endDate Data final.
     * @return Uma lista de <CODE>br.com.correios.sromonitor.vos.ControleTransmissao</CODE>.
     * @throws br.com.correios.sromonitor.managers.ManagementException Caso haja algum problema na obten&ccedil;&atilde;o dos resultados.
     */
    public List<ControleTransmissao> getTransmissoes(String codigoUnidade, Date startDate, Date endDate) throws ManagementException {
        List<ControleTransmissao> result = null;
        try {
              result = controleDAO.getTransmissoes(codigoUnidade, startDate, endDate);
        } catch (DAOException ex) {
            //result = Collections.emptyList();
            //ex.printStackTrace();
            ResourceBundle b = ResourceBundle.getBundle("resources.messages");
            throw new ManagementException(b.getString("db.error"));
        }
        return result;
    }
    
    public String getNomeUnidade(String codigoUnidade) throws ManagementException {
        String nomeUnidade = null;
        ResourceBundle b = ResourceBundle.getBundle("resources.messages");
        
        if ( codigoUnidade == null || "".equals(codigoUnidade.trim())) {
            throw new ManagementException(b.getString("not.null"));
        }
        
        try {
            
            nomeUnidade = controleDAO.getNomeUnidade(codigoUnidade);
        } catch (DAOException ex) {
            ex.printStackTrace();
            throw new ManagementException(b.getString("db.error"));
        }
        
        return nomeUnidade;
    }
    
}
