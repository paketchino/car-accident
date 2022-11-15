package car.accident.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import car.accident.model.Accident;

@Repository
public interface AccidentRepository extends CrudRepository<Accident, Integer> {
}
