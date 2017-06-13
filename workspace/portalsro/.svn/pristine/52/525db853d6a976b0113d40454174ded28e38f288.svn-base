package br.com.correios.sromonitor.dao;

import java.util.List;

import br.com.correios.sromonitor.vos.FaixaCepUnidadeOperacional;
import br.com.correios.sromonitor.vos.UnidadeOperacional;

/**
 * @author Paulo Henrique Mendes
 */
public interface FaixaCepDAO {
	
	List<FaixaCepUnidadeOperacional> pesquisarPorFiltros(String dr, String tipoUnidade) throws DAOException;

	UnidadeOperacional obterUnidadeOperacionalPorCodigo(String codigoUnidade) throws DAOException;

	void insert(FaixaCepUnidadeOperacional faixaCepUnidadeOperacional) throws DAOException;

	void delete(String codigoUnidade) throws DAOException;

	boolean existeFaixaCepParaUnidade(String codigoUnidade) throws DAOException;

}