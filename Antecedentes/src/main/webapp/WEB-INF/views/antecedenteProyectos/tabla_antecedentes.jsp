<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<script>
//@ sourceURL=dynamicScript.js
$(function() {	
	$('.show-link').click(function() {
		var name = $(this).attr('data-name');
		var id = $(this).attr('tabindex');
		$('#myModalLabel').text(name);
		$('#boton_imprimir').attr({'href': '<c:url value="/imprimir/"/>'+ id});
	});
	
	$('.delete-link').click(function() {
		if (confirm("¿Desea borrar este antecedente?")) {
			var index = $(this).attr('tabindex');
			$.ajax({
				url : '<c:url value="/antecedenteProyectos/"/>' + index,
				type : 'DELETE',
				success : function(response) {
					window.location.href = "/antecedenteProyectos";
				}
			});
		}
	});
	
	// Para que cada vez que se aprieta en ver, cambie la información en el modal
	$('body').on('hidden', '.modal', function() {
		$(this).removeData('modal');
	});
	
	$('.page-link').click(function(){
		var page = $(this).html();
		$.get('/buscar', $("#buscador").serialize() + "&page=" + page, function(data) {
			$('#antecedentes_tabla').html(data);
		});
		return false;			
	});	
	$('#imprimir_lista2').click(function(){
		var ids = "";
		$('#tabla_buscador tbody tr').each(function(index){
			ids = ids + $(this).attr('id') + ",";
		});
		ids = ids.slice(0, -1); 	
		$('#ids').val(ids); 
		if(ids != ""){
			$(this).attr('href','<c:url value="/imprimir/lista?ids="/>'+ids);
			}
		else{$(this).attr('href','#');}
	});
	
});
</script>

<c:if test="${tipoBotones == 2}">
<script type="text/javascript">
	$(function(){
		$(".rowLink").click(function () {
	
	   		// get the row containing this link
		    var row = $(this).closest("tr");
		 
		    // find out in which table it resides
		    var tableId = $(this).closest("table").attr('id');
		   	
		    if(tableId == 'tabla_buscador') {
		    	seleccionarFila(row, $(this));
		    } else if(tableId == 'tabla_seleccion'){
		    	deseleccionarFila(row, $(this));
		    }
		});
	});	
	</script>

</c:if>
<table id="tabla_buscador" class="table table-striped table-bordered">
	<thead>
		<tr>
			<th><spring:message code="palabra.antecedente" /></th>
			<th><spring:message code="palabra.cliente" /></th>
			<th><spring:message code="palabra.estado" /></th>
			<th><spring:message code="palabra.accion" /></th>
		</tr>
	</thead> 
	<tbody>
		<c:choose>
			<c:when test="${empty antecedentes}">
				<!-- mostrar cuando no haya registros -->
				<tr>
					<td colspan="4"><p style="text-align: center;"><spring:message code="mensaje.bandeja"/></p></td>
				</tr>
				<!-- fin mostrar cuando no haya registros -->
			</c:when>
			<c:otherwise>
				<c:forEach items="${antecedentes}" var="antecedente">
					<tr id="${antecedente.id}">
						<td>${antecedente.nombre}</td>
						<td>${antecedente.cliente}</td>
						<td>${antecedente.estado}</td>						
						<c:if test="${empty tipoBotones or tipoBotones == 1}">
							<td>
								<div class="btn-group ">
									<a class="btn dropdown-toggle btn-small" data-toggle="dropdown"
										href="#"> <spring:message code="accion.seleccion"/> <span class="caret"></span>
									</a>
									<ul class="dropdown-menu">
										<li>
											<a class="show-link" data-toggle="modal" href="<c:url value="/antecedenteProyectos/${antecedente.id}"/>"
												data-target="#ver_antecedente" data-name="${antecedente.nombre}" tabindex="${antecedente.id}"><spring:message code="accion.ver"/></a>
										</li>
										<sec:authorize access="hasRole('CREAR_ANTECEDENTE')">
											<li>							
												<a href="<c:url value="/antecedenteProyectos/${antecedente.id}?form"/> "><spring:message code="accion.editar"/></a>								
											</li>
										</sec:authorize>
										<sec:authorize access="hasRole('BORRAR_ANTECEDENTE')">
											<li>														
												<a class="delete-link" tabindex="${antecedente.id}"	href="#"><spring:message code="accion.borrar"/></a>	
											</li>
										</sec:authorize>
									</ul>
								</div>
							</td>
						</c:if>
						<c:if test="${tipoBotones == 2}">
							<td>
								<div class="btn-group " style="align:center">
								
									<a class="show-link btn btn-small" style="padding-left:5px" data-toggle="modal" 
										href="<c:url value="/antecedenteProyectos/${antecedente.id}"/>" data-target="#ver_antecedente" 
										data-name="${antecedente.nombre}" tabindex="${antecedente.id}"><spring:message code="accion.ver"/></a>
								
									<a class="btn  btn-small rowLink" id="rowbutton${antecedente.id}" data-toggle="dropdown" href="#">
											<spring:message code="accion.seleccionar"/> </a>
								</div>
							</td>
						</c:if>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>	

<div class="pull-right" style="padding-right: 15px;">
	<a class="btn btn-big" id="imprimir_lista2" href="#"><spring:message code="boton.imprimir.lista"/></a>
</div>
	
	
<div id="ver_antecedente" class="modal hide fade" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-header ">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">X—</button>
		<h3 id="myModalLabel">NO PROJECT NAME</h3>
	</div>
	<div class="modal-body"></div>
	<div class="modal-footer">
		<a id="boton_imprimir" href="#" role="button" class="btn" aria-hidden="true">
			<i class="icon-print"></i>
			<spring:message code="boton.imprimir.antecedente"/>
		</a>
	</div>
</div>	

<div class="pagination pull-left">
	<ul>
		<c:if test="${maxPages > 1}">
			<li><a href="#">Prev</a></li>
			<c:forEach var="i" begin="1" end="${maxPages}">
				<li><a href="#" class="page-link"><c:out value="${i}" /></a></li>
			</c:forEach>
			<li><a href="#">Next</a></li>
		</c:if>
	</ul>
</div>