package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Supervisor {
    private String id;
    private String nombres;
    private String apellidos;
    private String correo;
    private String clave;
}



