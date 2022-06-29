package com.emergentes.dao;

import com.emergentes.modelo.Asignatura;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AsignaturaDAOimpl extends ConexionDB implements AsignaturaDAO{

    @Override
    public void insert(Asignatura estudiante) throws Exception {
        String sql = "insert asignatura (Materia) values (?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, estudiante.getMateria());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Asignatura estudiante) throws Exception {
        String sql = "update asignatura set Materia=? where Id_asignatura=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, estudiante.getMateria());
        ps.setInt(2, estudiante.getId_asignatura());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from asignatura where Id_asignatura = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public Asignatura getById(int id) throws Exception {
        Asignatura es = new Asignatura();
        String sql = "select * from asignatura where Id_asignatura = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            es.setId_asignatura(rs.getInt("Id_asignatura"));
            es.setMateria(rs.getString("Materia"));
        }
        this.desconectar();
        return es;
    }

    @Override
    public List<Asignatura> getAll() throws Exception {
        List<Asignatura> list = null;
        String sql = "select * from asignatura";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        list = new ArrayList<Asignatura>();
        while (rs.next()) {            
            Asignatura es = new Asignatura();
            es.setId_asignatura(rs.getInt("Id_asignatura"));
            es.setMateria(rs.getString("Materia"));
            list.add(es);
        }
        this.desconectar();
        return list;
    }
    
}
