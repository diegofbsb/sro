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
<title><h:outputText value="#{config.estacoesDeTrabalhoTitle}" /></title>
</head>
<body>

	<div class="content">


		<br />
		<jsp:include page="header.jsp" flush="false" />
		<br />
		<h2>
			<h:outputText value="#{config.estacoesDeTrabalhoTitle}" />
		</h2>
		<h:form id="formControl">
			<h:panelGrid columns="2">


				<h:outputLabel value="#{config.dr}" for="selectDR" />
				<h:selectOneMenu value="#{estacoesDeTrabalho.dr}" id="selectDR">
					<f:selectItems value="#{selectDrs.drs}" />
				</h:selectOneMenu>


				<h:outputLabel value="#{config.tipoUnidade}" for="textTipoUnidade" />
				<h:panelGroup>
					<h:inputText value="#{estacoesDeTrabalho.tipoUnidade}"
						id="textTipoUnidade" />
					<h:message for="textTipoUnidade" errorClass="error" />
				</h:panelGroup>

				<h:outputLabel value="#{config.uniName}" for="textUniName" />
				<h:inputText value="#{estacoesDeTrabalho.uniName}" id="textUniName"
					title="#{config.uniNameHint}" />



				<h:outputLabel value="#{config.uniVersao}" for="textVersao" />
				<h:inputText value="#{estacoesDeTrabalho.uniVersao}" 
							 id="textversao"
							 title="#{config.uniNameHint}" />
				
				<h:outputLabel value="#{config.tipoEstacao}" for="textVersao" />
				<h:selectOneMenu value="#{estacoesDeTrabalho.tipoEstacao}" style="width:140px;" id="lista">
					<f:selectItem itemLabel="#{config.listaIten}" />
					
					<f:selectItems value="#{selectTipoEstacao.estacoesLista}" />
				</h:selectOneMenu>

				<h:commandButton value="#{config.submit}" styleClass="button"
					action="#{estacoesDeTrabalho.pesquisar}" />
			</h:panelGrid>
		</h:form>
		<jsp:include flush="false" page="footer.html" />

	</div>


</body>
	</html>
</f:view>

