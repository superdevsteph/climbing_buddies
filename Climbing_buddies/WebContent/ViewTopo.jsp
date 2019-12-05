<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>View Topo</title>
		<link rel="stylesheet" type="text/css" href="styles.css" />
	</head>
	<body>
        <h1>Les Topos</h1>
        
        <p>Bonjour ${connectedUser.login} !</p>
        
	    <br/>
	   
        Identifier: ${topoCatalogBrowser.currentTopo.topo_id} <br/>
        Nom: ${topoCatalogBrowser.currentTopo.topo_nom} <br/>	
        Région: ${topoCatalogBrowser.currentTopo.topo_region} <br/>
        Sites : ${topoCatalogBrowser.currentTopo.topo_nbSites} <br/>
        Secteurs: ${topoCatalogBrowser.currentTopo.topo_nbSecteurs} <br/>
        Voies : ${topoCatalogBrowser.currentTopo.topo_nbVoies} <br/>
        Disponibilité: ${topoCatalogBrowser.currentTopo.topo_disponible} <br/>
       Description: ${topoCatalogBrowser.currentTopo.topo_description} <br/>
       
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