package fr.ocr.climbing.model;

import java.util.Date;

public class TopoInfo {
 
	private Long id; 
	private String nom;
	private String region; 
	private int nbSites;
	private int nbSecteurs; 
	private int nbVoies; 
	private boolean disponible; 
	private String description; 
	private Date datePublication;
 
    public TopoInfo() {
 
    }
 



	public TopoInfo(Long id, String nom, String region, int nbSites, int nbSecteurs, int nbVoies, boolean disponible,
			String description, Date datePublication) {
		this.id = id;
		this.nom = nom;
		this.region = region;
		this.nbSites = nbSites;
		this.nbSecteurs = nbSecteurs;
		this.nbVoies = nbVoies;
		this.disponible = disponible;
		this.description = description;
		this.datePublication = datePublication;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getNom() {
		return nom;
	}




	public void setNom(String nom) {
		this.nom = nom;
	}




	public String getRegion() {
		return region;
	}




	public void setRegion(String region) {
		this.region = region;
	}




	public int getNbSites() {
		return nbSites;
	}




	public void setNbSites(int nbSites) {
		this.nbSites = nbSites;
	}




	public int getNbSecteurs() {
		return nbSecteurs;
	}




	public void setNbSecteurs(int nbSecteurs) {
		this.nbSecteurs = nbSecteurs;
	}




	public int getNbVoies() {
		return nbVoies;
	}




	public void setNbVoies(int nbVoies) {
		this.nbVoies = nbVoies;
	}




	public boolean isDisponible() {
		return disponible;
	}




	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public Date getDatePublication() {
		return datePublication;
	}




	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}





 
}