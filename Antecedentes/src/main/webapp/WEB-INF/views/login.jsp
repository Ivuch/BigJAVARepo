<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!doctype html>
<html>

<head>
<title><spring:message code="boton.ingresar"/></title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
<link rel="stylesheet" href="themes/snoop/bootstrap.css">
<link rel="stylesheet" href="css/bootstrap-responsive.css">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<style type="text/css">
body{
    padding-top:40px;
    padding-bottom:40px;
    background-color: #F0F2F2;
    background-image:none;
    }
.form-logo{
    max-width: 500px;
    padding: 10px 0px;
        margin: 0 auto 20px;
    text-align:center;
    }
.form-signin {
    max-width: 410px;
    padding: 19px 29px 29px;
    margin: 0 auto 20px;
    background-color: #fff;
    border: 1px solid #e5e5e5;
    -webkit-border-radius: 5px;
       -moz-border-radius: 5px;
            border-radius: 5px;
    -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
       -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
            box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
.form-signin .form-signin-heading,
.form-signin .checkbox {
	margin-bottom: 10px;
}
.form-signin input[type="text"],
.form-signin input[type="password"] {
	font-size: 16px;
    height: auto;
    margin-bottom: 15px;
    padding: 7px 9px;
}
.contenedor-botones{
	margin-top:14px; overflow:hidden;
}
.boton_facebook{
	display:block;width:200px;height:34px;background:transparent url(images/login-botones.png) 0px 0px no-repeat; margin-bottom:6px; margin-right:10px;
}
.boton_facebook:hover{
	background-position:0px -34px;
}
.boton_google{
	display:block;width:200px;height:34px;background:transparent url(images/login-botones.png) 0px -103px no-repeat; margin-bottom:6px;
}
.boton_google:hover{
	background-position:0px -137px;
}

    </style>
</head>

<body>
	<spring:url value="/signin/google" var="form_url_google" />
	<spring:url value="/signin/facebook" var="form_url_facebook" />
	<spring:url value="/resources/j_spring_security_check" var="form_url" />

	<div class="container">
		<div class="form-logo">
			<img src="images/logo-grande.png" />
		</div>
		<form class="form-signin" method="post"	action="${form_url}">

		<div class="contenedor-botones">
			<a id="facebook_link" class="boton_facebook pull-left" href="#" onclick="$('#fb_signin').submit();"></a>
			<a id="google_link" class="boton_google pull-left" href="#" onclick="$('#gl_signin').submit();"></a>
		</div>
			<hr>
			<input type="text" name='j_username' class="input-block-level" placeholder="<spring:message code="placeholder.user"/>">
			<input type="password" name='j_password' class="input-block-level"
				placeholder="<spring:message code="placeholder.pass"/>">
			
			<c:if test="${not empty param.login_error }">
				<div class="alert alert-error">
					<button type="button" class="close" data-dismiss="alert">×</button>
					<b><spring:message code="error"/></b> <spring:message code="error.msg"/>
				</div>
			</c:if>
			<label class="checkbox">
				<input type='checkbox' name='_spring_security_remember_me' id="_spring_security_remember_me"
                     tabindex="3" value="true"/> <spring:message code="remember.me"/>
			</label>
			<button class="btn btn-large btn-primary" type="submit"><spring:message code="boton.ingresar"/></button>
		</form>
		
	</div> <!-- /container -->
		
	<form id="gl_signin" action="${form_url_google}" method="POST">
		<input type="hidden" name="scope"
			value="https://www.googleapis.com/auth/userinfo.profile https://www.googleapis.com/auth/userinfo#email https://www.googleapis.com/auth/plus.me" />
	</form>

	<form id="fb_signin" action="${form_url_facebook}" method="POST">
		<input type="hidden" name="scope" value="publish_stream,user_photos,offline_access" />
	</form>
</body>

</html>