package org.sisti.controller;

import java.io.IOException;
import java.time.LocalDate;

import org.sisti.model.Asignacion;
import org.sisti.model.Equipo;
import org.sisti.model.Usuario;
import org.sisti.service.AsignacionService;
import org.sisti.service.EquipoService;
import org.sisti.service.UsuarioService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/asignaciones")
public class AsignacionController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private AsignacionService asignacionService;
    private EquipoService equipoService;
    private UsuarioService usuarioService;

    @Override
    public void init() throws ServletException {
        asignacionService = new AsignacionService();
        equipoService = new EquipoService();
        usuarioService = new UsuarioService();
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
                "listaAsignaciones",
                asignacionService.listar()
        );

        request.getRequestDispatcher(
                "/WEB-INF/views/asignaciones/listar.jsp"
        ).forward(request, response);
    }

    private void nuevo(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute(
                "asignacion",
                new Asignacion()
        );

        request.setAttribute(
                "listaEquipos",
                equipoService.listar()
        );

        request.setAttribute(
                "listaUsuarios",
                usuarioService.listar()
        );

        request.setAttribute(
                "accion",
                "registrar"
        );

        request.getRequestDispatcher(
                "/WEB-INF/views/asignaciones/formulario.jsp"
        ).forward(request, response);
    }

    private void editar(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(
                request.getParameter("id")
        );

        Asignacion asignacion =
                asignacionService.buscar(id);

        request.setAttribute(
                "asignacion",
                asignacion
        );

        request.setAttribute(
                "listaEquipos",
                equipoService.listar()
        );

        request.setAttribute(
                "listaUsuarios",
                usuarioService.listar()
        );

        request.setAttribute(
                "accion",
                "actualizar"
        );

        request.getRequestDispatcher(
                "/WEB-INF/views/asignaciones/formulario.jsp"
        ).forward(request, response);
    }

    private void registrar(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        Asignacion asignacion = new Asignacion();

        asignacion.setFecha_asignacion(
                LocalDate.parse(
                        request.getParameter("fecha_asignacion")
                )
        );

        String fechaDevolucion =
                request.getParameter("fecha_devolucion");

        if (fechaDevolucion != null
                && !fechaDevolucion.isEmpty()) {

            asignacion.setFecha_devolucion(
                    LocalDate.parse(fechaDevolucion)
            );
        }

        asignacion.setMotivo(
                request.getParameter("motivo")
        );

        asignacion.setObservaciones(
                request.getParameter("observaciones")
        );

        asignacion.setEstado(
                request.getParameter("estado")
        );

        int idEquipo = Integer.parseInt(
                request.getParameter("id_equipo")
        );

        int idUsuario = Integer.parseInt(
                request.getParameter("id_usuario")
        );

        Equipo equipo =
                equipoService.buscar(idEquipo);

        Usuario usuario =
                usuarioService.buscar(idUsuario);

        asignacion.setEquipo(equipo);
        asignacion.setUsuario(usuario);

        asignacionService.registrar(asignacion);

        response.sendRedirect(
                request.getContextPath() + "/asignaciones"
        );
    }

    private void actualizar(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        Asignacion asignacion = new Asignacion();

        asignacion.setId_asignacion(
                Integer.parseInt(
                        request.getParameter("id_asignacion")
                )
        );

        asignacion.setFecha_asignacion(
                LocalDate.parse(
                        request.getParameter("fecha_asignacion")
                )
        );

        String fechaDevolucion =
                request.getParameter("fecha_devolucion");

        if (fechaDevolucion != null
                && !fechaDevolucion.isEmpty()) {

            asignacion.setFecha_devolucion(
                    LocalDate.parse(fechaDevolucion)
            );
        }

        asignacion.setMotivo(
                request.getParameter("motivo")
        );

        asignacion.setObservaciones(
                request.getParameter("observaciones")
        );

        asignacion.setEstado(
                request.getParameter("estado")
        );

        int idEquipo = Integer.parseInt(
                request.getParameter("id_equipo")
        );

        int idUsuario = Integer.parseInt(
                request.getParameter("id_usuario")
        );

        Equipo equipo =
                equipoService.buscar(idEquipo);

        Usuario usuario =
                usuarioService.buscar(idUsuario);

        asignacion.setEquipo(equipo);
        asignacion.setUsuario(usuario);

        asignacionService.actualizar(asignacion);

        response.sendRedirect(
                request.getContextPath() + "/asignaciones"
        );
    }

    private void eliminar(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(
                request.getParameter("id")
        );

        asignacionService.eliminar(id);

        response.sendRedirect(
                request.getContextPath() + "/asignaciones"
        );
    }
}