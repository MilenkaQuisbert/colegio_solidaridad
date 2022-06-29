package com.emergentes.modelo;

public class Usuario {

    private int id;
    private String nombres;
    private String usuario;
    private String contraseña;
    private String rol;

    public Usuario() {
        this.id = 0;
        this.nombres = "";
        this.usuario = "";
        this.contraseña = "";
        this.rol = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

}
