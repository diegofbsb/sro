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
                    <h:panelGrid columns="3">
                        <h:outputLabel value="#{config.codigoSro}" for="textCodigoSroUnidade" rendered="#{cadastroConcentradorSro.mostraSelectCampos}"/>
                        <h:panelGroup rendered="#{cadastroConcentradorSro.mostraSelectCampos}">
                            <h:inputText value="#{cadastroConcentradorSro.codigoSroUnidade}" id="textCodigoSroUnidade"/>
                        </h:panelGroup>
                        <h:message for="textCodigoSroUnidade" style="color:red" />

                        <h:outputLabel value="#{config.dr}" for="selectDR" rendered="#{!cadastroConcentradorSro.mostraSelectCampos}"/>
                        <h:selectOneMenu value="#{cadastroConcentradorSro.dr}" id="selectDR" rendered="#{!cadastroConcentradorSro.mostraSelectCampos}">
                            <f:selectItems value="#{selectDrs.drs}" id="itensDR" />
                        </h:selectOneMenu>
                        
                        <h:outputLabel value="#{config.ipMicroSRO_II}" for="textIpMicroSRO_II" rendered="#{cadastroConcentradorSro.mostraSelectCampos}"/>
                        <h:panelGroup rendered="#{cadastroConcentradorSro.mostraSelectCampos}">
                        <h:inputText value="#{cadastroConcentradorSro.ipConcentrador}" id="textIpMicroSRO_II"/>
                        </h:panelGroup>
                        <h:message for="textIpMicroSRO_II" style="color:red" />

                        <h:outputLabel value="#{config.senhaMicroSRO_II}" for="textSenhaUsuarioConcentrador" rendered="#{cadastroConcentradorSro.mostraSelectCampos}"/>
                        <h:panelGroup rendered="#{cadastroConcentradorSro.mostraSelectCampos}">
                            <h:inputSecret value="#{cadastroConcentradorSro.senhaRootConcentrador}" id="textSenhaUsuarioConcentrador"/>
                        </h:panelGroup>
                        <h:message for="textSenhaUsuarioConcentrador" style="color:red" />

                        <h:outputLabel  value="#{config.senhaConfirmaMicroSRO_II}" for="textConfirmaSenhaUsuarioConcentrador" rendered="#{cadastroConcentradorSro.mostraSelectCampos}"/>
                        <h:panelGroup rendered="#{cadastroConcentradorSro.mostraSelectCampos}">
                            <h:inputSecret value="#{cadastroConcentradorSro.senhaConfirmaRootConcentrador}" id="textConfirmaSenhaUsuarioConcentrador"/>
                        </h:panelGroup>
                        <h:message for="textConfirmaSenhaUsuarioConcentrador" style="color:red" />
                        
                         </h:panelGrid>
                         <h:panelGrid rendered="#{!cadastroConcentradorSro.mostraSelectBotao}">
                            <h:commandButton  id="btnOk" value="#{config.submit}" styleClass="button" action="#{cadastroConcentradorSro.habilitaCamposDR}" />
                         </h:panelGrid>
                         <h:panelGrid rendered="#{cadastroConcentradorSro.mostraSelectBotao}" columns="3">
                            <h:commandButton  id="btnOk1" value="#{config.submitSalvar}" styleClass="button" action="#{cadastroConcentradorSro.salvarInformacoesConcentrador}"/>
                            <f:verbatim>&nbsp;&nbsp;</f:verbatim>

                             <h:commandButton  id="btnVoltar" value="#{config.submitVoltar}" styleClass="button" action="#{cadastroConcentradorSro.voltarPaginaInicio}" />

                         </h:panelGrid>
                    <h:panelGrid   rendered="#{cadastroConcentradorSro.mostraSelectBotao}" style="text-align:center;">
                        <h1><h:message id="erroCadastro_II" for="erroCadastro_II" style="color:blue"/></h1>
                    </h:panelGrid>

                   
                        <h:dataTable value="#{cadastroConcentradorSro.arrayConcentradores}" var="item" border="3" rendered="#{cadastroConcentradorSro.mostraSelectBotao}">

                           

                            <h1><h:outputText value="Relação Concentradores"/></h1>

                     <h:column >

                        <f:facet name="header">

                            <h:outputText value="Código SRO"/>

                        </f:facet>

                        <h:commandLink styleClass="commandLink" action="#{cadastroConcentradorSro.editaCadastroUnidade}" id="codigoSro" ><f:param  value="#{item.codigo}" name="entidadeId"/><f:param value="#{item.ip}" name="entidadeIp"/><h:outputText value="#{item.codigo}" id="textCodigoSroUnidade"/></h:commandLink>

                    </h:column>


                   <h:column>

                        <f:facet name="header">

                            <h:outputText value="Senha do Concentrador"/>

                        </f:facet>

                        <h:outputText value="#{item.nome}"/>

                    </h:column>

                         <h:column>

                        <f:facet name="header">

                            <h:outputText value="IP do Concentrador"/>

                        </f:facet>

                        <h:outputText value="#{item.ip}"/>

                    </h:column>

           

                </h:dataTable>
                                    
                </h:form>
               
                    
                    <h:panelGrid   rendered="#{cadastroConcentradorSro.mostraSelectBotao}" style="text-align:center;">
                        <h1><h:message id="erroCadastro_II" for="erroCadastro_II" style="color:blue"/></h1>
                    </h:panelGrid>

               
                <jsp:include flush="false" page="footer.html" />
            </div>
        </body>
    </f:view>
</html>
