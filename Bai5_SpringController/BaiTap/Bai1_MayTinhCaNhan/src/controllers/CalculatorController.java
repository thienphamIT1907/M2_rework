package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import services.CalculatorService;

@Controller
public class CalculatorController {

    @Autowired
    CalculatorService calculatorService;

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
        switch (operator) {
            case "Addition (+)":
                model.addAttribute("result", calculatorService.addition(num1, num2));
                break;
            case "Subtraction (-)":
                model.addAttribute("result", calculatorService.subtraction(num1, num2));
                break;
            case "Multiplication (*)":
                model.addAttribute("result", calculatorService.multiplication(num1, num2));
                break;
            case "Division (/)":
                model.addAttribute("result", calculatorService.division(num1, num2));
        }
        return "index";
    }
}
