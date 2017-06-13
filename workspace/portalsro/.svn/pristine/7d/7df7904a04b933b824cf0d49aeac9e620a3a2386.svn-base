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

import br.com.correios.sromonitor.vos.DetalhePendenciaBaixa;
import br.com.correios.sromonitor.vos.PendenciaBaixa;

/**
 *
 * @author jeans
 */
public class OraclePendenciaBaixaDAO implements PendenciaBaixaDAO {
    
    private Properties p;
    
    private final String LDI = "LDI";
    private final String LOEC = "OEC";
    private final String filtroPrazoVencido = "filtroPrazoVencido";
    
    /** Creates a new instance of OraclePendenciaBaixaDAO */
    public OraclePendenciaBaixaDAO() {
        p = new Properties();
        java.io.InputStream in =
                this.getClass().getResourceAsStream("/resources/pendenciaBaixaDB.properties");
        
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
    public List<PendenciaBaixa> getPendenciaPorDR(String dr, String uniName, String tipoDeLista) throws DAOException {
        List<PendenciaBaixa> result = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        String sql = p.getProperty("pendencia.baixa.dr");
        try {
            con = DAOFactory.getConnection();
            //System.out.println("Conexão "+con.toString());
            
            if (tipoDeLista.equals(LDI)){
            	sql=sql.replaceAll(filtroPrazoVencido, p.getProperty("pendencia.filtroPrazoVencido"));
            } else{
            	sql=sql.replaceAll(filtroPrazoVencido,"");
            }
            
            if ( uniName == null || "".equals(uniName.trim())) {
                pstmt = con.prepareStatement(sql);
            } else {
                sql += ' ' + p.getProperty("pendencia.unidade");
                pstmt = con.prepareStatement(sql);
                pstmt.setString(3, uniName + '%');
            }
                        
            pstmt.setString(1, dr);
            pstmt.setString(2, tipoDeLista);
            
            result = getResult(pstmt);
            System.out.println("result "+result.toString());
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
    public List<PendenciaBaixa> getPendenciaPorDRReop(String dr, int reop, String uniName,String tipoDeLista) throws DAOException {
    	System.out.println("M�TODO getPendenciaPorDRReop");
        List<PendenciaBaixa> result = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DAOFactory.getConnection();
            String sql = p.getProperty("pendencia.baixa.dr.reop");
            
            if (tipoDeLista.equals(LDI)){
            	sql=sql.replaceAll(filtroPrazoVencido, p.getProperty("pendencia.filtroPrazoVencido"));
            } else{
            	sql=sql.replaceAll(filtroPrazoVencido,"");
            }
            
            
            if ( uniName == null || "".equals(uniName.trim())) {
                pstmt = con.prepareStatement(sql);
            } else {
                sql += ' ' + p.getProperty("pendencia.unidade");
                pstmt = con.prepareStatement(sql);
                pstmt.setString(4, uniName + '%');
            }
            
            pstmt.setString(1, dr);
            pstmt.setInt(2, reop);
            pstmt.setString(3, tipoDeLista);
            
            result = getResult(pstmt);
       
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
    public List<PendenciaBaixa> getPendenciaPorDRReopTipoUNidade(String dr, int reop, String tipoUnidade, String uniName,String tipoDeLista) throws DAOException {
    	System.out.println("M�TODO getPendenciaPorDRReopTipoUNidade");
        List<PendenciaBaixa> result = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DAOFactory.getConnection();
            String sql = p.getProperty("pendencia.baixa.dr.tipo.reop");
            
            if (tipoDeLista.equals(LDI)){
            	sql=sql.replaceAll(filtroPrazoVencido, p.getProperty("pendencia.filtroPrazoVencido"));
            } else{
            	sql=sql.replaceAll(filtroPrazoVencido,"");
            }
            
            if ( uniName == null || "".equals(uniName.trim())) {
                pstmt = con.prepareStatement(sql);
            } else {
                sql += ' ' + p.getProperty("pendencia.unidade");
                pstmt = con.prepareStatement(sql);
                pstmt.setString(5, uniName + '%');
            }
            
            pstmt.setString(1, dr);
            pstmt.setString(2, tipoUnidade);
            pstmt.setInt(3, reop);
            pstmt.setString(4, tipoDeLista);
            
            result = getResult(pstmt);

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
    public List<PendenciaBaixa> getPendenciaPorDRTipoUNidade(String dr, String tipoUnidade, String uniName,String tipoDeLista) throws DAOException {
    	System.out.println("M�TODO getPendenciaPorDRTipoUNidade");
        List<PendenciaBaixa> result = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DAOFactory.getConnection();
            
            String sql = p.getProperty("pendencia.baixa.dr.tipo");
            
            if (tipoDeLista.equals(LDI)){
            	sql=sql.replaceAll(filtroPrazoVencido, p.getProperty("pendencia.filtroPrazoVencido"));
            } else{
            	sql=sql.replaceAll(filtroPrazoVencido,"");
            }
            
            if ( uniName == null || "".equals(uniName.trim())) {
                pstmt = con.prepareStatement(sql);
            } else {
                sql += ' ' + p.getProperty("pendencia.unidade");
                pstmt = con.prepareStatement(sql);
                pstmt.setString(4, uniName + '%');
            }
            System.out.println(sql);
            pstmt.setString(1, dr);
            pstmt.setString(2, tipoUnidade);
            pstmt.setString(3, tipoDeLista);
            
            result = getResult(pstmt);

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
    
    private List<PendenciaBaixa> getResult(PreparedStatement pstmt) throws SQLException {
        List<PendenciaBaixa> result = new ArrayList<PendenciaBaixa>();
        ResultSet rs = null;
        try {
            rs = pstmt.executeQuery();
            PendenciaBaixa pendencia = null;
            while ( rs.next() ) {
                pendencia = new PendenciaBaixa();
                pendencia.setCodigo(rs.getString("uni_cep"));
                pendencia.setNome(rs.getString("uni_name"));
                result.add(pendencia);
            }
        } finally {
            if ( rs != null ) {
                rs.close();
            }
        }
        
        return result;
    }

    public List<DetalhePendenciaBaixa> getDetalhe(String codigoUnidade, String tipoDeLista) throws DAOException {
        List<DetalhePendenciaBaixa> detalhes = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
        	
            con = DAOFactory.getConnection();
            String sql = p.getProperty("pendencia.baixa.detalhe");
            
            if (tipoDeLista != null && tipoDeLista.equals(LDI)) {
            	sql += ' ' + p.getProperty("pendencia.filtroPrazoVencido");
            }
            
            pstmt = con.prepareStatement(sql);
           
            pstmt.setString(1, codigoUnidade);
            pstmt.setString(2, tipoDeLista == null ? LOEC : tipoDeLista);
            
            rs = pstmt.executeQuery();
            DetalhePendenciaBaixa detalhe = null;
            detalhes = new ArrayList<DetalhePendenciaBaixa>();
            
            while ( rs.next() ) {
                detalhe = new DetalhePendenciaBaixa();
                detalhe.setDataCriacao(new Date(rs.getTimestamp("pen_dh_criacao").getTime()));
                detalhe.setObjeto(rs.getString("pen_nu_objeto"));
                detalhe.setTempo(rs.getString("tempo"));
                detalhe.setPrazo(rs.getString("lop_te_prazao_guarda"));
                
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
    
}
