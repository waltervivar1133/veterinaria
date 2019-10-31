package com.example.demo.controller;


import com.example.demo.model.Usuario;
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
    public String getUsuariosList(Model model){
        //list

        List<Usuario> usuarios = usuarioService.getAll();
        model.addAttribute("usuarios",usuarios);
        model.addAttribute("usuario", new Usuario());


        return "usuario";
    }

    @PostMapping("/usuario/save")
    public String saveUsuario(Usuario usuario,
                              Model model){
        //save
        usuarioService.saveUsuario(usuario);

        //list
        List<Usuario> usuarios = usuarioService.getAll();
        model.addAttribute("usuarios",usuarios);
        return "usuario";
    }
/*
 @GetMapping("usuario/add")
    public String addUsuario(Model model){
        model.addAttribute("usuario", new Usuario());
      return "usuario";
  }
*/
    @GetMapping("/usuario/edit/{id}")
    public String getUsuarioForUpdate (@PathVariable String id,
                                      Model model){

        Usuario currentUsuario = usuarioService.findById(id);
       return "usuario";
   }


    @PostMapping("/usuario/update/{id}")
    public String updateUsuarios(@PathVariable String id,
                                Usuario usuario,
                                Model model){

        //Update
        usuarioService.updateUsuario(usuario);

        //list
        List<Usuario> usuarios = usuarioService.getAll();
        model.addAttribute("usuarios", usuarios);
        return "usuario";
    }

    @GetMapping("/usuario/delete/{id}")
    public String  deleteUsuario(@PathVariable String id,
                                Model model){

        Usuario currentUsuario = usuarioService.findById(id);

        //Delete
        usuarioService.deleteUsuario(currentUsuario);

        //list
        List<Usuario> usuarios = usuarioService.getAll();
        model.addAttribute("usuarios",usuarios);

        return "redirect:/usuario";
    }


}
