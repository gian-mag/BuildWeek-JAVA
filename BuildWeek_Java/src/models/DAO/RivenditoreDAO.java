package models.DAO;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import models.JpaUtil.JpaUtil;
import models.classes.Biglietto;
import models.classes.Rivenditore;

public class RivenditoreDAO {

	public static void save(Rivenditore a) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();

		t.begin();
		em.persist(a);
		t.commit();

		em.close();

	}

	public static Rivenditore getById(int id) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		Rivenditore p = em.find(Rivenditore.class, id);

		em.close();

		return p;
	}

	public static void delete(int id) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();

		Rivenditore p = em.find(Rivenditore.class, id);

		t.begin();
		em.remove(p);
		t.commit();

		em.close();

	}

	public static void refresh(Rivenditore a) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		em.refresh(a);

		em.close();

	}

}
