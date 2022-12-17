package car.accident.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import car.accident.model.Accident;

import java.util.List;

@Repository
public interface AccidentRepository extends CrudRepository<Accident, Integer> {

    @Modifying
    @Query("update Accident as a set a.status = true where a.id =:id")
    void completeAcc(@Param("id") int id);

    @Query("from Accident")
    List<Accident> getAll();
}
