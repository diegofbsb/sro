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
			<title><h:outputText value="#{config.pendenciaBaixaDiariaTitle}" /></title>
		</head>
		
		<body>
			<div class="content">
				<br />
				<jsp:include page="header.jsp" flush="false" />
				<br />
				
				<h:panelGrid columns="2">
					<h:outputLabel value="#{config.dr}" for="textDR" />
					<h:outputText value="#{config.todasDRs}" id="textDR" />
					
					<h:outputLabel value="#{config.dataMaiusculaInicio}" for="textDataInicio" />
					<h:outputText value="#{pendenciaBaixaDiaria.data}" id="textDataInicio" />
					
					<h:outputLabel value="#{config.dataMaiusculaFinal}" for="textDataFinal" />
					<h:outputText value="#{pendenciaBaixaDiaria.data}" id="textDataFinal" />
				</h:panelGrid>
				
				<jsp:include flush="false" page="/helpHeader.html" />
				
				<div class="tableContainer">
					<div class="tablecaption">
						<p>
							<h:outputText value="#{config.pendenciaBaixaTitle}" />
						</p>
					</div>
					
					<h:form id="formPendenciaDiaria">
						<h:dataTable value="#{pendenciaBaixaDiaria.transmissoes}" var="item" rowClasses="even,odd" styleClass="blue" id="myTable">
							<h:column>
								<f:facet name="header">
									<h:outputText value="#{config.headdr}" />
								</f:facet>
								<h:outputText value="#{item.dr}" />
							</h:column>
							<h:column>
								<f:facet name="header">
									<h:outputText value="#{config.cargaLancada}" />
								</f:facet>
								<h:outputText value="#{item.lancado}" />
							</h:column>
							<h:column>
								<f:facet name="header">
									<h:outputText value="#{config.pendencia}" />
								</f:facet>
								<h:outputText value="#{item.pendencia}" />
							</h:column>
							<h:column>
								<f:facet name="header">
									<h:outputText value="#{config.percentual}" />
								</f:facet>
								<h:outputText value="#{item.percentual}" />
							</h:column>
						</h:dataTable>
	
						<div class="tablecaption">
							<h:outputText value="" />
							<f:verbatim>&nbsp;</f:verbatim>
						</div>
	
						<script type="text/javascript">
							var table3Filters = {
								on_change : true,
								btn : false,
								btn_reset : true,
								loader : true
							}
							setFilterGrid("formPendenciaDiaria:myTable", 0, table3Filters);
						</script>
						
						<div class="messagebox">
							<h:messages infoClass="info" errorClass="error" />
						</div>
						
						<jsp:include flush="false" page="footer.html" />
					</h:form>
				</div>
			</div>
	
			<!-- Code for the left panel -->
			<jsp:include flush="false" page="/help.html" />
			<!-- End code for the left panel -->
	
		</body>
		
	</f:view>
	
</html>
