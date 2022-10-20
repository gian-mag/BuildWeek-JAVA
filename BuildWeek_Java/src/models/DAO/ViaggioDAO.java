package models.DAO;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

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

	}

	public static Viaggio getById(int id) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		Viaggio p = em.find(Viaggio.class, id);

		em.close();

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

	}

	public static void refresh(Viaggio a) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		em.refresh(a);

		em.close();

	}

	public static void termineViaggio(Viaggio a) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();

		a.setOrarioArrivo(LocalDateTime.now());

		Query q = em.createQuery("UPDATE Viaggio a SET orarioArrivo = :s WHERE a.id = :id");

		t.begin();

		q.setParameter("s", a.getOrarioArrivo());
		q.setParameter("id", a.getIdViaggio());

		q.executeUpdate();
		t.commit();

		em.close();

	}

	public static int percorrenze(int idMezzo, int idTratta) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		Query q = em.createQuery("SELECT v FROM Viaggio v WHERE v.mezzo.idMezzo = :m AND v.tratta.id = :t",
				Viaggio.class);
		q.setParameter("m", idMezzo);
		q.setParameter("t", idTratta);

		List<Viaggio> list = q.getResultList();

		em.close();
		return list.size();

	}

}
