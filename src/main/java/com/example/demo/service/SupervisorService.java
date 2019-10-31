package com.example.demo.service;


import com.example.demo.model.Supervisor;
import com.example.demo.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



@Service
public class SupervisorService {

    List<Supervisor> supervisors = new ArrayList<>(
            Arrays.asList(
                    new Supervisor("1",
                            "Jean Franco",
                            "Rojas Quiroz",
                            "jean96rq@gmail.com",
                            "123456")

            )
    );

    public List<Supervisor> getAll(){
        return supervisors;
    }


    public void saveSupervisor(Supervisor supervisor){
        supervisors.add(supervisor);
    }

    public void deleteSupervisor(Supervisor supervisor){

       supervisors.remove(supervisor);
    }

    public void updateSupervisor(Supervisor supervisor){
        Supervisor currentSupervisor = findById(supervisor.getId());
        int index = supervisors.indexOf(currentSupervisor);
        supervisor.setId(currentSupervisor.getId());
        supervisors.set(index, supervisor);
    }

    public Supervisor findById(String id){
        Supervisor supervisor = supervisors.stream()
                .filter(s -> s.getId()
                        .equalsIgnoreCase(id))
                .findFirst()
                .orElseGet(null);
        return supervisor;
    }
}
