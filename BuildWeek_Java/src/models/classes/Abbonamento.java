package models.classes;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import models.enums.Emissione;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Abbonamento extends Biglietto {

	@Id
	private int id;

	@Enumerated(EnumType.STRING)
	private Emissione emissione;

	private Utente utente;

	private LocalDate dataEmissione = LocalDate.now();

	private LocalDate validità = (emissione == Emissione.SETTIMANALE ? LocalDate.now().plusDays(7) : LocalDate.now().plusMonths(1));

}
