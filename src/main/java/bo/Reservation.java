package bo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="reservations")
public class Reservation {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nombre_personne")
	private int nbPersonne;
	private String statut;
	private LocalDate horaireReservation;
		
	public Reservation(int id, int nbPersonne, String statut, LocalDate horaireReservation) {
		this.id = id;
		this.nbPersonne = nbPersonne;
		this.statut = statut;
		this.horaireReservation = horaireReservation;
	}
	
	public Reservation(int nbPersonne, String statut, LocalDate horaireReservation) {
		this.nbPersonne = nbPersonne;
		this.statut = statut;
		this.horaireReservation = horaireReservation;
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

	public LocalDate getHoraireReservation() {
		return horaireReservation;
	}

	public void setHoraireReservation(LocalDate horaireReservation) {
		this.horaireReservation = horaireReservation;
	}	
}
