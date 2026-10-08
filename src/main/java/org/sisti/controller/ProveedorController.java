package org.sisti.controller;

import java.io.IOException;

import org.sisti.model.Proveedor;
import org.sisti.service.ProveedorService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/proveedores")
public class ProveedorController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private ProveedorService proveedorService;

    @Override
    public void init() throws ServletException {
        proveedorService = new ProveedorService();
    }

    // ==========================================
    // GET
    // ==========================================

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion == null) {
            accion = "listar";
        }

        switch (accion) {

            // ==============================
            // LISTAR
            // ==============================

            case "listar":

                request.setAttribute(
                        "proveedores",
                        proveedorService.listar()
                );

                request.getRequestDispatcher(
                        "/WEB-INF/views/proveedores/listar.jsp"
                ).forward(request, response);

                break;

            // ==============================
            // NUEVO
            // ==============================

            case "nuevo":

                request.getRequestDispatcher(
                        "/WEB-INF/views/proveedores/formulario.jsp"
                ).forward(request, response);

                break;

            // ==============================
            // EDITAR
            // ==============================

            case "editar":

                int idEditar = Integer.parseInt(
                        request.getParameter("id")
                );

                Proveedor proveedorEditar =
                        proveedorService.buscar(idEditar);

                request.setAttribute(
                        "proveedor",
                        proveedorEditar
                );

                request.getRequestDispatcher(
                        "/WEB-INF/views/proveedores/formulario.jsp"
                ).forward(request, response);

                break;

            // ==============================
            // ELIMINAR
            // ==============================

            case "eliminar":

                int idEliminar = Integer.parseInt(
                        request.getParameter("id")
                );

                proveedorService.eliminar(idEliminar);

                response.sendRedirect(
                        request.getContextPath() + "/proveedores"
                );

                break;

            // ==============================
            // ACCIÓN DESCONOCIDA
            // ==============================

            default:

                response.sendRedirect(
                        request.getContextPath() + "/proveedores"
                );

                break;
        }
    }

    // ==========================================
    // POST
    // ==========================================

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String accion = request.getParameter("accion");

        // ==========================================
        // GUARDAR
        // ==========================================

        if ("guardar".equals(accion)) {

            String id = request.getParameter("id");

            Proveedor proveedor;

            // ======================================
            // ACTUALIZAR
            // ======================================

            if (id != null && !id.isEmpty()) {

                int idProveedor = Integer.parseInt(id);

                proveedor =
                        proveedorService.buscar(idProveedor);

                if (proveedor == null) {

                    response.sendRedirect(
                            request.getContextPath() + "/proveedores"
                    );

                    return;
                }

            } else {

                // ==================================
                // NUEVO
                // ==================================

                proveedor = new Proveedor();
            }

            // ==========================================
            // DATOS DEL PROVEEDOR
            // ==========================================

            proveedor.setRazon_social(
                    request.getParameter("razon_social")
            );

            proveedor.setRuc(
                    request.getParameter("ruc")
            );

            proveedor.setTelefono(
                    request.getParameter("telefono")
            );

            proveedor.setCorreo(
                    request.getParameter("correo")
            );

            proveedor.setDireccion(
                    request.getParameter("direccion")
            );

            // ==========================================
            // ESTADO
            // ==========================================

            String estado =
                    request.getParameter("estado");

            if (estado != null && !estado.isEmpty()) {

                proveedor.setEstado(
                        Integer.parseInt(estado)
                );

            } else {

                proveedor.setEstado(1);
            }

            // ==========================================
            // GUARDAR O ACTUALIZAR
            // ==========================================

            if (id != null && !id.isEmpty()) {

                proveedorService.actualizar(proveedor);

            } else {

                proveedorService.registrar(proveedor);
            }

            // ==========================================
            // VOLVER A LISTAR
            // ==========================================

            response.sendRedirect(
                    request.getContextPath() + "/proveedores"
            );
        }
    }

    // ==========================================
    // DESTROY
    // ==========================================

    @Override
    public void destroy() {

        if (proveedorService != null) {
            proveedorService.cerrar();
        }

        super.destroy();
    }
}