package com.example.demo.controller;


import com.example.demo.model.Usuario;
import com.example.demo.repository.JdbcUsuarioRepository;
import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;


    @GetMapping("/usuario")
    public String getUsuarios(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarios", usuarioService.findAll());
        return "usuario";
    }

    @PostMapping("/usuario/save")
    public String saveUsuarios(Usuario usuario,
                              Model model) {
        //save
        usuarioService.create(usuario);

        //list
        List<Usuario> usuarios = usuarioService.findAll();
        model.addAttribute("usuarios", usuarios);
        return "usuario";
    }

   /* @GetMapping("/usuario/add")
    public String AddUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());

        return "usuario";
    }*/

    @GetMapping("/usuario/edit/{id}")
    public String getUsuarioForUpdate(@PathVariable String id,
                                      Model model) {

        model.addAttribute("usuario", usuarioService.findById(id));
        return "edit-usuario";
    }

    @PostMapping("/usuario/update/{id}")
    public String updateUsuarios(@PathVariable String id,
                                 Usuario usuario,
                                 Model model) {

        //Update
        usuarioService.update(usuario);


        //list
        List<Usuario> usuarios = usuarioService.findAll();
        model.addAttribute("usuarios", usuarios);
        return "usuario";
    }

    @GetMapping("/usuario/delete/{id}")
    public String deleteUsuario(@PathVariable String id,
                                Model model) {
        model.addAttribute("usuario", usuarioService.findById(id));


        //Delete
        usuarioService.delete(id);

        //list
        List<Usuario> usuarios = usuarioService.findAll();
        model.addAttribute("usuarios", usuarios);

        return "usuario";
    }

}