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
public abstract class Tram extends Mezzi{
    @Column(name = "numero_posti")
    int numeroPosti = 50;
}