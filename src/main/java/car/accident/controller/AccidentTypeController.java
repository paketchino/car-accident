package car.accident.controller;

import car.accident.dto.accidentType.AccidentTypeDTO;
import car.accident.model.AccidentType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import car.accident.service.AccidentTypeServiceData;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping("/accidentsTypes")
public class AccidentTypeController {

    private final AccidentTypeServiceData accidentTypeServiceData;

    @GetMapping("/formAccidentsTypes")
    public String getAccidentsType(Model model) {
        model.addAttribute("accTypes",
                accidentTypeServiceData.getAll());
        return "accidentType/formAccidentsTypes";
    }

    @GetMapping("/createAccidentType")
    public String getAddAccidentType() {
        return "accidentType/createAccidentType";
    }

    @PostMapping("/saveAccidentType")
    public String save(@Valid @ModelAttribute AccidentType accidentTypeDTO) {
        accidentTypeServiceData.save(accidentTypeDTO);
        return "redirect:/index";
    }

    @GetMapping("/formUpdateAccidentType")
    public String updateAccidentType(Model model, HttpServletRequest req) {
        String id = req.getParameter("id");
        model.addAttribute("accidentType",
                accidentTypeServiceData.findById(Integer.parseInt(id)));
        return "accidentType/formUpdateAccidentType";
    }

    @PostMapping("/changeAccidentType")
    public String update(@ModelAttribute AccidentType accidentTypeDTO) {
        accidentTypeServiceData.save(accidentTypeDTO);
        return "redirect:/index";
    }
}
