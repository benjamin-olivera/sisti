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
@Table(name = "equipos")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_equipo;

    private String codigo_inventario;

    private String modelo;

    private String numero_serie;

    private String procesador;

    private String ram;

    private String almacenamiento;

    private String sistema_operativo;

    private String hostname;

    private LocalDate fecha_adquisicion;

    private BigDecimal precio_adquisicion;

    private String estado_equipo;

    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "id_tipo")
    private TipoEquipo tipoEquipo;

    @ManyToOne
    @JoinColumn(name = "id_marca")
    private Marca marca;

    public int getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    public String getCodigo_inventario() {
        return codigo_inventario;
    }

    public void setCodigo_inventario(String codigo_inventario) {
        this.codigo_inventario = codigo_inventario;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumero_serie() {
        return numero_serie;
    }

    public void setNumero_serie(String numero_serie) {
        this.numero_serie = numero_serie;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(String almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public String getSistema_operativo() {
        return sistema_operativo;
    }

    public void setSistema_operativo(String sistema_operativo) {
        this.sistema_operativo = sistema_operativo;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public LocalDate getFecha_adquisicion() {
        return fecha_adquisicion;
    }

    public void setFecha_adquisicion(LocalDate fecha_adquisicion) {
        this.fecha_adquisicion = fecha_adquisicion;
    }

    public BigDecimal getPrecio_adquisicion() {
        return precio_adquisicion;
    }

    public void setPrecio_adquisicion(BigDecimal precio_adquisicion) {
        this.precio_adquisicion = precio_adquisicion;
    }

    public String getEstado_equipo() {
        return estado_equipo;
    }

    public void setEstado_equipo(String estado_equipo) {
        this.estado_equipo = estado_equipo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public TipoEquipo getTipoEquipo() {
        return tipoEquipo;
    }

    public void setTipoEquipo(TipoEquipo tipoEquipo) {
        this.tipoEquipo = tipoEquipo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Equipo [id_equipo=" + id_equipo
                + ", codigo_inventario=" + codigo_inventario
                + ", modelo=" + modelo
                + ", numero_serie=" + numero_serie
                + ", procesador=" + procesador
                + ", ram=" + ram
                + ", almacenamiento=" + almacenamiento
                + ", sistema_operativo=" + sistema_operativo
                + ", hostname=" + hostname
                + ", fecha_adquisicion=" + fecha_adquisicion
                + ", precio_adquisicion=" + precio_adquisicion
                + ", estado_equipo=" + estado_equipo
                + ", observaciones=" + observaciones
                + ", tipoEquipo=" + tipoEquipo
                + ", marca=" + marca + "]";
    }
}