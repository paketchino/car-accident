package car.accident.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import car.accident.model.Rule;
import car.accident.repository.RuleRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RuleServiceData {
    private final RuleRepository ruleRepository;

    public Optional<Rule> findById(int id) {
        return ruleRepository.findById(id);
    }

    @Transactional
    public void save(Rule rule) {
        ruleRepository.save(rule);
    }

    public boolean findByIdForCheck(int id) {
        return ruleRepository.existsById(id);
    }

    @Transactional
    public void update(Rule rule) {
        ruleRepository.save(rule);
    }

    public List<Rule> findAll() {
        return ruleRepository.findAll();
    }
}
