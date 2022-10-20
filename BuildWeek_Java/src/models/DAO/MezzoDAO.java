package models.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import models.JpaUtil.JpaUtil;
import models.classes.Mezzo;
import models.enums.Status;

public class MezzoDAO {

//	public static void save(Mezzo a) {
//
//		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction t = em.getTransaction();
//
//		t.begin();
//		em.persist(a);
//		t.commit();
//
//		em.close();
//		
//	}

	public static Mezzo getById(int id) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		Mezzo p = em.find(Mezzo.class, id);

		em.close();
		
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
		
	}

	public static void refresh(Mezzo a) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		em.refresh(a);

		em.close();

	}

	public static List<Mezzo> getActive(Status s) {

        EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        Query q = em.createQuery("SELECT m FROM Mezzo m WHERE m.status = :s", Mezzo.class);
        q.setParameter("s", s);

        em.close();
        return q.getResultList();

    }
	
}
