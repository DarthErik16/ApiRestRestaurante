package com.mx.ApiRestRestaurante.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "MESAS")
public class Mesas {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NUM_MESA", nullable = false)
    private Integer numMesa;

    @Column(name = "NUM_SILLAS", nullable = false)
    private Integer numSillas;

    // Relación muchos a uno: muchas mesas pueden ser atendidas por un mesero
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_MESERO", nullable = false)
    private Mesero mesero;

    // ✅ Getters y setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(Integer numMesa) {
        this.numMesa = numMesa;
    }

    public Integer getNumSillas() {
        return numSillas;
    }

    public void setNumSillas(Integer numSillas) {
        this.numSillas = numSillas;
    }

    public Mesero getMesero() {
        return mesero;
    }

    public void setMesero(Mesero mesero) {
        this.mesero = mesero;
    }
}
