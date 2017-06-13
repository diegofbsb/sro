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
            <script type="text/javascript">
                function consultaSRO(objeto){
                    window.open("http://websro2.correiosnet.int/rastreamento/sro?opcao=PESQUISA&objetos=" +objeto);
                    return false;
                }

            </script>
            <title><h:outputText value="#{config.detalheEstacoesDeTrabalho}" /></title>
        </head>
        <body>
            <div class="content" >
                <br/>
                <jsp:include page="header.jsp" flush="false" />                 
                <br/>
                <h:outputLabel for="textNomeUnidade" value="#{config.unitLabel}" />
                <h:outputText id="textNomeUnidade" value="#{detalheEstacoesDeTrabalho.nome} (#{detalheEstacoesDeTrabalho.codigo})" />
                <jsp:include flush="false" page="/helpHeader.html" />
                <div class="tableContainer">
                    <div class="tablecaption">
                        <p><h:outputText value="#{config.detalheEstacoesDeTrabalhoTitle}" /></p>
                    </div>
                    
                    <h:dataTable value="#{detalheEstacoesDeTrabalho.transmissoes}" var="item" rowClasses="even,odd" styleClass="blue" id="myTable"  >
                        
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="#{config.objeto}" />
                            </f:facet>
                            
                            <h:outputLink value="#" onclick="consultaSRO('#{item.objeto}')" >
                                <h:outputText value="#{item.objeto}" />
                            </h:outputLink>
                            
                            
                        </h:column>
                        
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="#{config.lancado}" />
                            </f:facet>
                            <h:outputText value="#{item.dataCriacao}" >
                                <f:convertDateTime pattern="dd-MM-yyyy HH:mm:ss" />
                            </h:outputText>
                        </h:column>
                        
                         <h:column>
                            <f:facet name="header">
                                <h:outputText value="#{config.prazo}" />
                            </f:facet>
                            <h:outputText value="#{item.prazo}" />
                        </h:column>
                        
                        <%--
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="#{config.inserido}" />
                            </f:facet>
                            <h:outputText value="#{item.datInsercao}" >
                                <f:convertDateTime pattern="dd-MM-yyyy HH:mm:ss" />
                            </h:outputText>
                        </h:column>
                        --%>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="#{config.tempo}" />
                            </f:facet>
                            <h:outputText value="#{item.tempo}" />
                        </h:column>
                        
                        
                    </h:dataTable>
                    <div class="tablecaption">
                        <p><h:outputText value="#{config.footerDetalhe}"/><h:outputText value="#{detalheEstacoesDeTrabalho.numObjetos}" /></p>
                    </div>
                    <script  type="text/javascript">
	var table3Filters = {
                on_change:true,
                btn: false,
                btn_reset: true,
                loader: true
	}
 	setFilterGrid("myTable",0,table3Filters);
                    </script>
                    <div class="messagebox">
                        <h:messages infoClass="info" errorClass="error" />   
                    </div>
                    <jsp:include flush="false" page="footer.html" />
                </div>
            </div>
            <!-- Code for the left panel -->
            <jsp:include flush="false" page="/help.html" />
            <!-- End code for the left panel -->
        </body>
    </f:view>
</html>
