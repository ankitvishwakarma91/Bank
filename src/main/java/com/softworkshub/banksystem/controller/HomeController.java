package com.softworkshub.banksystem.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping("/index")
    public String index(){
        return "index";
    }

//    @GetMapping("/sub-home")
//    public String subHome(){
//        return "subHome";
//    }
}
