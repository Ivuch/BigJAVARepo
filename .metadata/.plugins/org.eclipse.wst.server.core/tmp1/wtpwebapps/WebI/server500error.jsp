<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script type="text/javascript">
function getHello(){
	if(window.XMLHttpRequest) {
	    peticion_http = new XMLHttpRequest();
	}
	else if(window.ActiveXObject) {
		peticion_http = new ActiveXObject("Microsoft.XMLHTTP");
	}

	peticion_http.onreadystatechange = muestraContenido;

	// Realizar peticion HTTP
	peticion_http.open('POST','http://localhost:8082/WebI/rest/user/auth', true);
	peticion_http.send(null);
}
	function muestraContenido() {
      if(peticion_http.readyState == 4) {
      	if(peticion_http.status == 200) {
      		document.getElementById('msg500').value = peticion_http.responseText;
      	}
	  }
		}</script>
<title>¡Bienvenido a RESTafar I!</title>
</head>
<body>
	<div id="header">
		<p id="title">RESTafar I!</p>
	</div>
	<div id="body">
		<div id="container-left"></div>
		<div id="container-center">
		<p id="error500">500 Server Error</p><p id="msg500"></p>
		<input type="button" onclick="getHello()"/>
		</div>
		<div id="container-right">Monkey D. Luffy - Ivuch D. Kong</div>
	</div>
	<div id="footer">FOOTER</div>
</body>
</html>