package com.mx.ApiRestRestaurante.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.ApiRestRestaurante.entity.Mesas;
import com.mx.ApiRestRestaurante.entity.Mesero;
import com.mx.ApiRestRestaurante.repository.MesasRepository;
import com.mx.ApiRestRestaurante.repository.MeserosRepository;

@Service
public class MesasServImp {

    @Autowired
    private MesasRepository mesasRepository;

    @Autowired
    private MeserosRepository meserosRepository;

    //LISTAR MESAS
    public List<Mesas> listarMesas() {
        return mesasRepository.findAll();
    }

    //GUARDAR NUEVA MESA
    public Mesas guardarMesa(Mesas mesa) throws Exception {
        // Validar ID repetido
        if (mesa.getId() != null && mesasRepository.existsById(mesa.getId())) {
            throw new Exception("El ID de la mesa ya existe");
        }

        // Validar NUM_MESA repetido
        boolean numMesaExistente = mesasRepository.findAll().stream()
            .anyMatch(m -> m.getNumMesa().equals(mesa.getNumMesa()));
        if (numMesaExistente) {
            throw new Exception("El número de mesa ya existe");
        }

        // Validar que el mesero exista
        if (mesa.getMesero() == null || mesa.getMesero().getId() == null
                || !meserosRepository.existsById(mesa.getMesero().getId())) {
            throw new Exception("El mesero asignado no existe");
        }

        return mesasRepository.save(mesa);
    }

    //BUSCAR MESA POR ID
    public Mesas buscarMesaPorId(Integer id) throws Exception {
        Optional<Mesas> mesaOpt = mesasRepository.findById(id);
        if (mesaOpt.isEmpty()) {
            throw new Exception("Mesa no encontrada con ID: " + id);
        }
        return mesaOpt.get();
    }

    //EDITAR MESA
    public Mesas editarMesa(Mesas mesa) throws Exception {
        if (mesa.getId() == null || !mesasRepository.existsById(mesa.getId())) {
            throw new Exception("No se puede editar: la mesa no existe");
        }

        if (mesa.getMesero() == null || mesa.getMesero().getId() == null
                || !meserosRepository.existsById(mesa.getMesero().getId())) {
            throw new Exception("El mesero asignado no existe");
        }

        return mesasRepository.save(mesa);
    }

 //ELIMINAR MESA
    public void eliminarMesa(Integer id) throws Exception {
        // Validar que la mesa exista
        if (!mesasRepository.existsById(id)) {
            throw new Exception("No se puede eliminar: la mesa no existe");
        }
        mesasRepository.deleteById(id);
    }

}
