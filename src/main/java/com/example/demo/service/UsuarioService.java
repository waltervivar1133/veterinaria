package com.example.demo.service;


import com.example.demo.model.Usuario;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class UsuarioService {

    List<Usuario> usuarios = new ArrayList<>(
            Arrays.asList(
                    new Usuario("1",
                            "Jean Franco",
                            "Rojas Quiroz",
                            "jean96rq@gmail.com",
                            "123456",
                            "9919205154"),
                     new Usuario("2",
                                         "Jean ",
                                         "Rojas ",
                                         "jeasn96rq@gmail.com",
                                         "123456",
                                         "9919205154")

            )

    );


    public List<Usuario> getAll(){
        return usuarios;
    }


    public void saveUsuario(Usuario usuario){
        usuarios.add(usuario);
    }

    public void deleteUsuario(Usuario usuario){

        usuarios.remove(usuario);
    }

    public void updateUsuario(Usuario usuario){
        Usuario currentUsuario = findById(usuario.getId());
        int index = usuarios.indexOf(currentUsuario);
        usuario.setId(currentUsuario.getId());
        usuarios.set(index, usuario);
    }

    public Usuario findById(String id){
        Usuario usuario = usuarios.stream()
                .filter(s -> s.getId()
                        .equalsIgnoreCase(id))
                .findFirst()
                .orElseGet(null);
        return usuario;
    }


}
