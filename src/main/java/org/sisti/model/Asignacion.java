package org.sisti.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "asignaciones")
public class Asignacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_asignacion;

    private LocalDate fecha_asignacion;

    private LocalDate fecha_devolucion;

    private String motivo;

    private String observaciones;

    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_equipo")
    private Equipo equipo;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public int getId_asignacion() {
        return id_asignacion;
    }

    public void setId_asignacion(int id_asignacion) {
        this.id_asignacion = id_asignacion;
    }

    public LocalDate getFecha_asignacion() {
        return fecha_asignacion;
    }

    public void setFecha_asignacion(LocalDate fecha_asignacion) {
        this.fecha_asignacion = fecha_asignacion;
    }

    public LocalDate getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(LocalDate fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Asignacion [id_asignacion=" + id_asignacion
                + ", fecha_asignacion=" + fecha_asignacion
                + ", fecha_devolucion=" + fecha_devolucion
                + ", motivo=" + motivo
                + ", observaciones=" + observaciones
                + ", estado=" + estado
                + ", equipo=" + equipo
                + ", usuario=" + usuario + "]";
    }
}