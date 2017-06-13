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
import java.util.List;
import java.util.Properties;

import br.com.correios.sromonitor.vos.DifusaoWebSROIIWebSphere;

/**
 *
 * @author jeans
 */
public class OracleDifusaoWebSROIIWebSphereDAO implements DifusaoWebSROIIWebSphereDAO {
    
    private Properties p;
    
    /** Creates a new instance of OraclePendenciaBaixaDAO */
    public OracleDifusaoWebSROIIWebSphereDAO() {
        p = new Properties();
        java.io.InputStream in =
                this.getClass().getResourceAsStream("/resources/difusaoWebSroii.properties");
        
        if( in != null ) {
            try {
                p.load(in);
            } catch( java.io.IOException ex ) {
                
            }
        }
    }
    
        /**
     * 
     * @param uniCep 
     * @throws br.com.correios.sromonitor.dao.DAOException 
     * @return 
     */
    public boolean getUpdateUniRunningdateUnidade(String uniCep) throws DAOException {
        Connection con = null;
        PreparedStatement pstmt = null;
        String sql = p.getProperty("difusao.web.sroii.was");
        boolean resultado = false;
        try {
            con = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getConnection();
            System.out.println("Conexão "+con.toString());
            System.out.println("SQl "+sql);
            if ( uniCep == null || "".equals(uniCep.trim())) {
                resultado = false;
            } else {
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, uniCep.trim());
                int retorno = pstmt.executeUpdate();
                if(retorno >= 1){
                resultado = true;
                }else{
                 resultado = false;
                }
            }
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
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
        
        
        return resultado;
    }
    
    /**
     * 
     * @param uniName 
     * @throws br.com.correios.sromonitor.dao.DAOException 
     * @return 
     */
    public List<DifusaoWebSROIIWebSphere> getUnidades(String uniName) throws DAOException {
        List<DifusaoWebSROIIWebSphere> result = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DAOFactory.getConnection();
            
            String sql = p.getProperty("lista.unidades.por.nome");
            if ( uniName == null || "".equals(uniName.trim())) {
                result = Collections.emptyList();
            } else {
                
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, '%'+ uniName + '%');
            }
                        
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
    
        public List<DifusaoWebSROIIWebSphere> getUnidadesCodigo(String codigo) throws DAOException {
        List<DifusaoWebSROIIWebSphere> result = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DAOFactory.getConnection();
            
            String sql = p.getProperty("lista.unidades.por.codigo");
            if ( codigo == null || "".equals(codigo)) {
                result = Collections.emptyList();
                
            } else {
                
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, codigo);
                
            }
                        
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
    
    private List<DifusaoWebSROIIWebSphere> getResult(PreparedStatement pstmt) throws SQLException {
        List<DifusaoWebSROIIWebSphere> result = new ArrayList<DifusaoWebSROIIWebSphere>();
        ResultSet rs = null;
        try {
            rs = pstmt.executeQuery();
            DifusaoWebSROIIWebSphere unidade = null;
            while ( rs.next() ) {
                unidade = new DifusaoWebSROIIWebSphere();
                unidade.setCodigo(rs.getString("uni_cep"));
                unidade.setNome(rs.getString("uni_name"));
                result.add(unidade);
            }
        } finally {
            if ( rs != null ) {
                rs.close();
            }
        }
        
        return result;
    }
    
}
