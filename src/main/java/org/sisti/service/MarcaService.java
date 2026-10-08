package org.sisti.service;

import java.util.List;

import org.sisti.dao.MarcaDAO;
import org.sisti.model.Marca;

public class MarcaService {

    private MarcaDAO marcaDAO;

    public MarcaService() {
        marcaDAO = new MarcaDAO();
    }

    public List<Marca> listar() {
        return marcaDAO.listar();
    }

    public Marca buscar(int id) {
        return marcaDAO.buscar(id);
    }

    public void registrar(Marca marca) {
        marcaDAO.registrar(marca);
    }

    public void actualizar(Marca marca) {
        marcaDAO.actualizar(marca);
    }

    public void eliminar(int id) {
        marcaDAO.eliminar(id);
    }
}