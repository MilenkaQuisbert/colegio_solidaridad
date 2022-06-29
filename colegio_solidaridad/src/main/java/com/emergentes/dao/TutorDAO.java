
package com.emergentes.dao;

import com.emergentes.modelo.Tutor;
import java.util.List;

public interface TutorDAO {
    public void insert(Tutor estudiante) throws Exception;
    public void update(Tutor estudiante) throws Exception;
    public void delete(int id) throws Exception;
    public Tutor getById(int id) throws Exception;
    public List<Tutor> getAll() throws Exception;
}
