package models.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import models.JpaUtil.JpaUtil;
import models.classes.Tram;

public class TramDAO {
	
	public static void save(Tram a) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();

		t.begin();
		em.persist(a);
		t.commit();

		em.close();
		emf.close();
	}

	public static Tram getById(int id) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		Tram p = em.find(Tram.class, id);

		em.close();
		emf.close();

		return p;
	}

	public static void delete(int id) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();

		Tram p = em.find(Tram.class, id);

		t.begin();
		em.remove(p);
		t.commit();

		em.close();
		emf.close();
	}

	public static void refresh(Tram a) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		em.refresh(a);

		em.close();
		emf.close();
	}

}
