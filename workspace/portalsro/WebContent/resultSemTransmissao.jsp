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
            
            <title><h:outputText value="#{config.resultSemTransmissaoTitle}" /></title>
        </head>
        <body>
            
            <div class="content" >
                <br/>
                <jsp:include page="header.jsp" flush="false" />
                <br/>
                <h:panelGrid columns="2" >
                    <h:outputLabel value="#{config.dr}" for="selectDR" />
                    <h:outputText value="#{selectDrs.mapSiglas[semTransmissao.dr]} - #{selectDrs.mapNomes[semTransmissao.dr]}" id="selectDR" />
                    
                    <h:outputLabel value="#{config.reopTextBox}" for="textReop" rendered="#{semTransmissao.reop > 0}" />
                    <h:outputText value="#{semTransmissao.reop}" id="textReop" rendered="#{semTransmissao.reop > 0}" />
                    
                    <h:outputLabel value="#{config.tipoUnidade}" for="textTipoUnidade" rendered="#{semTransmissao.tipoUnidade != '0.919019191'}" />
                    <h:outputText value="#{semTransmissao.tipoUnidade}" id="textTipoUnidade" rendered="#{semTransmissao.tipoUnidade != '0.919019191'}" />
                </h:panelGrid>
                <jsp:include flush="false" page="/helpHeader.html" />
                <div class="tableContainer">
                    <div class="tablecaption">
                        <p><h:outputText value="#{config.semTransmissaoTitle}" /></p>
                    </div>
                    <h:dataTable value="#{semTransmissao.transmissoes}" var="item" rowClasses="even,odd" styleClass="blue" id="myTable" rendered="#{semTransmissao.rendered}" >
                        
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="#{config.codigo}" />
                            </f:facet>
                            <h:outputText value="#{item.codigo}" />
                        </h:column>
                        
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="#{config.nome}" />
                            </f:facet>
                            <h:outputText value="#{item.nome}" />
                        </h:column>
                        
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="#{config.reop}" />
                            </f:facet>
                            <h:outputText value="#{item.reop}" >
                                <f:convertNumber minIntegerDigits="2" type="number" integerOnly="true" pattern="00" />
                            </h:outputText>
                        </h:column>
                        
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="#{config.headdr}" />
                            </f:facet>
                            <h:outputText value="#{item.dr}" />
                        </h:column>
                        
                    </h:dataTable>
                    
                    	<div class="tablecaption">
						<h:outputText value="" />
						<f:verbatim>
                            &nbsp;
                        </f:verbatim>
					</div>
                    
                    
                    
                    <script  type="text/javascript">
	var table3Filters = {
		col_2: "select",
                col_3: "none",
		/*btn_text: " > "*/
                on_change:true,
                btn: false,
                btn_reset: true,
                loader: true,
                sort_select: true
	};
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
