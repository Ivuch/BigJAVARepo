<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="snoop" tagdir="/WEB-INF/tags/snoop"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:directive.page contentType="text/html;charset=UTF-8" />
<div>
	<div class="container master-container">
		
		<snoop:solap nexo="2"></snoop:solap>
		<snoop:form-header nroPaso="2"></snoop:form-header>
		
		<spring:url value="/antecedenteProyectos/create/paso/2" var="form_url" />

		<form:form method="POST" commandName="antecedenteProyecto"
			class="simple_form form-horizontal"
			action="${form_url}" accept-charset="UTF-8">
			<legend><spring:message code="complete.all"/></legend>


			<form:hidden path="id" />

			<spring:message code="nombre.servicio" var="serviceN"/>
			<snoop:select items="${servicios}" labelText="${serviceN}"
				path="servicio" id="servicio" itemLabel="nombre" itemValue="id"
				requerido="true" />
			
			<spring:message code="nombre.tipo.solucion" var="tipoS"/>
			<snoop:input labelText="${tipoS}" path="tipoSolucion"
				id="tipo_solucion" requerido="true" />

			<spring:message code="nombre.pais" var="paisP"/>
			<snoop:select items="${paises}" labelText="${paisP}" path="pais"
				id="pais" itemLabel="nombre" itemValue="id" requerido="true" />

			<spring:message code="nombre.sbu" var="sbuY"/>
			<snoop:select items="${sbus}" labelText="${sbuY}" path="sbu" id="sbu"
				itemLabel="nombre" itemValue="id" requerido="true" />


			<spring:bind path="montoContrato">
				<div
					class="control-group string required article_name ${status.error ? 'error' : ''} ">
					<label for="article_name" class="string required control-label">
						<abbr title="required">*</abbr> <spring:message code="nombre.monto"/>
					</label>
					<div class="controls">
						<form:input path="montoContrato" type="text" name="montoContrato"
							id="monto_contrato" data-provide="typeahead"
							class="string required span2" />
						<form:select path="monedaContrato" items="${monedas}"
							itemLabel="nombre" itemValue="id" id="moneda_contrato"
							class="select optional span1" />
						<form:errors path="mon*" cssClass="help-inline" />
					</div>
				</div>
			</spring:bind>

			<spring:message code="nombre.cotizacion" var="cotizaZion"/>
			<snoop:input labelText="${cotizaZion}"
				path="cotizacionMoneda" id="cotizacion_moneda" size="2"></snoop:input>

			<div class="form-actions">
				<input type="submit" value="<spring:message code="boton.next"/>" name="commit" class="btn btn-primary" /> 
				<a href="<c:url value="/bandeja" />" class="btn"><spring:message code="boton.cancelar"/></a>  
			</div>
		</form:form>
	</div>
</div>
