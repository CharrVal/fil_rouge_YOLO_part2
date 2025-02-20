package controller;

import java.io.IOException;

import Exception.UtilisateurException;
import bll.UtilisateurBLL;
import bo.Utilisateur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/modifier")
public class profilModifServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/jsp/modifierProfil.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UtilisateurBLL bll = new UtilisateurBLL();
		HttpSession session = request.getSession(false);
		if (session == null) {
			response.sendRedirect("connexion");
		} else {
			try {
				Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
				Utilisateur util = new Utilisateur();
				util.setId(utilisateur.getId());
				util.setNom(request.getParameter("inputNom"));
				util.setPrenom(request.getParameter("inputPrenom"));
				util.setTelephone(request.getParameter("inputTel"));
				util.setEmail(request.getParameter("inputEmail"));
				util.setLogin(request.getParameter("inputLogin"));
				util.setPassword(request.getParameter("inputMp"));
				util.setRole(utilisateur.getRole());
				util.setReservations(utilisateur.getReservations());
				bll.update(util);
				session.setAttribute("utilisateur", util);
				response.sendRedirect("profil");

		
		} catch (UtilisateurException e) {
				request.setAttribute("erreur", e.getErreurs());
				request.getRequestDispatcher("/WEB-INF/jsp/modifierProfil.jsp").forward(request, response);
			}
		}
	}
}