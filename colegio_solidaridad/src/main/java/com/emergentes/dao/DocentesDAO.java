package com.emergentes.dao;

import com.emergentes.modelo.Profesor;
import java.util.List;

public interface DocentesDAO {
    public void insert(Profesor estudiante) throws Exception;
    public void update(Profesor estudiante) throws Exception;
    public void delete(int id) throws Exception;
    public Profesor getById(int id) throws Exception;
    public List<Profesor> getAll() throws Exception;
}
