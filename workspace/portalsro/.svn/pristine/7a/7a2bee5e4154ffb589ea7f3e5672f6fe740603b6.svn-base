/*
 * UltimaTransmissaoDAO.java
 *
 * Created on 31 de Agosto de 2006, 16:14
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.correios.sromonitor.dao;

import java.util.List;

import br.com.correios.sromonitor.vos.Transmissao;

/**
 *
 * @author Jean Clay Souza da Silva - Analista POLITEC - DESUN/DSGL
 */
public interface UltimaTransmissaoDAO {
    
    /**
     * 
     * @param dr 
     * @throws br.com.correios.sromonitor.dao.DAOException 
     * @return 
     */
    List<Transmissao> getUltimaTransmissaoPorDR(String dr) throws DAOException;
    
    /**
     * 
     * @param dr 
     * @param reop 
     * @throws br.com.correios.sromonitor.dao.DAOException 
     * @return 
     */
    List<Transmissao> getUltimaTransmissaoPorDRReop(String dr, int reop) throws DAOException;
    
    /**
     * 
     * @param dr 
     * @param reop 
     * @param tipoUnidade 
     * @throws br.com.correios.sromonitor.dao.DAOException 
     * @return 
     */
    List<Transmissao> getUltimaTransmissaoPorDRReopTipoUNidade(String dr, int reop, String tipoUnidade) throws DAOException;
    
    /**
     * 
     * @param dr 
     * @param tipoUnidade 
     * @throws br.com.correios.sromonitor.dao.DAOException 
     * @return 
     */
    List<Transmissao> getUltimaTransmissaoPorDRTipoUNidade(String dr, String tipoUnidade) throws DAOException;
    
}
