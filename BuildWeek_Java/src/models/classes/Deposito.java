package models.classes;

import lombok.*;
import models.enums.Status;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Deposito {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "id_mezzo")
    private Mezzi mezzo;
    @Column(name = "status_mezzo")
    private Status statusMezzo;
    private LocalDate data = LocalDate.now();
}
