<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="snoop" tagdir="/WEB-INF/tags/snoop"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<script type="text/javascript">
	$(function() {
		$('#buscador').submit(function() {
			$.get('<c:url value="/buscar"/>', $("#buscador").serialize(), function(data) {
				$('#antecedentes_tabla').html(data);
			});
			return false;
		});
	});
	<!--
//-->
</script>
<div class="container">
	<snoop:solap nexo="2"></snoop:solap>

	<jsp:include page="../buscador.jsp" />

	<div id="antecedentes_tabla"></div>


	<div class="pull-right" style="padding-right: 15px;"> 
		<a class="btn btn-big" href="<c:url value="/antecedenteProyectos?form"/> "><spring:message code="boton.nuevo.antecedente"/></a>
	</div>

</div>