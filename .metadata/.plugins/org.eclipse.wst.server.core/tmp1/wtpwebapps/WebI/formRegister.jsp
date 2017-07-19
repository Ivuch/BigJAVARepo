<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/validateForm.css" />
<title>¡Bienvenido a RESTafar I!</title>
</head>
<body>
	<div id="header">
		<p id="title">RESTafar I!</p>
	</div>
	<div id="body">
		<div id="container-left">
			<div class="linkToResource"><a href="index.jsp">HOME</a></div>
		</div>
		<div id="container-center">
			<form action="rest/user" method="POST">
			<label>Nombres:</label> <input type="text" name="name"><br/>
			<label>Apellido: </label> <input type="text" name="lname"><br/>
			<label>Contraseña: </label> <input type="password" name="pass"><br/>
			<label>Confirmar Contraseña: </label> <input type="password" name="confirmPass"><br/>
			<label>E-mail: </label> <input type="email" name="email"><br/>
			<input type="submit" id="formButton" value="Submit">
	</form>
		</div>
		<div id="container-right">Monkey D. Luffy - Ivuch D. Kong</div>
	</div>
	<div id="footer">FOOTER</div>
</body>
</html>