package com.example.demo.service;

import com.example.demo.dto.UsuarioDTO;
import java.util.List;

public interface UsuarioService {

    List<UsuarioDTO> listar();
    UsuarioDTO registrar(UsuarioDTO dto);
    String actualizarClave(String id, String clave);
}
