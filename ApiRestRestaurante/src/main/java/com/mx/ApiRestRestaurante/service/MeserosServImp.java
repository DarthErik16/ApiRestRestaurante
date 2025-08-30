package com.mx.ApiRestRestaurante.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.ApiRestRestaurante.entity.Mesero;
import com.mx.ApiRestRestaurante.repository.MeserosRepository;

@Service
public class MeserosServImp {

    @Autowired
    private MeserosRepository meserosRepository;

    // --- LISTAR TODOS LOS MESEROS ---
    public List<Mesero> listarMeseros() {
        return meserosRepository.findAll();
    }

    // --- GUARDAR NUEVO MESERO ---
    public Mesero guardarMesero(Mesero mesero) throws Exception {
        // Validar que no exista ID repetido
        if (mesero.getId() != null && meserosRepository.existsById(mesero.getId())) {
            throw new Exception("El ID ya existe");
        }

        // Validar que no exista un mesero con mismo nombre completo
        boolean nombreCompletoExistente = meserosRepository.findAll().stream()
            .anyMatch(m -> m.getNombre().equalsIgnoreCase(mesero.getNombre())
                        && m.getApp().equalsIgnoreCase(mesero.getApp())
                        && ((m.getApm() == null && mesero.getApm() == null) 
                            || (m.getApm() != null && m.getApm().equalsIgnoreCase(mesero.getApm()))));
        if (nombreCompletoExistente) {
            throw new Exception("Ya existe un mesero con el mismo nombre completo");
        }

        return meserosRepository.save(mesero);
    }

    // --- BUSCAR MESERO POR ID ---
    public Mesero buscarMeseroPorId(Integer id) throws Exception {
        Optional<Mesero> meseroOpt = meserosRepository.findById(id);
        if (meseroOpt.isEmpty()) {
            throw new Exception("Mesero no encontrado con ID: " + id);
        }
        return meseroOpt.get();
    }

    // --- EDITAR MESERO ---
    public Mesero editarMesero(Mesero mesero) throws Exception {
        if (mesero.getId() == null || !meserosRepository.existsById(mesero.getId())) {
            throw new Exception("No se puede editar: el ID no existe");
        }
        return meserosRepository.save(mesero);
    }

    // --- ELIMINAR MESERO ---
    public void eliminarMesero(Integer id) throws Exception {
        if (!meserosRepository.existsById(id)) {
            throw new Exception("No se puede eliminar: el ID no existe");
        }
        meserosRepository.deleteById(id);
    }
}
