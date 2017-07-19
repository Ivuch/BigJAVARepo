<%@ taglib prefix="snoop" tagdir="/WEB-INF/tags/snoop"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script> 
$(function() {
	$('.popup_rechazo').popover({
		trigger: 'click',
    	placement: 'right',
    	html: true,  	
	});
	
	$('.show-link').click(function() {
		var name = $(this).attr('data-name');
		$('#myModalLabel').text(name);
	
		var id = $(this).attr('tabindex');
		$('#boton_validar').attr('href', '<c:url value="/antecedenteProyectos/validar/" />' + id);
		
		$('#id_antecedente').attr('value',id);
	});
	
	$('.delete-link').click(function() {
		if (confirm("¿Desea borrar este antecedente?")) {
			var link = $(this);
			var index = link.attr('tabindex');
			$.ajax({
				url : '<c:url value="/antecedenteProyectos/" />' + index,
				type : 'DELETE',
				success : function(response) {
					link.closest('tr').remove();
				}
			}); 
		}
	});
	
	// Para que cada vez que se aprieta en ver, cambie la información en el modal
	$('body').on('hidden', '.modal', function() {
		$(this).removeData('modal');
	});
});
</script>
<div class="container">
	<snoop:solap nexo="1"></snoop:solap>
	<table class="table table-striped table-bordered">
		<thead>
			<tr>
				<th><spring:message code="palabra.antecedente"/></th>
				<th><spring:message code="palabra.cliente"/></th>
				<th><spring:message code="palabra.estado"/></th>
				<th><spring:message code="palabra.accion"/></th>
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
						<tr>
							<td>${antecedente.nombre}</td>
							<td>${antecedente.cliente}</td>
							<td>${antecedente.estado}
								<c:if test="${antecedente.estado == 'RECHAZADO'}">
									<i id="rechazo_popover" class="icon-search popup_rechazo" 
										data-content="${antecedente.validaciones.mensaje}"
										data-title="Motivo rechazo"></i>
								</c:if>			
							</td>
							<td>
								<div class="btn-group ">
									<a class="btn dropdown-toggle btn-small" data-toggle="dropdown"
										href="#"> <spring:message code="accion.seleccion"/> <span class="caret"></span>
									</a>
									<ul class="dropdown-menu">
										<li>
											<a class="show-link" data-toggle="modal" href="<c:url value="/antecedenteProyectos/${antecedente.id}" />"
												data-name="${antecedente.nombre}"
												data-target="#ver_antecedente" tabindex="${antecedente.id}"><spring:message code="accion.ver"/></a>
										</li>
										<sec:authorize access="hasRole('CREAR_ANTECEDENTE')">
											<li>							
												<a href="<c:url value="/antecedenteProyectos/${antecedente.id}?form" />"><spring:message code="accion.editar"/></a>								
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
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>	
	
	<div id="ver_antecedente" class="modal hide fade" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header ">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">X—</button>
			<h3 id="myModalLabel">NO PROJECT NAME</h3>
		</div>
		<div class="modal-body"></div>
		<div class="modal-footer">
			<sec:authorize access="hasRole('VALIDAR_ANTECEDENTE')">
				<a id="boton_rechazo" href="#modalRechazo" role="button" class="btn btn-danger"
						data-toggle="modal" data-dismiss="modal" aria-hidden="true"><spring:message code="accion.rechazar"/></a>
				<a id="boton_validar" role="button" class="btn btn-success"><spring:message code="accion.aprobar"/></a>
			</sec:authorize>
		</div>
	</div>	
	
	<div id="modalRechazo" class="modal hide fade" tabindex="-1"
		role="dialog" aria-hidden="true">
		<div class="modal-header ">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">X—</button>
			<h3 id="myModalLabel">Rechazado</h3>
		</div>
		
		<spring:url value="/antecedenteProyectos/rechazar" var="rechazar_form"></spring:url>
		
		<form action="${rechazar_form}" method="post">
			<div class="modal-body">
				<div class="row-fluid">
					<div class="control-group text optional ">
						<label for="texto_rechazo" class="text optional control-label">
							Explique el motivo </label>
						<input id="id_antecedente" name="id_antecedente" type="hidden" />	
						<div class="controls">
							<textarea class="textarea text optional span6"
								name="texto_rechazo" id="texto_rechazo"></textarea>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<input type="submit" class="btn btn-danger" aria-hidden="true"
					value=<spring:message code="accion.rechazar"/> />
				<!--button class="btn btn-success">Aprobar</button-->
			</div>
		</form>
	</div>
	
	<div class="pagination pull-left">
		<ul>
			<c:if test="${maxPages > 1}">
				<li><a href="#">Prev</a></li>
				<c:forEach var="i" begin="1" end="${maxPages}">
					<li><a href="<c:url value="/bandeja?page=${i}&size=${param.size}" />" > 
						<c:out value="${i}" /></a>
					</li>
				</c:forEach>
				<li><a href="#">Next</a></li>
			</c:if>
		</ul>
	</div>
	
	<div class="pull-right">
		<a class="btn btn-big" href="<c:url value="/antecedenteProyectos?form" />"><spring:message code="boton.nuevo.antecedente"/></a>
	</div>
</div>

