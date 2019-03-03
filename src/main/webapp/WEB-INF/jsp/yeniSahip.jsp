<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sahip Ekleme</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">         
<script src="../js/bootstrap.min.js"></script>
</head>
<body>

	<form:form modelAttribute="sahip" method="post">
<!-- 		<div class="form-group"> -->
<!-- 			<label for="id">ID</label> -->
<%-- 			<form:input path="id" type="text" class="form-control" id="id" --%>
<%-- 				aria-describedby="adbilgi" placeholder="ID giriniz" />  --%>
<!-- 			<small id="idbilgi" class="form-text text-muted">Sahip ID -->
<!--  				Bilgisini Giriniz.</small> -->
<!-- 		</div>  -->
		<div class="form-group">
			<label for="ad">İsim</label>
			<form:input path="ad" type="text" class="form-control" id="ad"
				aria-describedby="adbilgi" placeholder="İsim Giriniz" />
			<small id="adbilgi" class="form-text text-muted">Sahip Ad
				Bilgisini Giriniz.</small>
		</div>
		<div class="form-group">
			<label for="soyad">soyad</label>
			<form:input path="soyad" type="text" class="form-control" id="soyad"
				aria-describedby="soyadbilgi" placeholder="Soyad Giriniz" />
			<small id="soyadbilgi" class="form-text text-muted">Sahip
				Soyad Bilgisini Giriniz.</small>
		</div>
		<div class="form-group">
			<label for="adres">Adres</label>
			<form:input path="adres" type="text" class="form-control" id="adres"
				aria-describedby="adresbilgi" placeholder="Adres Giriniz" />
			<small id="adresbilgi" class="form-text text-muted">Sahip
				Adres Bilgisini Giriniz.</small>
		</div>
		<div class="form-group">
			<label for="telefon">Telefon</label>
			<form:input path="telefon" type="text" class="form-control"
				id="telefon" aria-describedby="telefonbilgi"
				placeholder="Telefon Giriniz" />
			<small id="telefonbilgi" class="form-text text-muted">Sahip
				Telefon Bilgisini Giriniz.</small>
		</div>
		<div class="form-group">
			<label for="eposta">E-Posta</label>
			<form:input path="eposta" type="email" class="form-control"
				id="eposta" aria-describedby="epostabilgi"
				placeholder="E-Posta Giriniz" />
			<small id="epostabilgi" class="form-text text-muted">Sahip
				E-Posta Bilgisini Giriniz.</small>
		</div>
		<form:button name="submit" type="submit" class="btn btn-primary">Kaydet</form:button>
	</form:form>

</body>
</html>