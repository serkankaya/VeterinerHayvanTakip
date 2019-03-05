<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kullanıcı Girişi</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
    <link href="https://getbootstrap.com/docs/3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/3.3/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
    <link href="../css/signin.css" rel="stylesheet">
    <script src="https://getbootstrap.com/docs/3.3/assets/js/ie-emulation-modes-warning.js"></script>
<script src="../js/bootstrap.min.js"></script>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

</head>
<body class="center text-center">
	<div class="container">
		<form class="form-signin" action="login" method=post>

			<h2 class="form-signin-heading">Kullanıcı Girişi</h2>
			<label for="inputEmail" class="sr-only">E-Posta</label> 
			<input
				type="text" name="username" id="inputEmail" class="form-control"
				placeholder="E-Posta Adresi" required autofocus> 
				<label
				for="inputPassword" class="sr-only">Şifre</label>
				<input
				type="password" name="password" id="inputPassword"
				class="form-control" placeholder="Şifre" required> 
				<input
				type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<div class="checkbox mb-3">
				<label> <input type="checkbox" value="remember-me"
					name="remember-me"> Beni Hatırla
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit"
				value="Login">Giriş Yap</button>
			<font color="red"> <c:if test="${not empty param.loginFailed}">
					<c:out value="Giriş Başarısız !!! Kullanıcı Adı veya Şifre yanlış"></c:out>
				</c:if>
			</font>
			<p class="mt-5 mb-3 text-muted">Veteriner Hayvan Takip v1.0</br>
			© 2019 -MIT License</br>
			Serkan Kaya </p>
		</form>
	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>