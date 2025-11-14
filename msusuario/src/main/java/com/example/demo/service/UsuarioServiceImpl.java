package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UsuarioDTO;
import com.example.demo.mapper.UsuarioMapper;
import com.example.demo.models.Usuario;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repo;
    private static final Logger logger = LoggerFactory.getLogger(UsuarioServiceImpl.class);

    public UsuarioServiceImpl(UsuarioRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<UsuarioDTO> listar() {
        logger.info("Listando usuarios");
        return repo.findAll().stream()
                .map(UsuarioMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioDTO registrar(UsuarioDTO dto) {
        logger.info("Registrando usuario {}", dto.getNombre());
        Usuario u = UsuarioMapper.toEntity(dto);
        Usuario saved = repo.save(u);
        return UsuarioMapper.toDTO(saved);
    }

    @Override
    public String actualizarClave(String id, String clave) {
        logger.warn("Actualizando clave del usuario {}", id);

        return repo.findById(id)
                .map(u -> {
                    u.setClave(clave);
                    repo.save(u);
                    return "Clave actualizada";
                })
                .orElse("Usuario no encontrado");
    }
}
