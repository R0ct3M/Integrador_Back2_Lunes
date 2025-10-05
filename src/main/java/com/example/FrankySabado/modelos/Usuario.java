package com.example.FrankySabado.modelos;

import com.example.FrankySabado.ayudas.Estados;
import com.example.FrankySabado.ayudas.Roles;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El nombre no puede esta vacío")
    @Size(max = 50, message = "EL nombre es demasiado largo...")
    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @NotBlank(message = "El correo es obligatorio.")
    @Email(message = "El correo no tiene un formato válido. Ejemplo: info@info.com")
    @Size(max = 50, message = "EL correo es demasiado largo...")
    @Column(name = "correo", length = 50, nullable = false, unique = true)
    private String correo;

    @NotBlank(message = "La contraseña es obligatoria.")
    @Size(min = 6,  max = 100, message = "Debe tener al menos 6 caractéres.")
    @Column(name = "contrasena",nullable = false)
    private String contrasena;

    @NotNull(message = "EL rol es obligatorio")
    @Column(name = "rol", nullable = false)
    @Enumerated(EnumType.STRING)
    private Roles rol;

    @NotNull(message = "EL estado es obligatorio")
    @Column(name = "estado", nullable = false)
    @Enumerated(EnumType.STRING)
    private Estados estado;

    //RELACIONES

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "relacionusuarioestudiante")
    private Estudiante estudiante;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "relacionusuariofamiliar")
    private List<Familiar> familiares;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "realcionusuariodocente")
    private Docente docente;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "relacionusuarioempresario")
    private Empresario empresario;

    public Usuario() {}

    public Usuario(Integer id, String nombre, String correo, String contrasena, Roles rol, Estados estado) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rol = rol;
        this.estado = estado;
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

    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Roles getRol() {
        return rol;
    }
    public void setRol(Roles rol) {
        this.rol = rol;
    }

    public Estados getEstado() {
        return estado;
    }
    public void setEstado(Estados estado) {
        this.estado = estado;
    }
}
