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

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "accidents_accident_types", joinColumns = {
            @JoinColumn(name = "accident_id", nullable = false, updatable = false)},
    inverseJoinColumns = {
            @JoinColumn(name = "accidentType_id", nullable = false, updatable = false)})
    private Set<AccidentType> accidentType;

    private String address;

    private int numberCar;

    private String description;

    private byte[] photo;

    private boolean status;

}
