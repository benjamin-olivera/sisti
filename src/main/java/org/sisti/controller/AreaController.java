package org.sisti.controller;

import java.io.IOException;
import java.util.List;

import org.sisti.model.Area;
import org.sisti.service.AreaService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/areas")
public class AreaController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private AreaService areaService;

    @Override
    public void init() throws ServletException {
        areaService = new AreaService();
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

        List<Area> lista = areaService.listar();

        request.setAttribute("listaAreas", lista);

        request.getRequestDispatcher(
                "/WEB-INF/views/areas/listar.jsp"
        ).forward(request, response);
    }

    private void nuevo(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        Area area = new Area();

        request.setAttribute("area", area);

        request.getRequestDispatcher(
                "/WEB-INF/views/areas/formulario.jsp"
        ).forward(request, response);
    }

    private void editar(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(
                request.getParameter("id")
        );

        Area area = areaService.buscar(id);

        request.setAttribute("area", area);

        request.getRequestDispatcher(
                "/WEB-INF/views/areas/formulario.jsp"
        ).forward(request, response);
    }

    private void registrar(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        Area area = new Area();

        area.setNombre_area(
                request.getParameter("nombre_area")
        );

        area.setDescripcion(
                request.getParameter("descripcion")
        );

        area.setEstado(
                Integer.parseInt(
                        request.getParameter("estado")
                )
        );

        areaService.registrar(area);

        response.sendRedirect(
                request.getContextPath() + "/areas"
        );
    }

    private void actualizar(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        Area area = new Area();

        area.setId_area(
                Integer.parseInt(
                        request.getParameter("id_area")
                )
        );

        area.setNombre_area(
                request.getParameter("nombre_area")
        );

        area.setDescripcion(
                request.getParameter("descripcion")
        );

        area.setEstado(
                Integer.parseInt(
                        request.getParameter("estado")
                )
        );

        areaService.actualizar(area);

        response.sendRedirect(
                request.getContextPath() + "/areas"
        );
    }

    private void eliminar(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(
                request.getParameter("id")
        );

        areaService.eliminar(id);

        response.sendRedirect(
                request.getContextPath() + "/areas"
        );
    }
}