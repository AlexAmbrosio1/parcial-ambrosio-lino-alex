package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

public class UsuarioDTO {

    @Getter @Setter
    private String id;

    @Getter @Setter
    private String nombre;

    @Getter @Setter
    private String clave;
}
