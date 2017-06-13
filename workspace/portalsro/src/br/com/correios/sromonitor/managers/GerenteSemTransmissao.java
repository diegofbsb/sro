/*
 * GerenteSemTransmissao.java
 *
 * Created on 6 de Setembro de 2006, 09:51
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
import br.com.correios.sromonitor.dao.SemTransmissaoDAO;
import br.com.correios.sromonitor.vos.Transmissao;

/**
 * Facade para SemTransmissaoDAO.
 * @author Jean Clay Souza da Silva - Analista POLITEC - DESUN/DSGL
 */
public class GerenteSemTransmissao {
    private SemTransmissaoDAO std;
    /** Creates a new instance of GerenteSemTransmissao */
    public GerenteSemTransmissao() {
        std = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getSemTransmissaoDAO();
    }
    
    /**
     * Retorna uma lista de unidades que n&atilde;o est&atilde; transmitindo.
     * @param dr DR
     * @param reop REOP
     * @param tipoUnidade Tipo de unidade.
     * @return Lista de unidades que n&atilde;o est&atilde; transmitindo.
     * @throws br.com.correios.sromonitor.managers.ManagementException Caso haja algum problema na obten&ccedil;&atilde;o dos resultados.
     */
    public List<Transmissao> getSemTransmissao(String dr, Integer reop, String tipoUnidade) throws ManagementException {
        List<Transmissao> result = null;
        
        if ( tipoUnidade != null ) {
            tipoUnidade = tipoUnidade.trim();
        }
        
        System.out.println("DR: " + dr + ", REOP: " + reop + ", Tipo Unidade: " + tipoUnidade);
        
        if ( dr != null && (reop == null || reop == 0) && (tipoUnidade == null || "".equals(tipoUnidade)) ) {
            try {
                result = std.getSemTransmissaoPorDR(dr);
            } catch (DAOException ex) {
                throwError();
            }
        } else if ( dr != null && (reop != null && reop > 0) && (tipoUnidade == null || "".equals(tipoUnidade)) ) {
            try {
                result = std.getSemTransmissaoPorDRReop(dr, reop);
            } catch (DAOException ex) {
                throwError();
            }
        } else if ( dr != null && (reop != null && reop > 0) && (tipoUnidade != null || ! "".equals(tipoUnidade)) ) {
            try {
                result = std.getSemTransmissaoPorDRReopTipoUNidade(dr, reop, tipoUnidade);
            } catch (DAOException ex) {
                throwError();
            }
        } else if ( dr != null && (reop == null || reop == 0) && (tipoUnidade != null || ! "".equals(tipoUnidade)) ) {
            try {
                result = std.getSemTransmissaoPorDRTipoUNidade(dr, tipoUnidade);
            } catch (DAOException ex) {
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
