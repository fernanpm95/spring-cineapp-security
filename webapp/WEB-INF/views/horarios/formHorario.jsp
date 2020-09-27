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
<meta name="author" content="">
<title>Creacion de Horarios</title>
<spring:url value="/resources" var="urlPublic"></spring:url>
<spring:url value="/horarios/save" var="urlForm"></spring:url>
<spring:url value="/" var="urlRoot"></spring:url>
<link href="${urlPublic}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
</head>

<body>

	<jsp:include page="../includes/menu.jsp"></jsp:include>

	<div class="container theme-showcase" role="main">

		<h3 class="blog-title">
			<span class="badge badge-success">Datos del Horario</span>
		</h3>
		
		<spring:hasBindErrors name="horario">
			<div class='alert alert-danger' role='alert'>
				Por favor corrija los siguientes errores:
				<ul>
					<c:forEach var="error" items="${errors.allErrors}">
						<li><spring:message message="${error}" /></li>
					</c:forEach>
				</ul>
			</div>
		</spring:hasBindErrors>

		<form:form action="${urlForm}" method="post" modelAttribute="horario">
			<div class="form-row">
				<div class="form-group col-sm-3">
					<label for="idPelicula" class="col-form-label">Pelicula</label> 
					<form:select id="idPelicula" path="pelicula.id" class="form-control" items="${peliculas}" itemValue="id" itemLabel="titulo">
					</form:select>
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-sm-3">
					<label for="fecha" class="col-form-label">Fecha</label> 
					<form:input type="text" class="form-control" path="fecha" id="fecha" required="required" />
				</div>
				<div class="form-group col-sm-3">
					<label for="hora" class="col-form-label">Hora</label> 
					<form:input type="text" class="form-control" path="hora" id="hora"
						placeholder="Formato: HH:mm Ejemplo 21:30" required="required" />
				</div>
				<div class="form-group col-sm-3">
					<label for="sala" class="col-form-label">Sala</label> 
					<form:select id="sala" path="sala" class="form-control">
						<form:option value="Premium">Sala Premium</form:option>
						<form:option value="Sala 1">Sala 1</form:option>
						<form:option value="Sala 2">Sala 2</form:option>
						<form:option value="Sala 3">Sala 3</form:option>
					</form:select>
				</div>

				<div class="form-group col-sm-3">
					<label for="precio" class="col-form-label">Precio</label> 
					<form:input type="text" class="form-control" path="precio" id="precio" required="required" />
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
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script>
		$(function() {
			$("#fecha").datepicker({
				dateFormat : 'dd-mm-yy'
			});
		});
	</script>
</body>
</html>
