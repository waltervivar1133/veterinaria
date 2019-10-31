package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Veterinaria {


    private String id;
    private String nombre;
    private String direccion;
    private String correo;
    private String numero;
}
