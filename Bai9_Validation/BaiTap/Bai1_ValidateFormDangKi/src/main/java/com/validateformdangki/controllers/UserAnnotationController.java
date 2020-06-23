package com.validateformdangki.controllers;

import com.validateformdangki.models.UserAnnotation;
import com.validateformdangki.service.UserAnnotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Optional;


@Controller
public class UserAnnotationController {

    @Autowired
    UserAnnotationService userAnnotationService;

    @GetMapping("/")
    public String showMenu() {
        return "/common/menu";
    }

    @GetMapping("/create_userAnnotation")
    public ModelAndView showRegisterPage() {
        return new ModelAndView("/user_annotation/register", "userAnnotation", new UserAnnotation());
    }

    @PostMapping("/create_userAnnotation")
    public ModelAndView createUserAnnotation(@Validated
                                      @ModelAttribute UserAnnotation userAnnotation,
                                      BindingResult bindingResult) {

        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("/user_annotation/register");
            return modelAndView;
        } else {
            userAnnotationService.add(userAnnotation);
            ModelAndView modelAndView = new ModelAndView("/user_annotation/result");

//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//            LocalDate currentDate = userAnnotation.getBirthday();
//            userAnnotation.setBirthday(LocalDate.parse(simpleDateFormat.format(currentDate)));

            modelAndView.addObject("userAnnotation", userAnnotation);
            return modelAndView;
        }
    }

//    @GetMapping("/show_date/{id}")
//    public ModelAndView findUserAndShowDate(@PathVariable Integer id) {
//        UserAnnotation user = userAnnotationService.findById(id);
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
//        String result = dateTimeFormatter.format(user.getBirthday());
//
//        return new ModelAndView("/user_annotation/show_date", "userDate", result);
//    }
}
