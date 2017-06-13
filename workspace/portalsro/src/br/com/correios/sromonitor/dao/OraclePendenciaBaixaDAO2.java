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
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.correios.sromonitor.managed.beans.PendenciaBaixaManagedBean2;
import br.com.correios.sromonitor.vos.DetalhePendenciaBaixa;
import br.com.correios.sromonitor.vos.PendenciaBaixa2;
import br.com.correios.sromonitor.vos.PendenciaBaixaDiaria;

/**
 * @author jeans
 */
public class OraclePendenciaBaixaDAO2 implements PendenciaBaixa2DAO {
    
    private Properties p;

    /** Creates a new instance of OraclePendenciaBaixaDAO */
    public OraclePendenciaBaixaDAO2() {
        p = new Properties();
        java.io.InputStream in =
                this.getClass().getResourceAsStream("/resources/pendenciaBaixa2DB.properties");
        
        if( in != null ) {
            try {
                p.load(in);
            } catch( java.io.IOException ex ) {
                
            }
        }
    }
    
    /**
     * 
     * @param dr 
     * @throws br.com.correios.sromonitor.dao.DAOException 
     * @return 
     */
    public List<PendenciaBaixa2> getPendenciaPorDR(String dr, String dataInicio, String dataFinal) throws DAOException {
        setRenderizador(false, true);
        List<PendenciaBaixa2> result = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        String sql = p.getProperty("pendencia.baixa.dr");
        try {
            con = DAOFactory.getConnection();
//            if ( uniName == null || "".equals(uniName.trim())) {
//                pstmt = con.prepareStatement(sql);
//            } else {
//                sql += ' ' + p.getProperty("pendencia.unidade");
//                pstmt = con.prepareStatement(sql);
//                pstmt.setString(2, uniName + '%');
//            }
            pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1, dr);
            pstmt.setString(2, dataInicio);
            pstmt.setString(3, dataFinal);
            
            result = getResult(pstmt, "DR");
       
        } catch (SQLException ex) {
            ex.printStackTrace();
            result = Collections.emptyList();
            throw new DAOException(ex.getMessage());
        } finally {
            if ( pstmt != null ) {
                try {
                    pstmt.close();
                } catch (SQLException ex) {
                }
            }
            
            if ( con != null ) {
                try {
                    con.close();
                } catch (SQLException ex) {
                }
            }
        }
        
        
        return result;
    }
    
    
    /**
     * 
     * @param dr 
     * @param reop 
     * @throws br.com.correios.sromonitor.dao.DAOException 
     * @return 
     */
    public List<PendenciaBaixa2> getPendenciaPorDRTipo(String dr, int tipoUnidade, String dataInicio, String dataFinal) throws DAOException {
        setRenderizador(false, true);
        List<PendenciaBaixa2> result = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DAOFactory.getConnection();
            String sql = p.getProperty("pendencia.baixa.dr.tipoUnidade");
//            if ( uniName == null || "".equals(uniName.trim())) {
//                pstmt = con.prepareStatement(sql);
//            } else {
//                sql += ' ' + p.getProperty("pendencia.unidade");
//                pstmt = con.prepareStatement(sql);
//                pstmt.setString(3, uniName + '%');
//            }
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, dr);
            pstmt.setInt(2, tipoUnidade);
            pstmt.setString(3, dataInicio);
            pstmt.setString(4, dataFinal);
            
            result = getResult(pstmt, "TIPO");
       
        } catch (SQLException ex) {
            ex.printStackTrace();
            result = Collections.emptyList();
            throw new DAOException(ex.getMessage());
        } finally {
            if ( pstmt != null ) {
                try {
                    pstmt.close();
                } catch (SQLException ex) {
                }
            }
            
            if ( con != null ) {
                try {
                    con.close();
                } catch (SQLException ex) {
                }
            }
        }
        
        
        return result;
    }
    
    /**
     * 
     * @param dr 
     * @param reop 
     * @param tipoUnidade 
     * @throws br.com.correios.sromonitor.dao.DAOException 
     * @return 
     */
    public List<PendenciaBaixa2> getPendenciaPorDRTipoUNidadeNomeUnidade(String dr, int tipoUnidade, String uniName, String dataInicio, String dataFinal) throws DAOException {
        setRenderizador(false, true);
        List<PendenciaBaixa2> result = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DAOFactory.getConnection();
            String sql = p.getProperty("pendencia.baixa.dr.unidade");
//            if ( uniName == null || "".equals(uniName.trim())) {
//                pstmt = con.prepareStatement(sql);
//            } else {
//                sql += ' ' + p.getProperty("pendencia.unidade");
//                pstmt = con.prepareStatement(sql);
//                pstmt.setString(4, uniName + '%');
//            }
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, dr);
            pstmt.setInt(2, tipoUnidade);
            pstmt.setString(3, "%"+uniName.toUpperCase()+"%");
            pstmt.setString(4, dataInicio);
            pstmt.setString(5, dataFinal);
            
            result = getResult(pstmt,"UNI");
    
        } catch (SQLException ex) {
            ex.printStackTrace();
            result = Collections.emptyList();
            throw new DAOException(ex.getMessage());
        } finally {
            if ( pstmt != null ) {
                try {
                    pstmt.close();
                } catch (SQLException ex) {
                }
            }
            
            if ( con != null ) {
                try {
                    con.close();
                } catch (SQLException ex) {
                }
            }
        }
        
        
        return result;
    }
    
    /**
     * 
     * @param dr 
     * @param tipoUnidade 
     * @throws br.com.correios.sromonitor.dao.DAOException 
     * @return 
     */
    public List<PendenciaBaixa2> getPendenciaPorTipoUNidadeNome(String dr, int tipoUnidade, String uniName, String dataInicio, String dataFina) throws DAOException {
        setRenderizador(true, true);
        List<PendenciaBaixa2> result = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        String sql ="";
        try {
            con = DAOFactory.getConnection();
            if(dr.equals("0") && tipoUnidade > 0 && !"".equals(uniName)){
                sql = p.getProperty("pendencia.baixa.dr.tipoUnidadeNome");
                pstmt = con.prepareStatement(sql);
                pstmt.setInt(1, tipoUnidade);
                pstmt.setString(2, "%"+uniName.toUpperCase()+"%");
                pstmt.setString(3, dataInicio);
                pstmt.setString(4, dataFina);
            }else if(dr.equals("0") && tipoUnidade == 0 && !"".equals(uniName)){
                sql = p.getProperty("pendencia.baixa.dr.unidadesNome");
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, "%"+uniName.toUpperCase()+"%");
                pstmt.setString(2, dataInicio);
                pstmt.setString(3, dataFina);
            }else if(dr.equals("0") && tipoUnidade > 0 && "".equals(uniName)){
                sql = p.getProperty("pendencia.baixa.dr.tipoUnidadesDRs");
                pstmt = con.prepareStatement(sql);
                pstmt.setInt(1, tipoUnidade);
                pstmt.setString(2, dataInicio);
                pstmt.setString(3, dataFina);
            }else if(!dr.equals("0") && tipoUnidade == 0 && !"".equals(uniName)){
                setRenderizador(false, true);
                sql = p.getProperty("pendencia.baixa.dr.DRNomeUnidade");
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, dr);
                pstmt.setString(2, "%"+uniName.toUpperCase()+"%");
                pstmt.setString(3, dataInicio);
                pstmt.setString(4, dataFina);
            }
            result = getResult(pstmt, "TIPO");
      
        } catch (SQLException ex) {
            ex.printStackTrace();
            result = Collections.emptyList();
            throw new DAOException(ex.getMessage());
        } finally {
            if ( pstmt != null ) {
                try {
                    pstmt.close();
                } catch (SQLException ex) {
                }
            }
            
            if ( con != null ) {
                try {
                    con.close();
                } catch (SQLException ex) {
                }
            }
        }
        
        
        return result;
    }
    
    private List<PendenciaBaixa2> getResult(PreparedStatement pstmt, String tipoResultado) throws SQLException {
        List<PendenciaBaixa2> result = new ArrayList<PendenciaBaixa2>();
        ResultSet rs = null;
        
        try {
            PendenciaBaixa2 pendencia = null;
			if ("".equalsIgnoreCase(tipoResultado)) {
				rs = pstmt.executeQuery();

				while (rs.next()) {
					pendencia = new PendenciaBaixa2();
					
					pendencia.setDataPesquisada(rs.getDate("DATA"));
					pendencia.setSiglaDr(rs.getString("DR").trim());
					pendencia.setCodigo(buscaCodigoDr(rs.getString("DR").trim()));
					pendencia.setLancado(rs.getString("LANCADOS"));
					pendencia.setBaixado(rs.getString("BAIXADOS"));
					pendencia.calculaPercentualBaixado();

					result.add(pendencia);
				}
			} else if ("DR".equalsIgnoreCase(tipoResultado) || "TIPO".equalsIgnoreCase(tipoResultado) || "UNI".equalsIgnoreCase(tipoResultado)) {
				rs = pstmt.executeQuery();

				while (rs.next()) {
					pendencia = new PendenciaBaixa2();
					
					pendencia.setDataPesquisada(rs.getDate("DATA"));
					pendencia.setCodigo(rs.getString("CODIGO").trim());
					pendencia.setCodigoMCMCU(rs.getString("CODIGOMCMCU").trim());
					pendencia.setSiglaDr(rs.getString("DR").trim());
					pendencia.setNome(rs.getString("NOME").trim());
					pendencia.setCodigoSro(rs.getString("UNIDADE").trim());
					pendencia.setTipoUnidade(rs.getString("TIPO").trim());
					pendencia.setLancado(rs.getString("LANCADOS"));
					pendencia.setBaixado(rs.getString("BAIXADOS"));
					pendencia.calculaPercentualBaixado();
					
					result.add(pendencia);
				}
			}
        } finally {
            if ( rs != null ) {
                rs.close();
            }
        }
        
        return result;
    }


    public List<DetalhePendenciaBaixa> getDetalhe(String codigoUnidade) throws DAOException {
        List<DetalhePendenciaBaixa> detalhes = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = DAOFactory.getConnection();
            String sql = p.getProperty("pendencia.baixa.detalhe");
            pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1, codigoUnidade);
            
            rs = pstmt.executeQuery();
            DetalhePendenciaBaixa detalhe = null;
            detalhes = new ArrayList<DetalhePendenciaBaixa>();
            
            while ( rs.next() ) {
                detalhe = new DetalhePendenciaBaixa();
                detalhe.setDataCriacao(new Date(rs.getTimestamp("pen_dh_criacao").getTime()));
                detalhe.setObjeto(rs.getString("pen_nu_objeto"));
                detalhe.setTempo(rs.getString("tempo"));
                detalhe.setDatInsercao(new Date(rs.getTimestamp("pen_dh_insercao").getTime()));
                detalhes.add(detalhe);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DAOException(ex.getMessage());
        } finally {
            
            if ( rs != null ) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                }
            }
            
            if ( pstmt != null ) {
                try {
                    pstmt.close();
                } catch (SQLException ex) {
                }
            }
            
            if ( con != null ) {
                try {
                    con.close();
                } catch (SQLException ex) {
                }
            }
        }
        
        
        return detalhes;
    }

    public List<PendenciaBaixa2> getPendenciaDRs(String dataInicio, String dataFinal) throws DAOException {
        setRenderizador(true, false);
        List<PendenciaBaixa2> result = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DAOFactory.getConnection();

            String sql = p.getProperty("pendencia.baixa.drs");

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, dataInicio);
            pstmt.setString(2, dataFinal);

            result = getResult(pstmt,"");
   
        } catch (SQLException ex) {
            ex.printStackTrace();
            result = Collections.emptyList();
            throw new DAOException(ex.getMessage());
        } finally {
            if ( pstmt != null ) {
                try {
                    pstmt.close();
                } catch (SQLException ex) {
                }
            }

            if ( con != null ) {
                try {
                    con.close();
                } catch (SQLException ex) {
                }
            }
        }


        return result;
    }

    public void setRenderizador(boolean mostraDR, boolean mostraNomeUnidade){
        PendenciaBaixaManagedBean2.setDrMostra(mostraDR);
        PendenciaBaixaManagedBean2.setNomeUniMostra(mostraNomeUnidade);
    }

    public String buscaCodigoDr(String siglaDR){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String codigo = "";
        try {
            con = DAOFactory.getConnection();

            String sql = p.getProperty("pendencia.baixa.codigoDr");

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, siglaDR);

            rs = pstmt.executeQuery();
            while ( rs.next() ) {
                  codigo = rs.getString("CODIGO");
                }


 
        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                throw new DAOException(ex.getMessage());
            } catch (DAOException ex1) {
                Logger.getLogger(OraclePendenciaBaixaDAO2.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if ( pstmt != null ) {
                try {
                    pstmt.close();
                } catch (SQLException ex) {
                }
            }

            if ( con != null ) {
                try {
                    con.close();
                } catch (SQLException ex) {
                }
            }
        }

    return codigo;
    }
    
    @Override
	public List<PendenciaBaixaDiaria> getPendenciaDiaria(String hoje) throws DAOException {
        Connection con = null;
        PreparedStatement pstmt = null;
        List<PendenciaBaixaDiaria> result = null;
        
        try {
            con = DAOFactory.getConnection();
            
            pstmt = con.prepareStatement(p.getProperty("pendencia.baixa.diaria"));
            pstmt.setString(1, hoje);
            pstmt.setString(2, hoje);
            
            result = getResultDiaria(pstmt);
        } catch (SQLException e) {
            e.printStackTrace();
            result = Collections.emptyList();
            throw new DAOException(e.getMessage());
        } finally {
            if ( pstmt != null ) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                }
            }
            
            if ( con != null ) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
        
        return result;
	}

	private List<PendenciaBaixaDiaria> getResultDiaria(PreparedStatement pstmt) throws SQLException {
		List<PendenciaBaixaDiaria> result = new ArrayList<PendenciaBaixaDiaria>();
		ResultSet rs = null;

		try {
			PendenciaBaixaDiaria pendencia = null;
			rs = pstmt.executeQuery();

			while (rs.next()) {
				pendencia = new PendenciaBaixaDiaria();

				pendencia.setDr(rs.getString("DR").trim());
				pendencia.setLancado(rs.getString("LANCADOS"));
				pendencia.setPendencia(rs.getString("PENDENCIAS"));

				result.add(pendencia);
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
		}

		return result;
	}

}
