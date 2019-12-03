package com.example.demo.repository;

import com.example.demo.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcUsuarioRepository implements UsuarioRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Usuario usuario) {

        final String sql = "insert into usuario(id,nombre, apellido,correo,celular,clave  ) values (?,?,?,?,?,?)";
        jdbcTemplate.update(sql, usuario.getId(), usuario.getNombre(), usuario.getApellido(),usuario.getCorreo(),usuario.getCelular(),usuario.getClave());

    }

    @Override
    public void update(Usuario usuario) {
        final String sql = "update usuario set nombre = ?, apellido = ? , correo = ? , celular = ?, clave = ? where id = ?";
        jdbcTemplate.update(sql, usuario.getNombre(), usuario.getApellido(), usuario.getCorreo(), usuario.getCelular(),usuario.getClave(), usuario.getId());
    }

    @Override
    public void delete(String id) {
        final String sql = "delete usuario where id = ?";
        jdbcTemplate.update(sql, id);

    }

    @Override
    public List<Usuario> findAll() {
        final String sql = "select * from usuario";
        List<Usuario> usuarios = jdbcTemplate.query(sql,
                JdbcUsuarioRepository::UsuarioRowMapper);
        return usuarios;
    }


    private static Usuario UsuarioRowMapper(ResultSet resultSet, int i) throws SQLException {
        String id = resultSet.getString("id");
        String nombre = resultSet.getString("nombre");
        String apellido = resultSet.getString("apellido");
        String correo = resultSet.getString("correo");
        String celular = resultSet.getString("celular");
        String clave = resultSet.getString("clave");

        return new Usuario(id, nombre,apellido,correo,celular,clave);
    }

    @Override
    public Usuario findById(String id) {
        final String sql = "select * from usuario where id = ?";
        Usuario usuario = jdbcTemplate.queryForObject(sql,
                new Object[]{id},
                JdbcUsuarioRepository::UsuarioRowMapper);
        return usuario;
    }

    @Override
    public List<Usuario> findByDistrito(String s) {
        return null;
    }

}
