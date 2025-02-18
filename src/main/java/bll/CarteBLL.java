package bll;

import java.util.List;

import Exception.CarteException;
import bo.Carte;
import dal.CarteDAO;

public class CarteBLL {
	private CarteDAO dao;
	
	public CarteBLL() {
		dao = new CarteDAO();
	}
	
	public List<Carte> select() {
		return dao.select();
	}
	
	public Carte selectById(int id) {
		return dao.selectById(id);
	}
	
	public void insert(Carte Carte) throws CarteException {
		//verifier(Carte);
		dao.insert(Carte);
	}

	public void delete(Carte Carte) {
		dao.delete(Carte);
	}

	public void update(Carte Carte) throws CarteException {
		// verifier(Carte);
		dao.update(Carte);
	}

}
