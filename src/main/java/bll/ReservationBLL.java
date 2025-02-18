package bll;

import java.util.List;

import Exception.ReservationException;
import bo.Reservation;
import dal.ReservationDAO;

public class ReservationBLL {
	private ReservationDAO dao;
	
	public ReservationBLL() {
		dao = new ReservationDAO();
	}
	
	public List<Reservation> select() {
		return dao.select();
	}
	
	public Reservation selectById(int id) {
		return dao.selectById(id);
	}
	
	public void insert(Reservation Reservation) throws ReservationException {
		//verifier(Reservation);
		dao.insert(Reservation);
	}

	public void delete(Reservation Reservation) {
		dao.delete(Reservation);
	}

	public void update(Reservation Reservation) throws ReservationException {
		// verifier(Reservation);
		dao.update(Reservation);
	}
}
