<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="es">

<head>

    <meta charset="UTF-8">

    <title>SISTI - Usuarios</title>

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

    <h1>Usuarios</h1>

    <a href="${pageContext.request.contextPath}/usuarios?accion=nuevo"
       class="boton-nuevo">
        + Nuevo Usuario
    </a>

    <table>

        <thead>

            <tr>

                <th>ID</th>
                <th>DNI</th>
                <th>Nombres</th>
                <th>Apellidos</th>
                <th>Correo</th>
                <th>Teléfono</th>
                <th>Cargo</th>
                <th>Área</th>
                <th>Estado</th>
                <th>Acciones</th>

            </tr>

        </thead>

        <tbody>

            <c:forEach var="usuario" items="${listaUsuarios}">

                <tr>

                    <td>
                        ${usuario.id_usuario}
                    </td>

                    <td>
                        ${usuario.dni}
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
                        ${usuario.telefono}
                    </td>

                    <td>
                        ${usuario.cargo}
                    </td>

                    <td>
                        ${usuario.area.nombre_area}
                    </td>

                    <td>
                        ${usuario.estado}
                    </td>

                    <td>

                        <a class="editar"
                           href="${pageContext.request.contextPath}/usuarios?accion=editar&id=${usuario.id_usuario}">
                            Editar
                        </a>

                        <a class="eliminar"
                           href="${pageContext.request.contextPath}/usuarios?accion=eliminar&id=${usuario.id_usuario}"
                           onclick="return confirm('¿Está seguro de eliminar este usuario?');">
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