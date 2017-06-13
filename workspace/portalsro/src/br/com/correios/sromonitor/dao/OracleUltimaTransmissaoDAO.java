/*
 * OracleUltimaTransmissaoDAO.java
 *
 * Created on 31 de Agosto de 2006, 16:27
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.correios.sromonitor.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import br.com.correios.sromonitor.vos.Transmissao;

/**
 *
 * @author Jean Clay Souza da Silva - Analista POLITEC - DESUN/DSGL
 */
public class OracleUltimaTransmissaoDAO implements UltimaTransmissaoDAO {
	
    private Properties p;
    /**
     * Creates a new instance of OracleUltimaTransmissaoDAO
     */
    public OracleUltimaTransmissaoDAO() {
        p = new Properties();
        java.io.InputStream in =
                this.getClass().getResourceAsStream("/resources/ultimaTransmissaoDB.properties");
        
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
    public List<Transmissao> getUltimaTransmissaoPorDR(String dr)  throws DAOException {
        String sql = p.getProperty("ultima.transmissao.dr");
        sql = sql.replaceFirst("[?]", " " + dr + " ");
        System.out.println(sql);
        return getResult(sql);
    }
    
    /**
     * 
     * @param dr 
     * @param reop 
     * @throws br.com.correios.sromonitor.dao.DAOException 
     * @return 
     */
    public List<Transmissao> getUltimaTransmissaoPorDRReop(String dr, int reop) throws DAOException {
        String sql = p.getProperty("ultima.transmissao.dr.reop");
        sql = sql.replaceFirst("[?]", " " + dr + " ");
        sql = sql.replaceFirst("[?]", " " + reop + " ");
        System.out.println(sql);
        return getResult(sql);
    }
    
    /**
     * 
     * @param dr 
     * @param reop 
     * @param tipoUnidade 
     * @throws br.com.correios.sromonitor.dao.DAOException 
     * @return 
     */
    public List<Transmissao> getUltimaTransmissaoPorDRReopTipoUNidade(String dr, int reop, String tipoUnidade) throws DAOException {
        String sql = p.getProperty("ultima.transmissao.dr.reop.tipo.unidade");
        sql = sql.replaceFirst("[?]", " " + dr + " ");
        sql = sql.replaceFirst("[?]", " " + reop + " ");
        sql = sql.replaceFirst("[?]", " '" + tipoUnidade + "' ");
        
        return getResult(sql);
    }
    
    /**
     * 
     * @param dr 
     * @param tipoUnidade 
     * @throws br.com.correios.sromonitor.dao.DAOException 
     * @return 
     */
    public List<Transmissao> getUltimaTransmissaoPorDRTipoUNidade(String dr, String tipoUnidade) throws DAOException {
        String sql = p.getProperty("ultima.transmissao.dr.tipo.unidade");
        sql = sql.replaceFirst("[?]", " " + dr + " ");
        sql = sql.replaceFirst("[?]", " '" + tipoUnidade + "' ");
        System.out.println(sql);
        return getResult(sql);
    }

    private List<Transmissao> getResult(String sql) throws DAOException {
        List<Transmissao> result = new ArrayList<Transmissao>();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = DAOFactory.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            Transmissao ut = null;
            
            while ( rs.next() ) {
                ut = new Transmissao();
                ut.setCodigo(rs.getString("uni_cep"));
                ut.setData(new java.util.Date(rs.getTimestamp("utr_dh_transmissao").getTime()));
                ut.setEvento(rs.getString("et_eventtypecode"));
                ut.setNome(rs.getString("uni_name"));
                ut.setReop(rs.getInt("uni_reope"));
                ut.setTempo(rs.getString("tempo"));
                ut.setCodigoMCU(rs.getString("uni_code"));
                ut.setSistemaGerador(rs.getString("uni_name"));
                result.add(ut);
            }

        } catch (SQLException ex) {
            throw new DAOException(ex.getMessage());
        } finally {
            if ( rs != null ) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                }
            }
            
            if ( stmt != null ) {
                try {
                    stmt.close();
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
    
}
