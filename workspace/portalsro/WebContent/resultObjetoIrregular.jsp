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
            
            <title><h:outputText value="#{config.resultObjetosIrregularesTitle}" /></title>
        </head>
        <body>
            
            <div class="content" >
                <br/>
                <jsp:include page="header.jsp" flush="false" />     
                <br/>
                <h:form id="form1" >
                    <h:panelGrid columns="2" id="grid1" >
                        <h:outputLabel value="#{config.dr}" for="selectDR" />
                        
                        <h:outputText value="#{selectDrs.mapSiglas[objetoIrregular.dr]} - #{selectDrs.mapNomes[objetoIrregular.dr]}" id="selectDR" />
                        
                    </h:panelGrid>
                </h:form>
                <jsp:include flush="false" page="/helpHeader.html" />
                <div class="tableContainer">
                    <div class="tablecaption">
                        <p><h:outputText value="#{config.objetosIrregularesTitle}" /></p>
                    </div>
                    
                    <h:dataTable value="#{objetoIrregular.transmissoes}" var="item" rowClasses="even,odd" styleClass="blue" id="myTable" rendered="#{objetoIrregular.rendered}" >
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="#{config.etiqueta}" />
                            </f:facet>
                            <h:outputText value="#{item.etiqueta}"  />
                        </h:column>
                        
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="#{config.evento}" />
                            </f:facet>
                            <h:outputText value="#{item.evento}" title="#{Events.event[item.evento]}" />
                        </h:column>
                        
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="#{config.dataCriacao}" />
                            </f:facet>
                            <h:outputText value="#{item.dataCriacao}" >
                                <f:convertDateTime pattern="dd-MM-yyyy HH:mm:ss" />
                            </h:outputText>
                        </h:column>
                        
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="#{config.uniName}" />
                            </f:facet>
                            <h:outputText value="#{item.unidade}" />
                        </h:column>
                        
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="#{config.codigo}" />
                            </f:facet>
                            <h:outputText value="#{item.codigoUnidade}" >
                                <f:convertNumber minIntegerDigits="2" type="number" integerOnly="true" pattern="00" />
                            </h:outputText>
                        </h:column>
                        
                    </h:dataTable>
                    <script  type="text/javascript">
	var table3Filters = {
		
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
