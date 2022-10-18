package models.classes;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Biglietto {

	@Id
	private int id;

	private LocalDate dataEmissione = LocalDate.now();

	private boolean vidimato = false;

	public Biglietto() {
	}

	public Biglietto(LocalDate dataEmissione, boolean vidimato) {
		this.dataEmissione = dataEmissione;
		this.vidimato = vidimato;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDataEmissione() {
		return dataEmissione;
	}

	public void setDataEmissione(LocalDate dataEmissione) {
		this.dataEmissione = dataEmissione;
	}

	public boolean isVidimato() {
		return vidimato;
	}

	public void setVidimato(boolean vidimato) {
		this.vidimato = vidimato;
	}

}
