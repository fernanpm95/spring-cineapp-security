<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Listado de Peliculas</title>
<spring:url value="/resources" var="urlPublic"></spring:url>
<spring:url value="/peliculas" var="urlPeliculas"></spring:url>
<spring:url value="${urlPeliculas}/create" var="urlNew"></spring:url>
<spring:url value="${urlPeliculas}/edit" var="urlEdit"></spring:url>
<spring:url value="${urlPeliculas}/delete" var="urlDelete"></spring:url>
<link href="${urlPublic}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

</head>

<body>

	<jsp:include page="../includes/menu.jsp"></jsp:include>

	<div class="container theme-showcase" role="main">

		<h3>Listado de Peliculas</h3>

		<c:if test="${mensaje!=null}">
			<div class='alert alert-success' role="alert">${mensaje}</div>
		</c:if>

		<a href="${urlPeliculas}/create" class="btn btn-success" role="button"
			title="Nueva Pelicula">Nueva</a><br> <br>

		<div class="table-responsive">
			<table class="table table-hover table-striped table-bordered">
				<tr>
					<th>Titulo</th>
					<th>Genero</th>
					<th>Clasificacion</th>
					<th>Duracion</th>
					<th>Fecha Estreno</th>
					<th>Estatus</th>
					<th>Opciones</th>
				</tr>
				<c:forEach items="${peliculas.content}" var="pelicula">
					<tr>
						<td>${pelicula.titulo}</td>
						<td>${pelicula.genero}</td>
						<td>${pelicula.clasificacion}</td>
						<td>${pelicula.duracion}</td>
						<td><fmt:formatDate value="${pelicula.fechaEstreno}"
								pattern="dd-MM-yyyy" /></td>
						<c:choose>
							<c:when test="${pelicula.estatus eq 'Activa'}">
								<td><span class="badge badge-success">Activa</span></td>
							</c:when>
							<c:otherwise>
								<td><span class="badge badge-danger">Inactiva</span></td>
							</c:otherwise>
						</c:choose>
						<td><a href="${urlPeliculas}/edit/${pelicula.id}" class="btn btn-success btn-sm" role="button"
							title="Edit"><i class="material-icons"> edit </i></a> 
							<a href="${urlPeliculas}/delete/${pelicula.id}" onclick="return confirm('Seguro que quieres eliminar la película?')" class="btn btn-danger btn-sm" role="button" title="Eliminar"><i
								class="material-icons"> delete </i></a></td>

					</tr>
				</c:forEach>

			</table>
			<nav aria-label="Paginacion peliculas">
				<ul class="pagination">
					<li class="page-item"><a class="page-link" href="${urlPeliculas}/indexPaginate?page=${peliculas.number-1}">Anterior</a></li>
					<li class="page-item"><a class="page-link" href="${urlPeliculas}/indexPaginate?page=${peliculas.number+1}">Siguiente</a></li>
				</ul>
			</nav>
		</div>

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
