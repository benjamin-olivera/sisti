package org.sisti.service;

import java.util.List;

import org.sisti.dao.AsignacionDAO;
import org.sisti.model.Asignacion;

public class AsignacionService {

    private AsignacionDAO asignacionDAO;

    public AsignacionService() {
        asignacionDAO = new AsignacionDAO();
    }

    public List<Asignacion> listar() {
        return asignacionDAO.listar();
    }

    public Asignacion buscar(int id) {
        return asignacionDAO.buscar(id);
    }

    public void registrar(Asignacion asignacion) {
        asignacionDAO.registrar(asignacion);
    }

    public void actualizar(Asignacion asignacion) {
        asignacionDAO.actualizar(asignacion);
    }

    public void eliminar(int id) {
        asignacionDAO.eliminar(id);
    }
}