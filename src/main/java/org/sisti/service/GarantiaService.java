package org.sisti.service;

import java.util.List;

import org.sisti.dao.GarantiaDAO;
import org.sisti.model.Garantia;

public class GarantiaService {

    private GarantiaDAO garantiaDAO;

    public GarantiaService() {
        garantiaDAO = new GarantiaDAO();
    }

    public List<Garantia> listar() {
        return garantiaDAO.listar();
    }

    public Garantia buscar(int id) {
        return garantiaDAO.buscar(id);
    }

    public void registrar(Garantia garantia) {
        garantiaDAO.registrar(garantia);
    }

    public void actualizar(Garantia garantia) {
        garantiaDAO.actualizar(garantia);
    }

    public void eliminar(int id) {
        garantiaDAO.eliminar(id);
    }
}