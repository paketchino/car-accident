package car.accident.mapper.impl;

import car.accident.dto.rule.RuleDTO;
import car.accident.mapper.RuleMapper;
import car.accident.model.Rule;
import org.springframework.stereotype.Component;

@Component
public class RuleMapperImpl implements RuleMapper {

    @Override
    public RuleDTO ruleToDTO(Rule rule) {
        if (rule == null) {
            return null;
        }
        RuleDTO ruleDTO = new RuleDTO();
        ruleDTO.setId(rule.getId());
        ruleDTO.setName(rule.getName());
        return ruleDTO;
    }
}
