<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<script src="../js/bootstrap.min.js"></script>
<!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"> -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
	<form action="logout" method="post">
		<input type="submit" value="Logout" /> 
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