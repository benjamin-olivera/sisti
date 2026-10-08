package org.sisti.controller;

import java.io.IOException;
import java.util.List;

import org.sisti.model.Marca;
import org.sisti.service.MarcaService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/marcas")
public class MarcaController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private MarcaService marcaService;

    @Override
    public void init() throws ServletException {
        marcaService = new MarcaService();
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

        List<Marca> lista = marcaService.listar();

        request.setAttribute("listaMarcas", lista);

        request.getRequestDispatcher(
                "/WEB-INF/views/marcas/listar.jsp"
        ).forward(request, response);
    }

    private void nuevo(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        Marca marca = new Marca();

        request.setAttribute("marca", marca);

        request.getRequestDispatcher(
                "/WEB-INF/views/marcas/formulario.jsp"
        ).forward(request, response);
    }

    private void editar(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(
                request.getParameter("id")
        );

        Marca marca = marcaService.buscar(id);

        request.setAttribute("marca", marca);

        request.getRequestDispatcher(
                "/WEB-INF/views/marcas/formulario.jsp"
        ).forward(request, response);
    }

    private void registrar(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        Marca marca = new Marca();

        marca.setNombre_marca(
                request.getParameter("nombre_marca")
        );

        marca.setEstado(
                Integer.parseInt(
                        request.getParameter("estado")
                )
        );

        marcaService.registrar(marca);

        response.sendRedirect(
                request.getContextPath() + "/marcas"
        );
    }

    private void actualizar(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        Marca marca = new Marca();

        marca.setId_marca(
                Integer.parseInt(
                        request.getParameter("id_marca")
                )
        );

        marca.setNombre_marca(
                request.getParameter("nombre_marca")
        );

        marca.setEstado(
                Integer.parseInt(
                        request.getParameter("estado")
                )
        );

        marcaService.actualizar(marca);

        response.sendRedirect(
                request.getContextPath() + "/marcas"
        );
    }

    private void eliminar(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(
                request.getParameter("id")
        );

        marcaService.eliminar(id);

        response.sendRedirect(
                request.getContextPath() + "/marcas"
        );
    }
}