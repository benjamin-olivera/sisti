package org.sisti.controller;

import java.io.IOException;

import org.sisti.model.Area;
import org.sisti.model.Usuario;
import org.sisti.service.AreaService;
import org.sisti.service.UsuarioService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/usuarios")
public class UsuarioController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private UsuarioService usuarioService;
    private AreaService areaService;

    @Override
    public void init() throws ServletException {
        usuarioService = new UsuarioService();
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

        request.setAttribute(
                "listaUsuarios",
                usuarioService.listar()
        );

        request.getRequestDispatcher(
                "/WEB-INF/views/usuarios/listar.jsp"
        ).forward(request, response);
    }

    private void nuevo(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute(
                "usuario",
                new Usuario()
        );

        request.setAttribute(
                "listaAreas",
                areaService.listar()
        );

        request.setAttribute(
                "accion",
                "registrar"
        );

        request.getRequestDispatcher(
                "/WEB-INF/views/usuarios/formulario.jsp"
        ).forward(request, response);
    }

    private void editar(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(
                request.getParameter("id")
        );

        Usuario usuario =
                usuarioService.buscar(id);

        request.setAttribute(
                "usuario",
                usuario
        );

        request.setAttribute(
                "listaAreas",
                areaService.listar()
        );

        request.setAttribute(
                "accion",
                "actualizar"
        );

        request.getRequestDispatcher(
                "/WEB-INF/views/usuarios/formulario.jsp"
        ).forward(request, response);
    }

    private void registrar(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        Usuario usuario = new Usuario();

        usuario.setDni(
                request.getParameter("dni")
        );

        usuario.setNombres(
                request.getParameter("nombres")
        );

        usuario.setApellidos(
                request.getParameter("apellidos")
        );

        usuario.setCorreo(
                request.getParameter("correo")
        );

        usuario.setTelefono(
                request.getParameter("telefono")
        );

        usuario.setCargo(
                request.getParameter("cargo")
        );

        usuario.setEstado(
                Integer.parseInt(
                        request.getParameter("estado")
                )
        );

        int idArea = Integer.parseInt(
                request.getParameter("id_area")
        );

        Area area = areaService.buscar(idArea);

        usuario.setArea(area);

        usuarioService.registrar(usuario);

        response.sendRedirect(
                request.getContextPath() + "/usuarios"
        );
    }

    private void actualizar(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        Usuario usuario = new Usuario();

        usuario.setId_usuario(
                Integer.parseInt(
                        request.getParameter("id_usuario")
                )
        );

        usuario.setDni(
                request.getParameter("dni")
        );

        usuario.setNombres(
                request.getParameter("nombres")
        );

        usuario.setApellidos(
                request.getParameter("apellidos")
        );

        usuario.setCorreo(
                request.getParameter("correo")
        );

        usuario.setTelefono(
                request.getParameter("telefono")
        );

        usuario.setCargo(
                request.getParameter("cargo")
        );

        usuario.setEstado(
                Integer.parseInt(
                        request.getParameter("estado")
                )
        );

        int idArea = Integer.parseInt(
                request.getParameter("id_area")
        );

        Area area = areaService.buscar(idArea);

        usuario.setArea(area);

        usuarioService.actualizar(usuario);

        response.sendRedirect(
                request.getContextPath() + "/usuarios"
        );
    }

    private void eliminar(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(
                request.getParameter("id")
        );

        usuarioService.eliminar(id);

        response.sendRedirect(
                request.getContextPath() + "/usuarios"
        );
    }
}