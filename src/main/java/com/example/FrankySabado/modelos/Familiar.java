package com.example.FrankySabado.modelos;

import com.example.FrankySabado.ayudas.Parentescos;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "familiar")
public class Familiar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "parentesco", nullable = false ,unique = false)
    @Enumerated(EnumType.STRING)
    private Parentescos parentesco;
    @Column(name = "telefono", nullable = false, unique = false, length = 10)
    private String telefono;
    @Column(name = "direccion", nullable = false, unique = false, length = 150)
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id")
    @JsonBackReference(value = "relacionusuariofamiliar")
    private Usuario usuario;

    public Familiar(){}

    public Familiar(Integer id, Parentescos parentesco, String telefono, String direccion) {
        this.id = id;
        this.parentesco = parentesco;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Parentescos getParentesco() {
        return parentesco;
    }

    public void setParentesco(Parentescos parentesco) {
        this.parentesco = parentesco;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
