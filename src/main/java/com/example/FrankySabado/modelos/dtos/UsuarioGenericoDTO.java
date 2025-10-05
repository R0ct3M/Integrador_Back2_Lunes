package com.example.FrankySabado.modelos.dtos;

import com.example.FrankySabado.ayudas.Estados;
import com.example.FrankySabado.ayudas.Roles;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UsuarioGenericoDTO {

    @NotBlank(message = "El nombre es obligatorio.")
    @Size(max = 50, message = "EL nombre es muy largo.")
    private String nombre;

    @NotBlank(message = "El correo es obligatorio.")
    @Email(message = "El correo no tiene un formato válido. Ejemplo: info@info.com")
    @Size(max = 50, message = "EL correo es demasiado largo...")
    private String correo;

    @NotBlank(message = "El contraseña es obligatoria.")
    @Size(min = 6,  max = 100, message = "Debe tener al menos 6 caractéres.")
    private String contrasena;

    @NotNull(message = "EL rol es obligatorio.")
    private Roles rol;

    @NotNull(message = "El estado es obligatorio.")
    private Estados estado;

    public UsuarioGenericoDTO() {
    }

    public UsuarioGenericoDTO(String nombre, String correo, String contrasena, Roles rol, Estados estado) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rol = rol;
        this.estado = estado;
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

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public Roles getRol() {
        return rol;
    }
    public void setRol(Roles rol) {
        this.rol = rol;
    }

    public Estados getEstado() { return estado; }
    public void setEstado(Estados estado) { this.estado = estado; }
}
