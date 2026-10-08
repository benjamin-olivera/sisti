package org.sisti.service;

import java.util.List;

import org.sisti.dao.EquipoDAO;
import org.sisti.model.Equipo;

public class EquipoService {

    private EquipoDAO equipoDAO;

    public EquipoService() {
        equipoDAO = new EquipoDAO();
    }

    public List<Equipo> listar() {
        return equipoDAO.listar();
    }

    public Equipo buscar(int id) {
        return equipoDAO.buscar(id);
    }

    public void registrar(Equipo equipo) {
        equipoDAO.registrar(equipo);
    }

    public void actualizar(Equipo equipo) {
        equipoDAO.actualizar(equipo);
    }

    public void eliminar(int id) {
        equipoDAO.eliminar(id);
    }

    public void cerrar() {
        equipoDAO.cerrar();
    }
}