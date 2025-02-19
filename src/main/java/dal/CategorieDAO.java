package dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import bo.Categorie;

public class CategorieDAO implements DAO<Categorie> {
	private EntityManagerFactory emf;
	
	public CategorieDAO() {
		emf = Persistence.createEntityManagerFactory("SQLServer");
	}
	
	@Override
	public List<Categorie> select() {
		EntityManager em = emf.createEntityManager();
		List<Categorie> resultat = em.createQuery("from Categorie", Categorie.class).getResultList();
		em.close();
		return resultat;
	}

	@Override
	public Categorie selectById(int id) {
		EntityManager em = emf.createEntityManager();
		Categorie resultat = em.find(Categorie.class, id);
		em.close();
		return resultat;
	}

	@Override
	public void update(Categorie categorie) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.merge(categorie);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();	
	}

	@Override
	public void insert(Categorie categorie) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.persist(categorie);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();		
	}

	@Override
	public void delete(Categorie categorie) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		try {
			em.remove(em.merge(categorie));
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();	
	}

	@Override
	public Categorie deletebyId(int id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Categorie categorie = null;
		try {
			categorie = em.find(Categorie.class, id);
			if (categorie != null) {
				em.remove(categorie);
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
		
		return categorie;
	}

}
