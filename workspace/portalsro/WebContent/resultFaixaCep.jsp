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
<title><h:outputText value="#{config.faixaCepTitle}" /></title>
	</head>
	<body>

		<div class="content">
			<br />
			<jsp:include page="header.jsp" flush="false" />
			<br />
			<h:panelGrid columns="2">
				<h:outputLabel value="#{config.dr}" for="selectDR" />
				<h:outputText
					value="#{selectDrs.mapSiglas[faixaCep.dr]} - #{selectDrs.mapNomes[faixaCep.dr]}"
					id="selectDR" />

				<h:outputLabel value="#{config.tipoUnidade}" for="textTipoUnidade"
					rendered="#{faixaCep.tipoUnidade != '0.919019191'}" />
				<h:outputText value="#{faixaCep.tipoUnidade}" id="textTipoUnidade"
					rendered="#{faixaCep.tipoUnidade != '0.919019191'}" />
			</h:panelGrid>

			<jsp:include flush="false" page="/helpHeader.html" />
			<div class="tableContainer">
				<div class="tablecaption">
					<h:outputText value="#{config.faixaCepTitle}" />
				</div>
				<h:form id="formResultFaixaCep">
					<h:dataTable value="#{faixaCep.listaFaixas}" var="faixa"
						rowClasses="even,odd" styleClass="blue" id="myTable"
						rendered="#{faixaCep.rendered}">
						
						<h:column>
							<f:facet name="header">
								<h:outputText value="#{config.codigo}" />
							</f:facet>
							<h:outputText value="#{faixa.codigoUnidade}" />
						</h:column>

						<h:column>
							<f:facet name="header">
								<h:outputText value="#{config.codigoMCU}" />
							</f:facet>
							<h:outputText value="#{faixa.codigoMcu}" />
						</h:column>



						<h:column>
							<f:facet name="header">
								<h:outputText value="#{config.nome}" />
							</f:facet>
							<h:outputText value="#{faixa.nomeUnidade}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="#{config.cepInicial}" />
							</f:facet>
							<h:outputText value="#{faixa.cepInicial}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="#{config.cepFinal}" />
							</f:facet>
							<h:outputText value="#{faixa.cepFinal}" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="#{config.data}" />
							</f:facet>
							<h:outputText value="#{faixa.dataHoraAtualizacao}">
								<f:convertDateTime pattern="dd-MM-yyyy HH:mm:ss" />
							</h:outputText>
						</h:column>
					</h:dataTable>

					<div class="tablecaption">
						<h:outputText value="" />
						<f:verbatim>
                            &nbsp;
                        </f:verbatim>
					</div>

					<script type="text/javascript">
						var table3Filters = {
							on_change : true,
							btn : false,
							btn_reset : true,
							loader : true
						}
						setFilterGrid("formResultFaixaCep:myTable", 0,
								table3Filters);
					</script>
					<div class="messagebox">
						<h:messages infoClass="info" errorClass="error" />
					</div>
					<jsp:include flush="false" page="footer.html" />
			</div>
			</h:form>
		</div>

		<!-- Code for the left panel -->
		<jsp:include flush="false" page="/help.html" />
		<!-- End code for the left panel -->

	</body>
</f:view>
</html>
