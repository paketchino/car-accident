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
                               HttpServletRequest req) throws Exception {
        accident.setPhoto(file.getBytes());
        accidentService.create(accident);
        return "redirect:/index";
    }

    @GetMapping("/formUpdateAccident")
    public String updateAccident(Model model, HttpServletRequest req) {
        String id = req.getParameter("id");
        model.addAttribute("types", accidentTypeServiceData.getAll());
        model.addAttribute("rules", ruleServiceData.findAll());
        model.addAttribute("accident", accidentService.findByIdAccident(Integer.parseInt(id)));
        return "accident/formUpdateAccident";
    }

    @PostMapping("/changeAccident")
    public String changeAccident(@ModelAttribute Accident accident,
                                 @RequestParam("file") MultipartFile file,
                                 Model model,
                                 HttpServletRequest req)
            throws Exception {
        String[] ids = req.getParameterValues("rIds");
        String id = req.getParameter("id");
        String typeId = req.getParameter("type.id");
        String ruleId = req.getParameter("rule.id");
        accident.setPhoto(file.getBytes());
        model.addAttribute("accident", accidentService.findByIdAccident(Integer.parseInt(id)));
        accidentService.update(accident,
                Integer.parseInt(ruleId),
                Integer.parseInt(typeId));
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
