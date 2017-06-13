/*
 * OracleArquivoRepetidoDAO.java
 *
 * Created on 29 de Maio de 2007, 15:57
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

import br.com.correios.sromonitor.vos.ArquivoRepetido;

/**
 *
 * @author jeans
 */
public class OracleArquivoRepetidoDAO implements ArquivoRepetidoDAO {
	
    private Properties p;
    
    /** Creates a new instance of OracleArquivoRepetidoDAO */
    public OracleArquivoRepetidoDAO() {
        p = new Properties();
        java.io.InputStream in =
                this.getClass().getResourceAsStream("/resources/trasmissaoRepetidos.properties");
        
        if( in != null ) {
            try {
                p.load(in);
            } catch( java.io.IOException ex ) {
                ex.printStackTrace();
            }
        }
    }
    
    public Collection<ArquivoRepetido> getArquivosRepetidos(String dr) throws DAOException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Collection<ArquivoRepetido> c = new ArrayList<ArquivoRepetido>();
        System.out.println("DR: " + dr);
        try {
            
            con = DAOFactory.getConnection();
            pstmt = con.prepareStatement(p.getProperty("sql"));
            pstmt.setString(1, dr);
            
            rs = pstmt.executeQuery();
            
            while ( rs.next() ) {
                ArquivoRepetido a = new ArquivoRepetido();
                a.setCodigoUnidade(rs.getString("ctr_unicep"));
                a.setDr(rs.getString("rd_acronym"));
                a.setNomeArquivo(rs.getString("ctr_namefile"));
                a.setQuantidade(rs.getInt("qtd"));
                a.setUnidade(rs.getString("uni_name"));
                c.add(a);
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
