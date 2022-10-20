package models.DAO;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import models.JpaUtil.JpaUtil;
import models.classes.Abbonamento;
import models.classes.Biglietto;
import models.classes.Mezzo;

public class AbbonamentoDAO {

	public static void save(Abbonamento a) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();

		t.begin();
		em.persist(a);
		t.commit();

		em.close();

	}

	public static Abbonamento getById(int id) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		Abbonamento p = em.find(Abbonamento.class, id);

		em.close();

		return p;
	}

	public static void delete(int id) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();

		Abbonamento p = em.find(Abbonamento.class, id);

		t.begin();
		em.remove(p);
		t.commit();

		em.close();

	}

	public static void refresh(Abbonamento a) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		em.refresh(a);

		em.close();

	}

	public static void abbonamentoVidima(Biglietto b, Mezzo m) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();

		Set<Mezzo> mezzi = new HashSet<>();
		mezzi.add(m);
		b.setMezzo(mezzi);

		Query query = em.createNativeQuery(
				"INSERT INTO mezzo_biglietto (mezzo_id_mezzo, biglietti_idbiglietto) VALUES (:d, :b)"
				);

		t.begin();

		query.setParameter("d", m.getIdMezzo());
		query.setParameter("b", b.getIdBiglietto());

		query.executeUpdate();
		t.commit();

		em.close();

	}

}
