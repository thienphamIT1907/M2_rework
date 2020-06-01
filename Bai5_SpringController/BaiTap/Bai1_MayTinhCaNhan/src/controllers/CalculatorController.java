package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String calculator() {
        return "index";
    }

    @RequestMapping(value = "/calculate", method = RequestMethod.POST)
    public String calculate(
            @RequestParam("num1") float num1,
            @RequestParam("num2") float num2,
            @RequestParam("operator") String operator,
            Model model
    ) {
        float result;
        switch (operator) {
            case "Addition (+)":
                result = num1 + num2;
                model.addAttribute("result", result);
                break;
            case "Subtraction (-)":
                result = num1 - num2;
                model.addAttribute("result", result);
                break;
            case "Multiplication (*)":
                result = num1 * num2;
                model.addAttribute("result", result);
                break;
            case "Division (/)":
                result = num1 / num2;
                if(result == 0) {
                    model.addAttribute("result", "Cannot division 0 !");
                } else {
                    model.addAttribute("result", result);
                }
                break;
        }
        return "index";
    }

}
