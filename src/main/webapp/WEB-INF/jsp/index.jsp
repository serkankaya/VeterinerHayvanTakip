<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">         
<script src="../js/bootstrap.min.js"></script>
</head>
<body>
	<form action="logout" method="post">
		<input type="submit" value="Logout"/>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	</form>
	
<ul class="list-group">
  <li class="list-group-item">
<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Ad</th>
      <th scope="col">Soyad</th>
      <th scope="col">Adres</th>
      <th scope="col">Telefon</th>
      <th scope="col">E-Posta</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${sahipler}" var="sahipler">
    <tr>
      <td>${sahipler.id}</td>
      <td>${sahipler.ad}</td>
      <td>${sahipler.soyad}</td>
      <td>${sahipler.adres}</td>
      <td>${sahipler.telefon}</td>
      <td>${sahipler.eposta}</td>
    </tr>
    </c:forEach>

  </tbody>
</table>
</li>
</ul>

</body>
</html>