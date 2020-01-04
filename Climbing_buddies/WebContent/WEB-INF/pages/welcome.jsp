<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>User List</title>
	<style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<header class="h-25 d-inline-block">
	<div class="overlay"></div>
	<video autoplay="autoplay" muted="muted"
		loop="loop">
		<source
			src="https://storage.googleapis.com/coverr-main/mp4/Mt_Baker.mp4"
			type="video/mp4">
	</video>
	<div class="container h-100">
		<div class="d-flex h-100 text-center align-items-center">
			<div class="w-100 text-white">
				<h1 class="display-3">Les amis de l'escalade</h1>
				<p class="lead mb-0">coucou</p>
			</div>
		</div>
	</div>
</header>
<body>

	<section class="my-5">
		<div class="container-fluid">
			<div class="row">
	<div class="container">
					<div class="row">
						<div class="col-3">
							<a href="${pageContext.request.contextPath}/home" class="btn btn-primary btn-lg active" role="button">Accueil</a>
						</div>
						
						<div class="col-3">
							<a href="${pageContext.request.contextPath}/infos" class="btn btn-primary btn-lg active" role="button">A propos de nous</a>
						</div>
						
							<div class="col-3">
							<a href="${pageContext.request.contextPath}/topoList" class="btn btn-primary btn-lg active" role="button">Les Topos</a>
						</div>
						<div class="col-3">
							<a href="${pageContext.request.contextPath}/formTopo" class="btn btn-primary btn-lg active" role="button">Ajouter un Topo</a>
						</div>

					</div>
				</div>
				
						
						
						<section class="my-5 container col-3">

						<h2>Welcome  ${username}</h2>
 
 
   <p> Hello ${info.name}, Bienvenue ! </p>
    
<a onclick="document.forms['logoutForm'].submit()" class="btn btn-primary btn-lg active">Logout</a>
						

						<form id="logoutForm" method="POST" action="${pageContext.request.contextPath}/home">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						</form>
</section>
					</div>
				
				</div>
			
	</section>
</body>
</html>