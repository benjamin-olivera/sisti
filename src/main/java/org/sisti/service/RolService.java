package org.sisti.service;

import java.util.List;

import org.sisti.dao.RolDAO;
import org.sisti.model.Rol;

public class RolService {

    private RolDAO rolDAO;

    public RolService() {
        rolDAO = new RolDAO();
    }

    public List<Rol> listar() {
        return rolDAO.listar();
    }

    public Rol buscar(int id) {
        return rolDAO.buscar(id);
    }

    public void registrar(Rol rol) {
        rolDAO.registrar(rol);
    }

    public void actualizar(Rol rol) {
        rolDAO.actualizar(rol);
    }

    public void eliminar(int id) {
        rolDAO.eliminar(id);
    }
}