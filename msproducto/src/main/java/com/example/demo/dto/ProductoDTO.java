package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

public class ProductoDTO {

    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String nombre;

    @Getter @Setter
    private Double precio;
}
