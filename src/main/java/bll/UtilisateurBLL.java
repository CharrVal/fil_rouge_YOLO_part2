package bll;

import java.sql.SQLException;
import java.util.HashMap;
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
	
	public Utilisateur selectByLoginPassword(String login, String password) {
		return dao.selectByLoginPassword(login, password);
	}

	public void insert(Utilisateur utilisateur) throws UtilisateurException, NamingException {

		verifier(utilisateur);
		Utilisateur existant = dao.connecterUtilisateur(utilisateur.getLogin(), utilisateur.getPassword());
		if (existant != null) {
			throw new UtilisateurException("Un compte avec ce login existe déjà.", null);
		}
		dao.insert(utilisateur);
	}

	public void delete(Utilisateur utilisateur) {
		dao.delete(utilisateur);
	}

	public void update(Utilisateur utilisateur) throws UtilisateurException {
		verifier(utilisateur);
		dao.update(utilisateur);
	}

	public Utilisateur connecterUtilisateur(String login, String password) throws NamingException {
		return dao.connecterUtilisateur(login, password);
	}
	
	public boolean utilisateurValide(Utilisateur utilisateur) throws SQLException {
		dao = new UtilisateurDAO();
		return dao.utilisateurValide(utilisateur);	
	}
	
	public boolean utilisateurExiste(Utilisateur utilisateur) throws SQLException {
		dao = new UtilisateurDAO();
		return dao.utilisateurExiste(utilisateur);	
	}

	public void verifier(Utilisateur utilisateur) throws UtilisateurException {
		HashMap<String, String> erreurs = new HashMap<String, String>();
		if (utilisateur.getNom() == null || utilisateur.getNom().length() < 3 || utilisateur.getNom().length() > 20) {
			erreurs.put("nom", "Le nom doit faire entre 3 et 20 caractères.");
		}

		if (utilisateur.getPrenom() == null || utilisateur.getPrenom().length() < 3
				|| utilisateur.getPrenom().length() > 20) {
			erreurs.put("prenom", "Le prénom doit faire entre 3 et 20 caractères.");
		}

		if (utilisateur.getTelephone() == null || !numeroValide(utilisateur.getTelephone())) {

			erreurs.put("telephone", "Saisissez un numero de telephone valide !");
		}

		if (utilisateur.getEmail() == null || !emailValide(utilisateur.getEmail())) {
			erreurs.put("email", "Votre email n'est pas valide !");
		}
		if (!loginValide(utilisateur.getLogin())) {
			erreurs.put("login", "Votre login n'est pas valide !");
		}
		if (!isValidPassword(utilisateur.getPassword())) {
			erreurs.put("password",
					"Votre mot de passe n'est pas valide! Il doit contenir au moins 8 caractères, une lettre majuscule, une lettre minuscule, un chiffre et un caractère spécial.");
		}

		if (!erreurs.isEmpty()) {
			throw new UtilisateurException("Les informations saisies sont incorrectes", erreurs);
		}

	}

	public boolean emailValide(String email) {
		return email != null && email.matches("^[\\w.-]+@[a-zA-Z\\d.-]+\\.[a-zA-Z]{2,}$");
	}

	public boolean numeroValide(String phoneNumber) {
		return phoneNumber != null && phoneNumber.matches("\\d{10}");
	}

	public static boolean loginValide(String login) {
		return login != null && login.matches("^[a-zA-Z0-9._-]{3,20}$");
	}

	public static boolean isValidPassword(String password) {
		return password != null && password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$");
	}
}