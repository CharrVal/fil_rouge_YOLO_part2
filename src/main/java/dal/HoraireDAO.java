package dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import bo.Horaire;

public class HoraireDAO implements DAO<Horaire>  {
	private EntityManagerFactory emf;
	
	public HoraireDAO() {
		emf = Persistence.createEntityManagerFactory("SQLServer");
	}
	
	@Override
	public List<Horaire> select() {
		EntityManager em = emf.createEntityManager();
		List<Horaire> resultat = em.createQuery("from Horaire", Horaire.class).getResultList();
		em.close();
		return resultat;
	}

	@Override
	public Horaire selectById(int id) {
		EntityManager em = emf.createEntityManager();
		Horaire resultat = em.find(Horaire.class, id);
		em.close();
		return resultat;
	}

	@Override
	public void update(Horaire horaire) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.merge(horaire);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();	
	}

	@Override
	public void insert(Horaire horaire) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.persist(horaire);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();	
	}

	@Override
	public void delete(Horaire horaire) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		try {
			em.remove(em.merge(horaire));
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();		
	}

	@Override
	public Horaire deletebyId(int id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Horaire horaire = null;
		try {
			horaire = em.find(Horaire.class, id);
			if (horaire != null) {
				em.remove(horaire);
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
		
		return horaire;
	}
	
}
