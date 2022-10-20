package models.DAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import models.JpaUtil.JpaUtil;
import models.classes.Biglietto;
import models.classes.Bus;
import models.classes.Mezzo;
import models.classes.Rivenditore;
import models.enums.Vidima;

public class BigliettoDAO {

	public static void save(Biglietto a) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();

		t.begin();
		em.persist(a);
		t.commit();

		em.close();

	}

	public static Biglietto getById(int id) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		Biglietto p = em.find(Biglietto.class, id);

		em.close();

		return p;
	}

	public static void delete(int id) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();

		Biglietto p = em.find(Biglietto.class, id);

		t.begin();
		em.remove(p);
		t.commit();

		em.close();

	}

	public static void refresh(Biglietto a) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		em.refresh(a);

		em.close();

	}

	public static void numeroTicketPerRangeTempo(LocalDate start, LocalDate end) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		// start e and sono istanze di LocalDate.of(int year, int month, int dayOfMonth)
		Query q = em
				.createQuery("SELECT b FROM Biglietto b WHERE b.dataEmissione >= :start AND b.dataEmissione <= :end");

		q.setParameter("start", start);
		q.setParameter("end", end);

		List<Biglietto> r = q.getResultList();
		for (Biglietto b : r) {
			System.out.println(b);
		}

		em.close();

	}

	public static void numeroTicketPerEmittente(Rivenditore r) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		Query q = em.createQuery("SELECT b FROM Biglietto b WHERE b.rivenditore.id = :id ");

		q.setParameter("id", r.getId());

		List<Biglietto> b = q.getResultList();
		for (Biglietto bigl : b) {
			System.out.println(bigl);
		}

		em.close();

	}

	public static void vidimaBiglietto(Biglietto b, Mezzo m) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();

		b.setVidimato(Vidima.TRUE);
		Set<Mezzo> mezzi = new HashSet<>();
		mezzi.add(m);
		b.setMezzo(mezzi);
		b.setDataVidimazione(LocalDate.now());

		Query q = em.createQuery(
				"UPDATE Biglietto b SET vidimato = :s, dataVidimazione = :k WHERE b.idBiglietto = :id");
		
		Query query = em.createNativeQuery(
				"INSERT INTO mezzo_biglietto (mezzo_id_mezzo, biglietti_idbiglietto) VALUES (:d, :b)"
				);

		t.begin();
		
		q.setParameter("s", b.getVidimato());	
		q.setParameter("id", b.getIdBiglietto());
		q.setParameter("k", b.getDataVidimazione());

		query.setParameter("d", m.getIdMezzo());
		query.setParameter("b", b.getIdBiglietto());
		
		q.executeUpdate();
		query.executeUpdate();
		t.commit();

		em.close();

	}

	public static List<Integer> vidimatiSulMezzo(int idMezzo) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		
//		Mezzo m = em.find(Mezzo.class, idMezzo);
		
		Query q = em.createNativeQuery(
				"SELECT biglietti_idbiglietto FROM mezzo_biglietto WHERE mezzo_id_mezzo = :id"
				);
		
		q.setParameter("id", idMezzo);
		
		List<Integer> list = q.getResultList();
		
		em.close();
		
		return list;
	}
	
	public static int cercaVidimati(List<Integer> listId) {
		
		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		Query q = em.createQuery(
				"SELECT b FROM Biglietto b WHERE b.vidimato = :v");

		q.setParameter("v", Vidima.TRUE);

		List<Biglietto> lists = q.getResultList();
		
		int counter = 0;
		
		
		for(int i = 0; i < listId.size(); i++) {
			for(int j = 0; j < lists.size(); j++) {
				if(lists.get(j).getIdBiglietto() == listId.get(i) ) {
					counter ++;
				}
			}
			
		}

		em.close();
		return counter;
	}

	public static int vidimazioniNelTempo(LocalDate start, LocalDate end) {

		EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();

		Query q = em.createQuery(
				"SELECT b FROM Biglietto b WHERE b.dataVidimazione >= :start AND b.dataVidimazione <= :end",
				Biglietto.class);

		q.setParameter("start", start);
		q.setParameter("end", end);

		List<Biglietto> list = q.getResultList();

		em.close();
		return list.size();
	}

}
