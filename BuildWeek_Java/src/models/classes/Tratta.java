package models.classes;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import models.enums.Zona;

@Entity
public class Tratta {
	
	@Id
	private int id;
	
	private Zona partenza;
	private Zona capolinea;
	private Date tempoMedio;
	
	public Tratta() {}

	public Tratta(Zona partenza, Zona capolinea, Date tempoMedio) {
		this.partenza = partenza;
		this.capolinea = capolinea;
		this.tempoMedio = tempoMedio;
	}

	public Zona getPartenza() {
		return partenza;
	}

	public void setPartenza(Zona partenza) {
		this.partenza = partenza;
	}

	public Zona getCapolinea() {
		return capolinea;
	}

	public void setCapolinea(Zona capolinea) {
		this.capolinea = capolinea;
	}

	public Date getTempoMedio() {
		return tempoMedio;
	}

	public void setTempoMedio(Date tempoMedio) {
		this.tempoMedio = tempoMedio;
	}

	public int getId() {
		return id;
	}
	
	

}
