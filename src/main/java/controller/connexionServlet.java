package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import javax.naming.NamingException;

import bll.UtilisateurBLL;
import bo.Utilisateur;


@WebServlet("/connexion")
public class connexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        UtilisateurBLL utilisateurBLL = new UtilisateurBLL();
        Utilisateur utilisateur = null;
        
        HttpSession session = request.getSession();
        
        try {
            utilisateur = utilisateurBLL.connecterUtilisateur(login, password);

            if (utilisateur == null) {
                request.setAttribute("message", "Identifiant ou mot de passe incorrect.");
                request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward(request, response);
                return;
            }
            
            session.setAttribute("utilisateur", utilisateur);
            session.setAttribute("message", "Vous êtes connecté !");
            
            response.sendRedirect("listeRestaurants");
            
        } catch (NamingException e) {
            e.printStackTrace();
            request.setAttribute("message", "Une erreur est survenue. Veuillez réessayer.");
            request.getRequestDispatcher("/WEB-INF/jsp/connexion.jsp").forward(request, response);
        }
    }
}