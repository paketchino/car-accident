package car.accident.model;

import lombok.*;

import javax.persistence.*;

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
    @JoinColumn(name = "rule_id")
    private Rule rule;

    @ManyToOne
    @JoinColumn(name = "accidentType_id")
    private AccidentType accidentType;

    private String address;

    private String numberCar;

    private String description;

    private byte[] photo;

    private boolean status;

}
