package org.sisti.controller;

import java.io.IOException;
import java.time.LocalDate;

import org.sisti.model.Equipo;
import org.sisti.model.Garantia;
import org.sisti.model.Proveedor;
import org.sisti.service.EquipoService;
import org.sisti.service.GarantiaService;
import org.sisti.service.ProveedorService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/garantias")
public class GarantiaController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private GarantiaService garantiaService;
    private EquipoService equipoService;
    private ProveedorService proveedorService;

    @Override
    public void init() throws ServletException {
        garantiaService = new GarantiaService();
        equipoService = new EquipoService();
        proveedorService = new ProveedorService();
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion == null) {
            listar(request, response);

        } else if (accion.equals("nuevo")) {
            nuevo(request, response);

        } else if (accion.equals("editar")) {
            editar(request, response);

        } else if (accion.equals("eliminar")) {
            eliminar(request, response);

        } else {
            listar(request, response);
        }
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String accion = request.getParameter("accion");

        if ("registrar".equals(accion)) {
            registrar(request, response);

        } else if ("actualizar".equals(accion)) {
            actualizar(request, response);

        } else {
            listar(request, response);
        }
    }

    private void listar(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute(
                "listaGarantias",
                garantiaService.listar()
        );

        request.getRequestDispatcher(
                "/WEB-INF/views/garantias/listar.jsp"
        ).forward(request, response);
    }

    private void nuevo(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute(
                "garantia",
                new Garantia()
        );

        request.setAttribute(
                "listaEquipos",
                equipoService.listar()
        );

        request.setAttribute(
                "listaProveedores",
                proveedorService.listar()
        );

        request.setAttribute(
                "accion",
                "registrar"
        );

        request.getRequestDispatcher(
                "/WEB-INF/views/garantias/formulario.jsp"
        ).forward(request, response);
    }

    private void editar(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(
                request.getParameter("id")
        );

        Garantia garantia =
                garantiaService.buscar(id);

        request.setAttribute(
                "garantia",
                garantia
        );

        request.setAttribute(
                "listaEquipos",
                equipoService.listar()
        );

        request.setAttribute(
                "listaProveedores",
                proveedorService.listar()
        );

        request.setAttribute(
                "accion",
                "actualizar"
        );

        request.getRequestDispatcher(
                "/WEB-INF/views/garantias/formulario.jsp"
        ).forward(request, response);
    }

    private void registrar(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        Garantia garantia = new Garantia();

        String fechaInicio =
                request.getParameter("fecha_inicio");

        String fechaFin =
                request.getParameter("fecha_fin");

        garantia.setFecha_inicio(
                LocalDate.parse(fechaInicio)
        );

        garantia.setFecha_fin(
                LocalDate.parse(fechaFin)
        );

        garantia.setCondiciones(
                request.getParameter("condiciones")
        );

        garantia.setEstado(
                request.getParameter("estado")
        );

        int idEquipo = Integer.parseInt(
                request.getParameter("id_equipo")
        );

        int idProveedor = Integer.parseInt(
                request.getParameter("id_proveedor")
        );

        Equipo equipo =
                equipoService.buscar(idEquipo);

        Proveedor proveedor =
                proveedorService.buscar(idProveedor);

        garantia.setEquipo(equipo);
        garantia.setProveedor(proveedor);

        garantiaService.registrar(garantia);

        response.sendRedirect(
                request.getContextPath() + "/garantias"
        );
    }

    private void actualizar(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        Garantia garantia = new Garantia();

        garantia.setId_garantia(
                Integer.parseInt(
                        request.getParameter("id_garantia")
                )
        );

        String fechaInicio =
                request.getParameter("fecha_inicio");

        String fechaFin =
                request.getParameter("fecha_fin");

        garantia.setFecha_inicio(
                LocalDate.parse(fechaInicio)
        );

        garantia.setFecha_fin(
                LocalDate.parse(fechaFin)
        );

        garantia.setCondiciones(
                request.getParameter("condiciones")
        );

        garantia.setEstado(
                request.getParameter("estado")
        );

        int idEquipo = Integer.parseInt(
                request.getParameter("id_equipo")
        );

        int idProveedor = Integer.parseInt(
                request.getParameter("id_proveedor")
        );

        Equipo equipo =
                equipoService.buscar(idEquipo);

        Proveedor proveedor =
                proveedorService.buscar(idProveedor);

        garantia.setEquipo(equipo);
        garantia.setProveedor(proveedor);

        garantiaService.actualizar(garantia);

        response.sendRedirect(
                request.getContextPath() + "/garantias"
        );
    }

    private void eliminar(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(
                request.getParameter("id")
        );

        garantiaService.eliminar(id);

        response.sendRedirect(
                request.getContextPath() + "/garantias"
        );
    }
}