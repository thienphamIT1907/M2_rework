package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import services.ConverterService;

@Controller
public class ConvertController {

    @Autowired
    ConverterService converterService;

    @GetMapping("/")
    public String converter() {
        return "convert";
    }

    @PostMapping("/convert")
    public String converter(@RequestParam("rate") float rate, @RequestParam("usd") float usd, Model model) {
        float vnd = converterService.convertUSDToVND(usd, rate);

        model.addAttribute("rate", rate);
        model.addAttribute("usd", usd);
        model.addAttribute("vnd", vnd);
        return "result";
    }
}
