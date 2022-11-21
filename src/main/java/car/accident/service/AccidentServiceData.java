package car.accident.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import car.accident.model.Accident;
import car.accident.repository.AccidentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccidentServiceData {

    @Autowired
    private final AccidentRepository accidentRepository;

    @Autowired
    private final AccidentTypeServiceData accidentTypeServiceData;

    @Autowired
    private final RuleServiceData ruleServiceData;

    public void create(Accident accident, int ruleId, int typeId) {
        accident.setAccidentType(accidentTypeServiceData
                .findById(typeId).get());
        accident.setRule(ruleServiceData
                .findById(ruleId).get());
        accidentRepository.save(accident);
    }
    public void update(Accident accident, int ruleId, int typeId) {
        accident.setAccidentType(accidentTypeServiceData
                .findById(typeId).get());
        accident.setRule(ruleServiceData
                .findById(ruleId).get());
        accidentRepository.save(accident);
    }

    public List<Accident> getAll() {
        var result = new ArrayList<Accident>();
        for (var accident : accidentRepository.findAll()) {
            result.add(accident);
        }
        return result;
    }

    public Optional<Accident> findByIdAccident(int id) {
        return accidentRepository.findById(id);
    }
}
