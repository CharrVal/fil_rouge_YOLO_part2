package controller;

import java.io.IOException;

import bll.UtilisateurBLL;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/profil")
public class profilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 int id = Integer.parseInt(request.getParameter("utilisateur"));
		 UtilisateurBLL bll= new UtilisateurBLL();
		 request.setAttribute("utilisateur",bll.selectById(id));
		request.getRequestDispatcher("/WEB-INF/jsp/profil.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}