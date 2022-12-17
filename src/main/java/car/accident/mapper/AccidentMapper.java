package car.accident.mapper;

import car.accident.dto.accidentDTO.AccidentDTO;
import car.accident.model.Accident;
import org.mapstruct.Mapper;

@Mapper
public interface AccidentMapper {

    AccidentDTO accidentToDTO(Accident accident);

    Accident accidentDTOFromAccident(AccidentDTO accidentDTO);
}
