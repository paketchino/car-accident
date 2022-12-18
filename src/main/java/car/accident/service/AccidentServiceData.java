package car.accident.service;

import car.accident.dto.accidentDTO.AccidentDTO;
import car.accident.mapper.impl.AccidentMapperImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import car.accident.model.Accident;
import car.accident.repository.AccidentRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccidentServiceData {

    @Autowired
    private final AccidentRepository accidentRepository;

    @Autowired
    private final AccidentTypeServiceData accidentTypeServiceData;

    @Autowired
    private final RuleServiceData ruleServiceData;

    private final AccidentMapperImpl accidentMapper;

    @Transactional
    public void create(AccidentDTO accident) {
        Accident acc = accidentMapper.accidentDTOFrom(accident);
        accidentRepository.save(acc);
    }

    @Transactional
    public void update(AccidentDTO accidentDTO, int ruleId, int typeId) {
        accidentDTO.setAccidentType(accidentTypeServiceData
                .findById(typeId).get());
        accidentDTO.setRule(ruleServiceData
                .findById(ruleId).get());
        Accident accident = accidentMapper.accidentDTOFrom(accidentDTO);
        accidentRepository.save(accident);
    }

    public List<AccidentDTO> getAll() {
        return accidentRepository
                .getAll()
                .stream()
                .map(accidentMapper::accidentToDTO)
                .collect(Collectors.toList());
    }

    public Optional<AccidentDTO> findByIdAccident(int id) {
        Accident accident = accidentRepository.findById(id).get();
        AccidentDTO accidentDTO = accidentMapper.accidentToDTO(accident);
        return Optional.ofNullable(accidentDTO);
    }

    @Transactional
    public void completeAcc(Accident accident) {
        accident.setStatus(true);
        accidentRepository.completeAcc(accident.getId());
    }
}
