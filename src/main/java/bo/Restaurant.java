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

@Entity @Table(name="restaurants")
public class Restaurant {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String adresse;
	private String email;
	private String url_image;
	
	@OneToOne
	@JoinColumn(name="id_cartes")
	private Carte carte;
	
	@OneToMany
	@JoinColumn(name="id_restaurants")
	private List<TableRestaurant> tablesRestaurant;
	
	@OneToMany
	@JoinColumn(name="id_restaurants")
	private List<Reservation> reservations;
	
	@OneToMany
	@JoinColumn(name="id_restaurants")
	private List<Utilisateur> utilisateurs;
	
	@OneToMany
	@JoinColumn(name="id_restaurants")
	private List<Horaire> horaires;

	public Restaurant(int id, String nom, String adresse, String email, String url_image, Carte carte, List<TableRestaurant> tablesRestaurant, List<Reservation> reservations,
			List<Utilisateur> utilisateurs, List<Horaire> horaires) {
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.email = email;
		this.url_image = url_image;
		this.carte = carte;
		this.tablesRestaurant = tablesRestaurant;
		this.reservations = reservations;
		this.utilisateurs = utilisateurs;
		this.horaires = horaires;
	}
	
	public Restaurant(String nom, String adresse, String email, String url_image, Carte carte, List<TableRestaurant> tablesRestaurant, List<Reservation> reservations,
			List<Utilisateur> utilisateurs, List<Horaire> horaires) {
		this.nom = nom;
		this.adresse = adresse;
		this.email = email;
		this.url_image = url_image;
		this.carte = carte;
		this.tablesRestaurant = tablesRestaurant;
		this.reservations = reservations;
		this.utilisateurs = utilisateurs;
		this.horaires = horaires;
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
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public List<TableRestaurant> getTablesRestaurant() {
		return tablesRestaurant;
	}

	public void setTablesRestaurant(List<TableRestaurant> tablesRestaurant) {
		this.tablesRestaurant = tablesRestaurant;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public List<Horaire> getHoraires() {
		return horaires;
	}

	public void setHoraires(List<Horaire> horaires) {
		this.horaires = horaires;
	}	
}