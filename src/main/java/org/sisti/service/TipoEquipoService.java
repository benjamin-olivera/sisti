package org.sisti.service;

import java.util.List;

import org.sisti.dao.TipoEquipoDAO;
import org.sisti.model.TipoEquipo;

public class TipoEquipoService {

    private TipoEquipoDAO tipoEquipoDAO;

    public TipoEquipoService() {
        tipoEquipoDAO = new TipoEquipoDAO();
    }

    public List<TipoEquipo> listar() {
        return tipoEquipoDAO.listar();
    }

    public TipoEquipo buscar(int id) {
        return tipoEquipoDAO.buscar(id);
    }

    public void registrar(TipoEquipo tipoEquipo) {
        tipoEquipoDAO.registrar(tipoEquipo);
    }

    public void actualizar(TipoEquipo tipoEquipo) {
        tipoEquipoDAO.actualizar(tipoEquipo);
    }

    public void eliminar(int id) {
        tipoEquipoDAO.eliminar(id);
    }
}