package com.emergentes.dao;

import com.emergentes.modelo.Profesor;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DocentesDAOimpl extends ConexionDB implements DocentesDAO{

    @Override
    public void insert(Profesor estudiante) throws Exception {
        String sql = "insert profesor (Id_asignatura_FK,Id_persona_FK) values (?,?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, estudiante.getId_asignatura());
        ps.setInt(2, estudiante.getId_persona());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Profesor estudiante) throws Exception {
        String sql = "update profesor set Id_asignatura_FK=?,Id_persona_FK=? where Id_profesor=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, estudiante.getId_asignatura());
        ps.setInt(2, estudiante.getId_persona());
        ps.setInt(3, estudiante.getId_profesor());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from profesor where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public Profesor getById(int id) throws Exception {
        Profesor es = new Profesor();
        String sql = "select * from profesor where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            es.setId_profesor(rs.getInt("Id_profesor"));
            es.setId_asignatura(rs.getInt("Id_asignatura_FK"));
            es.setId_persona(rs.getInt("Id_persona_FK"));
        }
        this.desconectar();
        return es;
    }

    @Override
    public List<Profesor> getAll() throws Exception {
        List<Profesor> list = null;
        String sql = "SELECT pr.*, p.CI as ci,p.Nombres as nombre,p.Apellidos as apellido,p.Fecha_nacimiento"
                + ",p.Direccion,p.Edad,p.Celular,a.Materia,c.Grado as curso from profesor pr";
        sql += " left join persona p on pr.Id_persona_FK=p.Id_persona";
        sql += " left join asignatura a on pr.Id_asignatura_FK = a.Id_asignatura";
        sql += " left join curso c on pr.Id_profesor=c.Id_profesor_FK ";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        list = new ArrayList<Profesor>();
        while (rs.next()) {            
            Profesor es = new Profesor();
            es.setId_profesor(rs.getInt("Id_profesor"));
            es.setId_asignatura(rs.getInt("Id_asignatura_FK"));
            es.setId_persona(rs.getInt("Id_persona_FK"));
            es.setCi(rs.getInt("ci"));
            es.setNombres(rs.getString("nombre"));
            es.setApellidos(rs.getString("apellido"));
            es.setFecha_nacimiento(rs.getDate("Fecha_nacimiento"));
            es.setDireccion(rs.getString("Direccion"));
            es.setEdad(rs.getInt("Edad"));
            es.setCelular(rs.getInt("Celular"));
            es.setAsignatura(rs.getString("Materia"));
            es.setCurso(rs.getString("curso"));
            list.add(es);
        }
        this.desconectar();
        return list;
    }
    
}
