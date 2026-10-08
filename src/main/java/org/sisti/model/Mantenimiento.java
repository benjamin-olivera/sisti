package org.sisti.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "mantenimientos")
public class Mantenimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_mantenimiento;

    private LocalDate fecha_inicio;

    private LocalDate fecha_fin;

    private String tipo_mantenimiento;

    private String problema;

    private String solucion;

    private String tecnico_responsable;

    private BigDecimal costo;

    private String estado;

    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "id_equipo")
    private Equipo equipo;

    public int getId_mantenimiento() {
        return id_mantenimiento;
    }

    public void setId_mantenimiento(int id_mantenimiento) {
        this.id_mantenimiento = id_mantenimiento;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getTipo_mantenimiento() {
        return tipo_mantenimiento;
    }

    public void setTipo_mantenimiento(String tipo_mantenimiento) {
        this.tipo_mantenimiento = tipo_mantenimiento;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }

    public String getTecnico_responsable() {
        return tecnico_responsable;
    }

    public void setTecnico_responsable(String tecnico_responsable) {
        this.tecnico_responsable = tecnico_responsable;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return "Mantenimiento [id_mantenimiento=" + id_mantenimiento
                + ", fecha_inicio=" + fecha_inicio
                + ", fecha_fin=" + fecha_fin
                + ", tipo_mantenimiento=" + tipo_mantenimiento
                + ", problema=" + problema
                + ", solucion=" + solucion
                + ", tecnico_responsable=" + tecnico_responsable
                + ", costo=" + costo
                + ", estado=" + estado
                + ", observaciones=" + observaciones
                + ", equipo=" + equipo + "]";
    }
}