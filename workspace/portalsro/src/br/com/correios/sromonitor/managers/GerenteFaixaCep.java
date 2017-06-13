package br.com.correios.sromonitor.managers;

import java.util.List;
import java.util.ResourceBundle;

import br.com.correios.componente.cliente.DnecWServiceClient;
import br.com.correios.componente.exception.UnidadeNaoEncontradaException;
import br.com.correios.faixa.Faixa;
import br.com.correios.faixa.cep.FaixaCep;
import br.com.correios.sromonitor.dao.DAOException;
import br.com.correios.sromonitor.dao.DAOFactory;
import br.com.correios.sromonitor.dao.FaixaCepDAO;
import br.com.correios.sromonitor.vos.FaixaCepUnidadeOperacional;
import br.com.correios.sromonitor.vos.UnidadeOperacional;

/**
 * Facade para FaixaCepDAO.
 * 
 * @author Paulo Henrique Mendes
 */
public class GerenteFaixaCep {

	private FaixaCepDAO faixaCepDAO;
	private ResourceBundle messages;

	public GerenteFaixaCep() {
		faixaCepDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getFaixaCepDAO();
		messages = ResourceBundle.getBundle("resources.messages");
	}

	public List<FaixaCepUnidadeOperacional> pesquisarPorFiltros(String dr, String tipoUnidade) throws ManagementException {
		try {
			return faixaCepDAO.pesquisarPorFiltros(dr, tipoUnidade);
		} catch (DAOException e) {
			e.printStackTrace();
			throwException("db.error");
		}

		return null;
	}
	
	public void incluir(String codigoUnidade) throws ManagementException {
		UnidadeOperacional unidade = obterUnidadeOperacionalPorCodigo(codigoUnidade);
		
		if (unidade == null) {
			throwException("unidade.nao.encontrada");
		}
		
		if (existeFaixaCepParaUnidade(codigoUnidade)) {
			throwException("existe.faixa.unidade");
		} else {
			FaixaCep faixaDNE = consultarFaixaDNE(unidade);
			
			for (Faixa faixa : faixaDNE.getFAIXAS().getFAIXA()) {
				try {
					faixaCepDAO.insert(new FaixaCepUnidadeOperacional(
							null, 
							codigoUnidade, 
							unidade.getNome(), 
							faixa.getCEPINICIAL(), 
							faixa.getCEPFINAL(), 
							Byte.valueOf(isCTEouCTCE(unidade) ? "1" : "0"), 
							null
					));
				} catch (DAOException e) {
					e.printStackTrace();
					throwException("db.error");
				}
			}
		}
	}
	
	public void excluir(String codigoUnidade) throws ManagementException {
		try {
			UnidadeOperacional unidade = obterUnidadeOperacionalPorCodigo(codigoUnidade);
			
			if (unidade == null) {
				throwException("unidade.nao.encontrada");
			}
			
			if (!existeFaixaCepParaUnidade(codigoUnidade)) {
				throwException("nao.existe.faixa.unidade");
			} else {
				faixaCepDAO.delete(codigoUnidade);
			}
		} catch (DAOException e) {
			e.printStackTrace();
			throwException("db.error");
		}
	}

	private UnidadeOperacional obterUnidadeOperacionalPorCodigo(String codigoUnidade) throws ManagementException {
		try {
			return faixaCepDAO.obterUnidadeOperacionalPorCodigo(codigoUnidade);
		} catch (DAOException e) {
			e.printStackTrace();
			throwException("db.error");
		}
		
		return null;
	}
	
	private boolean existeFaixaCepParaUnidade(String codigoUnidade) throws ManagementException {
		try {
			return faixaCepDAO.existeFaixaCepParaUnidade(codigoUnidade);
		} catch (DAOException e) {
			e.printStackTrace();
			throwException("db.error");
		}
		
		return false;
	}
	
	private FaixaCep consultarFaixaDNE(UnidadeOperacional unidade) throws ManagementException {
		try {
			DnecWServiceClient dneServiceClient = new DnecWServiceClient();
			List<FaixaCep> faixasDNE = null;
			
			if (isCTEouCTCE(unidade)) {
				faixasDNE = dneServiceClient.listaFaixa(unidade.getUf(), null);
			} else {
				faixasDNE = dneServiceClient.listaFaixaUnidade(unidade.getUf(), null, null, unidade.getNome());
			}
			
			if (faixasDNE != null && !faixasDNE.isEmpty()) {
				return faixasDNE.get(0);
			} else {
				throwException("faixa.nao.encontrada");
			}
		} catch (UnidadeNaoEncontradaException e) {
			e.printStackTrace();
			throwException("faixa.nao.encontrada");
		}
		
		return null;
	}
	
	private boolean isCTEouCTCE(UnidadeOperacional unidade) {
		return (unidade.getNome().startsWith("CTE") || unidade.getNome().startsWith("CTCE"));
	}

	private void throwException(String key) throws ManagementException {
		throw new ManagementException(messages.getString(key));
	}

}