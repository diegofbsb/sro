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
            
            <title><h:outputText value="#{config.resultArquivosRepetidosTitle}" /></title>
        </head>
        <body>
            
            <div class="content" >
                <br/>
                <jsp:include page="header.jsp" flush="false" />     
                <br/>
                <h:form id="form1" >
                    <h:panelGrid columns="2" id="grid1" >
                        <h:outputLabel value="#{config.dr}" for="selectDR" />
                        
                        <h:outputText value="#{selectDrs.mapSiglas[arquivosRepetidos.dr]} - #{selectDrs.mapNomes[arquivosRepetidos.dr]}" id="selectDR" />
                        
                    </h:panelGrid>
                </h:form>
                <jsp:include flush="false" page="/helpHeader.html" />
                <div class="tableContainer">
                    <div class="tablecaption">
                        <p><h:outputText value="#{config.arquivosRepetidosTitle}" /></p>
                    </div>
                    
                    <h:dataTable value="#{arquivosRepetidos.transmissoes}" var="item" rowClasses="even,odd" styleClass="blue" id="myTable" rendered="#{arquivosRepetidos.rendered}" >
                        
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="#{config.fileName}" />
                            </f:facet>
                            <h:outputText value="#{item.nomeArquivo}"  />
                        </h:column>
                        
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="#{config.headdr}" />
                            </f:facet>
                            <h:outputText value="#{item.dr}" />
                        </h:column>
                        
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="#{config.codigo}" />
                            </f:facet>
                            <h:outputText value="#{item.codigoUnidade}" />
                        </h:column>
                        
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="#{config.uniName}" />
                            </f:facet>
                            <h:outputText value="#{item.unidade}" />
                        </h:column>
                        
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="#{config.quantidade}" />
                            </f:facet>
                            <h:outputText value="#{item.quantidade}" >
                                <f:convertNumber minIntegerDigits="2" type="number" integerOnly="true" pattern="00" />
                            </h:outputText>
                        </h:column>
                        
                    </h:dataTable>
                    <script  type="text/javascript">
	var table3Filters = {
		col_1: "none",
                col_4: "select",
		/*btn_text: " > "*/
                on_change:true,
                btn: false,
                btn_reset: true,
                loader: true,
                sort_select: true
	}
 	setFilterGrid("myTable",0,table3Filters);
                    </script>
                    <div class="messagebox">
                        <h:messages infoClass="info" errorClass="error" />   
                    </div>
                    <jsp:include flush="false" page="footer.html" />
                </div>
            </div>
        </body>
    </f:view>
</html>
