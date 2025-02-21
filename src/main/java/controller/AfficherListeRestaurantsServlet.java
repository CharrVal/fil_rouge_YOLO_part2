package controller;

import java.io.IOException;

import bll.RestaurantBLL;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/listeRestaurants")
public class AfficherListeRestaurantsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private RestaurantBLL bll;
	 
	@Override
	public void init() throws ServletException {
		bll = new RestaurantBLL();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("listeRestaurants", bll.select());
		request.getRequestDispatcher("/WEB-INF/jsp/listeRestaurants.jsp").forward(request, response);
	}

}