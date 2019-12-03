package com.example.demo.resource;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioResource {

    @Autowired
    private UsuarioService UsuarioService;

    //GET
    @GetMapping("/usuarios")
    public ResponseEntity getAll(){

        List<Usuario> usuarios= UsuarioService.findAll();
        if(usuarios == null){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(usuarios, HttpStatus.OK);
    }

    //GET BY ID
    @GetMapping("/usuarios/{id}")
    public ResponseEntity getById(@PathVariable String id){

        Usuario currentVet = UsuarioService.findById(id);
        if(currentVet == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(currentVet, HttpStatus.OK);
    }

    @PostMapping("/usuarios")
    public ResponseEntity create(@RequestBody Usuario veterinaria){
        UsuarioService.create(veterinaria);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity update(@PathVariable String id,
                                 @RequestBody Usuario usuario){

        Usuario currentUsuario = UsuarioService.findById(id);
        if(currentUsuario == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        currentUsuario.setNombre(usuario.getNombre());
        currentUsuario.setApellido(usuario.getApellido());
        currentUsuario.setCorreo(usuario.getCorreo());
        currentUsuario.setId(usuario.getId());

        UsuarioService.update(currentUsuario);

        return new ResponseEntity(currentUsuario, HttpStatus.OK);
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity delete(@PathVariable String id){
        Usuario currentUsuario = UsuarioService.findById(id);
        if(currentUsuario == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        UsuarioService.delete(currentUsuario.getId());
        return new ResponseEntity(HttpStatus.OK);
    }
}
