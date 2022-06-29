package com.emergentes.dao;

import com.emergentes.modelo.Tutor;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TutorDAOimpl extends ConexionDB implements TutorDAO{

    @Override
    public void insert(Tutor estudiante) throws Exception { 
        String sql = "insert tutor (Oficio,Parentesco,Id_persona_FK) values (?,?,?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, estudiante.getOficio());
        ps.setString(2, estudiante.getParentesco());
        ps.setInt(3, estudiante.getId_persona());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Tutor estudiante) throws Exception {
        String sql = "update tutor set Oficio=?,Parentesco=?,Id_persona_FK=? where Id_tutor=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, estudiante.getOficio());
        ps.setString(2, estudiante.getParentesco());
        ps.setInt(3, estudiante.getId_persona());
        ps.setInt(4, estudiante.getId_tutor());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from tutor where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public Tutor getById(int id) throws Exception {
        Tutor es = new Tutor();
        String sql = "select * from tutor where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            es.setId_tutor(rs.getInt("Id_tutor"));
            es.setOficio(rs.getString("Oficio"));
            es.setParentesco(rs.getString("Parentesco"));
            es.setId_persona(rs.getInt("Id_persona_FK"));
        }
        this.desconectar();
        return es;
    }

    @Override
    public List<Tutor> getAll() throws Exception {
        List<Tutor> list = null;
        String sql = "SELECT t.*, p.CI as ci,CONCAT(p.Nombres,' ',p.Apellidos) as nombre,p.Celular,p.Direccion from tutor t ";
        sql += " left join persona p on t.Id_persona_FK=p.Id_persona";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        list = new ArrayList<Tutor>();
        while (rs.next()) {            
            Tutor es = new Tutor();
            es.setId_tutor(rs.getInt("Id_tutor"));
            es.setOficio(rs.getString("Oficio"));
            es.setParentesco(rs.getString("Parentesco"));
            es.setId_persona(rs.getInt("Id_persona_FK"));
            es.setCi(rs.getInt("ci"));
            es.setNombres(rs.getString("nombre"));
            es.setCelular(rs.getInt("Celular"));
            es.setDireccion(rs.getString("Direccion"));
            list.add(es);
        }
        this.desconectar();
        return list;
    }
    
}
