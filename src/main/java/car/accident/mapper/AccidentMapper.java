package car.accident.mapper;

import car.accident.dto.accidentDTO.AccidentDTO;
import car.accident.model.Accident;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AccidentMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "rule", source = "rule")
    @Mapping(target = "accidentType", source = "accidentType")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "numberCar", source = "numberCar")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "photo", source = "photo")
    @Mapping(target = "status", source = "status")
    AccidentDTO accidentToDTO(Accident accident);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "rule", source = "rule")
    @Mapping(target = "accidentType", source = "accidentType")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "numberCar", source = "numberCar")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "photo", source = "photo")
    @Mapping(target = "status", source = "status")
    Accident accidentDTOFrom(AccidentDTO accidentDTO);
}
