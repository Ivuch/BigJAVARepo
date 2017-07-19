<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="snoop" tagdir="/WEB-INF/tags/snoop"%>
<jsp:directive.page contentType="text/html;charset=UTF-8" />

<div>
	<div class="container master-container">
	<spring:url value="/antecedenteProyectos/dataEntry" var="form_url" />

		<form:form method="post" commandName="antecedenteProyecto"
			class="simple_form form-horizontal"
			action="${form_url}" accept-charset="UTF-8">
			<legend><spring:message code="complete.all"/></legend>

			<form:hidden path="id" />

			<spring:message code="nombre.proyecto" var="nameP"/>
			<snoop:input labelText="${nameP}" path="nombre"
				id="nombre_del_proyecto" requerido="true" />

			<spring:bind path="cliente.*">
				<div
					class="control-group string required ${status.error ? 'error' : '' }">
					<label for="cliente" class="string required control-label"> <abbr
						title="required">*</abbr><spring:message code="nombre.cliente"/>
					</label>
					<div class="controls">
						<form:input path="cliente.nombre" type="text" id="cliente"	class="string required span3" 
							autocomplete="off" />
						 <a id="cliente_link" class="btn" href="${antecedenteProyecto.clienteFinal.linkCRM}" 
						 	data-toggle="tooltip" title="Ver en CRM"><i class="icon-share"></i></a>
						<form:errors path="cliente.*" cssClass="help-inline" />
					</div>
				</div>
			</spring:bind>
			
			<form:hidden path="cliente.idCrm" id="clienteId" />
			<form:hidden path="cliente.direccion" id="cliente_direccion" />
			<form:hidden path="cliente.telefono" id="cliente_telefono" />
			<form:hidden path="cliente.vertical" id="cliente_vertical" />

			<spring:bind path="clienteFinal.*">
				<div
					class="control-group string required ${status.error ? 'error' : '' }">
					<label for="clienteFinal" class="string required control-label"> <abbr
						title="required">*</abbr><spring:message code="nombre.cliente.final"/>
					</label>
					<div class="controls">
						<form:input path="clienteFinal.nombre" type="text" id="clienteFinal" class="string required span3" 
							autocomplete="off" />
						<a id="cliente_final_link" class="btn" href="${antecedenteProyecto.clienteFinal.linkCRM}" 
							data-toggle="tooltip" title="Ver en CRM"><i class="icon-share"></i></a>
						<form:errors path="clienteFinal.*" cssClass="help-inline" />
					</div>
				</div>
			</spring:bind>
				
			<form:hidden path="clienteFinal.idCrm" id="clienteFinalId" />	
			<form:hidden path="clienteFinal.direccion" id="cliente_final_direccion" />
			<form:hidden path="clienteFinal.telefono" id="cliente_final_telefono" />
			<form:hidden path="clienteFinal.vertical" id="cliente_final_vertical" />

			<spring:message code="nombre.lider" var="nombreLider"/>
			<snoop:input labelText="${nombreLider}" path="liderProyecto" id="lider_proyecto" requerido="true"/>

			
			<div class="form-actions">
				<input type="submit" value="<spring:message code="boton.next"/>" name="commit" class="btn btn-primary" />  
				<a href="<c:url value="/bandeja" />" class="btn"><spring:message code="boton.cancelar"/></a>  
			</div>

		</form:form>

	</div>
</div>