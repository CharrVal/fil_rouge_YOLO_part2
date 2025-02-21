package controller;

import java.io.IOException;

import bll.RestaurantBLL;
import bo.Restaurant;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.EmailUtil;


@WebServlet("/contactezNous")
public class ContactezNousServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RestaurantBLL bll = new RestaurantBLL();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idParam = request.getParameter("idRestaurant");
		int id = Integer.parseInt(idParam);
		Restaurant restaurant = bll.selectById(id);
		
		String subject = request.getParameter("subject");
		String body = request.getParameter("body");
		
		if (subject != null && body != null && !subject.isEmpty() && !body.isEmpty()) {
	        // Construct recipient email (could be restaurant email or your admin email)
	        String recipientEmail = restaurant.getEmail() != null ? 
	            restaurant.getEmail() : "admin@yourrestaurant.com";
	        
	        // Try to send email
	        boolean emailSent = EmailUtil.sendEmail(recipientEmail, subject, body);
	        
	        // Add result as attribute for confirmation page
	        request.setAttribute("emailSent", emailSent);
	        request.setAttribute("restaurant", restaurant);
	        
	        request.getRequestDispatcher("/WEB-INF/jsp/contactezNousConfirmation.jsp").forward(request, response);
	        return;
	    }
		
		request.setAttribute("restaurant", restaurant);
		request.getRequestDispatcher("/WEB-INF/jsp/contactezNous.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ici gérer l'envoi du message !
	}

}
