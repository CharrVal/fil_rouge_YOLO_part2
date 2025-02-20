package bll;

import java.util.List;

import Exception.HoraireException;
import bo.Horaire;
import dal.HoraireDAO;

public class HoraireBLL {
	private HoraireDAO dao;
	
	public HoraireBLL() {
		dao = new HoraireDAO();
	}

	public List<Horaire> select() {
		return dao.select();
	}
	
	public Horaire selectById(int id) {
		return dao.selectById(id);
	}
	
	public void insert(Horaire Horaire) throws HoraireException {
		//verifier(Horaire);
		dao.insert(Horaire);
	}

	public void delete(Horaire Horaire) {
		dao.delete(Horaire);
	}

	public void update(Horaire Horaire) throws HoraireException {
		// verifier(Horaire);
		dao.update(Horaire);
	}
}
