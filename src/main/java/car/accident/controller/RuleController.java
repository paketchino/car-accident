package car.accident.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import car.accident.model.Rule;
import car.accident.service.RuleServiceData;

@Controller
@AllArgsConstructor
@RequestMapping("/rules")
public class RuleController {

    private final RuleServiceData ruleServiceData;

    @GetMapping("/createRule")
    public String getCreateRule() {
        return "rule/createRule";
    }

    @GetMapping("/updateRule")
    public String getFormUpdate(@RequestParam("id") int id, Model model) {
        model.addAttribute("rule", ruleServiceData.findById(id));
        return "rule/updateRule";
    }

    @PostMapping("/saveRule")
    public String updateTopic(@ModelAttribute Rule rule) {
        ruleServiceData.save(rule);
        return "redirect:/index";
    }

}
