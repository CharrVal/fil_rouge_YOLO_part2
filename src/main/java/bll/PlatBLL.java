package bll;

import java.util.List;

import Exception.PlatException;
import bo.Plat;
import dal.PlatDAO;

public class PlatBLL {
	private PlatDAO dao;
	
	public PlatBLL() {
		dao = new PlatDAO();
	}
	
	public List<Plat> select() {
		return dao.select();
	}
	
	public Plat selectById(int id) {
		return dao.selectById(id);
	}
	
	public void insert(Plat Plat) throws PlatException {
		//verifier(Plat);
		dao.insert(Plat);
	}

	public void delete(Plat Plat) {
		dao.delete(Plat);
	}

	public void update(Plat Plat) throws PlatException {
		// verifier(Plat);
		dao.update(Plat);
	}

}
