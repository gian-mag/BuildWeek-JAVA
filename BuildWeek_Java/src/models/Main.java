package models;

import java.time.LocalDate;

import models.DAO.*;
import models.classes.*;
import models.enums.*;

public class Main {

	public static void main(String[] args) {

//		salvaUtente();

//		creaBus();
//		creaTram();

//		toggleDeposito(5);

//		creaRivenditore(Zona.CENTRO);
//		creaDistributore(Zona.PARCO);

//		erogaBiglietto(1);

//		erogaTessera(1);

//		erogaAbbonamento(1, 2, Emissione.MENSILE);

//		rinnovaTessera(1);

//		nuovaTratta(Zona.CENTRO, Zona.PARCO);

//		nuovoViaggio(1, 2);

//		termineViaggio(3);

//		controlloValiditaTessera(2);

//		obliteratriceDeDios(4, 6);

		bigliettiSulMezzo(7);
		
		vidimatiPerTempo(LocalDate.of(2000, 10, 9), LocalDate.now());
		
		storicoMezzo(1);
		
		numeroViaggi(2, 1);
		
		System.out.println("------------ ABBIAMO FINITO, FLAVIO NON FACCIAMO PIU' NIENTE. CI VEDIAMO MAI --------------");
		
	}

	// SALVA UTENTE   ------ OK
	public static void salvaUtente() {

		Utente u1 = new Utente();
		u1.setNome("Gino");
		u1.setCognome("Paoli");

		Utente u2 = new Utente();
		u2.setNome("Pino");
		u2.setCognome("LaLavatrice");

		Utente u3 = new Utente();
		u3.setNome("Lava");
		u3.setCognome("Piatti");
		u3.setTessera(null);

		Utente u4 = new Utente();
		u4.setNome("Mangio");
		u4.setCognome("Mele");

		Utente u5 = new Utente();
		u5.setNome("Pony");
		u5.setCognome("Tail");

//		UtenteDAO.save(u1);
//		UtenteDAO.save(u2);
//		UtenteDAO.save(u3);
//		UtenteDAO.save(u4);
//		UtenteDAO.save(u5);

	}

	// ? mezzi   ------ OK
	static void creaBus() {
		Bus b = new Bus();

		Deposito d = new Deposito();

		DepositoDAO.save(b, d);
	}

	// salva tram  ------ OK
	static void creaTram() {
		Tram b = new Tram();

		Deposito d = new Deposito();

		DepositoDAO.save(b, d);
	}

	// storico deposito, cambia status mezzo   ------ OK
	static void toggleDeposito(int mezzoId) {

		Mezzo m = MezzoDAO.getById(mezzoId);

		Deposito d = new Deposito();

		DepositoDAO.saveDeposito(m, d);
	}

	// crea Rivenditore  ------ OK
	static void creaRivenditore(Zona ztl) {
		Rivenditore r = new Rivenditore();
		r.setZona(ztl);
		RivenditoreDAO.save(r);
	}
 
	// crea Distributore   ------ OK
	static void creaDistributore(Zona ztl) {
		Distributore d = new Distributore();
		d.setZona(ztl);
		DistributoreDAO.save(d);
	}

	// ? biglietti   ------ OK
	static void erogaBiglietto(int id) {
		Rivenditore r = RivenditoreDAO.getById(id);
		Biglietto b = new Biglietto();
		b.setRivenditore(r);
		BigliettoDAO.save(b);
	}

	// salva abbonamento
	// aggiungere controllo scadenza tessera   ------ OK
	static void erogaAbbonamento(int tesseraId, int id, Emissione em) {
		Tessera t = TesseraDAO.getById(tesseraId);
		Rivenditore r = RivenditoreDAO.getById(id);
		if (t != null) {
			Abbonamento a = new Abbonamento();
			a.setTessera(t);
			a.setRivenditore(r);
			a.setEmissione(em);
			BigliettoDAO.save(a);
		} else {
			System.out.println("Prima di richiedere l'abbonamento, fatti la tessera, pezzente! Che tanto è aggratiss");
		}
	}

	//  ------ OK
	static void compraAbbDaRivenditore(int tesseraId, int id, Emissione em) {  
		erogaAbbonamento(tesseraId, id, em);
	}

	//  ------ OK
	static void compraAbbDaDistributore(int tesseraId, int id, Emissione em) {
		if (DistributoreDAO.getById(id).getInServizio() == StatoServizio.IN_SERVIZIO) {
			erogaAbbonamento(tesseraId, id, em);
		} else {
			System.out.println("distributore non attivo");
		}

	}

	//  ------ OK
	static void compraBiglDaRivenditore(int id) {
		erogaBiglietto(id);
	}

	
	//  ------ OK
	static void compraBiglDaDistributore(int id) {
		if (DistributoreDAO.getById(id).getInServizio() == StatoServizio.IN_SERVIZIO) {
			erogaBiglietto(id);
		} else {
			System.out.println("distributore non attivo");
		}

	}

	
//	  ------ OK
	static void erogaTessera(int userId) {
		Utente u = UtenteDAO.getById(userId);
		Tessera t = new Tessera();
		t.setUtente(u);
		TesseraDAO.save(t);
	}

//	 ------ OK
	static void rinnovaTessera(int tId) {
		Tessera tess = TesseraDAO.getById(tId);
		TesseraDAO.rinnovaTessera(tess);
	}

	
	/// ---- METODI ----

	
	// salva la tratta ---- SISTEMARE IL TEMPO
	static void nuovaTratta(Zona partenza, Zona arrivo) {
		Tratta t = new Tratta();
		t.setPartenza(partenza);
		t.setCapolinea(arrivo);
		t.impostaTempoStimato();
		TrattaDAO.save(t);
	}

	// starta il viaggio  --------OK 
	static void nuovoViaggio(int idTratta, int idMezzo) {
		Mezzo m = MezzoDAO.getById(idMezzo);
		if (m.getStatus() == Status.SERVIZIO) {
			Tratta t = TrattaDAO.getById(idTratta);
			Viaggio v = new Viaggio();
			System.out.println(v.getIdViaggio());
			v.setTratta(t);
			v.setMezzo(m);
			ViaggioDAO.save(v);
		} else {
			System.out.println("Ma con cosa parti che il tuo mezzo è andato in autocombustione?");
		}

	}

	// termina il viaggio  -------------OK
	static void termineViaggio(int idViaggio) {
		Viaggio v = ViaggioDAO.getById(idViaggio);
		ViaggioDAO.termineViaggio(v);
	}

	
	
	// controllo e vidima  ----------- OK
	static boolean controlloAbbonamento(int id, int idMezzo) {
		LocalDate datascadenza = AbbonamentoDAO.getById(id).getValidità();
		if (LocalDate.now().compareTo(datascadenza) > 0) {
			return false;
		} else {
			Abbonamento a = AbbonamentoDAO.getById(id);
			Mezzo m = MezzoDAO.getById(idMezzo);
			AbbonamentoDAO.abbonamentoVidima(a, m);
			return true;
		}
	}

//	 ------ OK
	static void vidimaBiglietto(int idBiglietto, int idMezzo) {
		Biglietto b = BigliettoDAO.getById(idBiglietto);
		if (b.getVidimato() == Vidima.FALSE) {
			Mezzo m = MezzoDAO.getById(idMezzo);
			BigliettoDAO.vidimaBiglietto(b, m);
			System.out.println("buon viaggio");
		} else {
			System.out.println("sei uno scopino imbroglione");
		}
	}

//	 ------ OK
	static void obliteratriceDeDios(int idb, int idm) {
		// non so se va questo if
		if (BigliettoDAO.getById(idb) != null && BigliettoDAO.getById(idb) instanceof Abbonamento) {
			if (controlloAbbonamento(idb, idm)) {
				System.out.println("buon viaggio");
			} else {
				System.out.println("abbonamento non valido");
			}
		} else {
			vidimaBiglietto(idb, idm);
		}
	}

	// controllo tessera    ------ OK
	static boolean controlloValiditaTessera(int id) {
		Tessera t = TesseraDAO.getById(id);
		if (t != null) {
			if (t.getScadenzaTessera().compareTo(LocalDate.now()) > 0) {
				System.out.println("tessera valida");
				return true;
			} else {
				System.out.println("tessera non valida");
				return false;
			}
		} else {
			System.out.println("Tessera non esiste");
			return false;
		}

	}
	
//	 METODI 
	
//	vidimazione nel tempo -------- OK
	static void vidimatiPerTempo(LocalDate start, LocalDate end) {
		System.out.println(BigliettoDAO.vidimazioniNelTempo(start, end));
		
	}
	
	
//	vidimati nel mezzo   ------------------OK 
	static void bigliettiSulMezzo(int id) {
		System.out.println("I biglietti vidimati sul mezzo: " + id + " sono: " + BigliettoDAO.cercaVidimati(BigliettoDAO.vidimatiSulMezzo(id)));
		
	}
	
//	cerca storico nel deposito  ------------------OK
	static void storicoMezzo(int id) {
		DepositoDAO.cercaStoricoMezzo(MezzoDAO.getById(id));
	}
	
//	percorrenze (viaggoDAO) --------------OK
	static void numeroViaggi(int idMezzo, int idTratta) {
		System.out.println("Il numero di viaggi effettuati dal mezzo: " + idMezzo + ", sulla tratta: " + idTratta + ", sono: "  + ViaggioDAO.percorrenze(idMezzo, idTratta));
	}
}
