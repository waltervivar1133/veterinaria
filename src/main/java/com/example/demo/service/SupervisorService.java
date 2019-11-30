package com.example.demo.service;


import com.example.demo.model.Supervisor;
import com.example.demo.model.Usuario;
import com.example.demo.repository.JdbcSupervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



@Service
public class SupervisorService implements BaseService<Supervisor,String> {

    @Autowired
    private JdbcSupervisorRepository  jdbcSupervisorRepository;
    @Override
    public void create(Supervisor supervisor) {
        jdbcSupervisorRepository.create(supervisor);

    }

    @Override
    public void update(Supervisor supervisor) {
        jdbcSupervisorRepository.update(supervisor);
    }

    @Override
    public void delete(String id) {
        jdbcSupervisorRepository.delete(id);
    }

    @Override
    public List<Supervisor> findAll() {
        return jdbcSupervisorRepository.findAll();
    }

    @Override
    public Supervisor findById(String id) {
        return jdbcSupervisorRepository.findById(id);
    }
}
