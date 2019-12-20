<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html >
	
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Login</title>
	<style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<header>
  <div class="overlay"></div>
  <video playsinline="playsinline" autoplay="autoplay" muted="muted" loop="loop">
    <source src="https://storage.googleapis.com/coverr-main/mp4/Mt_Baker.mp4" type="video/mp4">
  </video>
  <div class="container h-100">
    <div class="d-flex h-100 text-center align-items-center">
      <div class="w-100 text-white">
        <h1 class="display-3">Les amis de l'escalade</h1>
        <p class="lead mb-0">Vous pouvez vous authentifier ici</p>
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
							<a href="${pageContext.request.contextPath}/login">Login</a>
						</div>
						<div class="col-2">
							<a href="${pageContext.request.contextPath}/registration">Créer
								un compte</a>
						</div>
						<div class="col-2">
							<a href="${pageContext.request.contextPath}/userList">Liste
								des utilisateurs</a>
						</div>
						<div class="col-2">
							<a href="${pageContext.request.contextPath}/formUser">Créer
								un utilisateur</a>
						</div>
						  </div>
  </div>
						</section>
<section class="my-5 ">
		<div class="container">
			<div class="row  ">

    <form method="POST" action="${contextPath}/login" class="form-signin">
        <h2 class="form-heading text-primary ">Log in</h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            <input name="username" type="text" class="form-control" placeholder="Username"/>
            <input name="password" type="password" class="form-control" placeholder="Password"/>
            <span>${error}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
            <h4 class="text-center"><a href="${contextPath}/registration">Create an account</a></h4>
        </div>

    </form>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/js/bootstrap.min.js"></script>
 </div>
 </section>
  

</body>
</html>