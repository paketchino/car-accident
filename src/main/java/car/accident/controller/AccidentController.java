package car.accident.controller;

import car.accident.model.AccidentType;
import car.accident.model.Rule;
import car.accident.service.AuthorityServiceData;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import car.accident.model.Accident;
import car.accident.model.Authority;
import car.accident.repository.AuthorityRepository;
import car.accident.service.AccidentServiceData;
import car.accident.service.AccidentTypeServiceData;
import car.accident.service.RuleServiceData;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

@Controller
@AllArgsConstructor
@RequestMapping("/accidents")
public class AccidentController {
    private final AccidentServiceData accidentService;
    private final AuthorityServiceData authorityServiceData;

    private final RuleServiceData ruleServiceData;

    private final AccidentTypeServiceData accidentTypeServiceData;

    @GetMapping("/createAccident")
    public String addAccident(Model model) {
        model.addAttribute("types", accidentTypeServiceData.getAll());
        model.addAttribute("rules", ruleServiceData.findAll());
        return "accident/createAccident";
    }

   @PostMapping("/saveAccident")
    public String saveAccident(@ModelAttribute Accident accident,
                               @RequestParam("file") MultipartFile file,
                               @RequestParam("type.id") int typeId,
                               @RequestParam("rule.id") int ruleId,
                               HttpServletRequest req) throws Exception {
        String[] ids = req.getParameterValues("rIds");
        accident.setPhoto(file.getBytes());
        accident.setStatus(false);
        accidentService.create(accident, typeId, ruleId);
        return "redirect:/index";
    }

    @GetMapping("/formUpdateAccident")
    public String updateAccident(@RequestParam("id") int id, Model model) {
        model.addAttribute("types", accidentTypeServiceData.getAll());
        model.addAttribute("rules", ruleServiceData.findAll());
        model.addAttribute("accident", accidentService.findByIdAccident(id));
        return "accident/formUpdateAccident";
    }

    @PostMapping("/changeAccident")
    public String changeAccident(@ModelAttribute Accident accident,
                                 @RequestParam("id") int id,
                                 @RequestParam("type.id") int typeId,
                                 @RequestParam("rule.id") int ruleId,
                                 @RequestParam("file") MultipartFile file,
                                 Model model,
                                 HttpServletRequest req)
            throws Exception {
        String[] ids = req.getParameterValues("rIds");
        accident.setPhoto(file.getBytes());
        accident.setRule(ruleServiceData.findById(ruleId).get());
        accident.setAccidentType(accidentTypeServiceData.findById(typeId).get());
        model.addAttribute("accident", accidentService.findByIdAccident(id));
        accidentService.update(accident);
        return "redirect:/index";
    }

    @GetMapping("/createAuthority")
    public String createAuthority() {
        return "createAuthority";
    }

    @PostMapping("/saveAuthority")
    public String saveAuthority(@ModelAttribute Authority authority) {
        authorityServiceData.save(authority);
        return "redirect:/index";
    }
}
