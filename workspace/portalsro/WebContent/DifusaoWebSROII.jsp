<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <f:loadBundle basename="resources.pages" var="config" />
    
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
            <link rel="stylesheet" href="styles/menu2.css" >
            <link rel="stylesheet" href="styles/basic.css" >
            <title><h:outputText value="#{config.difusaoBaixaTitle}" /></title>
            <script type="text/javascript" >
				function valida() {
					var saida = validaElemento("formControl:startDate", 10, "errorStartDate", "Por Favor, informe a Data Inicial.");
				    saida = validaElemento("formControl:endDate", 10, "errorEndDate", "Por Favor, informe a Data Final.") && saida;
				    saida = validaElemento("formControl:unitText", 8, "errorUnitText", "Por Favor, informe o Código da Unidade.") && saida;
				    return saida;
				}
	     	</script>
        </head>
        <body>
            
            <div class="content" >
                <%--
                <div style="margin-top: 30%; margin-bottom: 35%; font-family: arial, verdana, courier, sans-serif;text-align: center;font-weight: bold;font-size: 1.3em;background-color: #fff; color: rgb(0, 51, 153);">
                <p>
                    Esta consulta encontra-se em manuten&ccedil;&atilde;o.<br/>
                    T&atilde;o logo esteja dispon&iacute;vel, entraremos em 
                    contato com os respons&aacute;veis pelo SRO 
                    na sua regional. <br/><br/>
                    Contamos com a sua compreens&atilde;o.<br/><br/>
                    Equipe DENCO/DSRO.<br/>
                </p>
                </div>--%>
                
                <br/>
                <jsp:include page="header.jsp" flush="false" />
                <br/>
                <h2><h:outputText value="#{config.difusaoBaixaTitle}" /></h2>
                <h:form id="formControl">
                      <h:panelGrid columns="2" >
                        <h:outputLabel value="#{config.codigoUnidade}" for="textUniCep" />
                        <h:panelGroup>
                            <h:inputText value="#{webDifusao.codigoUnidade}" id="textUniCep" title="#{config.codigoUnidade}" required="true" >
                                <f:validateLength minimum="8" maximum="8" />
                            </h:inputText>
                            <h:message for="textUniCep" errorClass="error" />
                        </h:panelGroup>
                        
                        <h:commandButton value="#{config.submit}" styleClass="button" action="#{webDifusao.updateUnidade}" />
                    </h:panelGrid>                        
                </h:form>
                <jsp:include flush="false" page="footer.html" />
                
            </div>
            
            
        </body>
    </html>
</f:view>