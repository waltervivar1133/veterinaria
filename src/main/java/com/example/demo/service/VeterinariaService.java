package com.example.demo.service;


import com.example.demo.model.Usuario;
import com.example.demo.model.Veterinaria;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class VeterinariaService {

    List<Veterinaria> veterinarias = new ArrayList<>(
            Arrays.asList(
                    new Veterinaria("1",
                            "Veteri1",
                            "Surco",
                            "jean96rq@gmail.com",
                            "9919205154")

            )
    );


    public List<Veterinaria> getAll(){
        return veterinarias;
    }

    public void saveVeterinaria(Veterinaria veterinaria){
        veterinarias.add(veterinaria);
    }

    public void deleteVeterinaria(Veterinaria veterinaria){

      veterinarias.remove(veterinaria);
    }

    public void updateVeterinaria(Veterinaria veterinaria){
       Veterinaria currentVeterinaria = findById(veterinaria.getId());
        int index = veterinarias.indexOf(currentVeterinaria);
        veterinaria.setId(currentVeterinaria.getId());
       veterinarias.set(index, veterinaria);
    }

    public Veterinaria findById(String id){
        Veterinaria veterinaria = veterinarias.stream()
                .filter(s -> s.getId()
                        .equalsIgnoreCase(id))
                .findFirst()
                .orElseGet(null);
        return veterinaria;
    }


}

