package car.accident.controller;

import car.accident.dto.accidentDTO.AccidentDTO;
import car.accident.mapper.AccidentMapper;
import car.accident.mapper.AccidentMapperImpl;
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
import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping("/supervisors")
public class SupervisorController {

    private final AccidentServiceData accidentServiceData;

    private final AccidentMapperImpl accidentMapper;


    @GetMapping("/getCompleteAccident")
    public String endAccident(Model model, HttpServletRequest req) {
        String id = req.getParameter("id");
        model.addAttribute("accident",
                accidentServiceData.findByIdAccident(Integer.parseInt(id)));
        return "supervisor/getCompleteAccident";
    }

    @PostMapping("/postCompleteItem")
    public String finishAccident(@Valid @ModelAttribute AccidentDTO accidentDTO) {
        accidentDTO.setStatus(true);
        Accident accident = accidentMapper.accidentDTOFromAccident(accidentDTO);
        accidentServiceData.completeAcc(accident);
        return "redirect:/index";
    }
}
