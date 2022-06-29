package com.emergentes.dao;

import com.emergentes.modelo.Estudiantes;
import com.emergentes.modelo.Persona;
import java.util.List;

public interface EstudiantesDAO {
    public void insert(Estudiantes estudiante) throws Exception;
    public void update(Estudiantes estudiante) throws Exception;
    public void delete(int id) throws Exception;
    public Estudiantes getById(int id) throws Exception;
    public List<Estudiantes> getAll() throws Exception;
}
