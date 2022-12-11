package car.accident.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import car.accident.model.Rule;
import car.accident.service.RuleServiceData;

import javax.servlet.http.HttpServletRequest;

@Controller
@AllArgsConstructor
@RequestMapping("/rules")
public class RuleController {

    private final RuleServiceData ruleServiceData;

    @GetMapping("/formRules")
    public String getRules(Model model) {
        model.addAttribute("rules", ruleServiceData.findAll());
        return "rule/formRules";
    }

    @GetMapping("/createRule")
    public String getCreateRule() {
        return "rule/createRule";
    }

    @GetMapping("/updateRule")
    public String getFormUpdate(Model model, HttpServletRequest req) {
        String id = req.getParameter("id");
        model.addAttribute("rule",
                ruleServiceData.findById(Integer.parseInt(id)));
        return "rule/updateRule";
    }

    @PostMapping("/changeRule")
    public String changeRule(@ModelAttribute Rule rule) {
        ruleServiceData.save(rule);
        return "redirect:/index";
    }

    @PostMapping("/saveRule")
    public String addTopic(@ModelAttribute Rule rule) {
        ruleServiceData.save(rule);
        return "redirect:/index";
    }

}
