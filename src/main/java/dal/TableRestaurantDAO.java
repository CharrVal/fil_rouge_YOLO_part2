package dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import bo.TableRestaurant;

public class TableRestaurantDAO implements DAO<TableRestaurant> {
	private EntityManagerFactory emf;
	
	public TableRestaurantDAO() {
		emf = Persistence.createEntityManagerFactory("user");
	}
	
	@Override
	public List<TableRestaurant> select() {
		EntityManager em = emf.createEntityManager();
		List<TableRestaurant> resultat = em.createQuery("from TableRestaurant", TableRestaurant.class).getResultList();
		em.close();
		return resultat;
	}

	@Override
	public TableRestaurant selectById(int id) {
		EntityManager em = emf.createEntityManager();
		TableRestaurant resultat = em.find(TableRestaurant.class, id);
		em.close();
		return resultat;
	}

	@Override
	public void update(TableRestaurant tableRestaurant) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.merge(tableRestaurant);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();	
	}

	@Override
	public void insert(TableRestaurant tableRestaurant) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.persist(tableRestaurant);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();	
	}

	@Override
	public void delete(TableRestaurant tableRestaurant) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		try {
			em.remove(em.merge(tableRestaurant));
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();	
	}

	@Override
	public TableRestaurant deletebyId(int id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		TableRestaurant tableRestaurant = null;
		try {
			tableRestaurant = em.find(TableRestaurant.class, id);
			if (tableRestaurant != null) {
				em.remove(tableRestaurant);
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
		
		return tableRestaurant;
	}
	
}
