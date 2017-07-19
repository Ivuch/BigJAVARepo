<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@attribute name="id" required="true"%>
<%@attribute name="path" required="true"%>
<%@attribute name="labelText" type="java.lang.String" required="true"%>

<spring:bind path="${path}">
	<div 
		class="control-group string required ${status.error ? 'error' : '' }">
		<label for="${id}" class="string required control-label">
			<abbr title="required">*</abbr> Fecha${labelText}
		</label>
		<div class="controls date">
			<form:input path="${path}" id="${id}" autocomplete="off" /> 
			<form:errors path="${path}" cssClass="help-inline"/>
		</div>
	</div>
</spring:bind>