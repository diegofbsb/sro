/*
 * GerentePendenciaBaixa.java
 *
 * Created on 19 de Outubro de 2006, 10:21
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
import br.com.correios.sromonitor.dao.PendenciaBaixaDAO;
import br.com.correios.sromonitor.vos.DetalhePendenciaBaixa;
import br.com.correios.sromonitor.vos.PendenciaBaixa;

/**
 * Facade para PendenciaBaixaDAO.
 * @author jeans
 */
public class GerentePendenciaBaixa {
    private PendenciaBaixaDAO pendenciaBaixaDAO;
    /** Creates a new instance of GerentePendenciaBaixa */
    public GerentePendenciaBaixa() {
        pendenciaBaixaDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getPendenciaBaixaDAO();
    }
    
    /**
     * Retorna uma lista de pend&ecirc;ncias.
     * @param dr DR
     * @param reop REOP
     * @param tipoUnidade Tipo de unidade.
     * @return Lista de pend&ecirc;ncias.
     * @throws br.com.correios.sromonitor.managers.ManagementException Caso haja algum problema na obten&ccedil;&atilde;o dos resultados.
     */
    public List<PendenciaBaixa> getPendencias(String dr, Integer reop, String tipoUnidade, String uniName, String tipoDeLista) throws ManagementException {
        List<PendenciaBaixa> result = null;
        
        if ( tipoUnidade != null ) {
            tipoUnidade = tipoUnidade.trim();
        }
        
        

        
        System.out.println("DR: " + dr + ", REOP: " + reop + ", Tipo Unidade: " + tipoUnidade);
        
        if ( dr != null && (reop == null || reop == 0) && (tipoUnidade == null || "".equals(tipoUnidade)) ) {
            try {
                result = pendenciaBaixaDAO.getPendenciaPorDR(dr, uniName, tipoDeLista);
            } catch (DAOException ex) {
                ex.printStackTrace();
                throwError();
            }
                System.out.println("result if 1 "+result + " "+result.size());
        } else if ( dr != null && (reop != null && reop > 0) && (tipoUnidade == null || "".equals(tipoUnidade)) ) {
            try {
                result = pendenciaBaixaDAO.getPendenciaPorDRReop(dr, reop, uniName, tipoDeLista);
            } catch (DAOException ex) {
                ex.printStackTrace();
                throwError();
            }
                System.out.println("result if 2 "+result + " "+result.size());
        } else if ( dr != null && (reop != null && reop > 0) && (tipoUnidade != null || ! "".equals(tipoUnidade)) ) {
            try {
                result = pendenciaBaixaDAO.getPendenciaPorDRReopTipoUNidade(dr, reop, tipoUnidade, uniName,tipoDeLista);
            } catch (DAOException ex) {
                ex.printStackTrace();
                throwError();
            }
                System.out.println("result if 3 "+result + " "+result.size());
        } else if ( dr != null && (reop == null || reop == 0) && (tipoUnidade != null || ! "".equals(tipoUnidade)) ) {
            try {
                result = pendenciaBaixaDAO.getPendenciaPorDRTipoUNidade(dr, tipoUnidade, uniName, tipoDeLista);
            } catch (DAOException ex) {
                ex.printStackTrace();
                throwError();
            }
                System.out.println("result if 4 "+result + " "+result.size());
        } else {
                System.out.println("result if 5 "+result + " "+result.size());
            throw new IllegalArgumentException("DR tem de ser diferente de null.");
        }
        
        if ( result == null ) {
            result = Collections.emptyList();
                System.out.println("result if 6 "+result.size());
        }
        
        return result;
    }
    
    private void throwError() throws ManagementException {
        ResourceBundle b = ResourceBundle.getBundle("resources.messages");
        throw new ManagementException(b.getString("db.error"));
    }
    
    public List<DetalhePendenciaBaixa> getDetalhes(String codigoUnidade,String tipoDeLista) throws ManagementException  {
        List<DetalhePendenciaBaixa> result = null;
        try {
            result = pendenciaBaixaDAO.getDetalhe(codigoUnidade, tipoDeLista);
        } catch (DAOException ex) {
            throwError();
        }
        
        return result;
    }
    
}
