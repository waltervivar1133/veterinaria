package com.example.demo.repository;

import com.example.demo.model.Usuario;
import com.example.demo.model.Veterinaria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class JdbcVeterinariaRepository implements VeterinariaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Veterinaria veterinaria) {
        final String sql = "insert into veterinaria(id,nombre, distrito,direccion,correo,numero  ) values (?,?,?,?,?,?)";
        jdbcTemplate.update(sql, veterinaria.getId(), veterinaria.getNombre(), veterinaria.getDistrito(),veterinaria.getDireccion(),veterinaria.getCorreo(),veterinaria.getNumero());

    }

    @Override
    public void update(Veterinaria veterinaria) {

        final String sql = "update veterinaria set nombre = ?, distrito = ?,direccion = ? , correo = ? , numero = ? where id = ?";
        jdbcTemplate.update(sql, veterinaria.getNombre(), veterinaria.getDistrito(),veterinaria.getDireccion(), veterinaria.getCorreo(),veterinaria.getNumero(),veterinaria.getId());

    }

    @Override
    public void delete(String id) {
        final String sql = "delete veterinaria where id = ?";
        jdbcTemplate.update(sql, id);


    }

    @Override
    public List<Veterinaria> findAll() {
        final String sql = "select * from veterinaria";
        List<Veterinaria> veterinarias  = jdbcTemplate.query(sql,
                JdbcVeterinariaRepository::VeterinariaRowMapper);
        return veterinarias;
    }
    private static Veterinaria VeterinariaRowMapper(ResultSet resultSet, int i) throws SQLException {
        String id = resultSet.getString("id");
        String nombre = resultSet.getString("nombre");
        String distrito = resultSet.getString("distrito");
        String direccion=   resultSet.getString("direccion");
        String correo = resultSet.getString("correo");
        String numero = resultSet.getString("numero");


        return new Veterinaria(id, nombre,distrito,direccion,correo,numero);
    }


    @Override
    public Veterinaria findById(String id) {
        final String sql = "select * from veterinaria where id = ?";
        Veterinaria veterinaria = jdbcTemplate.queryForObject(sql,
                new Object[]{id},
                JdbcVeterinariaRepository::VeterinariaRowMapper);
        return veterinaria;
    }
    @Override
    public List<Veterinaria> findByDistrito(String distrito) {
        final String sql = "select * from veterinaria where distrito=?";
        List<Veterinaria> veterinarias  = jdbcTemplate.query(sql,
                new Object[]{distrito},
                JdbcVeterinariaRepository::VeterinariaRowMapper);
        return veterinarias;
    }
}
