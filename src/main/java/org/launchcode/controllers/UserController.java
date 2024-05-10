package org.launchcode.controllers;

import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("index")
    public String displayUserWelcome() {
        return "user/index";
    }

    @GetMapping("add")
    public String displayAddUserForm() {
        return "user/add";
    }

    @PostMapping("add")
    public String processAddUserForm(Model model, @ModelAttribute User user,
                                     String verify/*,
                                     String username,
                                     String email*/) {
// add form submission handling code here

        if (verify.equals(user.getPassword())) {
            return "user/index";
        } else {
            model.addAttribute("error", "Passwords did not match");
            model.addAttribute("username", /*username*/ user.getUsername()); // Didn't need the model attributes
            model.addAttribute("email", /*email*/ user.getEmail()); // Didn't need the model attributes
            return "user/add";
        }
    }
}
