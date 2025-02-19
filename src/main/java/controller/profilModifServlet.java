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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/jsp/modifierProfil.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtilisateurBLL bll= new UtilisateurBLL();
		HttpSession session = request.getSession(false);
		if (session == null) {
			response.sendRedirect("connexion");
		}
		Utilisateur utilisateur = (Utilisateur)session.getAttribute("utilisateur");
		try {
			Utilisateur util= new Utilisateur( request.getParameter("inputnom"), request.getParameter("inputprenom"),request.getParameter("inputTel"),
						request.getParameter("inputEmail"),request.getParameter("inputLogin") ,request.getParameter("inputMp"),utilisateur.getRole(),utilisateur.getReservations());
			bll.update(util);
		} catch (UtilisateurException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			request.getRequestDispatcher("profil").forward(request, response);
	}
}