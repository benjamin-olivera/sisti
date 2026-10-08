package org.sisti.service;

import java.util.List;

import org.sisti.dao.UsuarioDAO;
import org.sisti.model.Usuario;

public class UsuarioService {

    private UsuarioDAO usuarioDAO;

    public UsuarioService() {
        usuarioDAO = new UsuarioDAO();
    }

    public List<Usuario> listar() {
        return usuarioDAO.listar();
    }

    public Usuario buscar(int id) {
        return usuarioDAO.buscar(id);
    }

    public void registrar(Usuario usuario) {
        usuarioDAO.registrar(usuario);
    }

    public void actualizar(Usuario usuario) {
        usuarioDAO.actualizar(usuario);
    }

    public void eliminar(int id) {
        usuarioDAO.eliminar(id);
    }
}