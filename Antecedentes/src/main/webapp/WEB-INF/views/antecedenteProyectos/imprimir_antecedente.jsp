<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
	<title>Home</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
	<link rel="stylesheet" href="<c:url value="/themes/snoop/bootstrap.css"/> " media="print, screen">
	<link rel="stylesheet" href="<c:url value="/css/bootstrap-responsive.css"/> ">
	<script src="<c:url value="/js/jquery.min.js"/> "></script>
	<script src="<c:url value="/js/bootstrap.min.js"/> "></script>
</head>
<body style="background:none;">
  	<div class="navbar navbar-static-top">
    	<div>
      		<div class="container">
	        	<div class="brand"><img src="<c:url value="/images/header_imprimir.jpg"/>" /></div>
      		</div>
    	</div>
  	</div>
  	<div class="container">
    	<div class="page-header">
      		<h2>${antecedente.nombre}</h2>
    	</div>
    	<div class="container">
      		<div class="row-fluid">
        		<table width="100%">
          			<tr>
          				<c:if test="${antecedente.cliente != null}">
            				<td width="50%">
            					<div class="span6">
            						<h4>Cliente</h4>
              						<p>${antecedente.cliente}</p>
              					</div>
              				</td>
            			</c:if>
          				<c:if test="${antecedente.clienteFinal != null}">
            				<td width="50%">
            					<div class="span6">
            						<h4>Cliente final</h4>
              						<p>${antecedente.clienteFinal}</p>
              					</div>
              				</td>
            			</c:if>
          			</tr>
        		</table>               
      		</div>

      		<hr>
		      
      		<c:if test="${antecedente.servicio.nombre != null}">
      			<h4>Servicio</h4>
        		<p>${antecedente.servicio.nombre}</p>
      		</c:if>
            <c:if test="${antecedente.tipoSolucion != null}">
            	<h4>Tipo de solucion de negocio</h4>
              	<p>${antecedente.tipoSolucion}</p>
            </c:if>

            <div class="row-fluid">
            	<table width="100%">
          			<tr>
         				<c:if test="${antecedente.pais.nombre != null}">
            				<td width="50%">
            					<div class="span6">
	            					<h4>Pais</h4>
    	          					<p>${antecedente.pais.nombre}</p>
    	          				</div>
    	          			</td>
    	          		</c:if>
         				<c:if test="${antecedente.sbu.nombre != null}">   
            				<td width="50%">
            					<div class="span6">
            						<h4>SBU</h4>
              						<p>${antecedente.sbu.nombre}</p>
              					</div>
              				</td>
              			</c:if>
          			</tr>
        		</table>
        	</div>
              
            <c:if test="${antecedente.montoContrato != null}">
            	<h4>Monto y formato de moneda</h4>
              	<p>${antecedente.montoContrato} ${antecedente.monedaContrato.nombre}</p>
            </c:if>

            <hr>
              
            <c:if test="${antecedente.liderProyecto != null}">
            	<h4>Lider de Proyecto</h4>
              	<p>${antecedente.liderProyecto}</p>
            </c:if>
              
            <hr>
              
            <h3>Datos de Contacto - Cliente Final</h3>
              
            <div class="row-fluid">             
              	<table width="100%">
          			<tr>
          	 			<c:if test="${antecedente.contacto.nombre != null}">
            				<td width="50%">
            					<div class="span6">
	            					<h4>Nombre del contacto</h4>
    	          					<p>${antecedente.contacto.nombre}</p>
    	          				</div>
    	          			</td>
    	          		</c:if>
              			<c:if test="${antecedente.contacto.email != null}">
            				<td width="50%">
            					<div class="span6">
            						<h4>Mail del contacto</h4>
              						<p>${antecedente.contacto.email}</p>
              					</div>
              				</td>
              			</c:if>
          			</tr>
        		</table>              
            </div>
            
            <div class="row-fluid">
              	<c:if test="${antecedente.contacto.telefono != null}">
                	<div class="span6">
                		<h4>Telefonos del contacto</h4>
              			<p>${antecedente.contacto.telefono}</p>
              		</div>
              	</c:if>
            </div>
            <c:if test="${antecedente.contacto.areaPerteneciente != null}">
            	<h4>Area a la que pertenece el contacto</h4>
              	<p>${antecedente.contacto.areaPerteneciente}</p>
            </c:if>
            <c:if test="${antecedente.areaUsuaria != null}">
            	<h4>Area que utilizara el sistema</h4>
              	<p>${antecedente.areaUsuaria}</p>
            </c:if>

            <hr>
              
            <div class="row-fluid">              
              	<table width="100%">
          			<tr>
           				<c:if test="${antecedente.fechaInicio != null}">
            				<td width="50%">
            					<div class="span6">
            						<h4>Fecha desde</h4>
              						<p>${antecedente.fechaInicio}</p>
              					</div>
              				</td>
              			</c:if>
               			<c:if test="${antecedente.fechaFin != null}">
            				<td width="50%">
            					<div class="span6">
            						<h4>Fecha hasta</h4>
              						<p>${antecedente.fechaFin}</p>
              					</div>
              				</td>
              			</c:if>
          			</tr>
        		</table>              
            </div>
              
            <div class="row-fluid">             
            	<table width="100%">
          			<tr>
           				<c:if test="${antecedente.duracion != null}">
            				<td width="50%">
            					<div class="span6">
            						<h4>Duracion</h4>
              						<p>${antecedente.duracion} 
										<c:choose>
											<c:when test="${antecedente.duracion == 1}">
			 									mes
			 								</c:when>
			 								<c:otherwise> meses</c:otherwise>
										</c:choose>
									</p>
								</div>
							</td>
						</c:if>
			 			<c:if test="${antecedente.horas != null}">
            				<td width="50%">
            					<div class="span6">
            						<h4>Cantidad de horas del proyecto</h4>
              						<p>${antecedente.horas}
              							<c:choose>
              								<c:when test="${antecedente.horas == 1}">
			 									hora
			 								</c:when>
			 								<c:otherwise> horas</c:otherwise>
										</c:choose>
									</p>
								</div>
							</td>
						</c:if>
          			</tr> 
        		</table>
            </div>
			
			<c:if test="${antecedente.recursosPerfiles != null}">
            	<h4>Cantidad y perfiles de los recursos asignados</h4>
              	<div class="well">${antecedente.recursosPerfiles}</div>
            </c:if>
              
            <c:if test="${antecedente.descFuncionalProyecto != null}">
              	<h4>Descripcion funcional del proyecto</h4>
              	<div class="well">${antecedente.descFuncionalProyecto}</div>
            </c:if>
            
            <c:if test="${antecedente.descTecnicaProyecto != null}">
              	<h4>Descripcion tecnica del proyecto</h4>
              	<div class="well">${antecedente.descTecnicaProyecto}</div>
            </c:if>
              
            <c:if test="${antecedente.diagrama != null}">
            	<h4>Diagrama</h4>
              	<c:choose>
					<c:when test="${not empty antecedenteproyecto.diagrama }">
						<img src="/antecedenteProyectos/getDiagrama/${antecedenteproyecto.id}" height="256px" />
					</c:when>
					<c:otherwise>
						<p>--</p>
					</c:otherwise>
				</c:choose>
			</c:if>
			
			<c:if test="${antecedente.logrosObtenidos != null}">
            	<h4>Logros principales obtenidos</h4>
              	<div class="well">${antecedente.logrosObtenidos}</div>
            </c:if>  
    	</div>
  	</div>
</body>
</html>