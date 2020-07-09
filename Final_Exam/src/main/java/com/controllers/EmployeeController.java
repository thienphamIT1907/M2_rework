package com.controllers;

import com.models.Employee;
import com.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/list")
    public String showListEmployee(@RequestParam Optional<String> keyword, Model model) {
        Iterable<Employee> listEmployee;
        if (keyword.isPresent()) {
            listEmployee = employeeService.findAllByBirthdayContainingOrCmndContaining(
                    keyword.get(),
                    keyword.get()
            );
        } else {
            listEmployee = employeeService.findAll();
        }
        model.addAttribute("listEmployee", listEmployee);
        return "/employee/list";
    }

    @GetMapping("/save")
    public ModelAndView showSavePage() {
        return new ModelAndView("/employee/save", "employee", new Employee());
    }

    @PostMapping("/save")
    public String createEmployee(
            RedirectAttributes redirectAttributes,
            @Validated @ModelAttribute Employee employee,
            BindingResult bindingResult
    ) {
        new Employee().validate(employee, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "employee/save";
        } else {
            employeeService.save(employee);
            System.out.println(employee);
            redirectAttributes.addFlashAttribute("message", "Create new Employee success !");
            return "redirect:/list";
        }
    }



    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        employeeService.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Delete employee success !");
        return "redirect:/list";
    }
}
