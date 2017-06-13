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

<title><h:outputText
		value="#{config.resultControleTransmissaoTitle}" /></title>
	</head>
	<body>

		<div class="content">
			<br />
			<jsp:include page="header.jsp" flush="false" />
			<br />
			<h:form id="form1">
				<h:panelGrid columns="2" id="grid1">
					<h:outputLabel value="#{config.startDate}" for="startDate" />

					<h:outputText value="#{controleTransmissao.startDate}"
						id="startDate">
						<f:convertDateTime pattern="dd/MM/yyyy" />
					</h:outputText>
					<h:outputLabel value="#{config.endDate}" for="endDate" />

					<h:outputText value="#{controleTransmissao.endDate}" id="endDate">
						<f:convertDateTime pattern="dd/MM/yyyy" />
					</h:outputText>

					<h:outputLabel value="#{config.unitLabel}" for="unitText" />
					<h:panelGroup id="panel1">
						<h:outputText value="#{controleTransmissao.codigoUnidade}"
							id="unitText" />
						<h:outputText value=" - #{controleTransmissao.nomeUnidade}"
							id="nomeText" />
					</h:panelGroup>

				</h:panelGrid>
			</h:form>
			<jsp:include flush="false" page="/helpHeader.html" />
			<div class="tableContainer">
				<div class="tablecaption">
					<p>
						<h:outputText value="#{config.controleTransmissaoTitle}" />
					</p>
				</div>

				<h:dataTable value="#{controleTransmissao.transmissoes}" var="item"
					rowClasses="even,odd" styleClass="blue" id="myTable"
					rendered="#{controleTransmissao.rendered}">

					<h:column>
						<f:facet name="header">
							<h:outputText value="#{config.fileName}" />
						</f:facet>
						<h:outputText value="#{item.nomeArquivo}" />
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:outputText value="#{config.transmitido}" />
						</f:facet>
						<h:outputText value="#{item.transmitido}">
							<f:convertDateTime pattern="dd-MM-yyyy HH:mm:ss" />
						</h:outputText>
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:outputText value="#{config.gravado}" />
						</f:facet>
						<h:outputText value="#{item.gravado}">
							<f:convertDateTime pattern="dd-MM-yyyy HH:mm:ss" />
						</h:outputText>
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:outputText value="#{config.evento}" />
						</f:facet>
						<h:outputText value="#{item.evento}"
							title="#{Events.event[item.evento]}" />
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:outputText value="#{config.records}"
								title="#{config.recordsHint}" />
						</f:facet>
						<h:outputText value="#{item.registros}">
							<f:convertNumber minIntegerDigits="2" type="number"
								integerOnly="true" pattern="00" />
						</h:outputText>
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:outputText value="#{config.rejecteds}"
								title="#{config.rejectedsHint}" />
						</f:facet>
						<h:outputText value="#{item.rejeitados}">
							<f:convertNumber minIntegerDigits="2" type="number"
								integerOnly="true" pattern="00" />
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
						col_3 : "select",
						col_4 : "select",
						col_5 : "select",
						/*btn_text: " > "*/
						on_change : true,
						btn : false,
						btn_reset : true,
						loader : true,
						sort_select : true
					}
					setFilterGrid("myTable", 0, table3Filters);
				</script>
				<div class="messagebox">
					<h:messages infoClass="info" errorClass="error" />
				</div>
				<jsp:include flush="false" page="footer.html" />
			</div>
		</div>
	</body>
</f:view>
</html>
