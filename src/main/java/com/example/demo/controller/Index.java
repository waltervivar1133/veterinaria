package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Index {

    @GetMapping({"/", "/administrador"})
    public String index(){
       return "administrador";
    }

}




