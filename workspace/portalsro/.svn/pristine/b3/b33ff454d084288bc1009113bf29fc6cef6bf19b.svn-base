/*
 * GerenteObjetoIrregular.java
 *
 * Created on 12 de Julho de 2007, 15:04
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.correios.sromonitor.managers;

import java.util.Collection;
import java.util.Collections;
import java.util.ResourceBundle;

import br.com.correios.sromonitor.dao.DAOException;
import br.com.correios.sromonitor.dao.DAOFactory;
import br.com.correios.sromonitor.dao.ObjetoIrregularDAO;
import br.com.correios.sromonitor.vos.ObjetoIrregular;

/**
 *
 * @author Jean Clay Souza da Silva - Analista - DESUN/DSGL/CRO
 */
public class GerenteObjetoIrregular {
    
    /** Creates a new instance of GerenteObjetoIrregular */
    public GerenteObjetoIrregular() {
        dao = DAOFactory.getDAOFactory(DAOFactory.ORACLE).
                getObjetoIrregularDAO();
    }
    
    private ObjetoIrregularDAO dao;
    
    private void throwError() throws ManagementException {
        ResourceBundle b = ResourceBundle.getBundle("resources.messages");
        throw new ManagementException(b.getString("db.error"));
    }
    
    public Collection<ObjetoIrregular> getObjetosIrregulares(String dr) throws 
            ManagementException {
        
        Collection<ObjetoIrregular> result = Collections.emptyList();
        try {
            result = dao.getObjetosIrregulares(dr);
        } catch (DAOException ex) {
            ex.printStackTrace();
            throwError();
        }
        return result;
    }
    
}
