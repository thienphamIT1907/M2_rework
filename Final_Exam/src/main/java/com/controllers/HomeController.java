package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String showHomePage() {
        return "home";
    }
//
//    @GetMapping("/create")
//    public String showCreatePage() {
//        return "/example/save";
//    }
//
//    @GetMapping("/edit")
//    public String showEditPage() {
//        return "/example/edit";
//    }
//
//    @GetMapping("/list")
//    public String showListPage() {
//        return "/example/list";
//    }
//
//    @GetMapping("/menu")
//    public String showMenuPage() {
//        return "menu";
//    }
}
