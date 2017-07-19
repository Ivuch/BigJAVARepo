<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@attribute name="nroPaso" required="true"%>

<c:choose>
	<c:when test="${antecedenteProyecto.id == null}">
		<h2>
			<spring:message code="nuevo.proyecto"/>
		</h2>
	</c:when>
	<c:otherwise>
		<h2>
			${antecedenteProyecto.nombre} <small>${antecedenteProyecto.clienteFinal.nombre}</small>
		</h2>
	</c:otherwise>
</c:choose>

	<ol class="breadcrumb">
       <li class="${ nroPaso == 1 ? 'active' : ''}">
       			<c:choose>
                       <c:when test="${nroPaso == 1}">
                               <spring:message code="paso.1"/>
                       </c:when>
                       <c:otherwise>
                               <a href="<c:url value="/antecedenteProyectos/${antecedenteProyecto.id}?form" />"><spring:message code="paso.1"/></a>
                       </c:otherwise>
               </c:choose> <span class="divider">/</span></li>
       <li class="${ nroPaso == 2 ? 'active' : ''}"><c:choose>
                       <c:when test="${nroPaso == 2}">
                               <spring:message code="paso.2"/>
                       </c:when>
                       <c:otherwise>
                       <c:choose>
                              <c:when test="${antecedenteProyecto.id != null}"> 
                              	<a href="<c:url value="/antecedenteProyectos/${antecedenteProyecto.id}?form2" />"><spring:message code="paso.2"/></a>
                              </c:when>
                              <c:otherwise><a href="#"><spring:message code="paso.2"/></a></c:otherwise>
                       </c:choose>
                       </c:otherwise>
               </c:choose> <span class="divider">/</span></li>
       <li class="${ nroPaso == 3 ? 'active' : ''}"><c:choose>
                       <c:when test="${nroPaso == 3}">
                               <spring:message code="paso.3"/>
                       </c:when>
                       <c:otherwise>
                       <c:choose>
                              <c:when test="${antecedenteProyecto.id != null}"> 
                              <a href="<c:url value="/antecedenteProyectos/${antecedenteProyecto.id}?form3" />"><spring:message code="paso.3"/></a>
                              </c:when>
                              <c:otherwise><a href="#"><spring:message code="paso.3"/></a></c:otherwise>
                       </c:choose>
                       </c:otherwise>
               </c:choose> <span class="divider">/</span></li>
       <li class="${ nroPaso == 4 ? 'active' : ''}"><c:choose>
                       <c:when test="${nroPaso == 4}">
                               <spring:message code="paso.4"/>
                       </c:when>
                       <c:otherwise>
                        <c:choose>
                              <c:when test="${antecedenteProyecto.id != null}"> 
                              <a href="<c:url value="/antecedenteProyectos/${antecedenteProyecto.id}?form4" />"><spring:message code="paso.4"/></a>
                              </c:when>
                              <c:otherwise><a href="#"><spring:message code="paso.4"/></a></c:otherwise>
                       </c:choose>
                       </c:otherwise>
               </c:choose></li>
</ol>