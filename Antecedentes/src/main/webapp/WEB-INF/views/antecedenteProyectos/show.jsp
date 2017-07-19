<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>

	<div class="row-fluid">
		<div class="span6">
			<h4>Cliente</h4>
			<p>${antecedenteproyecto.cliente.nombre}</p>
		</div>
		<div class="span6">
			<h4>Cliente final</h4>
			<p>${antecedenteproyecto.clienteFinal.nombre}</p>
		</div>
	</div>

	<hr>

	<h4>Servicio</h4>
	<p>${antecedenteproyecto.servicio.nombre}</p>
	<h4>Tipo de solucion de negocio</h4>
	<p>${antecedenteproyecto.tipoSolucion}</p>

	<div class="row-fluid">
		<div class="span6">
			<h4>Pais</h4>
			<p>${antecedenteproyecto.pais.nombre}</p>
		</div>
		<div class="span6">
			<h4>SBU</h4>
			<p>${antecedenteproyecto.sbu.nombre}</p>
		</div>
	</div>

	<div class="row-fluid">
		<div class="span6">
			<h4>Monto y formato de moneda</h4>
			<p>${antecedenteproyecto.montoContrato}
				${antecedenteproyecto.monedaContrato.nombre}</p>
		</div>
		<div class="span6">
			<h4>Cotización de la moneda</h4>
			<p>${antecedenteproyecto.cotizacionMoneda }</p>
		</div>
	</div>


	<hr>

	<h4>Lider de Proyecto</h4>
	<p>${antecedenteproyecto.liderProyecto}</p>

	<hr>

	<h3>Cliente Final</h3>

	<div class="row-fluid">
		<div class="span6">
			<h4>Nombre del contacto</h4>
			<p>${antecedenteproyecto.contacto.nombre}</p>
		</div>
		<div class="span6">
			<h4>Mail del contacto</h4>
			<p>${antecedenteproyecto.contacto.email}</p>
		</div>
	</div>
	<div class="row-fluid">
		<div class="span6">
			<h4>Telefonos del contacto</h4>
			<p>${antecedenteproyecto.contacto.telefono}</p>
		</div>
	</div>
	<h4>Área a la que pertenece el contacto</h4>
	<p>${antecedenteproyecto.contacto.areaPerteneciente}</p>
	<h4>Área que utilizará el sistema</h4>
	<p>${antecedenteproyecto.areaUsuaria}</p>

	<hr>

	<div class="row-fluid">
		<c:if test="${antecedenteproyecto.fechaInicio != null}">
			<div class="span6">
				<h4>Fecha desde</h4>
				<p>${antecedenteproyecto.fechaInicio}</p>
			</div>
		</c:if>
		<c:if test="${antecedenteproyecto.fechaFin != null}">
			<div class="span6">
				<h4>Fecha hasta</h4>
				<p>${antecedenteproyecto.fechaFin}</p>
			</div>
		</c:if>
	</div>

	<div class="row-fluid">
		<c:if test="${antecedenteproyecto.duracion != null}">
			<div class="span6">
				<h4>Duración</h4>
				<p>${antecedenteproyecto.duracion} 
					<c:choose>
						<c:when test="${antecedenteproyecto.duracion == 1}">
					 		mes
					 	</c:when>
					 	<c:otherwise> meses</c:otherwise>
					</c:choose>
				</p>
			</div>
		</c:if>
		
		<c:if test="${antecedenteproyecto.horas != null}">
		<div class="span6">
			<h4>Cantidad de horas del proyecto</h4>
			<p>${antecedenteproyecto.horas}
			<c:choose>
				<c:when test="${antecedenteproyecto.horas == 1}">
			 		hora
			 	</c:when>
			 	<c:otherwise> horas</c:otherwise>
			</c:choose></p>
		</div>
		</c:if>
	</div>
	
	<c:if test="${antecedenteproyecto.recursosPerfiles != null}">
		<h4>Cantidad y perfiles de los recursos asignados</h4>
		<div class="well">${antecedenteproyecto.recursosPerfiles}</div>
	</c:if>
	<c:if test="${antecedenteproyecto.descFuncionalProyecto != null}">
		<h4>Descripción funcional del proyecto</h4>
		<div class="well">${antecedenteproyecto.descFuncionalProyecto}</div>
	</c:if>
	<c:if test="${antecedenteproyecto.descTecnicaProyecto != null}">
		<h4>Descripción técnica del proyecto</h4>
		<div class="well">${antecedenteproyecto.descTecnicaProyecto}</div>
	</c:if>	
	
	<h4>Diagrama</h4>
	<c:choose>
		<c:when test="${not empty antecedenteproyecto.diagrama }">
			<img src="<c:url value="/antecedenteProyectos/getDiagrama/${antecedenteproyecto.id}"/>" height="256px" />
		</c:when>
		<c:otherwise>
			<p>--</p>
		</c:otherwise>
	</c:choose>
	<h4>Logros principales obtenidos</h4>
	<div class="well">${antecedenteproyecto.logrosObtenidos}</div>

</div>