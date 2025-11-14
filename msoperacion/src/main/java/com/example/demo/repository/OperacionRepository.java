package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.Operacion;

public interface OperacionRepository extends JpaRepository<Operacion, Long> {

}
