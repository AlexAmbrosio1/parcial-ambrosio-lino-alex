package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Operacion {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long idoperacion;
 
    @Column
    @Getter 
    @Setter
    private Long idcliente;

    @Column
    @Getter 
    @Setter
    private String tipooperacion;
    
    @Column
    @Getter 
    @Setter
    private Double total;

}
