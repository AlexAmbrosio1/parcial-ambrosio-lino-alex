package com.example.demo.mapper;

import com.example.demo.dto.UsuarioDTO;
import com.example.demo.models.Usuario;

public class UsuarioMapper {

    public static UsuarioDTO toDTO(Usuario u) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(u.getId());
        dto.setNombre(u.getNombre());
        dto.setClave(u.getClave());
        return dto;
    }

    public static Usuario toEntity(UsuarioDTO dto) {
        Usuario u = new Usuario();
        u.setId(dto.getId());
        u.setNombre(dto.getNombre());
        u.setClave(dto.getClave());
        return u;
    }
}
