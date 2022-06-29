package com.emergentes.modelo;

import java.sql.Date;

public class Estudiantes extends Persona{
    private int id_alumno;
    private String rude;
    private String patologias;
    private int id_tutor;
    private int id_curso;
    private int id_persona;
    private String tutor;
    private String paralelo;
    private String curso;
    private String asesor;

    public String getAsesor() {
        return asesor;
    }

    public void setAsesor(String asesor) {
        this.asesor = asesor;
    }

    public Estudiantes() {
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public String getParalelo() {
        return paralelo;
    }

    public void setParalelo(String paralelo) {
        this.paralelo = paralelo;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public String getRude() {
        return rude;
    }

    public void setRude(String rude) {
        this.rude = rude;
    }

    public String getPatologias() {
        return patologias;
    }

    public void setPatologias(String patologias) {
        this.patologias = patologias;
    }

    public int getId_tutor() {
        return id_tutor;
    }

    public void setId_tutor(int id_tutor) {
        this.id_tutor = id_tutor;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    
    

}
