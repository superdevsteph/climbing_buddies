package fr.ocr.climbing.business;


public class ShoppingCartLine {

	private Topo topo;
	private int quantity;
	
	
	public ShoppingCartLine( Topo topo, int quantity ) {
		setTopo( topo );
		setQuantity( quantity );
	}
	
	
	public Topo getTopo() {
		return topo;
	}
	
	public void setTopo(Topo topo) {
		if ( topo == null ) throw new NullPointerException();
		this.topo = topo;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	public void increaseQuantity() {
		this.quantity++;
	}
	

}
