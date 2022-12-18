package car.accident.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import car.accident.model.Rule;

import java.util.List;
import java.util.Optional;

@Repository
public interface RuleRepository extends CrudRepository<Rule, Integer> {

    @Query("from Rule as r where r.id=:id")
    Optional<Rule> findById(@Param("id") int id);

    @Query("from Rule")
    List<Rule> findAll();
}
