package models.classes;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import models.enums.Emissione;

@Entity
public class Abbonamento extends Biglietto {

	@Id
	private int id;

	@Enumerated(EnumType.STRING)
	private Emissione emissione;

	private Utente utente;

	private LocalDate dataEmissione = LocalDate.now();

	private boolean validità = true;

	public Abbonamento() {
	}

	public Abbonamento(Emissione emissione, LocalDate dataEmissione, boolean validità) {
		this.emissione = emissione;
		this.dataEmissione = dataEmissione;
		this.validità = validità;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Emissione getEmissione() {
		return emissione;
	}

	public void setEmissione(Emissione emissione) {
		this.emissione = emissione;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public LocalDate getDataEmissione() {
		return dataEmissione;
	}

	public void setDataEmissione(LocalDate dataEmissione) {
		this.dataEmissione = dataEmissione;
	}

}
