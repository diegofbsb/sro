/*
 * GerentePendenciaBaixa.java
 *
 * Created on 19 de Outubro de 2006, 10:21
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.correios.sromonitor.managers;

import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import br.com.correios.sromonitor.dao.DAOException;
import br.com.correios.sromonitor.dao.DAOFactory;
import br.com.correios.sromonitor.dao.DifusaoWebSROIIWebSphereDAO;
import br.com.correios.sromonitor.vos.DifusaoWebSROIIWebSphere;

/**
 * Facade para PendenciaBaixaDAO.
 * @author jeans
 */
public class GerenteDifusaoWebSROIIWebSphere {
    private DifusaoWebSROIIWebSphereDAO difusaoWebSROIIWebSphereDAO;
    /** Creates a new instance of GerentePendenciaBaixa */
    public GerenteDifusaoWebSROIIWebSphere() {
        difusaoWebSROIIWebSphereDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getDifusaoWebSROIIWebSphereDAO();
    }
    
    /**
     * Retorna uma lista de Unidades.
     
     * @param uniCep.
     * @return Lista de pend&ecirc;ncias.
     * @throws br.com.correios.sromonitor.managers.ManagementException Caso haja algum problema na obten&ccedil;&atilde;o dos resultados.
     */
    public boolean getUpdateUniRunningdateUnidade(String uniCep) throws ManagementException {
        boolean resultado = false;
    
        System.out.println("Código unidade: " + uniCep);
        
        if ( uniCep != null && !"".equals(uniCep) ) {
            try {
                resultado = difusaoWebSROIIWebSphereDAO.getUpdateUniRunningdateUnidade(uniCep);
            } catch (DAOException ex) {
                ex.printStackTrace();
                throwError();
            }
             System.out.println("result if 1 "+resultado);
        }else{
             
            throw new IllegalArgumentException("Código unidade tem de ser diferente de null.");
        }
        
      
        return resultado;
    }
    
    /**
     * Retorna uma lista de Unidades.
     
     * @param uniName.
     * @return Lista de pend&ecirc;ncias.
     * @throws br.com.correios.sromonitor.managers.ManagementException Caso haja algum problema na obten&ccedil;&atilde;o dos resultados.
     */
    public List<DifusaoWebSROIIWebSphere> getUnidades(String uniName) throws ManagementException {
        List<DifusaoWebSROIIWebSphere> result = null;
    
        
        if ( uniName != null && !"".equals(uniName) ) {
            try {
                result = difusaoWebSROIIWebSphereDAO.getUnidades(uniName);
            } catch (DAOException ex) {
                ex.printStackTrace();
                throwError();
            }
             
        } else if( uniName == null || "".equals(uniName)){
            try {
                result = result = Collections.emptyList();
            }catch(Exception ex){
                ex.printStackTrace();
                throwError();
            }

        }else{
               
            throw new IllegalArgumentException("Nome da unidade tem de ser diferente de null.");
        }
        
        if ( result == null ) {
            result = Collections.emptyList();
               
        }
        
        return result;
    }
    
    public List<DifusaoWebSROIIWebSphere> getUnidadesCodigo(String codigo) throws ManagementException {
        List<DifusaoWebSROIIWebSphere> result = null;
    
        if ( codigo != null && !"".equals(codigo) ) {
            try {
                result = difusaoWebSROIIWebSphereDAO.getUnidadesCodigo(codigo);
            } catch (DAOException ex) {
                ex.printStackTrace();
                throwError();
            }
            
        } else if( codigo == null || "".equals(codigo)){
            try {
                result = result = Collections.emptyList();
            }catch(Exception ex){
                ex.printStackTrace();
                throwError();
            }

        }else{
             
            throw new IllegalArgumentException("Nome da unidade tem de ser diferente de null.");
        }
        
        if ( result == null ) {
            result = Collections.emptyList();
               
        }
        
        return result;
    }
    
    private void throwError() throws ManagementException {
        ResourceBundle b = ResourceBundle.getBundle("resources.messages");
        throw new ManagementException(b.getString("db.error"));
    }
    
    
}
