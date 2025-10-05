package com.example.FrankySabado.repositorios;

import com.example.FrankySabado.ayudas.Roles;
import com.example.FrankySabado.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUsuarioRepositorio extends JpaRepository<Usuario,Integer> {
    //Espacio donde se personalizan las consultas en SQL (DISTINTAS A LAS 5 BASICAS)

    //Buscando un usuario por nombre exacto
    Optional<Usuario>findByNombre(String nombre);

    //Buscando un usuario por correo
    Optional<Usuario> findByCorreo(String correo);

    //Buscando todos los usuarios que tengan un nombre en especifico
    List<Usuario>findByNombreContaining(String nombre);

    //Buscando los usuarios cuyo correo comience por :
    List<Usuario> findByCorreoStartingWith(String correo);

    //Buscando un usuario por rol
    List<Usuario> findByRol(Roles rol);


}