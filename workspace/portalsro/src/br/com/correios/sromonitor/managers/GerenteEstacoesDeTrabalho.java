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
import br.com.correios.sromonitor.dao.EstacoesDeTrabalhoDAO;
import br.com.correios.sromonitor.dao.PendenciaBaixaDAO;
import br.com.correios.sromonitor.vos.DetalheEstacoesDeTrabalho;
import br.com.correios.sromonitor.vos.EstacoesDeTrabalho;

/**
 * Facade para PendenciaBaixaDAO.
 * @author jeans
 */
public class GerenteEstacoesDeTrabalho {
    private EstacoesDeTrabalhoDAO estacoesDeTrabalhoDAO;
    /** Creates a new instance of GerentePendenciaBaixa */
    public GerenteEstacoesDeTrabalho() {
    	estacoesDeTrabalhoDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getEstacoesDeTrabalhoDAO();
    }
    
    
    
    /**
     * Retorna uma lista de pend&ecirc;ncias.
     * @param dr DR
     * @param reop REOP
     * @param tipoUnidade Tipo de unidade.
     * @return Lista de pend&ecirc;ncias.
     * @throws br.com.correios.sromonitor.managers.ManagementException Caso haja algum problema na obten&ccedil;&atilde;o dos resultados.
     */
    public List<EstacoesDeTrabalho> getEstacoesDeTrabalho(String dr, String tipoUnidade, String uniName, String uniVersao, String tipoEstacao) throws ManagementException {
        List<EstacoesDeTrabalho> result = null;
        
        System.out.println("DR: " + dr + ", Tipo Unidade: " + tipoUnidade + "  uniName: " + uniName + " uniVersao: " + uniVersao + "  tipoEstacao: " + tipoEstacao);
        
        if ( dr != null ) {
            try {
                result = estacoesDeTrabalhoDAO.getEstacoesDeTrabalhoPorDRTipoUNidadeNomeUnidade(dr, tipoUnidade, uniName, uniVersao, tipoEstacao) ;
            } catch (DAOException ex) {
                ex.printStackTrace();
                throwError();
            }
                System.out.println("result if 1 "+result + " "+result.size());
        }  else {
                System.out.println("result if 5 "+result + " "+result.size());
            throw new IllegalArgumentException("DR tem de ser diferente de null.");
        }
        
        if ( result == null ) {
            result = Collections.emptyList();
                System.out.println("result if 6 "+result.size());
        }
        
        System.out.println(result);

        return result;
    }
    
    private void throwError() throws ManagementException {
        ResourceBundle b = ResourceBundle.getBundle("resources.messages");
        throw new ManagementException(b.getString("db.error"));
    }
    
    public List<DetalheEstacoesDeTrabalho> getDetalhes(String codigoUnidade) throws ManagementException  {
        List<DetalheEstacoesDeTrabalho> result = null;
        try {
            result = estacoesDeTrabalhoDAO.getDetalhe(codigoUnidade);
        } catch (DAOException ex) {
            throwError();
        }
        
        return result;
    }
    
}
