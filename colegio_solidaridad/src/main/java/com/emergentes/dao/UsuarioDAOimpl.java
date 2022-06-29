package com.emergentes.dao;

import com.emergentes.modelo.Usuario;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOimpl extends ConexionDB implements UsuarioDAO{

    @Override
    public void insert(Usuario estudiante) throws Exception {
        String sql = "insert usuario (Nombres,Nombre_usuario,Contrasena,rol) values (?,?,?,?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, estudiante.getNombres());
        ps.setString(2, estudiante.getUsuario());
        ps.setString(3, estudiante.getContraseña());
        ps.setString(4, estudiante.getRol());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Usuario estudiante) throws Exception {
        String sql = "update usuario set Nombres=?,Nombre_usuario=?,Contrasena=?,rol=? where Id_usuario=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, estudiante.getNombres());
        ps.setString(2, estudiante.getUsuario());
        ps.setString(3, estudiante.getContraseña());
        ps.setString(4, estudiante.getRol());
        ps.setInt(5, estudiante.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from usuario where Id_usuario = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public Usuario getById(int id) throws Exception {
        Usuario es = new Usuario();
        String sql = "select * from usuario where Id_usuario = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            es.setId(rs.getInt("Id_usuario"));
            es.setNombres(rs.getString("Nombres"));
            es.setUsuario(rs.getString("Nombre_usuario"));
            es.setContraseña(rs.getString("Contrasena"));
            es.setRol(rs.getString("rol"));
        }
        this.desconectar();
        return es;
    }

    @Override
    public List<Usuario> getAll() throws Exception {
        List<Usuario> list = null;
        String sql = "select * from usuario";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        list = new ArrayList<Usuario>();
        while (rs.next()) {            
            Usuario es = new Usuario();
            es.setId(rs.getInt("Id_usuario"));
            es.setNombres(rs.getString("Nombres"));
            es.setUsuario(rs.getString("Nombre_usuario"));
            es.setContraseña(rs.getString("Contrasena"));
            es.setRol(rs.getString("rol"));
            list.add(es);
        }
        this.desconectar();
        return list;
    }

    
}
