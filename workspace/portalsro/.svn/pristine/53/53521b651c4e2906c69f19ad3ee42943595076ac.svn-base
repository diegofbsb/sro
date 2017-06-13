/*
 * OracleControleTransmissaoDAO.java
 *
 * Created on 8 de Setembro de 2006, 16:01
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
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import br.com.correios.sromonitor.vos.ControleTransmissao;


/**
 *
 * @author Jean Clay Souza da Silva - Analista POLITEC - DESUN/DSGL
 */
public class OracleControleTransmissaoDAO implements ControleTransmissaoDAO {
    Properties p;
    /** Creates a new instance of OracleControleTransmissaoDAO */
    public OracleControleTransmissaoDAO() {
        
        p = new Properties();
        java.io.InputStream in =
                this.getClass().getResourceAsStream("/resources/controleTransmissaoDB.properties");
        
        if( in != null ) {
            try {
                p.load(in);
            } catch( java.io.IOException ex ) {
                
            }
        }
    }
    
    /**
     *
     * @param codigoUnidade
     * @param startDate
     * @param endDate
     * @throws br.com.correios.sromonitor.dao.DAOException
     * @return
     */
    public List<ControleTransmissao> getTransmissoes(String codigoUnidade, Date startDate, Date endDate) throws DAOException {
        List<ControleTransmissao> result = new ArrayList<ControleTransmissao>();
        
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Calendar start = Calendar.getInstance();
        start.setTime(startDate);
        start.set(Calendar.HOUR_OF_DAY, 0);
        start.set(Calendar.MINUTE, 0);
        start.set(Calendar.SECOND, 0);
        start.set(Calendar.MILLISECOND, 0);
        Calendar end = Calendar.getInstance();
        end.setTime(endDate);
        end.set(Calendar.HOUR_OF_DAY, 0);
        end.set(Calendar.MINUTE, 0);
        end.set(Calendar.SECOND, 0);
        end.set(Calendar.MILLISECOND, 0);
        end.add(Calendar.DAY_OF_MONTH, 1);
        ControleTransmissao controle = null;
        System.out.println("Código Unidade: " + codigoUnidade);
        System.out.println("Start Date: " + start.getTime());
        System.out.println("End Date: " + end.getTime());
        try {
            
            con = DAOFactory.getConnection();
            pstmt = con.prepareStatement(p.getProperty("sql"));
            pstmt.setString(1, codigoUnidade);
            pstmt.setTimestamp(2, new java.sql.Timestamp(start.getTime().getTime()));
            pstmt.setTimestamp(3, new java.sql.Timestamp(end.getTime().getTime()));
            
            rs = pstmt.executeQuery();
            
            while ( rs.next() ) {
                controle = new ControleTransmissao();
                controle.setEvento(rs.getString("con_no_arquivo"));
                controle.setGravado(new Date(rs.getTimestamp("con_dh_tratado").getTime()));
                controle.setNomeArquivo(rs.getString("tar_no_arquivo"));
                controle.setRegistros(rs.getInt("con_qt_registro"));
                controle.setRejeitados(rs.getInt("con_qt_rejeitado"));
                controle.setTransmitido(new Date(rs.getTimestamp("con_dh_disponivel").getTime()));
                result.add(controle);
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
        
        return result;
    }
    
    public String getNomeUnidade(String codigoUnidade) throws DAOException {
        String nomeUnidade = null;
        
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            
            con = DAOFactory.getConnection();
            pstmt = con.prepareStatement(p.getProperty("nome.unidade"));
            pstmt.setString(1, codigoUnidade);
            rs = pstmt.executeQuery();
            
            if ( rs.next() ) {
                nomeUnidade = rs.getString("uni_name");
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DAOException(ex.getMessage());
        } finally {
            
            if ( rs != null ) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            
            if ( pstmt != null ) {
                try {
                    pstmt.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            
            if ( con != null ) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        
        return nomeUnidade;
    }
    
}
