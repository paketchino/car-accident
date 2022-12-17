package car.accident.mapper;

import car.accident.dto.rule.RuleDTO;
import car.accident.model.Rule;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface RuleMapper {

     RuleMapper INSTANCE = Mappers.getMapper(RuleMapper.class);

     RuleDTO ruleToDTO(Rule rule);

     Rule ruleDTOToRule(RuleDTO ruleDTO);

}
