package bo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity @Table(name="reservations")
public class Reservation {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre_personne")
	private int nbPersonne;

	@Column(name = "statut")
	private String statut;

	@Column(name = "horaire_reservation")
	private LocalDateTime horaireReservation;
		
	@OneToOne
	@JoinColumn(name="id_utilisateurs")
	private Utilisateur utilisateur;
	
	@OneToOne
	@JoinColumn(name="id_restaurants")
	private Restaurant restaurant;
	
	public Reservation(int id, int nbPersonne, String statut, LocalDateTime horaireReservation, Utilisateur utilisateur, Restaurant restaurant) {
		this.id = id;
		this.nbPersonne = nbPersonne;
		this.statut = statut;
		this.horaireReservation = horaireReservation;
		this.utilisateur = utilisateur;
		this.restaurant = restaurant;
	}
	
	public Reservation(int nbPersonne, String statut, LocalDateTime horaireReservation, Utilisateur utilisateur, Restaurant restaurant) {
		this.nbPersonne = nbPersonne;
		this.statut = statut;
		this.horaireReservation = horaireReservation;
		this.utilisateur = utilisateur;
		this.restaurant = restaurant;
	}

	public Reservation() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public int getNbPersonne() {
		return nbPersonne;
	}

	public void setNbPersonne(int nbPersonne) {
		this.nbPersonne = nbPersonne;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public LocalDateTime getHoraireReservation() {
		return horaireReservation;
	}

	public void setHoraireReservation(LocalDateTime dateTimeReservation) {
		this.horaireReservation = dateTimeReservation;
	}	
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
}
