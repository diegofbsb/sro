<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">


<html>
    <f:view>
        <f:loadBundle basename="resources.pages" var="config" />
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link rel="stylesheet" href="styles/menu2.css">
            <link rel="stylesheet" href="styles/basic.css">
            <link rel="stylesheet" href="dhtmlgoodies_calendar/dhtmlgoodies_calendar.css" media="screen">
            <script type="text/javascript" src="dhtmlgoodies_calendar/dhtmlgoodies_calendar.js"></script>

            <title><h:outputText value="#{config.cadastroConcentradoresSRO_IITitle}" /></title>
        </head>
        <body>

            <div class="content" >
                <br/>
                <jsp:include page="header.jsp" flush="false" />
                <h2><h:outputText value="#{config.cadastroConcentradoresSRO_IITitle}" /></h2>
                <br/>

                <h:form id="formSRO">
                    <h:panelGrid columns="3" >
                        <h:outputLabel value="#{config.codigoSro}" for="textCodigoSroUnidade" />
                        <h:panelGroup>
                            <h:inputText value="#{cadastroConcentradorSro.editorConcentrador.codigo}" id="textCodigoSroUnidade"/>
                        </h:panelGroup>
                        <h:message for="textCodigoSroUnidade" style="color:red" />

                        <h:outputLabel value="#{config.ipMicroSRO_II}" for="textIpMicroSRO_II"/>
                        <h:panelGroup >
                            <h:inputText value="#{cadastroConcentradorSro.editorConcentrador.ip}" id="textIpMicroSRO_II"/>
                        </h:panelGroup>
                        <h:message for="textIpMicroSRO_II" style="color:red" />

                        <h:outputLabel value="#{config.senhaMicroSRO_II}" for="textSenhaUsuarioConcentrador" />
                        <h:panelGroup >
                            <h:inputSecret value="#{cadastroConcentradorSro.editorConcentrador.nome}" id="textSenhaUsuarioConcentrador"/>
                        </h:panelGroup>
                        <h:message for="textSenhaUsuarioConcentrador" style="color:red" />

                        <h:outputLabel  value="#{config.senhaConfirmaMicroSRO_II}" for="textConfirmaSenhaUsuarioConcentrador" rendered="#{cadastroConcentradorSro.mostraSelectCampos}"/>
                        <h:panelGroup >
                            <h:inputSecret value="#{cadastroConcentradorSro.editorConcentrador.nome}" id="textConfirmaSenhaUsuarioConcentrador"/>
                        </h:panelGroup>
                        <h:message for="textConfirmaSenhaUsuarioConcentrador" style="color:red" />

                        </h:panelGrid>
                         <h:panelGrid columns="3">
                             <h:commandButton  id="btnOk1" value="#{config.submitSalvar}" styleClass="button" action="#{cadastroConcentradorSro.editaInformacoesConcentrador}"/>
                             
                             <f:verbatim>&nbsp;&nbsp;</f:verbatim>

                             <h:commandButton  id="btnVoltar" value="#{config.submitVoltar}" styleClass="button" action="#{cadastroConcentradorSro.voltarPagina}" />
                             
                         </h:panelGrid>
                    <h:panelGrid   rendered="#{cadastroConcentradorSro.mostraSelectBotao}" style="text-align:center;">
                        <h1><h:message id="erroCadastro_II" for="erroCadastro_II" style="color:blue"/></h1>
                    </h:panelGrid>


                </h:form>


                    <h:panelGrid   rendered="#{cadastroConcentradorSro.mostraSelectBotao}" style="text-align:center;">
                        <h1><h:message id="erroCadastro_II" for="erroCadastro_II" style="color:blue"/></h1>
                    </h:panelGrid>


                <jsp:include flush="false" page="footer.html" />
            </div>
        </body>
    </f:view>
</html>
