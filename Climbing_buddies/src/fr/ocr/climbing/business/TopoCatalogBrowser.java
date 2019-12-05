package fr.ocr.climbing.business;



import java.util.ArrayList;
import java.util.List;

import fr.ocr.climbing.dao.TopoDAO;

public class TopoCatalogBrowser {

	private int currentPosition = 1;
	private Topo currentTopo;
	private int topoCount = TopoDAO.getTopoCount();
	
	private List<ShoppingCartLine> shoppingCart = new ArrayList<>();
	
	
	public TopoCatalogBrowser() {
		currentTopo = TopoDAO.getTopoById( currentPosition );
	}
	
	public Topo getCurrentArticle() {
		return currentTopo;
	}

	public List<ShoppingCartLine> getShoppingCart() {
		return shoppingCart;
	}
	
	public int getShoppingCartSize() {
		int fullQuantity = 0;
		for (ShoppingCartLine shoppingCartLine : shoppingCart) {
			fullQuantity += shoppingCartLine.getQuantity();
		}
		return fullQuantity;
	}
	
	public void goPrevious() {
		if ( --currentPosition < 1 ) {
			currentPosition = topoCount;
		}
		currentTopo = TopoDAO.getTopoById( currentPosition );
	}
	
	public void goNext() {
		if ( ++currentPosition > topoCount ) {
			currentPosition = 1;
		}
		currentTopo = TopoDAO.getTopoById( currentPosition );
	}
	
	public void addCurrentTopo() {
		for (ShoppingCartLine shoppingCartLine : shoppingCart) {
			if ( shoppingCartLine.getTopo().getTopo_id() == currentTopo.getTopo_id() ) {
				shoppingCartLine.increaseQuantity();
				return;
			}
		}
		shoppingCart.add( new ShoppingCartLine( currentTopo, 1 ) );
	}
	
}
