package org.sisti.controller;

import java.io.IOException;

import org.sisti.model.Rol;
import org.sisti.model.UsuarioSistema;
import org.sisti.service.RolService;
import org.sisti.service.UsuarioSistemaService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/usuarios-sistema")
public class UsuarioSistemaController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private UsuarioSistemaService usuarioSistemaService;
    private RolService rolService;

    @Override
    public void init() throws ServletException {
        usuarioSistemaService = new UsuarioSistemaService();
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
                "listaUsuariosSistema",
                usuarioSistemaService.listar()
        );

        request.getRequestDispatcher(
                "/WEB-INF/views/sistema/listar.jsp"
        ).forward(request, response);
    }

    private void nuevo(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute(
                "usuarioSistema",
                new UsuarioSistema()
        );

        request.setAttribute(
                "listaRoles",
                rolService.listar()
        );

        request.setAttribute(
                "accion",
                "registrar"
        );

        request.getRequestDispatcher(
                "/WEB-INF/views/sistema/formulario.jsp"
        ).forward(request, response);
    }

    private void editar(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(
                request.getParameter("id")
        );

        UsuarioSistema usuarioSistema =
                usuarioSistemaService.buscar(id);

        request.setAttribute(
                "usuarioSistema",
                usuarioSistema
        );

        request.setAttribute(
                "listaRoles",
                rolService.listar()
        );

        request.setAttribute(
                "accion",
                "actualizar"
        );

        request.getRequestDispatcher(
                "/WEB-INF/views/sistema/formulario.jsp"
        ).forward(request, response);
    }

    private void registrar(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        UsuarioSistema usuarioSistema =
                new UsuarioSistema();

        usuarioSistema.setUsername(
                request.getParameter("username")
        );

        usuarioSistema.setPassword(
                request.getParameter("password")
        );

        usuarioSistema.setNombres(
                request.getParameter("nombres")
        );

        usuarioSistema.setApellidos(
                request.getParameter("apellidos")
        );

        usuarioSistema.setCorreo(
                request.getParameter("correo")
        );

        usuarioSistema.setEstado(
                Integer.parseInt(
                        request.getParameter("estado")
                )
        );

        int idRol = Integer.parseInt(
                request.getParameter("id_rol")
        );

        Rol rol = rolService.buscar(idRol);

        usuarioSistema.setRol(rol);

        usuarioSistemaService.registrar(
                usuarioSistema
        );

        response.sendRedirect(
                request.getContextPath()
                        + "/usuarios-sistema"
        );
    }

    private void actualizar(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        UsuarioSistema usuarioSistema =
                new UsuarioSistema();

        usuarioSistema.setId_usuario_sistema(
                Integer.parseInt(
                        request.getParameter(
                                "id_usuario_sistema"
                        )
                )
        );

        usuarioSistema.setUsername(
                request.getParameter("username")
        );

        usuarioSistema.setPassword(
                request.getParameter("password")
        );

        usuarioSistema.setNombres(
                request.getParameter("nombres")
        );

        usuarioSistema.setApellidos(
                request.getParameter("apellidos")
        );

        usuarioSistema.setCorreo(
                request.getParameter("correo")
        );

        usuarioSistema.setEstado(
                Integer.parseInt(
                        request.getParameter("estado")
                )
        );

        int idRol = Integer.parseInt(
                request.getParameter("id_rol")
        );

        Rol rol = rolService.buscar(idRol);

        usuarioSistema.setRol(rol);

        usuarioSistemaService.actualizar(
                usuarioSistema
        );

        response.sendRedirect(
                request.getContextPath()
                        + "/usuarios-sistema"
        );
    }

    private void eliminar(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(
                request.getParameter("id")
        );

        usuarioSistemaService.eliminar(id);

        response.sendRedirect(
                request.getContextPath()
                        + "/usuarios-sistema"
        );
    }
}