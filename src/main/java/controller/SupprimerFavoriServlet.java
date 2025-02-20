package controller;

import java.io.IOException;

import Exception.UtilisateurException;
import bll.RestaurantBLL;
import bll.UtilisateurBLL;
import bo.Utilisateur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/supprimerfavori")
public class SupprimerFavoriServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private RestaurantBLL restoBll = new RestaurantBLL();
	 private UtilisateurBLL utilisateurBLL = new UtilisateurBLL();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null) {
			response.sendRedirect("connexion");
			return;
		}
		
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		if (utilisateur == null) {
	         response.sendRedirect("connexion");
	         return;
	     }
		
		String idRestoParam = request.getParameter("idRestaurant");
		int idResto = Integer.parseInt(idRestoParam);
		utilisateur.setRestaurant(null);

		try {
			utilisateurBLL.update(utilisateur);
		} catch (UtilisateurException e) {
			e.printStackTrace();
		}
		session.setAttribute("utilisateur", utilisateur);
		
		 response.sendRedirect("profil");
	}
          
}
