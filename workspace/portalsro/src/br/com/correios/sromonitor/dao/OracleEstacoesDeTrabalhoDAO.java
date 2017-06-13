/*
 * OraclePendenciaBaixaDAO.java
 *
 * Created on 19 de Outubro de 2006, 11:22
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.correios.sromonitor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import br.com.correios.sromonitor.vos.DetalheEstacoesDeTrabalho;
import br.com.correios.sromonitor.vos.EstacoesDeTrabalho;
import br.com.correios.sromonitor.vos.PendenciaBaixa;

/**
 *
 * @author jeans
 */
public class OracleEstacoesDeTrabalhoDAO implements EstacoesDeTrabalhoDAO {

	private Properties p;
	private int position = 1;

	/** Creates a new instance of OraclePendenciaBaixaDAO */
	public OracleEstacoesDeTrabalhoDAO() {
		p = new Properties();
		java.io.InputStream in = this.getClass().getResourceAsStream("/resources/estacoesDeTrabalhoDB.properties");

		if (in != null) {
			try {
				p.load(in);
			} catch (java.io.IOException ex) {

			}
		}
	}

	@Override
	public List<DetalheEstacoesDeTrabalho> getDetalhe(String codigoUnidade) throws DAOException {

		return null;
	}

	@Override
	public List<EstacoesDeTrabalho> getEstacoesDeTrabalhoPorDRTipoUNidadeNomeUnidade(String dr, String tipoUnidade,
			String uniName, String uniVersao, String tipoEstacao) throws DAOException {
		System.out.println("M�TODO getEstacoesDeTrabalhoPorDRTipoUNidadeNomeUnidade");
		List<EstacoesDeTrabalho> result = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DAOFactory.getConnection();
			String sql = p.getProperty("estacoesDeTrabalho.dr");

			if (tipoUnidade != null && !"".equals(tipoUnidade.trim())) {
				sql += ' ' + p.getProperty("estacoesDeTrabalho.tipo");
			}

			if (uniName != null && !"".equals(uniName.trim())) {
				sql += ' ' + p.getProperty("estacoesDeTrabalho.unidade");
			}

			if (uniVersao != null && !"".equals(uniVersao.trim())) {
				sql += ' ' + p.getProperty("estacoesDeTrabalho.universao");
			}
			
			if (tipoEstacao != null && !"".equals(tipoEstacao.trim())) {
				sql += ' ' + p.getProperty("estacoesDeTrabalho.tipoEstacao");
			}
			
			sql += ' ' + p.getProperty("estacoesDeTrabalho.orderBy");

			pstmt = con.prepareStatement(sql);
			pstmt.setString(position, dr);
			position++;

			if (tipoUnidade != null && !"".equals(tipoUnidade.trim())) {
				pstmt.setString(position, '%' + tipoUnidade + '%');
				position++;
			}

			if (uniName != null && !"".equals(uniName.trim())) {
				pstmt.setString(position, '%' + uniName + '%');
				position++;
			}

			if (uniVersao != null && !"".equals(uniVersao.trim())) {
				pstmt.setString(position, '%' + uniVersao + '%');
				position++;
			}
			
			if (tipoEstacao != null && !"".equals(tipoEstacao.trim())){
				pstmt.setInt(position, Integer.parseInt(tipoEstacao));
				position++;
			}

			System.out.println("vai rodar " + sql);
			
			result = getResult(pstmt);
			
			System.out.println(sql);

		} catch (SQLException ex) {
			ex.printStackTrace();
			result = Collections.emptyList();
			throw new DAOException(ex.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException ex) {
				}
			}
		}

		return result;
	}

	private List<EstacoesDeTrabalho> getResult(PreparedStatement pstmt) throws SQLException {
		List<EstacoesDeTrabalho> result = new ArrayList<EstacoesDeTrabalho>();

		System.out.println("11111111111111111111111111");
		ResultSet rs = null;
		try {
			rs = pstmt.executeQuery();
			EstacoesDeTrabalho estacoesDeTrabalho = null;
			while (rs.next()) {
				estacoesDeTrabalho = new EstacoesDeTrabalho();
				estacoesDeTrabalho.setRD_ACRONYM(rs.getString("RD_ACRONYM"));
				System.out.println(rs.getString("RD_ACRONYM"));
				estacoesDeTrabalho.setEST_CO_UNICEP(rs.getString("EST_CO_UNICEP"));
				System.out.println(rs.getString("EST_CO_UNICEP"));
				estacoesDeTrabalho.setUNI_NAME(rs.getString("UNI_NAME"));
				System.out.println(rs.getString("UNI_NAME"));
				estacoesDeTrabalho.setOut_acronym(rs.getString("out_acronym"));
				System.out.println(rs.getString("out_acronym"));
				estacoesDeTrabalho.setEST_NO(rs.getString("EST_NO"));
				System.out.println(rs.getString("EST_NO"));
				estacoesDeTrabalho.setEST_CO_IP(rs.getString("EST_CO_IP"));
				System.out.println(rs.getString("EST_CO_IP"));
				estacoesDeTrabalho.setTipoEstacao(rs.getString("tipoEstacao"));
				System.out.println(rs.getString("tipoEstacao"));
				estacoesDeTrabalho.setINS_NU(rs.getString("INS_NU"));
				System.out.println(rs.getString("INS_NU"));
				estacoesDeTrabalho.setINS_TX_DIRETORIO(rs.getString("INS_TX_DIRETORIO"));
				System.out.println(rs.getString("INS_TX_DIRETORIO"));
				estacoesDeTrabalho.setINS_NO_VERSAO(rs.getString("INS_NO_VERSAO"));
				System.out.println(rs.getString("INS_NO_VERSAO"));
				estacoesDeTrabalho.setEST_DH_INSERCAO_SRO(rs.getDate("EST_DH_INSERCAO_SRO"));
				System.out.println(rs.getString("EST_DH_INSERCAO_SRO"));
				estacoesDeTrabalho.setUNI_CODE(rs.getString("UNI_CODE"));
				System.out.println(rs.getString("UNI_CODE"));
				result.add(estacoesDeTrabalho);
				System.out.println(rs.getString("RD_ACRONYM"));

				System.out.println("Mostrando Código MCU");
				System.out.println(rs.getString("UNI_CODE"));
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
		}
		return result;
	}
}
