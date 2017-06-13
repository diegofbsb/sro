/*
 * GerenteArquivoRepetido.java
 *
 * Created on 29 de Maio de 2007, 16:10
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.correios.sromonitor.managers;

import java.util.Collection;
import java.util.Collections;
import java.util.ResourceBundle;

import br.com.correios.sromonitor.dao.ArquivoRepetidoDAO;
import br.com.correios.sromonitor.dao.DAOException;
import br.com.correios.sromonitor.dao.DAOFactory;
import br.com.correios.sromonitor.vos.ArquivoRepetido;

/**
 *
 * @author jeans
 */
public class GerenteArquivoRepetido {
    private ArquivoRepetidoDAO dao;
    /** Creates a new instance of GerenteArquivoRepetido */
    public GerenteArquivoRepetido() {
        dao = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getArquivoRepetidoDAO();
    }
    
    private void throwError() throws ManagementException {
        ResourceBundle b = ResourceBundle.getBundle("resources.messages");
        throw new ManagementException(b.getString("db.error"));
    }
    
    public Collection<ArquivoRepetido> getArquivosRepetidos(String dr) throws ManagementException {
        Collection<ArquivoRepetido> result = Collections.emptyList();
        try {
            result = dao.getArquivosRepetidos(dr);
        } catch (DAOException ex) {
            ex.printStackTrace();
            throwError();
        }
        return result;
    }
    
}
