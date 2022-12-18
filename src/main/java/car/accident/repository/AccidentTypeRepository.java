package car.accident.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import car.accident.model.AccidentType;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccidentTypeRepository extends CrudRepository<AccidentType, Integer> {

    @Query("from AccidentType ")
    List<AccidentType> findAll();

    @Query("from AccidentType as ac where ac.id=:id")
    Optional<AccidentType> findById(@Param("id") int id);
}
