package org.sisti.service;

import java.util.List;

import org.sisti.dao.ProveedorDAO;
import org.sisti.model.Proveedor;

public class ProveedorService {

    private ProveedorDAO proveedorDAO;

    public ProveedorService() {
        proveedorDAO = new ProveedorDAO();
    }

    public List<Proveedor> listar() {
        return proveedorDAO.listar();
    }

    public Proveedor buscar(int id) {
        return proveedorDAO.buscar(id);
    }

    public void registrar(Proveedor proveedor) {
        proveedorDAO.registrar(proveedor);
    }

    public void actualizar(Proveedor proveedor) {
        proveedorDAO.actualizar(proveedor);
    }

    public void eliminar(int id) {
        proveedorDAO.eliminar(id);
    }

    public void cerrar() {
        proveedorDAO.cerrar();
    }
}