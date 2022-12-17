package car.accident.controller;

import car.accident.service.UserServiceData;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import car.accident.model.User;
import car.accident.repository.UserRepository;
import car.accident.service.AuthorityServiceData;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class RegControl {

    private final PasswordEncoder passwordEncoder;

    private final UserServiceData userServiceData;
    private final AuthorityServiceData authorityServiceData;

    @GetMapping("/reg")
    public String regPage(@RequestParam(value = "error", required = false)
                              String error, Model model) {
        String errorMessage = null;
        if (error != null) {
            errorMessage = "User with this username is already registered!!";
        }
        model.addAttribute("errorMessage", errorMessage);
        return "reg";
    }

    @PostMapping("/reg")
    public String regSave(@Valid @ModelAttribute User user) {
        user.setEnabled(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setAuthority(authorityServiceData.findByAuthority("ROLE_USER"));
        userServiceData.save(user);
        return "redirect:/login";
    }

    @GetMapping("/regAdmin")
    public String regAdminPage(@RequestParam(value = "error", required = false)
                          String error, Model model) {
        String errorMessage = null;
        if (error != null) {
            errorMessage = "User with this username is already registered!!";
        }
        model.addAttribute("errorMessage", errorMessage);
        return "regAdmin";
    }

    @PostMapping("/regAdmin")
    public String regSaveAdminRule(@ModelAttribute User user) {
        user.setEnabled(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setAuthority(authorityServiceData.findByAuthority("ROLE_ADMIN"));
        userServiceData.save(user);
        return "redirect:/login";
    }

    @GetMapping("/regSupervisor")
    public String regPageSupervisor(@RequestParam(value = "error", required = false)
                          String error, Model model) {
        String errorMessage = null;
        if (error != null) {
            errorMessage = "User with this username is already registered!!";
        }
        model.addAttribute("errorMessage", errorMessage);
        return "regSupervisor";
    }

    @PostMapping("/regSupervisor")
    public String formSaveSupervisor(@ModelAttribute User user) {
        user.setEnabled(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setAuthority(authorityServiceData.findByAuthority("ROLE_SUPERVISOR"));
        userServiceData.save(user);
        return "redirect:/login";
    }
}
