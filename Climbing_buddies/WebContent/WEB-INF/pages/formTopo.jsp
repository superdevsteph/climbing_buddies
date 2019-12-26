<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Cr�er un utilisateur</title>
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
				<p class="lead mb-0">Ajoutez un Topo</p>
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
							<a href="${pageContext.request.contextPath}/registration" class="btn btn-primary btn-lg active" role="button">Cr�er
								un compte</a>
						</div>
						<div class="col-3">
							<a href="${pageContext.request.contextPath}/userList" class="btn btn-primary btn-lg active" role="button">Liste
								des utilisateurs</a>
						</div>
	</div>

						<form:form class="my-5 center_div col-6" action="saveTopo" method="POST"
							modelAttribute="topoForm">
					<h3>Ajouter un Topo</h3>

						
							<table>
								<tr>
									<td>Nom</td>
									<td><form:input path="nom" /></td>
									<td><form:errors path="nom" class="error-message" /></td>
								</tr>
								<tr>
									<td>R�gion</td>
									<td><form:input  path="region" /></td>
									<td><form:errors path="region" class="error-message" /></td>
								</tr>
								<tr>
									<td>Nombre de sites</td>
									<td><form:input path="nbSites" /></td>
									<td><form:errors path="nbSites" class="error-message" /></td>
								</tr>
								<tr>
									<td>Nombre de secteurs</td>
									<td><form:input path="nbSecteurs" /></td>
									<td><form:errors path="nbSecteurs" class="error-message" /></td>

								</tr>

								<tr>
									<td>Nombre de voies</td>
									<td><form:input path="nbVoies" /></td>
									<td><form:errors path="nbVoies" class="error-message" /></td>
								</tr>

								<tr>
									<td>Description</td>
									<td><form:input path="description" /></td>
									<td><form:errors path="description" class="error-message" /></td>
								</tr>
								<tr>
									<td>Date de publication</td>
									<td><form:input path="datePublication" /></td>
									<td><form:errors path="datePublication" class="error-message" /></td>
								</tr>
								
								<tr>
									<td>&nbsp;</td>
									<td><input type="submit" value="Submit" /> <a
										href="${pageContext.request.contextPath}/topoList">Cancel</a>
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