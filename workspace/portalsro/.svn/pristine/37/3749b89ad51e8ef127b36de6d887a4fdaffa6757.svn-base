<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<f:view>
	
		<f:loadBundle basename="resources.pages" var="config" />
		
		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<link rel="stylesheet" href="styles/menu2.css">
			<link rel="stylesheet" href="styles/basic.css">
			<title><h:outputText value="#{config.faixaCepTitle}" /></title>
		</head>
		
		<body>
	
			<div class="content">
				<br /><jsp:include page="header.jsp" flush="false" /><br />
				
				<div class="messagebox">
					<h:messages infoStyle="color: green" infoClass="info" errorClass="error" />
				</div>
				
				<h2>
					<h:outputText value="#{config.faixaCepTitle}" />
				</h2>
	
				<h:form id="formFaixaCep">
					<h:panelGrid columns="2" id="panelFaixaCep">
						<h:outputLabel value="#{config.dr}" for="selectDR" id="labelDR" />
						<h:selectOneMenu value="#{faixaCep.dr}" id="selectDR">
							<f:selectItems value="#{selectDrs.drs}" id="itensDR" />
						</h:selectOneMenu>
	
						<h:outputLabel value="#{config.tipoUnidade}" for="textTipoUnidade" id="labelTipoUnidade" />
						<h:inputText value="#{faixaCep.tipoUnidade}" id="textTipoUnidade" />
						
						<h:panelGroup>
						<br /><br />
							<h:commandButton id="btnPesquisar" action="#{faixaCep.pesquisar()}" value="#{config.submit}" styleClass="button" />
							<br /><br />
						</h:panelGroup>
					</h:panelGrid>
				</h:form>
				<jsp:include flush="false" page="footer.html" />
			</div>
	
		</body>
		
	</f:view>
	
</html>
