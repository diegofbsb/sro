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
            <title><h:outputText value="#{config.ultimaTransmissaoTitle}" /></title>
        </head>
        <body>
            
            <div class="content" >
                <br/>
                <jsp:include page="header.jsp" flush="false" />
                <br/>
                <h2><h:outputText value="#{config.ultimaTransmissaoTitle}" /></h2>
                
                <h:form id="formUT">
                    <h:panelGrid columns="2" id="panelUT" >
                        
                        <h:outputLabel value="#{config.dr}" for="selectDR" id="labelDR" />
                        <h:selectOneMenu value="#{ultimaTransmissao.dr}" id="selectDR" >
                            <f:selectItems value="#{selectDrs.drs}" id="itensDR" />
                        </h:selectOneMenu>
                        
                        <h:outputLabel value="#{config.reopTextBox}" for="textReop" id="labelREOP" />
                        <h:panelGroup>
                            <h:inputText value="#{ultimaTransmissao.reop}" id="textReop" />
                            <h:message for="textReop" errorClass="error" id="errorMessage1" />
                        </h:panelGroup>
                        
                        <h:outputLabel value="#{config.tipoUnidade}" for="textTipoUnidade" id="labelTipoUnidade" />
                        <h:panelGroup>
                            <h:inputText value="#{ultimaTransmissao.tipoUnidade}" id="textTipoUnidade" />
                            <h:message for="textTipoUnidade" errorClass="error" id="errorMessage2" />
                        </h:panelGroup>
                        
                        <h:commandButton id="btnPesquisar" action="#{ultimaTransmissao.pesquisar}" value="#{config.submit}" styleClass="button" />
                        
                    </h:panelGrid>                        
                </h:form>
                <jsp:include flush="false" page="footer.html" />
            </div>
            
        </body>
    </f:view>
</html>
