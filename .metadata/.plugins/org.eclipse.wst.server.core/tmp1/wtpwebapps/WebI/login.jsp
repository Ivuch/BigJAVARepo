<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/validateForm.css" />
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="js/jqueryAPI.js"></script>
<script type="text/javascript" src="js/JavaScriptAPI.js"></script>
<title>¡Bienvenido a RESTafar I!</title>
</head>
<body>
	<div id="header">
		<p id="title">RESTafar I!</p>
	</div>
	<div id="body">
		<div id="container-left">
			<div class="linkToResource"><a href="index.jsp">HOME</a></div>
			<div class="linkToResource"><a href="cube.jsp">Cube!</a></div>
			<div id="msgid"></div>
		</div>
		<div id="container-center">
			<div id="login-container">
				<form action="rest/auth" method="POST" onsubmit="return validate()">
					<input type="text" name="user" id="userr"/>
					<input type="password" name="pass" id="passs"/>
					<input type="submit" />
					<a href="formRegister.jsp">don't have account?</a><a href="formRegister.jsp">Register</a>
				</form>
				<div id="beaker">
					<span class="bubble"> <span class="glow"> </span>
				</span>
			</div>
			</div>
		</div>
		<div id="container-right">Monkey D. Luffy - Ivuch D. Kong</div>
	</div>
	<div id="footer">FOOTER</div>
</body>
</html>