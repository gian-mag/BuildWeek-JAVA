package models.classes;

import javax.persistence.DiscriminatorValue;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import models.enums.StatoServizio;

@DiscriminatorValue("Distributore")
public class Distributore extends Rivenditore{

	@Enumerated(EnumType.STRING)
	private StatoServizio inServizio;
	
	public Distributore() {}

	public StatoServizio isInServizio() {
		return inServizio;
	}

	public void setInServizio(StatoServizio inServizio) {
		this.inServizio = inServizio;
	}
	
	
	
}
