<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>View Topo</title>
		<link rel="stylesheet" type="text/css" href="styles.css" />
	</head>
	<body>
        <h1>View topo - ${connectedUser.login}</h1>
	    <br/>
	   
        Identifier: ${TopocatalogBrowser.currentTopo.topo_id} <br/>
        Nom: ${catalogBrowser.currentTopo.topo_nom} <br/>	
        Région: ${catalogBrowser.currentTopo.topo_region} <br/>
        Sites price: ${catalogBrowser.currentTopo.topo_nbSites} <br/>
        Secteurs: ${catalogBrowser.currentTopo.topo_nbSecteurs} <br/>
        Voies price: ${catalogBrowser.currentTopo.topo_nbVoies} <br/>
        Disponibilité: ${catalogBrowser.currentTopo.topo_disponible} <br/>
       Description: ${catalogBrowser.currentTopo.topo_description} <br/>
       
        <br/>
        
        <form action="viewTopo" method="post">
            <input name="btnPrevious" type="submit" value="Previous" />
            &nbsp; &nbsp;
            <input name="btnAdd" type="submit" value="Add to shopping cart" />
            &nbsp; &nbsp;
            <input name="btnNext" type="submit" value="Next" />
        </form>  <br/>
        
        ${TopocatalogBrowser.shoppingCartSize} topo<c:if test="${TopocatalogBrowser.shoppingCartSize gt 1}">s</c:if> in the shopping cart.<br/>
        <a href="summary">View the shopping cart</a>
	</body>
</html>