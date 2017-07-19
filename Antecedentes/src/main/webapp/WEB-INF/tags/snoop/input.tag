<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@attribute name="id" required="true"%>
<%@attribute name="path" required="true"%>
<%@attribute name="labelText" type="java.lang.String" required="true"%>
<%@attribute name="requerido" type="java.lang.Boolean" description="Campo obligatorio. True or false."%>
<%@attribute name="size" type="java.lang.Integer" description="1 a 12, default 4"%>
<%@attribute name="ayudaTexto" type="java.lang.String" description="este texto se mostrara como ayuda debajo del campo"%>
<%@attribute name="readOnly" type="java.lang.Boolean" description="Inhabilitar el campo"%>

<spring:bind path="${path}">
	<div
		class="control-group string required ${id} ${status.error ? 'error' : '' }">
		<!-- se agrega la clase error para marcar el campo en rojo -->
		<label for="${id}" class="string required control-label"> 
			<c:if test="${requerido}">
				<abbr title="required">*</abbr>
			</c:if> ${labelText}
		</label>
		<div class="controls">
			<c:if test="${empty size or size > 12 or size < 1}">
				<c:set var="size" value="4"></c:set>
			</c:if>
			<form:input path="${path}" type="text" id="${id}" class="string required span${size}"
				readonly="${readOnly ? 'true' : '' }" />
			<form:errors path="${path}" cssClass="help-inline" />
			<c:if test="${not empty ayudaTexto}">
				<p class="help-block">${ayudaTexto}</p>
			</c:if>
		</div>
	</div>
</spring:bind>