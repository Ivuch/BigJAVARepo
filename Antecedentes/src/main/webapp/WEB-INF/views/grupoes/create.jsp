<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="snoop" tagdir="/WEB-INF/tags/snoop"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div version="2.0">		
	<div class="page-header">
		<h1>Formulario grupo</h1>
	</div>
	<div>
		
		<spring:url value="/grupoes" var="form" />
		
		<form:form commandName="grupo" class="simple_form form-horizontal" id="grupo" action="${form}" method="POST"
			enctype="application/x-www-form-urlencoded">
			
			<form:hidden path="id"/>
			<form:hidden path="version"/>
			
			<snoop:input labelText="Nombre :" path="nombre" id="nombre" requerido="true"></snoop:input>				
			
			<br />
			<div>
				<label class="string required control-label" for="_permisosUsuarios_id">Permisos Usuarios : </label>
				<div class="controls">
					<form:select path="permisosUsuarios" items="${permisosusuarios}" size="8" multiple="true"></form:select>
				</div>
			</div>
			<br />
			<div >
				<label class="string required control-label" for="_enabled_id">Enabled: </label>
				<div class="controls">
					<form:checkbox path="enabled"/>
				</div>
			</div>
			<br />
			<div class="form-actions submit">
				<input value="Guardar" type="submit" id="proceed" class="btn btn-primary" />
			</div>
		</form:form>
	</div>
</div>
