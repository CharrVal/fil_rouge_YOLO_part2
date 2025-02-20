package controller;

import java.io.IOException;

import bll.RestaurantBLL;
import bo.Restaurant;
import bo.Utilisateur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ajouterfavori")
public class AjouterFavoriServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Utilisateur utilisateur;
	private RestaurantBLL restoBll = new RestaurantBLL();

     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if (session == null) {
			response.sendRedirect("connexion");
		} else {
			utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		}
		
		String idRestoParam = request.getParameter("idRestaurant");
		int idResto = Integer.parseInt(idRestoParam);
		Restaurant restaurant = restoBll.selectById(idResto);

		utilisateur.setRestaurant(restaurant);
		
		//request.setAttribute("index", restaurant.getId());
		request.getRequestDispatcher("restaurant?index=" + idResto).forward(request, response);

	}

}
