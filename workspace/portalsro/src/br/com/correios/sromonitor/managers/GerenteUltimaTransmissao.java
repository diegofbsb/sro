/*
 * GerenteUltimaTransmissao.java
 *
 * Created on 31 de Agosto de 2006, 18:16
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.correios.sromonitor.managers;

import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import br.com.correios.sromonitor.dao.DAOException;
import br.com.correios.sromonitor.dao.DAOFactory;
import br.com.correios.sromonitor.dao.UltimaTransmissaoDAO;
import br.com.correios.sromonitor.vos.Transmissao;

/**
 * Facade para UltimaTransmissaoDAO.
 * @author Jean Clay Souza da Silva - Analista POLITEC - DESUN/DSGL
 */
public class GerenteUltimaTransmissao {
    private UltimaTransmissaoDAO utd;
    /** Creates a new instance of GerenteUltimaTransmissao */
    public GerenteUltimaTransmissao() {
        utd = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getUltimaTransmissaoDAO();
    }
    
    /**
     * Retorna uma lista contendo a &uacute;ltima transmiss&atilde;o de cada unidade.
     * @param dr DR
     * @param reop REOP
     * @param tipoUnidade Tipo de unidade.
     * @return Lista contendo a &uacute;ltima transmiss&atilde;o de cada unidade.
     * @throws br.com.correios.sromonitor.managers.ManagementException Caso haja algum problema na obten&ccedil;&atilde;o dos resultados.
     */
    public List<Transmissao> getUltimaTransmissao(String dr, Integer reop, String tipoUnidade) throws ManagementException {
        List<Transmissao> result = null;
        
        if ( tipoUnidade != null ) {
            tipoUnidade = tipoUnidade.trim();
        }
        
        System.out.println("DR: " + dr + ", REOP: " + reop + ", Tipo Unidade: " + tipoUnidade);
        
        if ( dr != null && (reop == null || reop == 0) && (tipoUnidade == null || "".equals(tipoUnidade)) ) {
            try {
                result = utd.getUltimaTransmissaoPorDR(dr);
            } catch (DAOException ex) {
                ex.printStackTrace();
                throwError();
            }
        } else if ( dr != null && (reop != null && reop > 0) && (tipoUnidade == null || "".equals(tipoUnidade)) ) {
            try {
                result = utd.getUltimaTransmissaoPorDRReop(dr, reop);
            } catch (DAOException ex) {
                ex.printStackTrace();
                throwError();
            }
        } else if ( dr != null && (reop != null && reop > 0) && (tipoUnidade != null || ! "".equals(tipoUnidade)) ) {
            try {
                result = utd.getUltimaTransmissaoPorDRReopTipoUNidade(dr, reop, tipoUnidade);
            } catch (DAOException ex) {
                ex.printStackTrace();
                throwError();
            }
        } else if ( dr != null && (reop == null || reop == 0) && (tipoUnidade != null || ! "".equals(tipoUnidade)) ) {
            try {
                result = utd.getUltimaTransmissaoPorDRTipoUNidade(dr, tipoUnidade);
            } catch (DAOException ex) {
                ex.printStackTrace();
                throwError();
            }
        } else {
            throw new IllegalArgumentException("DR tem de ser diferente de null.");
        }
        
        if ( result == null ) {
            result = Collections.emptyList();
        }
        
        return result;
    }
    
    private void throwError() throws ManagementException {
        ResourceBundle b = ResourceBundle.getBundle("resources.messages");
        throw new ManagementException(b.getString("db.error"));
    }
    
}
