package car.accident.mapper;

import car.accident.dto.accidentDTO.AccidentDTO;
import car.accident.dto.accidentType.AccidentTypeDTO;
import car.accident.model.AccidentType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface AccidentTypeMapper {

    AccidentTypeMapper INSTANCE = Mappers.getMapper(AccidentTypeMapper.class);

    AccidentTypeDTO convertToDTO(AccidentType accidentType);

    AccidentType accTypeDTOToAccType(AccidentTypeDTO accidentDTO);
}
