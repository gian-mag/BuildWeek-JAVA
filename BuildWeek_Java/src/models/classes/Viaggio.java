package models.classes;

import java.time.LocalDate;

import javax.persistence.Column;
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
public class Viaggio {
	
	@Id
	private int id;
	
	private Mezzi mezzo;
	private Tratta tratta;
	
	@Column(name="durata_tragitto" )
	private LocalDate durataTragitto;

}
