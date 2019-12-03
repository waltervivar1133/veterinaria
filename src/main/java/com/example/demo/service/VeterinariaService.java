package com.example.demo.service;


import com.example.demo.model.Usuario;
import com.example.demo.model.Veterinaria;
import com.example.demo.repository.JdbcUsuarioRepository;
import com.example.demo.repository.JdbcVeterinariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class VeterinariaService implements BaseService<Veterinaria,String> {

    @Autowired
    private JdbcVeterinariaRepository jdbcVeterinariaRepository;

    @Override
    public void create(Veterinaria veterinaria) {
        jdbcVeterinariaRepository.create(veterinaria);
    }

    @Override
    public void update(Veterinaria veterinaria) {
        jdbcVeterinariaRepository.update(veterinaria);
    }

    @Override
    public void delete(String id) {
            jdbcVeterinariaRepository.delete(id);
    }

    @Override
    public List<Veterinaria> findAll() {
        return jdbcVeterinariaRepository.findAll();
    }

    @Override
    public Veterinaria findById(String id) {
        return jdbcVeterinariaRepository.findById(id);
    }




}
