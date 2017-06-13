/*
 * ControleTransmissaoDAO.java
 *
 * Created on 8 de Setembro de 2006, 15:58
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.correios.sromonitor.dao;

import java.util.Date;
import java.util.List;

import br.com.correios.sromonitor.vos.ControleTransmissao;

/**
 * DAO para o controle de transmiss&otilde;es.
 * @author Jean Clay Souza da Silva - Analista POLITEC - DESUN/DSGL
 */
public interface ControleTransmissaoDAO {
    /**
     * Retorna uma lista de ControleTransmissao.
     * @param codigoUnidade C&oacute;digo da unidade.
     * @param startDate Data inicial.
     * @param endDate Data final.
     * @throws br.com.correios.sromonitor.dao.DAOException Caso ocorra algum erro na recupera&ccedil;&atilde;o de resultados.
     * @return Lista de ControleTransmissao.
     */
    List<ControleTransmissao> getTransmissoes(String codigoUnidade, Date startDate, Date endDate) throws DAOException;
    
    String getNomeUnidade(String codigoUnidade) throws DAOException;
}
