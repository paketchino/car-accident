package car.accident.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import car.accident.model.AccidentType;
import car.accident.service.AccidentTypeServiceData;

@Controller
@AllArgsConstructor
@RequestMapping("/accidentsTypes")
public class AccidentTypeController {

    private final AccidentTypeServiceData accidentTypeServiceData;

    @GetMapping("/createAccidentType")
    public String getAddAccidentType() {
        return "accidentType/createAccidentType";
    }

    @PostMapping("/saveAccidentType")
    public String save(AccidentType accidentType) {
        accidentTypeServiceData.create(accidentType);
        return "redirect:/index";
    }

}
