<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Créer un utilisateur</title>
	<style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<header>
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
				<p class="lead mb-0">Ajoutez un utilisateur</p>
			</div>
		</div>
	</div>
</header>
<body>

	<section class="my-5">
	
			<div class="row">

				<div class="container">
					<div class="row">
						<div class="col-3">
							<a href="${pageContext.request.contextPath}/home" class="btn btn-primary btn-lg active" role="button">Accueil</a>
						</div>
						<div class="col-3">
							<a href="${pageContext.request.contextPath}/login" class="btn btn-primary btn-lg active" role="button">Login</a>
						</div>
						<div class="col-3">
							<a href="${pageContext.request.contextPath}/registration" class="btn btn-primary btn-lg active" role="button">Créer
								un compte</a>
						</div>
						<div class="col-3">
							<a href="${pageContext.request.contextPath}/userList" class="btn btn-primary btn-lg active" role="button">Liste
								des utilisateurs</a>
						</div>
	</div>

						<form:form class="my-5 center_div col-6" action="saveUser" method="POST"
							modelAttribute="userForm">
					<h3>${formTitle}</h3>

							<form:hidden path="id" />

							<table>
								<tr>
									<td>Name</td>
									<td><form:input path="name" /></td>
									<td><form:errors path="name" class="error-message" /></td>
								</tr>
								<tr>
									<td>Password</td>
									<td><form:input type="password" path="password" /></td>
									<td><form:errors path="password" class="error-message" /></td>
								</tr>
								<tr>
									<td>Email</td>
									<td><form:input path="email" /></td>
									<td><form:errors path="email" class="error-message" /></td>
								</tr>
								<tr>
									<td>Login</td>
									<td><form:input path="login" /></td>
									<td><form:errors path="login" class="error-message" /></td>

								</tr>

								<tr>
									<td>Cotation</td>
									<td><form:input path="cotation" /></td>
									<td><form:errors path="cotation" class="error-message" /></td>
								</tr>

								<tr>
									<td>&nbsp;</td>
									<td><input type="submit" value="Submit" /> <a
										href="${pageContext.request.contextPath}/userList">Cancel</a>
									</td>
									<td>&nbsp;</td>
								</tr>
							</table>
						</form:form>
					</div>
				</div>
	
		
	</section>
</body>
</html>