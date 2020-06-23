package com.validateformdangki.controllers;

import com.validateformdangki.models.UserCustomValidation;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserCustomValidationController {

    @GetMapping("/create_userCustomValidation")
    public ModelAndView showRegisterPage() {
        return new ModelAndView("/user_customvalidation/register", "userCustomValidation", new UserCustomValidation());
    }

    @PostMapping("/create_userCustomValidation")
    public ModelAndView createUserCustomValidation(
            @Validated @ModelAttribute UserCustomValidation userCustomValidation,
            BindingResult bindingResult
   ) {
        new UserCustomValidation().validate(userCustomValidation, bindingResult);
        if(bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("/user_customvalidation/register");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/user_customvalidation/result");
            modelAndView.addObject("userCustomValidation", userCustomValidation);
            return modelAndView;
        }
    }
}
