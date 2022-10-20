package models.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import models.JpaUtil.JpaUtil;
import models.classes.Biglietto;
import models.classes.Bus;
import models.classes.Deposito;
import models.classes.Mezzo;

public class DepositoDAO {

	public static void save(Mezzo m, Deposito d) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();

		d.setMezzo(m);
		d.setStatusMezzo(m.getStatus());

		t.begin();

		em.persist(m);

		em.persist(d);

		t.commit();

		em.close();

	}

	public static void saveDeposito(Mezzo m, Deposito d) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();

		m.toggleStatus();

		Query q = em.createQuery("UPDATE Mezzo a SET status = :s WHERE a.id = :id");

		t.begin();

		q.setParameter("s", m.getStatus());
		q.setParameter("id", m.getIdMezzo());

		q.executeUpdate();

		d.setMezzo(m);
		d.setStatusMezzo(m.getStatus());

		em.persist(d);

		t.commit();

		em.close();

	}

	public static Deposito getById(int id) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		Deposito p = em.find(Deposito.class, id);

		em.close();

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

	}

	public static void refresh(Deposito a) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		em.refresh(a);

		em.close();

	}

	public static void cercaStoricoMezzo(Mezzo m) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		Query q = em.createQuery("SELECT d FROM Deposito d WHERE d.mezzo.idMezzo = :id");

		q.setParameter("id", m.getIdMezzo());

		List<Deposito> mezzo = q.getResultList();
		for (Deposito m1 : mezzo) {
			System.out.println(m1);
		}

		em.close();

	}

}
