/*
 * PendenciaBaixaDAO.java
 *
 * Created on 19 de Outubro de 2006, 10:26
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.correios.sromonitor.dao;

import java.util.List;

import br.com.correios.sromonitor.vos.DetalhePendenciaBaixa;
import br.com.correios.sromonitor.vos.PendenciaBaixa;

/**
 *
 * @author jeans
 */
public interface PendenciaBaixaDAO {
    /**
     * 
     * @param dr 
     * @throws br.com.correios.sromonitor.dao.DAOException 
     * @return 
     */
    List<PendenciaBaixa> getPendenciaPorDR(String dr, String uniName,String tipoDeLista) throws DAOException;
    
    /**
     * 
     * @param dr 
     * @param reop 
     * @throws br.com.correios.sromonitor.dao.DAOException 
     * @return 
     */
    List<PendenciaBaixa> getPendenciaPorDRReop(String dr, int reop, String uniName,String tipoDeLista) throws DAOException;
    
    /**
     * 
     * @param dr 
     * @param reop 
     * @param tipoUnidade 
     * @throws br.com.correios.sromonitor.dao.DAOException 
     * @return 
     */
    List<PendenciaBaixa> getPendenciaPorDRReopTipoUNidade(String dr, int reop, String tipoUnidade, String uniName,String tipoDeLista) throws DAOException;
    
    /**
     * 
     * @param dr 
     * @param tipoUnidade 
     * @throws br.com.correios.sromonitor.dao.DAOException 
     * @return 
     */
    List<PendenciaBaixa> getPendenciaPorDRTipoUNidade(String dr, String tipoUnidade, String uniName,String tipoDeLista) throws DAOException;
    
    List<DetalhePendenciaBaixa> getDetalhe(String codigoUnidade,String tipoDeLista) throws DAOException;
}
