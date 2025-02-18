package dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import bo.Restaurant;

public class RestaurantDAO implements DAO<Restaurant> {
	private EntityManagerFactory emf;
	
	public RestaurantDAO() {
		emf = Persistence.createEntityManagerFactory("user");
	}
	
	@Override
	public List<Restaurant> select() {
		EntityManager em = emf.createEntityManager();
		List<Restaurant> resultat = em.createQuery("from Restaurant", Restaurant.class).getResultList();
		em.close();
		return resultat;
	}

	@Override
	public Restaurant selectById(int id) {
		EntityManager em = emf.createEntityManager();
		Restaurant resultat = em.find(Restaurant.class, id);
		em.close();
		return resultat;
	}

	@Override
	public void update(Restaurant restaurant) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.merge(restaurant);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();	
	}

	@Override
	public void insert(Restaurant restaurant) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.persist(restaurant);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();	
	}

	@Override
	public void delete(Restaurant restaurant) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		try {
			em.remove(em.merge(restaurant));
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();	
	}

	@Override
	public Restaurant deletebyId(int id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Restaurant restaurant = null;
		try {
			restaurant = em.find(Restaurant.class, id);
			if (restaurant != null) {
				em.remove(restaurant);
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
		
		return restaurant;
	}
	
}
