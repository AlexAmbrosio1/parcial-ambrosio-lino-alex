package com.example.demo.mapper;

import com.example.demo.dto.OperacionDTO;
import com.example.demo.models.Operacion;

public class OperacionMapper {

    public static OperacionDTO toDTO(Operacion o) {
        OperacionDTO dto = new OperacionDTO();
        dto.setIdoperacion(o.getIdoperacion());
        dto.setIdcliente(o.getIdcliente());
        dto.setTipooperacion(o.getTipooperacion());
        dto.setTotal(o.getTotal());
        return dto;
    }

    public static Operacion toEntity(OperacionDTO dto) {
        Operacion o = new Operacion();
        o.setIdoperacion(dto.getIdoperacion());
        o.setIdcliente(dto.getIdcliente());
        o.setTipooperacion(dto.getTipooperacion());
        o.setTotal(dto.getTotal());
        return o;
    }
}
