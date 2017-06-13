/*
 * OraclePendenciaBaixaDAO.java
 *
 * Created on 19 de Outubro de 2006, 11:22
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package br.com.correios.sromonitor.dao;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.correios.sromonitor.vos.Concentrador;

/**
 *
 * @author jeans
 */
public class OracleCadastroConcentradorDAO {

    private Properties p;
    private String tipoParaComparacao = "";

    /** Creates a new instance of OraclePendenciaBaixaDAO */
    public OracleCadastroConcentradorDAO() {
        p = new Properties();
        java.io.InputStream in =
                this.getClass().getResourceAsStream("/resources/cadastroConcentradoresSRO_II.properties");

        if (in != null) {
            try {
                p.load(in);
            } catch (java.io.IOException ex) {
            }
        }
    }

    public List getCodigoSroUnidade(String codigoUnidade, boolean existeNasTablesUnitOrTecstream) throws DAOException {
        //String drConsulta = ""+dr;
        ArrayList result = new ArrayList();
        Connection con = null;
        PreparedStatement pstmt = null;
        String sql = "";
        if (existeNasTablesUnitOrTecstream) {
            sql = p.getProperty("cadastro.selecionacodigounidade.dr");
        } else {
            sql = p.getProperty("cadastro.selecionacodigounidadenatecstream.dr");
        }
        try {
            con = DAOFactory.getConnection();

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, codigoUnidade);
            ResultSet resultado = pstmt.executeQuery();
            while (resultado.next()) {
                if (existeNasTablesUnitOrTecstream) {
                    result.add(0, resultado.getString("CODIGOUNIDADE").toString());
                    result.add(1, resultado.getString("DR").toString());
                } else {
                    result.add(resultado.getString("CODIGOUNIDADE").toString());
                }

            }

            //result = getResult(pstmt);
        
        } catch (SQLException ex) {
            ex.printStackTrace();
            // result = Collections.emptyList();
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

    public List getConcentradoresDR(String dr, String codigoSroConcentrador) throws DAOException {
        //String drConsulta = ""+dr;
        String semInformacao = "Sem Informação!", ipCon = "", nomeCon = "", drCon = "";
        ArrayList result = new ArrayList();
        ArrayList concentradores = new ArrayList();
        Concentrador concentrador = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        String sql = p.getProperty("cadastro.selecionaconcentradores.dr");

        try {
            con = DAOFactory.getConnection();

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, dr);
            ResultSet resultado = pstmt.executeQuery();
            int index = 1;
            concentradores.add(0, "null");
            while (resultado.next()) {

                ipCon = resultado.getString("IP").toString();
                nomeCon = resultado.getString("NOME").toString();
                drCon = resultado.getString("DR").toString();

                concentrador = new Concentrador(resultado.getString("CODIGO").toString(), ipCon, nomeCon, nomeCon, drCon);
                if (!resultado.getString("CODIGO").toString().equalsIgnoreCase(codigoSroConcentrador)) {
                    concentradores.add(index, concentrador);
                    index++;
                } else {
                    concentradores.remove(0);
                    concentradores.add(0, concentrador);
                }

            }


        } catch (SQLException ex) {
            ex.printStackTrace();
            // result = Collections.emptyList();
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
                    System.out.println("erro ao fechar conexão");
                }
            }
        }


        return concentradores;

    }

    public List getConcentradoresDR(int drCodigo) throws DAOException{
        //String drConsulta = ""+dr;
        String semInformacao = "Sem Informação!", ipCon = "", nomeCon = "", drCon = "";
        ArrayList result = new ArrayList();
        ArrayList concentradores = new ArrayList();
        Concentrador concentrador = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        String sql = p.getProperty("cadastro.selecionaconcentradores.dr");
        String dr = ""+drCodigo;

        try {
            con = DAOFactory.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, dr.toString());
            ResultSet resultado = pstmt.executeQuery();
            int index = 0;
            //concentradores.add(0,"null");
            while (resultado.next()) {
                resultado.getString("IP");
                
                    ipCon = resultado.getString("IP").toString();
                
                
                    nomeCon = resultado.getString("NOME").toString();
                
                
                    drCon = resultado.getString("DR").toString();
                

                concentrador = new Concentrador(resultado.getString("CODIGO").toString(), ipCon, nomeCon, nomeCon, drCon);
                //if(!resultado.getString("CODIGO").toString().equalsIgnoreCase(codigoSroConcentrador)){
                concentradores.add(index, concentrador);
                index++;
//                }else{
//                    concentradores.remove(0);
//                    concentradores.add(0,concentrador);
//                }

            }

            //result = getResult(pstmt);

        } catch (SQLException ex) {
            ex.printStackTrace();
            // result = Collections.emptyList();
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
                    System.out.println("erro ao fechar conexão");
                }
            }
        }


        return concentradores;

    }

    public void getUpdateOrCadastraIpConcentrador(String ipConcentrador, String senhaRoot, String codigoUnidade, boolean updateOrCadastro) throws DAOException {
        Connection con = null;

        PreparedStatement pstmt = null;
        String sql = "";
        if (updateOrCadastro) {
            sql = p.getProperty("cadastro.updateconcentradorsro.dr");
        } else {
            sql = p.getProperty("cadastro.insertconcentradorsro.dr");
        }
        try {
            con = DAOFactory.getConnection();

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, senhaRoot);
            pstmt.setString(2, ipConcentrador);
            pstmt.setString(3, codigoUnidade);
            ResultSet resultado = pstmt.executeQuery();

            System.out.println("salvo :" + codigoUnidade);
            FacesContext.getCurrentInstance().addMessage("formSRO:erroCadastro_II", new FacesMessage("Concentrador cadastrado com sucesso!"));

        } catch (SQLException ex) {
            ex.printStackTrace();
            // result = Collections.emptyList();
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

    }

    private boolean comparaTipo(String tipoCompararNovo) {

        if (tipoCompararNovo.equalsIgnoreCase(tipoParaComparacao)) {
            tipoParaComparacao = tipoCompararNovo;
            return true;
        } else {
            tipoParaComparacao = tipoCompararNovo;
            return false;
        }
    }

    public static String pegaIpLocal() {
        String s = "";
        try {
            InetAddress in = InetAddress.getLocalHost();
            s = in.getHostAddress();

        } catch (Exception j) {
        }

        return s;
    }
}
