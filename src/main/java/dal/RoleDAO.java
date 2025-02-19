package dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import bo.Role;

public class RoleDAO implements DAO<Role> {
	private EntityManagerFactory emf;
	
	public RoleDAO() {
		emf = Persistence.createEntityManagerFactory("SQLServer");
	}
	
	@Override
	public List<Role> select() {
		EntityManager em = emf.createEntityManager();
		List<Role> resultat = em.createQuery("from Role", Role.class).getResultList();
		em.close();
		return resultat;
	}

	@Override
	public Role selectById(int id) {
		EntityManager em = emf.createEntityManager();
		Role resultat = em.find(Role.class, id);
		em.close();
		return resultat;
	}

	@Override
	public void update(Role role) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.merge(role);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();	
	}

	@Override
	public void insert(Role role) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.persist(role);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();	
	}

	@Override
	public void delete(Role role) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		try {
			em.remove(em.merge(role));
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();	
	}

	@Override
	public Role deletebyId(int id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Role role = null;
		try {
			role = em.find(Role.class, id);
			if (role != null) {
				em.remove(role);
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
		
		return role;
	}
	
}
