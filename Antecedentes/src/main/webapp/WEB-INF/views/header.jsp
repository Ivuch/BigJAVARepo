<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="navbar navbar-static-top">
	<div class="navbar-inner">
		<div class="container header">
			<div>
				<div class="brand">
					<a href="<spring:url value="/bandeja" />"><img src="<spring:url value="/images/logo.png" />" /></a>
				</div>
				<div class="navbar-content">
					<ul class="nav ">
						<li class="dropdown"><a onclick="return false;" href="#"
							class="dropdown-toggle" data-toggle="dropdown"><spring:message code="palabra.lenguaje"/> <b
								class="caret"></b></a>
							<ul class="dropdown-menu">
								<spring:url var="langEs" value="?lang=es" htmlEscape="true"/>
								<li><a  href="${langEs}">Español</a></li>
								<spring:url var="langEn" value="?lang=en" htmlEscape="true"/>
								<li><a  href="${langEn}">Ingles</a></li>
							</ul></li>
					</ul>
				</div>

				<div class="btn-group pull-right">
					<a class="btn dropdown-toggle" data-toggle="dropdown" href="#"><sec:authentication
							property="principal.username" /> <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="<c:url value="/resources/j_spring_security_logout"/> "><spring:message code="eleccion.logout"/></a></li>
						<!-- Acá va el alta de usuarios / Administracion de Usuarios -->
						<sec:authorize access="hasRole('ADMINISTRAR_USUARIOS')">
							<li><a href="<c:url value="/usuarios"/>"><spring:message code="eleccion.admin.user"/></a></li>
						</sec:authorize>
						<sec:authorize access="hasRole('ADMINISTRAR_GRUPOS')">
							<li><a href="<c:url value="/grupoes"/> "><spring:message code="eleccion.admin.group"/></a></li>
						</sec:authorize>
						<sec:authorize access="hasRole('ADMINISTRAR_TABLAS_MAESTRAS')">
							<li><a href="<c:url value="/sbus"/> "><spring:message code="eleccion.admin.sbus"/></a></li>
							<li><a href="<c:url value="/monedas"/> "><spring:message code="eleccion.admin.monedas"/></a></li>
							<li><a href="<c:url value="/servicios"/> "><spring:message code="eleccion.admin.servicios"/></a></li>
							<li><a href="<c:url value="/reindexar"/> "><spring:message code="eleccion.admin.reindexar"/></a></li>
						</sec:authorize>
					</ul>
				</div>

			</div>
		</div>
	</div>
</div>
