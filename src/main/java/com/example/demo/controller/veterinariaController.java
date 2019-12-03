package com.example.demo.controller;


import com.example.demo.model.Usuario;
import com.example.demo.model.Veterinaria;
import com.example.demo.service.VeterinariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class veterinariaController {

    @Autowired
    VeterinariaService veterinariaService;


    @GetMapping("/veterinaria")
    public String getVeterinarias(Model model) {
        model.addAttribute("veterinaria", new Veterinaria());
        model.addAttribute("veterinarias", veterinariaService.findAll());
        return "veterinaria";
    }
    @GetMapping("/veterinaria/buscarVeterinaria/{distrito}")
    public String getVeterinariasPorDistrito(@PathVariable String distrito,
                                             Model model) {

        model.addAttribute("veterinarias", veterinariaService.findByDistrito(distrito));
        return "veterinaria";
    }

    @PostMapping("/veterinaria/save")
    public String saveEmploye(Veterinaria veterinaria,
                              Model model) {
        //save
        veterinariaService.create(veterinaria);

        //list
        List<Veterinaria> veterinarias = veterinariaService.findAll();
        model.addAttribute("veterinarias", veterinarias);
        return "veterinaria";
    }

   /* @GetMapping("/veterinaria/add")
    public String AddEmploye(Model model) {
        model.addAttribute("veterinaria", new Veterinaria());

        return "add-veterinaria";
    }*/

    @GetMapping("/veterinaria/edit/{id}")
    public String getVeterinariaForUpdate(@PathVariable String id,
                                          Model model) {

        model.addAttribute("veterinaria", veterinariaService.findById(id));
        return "edit-veterinaria";
    }

    @PostMapping("/veterinaria/update/{id}")
    public String updateUsuarios(@PathVariable String id,
                                 Veterinaria veterinaria,
                                 Model model) {

        //Update
        veterinariaService.update(veterinaria);


        //list
        List<Veterinaria> veterinarias = veterinariaService.findAll();
        model.addAttribute("veterinarias", veterinarias);
        return "veterinaria";
    }

    @GetMapping("/veterinaria/delete/{id}")
    public String deleteVeterinaria(@PathVariable String id,
                                    Model model) {
        model.addAttribute("veterinaria", veterinariaService.findById(id));


        //Delete
        veterinariaService.delete(id);

        //list
        List<Veterinaria> veterinarias = veterinariaService.findAll();
        model.addAttribute("veterinarias", veterinarias);

        return "veterinaria";
    }



}