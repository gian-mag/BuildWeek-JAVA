package models.classes;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Bus extends Mezzi {
	@Column(name = "numero_posti")
	private int numeroPosti = 30;
}