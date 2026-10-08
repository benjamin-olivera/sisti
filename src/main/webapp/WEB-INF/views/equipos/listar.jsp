<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="es">

<head>

    <meta charset="UTF-8">

    <title>SISTI - Equipos TI</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <style>

        * {
            box-sizing: border-box;
        }

        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background: #f4f6f8;
            color: #222;
        }

        .contenedor {
            width: 95%;
            max-width: 1400px;
            margin: 30px auto;
        }

        .encabezado {
            background: #1f2937;
            color: white;
            padding: 25px;
            border-radius: 10px 10px 0 0;
        }

        .encabezado h1 {
            margin: 0 0 8px 0;
        }

        .encabezado p {
            margin: 0;
            color: #d1d5db;
        }

        .contenido {
            background: white;
            padding: 25px;
            border-radius: 0 0 10px 10px;
            box-shadow: 0 3px 10px rgba(0,0,0,0.08);
            overflow-x: auto;
        }

        .acciones {
            margin-bottom: 20px;
        }

        .btn {
            display: inline-block;
            padding: 10px 16px;
            text-decoration: none;
            border-radius: 6px;
            color: white;
            background: #2563eb;
        }

        .tabla {
            width: 100%;
            border-collapse: collapse;
            min-width: 1100px;
        }

        .tabla th,
        .tabla td {
            padding: 12px 10px;
            border-bottom: 1px solid #ddd;
            text-align: left;
            white-space: nowrap;
        }

        .tabla th {
            background: #f1f5f9;
            font-weight: bold;
        }

        .tabla tr:hover {
            background: #f8fafc;
        }

        .estado {
            padding: 5px 9px;
            border-radius: 15px;
            font-size: 12px;
            font-weight: bold;
        }

        .disponible {
            background: #dcfce7;
            color: #166534;
        }

        .asignado {
            background: #dbeafe;
            color: #1e40af;
        }

        .mantenimiento {
            background: #fef3c7;
            color: #92400e;
        }

        .baja {
            background: #fee2e2;
            color: #991b1b;
        }

        .acciones-tabla a {
            text-decoration: none;
            margin-right: 8px;
        }

        .editar {
            color: #2563eb;
        }

        .eliminar {
            color: #dc2626;
        }

        .mensaje {
            padding: 20px;
            text-align: center;
            color: #666;
        }
        
        .btn-menu {
    position: fixed;
    top: 20px;
    left: 20px;
    width: 42px;
    height: 42px;
    display: flex;
    align-items: center;
    justify-content: center;
    background: #343a40;
    color: white;
    text-decoration: none;
    border-radius: 50%;
    font-size: 24px;
    font-weight: bold;
    z-index: 1000;
    box-shadow: 0 3px 8px rgba(0,0,0,0.2);
    transition: 0.2s;
}

.btn-menu:hover {
    transform: scale(1.08);
    background: #0d6efd;
}

    </style>

</head>

<body>
<a href="${pageContext.request.contextPath}/"
   class="btn-menu"
   title="Menú principal">
    ←
</a>
<div class="contenedor">

    <div class="encabezado">

        <h1>SISTI</h1>

        <p>Sistema de Inventario de Equipos TI</p>

    </div>

    <div class="contenido">

        <div class="acciones">

            <a href="${pageContext.request.contextPath}/equipos?accion=nuevo"
               class="btn">
                + Registrar equipo
            </a>

        </div>

        <%
            java.util.List equipos =
                    (java.util.List) request.getAttribute("equipos");
        %>

        <% if (equipos == null || equipos.isEmpty()) { %>

            <div class="mensaje">
                No existen equipos registrados.
            </div>

        <% } else { %>

            <table class="tabla">

                <thead>

                    <tr>
                        <th>ID</th>
                        <th>Código</th>
                        <th>Modelo</th>
                        <th>N.º Serie</th>
                        <th>Procesador</th>
                        <th>RAM</th>
                        <th>Almacenamiento</th>
                        <th>Sistema Operativo</th>
                        <th>Hostname</th>
                        <th>Fecha Adquisición</th>
                        <th>Precio</th>
                        <th>Estado</th>
                        <th>Observaciones</th>
                        <th>Acciones</th>
                    </tr>

                </thead>

                <tbody>

                <% for (Object obj : equipos) {

                    org.sisti.model.Equipo equipo =
                            (org.sisti.model.Equipo) obj;
                %>

                    <tr>

                        <td>
                            <%= equipo.getId_equipo() %>
                        </td>

                        <td>
                            <%= equipo.getCodigo_inventario() %>
                        </td>

                        <td>
                            <%= equipo.getModelo() %>
                        </td>

                        <td>
                            <%= equipo.getNumero_serie() %>
                        </td>

                        <td>
                            <%= equipo.getProcesador() %>
                        </td>

                        <td>
                            <%= equipo.getRam() %>
                        </td>

                        <td>
                            <%= equipo.getAlmacenamiento() %>
                        </td>

                        <td>
                            <%= equipo.getSistema_operativo() %>
                        </td>

                        <td>
                            <%= equipo.getHostname() %>
                        </td>

                        <td>
                            <%= equipo.getFecha_adquisicion() %>
                        </td>

                        <td>
                            S/ <%= equipo.getPrecio_adquisicion() %>
                        </td>

                        <td>

                            <span class="estado
                                <%= equipo.getEstado_equipo()
                                    .toLowerCase()
                                    .replace("ó", "o") %>">

                                <%= equipo.getEstado_equipo() %>

                            </span>

                        </td>

                        <td>
                            <%= equipo.getObservaciones() %>
                        </td>

                        <td class="acciones-tabla">
                                                

                            <a class="editar"
                               href="${pageContext.request.contextPath}/equipos?accion=editar&id=<%= equipo.getId_equipo() %>">
                                Editar
                            </a>

                            <a class="eliminar"
                               href="${pageContext.request.contextPath}/equipos?accion=eliminar&id=<%= equipo.getId_equipo() %>"
                               onclick="return confirm('¿Está seguro de eliminar este equipo?');">
                                Eliminar
                            </a>

                        </td>

                    </tr>

                <% } %>

                </tbody>

            </table>

        <% } %>

    </div>

</div>

</body>

</html>