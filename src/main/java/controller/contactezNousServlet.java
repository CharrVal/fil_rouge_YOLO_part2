package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import bll.RestaurantBLL;
import bo.Restaurant;


@WebServlet("/contactezNous")
public class contactezNousServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RestaurantBLL bll = new RestaurantBLL();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idParam = request.getParameter("idRestaurant");
		int id = Integer.parseInt(idParam);
		Restaurant restaurant = bll.selectById(id);
		request.setAttribute("restaurant", restaurant);
		request.getRequestDispatcher("/WEB-INF/jsp/contactezNous.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ici gérer l'envoi du message !
	}

}
