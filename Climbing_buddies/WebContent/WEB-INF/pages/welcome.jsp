<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>User List</title>
	<style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<header>
	<div class="overlay"></div>
	<video playsinline="playsinline" autoplay="autoplay" muted="muted"
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
						<div class="col-2">
							<a href="${pageContext.request.contextPath}/home">Accueil</a>
						</div>
						<div class="col-2">
							<a href="${pageContext.request.contextPath}/registration">Cr�er
								un compte</a>
						</div>
						<div class="col-2">
							<a href="${pageContext.request.contextPath}/userList">Liste
								des utilisateurs</a>
						</div>
						<div class="col-2">
							<a href="${pageContext.request.contextPath}/formUser">Cr�er
								un utilisateur</a>
						</div>
						<div class="col-2">
							<a href="${pageContext.request.contextPath}/logout">Se
								d�connecter</a>
						</div>
						<h2>
							Welcome ${user.name} | <a
								onclick="document.forms['logoutForm'].submit()">Logout</a>
						</h2>


						<form id="logoutForm" method="POST" action="${contextPath}/logout">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						</form>

					</div>
					<!-- /container -->
					<script
						src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
					<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

				</div>
			</div>
		</div>
	</section>
</body>
</html>