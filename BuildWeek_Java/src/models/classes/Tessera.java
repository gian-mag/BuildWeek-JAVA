package models.classes;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

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
public class Tessera {

	@Id
	private int id;
	
	private Utente utente;
	
	private LocalDate emissioneTessera = LocalDate.now();
	
	private LocalDate scadenzaTessera = LocalDate.now().plusYears(1);
	
	public void rinnovaTessera() {
		if( LocalDate.now().compareTo(scadenzaTessera) < 0 ) {
			scadenzaTessera = scadenzaTessera.plusYears(1);
		} else {
			scadenzaTessera = LocalDate.now().plusYears(1);
		}
	}
	
}
