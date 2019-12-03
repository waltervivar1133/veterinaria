package com.example.demo.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.demo.model.Veterinaria;
import com.example.demo.service.VeterinariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class VetResource {
    @Autowired
    private VeterinariaService VetService;

    //GET
    @GetMapping("/veterinarias")
    public ResponseEntity  getAll(){

        List<Veterinaria> veterinarias= VetService.findAll();
        if(veterinarias == null){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(veterinarias, HttpStatus.OK);
    }

    //GET BY ID
    @GetMapping("/veterinarias/{id}")
    public ResponseEntity getById(@PathVariable String id){

        Veterinaria currentVet = VetService.findById(id);
        if(currentVet == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(currentVet, HttpStatus.OK);
    }

    @PostMapping("/veterinarias")
    public ResponseEntity create(@RequestBody Veterinaria veterinaria){
        VetService.create(veterinaria);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/veterinarias/{id}")
    public ResponseEntity update(@PathVariable String id,
                                 @RequestBody Veterinaria veterinaria){

        Veterinaria currentVet = VetService.findById(id);
        if(currentVet == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        currentVet.setNombre(veterinaria.getNombre());
        currentVet.setDireccion(veterinaria.getDireccion());
        currentVet.setCorreo(veterinaria.getCorreo());
        currentVet.setDistrito(veterinaria.getDistrito());
        currentVet.setNumero(veterinaria.getNumero());

        VetService.update(currentVet);

        return new ResponseEntity(currentVet, HttpStatus.OK);
    }

    @DeleteMapping("/veterinarias/{id}")
    public ResponseEntity delete(@PathVariable String id){
        Veterinaria currentVet = VetService.findById(id);
        if(currentVet == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        VetService.delete(currentVet.getId());
        return new ResponseEntity(HttpStatus.OK);
    }
}
