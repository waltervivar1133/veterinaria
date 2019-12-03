package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Index {

    @GetMapping({"/", "/index"})
    public String admin(){
       return "index";
    }

    @GetMapping({"/administrador"})
    public String index(){
        return "administrador";
    }
@GetMapping({"/buscarVeterinaria"})
    public String buscar(){
        return "buscarVeterinaria";
    }

}




