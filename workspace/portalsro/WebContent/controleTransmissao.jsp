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
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link rel="stylesheet" href="styles/menu2.css">
            <link rel="stylesheet" href="styles/basic.css">
            <link rel="stylesheet" href="dhtmlgoodies_calendar/dhtmlgoodies_calendar.css" media="screen">
            <script type="text/javascript" src="dhtmlgoodies_calendar/dhtmlgoodies_calendar.js"></script>
            <script type="text/javascript" >
                function validaElemento(id, tam, divErr, msg){
                    var text = document.getElementById(id).value;
                    var msgDiv = document.getElementById(divErr);
                    if (text.length != tam) {
                        msgDiv.innerHTML = msg;
                        return false;
                    } else {
                        msgDiv.innerHTML = "";
                    }
                    return true;
                }
                function valida() {
                    var saida = validaElemento("formControl:startDate", 10, "errorStartDate", "Por Favor, informe a Data Inicial.");
                    saida = validaElemento("formControl:endDate", 10, "errorEndDate", "Por Favor, informe a Data Final.") && saida;
                    saida = validaElemento("formControl:unitText", 8, "errorUnitText", "Por Favor, informe o Código da Unidade.") && saida;
                    return saida;
                }
            </script>
            <title><h:outputText value="#{config.controleTransmissaoTitle}" /></title>
        </head>
        <body>
            
            <div class="content" >
                <br/>
                <jsp:include page="header.jsp" flush="false" />
                <h2><h:outputText value="#{config.controleTransmissaoTitle}" /></h2>
                <br/>
                
                <h:form id="formControl" onsubmit="return valida();">
                    <h:panelGrid columns="4" >
                        <h:outputLabel value="#{config.startDate}" for="startDate" />
                        <h:panelGroup>
                            <h:inputText value="#{controleTransmissao.startDate}" id="startDate" required="true"  >
                                <f:convertDateTime pattern="dd/MM/yyyy" />
                            </h:inputText>
                            <h:message for="startDate" errorClass="error" />
                        </h:panelGroup>
                        <f:verbatim>
                            <a href="#" onclick="displayCalendar(document.getElementById('formControl:startDate'),'dd/mm/yyyy',this)">
                                <img style="border: none" src="images/button_calendar.gif" alt="cal"/>
                            </a>
                        </f:verbatim>
                        <f:verbatim>
                            <div id="errorStartDate" class="error"></div>
                        </f:verbatim>
                        
                        <h:outputLabel value="#{config.endDate}" for="endDate" />
                        <h:panelGroup>
                            <h:inputText value="#{controleTransmissao.endDate}" id="endDate" required="true" >
                                <f:convertDateTime pattern="dd/MM/yyyy" />
                            </h:inputText>
                            <h:message for="endDate" errorClass="error" />
                        </h:panelGroup>
                        <f:verbatim>
                            <a href="#" onclick="displayCalendar(document.getElementById('formControl:endDate'),'dd/mm/yyyy',this)">
                                <img style="border: none" src="images/button_calendar.gif" alt="cal"/>
                            </a>
                        </f:verbatim>
                        <f:verbatim>
                            <div id="errorEndDate" class="error"></div>
                        </f:verbatim>
                        
                        <h:outputLabel value="#{config.codigoUnidade}" for="unitText" />
                        <h:panelGroup>
                            <h:inputText value="#{controleTransmissao.codigoUnidade}" id="unitText" required="true" >
                                <f:validateLength minimum="8" maximum="8" />
                            </h:inputText>
                            <h:message for="unitText" errorClass="error" />
                        </h:panelGroup>
                        <f:verbatim>
                            &nbsp;
                        </f:verbatim>
                        <f:verbatim>
                            <div id="errorUnitText" class="error"></div>
                        </f:verbatim>
                        
                        <h:commandButton id="btnOk" value="#{config.submit}" styleClass="button" action="#{controleTransmissao.pesquisar}" />
                    </h:panelGrid>                        
                </h:form>
                <jsp:include flush="false" page="footer.html" />
            </div> 
        </body>
	</html>
</f:view>
