package models.classes;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import models.enums.Zona;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Tratta {
	
	@Id
	private int id;
	
	private Zona partenza;
	private Zona capolinea;
	private int tempoMedio;
	
	private Set<Mezzi> mezzi; 

}
