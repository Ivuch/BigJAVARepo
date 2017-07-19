<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="snoop" tagdir="/WEB-INF/tags/snoop"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:directive.page contentType="text/html;charset=UTF-8" />
<script type="text/javascript">
	function parseDate(str) {
		var mdy = str.split('/');
		return new Date(mdy[2], mdy[1], mdy[0]);
	}

	function monthDiff(first, second) {
		var months, firstDays, secondDays;
		var dif = second - first; //en milisegundos		
		dif = dif / (1000 * 3600 * 24 * 30); //paso a meses
		var round = Math.round(dif);
		return round == 0 ? 1 : round;  
	}

	$(function() {
		$('#datetimepicker1, #datetimepicker2').datepicker({
			format: 'dd/mm/yyyy',
			language : 'es',
            autoclose: true,
      
		}).on('changeDate',	function(ev) {
			if ($('#datetimepicker1').val() != "" && $('#datetimepicker2').val() != "") {
				var duracion = monthDiff(parseDate($('#datetimepicker1').val()),
										 parseDate($('#datetimepicker2').val()));
				if(duracion >= 0){
					$('#duracion').val(duracion);
				}
				else{
					$('#duracion').val("");
				}
			}
			
		});
		
		
		$('.textarea').wysihtml5({
			"font-styles" : false, //Font styling, e.g. h1, h2, etc. Default true
			"emphasis" : false, //Italics, bold, etc. Default true
			"lists" : true, //(Un)ordered lists, e.g. Bullets, Numbers. Default true
			"html" : false, //Button which allows you to edit the generated HTML. Default false
			"link" : false, //Button to insert a link. Default true
			"image" : false, //Button to insert an image. Default true,
			"color" : false, //Button to change color of font  
		});
		
		$('input[type=file]').bootstrapFileInput();
	});
</script>


<div>
	<div class="container master-container">
		<snoop:solap nexo="2"></snoop:solap>
		<snoop:form-header nroPaso="4"></snoop:form-header>

		<spring:url value="/antecedenteProyectos/create/paso/4" var="form_url" />

		<form:form novalidate="novalidate" method="post" id="new_article"
			class="simple_form form-horizontal"
			action="${form_url}" accept-charset="UTF-8"
			commandName="antecedenteProyecto" enctype="multipart/form-data">

			<legend><spring:message code="complete.all"/></legend>

			<form:hidden path="id" />
			
			<spring:message code="nombre.fechaInicio" var="fechaI"/>
			<snoop:datepicker id="datetimepicker1" path="fechaInicio"
				labelText=" ${fechaI}"></snoop:datepicker>

			<spring:message code="nombre.fechaHasta" var="fechaH"/>
			<snoop:datepicker id="datetimepicker2" path="fechaFin"
				labelText=" ${fechaH}"></snoop:datepicker>

			<spring:message code="nombre.duracion" var="duracioN"/>
			<spring:message code="duracion.ayuda.text" var="duracioNayuda"/>
			<snoop:input labelText="${duracioN}" path="duracion" id="duracion"
				ayudaTexto="${duracioNayuda}" size="2" requerido="true" readOnly="true" />

			<spring:message code="nombre.horas" var="horaP"/>
			<snoop:input labelText="${horaP}" path="horas"
				id="horas" size="2" requerido="true" />

			<spring:message code="nombre.perfiles" var="perfiL"/>
			<snoop:textarea
				labelText="${perfiL}"
				path="recursosPerfiles" id="recursos_perfiles" requerido="true"></snoop:textarea>

			<spring:message code="nombre.funcional" var="descF"/>
			<snoop:textarea labelText="${descF}"
				path="descFuncionalProyecto" id="desc_funcional" requerido="true"></snoop:textarea>

			<spring:message code="nombre.tecnica" var="descT"/>
			<snoop:textarea labelText="${descT}"
				path="descTecnicaProyecto" id="desc_tecnica" requerido="true"></snoop:textarea>

			<div class="control-group string required lider_proyecto">
				<label for="lider_proyecto" class="string required control-label">
					<spring:message code="nombre.diagrama"/></label>
				<div class="controls">
					<spring:message code="diagrama.boton" var="diagBoton"/>
					<form:input path="diagrama" type="file"
						title="${diagBoton}" />
					<form:errors path="diagrama" />
				</div>
			</div>

			<spring:message code="nombre.logrosObtenidos" var="logroS"/>
			<snoop:textarea labelText="${logroS}"
				path="logrosObtenidos" id="logros_obtenidos" requerido="true"></snoop:textarea>

			<spring:message code="nombre.palabras.clave" var="TagS"/>
			<spring:message code="palabras.clave.ayuda" var="ayudaTagS"/>
			<snoop:input labelText="${TagS}" path="tags" id="tags"
				ayudaTexto="${ayudaTagS}" requerido="true"></snoop:input>

			<div class="form-actions">
				<input type="submit" value="<spring:message code="boton.next"/>" name="commit" class="btn btn-primary">
				<a href="<c:url value="/bandeja" />" class="btn"><spring:message code="boton.cancelar"/></a>  	
				<!--input type="reset" value="Cancelar" name="commit" class="btn" -->
				<!--<span class="badge">Guardado</span> -->
			</div>
		</form:form>

	</div>
</div>
