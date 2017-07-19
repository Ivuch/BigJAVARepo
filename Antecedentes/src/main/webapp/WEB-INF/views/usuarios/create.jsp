<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="snoop" tagdir="/WEB-INF/tags/snoop"%>
<div version="2.0">
	<div class="page-header">
		<h1>Formulario usuario</h1>
	</div>
	
	<spring:url value="/usuarios"  var="form"/>	
	
	<form:form commandName="usuario" class="simple_form form-horizontal" id="usuario" action="${form}" method="POST"
		enctype="application/x-www-form-urlencoded">
		
		<form:hidden path="id"/>
		<form:hidden path="version"/>
		
		<snoop:input labelText="Username :" path="username" id="username" requerido="true"></snoop:input>
		
		<snoop:input labelText="Nombre :" path="nombre" id="nombre" requerido="true"></snoop:input>
		
		<snoop:input labelText="Email :" path="email" id="email" requerido="true"></snoop:input>
		
		<div class="control-group string required"
			id="_c_com_snoopconsulting_antecedentes_domain_Usuario_password_id">
			<label class="string required control-label" for="_password_id">Password : </label>
			<div class="controls">
				<form:password path="password" />
				<form:errors path="password" />
			</div>
		</div>
		
		<div class="control-group string required" id="__id">
			<label class="string required control-label" for="_enabled_id">Enabled: </label>
			<div class="controls">
				<form:checkbox path="enabled"/>
			</div>
		</div>
		
		<div class="control-group string required"
			id="_c_com_snoopconsulting_antecedentes_domain_Usuario_grupos_id">
			<label class="string required control-label" for="_grupos_id">Grupos : </label>
			<div class="controls">
				<form:select path="grupos" items="${grupoes}" itemLabel="nombre" itemValue="id" multiple="true"></form:select>
			</div>
		</div>
		
		<div id="fc_com_snoopconsulting_antecedentes_domain_Usuario_submit"
			class="form-actions submit">						
			<input value="Guardar" type="submit" id="proceed" class="btn btn-primary" />
		</div>
	</form:form>
</div>
