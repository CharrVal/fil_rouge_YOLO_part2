package dal;

import java.util.List;

import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import bo.Utilisateur;

public class UtilisateurDAO implements DAO<Utilisateur>{
	private EntityManagerFactory emf;
	
	public UtilisateurDAO() {
		emf = Persistence.createEntityManagerFactory("SQLServer");
	}
	
	@Override
	public List<Utilisateur> select() {
		EntityManager em = emf.createEntityManager();
		List<Utilisateur> resultat = em.createQuery("from Utilisateur", Utilisateur.class).getResultList();
		em.close();
		return resultat;
	}

	@Override
	public Utilisateur selectById(int id) {
		EntityManager em = emf.createEntityManager();
		Utilisateur resultat = em.find(Utilisateur.class, id);
		em.close();
		return resultat;
	}
	
	

	@Override
	public void update(Utilisateur utilisateur) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.merge(utilisateur);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();	
	}

	@Override
	public void insert(Utilisateur utilisateur) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			em.persist(utilisateur);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();		
	}

	@Override
	public void delete(Utilisateur utilisateur) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		try {
			em.remove(em.merge(utilisateur));
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();	
	}

	@Override
	public Utilisateur deletebyId(int id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Utilisateur utilisateur = null;
		try {
			utilisateur = em.find(Utilisateur.class, id);
			if (utilisateur != null) {
				em.remove(utilisateur);
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
		
		return utilisateur;
	}
	
	public Utilisateur connecterUtilisateur(String login, String password) throws NamingException {
	    EntityManager em = emf.createEntityManager();
	    Utilisateur utilisateur = null;

	    try {
	        utilisateur = em.createQuery("SELECT u FROM Utilisateur u WHERE u.login = :login AND u.password = :password", Utilisateur.class)
	                        .setParameter("login", login)
	                        .setParameter("password", password)
	                        .getSingleResult();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        em.close();
	    }

	    return utilisateur;
	}
	
	public boolean utilisateurValide(Utilisateur utilisateur) {
	    EntityManager em = emf.createEntityManager();
	    
	    try {
	        Utilisateur existingUtilisateur = selectById(utilisateur.getId());

	        if (existingUtilisateur != null) {
	            if (existingUtilisateur.getPassword().equals(utilisateur.getPassword())) {
	                return true;
	            }
	        }
	        return false;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    } finally {
	        em.close();
	    }
		
	}
	
	
	public boolean utilisateurExiste(Utilisateur utilisateur) {
	    EntityManager em = emf.createEntityManager();
	    
	    try {
	        // Query the database for the user by login
	        String query = "SELECT u FROM Utilisateur u WHERE u.login = :login";
	        Utilisateur existingUtilisateur = em.createQuery(query, Utilisateur.class)
	                                             .setParameter("login", utilisateur.getLogin())
	                                             .getResultStream()
	                                             .findFirst()
	                                             .orElse(null);
	        
	        // If a user with the login exists, check the password
	        if (existingUtilisateur != null) {
	            if (existingUtilisateur.getPassword().equals(utilisateur.getPassword())) {
	                return true;
	            }
	        }
	        return false;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    } finally {
	        em.close();
	    }
	}

}
