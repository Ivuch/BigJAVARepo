<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
<link rel="stylesheet" href="<c:url value="/themes/snoop/bootstrap.css"/> " media="print, screen">
<link rel="stylesheet" href="<c:url value="/css/bootstrap-responsive.css"/> ">
<script src="<c:url value="/js/jquery.min.js"/> "></script>
<script src="<c:url value="/js/bootstrap.min.js"/> "></script>
</head>
<body style="background:none;">
    <div class="navbar navbar-static-top">
        <div>
            <div class="container">
                <div class="brand"><img src="<c:url value="/images/header_imprimir.jpg" />"/></div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="page-header">
            <h2>Proyecto nuevo</h2>
        </div>
        <div class="container">
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>Antecedente</th>
						<th>Cliente</th>
						<th>Estado</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${empty antecedentes}">
							<!-- mostrar cuando no haya registros -->
							<tr>
								<td colspan="4"><h3>No tiene ningun mensaje nuevo</h3></td>
							</tr>
							<!-- fin mostrar cuando no haya registros -->
						</c:when>
						<c:otherwise>
							<c:forEach items="${antecedentes}" var="antecedente">
								<tr>
									<td>${antecedente.nombre}</td>
									<td>${antecedente.cliente}</td>
									<td>${antecedente.estado}</td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
    </div>
</body>
</html>