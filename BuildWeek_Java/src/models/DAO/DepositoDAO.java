package models.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import models.JpaUtil.JpaUtil;
import models.classes.Deposito;

public class DepositoDAO {
	
	public static void save(Deposito a) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();

		t.begin();
		em.persist(a);
		t.commit();

		em.close();
		emf.close();
	}

	public static Deposito getById(int id) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		Deposito p = em.find(Deposito.class, id);

		em.close();
		emf.close();

		return p;
	}

	public static void delete(int id) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();

		Deposito p = em.find(Deposito.class, id);

		t.begin();
		em.remove(p);
		t.commit();

		em.close();
		emf.close();
	}

	public static void refresh(Deposito a) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		em.refresh(a);

		em.close();
		emf.close();
	}

}
