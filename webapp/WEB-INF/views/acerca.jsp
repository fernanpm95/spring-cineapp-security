<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">    
		<meta name="description" content="">
		<meta name="author" content="">
		<title>Acerca</title>    
<spring:url value="/resources" var="urlPublic"></spring:url>
<link href="${urlPublic}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">

	</head>

	<body>

		<jsp:include page="includes/menu.jsp"></jsp:include>

		<div class="container theme-showcase" role="main">

			<div class="badge badge-default">
				<div class="badge-heading">
					<h3 class="badge-title">ACERCA DE ESTA APLICACION</h3>
				</div>
				<div class="badge-body">
					<div class="row">
						<div class="col-sm-3">
							<p class="text-center">
								<img class="rounded" src="images/acerca.png" alt="Generic placeholder image" height="220">            
							</p>
						</div>
						<div class="col-sm-9">
							<div class="badge badge-default">
								<div class="badge-heading">
									<h3 class="badge-title">DETALLES</h3>
								</div>
								<div class="badge-body">                           
									LOS DETALLES DE ESTA APLICACION
								</div>
							</div>                          
						</div>
					</div>
				</div>
			</div>

			<jsp:include page="includes/footer.jsp"></jsp:include>

		</div> <!-- /container -->

		<!-- Bootstrap core JavaScript
		================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
		<script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>
	</body>
</html>
