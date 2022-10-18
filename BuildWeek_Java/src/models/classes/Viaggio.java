package models.classes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "id")
	@Column(name = "mezzo_id")
	private Mezzo mezzo;
	
	@ManyToOne
	@JoinColumn(name = "id")
	@Column(name = "tratta_id")
	private Tratta tratta;
	
	@Column(name="orario_partenza" )
	private LocalDate orarioPartenza;
	
	@Column(name="orario_arrivo" )
	private LocalDate orarioArrivo;
	
	

}
