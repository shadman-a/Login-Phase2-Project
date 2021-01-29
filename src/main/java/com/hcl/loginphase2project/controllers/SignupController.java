package com.hcl.loginphase2project.controllers;

import com.hcl.loginphase2project.models.User;
import com.hcl.loginphase2project.services.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {
    @Autowired

    SignupService service;

    @GetMapping("/signup")
    public String showSignupPage(ModelMap model) {
        return "signup";
    }

    @PostMapping("/signup")
    public String postSignUp(Model model, @ModelAttribute("user") User user) {

        if(user != null && user.getName() != "" && user.getPassword() != "") {
            if(service.createUser(user)) {
                return "welcome";
            }else {
                model.addAttribute("error", "Username Taken");
                return "signup";
            }
        }else {
            model.addAttribute("error", "Missing Field");
            return "signup";
        }
    }
}
