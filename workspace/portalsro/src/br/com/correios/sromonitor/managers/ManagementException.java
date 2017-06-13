/*
 * ManagementException.java
 *
 * Created on 28 de Setembro de 2006, 09:07
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.correios.sromonitor.managers;

/**
 * Utilizada para informar problemas de obten&ccedil;&atilde;o de dados de consulta<br/>
 * a partir de um DAO.
 * @author Jean Clay Souza da Silva - Analista POLITEC - DESUN/DSGL
 */
public class ManagementException extends java.lang.Exception {
    
    /**
     * Creates a new instance of <code>ManagementException</code> without detail message.
     */
    public ManagementException() {
    }
    
    
    /**
     * Constructs an instance of <code>ManagementException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public ManagementException(String msg) {
        super(msg);
    }
}
