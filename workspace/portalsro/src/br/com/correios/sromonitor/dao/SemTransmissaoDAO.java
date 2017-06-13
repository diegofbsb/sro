/*
 * SemTransmissaoDAO.java
 *
 * Created on 5 de Setembro de 2006, 18:25
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
public interface SemTransmissaoDAO {
    /**
     * 
     * @param dr 
     * @throws br.com.correios.sromonitor.dao.DAOException 
     * @return 
     */
    List<Transmissao> getSemTransmissaoPorDR(String dr) throws DAOException;
    
    /**
     * 
     * @param dr 
     * @param reop 
     * @throws br.com.correios.sromonitor.dao.DAOException 
     * @return 
     */
    List<Transmissao> getSemTransmissaoPorDRReop(String dr, int reop) throws DAOException;
    
    /**
     * 
     * @param dr 
     * @param reop 
     * @param tipoUnidade 
     * @throws br.com.correios.sromonitor.dao.DAOException 
     * @return 
     */
    List<Transmissao> getSemTransmissaoPorDRReopTipoUNidade(String dr, int reop, String tipoUnidade) throws DAOException;
    
    /**
     * 
     * @param dr 
     * @param tipoUnidade 
     * @throws br.com.correios.sromonitor.dao.DAOException 
     * @return 
     */
    List<Transmissao> getSemTransmissaoPorDRTipoUNidade(String dr, String tipoUnidade) throws DAOException;
}
