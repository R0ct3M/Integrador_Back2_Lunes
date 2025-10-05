package com.example.FrankySabado.modelos.dtos;

import com.example.FrankySabado.ayudas.Estados;
import com.example.FrankySabado.ayudas.Roles;

public class UsuarioEspecialDTO {

    private Integer id;
    private String nombre;
    private String correo;
    private Roles rol;
    private Estados estado;

    public UsuarioEspecialDTO() {
    }

    public UsuarioEspecialDTO(Integer id, String nombre, String correo, Roles rol, Estados estado) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.rol = rol;
        this.estado = estado;
    }


    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public Roles getRol() { return rol; }
    public void setRol(Roles rol) { this.rol = rol; }

    public Estados getEstado() { return estado; }
    public void setEstado(Estados estado) { this.estado = estado; }
}
