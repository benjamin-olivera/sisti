package org.sisti.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios_sistema")
public class UsuarioSistema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario_sistema;

    private String username;

    private String password;

    private String nombres;

    private String apellidos;

    private String correo;

    private int estado;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;

    public int getId_usuario_sistema() {
        return id_usuario_sistema;
    }

    public void setId_usuario_sistema(int id_usuario_sistema) {
        this.id_usuario_sistema = id_usuario_sistema;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "UsuarioSistema [id_usuario_sistema=" + id_usuario_sistema
                + ", username=" + username
                + ", nombres=" + nombres
                + ", apellidos=" + apellidos
                + ", correo=" + correo
                + ", rol=" + rol
                + ", estado=" + estado + "]";
    }
}