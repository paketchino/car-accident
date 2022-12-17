package car.accident.mapper;

import car.accident.dto.accidentDTO.AccidentDTO;
import car.accident.model.Accident;
import org.springframework.stereotype.Component;

@Component
public class AccidentMapperImpl implements AccidentMapper {

    @Override
    public AccidentDTO accidentToDTO(Accident accident) {
        AccidentDTO accidentDTO = new AccidentDTO();
        accidentDTO.setId(accident.getId());
        accidentDTO.setName(accident.getName());
        accidentDTO.setRule(accident.getRule());
        accidentDTO.setAccidentType(accident.getAccidentType());
        accidentDTO.setAddress(accident.getAddress());
        accidentDTO.setNumberCar(accident.getNumberCar());
        accidentDTO.setDescription(accident.getDescription());
        accidentDTO.setPhoto(accident.getPhoto());
        accidentDTO.setStatus(accident.isStatus());
        return accidentDTO;
    }

    @Override
    public Accident accidentDTOFromAccident(AccidentDTO accidentDTO) {
        Accident accident = new Accident();
        accident.setId(accidentDTO.getId());
        accident.setName(accidentDTO.getName());
        accident.setAddress(accidentDTO.getAddress());
        accident.setNumberCar(accidentDTO.getNumberCar());
        accident.setDescription(accidentDTO.getDescription());
        accident.setPhoto(accidentDTO.getPhoto());
        accident.setStatus(accidentDTO.isStatus());
        accident.setAccidentType(accidentDTO.getAccidentType());
        accident.setRule(accidentDTO.getRule());
        accident.setPhoto(accidentDTO.getPhoto());
        return accident;
    }
}
