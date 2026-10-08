<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="es">

<head>

    <meta charset="UTF-8">

    <title>SISTI - Asignaciones</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <style>

        * {
            box-sizing: border-box;
        }

        body {
            margin: 0;
            padding: 30px;
            font-family: Arial, sans-serif;
            background-color: #f4f6f8;
        }

        .contenedor {
            max-width: 1200px;
            margin: auto;
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.10);
        }

        h1 {
            margin-top: 0;
            color: #222;
        }

        .boton-nuevo {
            display: inline-block;
            padding: 10px 18px;
            margin-bottom: 20px;
            background-color: #198754;
            color: white;
            text-decoration: none;
            border-radius: 6px;
        }

        .boton-nuevo:hover {
            background-color: #157347;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th,
        td {
            padding: 12px;
            border: 1px solid #ddd;
            text-align: left;
        }

        th {
            background-color: #212529;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f8f9fa;
        }

        .editar {
            color: #0d6efd;
            text-decoration: none;
            margin-right: 10px;
        }

        .eliminar {
            color: #dc3545;
            text-decoration: none;
        }

        .editar:hover,
        .eliminar:hover {
            text-decoration: underline;
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
    background: #0d6efd;
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
    background: #0b5ed7;
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

    <h1>Asignaciones</h1>

    <a href="${pageContext.request.contextPath}/asignaciones?accion=nuevo"
       class="boton-nuevo">
        + Nueva Asignación
    </a>

    <table>

        <thead>

            <tr>

                <th>ID</th>
                <th>Fecha Asignación</th>
                <th>Fecha Devolución</th>
                <th>Motivo</th>
                <th>Observaciones</th>
                <th>Estado</th>
                <th>Equipo</th>
                <th>Usuario</th>
                <th>Acciones</th>

            </tr>

        </thead>

        <tbody>

            <c:forEach var="asignacion"
                       items="${listaAsignaciones}">

                <tr>

                    <td>
                        ${asignacion.id_asignacion}
                    </td>

                    <td>
                        ${asignacion.fecha_asignacion}
                    </td>

                    <td>
                        ${asignacion.fecha_devolucion}
                    </td>

                    <td>
                        ${asignacion.motivo}
                    </td>

                    <td>
                        ${asignacion.observaciones}
                    </td>

                    <td>
                        ${asignacion.estado}
                    </td>

                    <td>
                        ${asignacion.equipo.codigo_inventario}
                        - ${asignacion.equipo.modelo}
                    </td>

                    <td>
                        ${asignacion.usuario.nombres}
                        ${asignacion.usuario.apellidos}
                    </td>

                    <td>

                        <a class="editar"
                           href="${pageContext.request.contextPath}/asignaciones?accion=editar&id=${asignacion.id_asignacion}">
                            Editar
                        </a>

                        <a class="eliminar"
                           href="${pageContext.request.contextPath}/asignaciones?accion=eliminar&id=${asignacion.id_asignacion}"
                           onclick="return confirm('¿Está seguro de eliminar esta asignación?');">
                            Eliminar
                        </a>

                    </td>

                </tr>

            </c:forEach>

        </tbody>

    </table>

</div>

</body>

</html>