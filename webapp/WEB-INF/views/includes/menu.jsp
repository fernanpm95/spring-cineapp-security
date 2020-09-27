
<!-- Fixed navbar -->
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<spring:url value="/" var="urlRoot" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<nav class="navbar navbar-inverse navbar-expand-md fixed-top navbar-dark bg-dark">
	
	<sec:authorize access="isAnonymous()">
		<a class="navbar-brand" href="${urlRoot}">My CineSite</a>
		<button type="button" class="navbar-toggler collapsed"
			data-toggle="collapse" data-target="#navbar" aria-expanded="false"
			aria-controls="navbar">
			<span class="sr-only">Toggle navigation</span> <i
				class="material-icons"> menu </i>
			<!-- <span class="navbar-toggler-icon"></span> -->
			<!-- <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span> -->
		</button>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="${urlRoot}">Home</a></li> 
				<li class="nav-item"><a class="nav-link" href="${urlRoot}about">Acerca</a></li>
				<li class="nav-item"><a class="nav-link" href="${urlRoot}formLogin">Iniciar sesión</a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</sec:authorize>
	
	<sec:authorize access="hasAnyAuthority('EDITOR')">
	<a class="navbar-brand" href="${urlRoot}admin/index">My Cinesite | Editor</a>
	<button type="button" class="navbar-toggler collapsed"
		data-toggle="collapse" data-target="#navbar" aria-expanded="false"
		aria-controls="navbar">
		<span class="sr-only">Toggle navigation</span> <i
			class="material-icons"> menu </i>
		<!-- <span class="navbar-toggler-icon"></span> -->
		<!-- <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span> -->
	</button>
	<div id="navbar" class="navbar-collapse collapse">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="${urlRoot}">Home</a></li>
			<li class="nav-item"><a class="nav-link" href="${urlRoot}peliculas/indexPaginate?page=0">Peliculas</a></li> 
			<li class="nav-item"><a class="nav-link" href="${urlRoot}noticias/index?page=0">Noticias</a></li> 
			<li class="nav-item"><a class="nav-link" href="${urlRoot}horarios/index?page=0">Horarios</a></li> 
			<li class="nav-item"><a class="nav-link" href="${urlRoot}admin/logout">Cerrar sesión</a></li>
		</ul>
	</div>
	<!--/.nav-collapse -->
	</sec:authorize>
	
	<sec:authorize access="hasAnyAuthority('GERENTE')">
	<a class="navbar-brand" href="${urlRoot}admin/index">My Cinesite | Gerente</a>
	<button type="button" class="navbar-toggler collapsed"
		data-toggle="collapse" data-target="#navbar" aria-expanded="false"
		aria-controls="navbar">
		<span class="sr-only">Toggle navigation</span> <i
			class="material-icons"> menu </i>
		<!-- <span class="navbar-toggler-icon"></span> -->
		<!-- <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span> -->
	</button>
	<div id="navbar" class="navbar-collapse collapse">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="${urlRoot}">Home</a></li>
			<li class="nav-item"><a class="nav-link" href="${urlRoot}peliculas/indexPaginate?page=0">Peliculas</a></li>
			<li class="nav-item"><a class="nav-link" href="${urlRoot}banners/index?page=0">Banners</a></li> 
			<li class="nav-item"><a class="nav-link" href="${urlRoot}noticias/index?page=0">Noticias</a></li> 
			<li class="nav-item"><a class="nav-link" href="${urlRoot}horarios/index?page=0">Horarios</a></li> 
			<li class="nav-item"><a class="nav-link" href="${urlRoot}admin/logout">Cerrar sesión</a></li>
		</ul>
	</div>
	<!--/.nav-collapse -->
	</sec:authorize>
</nav>