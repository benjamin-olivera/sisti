package org.sisti.service;

import java.util.List;

import org.sisti.dao.UsuarioSistemaDAO;
import org.sisti.model.UsuarioSistema;

public class UsuarioSistemaService {

    private UsuarioSistemaDAO usuarioSistemaDAO;

    public UsuarioSistemaService() {
        usuarioSistemaDAO = new UsuarioSistemaDAO();
    }

    public List<UsuarioSistema> listar() {
        return usuarioSistemaDAO.listar();
    }

    public UsuarioSistema buscar(int id) {
        return usuarioSistemaDAO.buscar(id);
    }

    public UsuarioSistema buscarPorUsername(String username) {
        return usuarioSistemaDAO.buscarPorUsername(username);
    }

    public void registrar(UsuarioSistema usuario) {
        usuarioSistemaDAO.registrar(usuario);
    }

    public void actualizar(UsuarioSistema usuario) {
        usuarioSistemaDAO.actualizar(usuario);
    }

    public void eliminar(int id) {
        usuarioSistemaDAO.eliminar(id);
    }
}