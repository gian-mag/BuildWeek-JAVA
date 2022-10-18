package models;

import lombok.*;
import models.classes.Mezzi;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Bus extends Mezzi {
    @Column(name = "numero_posti")
    int numeroPosti = 30;
}