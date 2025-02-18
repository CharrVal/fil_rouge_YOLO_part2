package bll;

import java.util.List;

import Exception.CategorieException;
import bo.Categorie;
import dal.CategorieDAO;

public class CategorieBLL {
	private CategorieDAO dao;
	
	public CategorieBLL() {
		dao = new CategorieDAO();
	}
	
	public List<Categorie> select() {
		return dao.select();
	}
	
	public Categorie selectById(int id) {
		return dao.selectById(id);
	}
	
	public void insert(Categorie Categorie) throws CategorieException {
		//verifier(Categorie);
		dao.insert(Categorie);
	}

	public void delete(Categorie Categorie) {
		dao.delete(Categorie);
	}

	public void update(Categorie Categorie) throws CategorieException {
		// verifier(Categorie);
		dao.update(Categorie);
	}
}
