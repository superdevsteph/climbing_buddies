package fr.ocr.climbing.business;


public class Topo {

	
	private int topo_id;
	private String topo_nom;
	private String topo_region;
	private int topo_nbSites;
	private int topo_nbSecteurs;
	private int topo_nbVoies;
	private boolean topo_disponible;
	private String topo_description;
	private int topo_user_fk_id;
	
	public Topo() {
	}
	

	public Topo(int topo_id, String topo_nom, String topo_region, int topo_nbSites, int topo_nbSecteurs,
			int topo_nbVoies, boolean topo_disponible, String topo_description, int topo_user_fk_id) {
		super();
		this.topo_id = topo_id;
		this.topo_nom = topo_nom;
		this.topo_region = topo_region;
		this.topo_nbSites = topo_nbSites;
		this.topo_nbSecteurs = topo_nbSecteurs;
		this.topo_nbVoies = topo_nbVoies;
		this.topo_disponible = topo_disponible;
		this.topo_description = topo_description;
		this.topo_user_fk_id = topo_user_fk_id;
	}

	
	
	
	public int getTopo_id() {
		return topo_id;
	}


	public void setTopo_id(int topo_id) {
		this.topo_id = topo_id;
	}


	public String getTopo_nom() {
		return topo_nom;
	}


	public void setTopo_nom(String topo_nom) {
		this.topo_nom = topo_nom;
	}


	public String getTopo_region() {
		return topo_region;
	}


	public void setTopo_region(String topo_region) {
		this.topo_region = topo_region;
	}


	public int getTopo_nbSites() {
		return topo_nbSites;
	}


	public void setTopo_nbSites(int topo_nbSites) {
		this.topo_nbSites = topo_nbSites;
	}


	public int getTopo_nbSecteurs() {
		return topo_nbSecteurs;
	}


	public void setTopo_nbSecteurs(int topo_nbSecteurs) {
		this.topo_nbSecteurs = topo_nbSecteurs;
	}


	public int getTopo_nbVoies() {
		return topo_nbVoies;
	}


	public void setTopo_nbVoies(int topo_nbVoies) {
		this.topo_nbVoies = topo_nbVoies;
	}


	public boolean isTopo_disponible() {
		return topo_disponible;
	}


	public void setTopo_disponible(boolean topo_disponible) {
		this.topo_disponible = topo_disponible;
	}


	public String getTopo_description() {
		return topo_description;
	}


	public void setTopo_description(String topo_description) {
		this.topo_description = topo_description;
	}


	public int getTopo_user_fk_id() {
		return topo_user_fk_id;
	}


	public void setTopo_user_fk_id(int topo_user_fk_id) {
		this.topo_user_fk_id = topo_user_fk_id;
	}

	
}
