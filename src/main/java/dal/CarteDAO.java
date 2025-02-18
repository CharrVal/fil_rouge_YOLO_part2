package dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import bo.Carte;

public class CarteDAO implements DAO<Carte> {
	private EntityManagerFactory emf;
	
	public CarteDAO() {
		emf = Persistence.createEntityManagerFactory("user");
	}
	
	@Override
	public List<Carte> select() {
		EntityManager em = emf.createEntityManager();
		List<Carte> resultat = em.createQuery("from Carte", Carte.class).getResultList();
		em.close();
		return resultat;
	}

	@Override
	public Carte selectById(int id) {
		EntityManager em = emf.createEntityManager();
		Carte resultat = em.find(Carte.class, id);
		em.close();
		return resultat;
	}

	@Override
	public void update(Carte carte) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.merge(carte);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();	
	}

	@Override
	public void insert(Carte carte) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.persist(carte);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();	
	}

	@Override
	public void delete(Carte carte) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		try {
			em.remove(em.merge(carte));
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();		
	}

	@Override
	public Carte deletebyId(int id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Carte carte = null;
		try {
			carte = em.find(Carte.class, id);
			if (carte != null) {
				em.remove(carte);
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
		
		return carte;
	}
	
}
