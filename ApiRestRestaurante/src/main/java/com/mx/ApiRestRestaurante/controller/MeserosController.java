package com.mx.ApiRestRestaurante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mx.ApiRestRestaurante.entity.Mesero;
import com.mx.ApiRestRestaurante.service.MeserosServImp;

@RestController
@RequestMapping("/api/meseros")
public class MeserosController {

    @Autowired
    private MeserosServImp meserosService;

    //LISTAR TODOS LOS MESEROS
    @GetMapping
    public ResponseEntity<List<Mesero>> listarMeseros() {
        return ResponseEntity.ok(meserosService.listarMeseros());
    }
    //Buscar X Id
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarMeseroPorId(@PathVariable("id") Integer id) {
        try {
            Mesero mesero = meserosService.buscarMeseroPorId(id);
            return ResponseEntity.ok(mesero);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    //GUARDAR NUEVO MESERO
    @PostMapping
    public ResponseEntity<?> guardarMesero(@RequestBody Mesero mesero) {
        try {
            Mesero nuevoMesero = meserosService.guardarMesero(mesero);
            return ResponseEntity.ok(nuevoMesero);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //EDITAR MESERO
    @PutMapping
    public ResponseEntity<?> editarMesero(@RequestBody Mesero mesero) {
        try {
            Mesero meseroEditado = meserosService.editarMesero(mesero);
            return ResponseEntity.ok(meseroEditado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    //Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarMesero(@PathVariable("id") Integer id) {
        try {
            meserosService.eliminarMesero(id);
            return ResponseEntity.ok("Mesero eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
