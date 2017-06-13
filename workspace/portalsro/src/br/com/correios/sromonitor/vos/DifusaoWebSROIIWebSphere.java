/*
 * PendenciaBaixa.java
 *
 * Created on 28 de Setembro de 2006, 15:18
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.correios.sromonitor.vos;

/**
 * VO para as pend&ecirc;ncias de baixa.
 * @author jeans
 */
public class DifusaoWebSROIIWebSphere implements java.io.Serializable {
    private String codigo;
    private String nome;
    /** Creates a new instance of PendenciaBaixa */
    public DifusaoWebSROIIWebSphere() {
    }

    /**
     * Retorna o c&oacute;digo da unidade.
     * @return O c&oacute;digo da unidade.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Define o c&oacute;digo da unidade.
     * @param codigo Novo c&oacute;digo da unidade.
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Retorna o nome da unidade.
     * @return O nome da unidade.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da unidade.
     * @param nome Novo nome da unidade.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
