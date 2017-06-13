package br.com.correios.sromonitor.dao;

import java.util.List;

import br.com.correios.sromonitor.vos.DetalhePendenciaBaixa;
import br.com.correios.sromonitor.vos.PendenciaBaixa2;
import br.com.correios.sromonitor.vos.PendenciaBaixaDiaria;

/**
 * @author jeans
 */
public interface PendenciaBaixa2DAO {
	
    /**
     * @param dr
     * @throws br.com.correios.sromonitor.dao.DAOException
     * @return
     */
    List<PendenciaBaixa2> getPendenciaDRs(String dataInicio, String dataFinal) throws DAOException;
    
    /**
     * @param dr 
     * @throws br.com.correios.sromonitor.dao.DAOException 
     * @return 
     */
    List<PendenciaBaixa2> getPendenciaPorDR(String dr, String dataInicio, String dataFinal) throws DAOException;
    
    /**
     * @param dr 
     * @param reop 
     * @throws br.com.correios.sromonitor.dao.DAOException 
     * @return 
     */
    List<PendenciaBaixa2> getPendenciaPorDRTipo(String dr, int tipo, String dataInicio, String dataFinal) throws DAOException;
    
    /**
     * @param dr 
     * @param reop 
     * @param tipoUnidade 
     * @throws br.com.correios.sromonitor.dao.DAOException 
     * @return 
     */
    List<PendenciaBaixa2> getPendenciaPorDRTipoUNidadeNomeUnidade(String dr, int tipoUnidade, String uniName, String dataInicio, String dataFinal) throws DAOException;
    
    /**
     * @param dr 
     * @param tipoUnidade
     * @param uniName 
     * @param dtPesquisa 
     * @throws br.com.correios.sromonitor.dao.DAOException 
     * @return 
     */
    List<PendenciaBaixa2> getPendenciaPorTipoUNidadeNome(String dr, int tipoUnidade, String uniName, String dataInicio, String dataFinal) throws DAOException;

    /**
     * @param codigoUnidade
     * @return
     * @throws DAOException
     */
    List<DetalhePendenciaBaixa> getDetalhe(String codigoUnidade) throws DAOException;
    
    /**
     * @param hoje
     * @return
     * @throws DAOException
     */
	List<PendenciaBaixaDiaria> getPendenciaDiaria(String hoje) throws DAOException;
	
}
