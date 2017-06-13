package br.com.correios.sromonitor.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import br.com.correios.sromonitor.vos.FaixaCepUnidadeOperacional;
import br.com.correios.sromonitor.vos.UnidadeOperacional;

/**
 * @author Paulo Henrique Mendes
 */
public class OracleFaixaCepDAO implements FaixaCepDAO {

	private Properties properties;

	public OracleFaixaCepDAO() {
		properties = new Properties();
		InputStream in = this.getClass().getResourceAsStream("/resources/faixaCepDB.properties");

		if (in != null) {
			try {
				properties.load(in);
			} catch (IOException ex) {
			}
		}
	}

	public List<FaixaCepUnidadeOperacional> pesquisarPorFiltros(String dr, String tipoUnidade) throws DAOException {
		List<FaixaCepUnidadeOperacional> faixas = new ArrayList<FaixaCepUnidadeOperacional>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = null;
		
		if (tipoUnidade != null && !tipoUnidade.equals("")) {
			sql = properties.getProperty("pesquisar.faixa.cep.por.dr.e.tipo.unidade");
			sql = sql.replaceFirst("[?]", String.valueOf(dr));
			sql = sql.replaceFirst("[?]", "'" + tipoUnidade + "%'");
		} else {
			sql = properties.getProperty("pesquisar.faixa.cep.por.dr");
			sql = sql.replaceFirst("[?]", String.valueOf(dr));
		}
		
		try {
			con = DAOFactory.getConnection();
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				faixas.add(montarFaixaCep(rs));
			}

		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			close(con, stmt, rs);
		}
		
		return faixas;
	}

	public UnidadeOperacional obterUnidadeOperacionalPorCodigo(String codigoUnidade) throws DAOException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DAOFactory.getConnection();
			pstmt = con.prepareStatement(properties.getProperty("find.unidade.operacional.by.codigo"));
			
			pstmt.setString(1, codigoUnidade);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				return montarUnidadeOperacional(rs);
			}
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		
		return null;
	}
	
	public boolean existeFaixaCepParaUnidade(String codigoUnidade) throws DAOException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DAOFactory.getConnection();
			pstmt = con.prepareStatement(properties.getProperty("count.faixas.unidade"));
			
			pstmt.setString(1, codigoUnidade);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				return rs.getLong(1) > 0;
			}
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		
		return false;
	}
	
	public void insert(FaixaCepUnidadeOperacional faixaCepUnidadeOperacional) throws DAOException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		Object[] values = {
			obterNovoId(con),
		    faixaCepUnidadeOperacional.getCodigoUnidade(),
		    faixaCepUnidadeOperacional.getCepInicial(),
		    faixaCepUnidadeOperacional.getCepFinal(),
		    faixaCepUnidadeOperacional.getTipoUnidade()
		};
		
		try {
			con = DAOFactory.getConnection();
			pstmt = con.prepareStatement(properties.getProperty("insert.faixa.cep"));
			
			for (int i = 0; i < values.length; i++) {
	            pstmt.setObject(i + 1, values[i]);
	        }
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			close(con, pstmt, null);
		}
	}
	
	public void delete(String codigoUnidade) throws DAOException {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DAOFactory.getConnection();
			pstmt = con.prepareStatement(properties.getProperty("delete.faixa.cep"));
			
            pstmt.setObject(1, codigoUnidade);
            
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			close(con, pstmt, null);
		}
	}

	private Long obterNovoId(Connection con) throws DAOException {
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			con = DAOFactory.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(properties.getProperty("get.max.id"));
			
			if (rs.next()) {
				return (rs.getLong(1) + 1);
			}
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		} finally {
			close(null, stmt, rs);
		}
		
		return null;
	}

	private FaixaCepUnidadeOperacional montarFaixaCep(ResultSet rs) throws SQLException {
		return new FaixaCepUnidadeOperacional(
			rs.getLong("ocr_recordid"), 
			rs.getString("ocr_unitcep"),
			rs.getString("uni_code"),
			rs.getString("uni_name"), 
			rs.getString("ocr_initialcep"), 
			rs.getString("ocr_finalcep"), 
			rs.getByte("ocr_geovalidity"), 
			new java.util.Date(rs.getTimestamp("ocr_updatetime").getTime())
		);
	}
	
	private UnidadeOperacional montarUnidadeOperacional(ResultSet rs) throws SQLException {
		return new UnidadeOperacional(
			rs.getString("uni_cep"), 
			rs.getString("uni_name"), 
			rs.getString("rd_acronym")
		);
	}
	
	private void close(Connection con, Statement stmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
