<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kullanıcı Girişi</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">         
<script src="../js/bootstrap.min.js"></script>


</head>
<body class="text-center">
<div class="container">
    <form class="form-signin" action="login" method=post>
  
  <h1 class="h3 mb-3 font-weight-normal">Kullanıcı Girişi</h1>
  <label for="inputEmail" class="sr-only">E-Posta</label>
  <input type="text" name="username" id="inputEmail" class="form-control" placeholder="E-Posta Adresi" required autofocus>
  <label for="inputPassword" class="sr-only">Şifre</label>
  <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Şifre" required>
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
  <div class="checkbox mb-3">
    <label>
      <input type="checkbox" value="remember-me" name="remember-me"> Beni Hatırla
    </label>
  </div>
  <button class="btn btn-lg btn-primary btn-block" type="submit" value="Login">Giriş Yap</button>
  <font color="red">
		<c:if test="${not empty param.loginFailed}">
			<c:out value="Giriş Başarısız !!! Kullanıcı Adı veya Şifre yanlış"></c:out>
		</c:if>
	</font>
  <p class="mt-5 mb-3 text-muted">&copy;2019</p>
</form>
</div>

</body>
</html>