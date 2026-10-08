package org.sisti.service;

import java.util.List;

import org.sisti.dao.AreaDAO;
import org.sisti.model.Area;

public class AreaService {

    private AreaDAO areaDAO;

    public AreaService() {
        areaDAO = new AreaDAO();
    }

    public List<Area> listar() {
        return areaDAO.listar();
    }

    public Area buscar(int id) {
        return areaDAO.buscar(id);
    }

    public void registrar(Area area) {
        areaDAO.registrar(area);
    }

    public void actualizar(Area area) {
        areaDAO.actualizar(area);
    }

    public void eliminar(int id) {
        areaDAO.eliminar(id);
    }
}