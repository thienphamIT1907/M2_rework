package controllers;

import models.Sanwich;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import services.SanwichService;

import java.util.Optional;

@Controller
public class SandwichController {

    @Autowired
    SanwichService sanwichService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showSandwichCondiments() {
        return "index";
    }

//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    public String sandwich(@RequestParam("condiment") String[] condimentsArr, Model model) {
//        model.addAttribute("message", "Your condiments: ");
//        model.addAttribute("condimentsArr", condimentsArr);
//        return "save";
//    }

    @PostMapping("/save")
    public String sandwich(@RequestParam(value = "condiment", required = false) Optional<String[]> condimentsArr,
                           Model model) {

        if(condimentsArr.isEmpty()) {
            model.addAttribute("message", "Nothing to cooking!");
            return "save";
        } else {
            Sanwich sw = new Sanwich();
            sw.setCondiments(condimentsArr.get());
            model.addAttribute("message", "Your sandwich is cooking with: ");
            model.addAttribute("finishSandwich", sanwichService.cookingSanwich(sw));
        }
        return "save";
    }
}
