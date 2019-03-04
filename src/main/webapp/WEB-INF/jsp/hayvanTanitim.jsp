<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
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
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<title>Veteriner Hayvan Takip</title>
</head>
<body>
	<div id="container">
		<div id="header">
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
					<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
						<li class="nav-item active"><a class="nav-link" href="/">Anasayfa
								<span class="sr-only">(current)</span>
						</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/hayvan-tanitim">Hayvan Tanıtımı</a></li>
						<!-- 						<li class="nav-item"><a class="nav-link disabled" href="#">Sahip Tanıtımı</a> -->
						<li class="nav-item"><a class="nav-link"
							href="/sahip-tanitim">Sahip Tanıtımı</a>
						<li class="nav-item">
							<form action="logout" method="post">
								<button type="submit" class="btn btn-outline-danger">Çıkış</button>
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}">
							</form>
						</li>
					</ul>
					<form class="form-inline my-2 my-lg-0">
						<input class="form-control mr-sm-3" type="search"
							placeholder="Hayvan || Sahip Ara">
						<button class="btn btn-outline-success my-2 my-sm-0" type="submit">ARA</button>
					</form>
				</div>
			</nav>

		</div>
		<div id="body">
			<div class="jumbotron"
				style="background-color: transparent !important;">
				<h3 class="text-primary">Hayvan Tanıtımı</h3>
				<ul class="list-group">
					<li class="list-group-item">
						<table class="table table-striped">
							<thead>
								<tr>
									<th scope="col">HayvanID</th>
									<th scope="col">Tür</th>
									<th scope="col">Cins</th>
									<th scope="col">Yaş</th>
									<th scope="col">Açıklama</th>
									<th scope="col">Düzenle</th>
									<th scope="col">Sil</th>

								</tr>
							</thead>
							<tbody>
								<c:forEach items="${hayvanlar}" var="hayvanlar">
									<tr>
										<td>${hayvanlar.hayvanID}</td>
										<td>${hayvanlar.tur}</td>
										<td>${hayvanlar.cins}</td>
										<td>${hayvanlar.yas}</td>
										<td style="max-width: 300px; word-wrap: break-word;">${hayvanlar.aciklama}</td>
										<td><button type="button" class="btn btn-outline-success">Güncelle</button></td>
										<td>
											<form action="${pageContext.request.contextPath}/hayvanSil/${hayvanlar.hayvanID}" method="get">
											<button onclick="return confirm('Silme işlemi gerçekleşsin mi ?')" type="submit" class="btn btn-outline-danger">Sil</button>
											</form>
										</td>

									</tr>
								</c:forEach>

							</tbody>
						</table>
					</li>
				</ul>

			</div>
		</div>
		<div id="footer">
			<footer class="font-small blue pt-4">
				<!-- Copyright -->
				<div class="footer-copyright text-center py-3">Serkan Kaya ©
					2019 Copyright - Veteriner Hayvan Takip v1.0 - MIT License</div>
				<!-- Copyright -->

			</footer>
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
	</div>
</body>
</html>
