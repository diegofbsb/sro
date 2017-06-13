package br.com.correios.sromonitor.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * Classe base para o pattern DAO.
 * 
 * @author Jean Clay Souza da Silva - Analista POLITEC - DESUN/DSGL
 */
public abstract class DAOFactory {

	/**
	 * Representa o SGBD Oracle.
	 */
	public static final int ORACLE = 0;
	private static InitialContext ic;
	private static DataSource dataSource;

	public static DAOFactory getDAOFactory(int type) {
		DAOFactory factory = null;

		switch (type) {
			case ORACLE:
				factory = OracleDAOFactory.getInstanca();
				break;
			default:
				throw new IllegalArgumentException("Tipo desconhecido: " + type);
		}

		try {
			ic = new InitialContext();
			dataSource = (DataSource) ic.lookup("jdbc/portalsro");
		} catch (Exception sqle) {
			sqle.printStackTrace();
		}

		return factory;
	}

	public synchronized static Connection getConnection() {
		try {
			Connection con = dataSource.getConnection();
			System.out.println("conexão " + con.toString() + " - " + con.isClosed());
			return con;
		} catch (SQLException ex) {
			System.out.println("conexão " + null);
			Logger.getLogger(DAOFactory.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	public abstract UltimaTransmissaoDAO getUltimaTransmissaoDAO();

	public abstract SemTransmissaoDAO getSemTransmissaoDAO();

	public abstract ControleTransmissaoDAO getControleTransmissaoDAO();

	public abstract PendenciaBaixaDAO getPendenciaBaixaDAO();

	public abstract PendenciaBaixa2DAO getPendenciaBaixaDAO2();

	public abstract ArquivoRepetidoDAO getArquivoRepetidoDAO();

	public abstract ObjetoIrregularDAO getObjetoIrregularDAO();

	public abstract DifusaoWebSROIIWebSphereDAO getDifusaoWebSROIIWebSphereDAO();

	public abstract FaixaCepDAO getFaixaCepDAO();
	
	public abstract EstacoesDeTrabalhoDAO getEstacoesDeTrabalhoDAO();

}
