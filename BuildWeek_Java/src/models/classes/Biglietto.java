package models.classes;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Biglietto {

	@Id
	private int id;

	private LocalDate dataEmissione = LocalDate.now();

	private boolean vidimato = false;

}
