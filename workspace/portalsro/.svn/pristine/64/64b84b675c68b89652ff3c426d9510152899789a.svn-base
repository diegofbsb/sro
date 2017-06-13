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

import br.com.correios.sromonitor.vos.DetalheEstacoesDeTrabalho;
import br.com.correios.sromonitor.vos.EstacoesDeTrabalho;
import br.com.correios.sromonitor.vos.PendenciaBaixa2;

/**
 *
 * @author jeans
 */

public interface EstacoesDeTrabalhoDAO {
    List<EstacoesDeTrabalho> getEstacoesDeTrabalhoPorDRTipoUNidadeNomeUnidade(String dr, String tipoUnidade, String uniName, String uniVersao, String tipoEstacao) throws DAOException;
    List<DetalheEstacoesDeTrabalho> getDetalhe(String codigoUnidade) throws DAOException;
}
