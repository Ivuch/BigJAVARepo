<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@attribute name="nexo" required="true"%>


<div class="page-header">
	<h1>
		<c:choose>
			<c:when test="${nexo == 1}"><spring:message code="titulo.inicial"/></c:when>
			<c:when test="${nexo == 2}"><spring:message code="titulo.antecedentes"/></c:when>
			<c:when test="${nexo == 3}"><spring:message code="titulo.reportes"/></c:when>
			<c:otherwise>Home</c:otherwise>
		</c:choose>
	</h1>
</div>

<spring:url value="/bandeja" var="url_bandeja" />
<spring:url value="/antecedenteProyectos" var="url_antecedentes" />
<spring:url value="/reporte" var="url_reporte" />

<ul class="nav nav-tabs">
<!-- se agrega la clase active para marcar el campo como activo -->
	<li class="${ nexo == 1 ? 'active' : ''}">
		<a href="${url_bandeja}"><spring:message code="solapa.bandeja"/></a>
	</li>
	<li class="${ nexo == 2 ? 'active' : ''}">
		<a href="${url_antecedentes}"><spring:message code="solapa.antecedente"/></a>
	</li>
	<li class="${ nexo == 3 ? 'active' : ''}">
		<a href="${url_reporte}"><spring:message code="solapa.reporte"/></a>
	</li>
</ul>

