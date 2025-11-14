package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

public class OperacionDTO {

    @Getter @Setter
    private Long idoperacion;

    @Getter @Setter
    private Long idcliente;

    @Getter @Setter
    private String tipooperacion;

    @Getter @Setter
    private Double total;
}
