package org.sisti.service;

import java.util.List;

import org.sisti.dao.MantenimientoDAO;
import org.sisti.model.Mantenimiento;

public class MantenimientoService {

    private MantenimientoDAO mantenimientoDAO;

    public MantenimientoService() {
        mantenimientoDAO = new MantenimientoDAO();
    }

    public List<Mantenimiento> listar() {
        return mantenimientoDAO.listar();
    }

    public Mantenimiento buscar(int id) {
        return mantenimientoDAO.buscar(id);
    }

    public void registrar(Mantenimiento mantenimiento) {
        mantenimientoDAO.registrar(mantenimiento);
    }

    public void actualizar(Mantenimiento mantenimiento) {
        mantenimientoDAO.actualizar(mantenimiento);
    }

    public void eliminar(int id) {
        mantenimientoDAO.eliminar(id);
    }
}