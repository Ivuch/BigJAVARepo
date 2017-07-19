<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
		
	function getCuentas(query, process){
		$.ajax({
            url: '<c:url value="/getCuentas"/>',
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
	
	$(function(){		
		$('#cliente').typeahead({
			source: getCuentas,
		    minLength: 2
		});
		
		$("#e7").select2({			
	        minimumInputLength: 2,
	        multiple: true,
	        width:800,
	        ajax: {
	            url: '<c:url value="/suggest"/>',
	            dataType: 'json',
	            quietMillis: 100,
	            data: function (term, page) { // page is the one-based page number tracked by Select2
	                return {
	                    q: term, //search term
	                    page_limit: 10, // page size
	                    page: page, // page number
	                };
	            },
	            results: function (data, page) {
					more = 0;
	                var results = new Array();
	                if(data.length !== 0){			               
		                $.each(data, function(index, value){
		                	var result = new Object();
		                	result.id = value;
		                	result.text = value;
		                	results.push(result);
		                });
	                }
	                // notice we return the value of more so Select2 knows if more results can be loaded
	                return {results: results, more: more};
	            }
	        },
	   });
	
		$('#fecha_desde, #fecha_hasta').datepicker({
			format: 'dd/mm/yyyy',
			language : 'es',
	           autoclose: true
		});
	});
	<!--
//-->
</script>
<div class="well">
	<form:form action="/buscar" id="buscador" method="get" commandName="form">	
		<div class="row-fluid">
			<div class="span1">
				<label for="cliente"><spring:message code="buscador.cliente"/></label>
			</div>
			<div class="span5">
				<form:input path="cliente.nombre" type="text" id="cliente" class="string required" 
						autocomplete="off"/>					
			</div>
			<div class="span1">
				<label for="servicio" class="string required control-label pull-left span3">
					<spring:message code="buscador.servicio"/> </label>
			</div>
			<div class="controls pull-left span5">
				<form:select path="servicio"  id="servicio"  >
					<form:option value="">&nbsp;</form:option>
    					<form:options items="${servicios}" itemLabel="nombre" itemValue="id" />
				</form:select>
			</div>
			
		</div>
		<div class="row-fluid">
			<div class="span1">
				<label for="cliente"><spring:message code="buscador.sbu"/></label>
			</div>
			<div class="span5">
				<form:select path="sbu"  id="sbu" >
					<form:option value="">&nbsp;</form:option>
    					<form:options items="${sbus}" itemLabel="nombre" itemValue="id" />
				</form:select>					
			</div>			
		</div>
		<div class="row-fluid">
			<div class="span1">
				<label for="cliente"><spring:message code="buscador.fecha.desde"/></label>
			</div>
			<div class="span5">
				<form:input id="fecha_desde" path="fechaDesde"/>				
			</div>	
			<div class="span1">
				<label for="cliente"><spring:message code="buscador.fecha.hasta"/></label>
			</div>
			<div class="span5">
				<form:input id="fecha_hasta" path="fechaHasta"/>				
			</div>	
		</div>
		<div class="row-fluid">
			<div class="">
				<label for="e7" class="string required control-label pull-left span1">
					<spring:message code="buscador.tags"/> </label>
				<div class="controls pull-left span10">
					<input type="hidden" name="palabras" class="bigdrop" id="e7" />
				</div>
			</div>
		</div>
		<div class=" row-fluid">
			<div class="span2"><button class="btn"><i class="icon-search"></i> <spring:message code="boton.buscar"/></button></div>
			<div >
				<label class="checkbox inline">
					<input type="checkbox" name="soloUsuarioLogeado" id="" class="check_boxes optional"><spring:message code="checkbox.usuario"/>
				</label>
			</div>
		</div>						 
	</form:form>
</div>