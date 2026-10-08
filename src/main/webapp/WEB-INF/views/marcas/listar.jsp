<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="es">

<head>

    <meta charset="UTF-8">

    <title>SISTI - Marcas</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <style>

        * {
            box-sizing: border-box;
        }

        body {
            margin: 0;
            font-family: Arial, Helvetica, sans-serif;
            background: #f4f6f8;
            color: #333;
        }

        .contenedor {
            width: 90%;
            max-width: 1000px;
            margin: 40px auto;
        }

        .encabezado {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 25px;
        }

        .titulo {
            margin: 0;
            color: #1f2937;
        }

        .subtitulo {
            margin-top: 8px;
            color: #6b7280;
        }

        .boton {
            display: inline-block;
            padding: 11px 18px;
            border-radius: 6px;
            text-decoration: none;
            font-weight: bold;
            border: none;
            cursor: pointer;
        }

        .btn-nuevo {
            background: #2563eb;
            color: white;
        }

        .btn-nuevo:hover {
            background: #1d4ed8;
        }

        .tabla-contenedor {
            background: white;
            border-radius: 10px;
            padding: 20px;
            box-shadow: 0 3px 10px rgba(0,0,0,0.08);
            overflow-x: auto;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th {
            background: #1f2937;
            color: white;
            padding: 14px;
            text-align: left;
        }

        td {
            padding: 13px;
            border-bottom: 1px solid #e5e7eb;
        }

        tr:hover {
            background: #f9fafb;
        }

        .estado-activo {
            color: #15803d;
            font-weight: bold;
        }

        .estado-inactivo {
            color: #dc2626;
            font-weight: bold;
        }

        .acciones {
            white-space: nowrap;
        }

        .btn-editar {
            background: #f59e0b;
            color: white;
            margin-right: 5px;
        }

        .btn-editar:hover {
            background: #d97706;
        }

        .btn-eliminar {
            background: #dc2626;
            color: white;
        }

        .btn-eliminar:hover {
            background: #b91c1c;
        }

        .mensaje-vacio {
            text-align: center;
            padding: 30px;
            color: #6b7280;
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

    <div class="encabezado">

        <div>

            <h1 class="titulo">
                Gestión de Marcas
            </h1>

            <p class="subtitulo">
                Administración de las marcas registradas en el sistema
            </p>

        </div>

        <a
            href="${pageContext.request.contextPath}/marcas?accion=nuevo"
            class="boton btn-nuevo">
            + Nueva Marca
        </a>

    </div>


    <div class="tabla-contenedor">

        <table>

            <thead>

                <tr>
                    <th>ID</th>
                    <th>Nombre de la Marca</th>
                    <th>Estado</th>
                    <th>Acciones</th>
                </tr>

            </thead>


            <tbody>

                <c:choose>

                    <c:when test="${not empty listaMarcas}">

                        <c:forEach var="marca" items="${listaMarcas}">

                            <tr>

                                <td>
                                    ${marca.id_marca}
                                </td>

                                <td>
                                    ${marca.nombre_marca}
                                </td>

                                <td>

                                    <c:choose>

                                        <c:when test="${marca.estado == 1}">

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

                                <td class="acciones">

                                    <a
                                        href="${pageContext.request.contextPath}/marcas?accion=editar&id=${marca.id_marca}"
                                        class="boton btn-editar">
                                        Editar
                                    </a>

                                    <a
                                        href="${pageContext.request.contextPath}/marcas?accion=eliminar&id=${marca.id_marca}"
                                        class="boton btn-eliminar"
                                        onclick="return confirm('¿Está seguro de eliminar esta marca?');">
                                        Eliminar
                                    </a>

                                </td>

                            </tr>

                        </c:forEach>

                    </c:when>


                    <c:otherwise>

                        <tr>

                            <td
                                colspan="4"
                                class="mensaje-vacio">

                                No existen marcas registradas.

                            </td>

                        </tr>

                    </c:otherwise>

                </c:choose>

            </tbody>

        </table>

    </div>

</div>

</body>

</html>