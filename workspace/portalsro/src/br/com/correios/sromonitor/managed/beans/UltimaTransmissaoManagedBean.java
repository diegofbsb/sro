/*
 * UltimaTransmissaoManagedBean.java
 *
 * Created on 30 de Agosto de 2006, 16:08
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.correios.sromonitor.managed.beans;

import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.correios.sromonitor.managers.GerenteUltimaTransmissao;
import br.com.correios.sromonitor.managers.ManagementException;
import br.com.correios.sromonitor.vos.Transmissao;

/**
 * ManagedBean para a &uacute;ltima transmiss&atilde;o de cada unidade.
 * @author Jean Clay Souza da Silva - Analista POLITEC - DESUN/DSGL
 */
public class UltimaTransmissaoManagedBean extends MonitorManagedBean {
    
    private List<Transmissao> transmissoes;
    private GerenteUltimaTransmissao gerente;
    /** Creates a new instance of UltimaTransmissaoManagedBean */
    public UltimaTransmissaoManagedBean() {
        
        gerente = new GerenteUltimaTransmissao();
        
    }
    
    
    /**
     *
     * @return
     */
    public String pesquisar() {
        
        if ( getDr() != null ) {
            try {
                transmissoes = gerente.getUltimaTransmissao(getDr(), getReop(), getTipoUnidade());
                if ( transmissoes == null || transmissoes.size() == 0 ) {
                    setRendered(false);
                    ResourceBundle b = ResourceBundle.getBundle("resources.messages");
                    setMessage(b.getString("no.result"), FacesMessage.SEVERITY_INFO);
                } else {
                    Collections.sort(transmissoes, new ComparaTempoData());
                    setRendered(true);
                }
                return AbstractManagedBean.SUCCESS;
            } catch (ManagementException ex) {
                this.setMessage(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
                ex.printStackTrace();
            }
        }
        return AbstractManagedBean.ERROR;
    }
    
    /**
     *
     * @return
     */
    public List<Transmissao> getTransmissoes() {
        return transmissoes;
    }
    
    private class ComparaTempoData implements Comparator<Transmissao> {
        /**
         * Compares its two arguments for order.  Returns a negative integer,
         * zero, or a positive integer as the first argument is less than, equal
         * to, or greater than the second.<p>
         *
         * The implementor must ensure that <tt>sgn(compare(x, y)) ==
         * -sgn(compare(y, x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
         * implies that <tt>compare(x, y)</tt> must throw an exception if and only
         * if <tt>compare(y, x)</tt> throws an exception.)<p>
         *
         * The implementor must also ensure that the relation is transitive:
         * <tt>((compare(x, y)&gt;0) &amp;&amp; (compare(y, z)&gt;0))</tt> implies
         * <tt>compare(x, z)&gt;0</tt>.<p>
         *
         * Finally, the implementer must ensure that <tt>compare(x, y)==0</tt>
         * implies that <tt>sgn(compare(x, z))==sgn(compare(y, z))</tt> for all
         * <tt>z</tt>.<p>
         *
         * It is generally the case, but <i>not</i> strictly required that
         * <tt>(compare(x, y)==0) == (x.equals(y))</tt>.  Generally speaking,
         * any comparator that violates this condition should clearly indicate
         * this fact.  The recommended language is "Note: this comparator
         * imposes orderings that are inconsistent with equals."
         *
         *
         * @param o1 the first object to be compared.
         * @param o2 the second object to be compared.
         * @return a negative integer, zero, or a positive integer as the
         * 	       first argument is less than, equal to, or greater than the
         * 	       second.
         * @throws ClassCastException if the arguments' types prevent them from
         * 	       being compared by this Comparator.
         */
        public int compare(Transmissao o1, Transmissao o2) {
            
            
            Collator c = Collator.getInstance(
                    FacesContext.getCurrentInstance()
                    .getApplication().getDefaultLocale());
            
            int result = c.compare(o2.getTempo(), o1.getTempo());
            
            if ( result == 0 ) {
                result = o2.getData().compareTo(o1.getData());
            }
            
            return result;
        }
        
    }
    
}
