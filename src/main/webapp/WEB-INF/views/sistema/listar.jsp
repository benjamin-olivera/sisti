<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">

    <title>SISTI - Usuarios del Sistema</title>

    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

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
            width: 95%;
            max-width: 1200px;
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
            padding: 9px 14px;
            text-decoration: none;
            border-radius: 6px;
            color: white;
            margin-right: 5px;
            font-size: 14px;
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

        th,
        td {
            padding: 11px;
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

    <h1>Usuarios del Sistema</h1>

    <div class="acciones">

        <a href="${pageContext.request.contextPath}/usuarios-sistema?accion=nuevo"
           class="btn btn-nuevo">
            + Nuevo Usuario
        </a>

    </div>

    <table>

        <thead>

        <tr>

            <th>ID</th>

            <th>Username</th>

            <th>Nombres</th>

            <th>Apellidos</th>

            <th>Correo</th>

            <th>Rol</th>

            <th>Estado</th>

            <th>Acciones</th>

        </tr>

        </thead>

        <tbody>

        <c:choose>

            <c:when test="${empty listaUsuariosSistema}">

                <tr>

                    <td colspan="8"
                        class="sin-registros">

                        No existen usuarios del sistema registrados.

                    </td>

                </tr>

            </c:when>

            <c:otherwise>

                <c:forEach var="usuario"
                           items="${listaUsuariosSistema}">

                    <tr>

                        <td>
                            ${usuario.id_usuario_sistema}
                        </td>

                        <td>
                            ${usuario.username}
                        </td>

                        <td>
                            ${usuario.nombres}
                        </td>

                        <td>
                            ${usuario.apellidos}
                        </td>

                        <td>
                            ${usuario.correo}
                        </td>

                        <td>
                            ${usuario.rol.nombre_rol}
                        </td>

                        <td>

                            <c:choose>

                                <c:when test="${usuario.estado == 1}">

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

                            <a href="${pageContext.request.contextPath}/usuarios-sistema?accion=editar&id=${usuario.id_usuario_sistema}"
                               class="btn btn-editar">
                                Editar
                            </a>

                            <a href="${pageContext.request.contextPath}/usuarios-sistema?accion=eliminar&id=${usuario.id_usuario_sistema}"
                               class="btn btn-eliminar"
                               onclick="return confirm('¿Está seguro de eliminar este usuario?');">
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