package org.sisti.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

import org.sisti.model.Equipo;
import org.sisti.model.Mantenimiento;
import org.sisti.service.EquipoService;
import org.sisti.service.MantenimientoService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/mantenimientos")
public class MantenimientoController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private MantenimientoService mantenimientoService;
    private EquipoService equipoService;

    @Override
    public void init() throws ServletException {
        mantenimientoService = new MantenimientoService();
        equipoService = new EquipoService();
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
                "listaMantenimientos",
                mantenimientoService.listar()
        );

        request.getRequestDispatcher(
                "/WEB-INF/views/mantenimientos/listar.jsp"
        ).forward(request, response);
    }

    private void nuevo(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute(
                "mantenimiento",
                new Mantenimiento()
        );

        request.setAttribute(
                "listaEquipos",
                equipoService.listar()
        );

        request.setAttribute(
                "accion",
                "registrar"
        );

        request.getRequestDispatcher(
                "/WEB-INF/views/mantenimientos/formulario.jsp"
        ).forward(request, response);
    }

    private void editar(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(
                request.getParameter("id")
        );

        Mantenimiento mantenimiento =
                mantenimientoService.buscar(id);

        request.setAttribute(
                "mantenimiento",
                mantenimiento
        );

        request.setAttribute(
                "listaEquipos",
                equipoService.listar()
        );

        request.setAttribute(
                "accion",
                "actualizar"
        );

        request.getRequestDispatcher(
                "/WEB-INF/views/mantenimientos/formulario.jsp"
        ).forward(request, response);
    }

    private void registrar(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        Mantenimiento mantenimiento =
                new Mantenimiento();

        String fechaInicio =
                request.getParameter("fecha_inicio");

        if (fechaInicio != null
                && !fechaInicio.isEmpty()) {

            mantenimiento.setFecha_inicio(
                    LocalDate.parse(fechaInicio)
            );
        }

        String fechaFin =
                request.getParameter("fecha_fin");

        if (fechaFin != null
                && !fechaFin.isEmpty()) {

            mantenimiento.setFecha_fin(
                    LocalDate.parse(fechaFin)
            );
        }

        mantenimiento.setTipo_mantenimiento(
                request.getParameter("tipo_mantenimiento")
        );

        mantenimiento.setProblema(
                request.getParameter("problema")
        );

        mantenimiento.setSolucion(
                request.getParameter("solucion")
        );

        mantenimiento.setTecnico_responsable(
                request.getParameter("tecnico_responsable")
        );

        String costo =
                request.getParameter("costo");

        if (costo != null && !costo.isEmpty()) {

            mantenimiento.setCosto(
                    new BigDecimal(costo)
            );
        }

        mantenimiento.setEstado(
                request.getParameter("estado")
        );

        mantenimiento.setObservaciones(
                request.getParameter("observaciones")
        );

        int idEquipo = Integer.parseInt(
                request.getParameter("id_equipo")
        );

        Equipo equipo =
                equipoService.buscar(idEquipo);

        mantenimiento.setEquipo(equipo);

        mantenimientoService.registrar(mantenimiento);

        response.sendRedirect(
                request.getContextPath() + "/mantenimientos"
        );
    }

    private void actualizar(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        Mantenimiento mantenimiento =
                new Mantenimiento();

        mantenimiento.setId_mantenimiento(
                Integer.parseInt(
                        request.getParameter("id_mantenimiento")
                )
        );

        String fechaInicio =
                request.getParameter("fecha_inicio");

        if (fechaInicio != null
                && !fechaInicio.isEmpty()) {

            mantenimiento.setFecha_inicio(
                    LocalDate.parse(fechaInicio)
            );
        }

        String fechaFin =
                request.getParameter("fecha_fin");

        if (fechaFin != null
                && !fechaFin.isEmpty()) {

            mantenimiento.setFecha_fin(
                    LocalDate.parse(fechaFin)
            );
        }

        mantenimiento.setTipo_mantenimiento(
                request.getParameter("tipo_mantenimiento")
        );

        mantenimiento.setProblema(
                request.getParameter("problema")
        );

        mantenimiento.setSolucion(
                request.getParameter("solucion")
        );

        mantenimiento.setTecnico_responsable(
                request.getParameter("tecnico_responsable")
        );

        String costo =
                request.getParameter("costo");

        if (costo != null && !costo.isEmpty()) {

            mantenimiento.setCosto(
                    new BigDecimal(costo)
            );
        }

        mantenimiento.setEstado(
                request.getParameter("estado")
        );

        mantenimiento.setObservaciones(
                request.getParameter("observaciones")
        );

        int idEquipo = Integer.parseInt(
                request.getParameter("id_equipo")
        );

        Equipo equipo =
                equipoService.buscar(idEquipo);

        mantenimiento.setEquipo(equipo);

        mantenimientoService.actualizar(mantenimiento);

        response.sendRedirect(
                request.getContextPath() + "/mantenimientos"
        );
    }

    private void eliminar(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(
                request.getParameter("id")
        );

        mantenimientoService.eliminar(id);

        response.sendRedirect(
                request.getContextPath() + "/mantenimientos"
        );
    }
}