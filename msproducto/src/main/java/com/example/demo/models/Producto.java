package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long idProducto;

    @Column(nullable = false)
    @Getter @Setter
    private String nombre;

    @Column(nullable = false)
    @Getter @Setter
    private Double precio;
}
