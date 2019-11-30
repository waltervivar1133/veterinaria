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
    public String getSupervisors(Model model) {
        model.addAttribute("supervisor", new Supervisor());
        model.addAttribute("supervisors", supervisorService.findAll());
        return "supervisor";
    }

    @PostMapping("/supervisor/save")
    public String saveSupervisors(Supervisor supervisor,
                                  Model model) {
        //save
        supervisorService.create(supervisor);

        //list
        List<Supervisor> supervisors = supervisorService.findAll();
        model.addAttribute("supervisors", supervisors);
        return "supervisor";
    }

   /* @GetMapping("/supervisor/add")
    public String AddSupervisor(Model model) {
        model.addAttribute("supervisor", new Supervisor());

        return "supervisor";
    }*/

    @GetMapping("/supervisor/edit/{id}")
    public String getSupervisorForUpdate(@PathVariable String id,
                                         Model model) {

        model.addAttribute("supervisor", supervisorService.findById(id));
        return "edit-supervisor";
    }

    @PostMapping("/supervisor/update/{id}")
    public String updateSupervisors(@PathVariable String id,
                                    Supervisor supervisor,
                                    Model model) {

        //Update
        supervisorService.update(supervisor);


        //list
        List<Supervisor> supervisors = supervisorService.findAll();
        model.addAttribute("supervisors", supervisors);
        return "supervisor";
    }

    @GetMapping("/supervisor/delete/{id}")
    public String deleteSupervisor(@PathVariable String id,
                                   Model model) {
        model.addAttribute("supervisor", supervisorService.findById(id));


        //Delete
        supervisorService.delete(id);

        //list
        List<Supervisor> supervisors = supervisorService.findAll();
        model.addAttribute("supervisors", supervisors);

        return "supervisor";
    }



}