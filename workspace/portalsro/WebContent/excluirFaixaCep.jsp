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
			<title><h:outputText value="#{config.excluirFaixaCepTitle}" /></title>
		</head>
		
		<body>
			<div class="content">
				<br /><jsp:include page="header.jsp" flush="false" /><br />
				
				<h2>
					<h:outputText value="#{config.excluirFaixaCepTitle}" />
				</h2>
				
				<div class="messagebox">
					<h:messages errorClass="error" /><br />
				</div>
	
				<h:form id="formExcluirFaixaCep">
				
					<h:panelGrid columns="2" id="panelExcluirFaixaCep">
						<h:outputLabel value="#{config.codigoUnidade}" for="textCodigoUnidade" id="labelCodigoUnidade" />
						<h:panelGroup>
							<h:inputText value="#{faixaCep.codigoUnidade}" id="textCodigoUnidade" required="true" />
						</h:panelGroup>
						
						<h:commandButton id="btnExcluir" action="#{faixaCep.excluir}" value="#{config.excluir}" styleClass="button" />
					</h:panelGrid>
					
				</h:form>
				
				<jsp:include flush="false" page="footer.html" />
			</div>
		</body>
		
	</f:view>
	
</html>
