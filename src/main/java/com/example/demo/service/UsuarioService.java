package com.example.demo.service;


import com.example.demo.model.Usuario;
import com.example.demo.repository.JdbcUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class UsuarioService implements BaseService<Usuario,String> {

    @Autowired
    private JdbcUsuarioRepository jdbcUsuarioRepository;


    @Override
    public void create(Usuario usuario) {
        jdbcUsuarioRepository.create(usuario);
    }

    @Override
    public void update(Usuario usuario) {
        jdbcUsuarioRepository.update(usuario);
    }

    @Override
    public void delete(String id) {
        jdbcUsuarioRepository.delete(id);
    }

    @Override
    public List<Usuario> findAll() {
        return jdbcUsuarioRepository.findAll();
    }

    @Override
    public Usuario findById(String id) {
        return jdbcUsuarioRepository.findById(id);
    }
}
