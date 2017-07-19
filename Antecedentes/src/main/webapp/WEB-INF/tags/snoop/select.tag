<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@attribute name="id" required="true" %>
<%@attribute name="path" required="true" %>
<%@attribute name="labelText" type="java.lang.String" required="true" %>
<%@attribute name="requerido" type="java.lang.Boolean" description="Campo obligatorio. True or false." %>
<%@attribute name="items" type="java.lang.Object" required="true" description="parámetro items de form:select" %>
<%@attribute name="itemLabel" description="parámetro itemLabel de form:select" %>
<%@attribute name="itemValue" description="parámetro itemValue de form:select" %>

<spring:bind path="${path}">
	<div class="control-group select optional ${id} ${status.error ? 'error' : '' }">
		<label for="${id}" class="select optional control-label">
		<c:if test="${requerido}">	
			<abbr title="required">*</abbr>
		</c:if> 
		${labelText}
		</label>
		<div class="controls">
			<c:choose>
				<c:when test="${not empty itemLabel and not empty itemValue}">
					<form:select id="${id}" path="${path}" cssClass="select optional" multiple="false">
						<form:option value="">&nbsp;</form:option>
     					<form:options items="${items}" itemLabel="${itemLabel}" itemValue="${itemValue}"  />
					</form:select>
				</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${empty itemLabel and empty itemValue}">
							<form:select id="${id}" path="${path}" items="${items}" cssClass="select optional" multiple="false"/>							
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${empty itemLabel and not empty itemValue}">
									<form:select id="${id}" path="${path}"  itemValue="${itemValue}" items="${items}" cssClass="select optional" multiple="false"/>							
								</c:when>
								<c:otherwise>
									<form:select id="${id}" path="${path}" itemLabel="${itemLabel}" items="${items}" cssClass="select optional" multiple="false"/>
								</c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose>
				</c:otherwise>
			</c:choose>
			<form:errors path="${path}" cssClass="help-inline" />
		</div>
	</div>
</spring:bind>