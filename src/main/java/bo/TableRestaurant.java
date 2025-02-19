package bo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity	@Table(name="tables_restaurant")
public class TableRestaurant {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nb_places")
	private int nbPlaces;
	
	@Column(name="numero_table")
	private int numeroTable;
	
	@OneToMany
	@JoinColumn(name="id_tables_restaurant")
	private List<Reservation> reservations;
	
	public TableRestaurant(int id, int nbPlaces, int numeroTable, List<Reservation> reservations) {
		this.id = id;
		this.nbPlaces = nbPlaces;
		this.numeroTable = numeroTable;
		this.reservations = reservations;
	}

	public TableRestaurant(int nbPlaces, int numeroTable, List<Reservation> reservations) {
		this.nbPlaces = nbPlaces;
		this.numeroTable = numeroTable;
		this.reservations = reservations;
	}
	
	public TableRestaurant() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNbPlaces() {
		return nbPlaces;
	}

	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	public int getNumeroTable() {
		return numeroTable;
	}

	public void setNumeroTable(int numeroTable) {
		this.numeroTable = numeroTable;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}	
}