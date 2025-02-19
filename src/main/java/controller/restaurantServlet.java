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

@WebServlet("/restaurant")
public class restaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RestaurantBLL restaurantBll;
	private CarteBLL carteBll;
    
	@Override
	public void init() throws ServletException {
		restaurantBll = new RestaurantBLL();
		carteBll = new CarteBLL();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idParam = request.getParameter("index");
		int id = Integer.parseInt(idParam);
		Restaurant restaurant = restaurantBll.selectById(id);
		Carte carte = carteBll.selectById(id);
		request.setAttribute("restaurant", restaurant);
		request.setAttribute("carte", carte);
		request.getRequestDispatcher("/WEB-INF/jsp/restaurant.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}