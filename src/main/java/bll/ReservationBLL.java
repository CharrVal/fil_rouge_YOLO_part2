package bll;

import java.time.LocalDateTime;
import java.util.List;

import Exception.ReservationException;
import bo.Reservation;
import dal.ReservationDAO;

public class ReservationBLL {
	private ReservationDAO dao;
	// private HoraireDAO horairedao = new HoraireDAO();
	
	public List<Reservation> select() {
		dao = new ReservationDAO();
		return dao.select();
	}
	
	public Reservation selectById(int id) {
		dao = new ReservationDAO();
		return dao.selectById(id);
	}
	
	public void insert(Reservation Reservation) throws ReservationException {
		verifier(Reservation);
		dao = new ReservationDAO();
		dao.insert(Reservation);
	}

	public void delete(Reservation Reservation) {
		dao = new ReservationDAO();
		dao.delete(Reservation);
	}

	public void update(Reservation Reservation) throws ReservationException {
		verifier(Reservation);
		dao = new ReservationDAO();
		dao.update(Reservation);
	}
	
	private void verifier(Reservation reservation) throws ReservationException{
		ReservationException exception = new ReservationException();
		if (reservation.getHoraireReservation().isBefore(LocalDateTime.now())) {
			exception.ajouterErreur("Impossible d'enregistrer cette réservation, la date est incorrecte ! Veuillez recommencer");
		}
		/* TENTATIVE DE COMPARAISON DES HORAIRES EN BASE VS LA SAISIE UTILISATEUR
		Horaire horaire = horairedao.selectById(....); --> Problème avec le SELECT....
	    if (horaire == null) {
	        exception.ajouterErreur("Aucune information sur les horaires pour ce jour !");
	    } else {
	        LocalDateTime heureOuverture = horaire.getOuverture();
	        LocalDateTime heureFermeture = horaire.getFermeture();

	        if (reservation.getHoraireReservation().isBefore(heureOuverture) || reservation.getHoraireReservation().isAfter(heureFermeture) ) {
	            exception.ajouterErreur("La réservation est en dehors des horaires d'ouverture !");
	        }
	    }
		 */
	    if (!exception.getMessages().isEmpty()) {
	        throw exception;
	    }
	}
	
}
