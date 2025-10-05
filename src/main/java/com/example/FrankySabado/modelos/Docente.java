package com.example.FrankySabado.modelos;

import com.example.FrankySabado.ayudas.Estados;
import com.example.FrankySabado.ayudas.Roles;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "docentes")
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre", length = 50, nullable = false, unique = false)
    private String nombre;
    @Column(name = "correo", length = 50, nullable = false, unique = false)
    private String  correo;
    @Column(name = "contraseña", length = 50, nullable = false, unique = false)
    private String contraseña;
    @Column(name = "rol", length = 50, nullable = false, unique = false)
    @Enumerated(EnumType.STRING)
    private Roles rol;
    @Column(name = "estado", length = 50, nullable = false, unique = false)
    @Enumerated(EnumType.STRING)
    private Estados estados;

    @OneToOne
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id")
    @JsonBackReference(value = "relacionusuariodocente")
    private Usuario usuario;

    public Docente() { }

    public Docente(Integer id, String nombre, String correo, String contraseña, Roles rol, Estados estados) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.rol = rol;
        this.estados = estados;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }

    public Estados getEstados() {
        return estados;
    }

    public void setEstados(Estados estados) {
        this.estados = estados;
    }
}

