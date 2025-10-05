package com.example.FrankySabado.modelos.mapas;

import com.example.FrankySabado.modelos.Usuario;
import com.example.FrankySabado.modelos.dtos.UsuarioEspecialDTO;
import com.example.FrankySabado.modelos.dtos.UsuarioGenericoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IMapaUsuarioDTO {

    //de DTO de entrada a entidad(Guarda o actualiza)
    @Mapping(target = "id", ignore = true) //La BD genera el ID
    Usuario convertirAEntidad(UsuarioGenericoDTO dto);

    //de entidad a DTO de salida
    UsuarioEspecialDTO convertirADTO(Usuario usuario);

    List<UsuarioEspecialDTO> convertirListaDTO(List<Usuario> lista);

}