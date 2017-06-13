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

import br.com.correios.sromonitor.vos.DifusaoWebSROIIWebSphere;

/**
 *
 * @author jeans
 */
public interface DifusaoWebSROIIWebSphereDAO {
    /**
 * 
     * @param uniCep 
     * @throws br.com.correios.sromonitor.dao.DAOException 
     * @return 
     */
    boolean getUpdateUniRunningdateUnidade(String uniCep) throws DAOException;
    
    List<DifusaoWebSROIIWebSphere> getUnidades(String uniName) throws DAOException;
    
    List<DifusaoWebSROIIWebSphere> getUnidadesCodigo(String codigo) throws DAOException;
    
}
