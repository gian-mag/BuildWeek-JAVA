package models.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import models.JpaUtil.JpaUtil;
import models.classes.Utente;

public class UtenteDAO {

	public static void save(Utente a) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();

		t.begin();
		em.persist(a);
		t.commit();

		em.close();
		emf.close();
	}

	public static Utente getById(int id) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		Utente p = em.find(Utente.class, id);

		em.close();
		emf.close();

		return p;
	}

	public static void delete(int id) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();

		Utente p = em.find(Utente.class, id);

		t.begin();
		em.remove(p);
		t.commit();

		em.close();
		emf.close();
	}

	public static void refresh(Utente a) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		em.refresh(a);

		em.close();
		emf.close();
	}
}
