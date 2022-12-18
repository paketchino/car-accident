package car.accident.mapper.impl;

import car.accident.dto.accidentDTO.AccidentDTO;
import car.accident.mapper.AccidentMapper;
import car.accident.model.Accident;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class AccidentMapperImpl implements AccidentMapper {

    @Override
    public AccidentDTO accidentToDTO(Accident accident) {
        if (accident == null) {
            return null;
        }

        AccidentDTO accidentDTO = new AccidentDTO();
        accidentDTO.setId( accident.getId() );
        accidentDTO.setName( accident.getName() );
        accidentDTO.setRule( accident.getRule() );
        accidentDTO.setAccidentType( accident.getAccidentType() );
        accidentDTO.setAddress( accident.getAddress() );
        accidentDTO.setNumberCar( accident.getNumberCar() );
        accidentDTO.setDescription( accident.getDescription() );
        byte[] photo = accident.getPhoto();

        if (photo != null) {
            accidentDTO.setPhoto( Arrays.copyOf( photo, photo.length ) );
        }

        accidentDTO.setStatus(accident.isStatus());
        return accidentDTO;
    }

    @Override
    public Accident accidentDTOFrom(AccidentDTO accidentDTO) {
        if (accidentDTO == null ) {
            return null;
        }

        Accident accident = new Accident();
        accident.setId( accidentDTO.getId() );
        accident.setName( accidentDTO.getName() );
        accident.setRule( accidentDTO.getRule() );
        accident.setAccidentType( accidentDTO.getAccidentType() );
        accident.setAddress( accidentDTO.getAddress() );
        accident.setNumberCar( accidentDTO.getNumberCar() );
        accident.setDescription( accidentDTO.getDescription() );
        byte[] photo = accidentDTO.getPhoto();

        if (photo != null ) {
            accident.setPhoto( Arrays.copyOf( photo, photo.length ) );
        }
        accident.setStatus(accidentDTO.isStatus());
        return accident;
    }


}
