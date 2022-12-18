package car.accident.mapper;

import car.accident.dto.rule.RuleDTO;
import car.accident.model.Rule;
import org.mapstruct.Mapper;

@Mapper
public interface RuleMapper {

    RuleDTO ruleToDTO(Rule rule);
}
