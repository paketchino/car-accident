package car.accident.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import car.accident.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
