<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/style.css" />
	<script type="text/javascript">
	function clear5(){
		document.getElementById('restResponses').value = '';
	}
	function getHello(path){
		if(window.XMLHttpRequest) {
		    peticion_http = new XMLHttpRequest();
		}
		else if(window.ActiveXObject) {
			peticion_http = new ActiveXObject("Microsoft.XMLHTTP");
		}

		peticion_http.onreadystatechange = muestraContenido;
 
		// Realizar peticion HTTP
		peticion_http.open('GET', path, true);
		peticion_http.send(null);
	}
		function muestraContenido() {
	      if(peticion_http.readyState == 4) {
	      	if(peticion_http.status == 200) {
	      		document.getElementById('restResponses').value = peticion_http.responseText;
	      	}
    	  }
  		}
		
	

	</script>
	<title>¡Bienvenido a RESTafar I!</title>
</head>
<body>
	<div id="header"><p id="title">Jah RESTafar I!</p></div>
	<div id="body">
		<div id="container-left">
			<input id="searchEngineBox" type="search" placeholder="Search API REST..."/>
			<div class="linkToResource"><a href="#" onClick="getHello('http://localhost:8082/WebI/rest/hello/REST%20response%20Ok');">LINK 1</a></div>
			<div class="linkToResource"><a href="#" onClick="getHello('http://localhost:8082/WebI/rest/hello/REST%20OP!');">LINK 1</a></div>
			<div class="linkToResource"><a href="#" onClick="getHello('http://localhost:8082/WebI/rest/hello/Ok?');">LINK 1</a></div>
			<div class="linkToResource"><a href="#" onClick="getHello('https://api.mercadolibre.com/users/1234');">MeLi user1234</a></div>
			<div class="linkToResource"><a href="#" onClick="getHello('http://localhost:8082/WebI/rest/hello/REST%20response%20Ok');">LINK 1</a></div>
			<div class="linkToResource"><a href="#" onClick="getHello('http://localhost:8082/WebI/rest/hello/REST%20response%20Ok');">LINK 1</a></div>
			<div class="linkToResource"><a href="login.jsp" onClick="">Log-in To/TheWeb!</a></div>
			<div class="linkToResource"><a href="casa/inicio.jsp">Casa App!</a></div>
			<div class="linkToResource"><a href="functions/actualizetextlimit.jsp"><i>functios</i> App</a></div>
		</div>
		<div id="container-center">
<!-- 			<p>Rastafar I es un movimiento, no una ideología, Rasta es el momento y no una idea estancada en el tiempo, esa es la diferencia. Jah es como lo llamamos, y por varias razones... Jah es el dios inicial del ser Humano desde tiempos inmemoriables, antes conocido como RA, el Dios del Sol, luego como Jahovia o Jehová, por el pueblo Judío, más tarde reencarnado en Jahsua, Yashua o Jesús (su nombre en lengua latina) para el cristianismo y luego como JAH o YHVH para el Rastafarismo. Por eso JAH, YA es el momento.</p>  -->
			<textarea id="restResponses"></textarea>
			<input  type="button" onClick="clear5();" value="Clear box" id="clearButton"/>
		</div>
		<iframe width="254" height="510" src="https://www.youtube.com/embed/G3jtfsJdy8s" frameborder="0" allowfullscreen></iframe>
		<object codetype="application/java" classid="java:Main.class"
   archive="C:\Users\MaximilianoIván\workspace\Ajedrez\target\Ajedrez-0.0.1-SNAPSHOT.jar" width="740" height="400"></object>
		<applet code="Main.class" archive="C:\Users\MaximilianoIván\workspace\Ajedrez\target\Ajedrez-0.0.1-SNAPSHOT.jar"
   width="740" height="400"></applet>
		<div id="container-right">Monkey D. Luffy - Ivuch D. Kong</div>
	</div>
	<div id="footer">FOOTER</div>	
</body>
</html>