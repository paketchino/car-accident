package car.accident.mapper;

import car.accident.dto.accidentType.AccidentTypeDTO;
import car.accident.model.AccidentType;
import org.springframework.stereotype.Component;

@Component
public class AccidentTypeMapperImpl implements AccidentTypeMapper {
    @Override
    public AccidentTypeDTO convertToDTO(AccidentType accidentType) {
        AccidentTypeDTO accidentTypeDTO = new AccidentTypeDTO();
        accidentTypeDTO.setId(accidentType.getId());
        accidentTypeDTO.setName(accidentType.getName());
        return accidentTypeDTO;
    }

    @Override
    public AccidentType accTypeDTOToAccType(AccidentTypeDTO accidentDTO) {
        AccidentType accidentType = new AccidentType();
        accidentType.setId(accidentDTO.getId());
        accidentType.setName(accidentDTO.getName());
        return accidentType;
    }

}
