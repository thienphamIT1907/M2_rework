package com.controllers;

import com.models.Customer;
import com.models.Province;
import com.service.customer.CustomerService;
import com.service.province.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;


@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProvinceService provinceService;

    @GetMapping("/")
    public String listCustomers(
            @PageableDefault(size = 2) Pageable pageable,
            @RequestParam Optional<String> keyword,
            Model model
    ) {
        Page<Customer> customerPage;
        if (keyword.isPresent()) {
            customerPage = customerService.findAllByFirstNameContaining(keyword.get(), pageable);
            model.addAttribute("keyword", keyword.get());
        } else {
            customerPage = customerService.findAll(pageable);
        }
        model.addAttribute("customers",customerPage);
        return "/customer/list";
    }

    @GetMapping("/create-customer")
    public ModelAndView showCreatePage() {
        return new ModelAndView("/customer/create", "customer", new Customer());
    }

    @PostMapping("/create-customer")
    public String saveCustomer(Customer customer, RedirectAttributes redirect) {
        customerService.save(customer);
        redirect.addFlashAttribute("message", "New customer created successfully");
        return "redirect:/";
    }

    @GetMapping("/edit-customer/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Customer customer = customerService.findById(id);
        return new ModelAndView("/customer/edit", "customer", customer);
    }

    @PostMapping("/edit-customer")
    public String updateCustomer(@ModelAttribute Customer customer, RedirectAttributes redirect) {
        customerService.save(customer);
        redirect.addFlashAttribute("message", "Customer updated successfully");
        return "redirect:/";
    }

    @GetMapping("/delete-customer/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Customer customer = customerService.findById(id);
        if (customer != null) {
            ModelAndView modelAndView = new ModelAndView("/customer/delete");
            modelAndView.addObject("customer", customer);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-customer")
    public String deleteCustomer(Long id) {
        customerService.remove(id);
        return "redirect:/";
    }

    @ModelAttribute("provinces")
    public Iterable<Province> provinces() {
        return provinceService.findAll();
    }
}
