package dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import bo.Reservation;

public class ReservationDAO implements DAO<Reservation> {
	private EntityManagerFactory emf;
	
	public ReservationDAO() {
		emf = Persistence.createEntityManagerFactory("user");
	}
	
	@Override
	public List<Reservation> select() {
		EntityManager em = emf.createEntityManager();
		List<Reservation> resultat = em.createQuery("from Reservation", Reservation.class).getResultList();
		em.close();
		return resultat;
	}

	@Override
	public Reservation selectById(int id) {
		EntityManager em = emf.createEntityManager();
		Reservation resultat = em.find(Reservation.class, id);
		em.close();
		return resultat;
	}

	@Override
	public void update(Reservation reservation) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.merge(reservation);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();	
	}

	@Override
	public void insert(Reservation reservation) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.persist(reservation);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();	
	}

	@Override
	public void delete(Reservation reservation) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		try {
			em.remove(em.merge(reservation));
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();	
	}

	@Override
	public Reservation deletebyId(int id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Reservation reservation = null;
		try {
			reservation = em.find(Reservation.class, id);
			if (reservation != null) {
				em.remove(reservation);
				em.getTransaction().commit();
			} else {
				em.getTransaction().rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		
		return reservation;
	}
	
}
