package br.com.correios.sromonitor.dao;

/**
 * @author Jean Clay Souza da Silva - Analista POLITEC - DESUN/DSGL
 */
public class OracleDAOFactory extends DAOFactory {
	
	private static OracleDAOFactory instance = null;

	public OracleDAOFactory() {
	}

	public UltimaTransmissaoDAO getUltimaTransmissaoDAO() {
		return new OracleUltimaTransmissaoDAO();
	}

	public SemTransmissaoDAO getSemTransmissaoDAO() {
		return new OracleSemTransmissaoDAO();
	}

	public ControleTransmissaoDAO getControleTransmissaoDAO() {
		return new OracleControleTransmissaoDAO();
	}

	public PendenciaBaixaDAO getPendenciaBaixaDAO() {
		return new OraclePendenciaBaixaDAO();
	}

	public ArquivoRepetidoDAO getArquivoRepetidoDAO() {
		return new OracleArquivoRepetidoDAO();
	}

	public ObjetoIrregularDAO getObjetoIrregularDAO() {
		return new OracleObjetoIrregularDAO();
	}

	public PendenciaBaixa2DAO getPendenciaBaixaDAO2() {
		return new OraclePendenciaBaixaDAO2();
	}

	public DifusaoWebSROIIWebSphereDAO getDifusaoWebSROIIWebSphereDAO() {
		return new OracleDifusaoWebSROIIWebSphereDAO();
	}

	public FaixaCepDAO getFaixaCepDAO() {
		return new OracleFaixaCepDAO();
	}

	public static synchronized OracleDAOFactory getInstanca() {
		if (instance == null) {
			instance = new OracleDAOFactory();
		}
		return instance;
	}

	public EstacoesDeTrabalhoDAO getEstacoesDeTrabalhoDAO() {
		return new OracleEstacoesDeTrabalhoDAO();
	}

}
