package car.accident.controller;

import car.accident.model.Accident;
import car.accident.service.AccidentServiceData;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@AllArgsConstructor
@RequestMapping("/supervisors")
public class SupervisorController {

    private final AccidentServiceData accidentServiceData;


    @GetMapping("/getCompleteAccident")
    public String endAccident(Model model, HttpServletRequest req) {
        String id = req.getParameter("id");
        model.addAttribute("accident",
                accidentServiceData.findByIdAccident(Integer.parseInt(id)));
        return "supervisor/getCompleteAccident";
    }

    @PostMapping("/postCompleteItem")
    public String finishAccident(@ModelAttribute Accident accident) {
        accident.setStatus(true);
        accidentServiceData.completeAcc(accident);
        return "redirect:/index";
    }
}
