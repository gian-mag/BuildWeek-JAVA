package models.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import models.JpaUtil.JpaUtil;
import models.classes.Viaggio;

public class ViaggioDAO {

	public static void save(Viaggio a) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();

		t.begin();
		em.persist(a);
		t.commit();

		em.close();
		emf.close();
	}

	public static Viaggio getById(int id) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		Viaggio p = em.find(Viaggio.class, id);

		em.close();
		emf.close();

		return p;
	}

	public static void delete(int id) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();

		Viaggio p = em.find(Viaggio.class, id);

		t.begin();
		em.remove(p);
		t.commit();

		em.close();
		emf.close();
	}

	public static void refresh(Viaggio a) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		em.refresh(a);

		em.close();
		emf.close();
	}
}
