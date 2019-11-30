package com.example.demo.repository;

import com.example.demo.model.Supervisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class JdbcSupervisorRepository implements SupervisorRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void create(Supervisor supervisor) {
        final String sql = "insert into supervisor(id,nombre, apellido,correo,clave  ) values (?,?,?,?,?)";
        jdbcTemplate.update(sql, supervisor.getId(), supervisor.getNombre(), supervisor.getApellido(),supervisor.getCorreo(),supervisor.getClave());

    }

    @Override
    public void update(Supervisor supervisor) {
        final String sql = "update supervisor set nombre = ?, apellido = ? , correo = ? , clave = ? where id = ?";
        jdbcTemplate.update(sql, supervisor.getNombre(), supervisor.getApellido(), supervisor.getCorreo(),supervisor.getClave(), supervisor.getId());
    }

    @Override
    public void delete(String id) {
        final String sql = "delete supervisor where id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Supervisor> findAll() {
        final String sql = "select * from supervisor";
        List<Supervisor> supervisors = jdbcTemplate.query(sql,
                JdbcSupervisorRepository::SupervisorRowMapper);
        return supervisors;
    }

    private static Supervisor SupervisorRowMapper(ResultSet resultSet, int i) throws SQLException {
        String id = resultSet.getString("id");
        String nombre = resultSet.getString("nombre");
        String apellido = resultSet.getString("apellido");
        String correo = resultSet.getString("correo");
        String clave = resultSet.getString("clave");

        return new Supervisor(id, nombre,apellido,correo,clave);
    }

    @Override
    public Supervisor findById(String id) {
        final String sql = "select * from supervisor where id = ?";
        Supervisor supervisor = jdbcTemplate.queryForObject(sql,
                new Object[]{id},
                JdbcSupervisorRepository::SupervisorRowMapper);
        return supervisor;
    }
}
