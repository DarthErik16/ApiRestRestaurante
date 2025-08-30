package com.mx.ApiRestRestaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mx.ApiRestRestaurante.entity.Mesas;

@Repository
public interface MesasRepository extends JpaRepository<Mesas, Integer> {
    // Aquí puedes agregar consultas personalizadas si las necesitas
}
