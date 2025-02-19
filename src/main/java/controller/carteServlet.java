package controller;

import java.io.IOException;

import bll.CarteBLL;
import bll.RestaurantBLL;
import bo.Carte;
import bo.Restaurant;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/carte")
public class carteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CarteBLL cartebll = new CarteBLL();
	private RestaurantBLL restaurantbll;
	
	@Override
	public void init() throws ServletException {
		restaurantbll = new RestaurantBLL();
		cartebll = new CarteBLL();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idParam = request.getParameter("id");
		int id = Integer.parseInt(idParam);
		
		Restaurant restaurant = restaurantbll.selectById(id);
		Carte carte = cartebll.selectById(id);
		
		request.setAttribute("restaurant", restaurant);
		request.setAttribute("carte", carte);
		request.getRequestDispatcher("/WEB-INF/jsp/carte.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}