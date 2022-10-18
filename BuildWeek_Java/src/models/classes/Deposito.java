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
public class Deposito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "id_mezzo")
    private Mezzo mezzo;
    @Column(name = "status_mezzo")
    private Status statusMezzo;
    private LocalDate data = LocalDate.now();
}
