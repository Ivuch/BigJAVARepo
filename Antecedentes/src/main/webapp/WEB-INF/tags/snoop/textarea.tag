<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@attribute name="id" required="true"%>
<%@attribute name="path" required="true"%>
<%@attribute name="labelText" type="java.lang.String" required="true"%>
<%@attribute name="requerido" type="java.lang.Boolean"
	description="Campo obligatorio. True or false."%>

<spring:bind path="${path}">
	<div 
		class="control-group string required  ${status.error ? 'error' : '' }">
		<label for="${id}" class="string required control-label"> <c:if
				test="${requerido}">
				<abbr title="required">*</abbr>
			</c:if> ${labelText}
		</label>
		<div class="controls" id="${id}">
			<spring:message code="nombre.placeholder" var="placeH"/>
			<form:textarea path="${path}" class="textarea text optional span6"
				placeholder="${placeH}"
				name="txa"
				minlenght="50"
				style="width: 600px; height: 200px" />
			<form:errors path="${path}" cssClass="help-inline"/>
		</div>
	</div>
</spring:bind>