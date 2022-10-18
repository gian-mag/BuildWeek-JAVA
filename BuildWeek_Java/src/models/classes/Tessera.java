package models.classes;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tessera {

	@Id
	private int id;
	
	private Utente utente;
	
	private LocalDate emissioneTessera = LocalDate.now();
	
	private LocalDate scadenzaTessera = LocalDate.now().plusYears(1);
	
	public Tessera() {}

	public Tessera(Utente utente, LocalDate emissioneTessera, LocalDate scadenzaTessera) {
		this.utente = utente;
		this.emissioneTessera = emissioneTessera;
		this.scadenzaTessera = scadenzaTessera;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public LocalDate getEmissioneTessera() {
		return emissioneTessera;
	}

	public void setEmissioneTessera(LocalDate emissioneTessera) {
		this.emissioneTessera = emissioneTessera;
	}

	public LocalDate getScadenzaTessera() {
		return scadenzaTessera;
	}

	public void setScadenzaTessera(LocalDate scadenzaTessera) {
		this.scadenzaTessera = scadenzaTessera;
	}
	
}
