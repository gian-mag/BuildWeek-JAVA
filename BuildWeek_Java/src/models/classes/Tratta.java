package models.classes;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private Zona partenza;
	private Zona capolinea;
	
	@Column(name = "tempo_stimato")
	private int tempoStimato;
	
//	@OneToMany(mappedBy = "tratta")
//	private Set<Viaggio> viaggio;

}