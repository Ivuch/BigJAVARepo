<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="snoop" tagdir="/WEB-INF/tags/snoop"%>
<jsp:directive.page contentType="text/html;charset=UTF-8" />
<script type="text/javascript">

	var accountNames = new Array();
	var accounts = new Object();
	
	function getCuentas(query, process){
		$.ajax({
            url: '<c:url value="/getCuentas" />',
            type: 'get',
            data: {query: query},
            dataType: 'json',
            success: function(json) {
            	accountNames = new Array();
            	accounts = new Object();
            	$.each( json, function ( index, account ){            		
            		accountNames.push( account.nombre );
            		accounts[account.nombre] = account;            		
                });
                return process(accountNames);
            }
        });
	}

	$(function() {
		
		$('#cliente_link, #cliente_final_link').click(function() {
			window.open($(this).prop('href'));
			return false;
		  });
		
		$('#cliente').typeahead({
				source: getCuentas,
			    minLength: 2,
			    updater: function(accountName){
			    	if(!$('#clienteFinal').val()){
				    	$('#clienteFinal').val(accountName);
				    	$('#clienteFinal').trigger('change');
			    	}
			    	return accountName;
			    }
		});
		
		$('#clienteFinal').typeahead({
			source: getCuentas,
		    minLength: 2
	});
		
		$('#clienteFinal').change(function(){
			var account = accounts[$( this ).val()];
			if(account){
		    	$('#clienteFinalId').val(account.idCrm);
		    	$('#cliente_final_direccion').val(account.direccion);
		    	$('#cliente_final_telefono').val(account.telefono);
		    	$('#cliente_final_vertical').val(account.vertical);
		    	$('#cliente_final_link').attr('href',account.linkCRM);
			}
			else {
		    	$('#clienteFinalId').val(account.idCrm);
		    	$('#cliente_final_direccion').val("");
		    	$('#cliente_final_telefono').val("");
		    	$('#cliente_final_vertical').val("");
		    	$('#cliente_final_link').attr('href','');
			}
	    });
		
		$('#cliente').change(function(){
			var account = accounts[$( this ).val()];
			if(account){
		    	$('#clienteId').val(account.idCrm);
		    	$('#cliente_direccion').val(account.direccion);
		    	$('#cliente_telefono').val(account.telefono);
		    	$('#cliente_vertical').val(account.vertical);
		    	$('#cliente_link').attr('href',account.linkCRM);
			} else {
		    	$('#clienteId').val("");
		    	$('#cliente_direccion').val("");
		    	$('#cliente_telefono').val("");
		    	$('#cliente_vertical').val("");
		    	$('#cliente_link').attr('href','');
			}
	    });
		
	});
	<!--
//-->
</script>
<div>

	<div class="container master-container">
		<snoop:solap nexo="2"></snoop:solap>
		<snoop:form-header nroPaso="1"></snoop:form-header>
		
		<spring:url value="/antecedenteProyectos/create/paso/1" var="form_url" />

		<form:form method="post" commandName="antecedenteProyecto"
			class="simple_form form-horizontal"
			action="${form_url}" accept-charset="UTF-8">
			<legend><spring:message code="complete.all"/></legend>

			<form:hidden path="id" />

			<spring:message code="nombre.proyecto" var="nameP"/>
			<snoop:input labelText="${nameP}" path="nombre"
				id="nombre_del_proyecto" requerido="true" />

			<spring:bind path="cliente.*">
				<div
					class="control-group string required ${status.error ? 'error' : '' }">
					<label for="cliente" class="string required control-label"> <abbr
						title="required">*</abbr><spring:message code="nombre.cliente"/>
					</label>
					<div class="controls">
						<form:input path="cliente.nombre" type="text" id="cliente"	class="string required span3" 
							autocomplete="off" />
						 <a id="cliente_link" class="btn" href="${antecedenteProyecto.clienteFinal.linkCRM}" 
						 	data-toggle="tooltip" title="Ver en CRM"><i class="icon-share"></i></a>
						<form:errors path="cliente.*" cssClass="help-inline" />
					</div>
				</div>
			</spring:bind>
			
			<form:hidden path="cliente.idCrm" id="clienteId" />
			<form:hidden path="cliente.direccion" id="cliente_direccion" />
			<form:hidden path="cliente.telefono" id="cliente_telefono" />
			<form:hidden path="cliente.vertical" id="cliente_vertical" />

			<spring:bind path="clienteFinal.*">
				<div
					class="control-group string required ${status.error ? 'error' : '' }">
					<label for="clienteFinal" class="string required control-label"> <abbr
						title="required">*</abbr><spring:message code="nombre.cliente.final"/>
					</label>
					<div class="controls">
						<form:input path="clienteFinal.nombre" type="text" id="clienteFinal" class="string required span3" 
							autocomplete="off" />
						<a id="cliente_final_link" class="btn" href="${antecedenteProyecto.clienteFinal.linkCRM}" 
							data-toggle="tooltip" title="Ver en CRM"><i class="icon-share"></i></a>
						<form:errors path="clienteFinal.*" cssClass="help-inline" />
					</div>
				</div>
			</spring:bind>
				
			<form:hidden path="clienteFinal.idCrm" id="clienteFinalId" />	
			<form:hidden path="clienteFinal.direccion" id="cliente_final_direccion" />
			<form:hidden path="clienteFinal.telefono" id="cliente_final_telefono" />
			<form:hidden path="clienteFinal.vertical" id="cliente_final_vertical" />

			<spring:message code="nombre.lider" var="nombreLider"/>
			<snoop:input labelText="${nombreLider}" path="liderProyecto" id="lider_proyecto" requerido="true"/>

			
			<div class="form-actions">
				<input type="submit" value="<spring:message code="boton.next"/>" name="commit" class="btn btn-primary" />  
				<a href="<c:url value="/bandeja" />" class="btn"><spring:message code="boton.cancelar"/></a>  
			</div>

		</form:form>

	</div>
</div>