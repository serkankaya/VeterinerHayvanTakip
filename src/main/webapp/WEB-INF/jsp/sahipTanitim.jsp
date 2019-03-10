<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

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
	<script>
	function setURL(form) {
		form.action = "sahip/ara/" + form.urlVal.value;
		console.log(form.action);
		event.preventDefault();
	}
</script>
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
						<li class="navbar-text" style="color: blue; margin-left: 50px">Merhaba
							<span style="color: blue"><security:authentication
									property="principal.username" /></span> , Kullanıcı Yetkisi: <security:authentication
								property="principal.authorities" />
						</li>
					</ul>
					<form action="sahip/ara/" onsubmit="setURL(this)" class="form-inline my-2 my-lg-0" method="get">
						<input id="ad" name="ara" class="form-control mr-sm-3" type="search"
							placeholder="Sahip Ara">
						<button class="btn btn-outline-success my-2 my-sm-0" type="submit">ARA</button>
					</form>
				</div>
			</nav>

		</div>
		<div id="body">
			<div class="jumbotron"
				style="background-color: transparent !important;">
				<div class="row">
					<div class="col-md-6 text-center">
						<span class="float-md-left"><h3 class="text-primary">Sahip
								Tanıtımı</h3></span>
					</div>
					<div class="col-md-6 text-center">
						<span class="float-md-right">
							<button type="button" class="btn btn-primary" data-toggle="modal"
								data-target="#exampleModal">Sahip Ekle</button>
						</span>
					</div>
				</div>


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
									<th scope="col">Düzenle</th>
									<security:authorize access="hasRole('ADMIN')">
										<th scope="col">Sil</th>
									</security:authorize>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${sahipler}" var="sahip">
									<tr>
										<td>${sahip.id}</td>
										<td>${sahip.ad}</td>
										<td>${sahip.soyad}</td>
										<td>${sahip.adres}</td>
										<td>${sahip.telefon}</td>
										<td>${sahip.eposta}</td>
										<td>
											<form action="/sahip/guncelle/${sahip.id}">
												<a class="btn btn-outline-success"
													href="${pageContext.request.contextPath}/sahip/guncelle/${sahip.id}"
													role="button">Düzenle</a>
											</form>

										</td>
										<security:authorize access="hasRole('ADMIN')">
											<td>
												<form
													action="${pageContext.request.contextPath}/sahipSil/${sahip.id}"
													method="get">
													<button
														onclick="return confirm('Silme işlemi gerçekleşsin mi ?')"
														type="submit" class="btn btn-outline-danger">Sil</button>
												</form>
											</td>
										</security:authorize>
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
				<div class="footer-copyright text-center py-3">* Veteriner
					Hayvan Takip v1.0 -Serkan Kaya - © 2019 -MIT License *</div>
				<!-- Copyright -->

			</footer>
		</div>
		<!-- Sahip Ekleme Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Sahip Ekleme
							İşlemi</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form:form modelAttribute="sahip" method="post">
							<div class="form-group">
								<label for="ad">İsim</label>
								<form:input path="ad" type="text" class="form-control" id="ad"
									aria-describedby="adbilgi" placeholder="İsim Giriniz" />
							</div>
							<div class="form-group">
								<label for="soyad">Soyad</label>
								<form:input path="soyad" type="text" class="form-control"
									id="soyad" aria-describedby="soyadbilgi"
									placeholder="Soyad Giriniz" />
							</div>
							<div class="form-group">
								<label for="adres">Adres</label>
								<form:input path="adres" type="text" class="form-control"
									id="adres" aria-describedby="adresbilgi"
									placeholder="Adres Giriniz" />
							</div>
							<div class="form-group">
								<label for="telefon">Telefon</label>
								<form:input path="telefon" type="tel" class="form-control"
									id="telefon" aria-describedby="telefonbilgi"
									placeholder="Telefon Giriniz" />
							</div>
							<div class="form-group">
								<label for="eposta">E-Posta</label>
								<form:input path="eposta" type="email" class="form-control"
									id="eposta" aria-describedby="epostabilgi"
									placeholder="E-Posta Giriniz" />
							</div>
							<form:button name="submit" type="submit" class="btn btn-primary">Kaydet</form:button>
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">İptal</button>
						</form:form>
					</div>
				</div>
			</div>
		</div>
		<!-- Sahip Ekleme Modal -->
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
