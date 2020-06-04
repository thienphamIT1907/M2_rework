package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import services.DictionaryService;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TranslateController {

    @Autowired
    DictionaryService dictionaryService;

    @GetMapping("/")
    public String showDictionary() {
        return "index";
    }

    @PostMapping("/dictionary")
    public String translate(@RequestParam("eng") String eng, Model model) {
        model.addAttribute("eng", eng);
        String vie = dictionaryService.findWord(eng);
        model.addAttribute("vie", vie);
        return "result";
    }
}
