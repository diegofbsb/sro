<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">


<html>
    <f:view>

        <f:loadBundle basename="resources.pages" var="config" />
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link rel="stylesheet" href="styles/menu2.css">
            <link rel="stylesheet" href="styles/basic.css">
            <link rel="stylesheet" href="styles/dhtmlgoodies.css">
            <link rel="stylesheet" href="styles/filterTable.css">
            <script type="text/javascript" src="filterTable.js">
                /*====================================================
                    - HTML Table Filter Generator v1.5
                    - By Max Guglielmi
                    - mguglielmi.free.fr/scripts/TableFilter/?l=en
                    - please do not change this comment
                    - don't forget to give some credit... it's always
                good for the author
                =====================================================*/
            </script>
            <title><h:outputText value="#{config.resultPendenciaBaixaTitle}" /></title>
        </head>
        <body>

            <div class="content" >
                <br/>
                <jsp:include page="header.jsp" flush="false" />
                <br/>
                <h:panelGrid columns="2" >
               
                    <h:outputLabel value="#{config.dr}" for="selectDR" rendered="#{!pendenciaBaixa2.drMostra}" />
                    <h:outputText value="#{selectDrs.mapSiglas[pendenciaBaixa2.dr]} - #{selectDrs.mapNomes[pendenciaBaixa2.dr]}" id="selectDR" rendered="#{!pendenciaBaixa2.drMostra}" />

                    <h:outputLabel value="#{config.dr}" for="selectDR1" rendered="#{pendenciaBaixa2.drMostra}" />
                    <h:outputText value="#{config.todasDRs}" id="selectDR1" rendered="#{pendenciaBaixa2.drMostra}" />

                    <h:outputLabel value="#{config.dataMaiusculaInicio}" for="textDtMostrarTelaInicio" />
                    <h:outputText value="#{pendenciaBaixa2.dtInicialMostrarTela}" id="textDtMostrarTelaInicio" />

                    <h:outputLabel value="#{config.dataMaiusculaFinal}" for="textDtMostrarTelaFinal" />
                    <h:outputText value="#{pendenciaBaixa2.dtFinalMostrarTela}" id="textDtMostrarTelaFinal" />
     
                </h:panelGrid>
                <jsp:include flush="false" page="/helpHeader.html" />
                <div class="tableContainer">
                    <div class="tablecaption">
                        <p><h:outputText value="#{config.pendenciaBaixaTitle}" /></p>
                     </div>
                    <h:form id="formPendencia">
                    <h:dataTable value="#{pendenciaBaixa2.transmissoes}" var="item" rowClasses="even,odd" styleClass="blue" id="myTable" rendered="#{pendenciaBaixa2.rendered}" >

                        <h:column >
                            <f:facet name="header">
                                <h:outputText value="#{config.data}" />
                            </f:facet>
                         <h:outputText value="#{item.dataPesquisada}" />

                        </h:column>


                         <h:column rendered="#{pendenciaBaixa2.drMostra}">
                          <f:facet name="header">
                                <h:outputText value="#{config.headdr}" />
                            </f:facet>
                          
                         
                         <h:outputText value="#{item.siglaDr}" />
                        </h:column>


                        <h:column rendered="#{pendenciaBaixa2.nomeUniMostra}">
                            <f:facet name="header">
                                <h:outputText value="#{config.codigoSro}" />
                            </f:facet>
                            
                            <h:outputLink value="faces/detalhePendenciaBaixa.jsp?codigo=#{item.codigoSro}&nome=#{item.nomePesquisa}" rendered="#{(item.lancado - item.baixado) > 0}" >

                                <h:outputText value="#{item.codigoSro}" />
                            </h:outputLink>
                            <h:outputText value="#{item.codigoSro}" rendered="#{(item.lancado - item.baixado) == 0}"/>
                        </h:column>
                        
                        <h:column rendered="#{pendenciaBaixa2.nomeUniMostra}">
                            <f:facet name="header">
                                <h:outputText value="#{config.codigoMCMCU}"/>
                            </f:facet>
                            
                           <h:outputText value="#{item.codigoMCMCU}"/>
                          

                        </h:column>

                        <h:column rendered="#{pendenciaBaixa2.nomeUniMostra}">
                            <f:facet name="header">
                                <h:outputText value="#{config.tipoUnidade}" />
                            </f:facet>
                            
                           <h:outputText value="#{item.tipoUnidade}" />
                          

                        </h:column>

                         <h:column rendered="#{pendenciaBaixa2.nomeUniMostra}">
                            <f:facet name="header">
                                <h:outputText value="#{config.unitLabel}" />
                            </f:facet>
                            
                            
                                <h:outputText value="#{item.nome}" />
                          

                        </h:column>

                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="#{config.cargaLancada}" />
                            </f:facet>
                            <h:outputText value="#{item.lancado}" />
                        </h:column>

                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="#{config.cargaBaixada}" />
                            </f:facet>
                            <h:outputText value="#{item.baixado}" />
                        </h:column>

                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="#{config.percentual}" />
                            </f:facet>
                            <h:outputText value="#{item.percentualBaixado}" />
                        </h:column>


                    </h:dataTable>
          
                    <div class="tablecaption">
                        <h:outputText value=""/>  <f:verbatim>
                            &nbsp;
                        </f:verbatim>
                    </div>
            
                    <script  type="text/javascript">
	var table3Filters = {
                on_change:true,
                btn: false,
                btn_reset: true,
                loader: true
	}
 	setFilterGrid("formPendencia:myTable",0,table3Filters);
                    </script>
                    <div class="messagebox">
                        <h:messages infoClass="info" errorClass="error" />
                    </div>
                    <jsp:include flush="false" page="footer.html" />
                </div>
                </h:form>
            </div>

            <!-- Code for the left panel -->
            <jsp:include flush="false" page="/help.html" />
            <!-- End code for the left panel -->

        </body>
    </f:view>
</html>
