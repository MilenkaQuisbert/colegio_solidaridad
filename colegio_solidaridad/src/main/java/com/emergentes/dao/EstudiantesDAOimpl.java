package com.emergentes.dao;

import com.emergentes.modelo.Estudiantes;
import com.emergentes.modelo.Persona;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EstudiantesDAOimpl extends ConexionDB implements EstudiantesDAO {

    @Override
    public void insert(Estudiantes estudiante) throws Exception {
        String sql = "insert into alumno (Rude,Patologias,Id_tutor_FK,Id_curso_FK,Id_persona_FK) values (?,?,?,?,?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, estudiante.getRude());
        ps.setString(2, estudiante.getPatologias());
        ps.setInt(3, estudiante.getId_tutor());
        ps.setInt(4, estudiante.getId_curso());
        ps.setInt(5, estudiante.getId_persona());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Estudiantes estudiante) throws Exception {
        String sql = "update alumno set Rude=?,Patologias=?,Id_tutor_FK=?,Id_curso_FK=?,Id_persona_FK=? where Id_alumno=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, estudiante.getRude());
        ps.setString(2, estudiante.getPatologias());
        ps.setInt(3, estudiante.getId_tutor());
        ps.setInt(4, estudiante.getId_curso());
        ps.setInt(5, estudiante.getId_persona());
        ps.setInt(6, estudiante.getId_alumno());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from alumno where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public Estudiantes getById(int id) throws Exception {
        Estudiantes es = new Estudiantes();
        String sql = "select * from alumno where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            es.setId_alumno(rs.getInt("Id_alumno"));
            es.setRude(rs.getString("Rude"));
            es.setPatologias(rs.getString("Patologias"));
            es.setId_tutor(rs.getInt("Id_tutor_FK"));
            es.setId_curso(rs.getInt("Id_curso_FK"));
            es.setId_persona(rs.getInt("Id_persona_FK"));
        }
        this.desconectar();
        return es;
    }

    @Override
    public List<Estudiantes> getAll() throws Exception {
        List<Estudiantes> list = null;
        String sql = "SELECT a.*, CONCAT(p.Nombres,' ',p.Apellidos) as Tutor, c.Grado as grado,"
                + "c.Paralelo as Paralelo ,CONCAT(per.Nombres,' ',per.Apellidos) as asesor from alumno a ";
        sql += "left join tutor t on a.Id_tutor_FK= t.Id_tutor ";
        sql += "left join persona p on t.Id_persona_FK=p.Id_persona ";
        sql += "left join curso c on a.Id_curso_FK=c.Id_curso ";
        sql += "left join persona per on c.Id_profesor_FK= per.Id_persona ";
        
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        list = new ArrayList<Estudiantes>();
        while (rs.next()) {            
            Estudiantes es = new Estudiantes();
            es.setId_alumno(rs.getInt("Id_alumno"));
            es.setRude(rs.getString("Rude"));
            es.setPatologias(rs.getString("Patologias"));
            es.setId_tutor(rs.getInt("Id_tutor_FK"));
            es.setId_curso(rs.getInt("Id_curso_FK"));
            es.setId_persona(rs.getInt("Id_persona_FK"));
            es.setParalelo(rs.getString("Paralelo"));
            es.setTutor(rs.getString("Tutor"));
            es.setCurso(rs.getString("Grado"));
            es.setAsesor(rs.getString("asesor"));
            list.add(es);
        }
        this.desconectar();
        return list;
    }
    
}
