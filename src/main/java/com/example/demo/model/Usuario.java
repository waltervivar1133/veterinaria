package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Usuario {
    private String id;
    private String nombres;
    private String apellidos;
    private String correo;
    private String celular;
    private String clave;




}
