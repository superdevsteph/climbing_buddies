<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Shopping cart summary</title>
		<link rel="stylesheet" type="text/css" href="styles.css" />
	</head>
	<body>
        <h1>Shopping cart summary - ${connectedUser.login}</h1>
	    <br/>
	   
		<table style="width: 60%; border: 1px solid black; margin: auto;"> 
			<thead>
				<tr>
					<th>Identifier</th>
					<th>Description</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="#{catalogBrowser.shoppingCart}" var="line">
					<tr>
						<td>${line.topo.topo_id}</td>
						<td>${line.topo.description}</td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>        

		<br/><br/>
		
		<a href="viewTopo">Return to catalog</a>
		
	</body>
</html>