package com.qlkh_qlt.controllers;

import com.qlkh_qlt.models.Customer;
import com.qlkh_qlt.models.Province;
import com.qlkh_qlt.service.customer.CustomerService;
import com.qlkh_qlt.service.province.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProvinceService provinceService;

    @GetMapping("/")
    public ModelAndView listCustomers(){
        return new ModelAndView("/customer/list", "customers",customerService.findAll());
    }

    @GetMapping("/create-customer")
    public ModelAndView showCreatePage() {
        return new ModelAndView("/customer/create","customer", new Customer());
    }

    @PostMapping("/create-customer")
    public String saveCustomer(Customer customer, RedirectAttributes redirect){
        customerService.save(customer);
        redirect.addFlashAttribute("message", "New customer created successfully");
        return "redirect:/";
    }

    @GetMapping("/edit-customer/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Customer customer = customerService.findById(id);
        return new ModelAndView("/customer/edit", "customer", customer);
    }

    @PostMapping("/edit-customer")
    public String updateCustomer(@ModelAttribute Customer customer, RedirectAttributes redirect){
        customerService.save(customer);
        redirect.addFlashAttribute("message", "Customer updated successfully");
        return "redirect:/";
    }

    @GetMapping("/delete-customer/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Customer customer = customerService.findById(id);
        if(customer != null) {
            ModelAndView modelAndView = new ModelAndView("/customer/delete");
            modelAndView.addObject("customer", customer);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-customer")
    public String deleteCustomer(Long id){
        customerService.remove(id);
        return "redirect:/";
    }

    @ModelAttribute("provinces")
    public Iterable<Province> provinces(){
        return provinceService.findAll();
    }
}
