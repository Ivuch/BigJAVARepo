<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/style1.css" />
<link rel="stylesheet" type="text/css" href="../css/validateForm.css" />
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="js/jqueryAPI.js"></script>
<script type="text/javascript" src="js/JavaScriptAPI.js"></script>
<script type="text/javascript" src="js/casa.js"></script>
<title>¡Bienvenido a RESTafar I!</title>
</head>
<body>
	<div id="header">
		<p id="title">RESTafar I!</p>
		<nav>
			<a class="ship" href="../index.jsp">Home</a>
			<a class="ship" href="#">Como</a>
			<a class="ship" href="#">Contacto</a>
		</nav>	
	</div>
	<div id="body">
		<div id="container-left">
			<div class="stage">
				<label class="work">Mascotas:</label>
				<ul>
				<jsp:useBean id="date" class="java.util.Date" /> 
<p>The date/time is <%= date %>
					<li><input type="checkbox" /><i class="doneby"></i></li>
					<li>Sasha:<input type="checkbox" onClick="chkboxClick()"/><i class="doneby">(realizado por)</i></li>
					<li>Mirko:<input type="checkbox" /><i class="doneby">(realizado por)</i></li>
				</ul>
			</div>
		</div>
		<div id="container-center">

		</div>
		<div id="container-right">Monkey D. Luffy - Ivuch D. Kong</div>
	</div>
	<div id="footer">FOOTER</div>
</body>
</html>