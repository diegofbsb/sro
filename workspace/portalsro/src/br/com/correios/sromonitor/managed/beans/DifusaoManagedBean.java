/*
 * MonitorManagedBean.java
 *
 * Created on 13 de Novembro de 2006, 08:58
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.correios.sromonitor.managed.beans;

/**
 *
 * @author jeans
 */
public abstract class DifusaoManagedBean extends AbstractManagedBean {
    
 
   
    private String uniCep;
    private String uniName;
    
    /** Creates a new instance of MonitorManagedBean */
    public DifusaoManagedBean() {
    }

    public String getUniCep() {
        return uniCep;
    }

    public void setUniCep(String uniCep) {
        this.uniCep = uniCep;
    }

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

}
