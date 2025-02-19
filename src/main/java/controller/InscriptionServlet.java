package controller;

import java.io.IOException;

import javax.naming.NamingException;

import Exception.UtilisateurException;
import bll.UtilisateurBLL;
import bo.Role;
import bo.Utilisateur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/inscription")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurBLL utilisateurbll = new UtilisateurBLL();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/inscription.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String login = request.getParameter("login");
		String mdp = request.getParameter("mdp");
		String mdp2 = request.getParameter("mdp2");
		String email = request.getParameter("email");
		String tel = request.getParameter("telephone");
		
		if ((nom == null || nom.isEmpty() || 
	        prenom == null || prenom.isEmpty() || 
	        tel == null || tel.isEmpty() || 
	        email == null || email.isEmpty() || 
	        login == null || login.isEmpty() || 
	        mdp == null || mdp.isEmpty() || 
	        mdp2 == null || mdp2.isEmpty())) {
			request.setAttribute("error", "Tous les champs sont obligatoires.");
	        request.getRequestDispatcher("/WEB-INF/jsp/inscription.jsp").forward(request, response);
	        return;
	    }

	    if (!mdp.equals(mdp2)) {
	    	request.setAttribute("error", "Les mots de passe ne correspondent pas.");
	        request.getRequestDispatcher("/WEB-INF/jsp/inscription.jsp").forward(request, response);
	        return;
	    }

	    try {
	    	Utilisateur utilisateur = new Utilisateur();
	        utilisateur.setNom(nom);
	        utilisateur.setPrenom(prenom);
	        utilisateur.setTelephone(tel);
	        utilisateur.setEmail(email);
	        utilisateur.setLogin(login);
	        utilisateur.setPassword(mdp);
	        
	        Role role = new Role();
	        role.setId(3);
	        utilisateur.setRole(role);

	        utilisateurbll.insert(utilisateur);
	        
	        response.sendRedirect("connexion");
	    } catch (UtilisateurException | NamingException e) {
	        e.printStackTrace();
	        request.setAttribute("error", "Erreur lors de l'inscription : " + e.getMessage());
	        request.getRequestDispatcher("/WEB-INF/jsp/inscription.jsp").forward(request, response);
	    }
	}	
}
