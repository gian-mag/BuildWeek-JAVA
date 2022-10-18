package models.classes;

import java.util.Set;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Servizio", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Rivenditore")
public class Rivenditore {
	
	@Id
	private int id;
	
	private Set<Biglietto> bigliettiEmessi;
	private Set<Abbonamento> abbonamentiEmessi;
	
	public Rivenditore() {}

	public Set<Biglietto> getBigliettiEmessi() {
		return bigliettiEmessi;
	}

	public void setBigliettiEmessi(Set<Biglietto> bigliettiEmessi) {
		this.bigliettiEmessi = bigliettiEmessi;
	}

	public Set<Abbonamento> getAbbonamentiEmessi() {
		return abbonamentiEmessi;
	}

	public void setAbbonamentiEmessi(Set<Abbonamento> abbonamentiEmessi) {
		this.abbonamentiEmessi = abbonamentiEmessi;
	}

	public int getId() {
		return id;
	}
	
	

}
