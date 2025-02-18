package bo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="horaires")
public class Horaire {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String jour;
	private LocalDate ouverture;
	private LocalDate fermeture;
	
	public Horaire(int id, String jour, LocalDate ouverture, LocalDate fermeture) {
		this.id = id;
		this.jour = jour;
		this.ouverture = ouverture;
		this.fermeture = fermeture;
	}
	
	public Horaire( String jour, LocalDate ouverture, LocalDate fermeture) {
		this.jour = jour;
		this.ouverture = ouverture;
		this.fermeture = fermeture;
	}

	public Horaire() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJour() {
		return jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}

	public LocalDate getOuverture() {
		return ouverture;
	}

	public void setOuverture(LocalDate ouverture) {
		this.ouverture = ouverture;
	}

	public LocalDate getFermeture() {
		return fermeture;
	}

	public void setFermeture(LocalDate fermeture) {
		this.fermeture = fermeture;
	}	
}
