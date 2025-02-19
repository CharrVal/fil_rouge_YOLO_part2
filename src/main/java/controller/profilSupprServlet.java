package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import bll.UtilisateurBLL;
import bo.Utilisateur;

@WebServlet("/supprimer")
public class profilSupprServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/jsp/supprimerProfil.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session !=null) {
			Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");

				UtilisateurBLL bll= new UtilisateurBLL();
				bll.delete(utilisateur);
				request.getSession().invalidate();
				request.getRequestDispatcher("/WEB-INF/jsp/accueil.jsp").forward(request, response);
		}
	}


}