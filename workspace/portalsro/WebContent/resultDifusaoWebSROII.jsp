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
            <title><h:outputText value="#{config.resultDifusaoBaixaTitle}" /></title>
        </head>
        <body>
            
            <div class="content" >
                <br/>
                <jsp:include page="header.jsp" flush="false" />
                <br/>
                <h:panelGrid columns="2" >
                                        
                    <h:outputLabel value="#{config.sucessoDifusao}" rendered="#{webDifusao.resultado}" />
                    <h:outputLabel value="#{config.erroDifusao}" rendered="#{!webDifusao.resultado}" />
                    <br><br><br><br><br><br>
                                      
                </h:panelGrid>
               
                <div class="tableContainer">
                   
                    <h:form id="formDifusao">
                    <h:dataTable value="#{webDifusao.unidades}" var="item" rowClasses="even,odd" styleClass="blue" id="myTable" rendered="#{webDifusao.resultado}" >
                                               
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="#{config.codigoSro}" />
                            </f:facet>
                                 <h:outputText value="#{item.codigo}" />                           
                        </h:column>
                        
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="#{config.uniName}" />
                            </f:facet>
                            <h:outputText value="#{item.nome}" />
                        </h:column>
                        
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="#{config.resultadoCabecalho}" />
                            </f:facet>
                                 <h:outputText value="#{config.sucessoDifusao}" />                           
                        </h:column>
                        
                    </h:dataTable>
                    
                    <div class="messagebox">
                        <h:messages infoClass="info" errorClass="error" />   
                    </div>
                    <jsp:include flush="false" page="footer.html" />
                </div>
                </h:form>
            </div>
            
            <!-- Code for the left panel -->
           
            <!-- End code for the left panel -->
            
        </body>
    </f:view>
</html>
