package com.emergentes.dao;

import com.emergentes.modelo.Estudiantes;
import com.emergentes.modelo.Persona;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAOimpl extends ConexionDB implements PersonaDAO{

    @Override
    public void insert(Persona persona) throws Exception {
        String sql = "insert into persona (CI,Nombres,Apellidos,Fecha_nacimiento,Edad,Celular,Direccion,Id_usuario_FK)"
                + " values (?,?,?,?,?,?,?,?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, persona.getCi());
        ps.setString(2, persona.getNombres());
        ps.setString(3, persona.getApellidos());
        ps.setDate(4, persona.getFecha_nacimiento());
        ps.setInt(5, persona.getEdad());
        ps.setInt(6, persona.getCelular());
        ps.setString(7, persona.getDireccion());
        ps.setInt(8, persona.getId_usuario());
        
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Persona persona) throws Exception {
        String sql = "update persona set CI=?,Nombres=?,Apellidos=?,Fecha_nacimiento=?,Edad=?,Celular=?,Direccion=?,Id_usuario_FK=?"
                + " where Id_persona=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, persona.getCi());
        ps.setString(2, persona.getNombres());
        ps.setString(3, persona.getApellidos());
        ps.setDate(4, persona.getFecha_nacimiento());
        ps.setInt(5, persona.getEdad());
        ps.setInt(6, persona.getCelular());
        ps.setString(7, persona.getDireccion());
        ps.setInt(8, persona.getId_usuario());
        ps.setInt(9, persona.getId_persona());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from persona where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public Persona getById(int id) throws Exception {
        Persona per = new Persona();
        String sql = "select * from persona where Id_persona = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            per.setId_persona(rs.getInt("Id_persona"));
            per.setCi(rs.getInt("CI"));
            per.setNombres(rs.getString("Nombres"));
            per.setApellidos(rs.getString("Apellidos"));
            per.setFecha_nacimiento(rs.getDate("Fecha_nacimiento"));
            per.setEdad(rs.getInt("Edad"));
            per.setCelular(rs.getInt("Celular"));
            per.setDireccion(rs.getString("Direccion"));
            per.setId_usuario(rs.getInt("Id_usuario_FK"));
        }
        this.desconectar();
        return per;
    }

    @Override
    public List<Persona> getAll() throws Exception {
        List<Persona> list = null;
        String sql = "SELECT p.* from persona p ";
        sql +="inner join alumno a on p.Id_persona = a.Id_persona_FK";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        list = new ArrayList<Persona>();
        while (rs.next()) {            
            Persona per = new Persona();
            per.setId_persona(rs.getInt("Id_persona"));
            per.setCi(rs.getInt("CI"));
            per.setNombres(rs.getString("Nombres"));
            per.setApellidos(rs.getString("Apellidos"));
            per.setFecha_nacimiento(rs.getDate("Fecha_nacimiento"));
            per.setEdad(rs.getInt("Edad"));
            per.setCelular(rs.getInt("Celular"));
            per.setDireccion(rs.getString("Direccion"));
            per.setId_usuario(rs.getInt("Id_usuario_FK"));
            list.add(per);
        }
        this.desconectar();
        return list;
    }

    @Override
    public void buscar(int i) throws Exception {
    }
    
}
