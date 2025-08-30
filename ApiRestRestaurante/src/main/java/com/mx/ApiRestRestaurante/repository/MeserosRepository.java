package com.mx.ApiRestRestaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mx.ApiRestRestaurante.entity.Mesero;

@Repository
public interface MeserosRepository extends JpaRepository<Mesero, Integer> {
    // Aquí puedes agregar consultas personalizadas si las necesitas
}
