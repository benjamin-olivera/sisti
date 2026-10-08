package org.sisti.controller;

import java.io.IOException;

import org.sisti.model.Rol;
import org.sisti.service.RolService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/roles")
public class RolController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private RolService rolService;

    @Override
    public void init() throws ServletException {
        rolService = new RolService();
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
                "listaRoles",
                rolService.listar()
        );

        request.getRequestDispatcher(
                "/WEB-INF/views/roles/listar.jsp"
        ).forward(request, response);
    }

    private void nuevo(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute(
                "rol",
                new Rol()
        );

        request.setAttribute(
                "accion",
                "registrar"
        );

        request.getRequestDispatcher(
                "/WEB-INF/views/roles/formulario.jsp"
        ).forward(request, response);
    }

    private void editar(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(
                request.getParameter("id")
        );

        Rol rol = rolService.buscar(id);

        request.setAttribute(
                "rol",
                rol
        );

        request.setAttribute(
                "accion",
                "actualizar"
        );

        request.getRequestDispatcher(
                "/WEB-INF/views/roles/formulario.jsp"
        ).forward(request, response);
    }

    private void registrar(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        Rol rol = new Rol();

        rol.setNombre_rol(
                request.getParameter("nombre_rol")
        );

        rol.setDescripcion(
                request.getParameter("descripcion")
        );

        rol.setEstado(
                Integer.parseInt(
                        request.getParameter("estado")
                )
        );

        rolService.registrar(rol);

        response.sendRedirect(
                request.getContextPath() + "/roles"
        );
    }

    private void actualizar(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        Rol rol = new Rol();

        rol.setId_rol(
                Integer.parseInt(
                        request.getParameter("id_rol")
                )
        );

        rol.setNombre_rol(
                request.getParameter("nombre_rol")
        );

        rol.setDescripcion(
                request.getParameter("descripcion")
        );

        rol.setEstado(
                Integer.parseInt(
                        request.getParameter("estado")
                )
        );

        rolService.actualizar(rol);

        response.sendRedirect(
                request.getContextPath() + "/roles"
        );
    }

    private void eliminar(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(
                request.getParameter("id")
        );

        rolService.eliminar(id);

        response.sendRedirect(
                request.getContextPath() + "/roles"
        );
    }
}