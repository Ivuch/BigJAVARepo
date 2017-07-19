<!doctype html>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:directive.page contentType="text/html;charset=UTF-8" />
<jsp:directive.page pageEncoding="UTF-8" /> 
<html>
	<head>
		<title>Home</title>
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<meta content="text/html; charset=UTF-8" http-equiv="Content-Type" />
		<link rel="stylesheet" href="<c:url value="/themes/snoop/bootstrap.css" />" />
		<link rel="stylesheet" href="<c:url value="/css/bootstrap-responsive.css" />"  />
		<link rel="stylesheet" href="<c:url value="/css/datepicker.css" />" >
		<link rel="stylesheet" type="text/css" href="<c:url value="/css/prettify.css" />" ></link>
		<link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap-wysihtml5.css" />" ></link>
		<link rel="stylesheet" type="text/css" href="<c:url value="/css/select2.css" />" ></link>
		<link rel="stylesheet" type="text/css" href="<c:url value="/css/select2-bootstrap.css" />" >
		<script src="<c:url value="/js/jquery.min.js" />"></script>
		<script src="<c:url value="/js/bootstrap-datepicker.js" />"></script>
		<script src="<c:url value="/js/bootstrap-datepicker.es.js" />"></script>
		<script src="<c:url value="/js/wysihtml5-0.3.0.min.js" />"></script>
		<script src="<c:url value="/js/prettify.js" />"></script>
		<script src="<c:url value="/js/bootstrap-wysihtml5.js" />"></script>
		<script src="<c:url value="/js/bootstrap.file-input.js" />"></script>
		<script src="<c:url value="/js/bootstrap.min.js" />"><!-- --></script>
		<script src="<c:url value="/js/select2.js" />"><!-- --></script>
	</head>
	<body>
		<!-- Header -->
		<tiles:insertAttribute name="header" ignore="true" />
		<!-- Header -->
	    <div class="container body">
    		<!-- Body -->
	   		<tiles:insertAttribute name="body"/>
	   		<!-- Body -->
   		</div> 
   		
	    <div class="container footer">
	    	<!-- Footer -->
	    	<tiles:insertAttribute name="footer" ignore="true"/>
	    	<!-- Footer -->
	    </div>
	</body>
</html>
