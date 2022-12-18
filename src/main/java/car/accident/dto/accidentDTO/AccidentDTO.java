package car.accident.dto.accidentDTO;

import car.accident.model.AccidentType;
import car.accident.model.Rule;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccidentDTO {

    private int id;

    private String name;

    private Rule rule;

    private AccidentType accidentType;

    private String address;

    private String numberCar;

    private String description;

    private byte[] photo;

    private boolean status;
}
