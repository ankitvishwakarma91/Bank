package com.softworkshub.banksystem.controller;

import com.softworkshub.banksystem.entity.Customer;
import com.softworkshub.banksystem.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RegisterController {

    @Autowired
    private CustomerRepo customerRepo;

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String processRegister(
            @RequestParam("firstName") String firstName,
            @RequestParam("email") String email,
            @RequestParam("gender") String gender,
            @RequestParam("pan") String pan,
            @RequestParam("phone") String phone,
            @RequestParam("aadharNo") String aadharNo,
            @RequestParam("accountType") String accountType,
            Model model
    ) {
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setEmail(email);
        customer.setGender(gender);
        customer.setPan(pan);
        customer.setPhone(phone);
        customer.setAadharNo(aadharNo);
        customer.setAccountType(accountType);

        customerRepo.save(customer);

        model.addAttribute("message", "Registration successful for: " + firstName);
        return "subHome";
    }

    @GetMapping("/details")
    public String viewDetails(Model model) {
        List<Customer> customers = customerRepo.findAll();
        model.addAttribute("customers", customers);
        return "details"; // Renders the `details.html` template
    }
}
