package car.accident.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import car.accident.model.AccidentType;
import car.accident.repository.AccidentTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AccidentTypeServiceData {
    @Autowired
    private final AccidentTypeRepository accidentTypeRepository;

    public AccidentTypeServiceData(AccidentTypeRepository accidentTypeRepository) {
        this.accidentTypeRepository = accidentTypeRepository;
    }

    public void save(AccidentType accidentType) {
        accidentTypeRepository.save(accidentType);
    }

    public List<AccidentType> getAll() {
        return (List<AccidentType>) accidentTypeRepository.findAll();
    }

    public Optional<AccidentType> findById(int id) {
        return accidentTypeRepository.findById(id);
    }

}
