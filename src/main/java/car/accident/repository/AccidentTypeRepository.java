package car.accident.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import car.accident.model.AccidentType;

@Repository
public interface AccidentTypeRepository extends CrudRepository<AccidentType, Integer> {
}
