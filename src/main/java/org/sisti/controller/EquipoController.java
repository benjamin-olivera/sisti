package org.sisti.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

import org.sisti.model.Equipo;
import org.sisti.service.EquipoService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/equipos")
public class EquipoController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private EquipoService equipoService;

    @Override
    public void init() throws ServletException {
        equipoService = new EquipoService();
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
                        "equipos",
                        equipoService.listar()
                );

                request.getRequestDispatcher(
                        "/WEB-INF/views/equipos/listar.jsp"
                ).forward(request, response);

                break;

            // ==============================
            // NUEVO
            // ==============================

            case "nuevo":

                request.getRequestDispatcher(
                        "/WEB-INF/views/equipos/formulario.jsp"
                ).forward(request, response);

                break;

            // ==============================
            // EDITAR
            // ==============================

            case "editar":

                int idEditar = Integer.parseInt(
                        request.getParameter("id")
                );

                System.out.println("==============================");
                System.out.println("EDITANDO EQUIPO");
                System.out.println("ID recibido: " + idEditar);

                Equipo equipoEditar =
                        equipoService.buscar(idEditar);

                System.out.println("Equipo encontrado: " + equipoEditar);
                System.out.println("==============================");

                request.setAttribute(
                        "equipo",
                        equipoEditar
                );

                request.getRequestDispatcher(
                        "/WEB-INF/views/equipos/formulario.jsp"
                ).forward(request, response);

                break;

            // ==============================
            // ELIMINAR
            // ==============================

            case "eliminar":

                int idEliminar = Integer.parseInt(
                        request.getParameter("id")
                );

                equipoService.eliminar(idEliminar);

                response.sendRedirect(
                        request.getContextPath() + "/equipos"
                );

                break;

            // ==============================
            // ACCIÓN DESCONOCIDA
            // ==============================

            default:

                response.sendRedirect(
                        request.getContextPath() + "/equipos"
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
        // GUARDAR / ACTUALIZAR
        // ==========================================

        if ("guardar".equals(accion)) {

            String id = request.getParameter("id");

            Equipo equipo;

            // ======================================
            // SI TIENE ID → ACTUALIZAR
            // SI NO TIENE ID → NUEVO
            // ======================================

            if (id != null && !id.isEmpty()) {

                int idEquipo = Integer.parseInt(id);

                equipo = equipoService.buscar(idEquipo);

                if (equipo == null) {

                    response.sendRedirect(
                            request.getContextPath() + "/equipos"
                    );

                    return;
                }

            } else {

                equipo = new Equipo();
            }

            // ==========================================
            // DATOS DEL EQUIPO
            // ==========================================

            equipo.setCodigo_inventario(
                    request.getParameter("codigo_inventario")
            );

            equipo.setModelo(
                    request.getParameter("modelo")
            );

            equipo.setNumero_serie(
                    request.getParameter("numero_serie")
            );

            equipo.setProcesador(
                    request.getParameter("procesador")
            );

            equipo.setRam(
                    request.getParameter("ram")
            );

            equipo.setAlmacenamiento(
                    request.getParameter("almacenamiento")
            );

            equipo.setSistema_operativo(
                    request.getParameter("sistema_operativo")
            );

            equipo.setHostname(
                    request.getParameter("hostname")
            );

            // ==========================================
            // FECHA
            // ==========================================

            String fecha =
                    request.getParameter("fecha_adquisicion");

            if (fecha != null && !fecha.isEmpty()) {

                equipo.setFecha_adquisicion(
                        LocalDate.parse(fecha)
                );

            } else {

                equipo.setFecha_adquisicion(null);
            }

            // ==========================================
            // PRECIO
            // ==========================================

            String precio =
                    request.getParameter("precio_adquisicion");

            if (precio != null && !precio.isEmpty()) {

                equipo.setPrecio_adquisicion(
                        new BigDecimal(precio)
                );

            } else {

                equipo.setPrecio_adquisicion(null);
            }

            // ==========================================
            // ESTADO
            // ==========================================

            equipo.setEstado_equipo(
                    request.getParameter("estado_equipo")
            );

            // ==========================================
            // OBSERVACIONES
            // ==========================================

            equipo.setObservaciones(
                    request.getParameter("observaciones")
            );

            // ==========================================
            // GUARDAR O ACTUALIZAR
            // ==========================================

            if (id != null && !id.isEmpty()) {

                equipoService.actualizar(equipo);

            } else {

                equipoService.registrar(equipo);
            }

            // ==========================================
            // VOLVER A LA LISTA
            // ==========================================

            response.sendRedirect(
                    request.getContextPath() + "/equipos"
            );
        }
    }

    // ==========================================
    // DESTROY
    // ==========================================

    @Override
    public void destroy() {

        if (equipoService != null) {
            equipoService.cerrar();
        }

        super.destroy();
    }
}