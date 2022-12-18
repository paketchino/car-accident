package car.accident.mapper.impl;

import car.accident.dto.accidentType.AccidentTypeDTO;
import car.accident.mapper.AccidentTypeMapper;
import car.accident.model.AccidentType;
import org.springframework.stereotype.Component;

@Component
public class AccidentTypeMapperImpl implements AccidentTypeMapper {

    @Override
    public AccidentTypeDTO accidentTypeToTDO(AccidentType accidentType) {
        if (accidentType == null) {
            return null;
        }
        AccidentTypeDTO accidentTypeDTO = new AccidentTypeDTO();
        accidentTypeDTO.setId(accidentType.getId());
        accidentTypeDTO.setName(accidentType.getName());
        return accidentTypeDTO;
    }
}
