package car.accident.service;

import car.accident.dto.accidentType.AccidentTypeDTO;
import car.accident.mapper.AccidentTypeMapperImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import car.accident.model.AccidentType;
import car.accident.repository.AccidentTypeRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccidentTypeServiceData {
    private final AccidentTypeRepository accidentTypeRepository;

    private final AccidentTypeMapperImpl accidentTypeMapperImpl;

    @Transactional
    public void save(AccidentType accidentType) {
        accidentTypeRepository.save(accidentType);
    }

    public List<AccidentTypeDTO> getAll() {
        return accidentTypeRepository.findAll()
                .stream()
                .map(accidentTypeMapperImpl::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<AccidentType> findById(int id) {
      return accidentTypeRepository.findById(id);
    }

}
