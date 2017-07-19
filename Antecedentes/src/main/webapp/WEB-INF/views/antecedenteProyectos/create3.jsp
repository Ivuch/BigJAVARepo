<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="snoop" tagdir="/WEB-INF/tags/snoop"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:directive.page contentType="text/html;charset=UTF-8" />  
<jsp:directive.page pageEncoding="UTF-8" /> 
<script>

	function getDatosContacto(){
		$('#telefono_CF').val("");
		$('#email_CF').val("");
		$('#contacto_nombre').val("");	
		$('#areaPert_CF').val("");
		
		$.get("<c:url value="/getContacto" />?id=" + $('#contacto_idCrm').attr('value'),
				function(data){
			$('#telefono_CF').val(data.telefono);
			$('#email_CF').val(data.email);
			$('#areaPert_CF').val(data.areaPerteneciente);
			$('#contacto_nombre').val(data.nombre);	
		});
	}
	
	$(function() {	
		
		getDatosContacto();
		
		$('#contacto_idCrm').change(
			getDatosContacto	
		);
	}); 
</script>
<jsp:directive.page contentType="text/html;charset=UTF-8" />
<div>
	<div class="container master-container">

		<snoop:solap nexo="2"></snoop:solap>
		<snoop:form-header nroPaso="3"></snoop:form-header>
		
		<spring:url value="/antecedenteProyectos/create/paso/3" var="form_url" />

		<form:form method="POST" commandName="antecedenteProyecto"
			class="simple_form form-horizontal"
			action="${form_url}" accept-charset="UTF-8">
			<legend><spring:message code="complete.all"/></legend>

			<form:hidden path="id" />
			
			<form:hidden path="contacto.id"/>
			
			<form:hidden id="contacto_nombre" path="contacto.nombre"/>
			
			<spring:message code="nombre.contacto" var="nombreC"/>
			<snoop:select items="${contactos}" labelText="${nombreC}" 
				path="contacto.idCrm" id="contacto_idCrm" itemLabel="nombre" itemValue="idCrm" requerido="true" />

			<spring:message code="nombre.mail" var="mailC"/>
			<snoop:input labelText="${mailC}" path="contacto.email" id="email_CF" readOnly="true" />

			<spring:message code="nombre.telefono" var="telefonoC"/>
			<snoop:input labelText="${telefonoC}" path="contacto.telefono" id="telefono_CF" readOnly="true" />

			<spring:message code="nombre.area.perteneciente" var="areaP"/>
			<snoop:input labelText="${areaP}" path="contacto.areaPerteneciente" id="areaPert_CF" requerido="true"/>

			<spring:message code="nombre.area.usuaria" var="areaU"/>	
			<snoop:input labelText="${areaU}" path="areaUsuaria" id="area_usuaria" requerido="true" />

			<div class="form-actions">
				<input type="submit" value="<spring:message code="boton.next"/>" name="commit" class="btn btn-primary" /> 
				<a href="<c:url value="/bandeja" />" class="btn"><spring:message code="boton.cancelar"/></a>  
			</div>

		</form:form>
	</div>
</div>