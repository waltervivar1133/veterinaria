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
    public String getVeterinariasList(Model model){
        //list

        List<Veterinaria> veterinarias = veterinariaService.getAll();
        model.addAttribute("veterinarias",veterinarias);
        model.addAttribute("veterinaria", new Veterinaria());


        return "veterinaria";
    }

    @PostMapping("/veterinaria/save")
    public String saveVeterinaria(Veterinaria veterinaria,
                              Model model){
        //save
        veterinariaService.saveVeterinaria(veterinaria);

        //list
        List<Veterinaria> veterinarias = veterinariaService.getAll();
        model.addAttribute("veterinarias",veterinarias);
        return "veterinaria";
    }
    /*
     @GetMapping("usuario/add")
        public String addUsuario(Model model){
            model.addAttribute("usuario", new Usuario());
          return "usuario";
      }
    */
    @GetMapping("/veterinaria/edit/{id}")
    public String getVeterinariaForUpdate (@PathVariable String id,
                                       Model model){

        Veterinaria currentVeterinaria = veterinariaService.findById(id);
        return "veterinaria";
    }


    @PostMapping("/veterinaria/update/{id}")
    public String updateVeterinarias(@PathVariable String id,
                                 Veterinaria veterinaria,
                                 Model model){

        //Update
        veterinariaService.updateVeterinaria(veterinaria);

        //list
        List<Veterinaria> veterinarias = veterinariaService.getAll();
        model.addAttribute("veterinarias", veterinarias);
        return "veterinaria";
    }

    @GetMapping("/veterinaria/delete/{id}")
    public String  deleteUsuario(@PathVariable String id,
                                 Model model){

       Veterinaria currentVeterinaria = veterinariaService.findById(id);

        //Delete
        veterinariaService.deleteVeterinaria(currentVeterinaria);

        //list
        List<Veterinaria> veterinarias = veterinariaService.getAll();
        model.addAttribute("veterinarias",veterinarias);

        return "redirect:/veterinaria";
    }


}