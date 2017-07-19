<!-- This is the fully JavaScript code -->
	function validate(){
		var response = document.getElementsById("userr");
		if(response != null || response.value==""){
		alert("user empty");
		return false;
		}
		else{return true}
	}
	<!-- AJAX  -->
	function clear5(){
		document.getElementById('restResponses').value = '';
	}
	function getAjax(path){
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
  		<!-- POST -->
  		function postAjax(path){
		if(window.XMLHttpRequest) {
		    peticion_http = new XMLHttpRequest();
		}
		else if(window.ActiveXObject) {
			peticion_http = new ActiveXObject("Microsoft.XMLHTTP");
		}

		peticion_http.onreadystatechange = muestraContenido;
 
		// Realizar peticion HTTP
		peticion_http.open('POST', path, true);
		peticion_http.send(null);
	}
		function muestraContenido() {
	      if(peticion_http.readyState == 4) {
	      	if(peticion_http.status == 200) {
	      		document.getElementById('restResponses').value = peticion_http.responseText;
	      	}
    	  }
  		}
  		<!-- /POST-->
  	<!-- /AJAX -->
<!--  /JavaScript  -->
	
