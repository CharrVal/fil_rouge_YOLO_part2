package controller;

import java.io.IOException;

import bll.UtilisateurBLL;
import bo.Utilisateur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/profil")
public class profilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         
		
		/*HttpSession session = request.getSession(false);
		if(session !=null) {
			Utilisateur utilisateur = (Utilisateur)session.getAttribute("utilisateur");

				request.setAttribute("utilisateur", utilisateur);*/
		System.out.println("dans le servlet modifier*****************************************************************************************\n******************\n++++++++++");

				request.getRequestDispatcher("/WEB-INF/jsp/afficherProfil.jsp").forward(request, response);
       /* }else {
        	response.sendRedirect("connexion");
		}*/

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}