package com.emergentes.dao;

import com.emergentes.modelo.Asignatura;
import java.util.List;

public interface AsignaturaDAO {
    public void insert(Asignatura estudiante) throws Exception;
    public void update(Asignatura estudiante) throws Exception;
    public void delete(int id) throws Exception;
    public Asignatura getById(int id) throws Exception;
    public List<Asignatura> getAll() throws Exception;
}
