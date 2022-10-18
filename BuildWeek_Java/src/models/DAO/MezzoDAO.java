package models.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import models.JpaUtil.JpaUtil;
import models.classes.Mezzo;
import models.enums.Status;

public class MezzoDAO {

	public static void save(Mezzo a) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();

		t.begin();
		em.persist(a);
		t.commit();

		em.close();
		emf.close();
	}

	public static Mezzo getById(int id) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		Mezzo p = em.find(Mezzo.class, id);

		em.close();
		emf.close();

		return p;
	}

	public static void delete(int id) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();

		Mezzo p = em.find(Mezzo.class, id);

		t.begin();
		em.remove(p);
		t.commit();

		em.close();
		emf.close();
	}

	public static void refresh(Mezzo a) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		em.refresh(a);

		em.close();
		emf.close();
	}
	
	public static void toggle(Mezzo a) {
		
		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		a.toggleStatus();
		
		Query q = em.createQuery(
				"UPDATE Mezzo a SET status = :s WHERE a.id = :id"
				);
		
		t.begin();	
		
		q.setParameter("s", a.getStatus());
		q.setParameter("id", a.getId());
		
		q.executeUpdate();
		t.commit();
		
		em.close();
		emf.close();
	
	}
	
}
