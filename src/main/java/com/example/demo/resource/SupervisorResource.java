package com.example.demo.resource;

import com.example.demo.model.Supervisor;
import com.example.demo.service.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SupervisorResource {

    @Autowired
    private SupervisorService supervisorService;

    //GET
    @GetMapping("/supervisors")
    public ResponseEntity getAll(){

        List<Supervisor> supervisors= supervisorService.findAll();
        if(supervisors == null){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(supervisors, HttpStatus.OK);
    }

    //GET BY ID
    @GetMapping("/supervisors/{id}")
    public ResponseEntity getById(@PathVariable String id){

        Supervisor currentSupervisor = supervisorService.findById(id);
        if(currentSupervisor == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(currentSupervisor, HttpStatus.OK);
    }

    @PostMapping("/supervisors")
    public ResponseEntity create(@RequestBody Supervisor supervisor){
        supervisorService.create(supervisor);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/supervisors/{id}")
    public ResponseEntity update(@PathVariable String id,
                                 @RequestBody Supervisor supervisor){

        Supervisor currentSupervisor = supervisorService.findById(id);
        if(currentSupervisor == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        currentSupervisor.setNombre(supervisor.getNombre());
        currentSupervisor.setApellido(supervisor.getApellido());
        currentSupervisor.setCorreo(supervisor.getCorreo());
        currentSupervisor.setId(supervisor.getId());

        supervisorService.update(currentSupervisor);

        return new ResponseEntity(currentSupervisor, HttpStatus.OK);
    }

    @DeleteMapping("/supervisors/{id}")
    public ResponseEntity delete(@PathVariable String id){
        Supervisor currentSupervisor = supervisorService.findById(id);
        if(currentSupervisor == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        supervisorService.delete(currentSupervisor.getId());
        return new ResponseEntity(HttpStatus.OK);
    }
}
