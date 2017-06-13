/*
 * OracleObjetoIrregularDAO.java
 *
 * Created on 12 de Julho de 2007, 14:45
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
import java.util.Collection;
import java.util.Properties;

import br.com.correios.sromonitor.vos.ObjetoIrregular;

/**
 *
 * @author Jean Clay Souza da Silva - Analista - DESUN/DSGL/CRO
 */
public class OracleObjetoIrregularDAO implements ObjetoIrregularDAO {
	
    private Properties p;
    
    /** Creates a new instance of OracleObjetoIrregularDAO */
    public OracleObjetoIrregularDAO() {
        p = new Properties();
        java.io.InputStream in = this.getClass().getResourceAsStream(
                "/resources/objetosIrregulares.properties");
        
        if( in != null ) {
            try {
                p.load(in);
            } catch( java.io.IOException ex ) {
                ex.printStackTrace();
            }
        }
    }
    
    public Collection<ObjetoIrregular> getObjetosIrregulares(String dr) throws
            DAOException {
        
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Collection<ObjetoIrregular> c = new ArrayList<ObjetoIrregular>();
        System.out.println("DR: " + dr);
        try {
            
            con = DAOFactory.getConnection();
            pstmt = con.prepareStatement(p.getProperty("sql"));
            pstmt.setString(1, dr);
            
            rs = pstmt.executeQuery();
            ObjetoIrregular o = null;
            while ( rs.next() ) {
                o = new ObjetoIrregular();
                o.setCodigoUnidade(rs.getString("evt_hitunitcep"));
                o.setDataCriacao(new java.util.Date(
                        rs.getTimestamp("evt_createtime").getTime()));
                o.setEtiqueta(rs.getString("evt_itemcode"));
                o.setEvento(rs.getString("evt_code"));
                o.setUnidade(rs.getString("uni_name"));
                c.add(o);
            }
        
        } catch (SQLException ex) {
            ex.printStackTrace();
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
        
        return c;
    }
    
}
