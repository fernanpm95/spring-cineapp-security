<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Creacion de imagenes del Banner</title>
<spring:url value="/resources" var="urlPublic"></spring:url>
<spring:url value="/banners/save" var="urlForm"></spring:url>
<link href="${urlPublic}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">

</head>

<body>

	<jsp:include page="../includes/menu.jsp"></jsp:include>

	<div class="container theme-showcase" role="main">

		<h3 class="blog-title">
			<span class="badge badge-success">Datos de la imagen</span>
		</h3>

		<spring:hasBindErrors name="banner">
			<div class='alert alert-danger' role='alert'>
				<p>Por favor corrija los siguientes errores:</p>
				<ul>
					<c:forEach var="error" items="${errors.allErrors}">
						<li><p>
								<spring:message message="${error}" />
							</p>
						</li>
					</c:forEach>
				</ul>
			</div>
		</spring:hasBindErrors>

		<form:form method="post" action="${urlForm}" enctype="multipart/form-data" modelAttribute="banner">
			<div class="form-row">
				<div class="form-group col-sm-6">
					<label for="titulo" class="col-form-label">Titulo</label> 
					<form:hidden path="id"/>
					<form:input	type="text" class="form-control" path="titulo" id="titulo" required="required" />
				</div>

				<div class="form-group col-sm-3">
					<label for="imagen" class="col-form-label">Imagen</label> 
					<input type="file" id="archivoImagen" name="archivoImagen"
						required="required" class="form-control-file" />
					<p class="text-muted">Tamaño recomendado: 1140 x 250</p>
				</div>

				<div class="form-group col-sm-3">
					<label for="estatus" class="col-form-label">Estatus</label> 
					<form:select
						id="estatus" path="estatus" class="form-control">
						<form:option value="Activo">Activo</form:option>
						<form:option value="Inactivo">Inactivo</form:option>
					</form:select>
				</div>
			</div>

			<button type="submit" class="btn btn-danger">Guardar</button>
		</form:form>

		<hr class="featurette-divider">

		<jsp:include page="../includes/footer.jsp"></jsp:include>

	</div>
	<!-- /container -->

	<!-- Bootstrap core JavaScript
      ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>
