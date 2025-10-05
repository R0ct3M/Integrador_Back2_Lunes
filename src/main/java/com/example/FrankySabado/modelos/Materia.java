package com.example.FrankySabado.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "Materia")

public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "codigo")
    private Integer codigo;

    @ManyToOne
    @JoinColumn(name = "fk_grupo")
    private Grupo grupo;

    public Materia() {}

    public Materia(Integer id, String nombre, Integer codigo, Grupo grupo) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.grupo = grupo;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Integer getCodigo() { return codigo; }
    public void setCodigo(Integer codigo) { this.codigo = codigo; }

    public Grupo getGrupo() { return grupo; }
    public void setGrupo(Grupo grupo) { this.grupo = grupo; }
}
