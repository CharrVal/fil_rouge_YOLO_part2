package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import Exception.ReservationException;
import bll.ReservationBLL;
import bll.RestaurantBLL;
import bo.Reservation;
import bo.Restaurant;
import bo.Utilisateur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/reservationConfirmation")
public class reservationConfirmationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReservationBLL resaBll = new ReservationBLL();
	private RestaurantBLL restoBll = new RestaurantBLL();
	private Utilisateur utilisateur;

       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idRestoParam = request.getParameter("idRestaurant");
		int idResto = Integer.parseInt(idRestoParam);
		Restaurant restaurant = restoBll.selectById(idResto);
		
		String nbPersonnesParam = request.getParameter("nbPersonnes");
		int nbPersonnes = Integer.parseInt(nbPersonnesParam);
		System.out.println(nbPersonnes);
		
		String dateTimeReservationParam = request.getParameter("dateReservation") + " " + request.getParameter("horaireReservation");;
		System.out.println(dateTimeReservationParam);
		LocalDateTime dateTimeReservation = null;
		if (dateTimeReservationParam != null && !dateTimeReservationParam.isEmpty()) {
		    try {
		    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		    	dateTimeReservation = LocalDateTime.parse(dateTimeReservationParam, formatter);
		    } catch (DateTimeParseException e) {
		        System.err.println("Error parsing date: " + e.getMessage());
		        // request.setAttribute("errorMessage", "Invalid date format");
		    }
		}
		
		HttpSession session = request.getSession(false);
		if (session == null) {
			response.sendRedirect("connexion");
		} else {
			utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		}
		
		Reservation resa = new Reservation();
		resa.setHoraireReservation(dateTimeReservation);
		resa.setNbPersonne(nbPersonnes);
		resa.setStatut("En attente");
		resa.setUtilisateur(utilisateur);
		resa.setRestaurant(restaurant);
		
		System.out.println(resa.getHoraireReservation());
		System.out.println(resa.getNbPersonne());
		System.out.println(resa.getRestaurant().getId());
		System.out.println(resa.getStatut());
		System.out.println(resa.getUtilisateur().getId());

		try {
			resaBll.insert(resa);
		} catch (ReservationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		 * resaBll = new ReservationBLL(); try { resaBll.insert(resa); } catch
		 * (ReservationException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		
		
		
		request.setAttribute("restaurant", restaurant);
		request.getRequestDispatcher("/WEB-INF/jsp/reservationConfirmation.jsp").forward(request, response);
	}
}