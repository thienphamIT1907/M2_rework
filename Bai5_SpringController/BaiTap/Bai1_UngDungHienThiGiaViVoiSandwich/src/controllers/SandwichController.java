package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showSandwichCondiments() {
        return "index";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String sandwich(@RequestParam("condiment") String[] condimentsArr, Model model) {
        model.addAttribute("message", "Your condiments: ");
        model.addAttribute("condimentsArr", condimentsArr);
        return "save";
    }
}
