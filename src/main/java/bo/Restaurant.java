package bo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity @Table
public class Restaurant {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String adresse;
	private String url_image;
	
	@OneToOne
	private Carte carte;
	
	@OneToMany
	@JoinColumn(name="restaurant_id")
	private List<TableRestaurant> tablesRestaurant;

	public Restaurant(int id, String nom, String adresse, String url_image, Carte carte, List<TableRestaurant> tablesRestaurant) {
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.url_image = url_image;
		this.carte = carte;
		this.tablesRestaurant = tablesRestaurant;
	}
	
	public Restaurant(String nom, String adresse, String url_image, Carte carte, List<TableRestaurant> tablesRestaurant) {
		this.nom = nom;
		this.adresse = adresse;
		this.url_image = url_image;
		this.carte = carte;
		this.tablesRestaurant = tablesRestaurant;
	}
	
	public Restaurant() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getUrl_image() {
		return url_image;
	}

	public void setUrl_image(String url_image) {
		this.url_image = url_image;
	}

	public Carte getCarte() {
		return carte;
	}

	public void setCarte(Carte carte) {
		this.carte = carte;
	}

	public List<TableRestaurant> getTables() {
		return tablesRestaurant;
	}

	public void setTables(List<TableRestaurant> tablesRestaurant) {
		this.tablesRestaurant = tablesRestaurant;
	}		
}