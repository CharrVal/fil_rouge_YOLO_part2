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
         
		
		//HttpSession session = request.getSession(false);
		//if(session !=null) {
			//Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");

				//int id = utilisateur.getId();
				UtilisateurBLL bll= new UtilisateurBLL();
				request.setAttribute("utilisateur",bll.selectById(1));
		//}

		request.getRequestDispatcher("/WEB-INF/jsp/profil.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}