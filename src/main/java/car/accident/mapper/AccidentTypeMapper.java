package car.accident.mapper;

import car.accident.dto.accidentType.AccidentTypeDTO;
import car.accident.model.AccidentType;
import org.mapstruct.Mapper;

@Mapper
public interface AccidentTypeMapper {

    AccidentTypeDTO accidentTypeToTDO(AccidentType accidentType);
}
