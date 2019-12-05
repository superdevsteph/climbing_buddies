<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>View Topo</title>
		<link rel="stylesheet" type="text/css" href="styles.css" />
	</head>
	<body>
        <h1>Les Topos - ${connectedUser.login}</h1>
	    <br/>
	   
        Identifier: ${TopocatalogBrowser.currentTopo.topo_id} <br/>
        Nom: ${TopocatalogBrowser.currentTopo.topo_nom} <br/>	
        Région: ${TopocatalogBrowser.currentTopo.topo_region} <br/>
        Sites : ${TopocatalogBrowser.currentTopo.topo_nbSites} <br/>
        Secteurs: ${TopocatalogBrowser.currentTopo.topo_nbSecteurs} <br/>
        Voies : ${TopocatalogBrowser.currentTopo.topo_nbVoies} <br/>
        Disponibilité: ${TopocatalogBrowser.currentTopo.topo_disponible} <br/>
       Description: ${TopocatalogBrowser.currentTopo.topo_description} <br/>
       
        <br/>
        
        <form action="viewTopo" method="post">
            <input name="btnPrevious" type="submit" value="Previous" />
            &nbsp; &nbsp;
            <input name="btnAdd" type="submit" value="Add to shopping cart" />
            &nbsp; &nbsp;
            <input name="btnNext" type="submit" value="Next" />
        </form>  <br/>
        
        ${topoCatalogBrowser.shoppingCartSize} topo(s) in the shopping cart.<br/>
        <a href="summary">View the shopping cart</a>
	</body>
</html>