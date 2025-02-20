package bll;

import java.util.List;

import Exception.ReservationException;
import bo.Reservation;
import dal.ReservationDAO;

public class ReservationBLL {
	private ReservationDAO dao;
	
	public List<Reservation> select() {
		dao = new ReservationDAO();
		return dao.select();
	}
	
	public Reservation selectById(int id) {
		dao = new ReservationDAO();
		return dao.selectById(id);
	}
	
	public void insert(Reservation Reservation) throws ReservationException {
		//verifier(Reservation);
		dao = new ReservationDAO();
		dao.insert(Reservation);
	}

	public void delete(Reservation Reservation) {
		dao = new ReservationDAO();
		dao.delete(Reservation);
	}

	public void update(Reservation Reservation) throws ReservationException {
		// verifier(Reservation);
		dao = new ReservationDAO();
		dao.update(Reservation);
	}
}
