package car.accident.service;

import car.accident.dto.accidentDTO.AccidentDTO;
import car.accident.mapper.AccidentMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import car.accident.model.Accident;
import car.accident.repository.AccidentRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccidentServiceData {

    @Autowired
    private final AccidentRepository accidentRepository;

    private final AccidentMapper accidentMapper;

    @Autowired
    private final AccidentTypeServiceData accidentTypeServiceData;

    @Autowired
    private final RuleServiceData ruleServiceData;

    @Transactional
    public void create(Accident accident) {
        accidentRepository.save(accident);
    }

    @Transactional
    public void update(Accident accident, int ruleId, int typeId) {
        accident.setAccidentType(accidentTypeServiceData
                .findById(typeId).get());
        accident.setRule(ruleServiceData
                .findById(ruleId).get());
        accidentRepository.save(accident);
    }

    public List<AccidentDTO> getAll() {
        return accidentRepository
                .getAll()
                .stream()
                .map(accidentMapper::accidentToDTO)
                .collect(Collectors.toList());
    }

    public Optional<Accident> findByIdAccident(int id) {
        return accidentRepository.findById(id);
    }

    @Transactional
    public void completeAcc(Accident accident) {
        accident.setStatus(true);
        accidentRepository.completeAcc(accident.getId());
    }
}
