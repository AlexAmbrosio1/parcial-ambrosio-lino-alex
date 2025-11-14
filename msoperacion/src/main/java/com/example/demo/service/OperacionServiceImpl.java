package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.demo.dto.OperacionDTO;
import com.example.demo.mapper.OperacionMapper;
import com.example.demo.models.Operacion;
import com.example.demo.repository.OperacionRepository;

@Service
public class OperacionServiceImpl implements OperacionService {

    private final OperacionRepository repo;
    private static final Logger logger = LoggerFactory.getLogger(OperacionServiceImpl.class);

    public OperacionServiceImpl(OperacionRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<OperacionDTO> listar() {
        logger.info("Listando operaciones");
        return repo.findAll().stream()
                .map(OperacionMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OperacionDTO registrar(OperacionDTO dto) {
        logger.info("Registrando operación tipo {}", dto.getTipooperacion());
        Operacion o = OperacionMapper.toEntity(dto);
        Operacion saved = repo.save(o);
        return OperacionMapper.toDTO(saved);
    }

    @Override
    public String actualizarTotal(Long id, Double total) {
        logger.warn("Actualizando total de la operación {}", id);

        return repo.findById(id)
                .map(o -> {
                    o.setTotal(total);
                    repo.save(o);
                    return "Total actualizado";
                })
                .orElse("Operación no encontrada");
    }
}
