package com.example.demo.controller;

import com.example.demo.model.Supervisor;
import com.example.demo.model.Usuario;
import com.example.demo.service.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SupervisorController {

    @Autowired
    SupervisorService supervisorService;

    @GetMapping("/supervisor")
    public String getSupervisorList(Model model){
        //list

        List<Supervisor> supervisors = supervisorService.getAll();
        model.addAttribute("supervisors",supervisors);
        model.addAttribute("supervisor", new Supervisor());


        return "supervisor";
    }

    @PostMapping("/supervisor/save")
    public String saveSupervisor(Supervisor supervisor,
                              Model model){
        //save
        supervisorService.saveSupervisor(supervisor);

        //list
        List<Supervisor> supervisors = supervisorService.getAll();
        model.addAttribute("supervisors",supervisors);
        return "supervisor";
    }
    /*
     @GetMapping("usuario/add")
        public String addUsuario(Model model){
            model.addAttribute("usuario", new Usuario());
          return "usuario";
      }
    */
    @GetMapping("/supervisor/edit/{id}")
    public String getSupervisorForUpdate (@PathVariable String id,
                                       Model model){

       Supervisor currentSupervisor = supervisorService.findById(id);
        return "supervisor";
    }


    @PostMapping("/supervisor/update/{id}")
    public String updateSupervisor(@PathVariable String id,
                                 Supervisor supervisor,
                                 Model model){

        //Update
        supervisorService.updateSupervisor(supervisor);

        //list
        List<Supervisor> supervisors = supervisorService.getAll();
        model.addAttribute("supervisors",supervisors);
        return "usuario";
    }

    @GetMapping("/supervisor/delete/{id}")
    public String  deleteSupervisor(@PathVariable String id,
                                 Model model){

       Supervisor currentSupervisor = supervisorService.findById(id);

        //Delete
        supervisorService.deleteSupervisor(currentSupervisor);

        //list
        List<Supervisor> supervisors = supervisorService.getAll();
        model.addAttribute("supervisors",supervisors);

        return "redirect:/supervisor";
    }


}
