package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "operacion")     // 👈 IMPORTANTE
public class Operacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idoperacion")
    @Getter @Setter
    private Long idoperacion;

    @Column(name = "idcliente")
    @Getter @Setter
    private Long idcliente;

    @Column(name = "tipooperacion")
    @Getter @Setter
    private String tipooperacion;

    @Column(name = "total")
    @Getter @Setter
    private Double total;
}
