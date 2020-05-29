package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TranslateController {
    @GetMapping("/")
    public String showDictionary() {
        return "index";
    }

    @PostMapping("/dictionary")
    public String translate(@RequestParam("eng") String eng, Model model) {
        Map<String, String> mapDictionary = new HashMap<>();
        mapDictionary.put("hello", "xin chào");
        mapDictionary.put("cloud", "đám mây");
        mapDictionary.put("home", "ngôi nhà");

        model.addAttribute("eng", eng);

        String vie = mapDictionary.get(eng);
        model.addAttribute("vie", vie);

        return "result";
    }
}
