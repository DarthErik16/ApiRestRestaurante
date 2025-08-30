package com.mx.ApiRestRestaurante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mx.ApiRestRestaurante.entity.Mesas;
import com.mx.ApiRestRestaurante.service.MesasServImp;

@RestController
@RequestMapping("/api/mesas")
public class MesasController {

    @Autowired
    private MesasServImp mesasService;

    //LISTAR TODAS LAS MESAS
    @GetMapping
    public ResponseEntity<List<Mesas>> listarMesas() {
        return ResponseEntity.ok(mesasService.listarMesas());
    }

    //BUSCAR MESA POR ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarMesaPorId(@PathVariable("id") Integer id) {
        try {
            Mesas mesa = mesasService.buscarMesaPorId(id);
            return ResponseEntity.ok(mesa);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //GUARDAR NUEVA MESA
    @PostMapping
    public ResponseEntity<?> guardarMesa(@RequestBody Mesas mesa) {
        try {
            Mesas nuevaMesa = mesasService.guardarMesa(mesa);
            return ResponseEntity.ok(nuevaMesa);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //EDITAR MESA
    @PutMapping
    public ResponseEntity<?> editarMesa(@RequestBody Mesas mesa) {
        try {
            Mesas mesaEditada = mesasService.editarMesa(mesa);
            return ResponseEntity.ok(mesaEditada);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
 //ELIMINAR MESA
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarMesa(@PathVariable("id") Integer id) {
        try {
            mesasService.eliminarMesa(id);
            return ResponseEntity.ok("Mesa eliminada correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
