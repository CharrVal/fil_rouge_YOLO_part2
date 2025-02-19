package dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import bo.Plat;

public class PlatDAO implements DAO<Plat> {
	private EntityManagerFactory emf;
	
	public PlatDAO() {
		emf = Persistence.createEntityManagerFactory("SQLServer");
	}
	
	@Override
	public List<Plat> select() {
		EntityManager em = emf.createEntityManager();
		List<Plat> resultat = em.createQuery("from Plat", Plat.class).getResultList();
		em.close();
		return resultat;
	}

	@Override
	public Plat selectById(int id) {
		EntityManager em = emf.createEntityManager();
		Plat resultat = em.find(Plat.class, id);
		em.close();
		return resultat;
	}

	@Override
	public void update(Plat plat) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.merge(plat);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();	
	}

	@Override
	public void insert(Plat plat) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.persist(plat);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();	
	}

	@Override
	public void delete(Plat plat) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		try {
			em.remove(em.merge(plat));
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();		
	}

	@Override
	public Plat deletebyId(int id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Plat plat = null;
		try {
			plat = em.find(Plat.class, id);
			if (plat != null) {
				em.remove(plat);
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
		
		return plat;
	}
	
}
