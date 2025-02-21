package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import bll.RestaurantBLL;
import bo.Restaurant;
import bo.Utilisateur;


@WebServlet("/contactezNous")
public class contactezNousServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RestaurantBLL bll = new RestaurantBLL();
	private Utilisateur utilisateur;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idParam = request.getParameter("idRestaurant");
		int id = Integer.parseInt(idParam);
		Restaurant restaurant = bll.selectById(id);
		request.setAttribute("restaurant", restaurant);
		request.getRequestDispatcher("/WEB-INF/jsp/contactezNous.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titre = request.getParameter("titre");
        String message = request.getParameter("message");

        String idParam = request.getParameter("idRestaurant");
        if (idParam == null || idParam.isEmpty()) {
            // Gérer l'erreur si l'ID du restaurant est manquant
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID du restaurant manquant");
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idParam);
        } catch (NumberFormatException e) {
            // Gérer l'erreur si l'ID du restaurant n'est pas un entier valide
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID du restaurant invalide");
            return;
        }

        Restaurant restaurant = bll.selectById(id);
        request.setAttribute("restaurant", restaurant);

        // Logique de traitement du message, par exemple, enregistrer dans une base de données ou envoyer un email

        // Redirection vers la page de confirmation
        request.getRequestDispatcher("/WEB-INF/jsp/contactezNousConfirmation.jsp").forward(request, response);
	}
}
