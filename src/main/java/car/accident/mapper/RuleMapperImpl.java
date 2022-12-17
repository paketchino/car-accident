package car.accident.mapper;

import car.accident.dto.rule.RuleDTO;
import car.accident.model.Rule;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RuleMapperImpl implements RuleMapper {

    @Override
    public RuleDTO ruleToDTO(Rule rule) {
        RuleDTO ruleDTO = new RuleDTO();
        ruleDTO.setId(rule.getId());
        ruleDTO.setName(rule.getName());
        return ruleDTO;
    }

    @Override
    public Rule ruleDTOToRule(RuleDTO ruleDTO) {
        Rule rule = new Rule();
        rule.setId(ruleDTO.getId());
        rule.setName(ruleDTO.getName());
        return rule;
    }

}
