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
<title>Listado de Noticias</title>
<spring:url value="/resources" var="urlPublic"></spring:url>
<spring:url value="/noticias/create" var="urlNew"></spring:url>
<spring:url value="/noticias/edit" var="urlEdit"></spring:url>
<spring:url value="/noticias/delete" var="urlDelete"></spring:url>
<link href="${urlPublic}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

</head>

<body>

		<jsp:include page="../includes/menu.jsp"></jsp:include>

	<div class="container theme-showcase" role="main">

		<h3>Listado de Noticias</h3>
		
		<c:if test="${mensaje!=null}">
			<div class='alert alert-success' role="alert">${mensaje}</div>
		</c:if>

		<a href="${urlNew}" class="btn btn-success" role="button"
			title="Nueva Pelicula">Nueva</a><br>
		<br>

		<div class="table-responsive">
			<table class="table table-hover table-striped table-bordered">
				<tr>
					<th>Id</th>
					<th>Titulo</th>
					<th>Fecha</th>
					<th>Estatus</th>
					<th>Opciones</th>
				</tr>
				<c:forEach items="${noticias.getContent()}" var="noticia">
				<tr>
					<td>${noticia.id}</td>
					<td>${noticia.titulo}</td>
					<td><fmt:formatDate value="${noticia.fecha}" pattern="dd-MM-yyyy"/> </td>
					<c:choose>
							<c:when test="${noticia.estatus eq 'Activa'}">
								<td><span class="badge badge-success">Activa</span></td>
							</c:when>
							<c:otherwise>
								<td><span class="badge badge-danger">Inactiva</span></td>
							</c:otherwise>
						</c:choose>
						<td><a href="${urlEdit}/${noticia.id}" class="btn btn-success btn-sm" role="button"
							title="Edit"><i class="material-icons"> edit </i></a> 
							<a href="${urlDelete}/${noticia.id}" onclick="return confirm('Seguro que quieres eliminar la noticia?')" class="btn btn-danger btn-sm" role="button" title="Eliminar"><i
								class="material-icons"> delete </i></a></td>
				</tr>
				</c:forEach>
			</table>
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
