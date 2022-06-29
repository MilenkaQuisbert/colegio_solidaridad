package com.emergentes.dao;

import com.emergentes.modelo.Curso;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CursoDAOimpl extends ConexionDB implements CursoDAO{

    @Override
    public void insert(Curso estudiante) throws Exception {
        String sql = "insert curso (Grado,Paralelo,Id_profesor_FK) values (?,?,?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, estudiante.getGrado());
        ps.setString(2, estudiante.getParalelo());
        ps.setInt(3, estudiante.getId_profesor());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Curso estudiante) throws Exception {
        String sql = "update curso set Grado=?,Paralelo=?,Id_profesor_FK=? where Id_curso=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, estudiante.getGrado());
        ps.setString(2, estudiante.getParalelo());
        ps.setInt(3, estudiante.getId_profesor());
        ps.setInt(4, estudiante.getId_curso());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from curso where Id_curso = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public Curso getById(int id) throws Exception {
        Curso es = new Curso();
        String sql = "select * from curso where Id_curso = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            es.setId_curso(rs.getInt("Id_curso"));
            es.setGrado(rs.getString("Grado"));
            es.setParalelo(rs.getString("Paralelo"));
            es.setId_profesor(rs.getInt("Id_profesor_FK"));
        }
        this.desconectar();
        return es;
    }

    @Override
    public List<Curso> getAll() throws Exception {
        List<Curso> list = null;
        String sql = "SELECT c.*,CONCAT(p.Nombres,' ',p.Apellidos) as nombre from curso c";
        sql += " left join profesor pr on c.Id_profesor_FK=pr.Id_profesor";
        sql += " left join persona p on pr.Id_persona_FK=p.Id_persona";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        list = new ArrayList<Curso>();
        while (rs.next()) {            
            Curso es = new Curso();
            es.setId_curso(rs.getInt("Id_curso"));
            es.setGrado(rs.getString("Grado"));
            es.setParalelo(rs.getString("Paralelo"));
            es.setId_profesor(rs.getInt("Id_profesor_FK"));
            es.setAsesor(rs.getString("nombre"));
            list.add(es);
        }
        this.desconectar();
        return list;
    }
    
}
