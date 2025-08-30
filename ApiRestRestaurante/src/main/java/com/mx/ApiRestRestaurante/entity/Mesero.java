package com.mx.ApiRestRestaurante.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MESERO")
public class Mesero {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "APP", nullable = false)
    private String app;

    @Column(name = "APM")
    private String apm;

    @Column(name = "SUELDO", nullable = false)
    private Double sueldo;

    // ✅ Getters y setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getApm() {
        return apm;
    }

    public void setApm(String apm) {
        this.apm = apm;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }
}
