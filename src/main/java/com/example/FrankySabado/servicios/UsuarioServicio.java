package com.example.FrankySabado.servicios;

import com.example.FrankySabado.modelos.Usuario;
import com.example.FrankySabado.modelos.dtos.UsuarioEspecialDTO;
import com.example.FrankySabado.modelos.dtos.UsuarioGenericoDTO;
import com.example.FrankySabado.modelos.mapas.IMapaUsuarioDTO;
import com.example.FrankySabado.repositorios.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {

    //1. Llamar al repositorio
    //INYECTAR UNA DEPENDENCIA AL REPO
    @Autowired
    private IUsuarioRepositorio repositorio;

    @Autowired
    private IMapaUsuarioDTO mapa;

    //1. Servicio para guardar un usuario
    public UsuarioEspecialDTO guardarUsuario(UsuarioGenericoDTO datosUsuario)throws Exception{
        try{
            //validar correo.
            if (repositorio.findByCorreo(datosUsuario.getCorreo()).isPresent()) {
                throw new Exception("Este correo ya ha sido registrado.");
            }

            Usuario usuarioEntidad = mapa.convertirAEntidad(datosUsuario);
            Usuario usurioGuardado = this.repositorio.save(usuarioEntidad);
            return this.mapa.convertirADTO(usurioGuardado);

        }catch(Exception error){
            throw new Exception("upss fallamos "+error.getMessage());
        }
    }

    //2. Servicio para buscar Todos los usuarios
    public List<UsuarioEspecialDTO> buscarUsuarios()throws Exception{
        try{
            List<Usuario> listausuarios = repositorio.findAll();
            return this.mapa.convertirListaDTO(listausuarios);
        }catch(Exception error){
            throw new Exception("upss fallamos "+error.getMessage());
        }
    }

    //3. Servicio para buscar un usuario si me dan su ID
    public UsuarioEspecialDTO buscarUsuarioPorId(Integer id)throws Exception{
        try{
            Optional<Usuario>usuarioBuscado= this.repositorio.findById(id);
            if(usuarioBuscado.isPresent()){ //SI SI ESTA
                return this.mapa.convertirADTO(usuarioBuscado.get());
            }else{ //SI NO ESTA
                throw new Exception("Usuario no encontrado");
            }
        }catch(Exception error){
            throw new Exception("upss fallamos "+error.getMessage());
        }
    }

    //Buscar por correo
    public UsuarioEspecialDTO buscarUsuarioPorCorreo(String correo)throws Exception{
        try{
            Optional<Usuario>usuarioBuscado = this.repositorio.findByCorreo(correo);
            if(usuarioBuscado.isPresent()){ //SI SI ESTA
                return this.mapa.convertirADTO(usuarioBuscado.get());
            }else{ //SI NO ESTA
                throw new Exception("Usuario no encontrado");
            }
        }catch(Exception error){
            throw new Exception("upss fallamos "+error.getMessage());
        }
    }

}
