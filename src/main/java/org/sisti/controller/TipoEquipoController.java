package org.sisti.controller;

import java.io.IOException;

import org.sisti.model.TipoEquipo;
import org.sisti.service.TipoEquipoService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/tipos")
public class TipoEquipoController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private TipoEquipoService tipoEquipoService;

    @Override
    public void init() throws ServletException {
        tipoEquipoService = new TipoEquipoService();
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
                "listaTipos",
                tipoEquipoService.listar()
        );

        request.getRequestDispatcher(
                "/WEB-INF/views/tipos/listar.jsp"
        ).forward(request, response);
    }

    private void nuevo(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute(
                "tipoEquipo",
                new TipoEquipo()
        );

        request.setAttribute("accion", "registrar");

        request.getRequestDispatcher(
                "/WEB-INF/views/tipos/formulario.jsp"
        ).forward(request, response);
    }

    private void editar(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(
                request.getParameter("id")
        );

        TipoEquipo tipoEquipo =
                tipoEquipoService.buscar(id);

        request.setAttribute(
                "tipoEquipo",
                tipoEquipo
        );

        request.setAttribute("accion", "actualizar");

        request.getRequestDispatcher(
                "/WEB-INF/views/tipos/formulario.jsp"
        ).forward(request, response);
    }

    private void registrar(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        TipoEquipo tipoEquipo = new TipoEquipo();

        tipoEquipo.setNombre_tipo(
                request.getParameter("nombre_tipo")
        );

        tipoEquipo.setDescripcion(
                request.getParameter("descripcion")
        );

        tipoEquipo.setEstado(
                Integer.parseInt(
                        request.getParameter("estado")
                )
        );

        tipoEquipoService.registrar(tipoEquipo);

        response.sendRedirect(
                request.getContextPath() + "/tipos"
        );
    }

    private void actualizar(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        TipoEquipo tipoEquipo = new TipoEquipo();

        tipoEquipo.setId_tipo(
                Integer.parseInt(
                        request.getParameter("id_tipo")
                )
        );

        tipoEquipo.setNombre_tipo(
                request.getParameter("nombre_tipo")
        );

        tipoEquipo.setDescripcion(
                request.getParameter("descripcion")
        );

        tipoEquipo.setEstado(
                Integer.parseInt(
                        request.getParameter("estado")
                )
        );

        tipoEquipoService.actualizar(tipoEquipo);

        response.sendRedirect(
                request.getContextPath() + "/tipos"
        );
    }

    private void eliminar(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(
                request.getParameter("id")
        );

        tipoEquipoService.eliminar(id);

        response.sendRedirect(
                request.getContextPath() + "/tipos"
        );
    }
}