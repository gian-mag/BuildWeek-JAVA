package models.classes;

import lombok.*;
import models.enums.Status;

import java.util.Set;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Mezzi {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private Status status = Status.SERVIZIO;
    private Set<Biglietto> biglietti;
    
    public void toggleStatus() {
    	if(status == Status.SERVIZIO) {
    		status = Status.MANUTENZIONE;
    	} else {
    		status = Status.SERVIZIO;
    	}
    }
    
}
