package car.accident.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "accidents")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Accident {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    private Rule rule;

    @ManyToOne
    private AccidentType accidentType;

    private String address;

    private int numberCar;

    private String description;

    private byte[] photo;

    private boolean status;

}
