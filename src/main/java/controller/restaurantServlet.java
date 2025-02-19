package controller;

import java.io.IOException;

import bll.RestaurantBLL;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/restaurant")
public class restaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RestaurantBLL bll;
    
	@Override
	public void init() throws ServletException {
		bll = new RestaurantBLL();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("index");
		request.setAttribute("restaurant", bll.selectById(Integer.parseInt(id)));
		request.getRequestDispatcher("/WEB-INF/jsp/restaurant.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}