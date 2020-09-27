<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>CineSite | Bienvenido</title>
<spring:url value="/resources" var="urlPublic"></spring:url>
<spring:url value="/" var="urlRoot"></spring:url>
<link href="${urlPublic}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">

</head>

<body>

	<jsp:include page="includes/menu.jsp"></jsp:include>

	<div class="container theme-showcase" role="main">

		<!-- Carousel
    ================================================== -->
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<c:forEach items="${banners}" var="banner" varStatus="loop">
					<c:choose>
						<c:when test="${loop.index==0}">
							<li data-target="#myCarousel" data-slide-to="${loop.index}"
								class="active"></li>
						</c:when>
						<c:otherwise>
							<li data-target="#myCarousel" data-slide-to="${loop.index}"></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>

			</ol>
			<!-- Image Size 1140 x 250 -->
			<div class="carousel-inner" role="listbox">
				<c:forEach items="${banners}" var="banner" varStatus="loop">
					<c:choose>
						<c:when test="${loop.index==0}">
							<div class="carousel-item active">
								<img src="${urlPublic}/images/${banner.archivo}" alt="Slide"
									title="${banner.titulo}">
							</div>
						</c:when>
						<c:otherwise>
							<div class="carousel-item">
								<img src="${urlPublic}/images/${banner.archivo}" alt="Slide"
									title="${banner.titulo}">
							</div>
						</c:otherwise>
					</c:choose>

				</c:forEach>

			</div>
			<a class="carousel-control-prev" href="#myCarousel" role="button"
				data-slide="prev"> <span class="carousel-control-prev-icon"
				aria-hidden="true"></span> <span class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#myCarousel" role="button"
				data-slide="next"> <span class="carousel-control-next-icon"
				aria-hidden="true"></span> <span class="sr-only">Next</span>
			</a>
		</div>
		<!-- /.carousel -->

		<div class="row page-header">
			<div class="col-lg-12">
				<h2 class="text-center my-3">
					<span class="badge badge-success">EN CARTELERA</span>
				</h2>
				<form class="form-inline my-3" action="${urlRoot}search"
					method="post">
					<div class="form-group">
						<label for="fecha">Fecha: </label> 
						<select id="fecha" name="fecha" class="form-control">
							<c:forEach items="${fechas}" var="fecha">
								<c:choose>
									<c:when test="${fecha eq fechaBusqueda}">
										<option value="${fecha}" selected>${fecha}</option>
									</c:when>
									<c:otherwise>
										<option value="${fecha}">${fecha}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</div>
					<button type="submit" class="btn btn-primary">Filtrar</button>
				</form>
			</div>
		</div>

		<!-- Marketing messaging -->
		<div class="container marketing">

			<div class="row justify-content-md-center">

				<c:forEach items="${peliculas}" var="pelicula">
					<div class="col-xs-12 col-sm-6 col-md-3">
						<img class="rounded" src="${urlPublic}/images/${pelicula.imagen}"
							alt="Generic placeholder image" width="150" height="200">
						<h4 class="card-title">${pelicula.titulo}</h4>
						<h4>
							<span class="badge badge-secondary">${pelicula.clasificacion}</span>
							<span class="badge badge-secondary">${pelicula.duracion}
								mins.</span> <span class="badge badge-secondary">${pelicula.genero}</span>
						</h4>
						<p>
							<a class="btn btn-sm btn-primary"
								href="${urlRoot}detail/${pelicula.id}/${fechaBusqueda}"
								role="button">Consulta Horarios &raquo;</a>

						</p>

					</div>

				</c:forEach>

			</div>

			<div class="page-header">
				<h2 class="text text-center">
					<span class="badge badge-success">Noticias y novedades</span>
				</h2>
			</div>

			<div class="form-row">

				<div class="col-sm-12 blog-main">

					<c:forEach items="${noticiasRecientes}" var="noticia">

						<div class="blog-post">
							<h3 class="blog-post-title">${noticia.titulo}</h3>

							<p class="blog-post-meta">
								<span class="badge badge-danger">Publicado: <fmt:formatDate value="${noticia.fecha}" pattern="dd-MM-yyyy"/> </span>
							</p>
							<p>${noticia.detalle}</p>

							<hr class="featurette-divider">
						</div>

					</c:forEach>

					<hr class="featurette-divider">
				</div>

			</div>
		</div>

	</div>

	<jsp:include page="includes/footer.jsp"></jsp:include>

	<!-- /container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
