<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>SISTI - Roles</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <style>
        * {
            box-sizing: border-box;
        }

        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background: #f4f6f8;
        }

        .container {
            width: 90%;
            max-width: 1100px;
            margin: 40px auto;
            background: white;
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.10);
        }

        h1 {
            margin-top: 0;
            color: #222;
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
            margin-right: 5px;
        }

        .btn-nuevo {
            background: #198754;
        }

        .btn-editar {
            background: #0d6efd;
        }

        .btn-eliminar {
            background: #dc3545;
        }

        .btn:hover {
            opacity: 0.85;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 12px;
            border: 1px solid #ddd;
            text-align: left;
        }

        th {
            background: #343a40;
            color: white;
        }

        tr:nth-child(even) {
            background: #f8f9fa;
        }

        .estado-activo {
            color: #198754;
            font-weight: bold;
        }

        .estado-inactivo {
            color: #dc3545;
            font-weight: bold;
        }

        .sin-registros {
            text-align: center;
            color: #777;
            padding: 20px;
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
<div class="container">

    <h1>Gestión de Roles</h1>

    <div class="acciones">
        <a href="${pageContext.request.contextPath}/roles?accion=nuevo"
           class="btn btn-nuevo">
            + Nuevo Rol
        </a>
    </div>

    <table>

        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre del Rol</th>
                <th>Descripción</th>
                <th>Estado</th>
                <th>Acciones</th>
            </tr>
        </thead>

        <tbody>

            <c:choose>

                <c:when test="${empty listaRoles}">

                    <tr>
                        <td colspan="5" class="sin-registros">
                            No existen roles registrados.
                        </td>
                    </tr>

                </c:when>

                <c:otherwise>

                    <c:forEach var="rol" items="${listaRoles}">

                        <tr>

                            <td>
                                ${rol.id_rol}
                            </td>

                            <td>
                                ${rol.nombre_rol}
                            </td>

                            <td>
                                ${rol.descripcion}
                            </td>

                            <td>

                                <c:choose>

                                    <c:when test="${rol.estado == 1}">
                                        <span class="estado-activo">
                                            Activo
                                        </span>
                                    </c:when>

                                    <c:otherwise>
                                        <span class="estado-inactivo">
                                            Inactivo
                                        </span>
                                    </c:otherwise>

                                </c:choose>

                            </td>

                            <td>

                                <a href="${pageContext.request.contextPath}/roles?accion=editar&id=${rol.id_rol}"
                                   class="btn btn-editar">
                                    Editar
                                </a>

                                <a href="${pageContext.request.contextPath}/roles?accion=eliminar&id=${rol.id_rol}"
                                   class="btn btn-eliminar"
                                   onclick="return confirm('¿Está seguro de eliminar este rol?');">
                                    Eliminar
                                </a>

                            </td>

                        </tr>

                    </c:forEach>

                </c:otherwise>

            </c:choose>

        </tbody>

    </table>

</div>

</body>
</html>