<%@page contentType="text/html"%>
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


<title><h:outputText value="#{config.estacoesDeTrabalhoTitle}" /></title>
	</head>
	<body>

		<div class="content">
			<br />
			<jsp:include page="header.jsp" flush="false" />
			<br />
			<h:panelGrid columns="2">
				<h:outputLabel value="#{config.dr}" for="selectDR" />

				<h:outputText
					value="#{selectDrs.mapSiglas[estacoesDeTrabalho.dr]} - #{selectDrs.mapNomes[estacoesDeTrabalho.dr]}"
					id="selectDR" />


				<h:outputLabel value="#{config.tipoUnidade}" for="textTipoUnidade"
					rendered="#{estacoesDeTrabalho.tipoUnidade != '0.919019191'}" />

				<h:outputText value="#{estacoesDeTrabalho.tipoUnidade}"
					id="textTipoUnidade"
					rendered="#{estacoesDeTrabalho.tipoUnidade != '0.919019191'}" />

				<h:outputLabel value="#{config.uniName}" for="textUniName"
					rendered="#{estacoesDeTrabalho.uniName != '0.919019191'}" />
				<h:outputText value="#{estacoesDeTrabalho.uniName}" id="textUniName"
					title="#{config.uniNameHint}"
					rendered="#{estacoesDeTrabalho.uniName != '0.919019191'}" />

			</h:panelGrid>

			<jsp:include flush="false" page="/helpHeader.html" />
			<div class="tableContainer">
				<div class="tablecaption">
					<p>
						<h:outputText value="#{config.estacoesDeTrabalhoTitle}" />
					</p>
				</div>
				<h:dataTable value="#{estacoesDeTrabalho.estacoesDeTrabalho}"
					var="item" style="font-size: 13px;" rowClasses="even,odd"
					styleClass="blue" id="myTable"
					rendered="#{estacoesDeTrabalho.rendered}">

					<h:column>
						<f:facet name="header">
							<h:outputText value="#{config.sro}" id="col_1" />
						</f:facet>
						<h:outputText value="#{item.EST_CO_UNICEP}" />
					</h:column>

					<!-- Adicionada a coluna Código MCU -->
					<h:column>
						<f:facet name="header">
							<h:outputText value="#{config.codigoMCU}" id="col_2" />
						</f:facet>
						<h:outputText value="#{item.UNI_CODE}" />
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:outputText value="#{config.unidade}"  /> <!-- id="col_2" -->
						</f:facet>
						<h:outputText value="#{item.UNI_NAME}" />
					</h:column>


					<h:column>
						<f:facet name="header">
							<h:outputText value="#{config.tipo}" />
						</f:facet>
						<h:outputText value="#{item.out_acronym}" />
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:outputText value="#{config.host}" />
						</f:facet>
						<h:outputText value="#{item.EST_NO}" />
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:outputText value="#{config.ip}" />
						</f:facet>
						<h:outputText value="#{item.EST_CO_IP}" />
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:outputText value="#{config.estacao}" />
						</f:facet>
						<h:outputText value="#{item.tipoEstacao}" />
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:outputText value="#{config.numero}" />
						</f:facet>
						<h:outputText value="#{item.INS_NU}" />
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:outputText value="#{config.diretorio}" />
						</f:facet>
						<h:outputText value="#{item.INS_TX_DIRETORIO}" />
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:outputText value="#{config.versao}" />
						</f:facet>
						<h:outputText value="#{item.INS_NO_VERSAO}" />
					</h:column>

					<h:column>
						<f:facet name="header">
							<h:outputText value="#{config.data}" />
						</f:facet>
						<h:outputText value="#{item.EST_DH_INSERCAO_SRO}">
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
