/*
 * PendenciaBaixaManagedBean.java
 *
 * Created on 26 de Setembro de 2006, 11:18
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.correios.sromonitor.managed.beans;

import java.io.IOException;
import java.net.ConnectException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.com.correios.sromonitor.dao.DAOException;
import br.com.correios.sromonitor.dao.OracleCadastroConcentradorDAO;
import br.com.correios.sromonitor.managers.ManagementException;
import br.com.correios.sromonitor.vos.Concentrador;
import br.com.correios.sromonitor.vos.PendenciaBaixa;

/**
 * ManagedBean para a pend&ecirc;ncia de baixa.
 * @author Jean Clay Souza da Silva - Analista POLITEC - DESUN/DSGL
 */
public class ConcentradorManagedBean  extends AbstractManagedBean {
    
    private String siglaDR;
    private int dr = 0;
    private String codigoSroUnidade;
    private String ipConcentrador;
    private String senhaRootConcentrador;
    private String senhaConfirmaRootConcentrador;
    private boolean mostraSelectCampos = false;
    private boolean mostraSelectBotao = false;
    private List listaCodigoSro = null;
    private List arrayConcentradores = new ArrayList();
    private Concentrador editorConcentrador = null;
        
     
    
    /**
     * Creates a new instance of PendenciaBaixaManagedBean
     */
    public ConcentradorManagedBean() {

        setRendered(false);
    }

    
    /**
     * @return the mostraSelectReops
     */
    public boolean isMostraSelectReops() {
        return isMostraSelectCampos();
    }

    /**
     * @param mostraSelectReops the mostraSelectReops to set
     */
    public void setMostraSelectReops(boolean mostraSelectReops) {
        this.setMostraSelectCampos(mostraSelectReops);
    }


    
    @Override
    public List<?> getTransmissoes() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @return the mostraSelectCampos
     */
    public boolean isMostraSelectCampos() {
        return mostraSelectCampos;
    }

    /**
     * @param mostraSelectCampos the mostraSelectCampos to set
     */
    public void setMostraSelectCampos(boolean mostraSelectCampos) {
        this.mostraSelectCampos = mostraSelectCampos;
    }

    /**
     * @return the mostraSelectBotao
     */
    public boolean isMostraSelectBotao() {
        return mostraSelectBotao;
    }

    /**
     * @param mostraSelectBotao the mostraSelectBotao to set
     */
    public void setMostraSelectBotao(boolean mostraSelectBotao) {
        this.mostraSelectBotao = mostraSelectBotao;
    }

    /**
     * @return the codigoSroUnidade
     */
    public String getCodigoSroUnidade() {
        return codigoSroUnidade;
    }

    /**
     * @param codigoSroUnidade the codigoSroUnidade to set
     */
//
    public void setCodigoSroUnidade(String codigoSroUnidade) {
        this.codigoSroUnidade = codigoSroUnidade;
    }



    /**
     * @return the ipConcentrador
     */
    public String getIpConcentrador() {
        return ipConcentrador;
    }

    /**
     * @param ipConcentrador the ipConcentrador to set
     */
    public void setIpConcentrador(String ipConcentrador) {
        this.ipConcentrador = ipConcentrador;
    }

    /**
     * @return the senhaRootConcentrador
     */
    public String getSenhaRootConcentrador() {
        return senhaRootConcentrador;
    }

    /**
     * @param senhaRootConcentrador the senhaRootConcentrador to set
     */
    public void setSenhaRootConcentrador(String senhaRootConcentrador) {
        this.senhaRootConcentrador = senhaRootConcentrador;
    }

    /**
     * @return the senhaConfirmaRootConcentrador
     */
    public String getSenhaConfirmaRootConcentrador() {
        return senhaConfirmaRootConcentrador;
    }

    /**
     * @param senhaConfirmaRootConcentrador the senhaConfirmaRootConcentrador to set
     */
    public void setSenhaConfirmaRootConcentrador(String senhaConfirmaRootConcentrador) {
        this.senhaConfirmaRootConcentrador = senhaConfirmaRootConcentrador;
    }

    @Override
    public String pesquisar() {
        try {
            habilitaCamposDR();
        } catch (ConnectException ex) {
            ex.printStackTrace();
        }
        return null;//throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @return the arrayConcentradores
     */
    public List getArrayConcentradores() {
        return arrayConcentradores;
    }

    /**
     * @param arrayConcentradores the arrayConcentradores to set
     */
    public void setArrayConcentradores(List arrayConcentradores) {
        this.arrayConcentradores = arrayConcentradores;
    }

    /**
     * @return the editorConcentrador
     */
    public Concentrador getEditorConcentrador() {
        return editorConcentrador;
    }

    /**
     * @param editorConcentrador the editorConcentrador to set
     */
    public void setEditorConcentrador(Concentrador editorConcentrador) {
        this.editorConcentrador = editorConcentrador;
    }

    /**
     * @return the siglaDR
     */
    public String getSiglaDR() {
        return siglaDR;
    }

    /**
     * @param siglaDR the siglaDR to set
     */
    public void setSiglaDR(String selectDR) {
        this.siglaDR = selectDR;
    }

   
    private class ComparaQuantidadeNome implements Comparator<PendenciaBaixa> {
        
        public int compare(PendenciaBaixa o1, PendenciaBaixa o2) {
            
            
            Collator c = Collator.getInstance(
                    FacesContext.getCurrentInstance()
                    .getApplication().getDefaultLocale());
            
            return c.compare(o1.getNome(), o2.getNome());
        }
        
    }

    public String getUniName() {
        return getIpConcentrador();
    }

    public void setUniName(String uniName) {
        this.setIpConcentrador(uniName);
    }

    public void habilitaCampos() throws ConnectException {
        if(testaCadastroUnidade()){
            setMostraSelectBotao(true);
            setMostraSelectCampos(true);
            setRendered(true);
        }else{
            FacesContext.getCurrentInstance().addMessage("formSRO:textCodigoSroUnidade", new FacesMessage("Unidade inválida ou não cadastrada como SRO II!"));
            setMostraSelectBotao(false);
            setMostraSelectCampos(false);
            setRendered(false);
        }
    }

    public void habilitaCamposDR() throws ConnectException {
        if(getDr() > 0 && selecionaConcentradoresDr()){
            setMostraSelectBotao(true);
            setMostraSelectCampos(true);
            setRendered(true);
        }else{
            FacesContext.getCurrentInstance().addMessage("formSRO:textCodigoSroUnidade", new FacesMessage("Não existe DR ou Unidades cadastrada como SRO II!"));
            setMostraSelectBotao(false);
            setMostraSelectCampos(false);
            setRendered(false);
        }
    }

    /** Creates a new instance of SelectItemsDR */
    public boolean testaCadastroUnidade() throws ConnectException {
//      new SelectItem[codigos.length];
        boolean testeExisteUnidade = false;
        OracleCadastroConcentradorDAO consulta = new OracleCadastroConcentradorDAO();
        System.out.println("dr selecionada " + getSiglaDR());
        listaCodigoSro = new ArrayList();
        //setArrayConcentradores(new ArrayList());
        try {
            listaCodigoSro = consulta.getCodigoSroUnidade(getCodigoSroUnidade(), true);
            for(int i = 0; i < listaCodigoSro.size();i++){
               if(getCodigoSroUnidade().equalsIgnoreCase(listaCodigoSro.get(i).toString())){
                  testeExisteUnidade = true;
                  setMostraSelectBotao(true);

                    setArrayConcentradores(consulta.getConcentradoresDR(listaCodigoSro.get(1).toString().trim(), codigoSroUnidade));
                    
                  break;
               }
            }

        } catch (DAOException ex) {
            Logger.getLogger(OracleCadastroConcentradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return testeExisteUnidade;
    }

    public boolean selecionaConcentradoresDr() throws ConnectException {
//      new SelectItem[codigos.length];
        boolean selecionaConcentradores = false;
        OracleCadastroConcentradorDAO consulta = new OracleCadastroConcentradorDAO();
        System.out.println("dr selecionada " + getDr());
//        listaCodigoSro = new ArrayList();
//        //setArrayConcentradores(new ArrayList());
//        try {
//            listaCodigoSro = consulta.getCodigoSroUnidade(getCodigoSroUnidade(), true);
//            for(int i = 0; i < listaCodigoSro.size();i++){
//               if(getCodigoSroUnidade().equalsIgnoreCase(listaCodigoSro.get(i).toString())){
                 
        try {
            setArrayConcentradores(consulta.getConcentradoresDR(getDr()));
             selecionaConcentradores = true;
             setMostraSelectBotao(true);
            //                  break;
            //               }
            //            }
        } catch (DAOException ex) {
            Logger.getLogger(ConcentradorManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }

//                  break;
//               }
//            }


        return selecionaConcentradores;
    }

    public void salvarInformacoesConcentrador() throws DAOException, ManagementException, ConnectException {
        //testaCadastroUnidade();
        boolean testeExisteUnidadeTecstream = testaCadastroUnidade();
        OracleCadastroConcentradorDAO consulta = new OracleCadastroConcentradorDAO();
        List listaReops = new ArrayList();
         boolean validaIp = validaIp();
         boolean validaSenhas = validaSenhas();
         boolean validaCodigoSro = validaCodigoSro();

        try {
            listaReops = consulta.getCodigoSroUnidade(getCodigoSroUnidade(), false);
            for(int i = 0; i < listaReops.size();i++){
               if(getCodigoSroUnidade().equalsIgnoreCase(listaReops.get(i).toString())){
                  testeExisteUnidadeTecstream = true;
                  break;
               }
            }

        } catch (DAOException ex) {
            Logger.getLogger(OracleCadastroConcentradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
//         boolean validaIp = validaIp();
//         boolean validaSenhas = validaSenhas();
//         boolean validaCodigoSro = validaCodigoSro();
         
         if(testeExisteUnidadeTecstream && validaIp && validaSenhas && validaCodigoSro){
            consulta.getUpdateOrCadastraIpConcentrador(ipConcentrador, senhaRootConcentrador, codigoSroUnidade, true);
         }else if(!testeExisteUnidadeTecstream && validaIp && validaSenhas && validaCodigoSro){
            consulta.getUpdateOrCadastraIpConcentrador(ipConcentrador, senhaRootConcentrador, codigoSroUnidade, false);
         }
         getArrayConcentradores().clear();
         setArrayConcentradores(consulta.getConcentradoresDR(listaCodigoSro.get(1).toString().trim(), codigoSroUnidade));
    }

    public void editaInformacoesConcentrador() throws DAOException, ManagementException, ConnectException {
        boolean testeExisteUnidadeTecstream = false;
        OracleCadastroConcentradorDAO consulta = new OracleCadastroConcentradorDAO();
        List listaReops = new ArrayList();
        setCodigoSroUnidade(editorConcentrador.getCodigo());
        setIpConcentrador(editorConcentrador.getIp());
        setSenhaRootConcentrador(editorConcentrador.getNome());
        setSenhaConfirmaRootConcentrador(editorConcentrador.getNome());

       boolean validaIp = validaIp();
       boolean validaSenhas = validaSenhas();
       boolean validaCodigoSro = validaCodigoSro();

        System.out.println(codigoSroUnidade + editorConcentrador.getCodigo()+editorConcentrador.getIp()+editorConcentrador.getNome());
        try {
            listaReops = consulta.getCodigoSroUnidade(getCodigoSroUnidade(), false);
            if(!listaReops.isEmpty()){
            for(int i = 0; i < listaReops.size();i++){
               if(getCodigoSroUnidade().equalsIgnoreCase(listaReops.get(i).toString())){
                  testeExisteUnidadeTecstream = true;
                  break;
               }
            }
            }else{
                FacesContext.getCurrentInstance().addMessage("formSRO:textCodigoSroUnidade", new FacesMessage("Unidade inválida ou não cadastrada como SRO II!"));
            }

        } catch (DAOException ex) {
            Logger.getLogger(OracleCadastroConcentradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
//
        if (listaReops.isEmpty()){
            validaIp = validaIp();
            validaSenhas = validaSenhas();
            validaCodigoSro = validaCodigoSro();
        }

         if(testeExisteUnidadeTecstream && validaIp && validaSenhas && validaCodigoSro){
            consulta.getUpdateOrCadastraIpConcentrador(ipConcentrador, senhaRootConcentrador, codigoSroUnidade, true);
         }else if(!testeExisteUnidadeTecstream && validaIp && validaSenhas && validaCodigoSro){
            consulta.getUpdateOrCadastraIpConcentrador(ipConcentrador, senhaRootConcentrador, codigoSroUnidade, false);
            
         }
        if(!listaReops.isEmpty()){
         getArrayConcentradores().clear();
         setArrayConcentradores(consulta.getConcentradoresDR(listaCodigoSro.get(1).toString().trim(), codigoSroUnidade));
        }
    }

    private boolean validaIp(){
      String ip = ipConcentrador;
      String regex = "^((25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])\\.){3}(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])$";
      Pattern pattern = Pattern.compile( regex );
      Matcher matcher = pattern.matcher( ip );
      if(!matcher.matches() ) {
          System.out.println( "IP válido" );
          FacesContext.getCurrentInstance().addMessage("formSRO:textIpMicroSRO_II", new FacesMessage("IP inválido!"));
      return false;
      }

    return true;
    }

    private boolean validaSenhas(){
        if(!senhaRootConcentrador.equalsIgnoreCase(senhaConfirmaRootConcentrador) || senhaRootConcentrador.isEmpty() || getSenhaConfirmaRootConcentrador().isEmpty() || senhaRootConcentrador.length() != getSenhaConfirmaRootConcentrador().length()){
            FacesContext.getCurrentInstance().addMessage("formSRO:textSenhaUsuarioConcentrador", new FacesMessage("Senhas devem ser iguais!"));
            FacesContext.getCurrentInstance().addMessage("formSRO:textConfirmaSenhaUsuarioConcentrador", new FacesMessage("Senhas devem ser iguais!"));
            return false;
        }


    return true;
    }

    private boolean validaCodigoSro() throws ConnectException{
        if(!testaCadastroUnidade()){
        FacesContext.getCurrentInstance().addMessage("formSRO:textCodigoSroUnidade", new FacesMessage("Unidade inválida ou não cadastrada como SRO II!"));
        FacesContext.getCurrentInstance().addMessage("formSROedit:textCodigoSroUnidade", new FacesMessage("Unidade inválida ou não cadastrada como SRO II!"));
        return false;
        }
    return true;
    }

    public void editaCadastroUnidade() throws IOException {
//      new SelectItem[codigos.length];
        //mostraSelectCampos = true;
        //mostraSelectBotao = true;
        OracleCadastroConcentradorDAO consulta = new OracleCadastroConcentradorDAO();
        

        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest req = (HttpServletRequest) context.getExternalContext().getRequest();
     

               
        for(int a = 0; a < arrayConcentradores.size(); a++){
             setEditorConcentrador((Concentrador) arrayConcentradores.get(a));
             if(getEditorConcentrador().getCodigo().equalsIgnoreCase(req.getParameter("entidadeId"))){

                 FacesContext.getCurrentInstance().getExternalContext().redirect("editorConcentrador.jsp");
                 break;
             }
             
        }
    }

    public void voltarPagina() throws IOException{

        FacesContext.getCurrentInstance().getExternalContext().redirect("cadastroConcentradoresSROII.jsp");

    }

    public void voltarPaginaInicio() throws IOException{

        mostraSelectBotao = false;
        mostraSelectCampos = false;

        FacesContext.getCurrentInstance().getExternalContext().redirect("cadastroConcentradoresSROII.jsp");

    }

    public int getDr() {
        return dr;
    }

    public void setDr(int dr) {
        this.dr = dr;
    }


}
