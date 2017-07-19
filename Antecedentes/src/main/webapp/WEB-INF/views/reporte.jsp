<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="snoop" tagdir="/WEB-INF/tags/snoop"%>
<jsp:directive.page contentType="text/html;charset=UTF-8" />

<script type="text/javascript">		
	function checkAll(check){
		$('#camposReporte .check_boxes').each(function (index) {
	        $(this).prop('checked', check);
	    });
	}
	
	function enviarForm(){
		var ids = "";
		$('#tabla_seleccion tbody tr').each(function(index){
			ids = ids + $(this).attr('id') + ",";
		});
		ids = ids.slice(0, -1); //saco la ultima coma	
		$('#ids').val(ids); 
		if(ids.length > 0){
			$('#camposReporte').submit();
		}
	}
	
	function seleccionarFila(row, button){
		var rows = $('#tabla_seleccion tbody #' + row.attr('id'));
		if(rows.length == 0){
			row.detach();
	    	$("#tabla_seleccion").append(row);
			row.fadeOut();
	        button.text("Quitar");
	        row.fadeIn();
		} else {
			//alert('Antecedente ya seleccionado');
		}
	}
	
	function deseleccionarFila(row, button){
		var rows = $('#tabla_buscador tbody #' + row.attr('id'));
		row.detach();
		if(rows.length == 0){	    		
			$("#tabla_buscador").append(row);
	    	row.fadeOut();
	    	button.text("Seleccionar");
	    	row.fadeIn();
		}
	}
	
	$(function(){
		$('#buscador').submit(function(){
			$.get('<c:url value="/buscar"/> ', $("#buscador").serialize() + "&tipoBotones=2", function(data) {
				$('#antecedentes_tabla').html(data);
			});
			return false;			
		});
	
	$("#elegir_todos").click(function () {
		$('#tabla_buscador tbody tr').each(function(){
			var row = $(this).closest("tr");
			var button = $('#tabla_buscador tbody tr td .rowLink');				
			seleccionarFila(row,button);
	 	});
		
	});
	
	$('#quitar_todos').click(function(){
		$('#tabla_seleccion tbody tr').each(function(){
			var row = $(this).closest("tr");
			var button = $('#tabla_seleccion tbody tr td .rowLink');
			deseleccionarFila(row, button);			
		});
		
	});
	
	$('#imprimir_lista').click(function(){
		var ids = "";
		$('#tabla_seleccion tbody tr').each(function(index){
			ids = ids + $(this).attr('id') + ",";
		});
		ids = ids.slice(0, -1); 	
		$('#ids').val(ids); 
		if(ids != ""){
		$(this).attr('href','/imprimir/lista?ids='+ids);
		}
		else{$(this).attr('href','#');}
	});
	
});
</script>

<div>

	<div class="container master-container">
		<snoop:solap nexo="3"></snoop:solap>
		
	 	<jsp:include page="buscador.jsp" />
		
		<div class="row-fluid">
			<div class="span6">
				<div class="row-fluid">
					<div class="pull-left">
						<h4><spring:message code="sub.titulo.resultados"/></h4>
					</div>
				</div>
				
				<div id="antecedentes_tabla">
				<table  class="table table-striped table-bordered">
		          <thead>
	            	<tr>
						<th><spring:message code="palabra.antecedente"/></th>
						<th><spring:message code="palabra.cliente" /></th>
						<th><spring:message code="palabra.estado" /></th>
						<th><spring:message code="palabra.accion" /></th>
					</tr>
		          </thead>
				</table>
			</div>
		</div>
			
			<div class="span6 last">
				<div class="row-fluid">
					<div class="pull-left">
						<h4><spring:message code="sub.titulo.elegidos"/></h4>
					</div>
					<div class="pull-right">
						<button id="elegir_todos" class="btn"><spring:message code="boton.elegir.todos"/></button>
					 	<button id="quitar_todos" class="btn"><spring:message code="boton.quitar.todos"/></button>
					 </div>
				</div>
			<table id="tabla_seleccion" class="table table-striped table-bordered">
         		<thead>
         			<tr>
						<th><spring:message code="palabra.antecedente" /></th>
						<th><spring:message code="palabra.cliente" /></th>
						<th><spring:message code="palabra.estado" /></th>
						<th><spring:message code="palabra.accion" /></th>
					</tr>
          		</thead>
          		<tbody>
			
          		</tbody>
        	</table>
		</div>
			
			<div class="pull-right" style="padding-left: 15px">
				<a onClick="$('#myModal').css('width', '500px').css('margin-left','-250px'); $('#myModal .modal-body').css('height', ($(document).height()-300)+'px');" href="#myModal" role="button" class="btn btn-primary" data-toggle="modal"><i class="icon-white icon-file"></i> <spring:message code="boton.preparar.informe"/></a>
			</div>
			<div class="pull-right">
				<a id="imprimir_lista" class="btn btn-big" href="/imprimir/lista"><spring:message code="boton.imprimir.lista"/></a>
			</div>
		</div>		
    </div>
</div>

<!-- Modal -->
<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-header ">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		<h3 id="myModalLabel"><spring:message code="boton.preparar.informe"/></h3>
	</div>
	<div class="modal-body">
	
		<spring:url value="/reporte/generarReporte" var="reporte_form"></spring:url>
		<form:form commandName="camposReporte" action="${reporte_form}" method="POST" id="camposReporte">
			<div class="row-fluid">
				<div class="span6">
					<label class="checkbox ">
						<form:checkbox path="cliente" class="check_boxes optional" /><spring:message code="nombre.cliente"/>
					</label>
				</div>
			</div>
		
			<hr>
				
			<label class="checkbox ">
				<form:checkbox path="servicio" class="check_boxes optional" /><spring:message code="nombre.servicio"/>
			</label>
				
			<label class="checkbox ">
				<form:checkbox path="tipoSolucion" class="check_boxes optional" /><spring:message code="nombre.tipo.solucion"/>
			</label>
				
			<div class="row-fluid">
				<div class="span6">
					<label class="checkbox ">
						<form:checkbox path="pais" class="check_boxes optional" /><spring:message code="nombre.pais"/>
					</label>
				</div>
				
				<div class="span6">
					<label class="checkbox ">
						<form:checkbox path="sbu" class="check_boxes optional" /><spring:message code="nombre.sbu"/>
					</label>
				</div>
			</div>
				
			<label class="checkbox ">
				<form:checkbox path="monto" class="check_boxes optional" /><spring:message code="nombre.monto"/>
			</label>		
		
			<hr>
				
			<label class="checkbox ">
				<form:checkbox path="lider" class="check_boxes optional" /><spring:message code="nombre.lider"/>
			</label>		
				
			<hr>
				
			<div class="row-fluid">
				<div class="span6">
					<label class="checkbox ">
						<form:checkbox path="contacto" class="check_boxes optional" />Datos del contacto
					</label>
				</div>
				<div class="span6">
					<label class="checkbox ">
						<form:checkbox path="areaUsuaria" class="check_boxes optional" />Área que utilizará el sistema
					</label>
				</div>
			</div>	
		
			<hr>
				
			<div class="row-fluid">
				<div class="span6">
					<label class="checkbox ">
						<form:checkbox path="fechaInicioFin" class="check_boxes optional" />Fechas
					</label>
				</div>
			</div>
				
			<div class="row-fluid">
				<div class="span6">
					<label class="checkbox ">
						<form:checkbox path="duracion" class="check_boxes optional" />Duración
					</label>
				</div>
				<div class="span6">
					<label class="checkbox ">
						<form:checkbox path="horas" class="check_boxes optional" />Cantidad de horas del proyecto
					</label>
				</div>
			</div>
		
			<label class="checkbox ">
				<form:checkbox path="perfilesRecursos" class="check_boxes optional" />Cantidad y perfiles de los recursos asignados
			</label>		
				
			<label class="checkbox ">
				<form:checkbox path="descFuncional" class="check_boxes optional" />Descripción funcional del proyecto
			</label>
			
			<label class="checkbox ">
				<form:checkbox path="descTecnica" class="check_boxes optional" />Descripción técnica del proyecto
			</label>
			
			<label class="checkbox ">
				<form:checkbox path="diagrama" class="check_boxes optional" />Diagrama
			</label>
				
			<label class="checkbox ">
				<form:checkbox path="logros" class="check_boxes optional" />Logros principales obtenidos
			</label>	
			
			<form:hidden path="ids" />
		</form:form>				
		
	</div>
	<div class="modal-footer">
		<button class="btn" onclick="checkAll(true)"><spring:message code="boton.seleccionar.todo"/></button>
		<button class="btn" onclick="checkAll(false)"><spring:message code="boton.deseleccionar.todo"/></button>
		<button class="btn btn-primary" onclick="enviarForm()"><i class="icon-white icon-ok"></i> <spring:message code="boton.descargar"/></button>
	</div>
</div>
<!-- fin Modal -->
			
