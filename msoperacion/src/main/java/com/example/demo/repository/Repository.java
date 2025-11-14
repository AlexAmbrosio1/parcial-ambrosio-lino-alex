package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.Operacion;

public interface Repository extends JpaRepository<Operacion, Long> {
    
}
