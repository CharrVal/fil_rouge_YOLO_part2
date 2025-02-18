package bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table
public class Reservation {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
}
