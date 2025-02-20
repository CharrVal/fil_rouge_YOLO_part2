package bll;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

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
	
	public void insert(Utilisateur utilisateur) throws UtilisateurException, NamingException {
	    Utilisateur existant = dao.connecterUtilisateur(utilisateur.getLogin(), utilisateur.getPassword());
	    if (existant != null) {
	        throw new UtilisateurException("Un compte avec ce login existe déjà.");
	    }
	    dao.insert(utilisateur);
	}


	public void delete(Utilisateur utilisateur) {
		dao.delete(utilisateur);
	}

	public void update(Utilisateur utilisateur) throws UtilisateurException {
		// verifier(utilisateur);
		dao.update(utilisateur);
	}
	
	public Utilisateur connecterUtilisateur(String login, String password) throws NamingException {
		return dao.connecterUtilisateur(login, password);
	}
	
	public boolean utilisateurValide(Utilisateur utilisateur) throws SQLException {
		dao = new UtilisateurDAO();
		return dao.utilisateurValide(utilisateur);	
	}
}