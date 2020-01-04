<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	 <meta http-equiv="X-UA-Compatible" content="IE=edge">
	 <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
	<title>Log in with your account</title>
	<style>
<%@ include file="/WEB-INF/css/style.css"%>
</style>
</head>
<header class="h-25 d-inline-block">
	<div class="overlay"></div>
	<video  autoplay="autoplay" muted="muted"
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
							<a href="${pageContext.request.contextPath}/home" class="btn btn-primary btn-lg active" role="button">Accueil</a>
						</div>
						<div class="col-2">
							<a href="${pageContext.request.contextPath}/login" class="btn btn-primary btn-lg active" role="button">Login</a>
						</div>
						<div class="col-2">
							<a href="${pageContext.request.contextPath}/registration" class="btn btn-primary btn-lg active" role="button">Créer
								un compte</a>
						</div>
						
						<div class="col-2">
							<a href="${pageContext.request.contextPath}/infos" class="btn btn-primary btn-lg active" role="button">A propos de nous</a>
						</div>
						
							<div class="col-2">
							<a href="${pageContext.request.contextPath}/topoList" class="btn btn-primary btn-lg active" role="button">Les Topos</a>
						</div>
						<div class="col-2">
							<a href="${pageContext.request.contextPath}/formTopo" class="btn btn-primary btn-lg active" role="button">Ajouter un Topo</a>
						</div>

					</div>
				</div>

			</div>
					
		</div>

	</section>
        <div id="mainWrapper" class="col-6 center_div">
            <div class="login-container">
                <div class="login-card">
                    <div class="login-form">
                        <c:url var="loginUrl" value="/login" />
                      
                        
                      <form method="POST" action="${contextPath}/login" class="form-signin">
        <h2 class="form-heading">Log in</h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            <input name="username" type="text" class="form-control" placeholder="Username"
                  />
            <input name="password" type="password" class="form-control" placeholder="Password"/>
            <span>${error}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
            <h4 class="text-center"><a href="${contextPath}/registration">Create an account</a></h4>
        </div>

    </form>
                    </div>
                </div>
            </div>
        </div>
 
    </body>
</html>