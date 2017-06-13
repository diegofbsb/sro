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
            <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
            <title><h:outputText value="#{config.objetosIrregularesTitle}" /></title>
        </head>
        <body>
            
            <div class="content" >
                <br/>
                <jsp:include page="header.jsp" flush="false" />
                <h2><h:outputText value="#{config.objetosIrregularesTitle}" /></h2>
                <br/>
                
                <h:form id="formControl">
                    <h:panelGrid columns="2" >
                        <h:outputLabel value="#{config.dr}" for="selectDR" />
                        <h:selectOneMenu value="#{objetoIrregular.dr}" id="selectDR" >
                            <f:selectItems value="#{selectDrs.drs}" id="itensDR" />
                        </h:selectOneMenu>
                        <h:commandButton id="btnOk" value="#{config.submit}" styleClass="button" action="#{objetoIrregular.pesquisar}" />
                    </h:panelGrid>                        
                </h:form>
                <jsp:include flush="false" page="footer.html" />
            </div>
        </body>
    </f:view>
</html>
