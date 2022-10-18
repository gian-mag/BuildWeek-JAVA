package models.classes;

import java.util.Set;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="servizio", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Rivenditore")
public class Rivenditore {
	
	@Id
	private int id;
	
	private Set<Biglietto> bigliettiEmessi;
//	private Set<Abbonamento> abbonamentiEmessi;

}
