package fr.ocr.climbing.entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/*import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;*/
import javax.persistence.Table;

@Entity
@Table(name="tb_topo")
public class Topo implements Serializable {

	private static final long serialVersionUID = -7893237204476214050L;
	   
	private Long id; 
	private String nom;
	private String region; 
	private int nbSites;
	private int nbSecteurs; 
	private int nbVoies; 
	private boolean disponible; 
	private String description; 
	private Date datePublication;
	//private Long userId;
	

	 @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY )
	   @Column(name = "topo_id", length = 50, nullable = false)
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	   @Column(name = "topo_nom", length = 50, nullable = false)
	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}

	   @Column(name = "topo_region", length = 50, nullable = false)
	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}

	   @Column(name = "topo_nbSites", length = 50, nullable = false)
	public int getNbSites() {
		return nbSites;
	}


	public void setNbSites(int nbSites) {
		this.nbSites = nbSites;
	}

	@Column(name = "topo_nbSecteurs", length = 50, nullable = false)
	public int getNbSecteurs() {
		return nbSecteurs;
	}


	public void setNbSecteurs(int nbSecteurs) {
		this.nbSecteurs = nbSecteurs;
	}

	@Column(name = "topo_nbVoies", length = 50, nullable = false)
	public int getNbVoies() {
		return nbVoies;
	}


	public void setNbVoies(int nbVoies) {
		this.nbVoies = nbVoies;
	}

	@Column(name = "topo_disponible", length = 50, nullable = false)
	public boolean isDisponible() {
		return disponible;
	}


	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	@Column(name = "topo_description", length = 50, nullable = false)
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "topo_publication", length = 50, nullable = false)
	public Date getDatePublication() {
		return datePublication;
	}


	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	} 
/*
@ManyToOne
@JoinTable(name="tb_user", joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name="topo_id"))
public Long getUserId() {
		return userId;
}

public void setUserId(Long userId) {
	this.userId = userId;
	
}
	*/
}
