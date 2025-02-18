package bll;

import java.util.List;

import Exception.UtilisateurException;
import bo.Utilisateur;
import dal.UtilisateurDAO;

public class UtilisateurBLL {
	private UtilisateurDAO dao;
	
	public UtilisateurBLL() {
		dao = new UtilisateurDAO();
	}
	
	public List<Utilisateur> select() {
		return dao.select();
	}
	
	public Utilisateur selectById(int id) {
		return dao.selectById(id);
	}
	
	public void insert(Utilisateur utilisateur) throws UtilisateurException {
		//verifier(utilisateur);
		dao.insert(utilisateur);
	}

	public void delete(Utilisateur utilisateur) {
		dao.delete(utilisateur);
	}

	public void update(Utilisateur utilisateur) throws UtilisateurException {
		// verifier(utilisateur);
		dao.update(utilisateur);
	}
}
