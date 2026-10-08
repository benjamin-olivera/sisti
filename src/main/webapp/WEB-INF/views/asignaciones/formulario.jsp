<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="es">

<head>

    <meta charset="UTF-8">

    <title>SISTI - Asignación</title>

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
            max-width: 650px;
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

        .campo {
            margin-bottom: 18px;
        }

        label {
            display: block;
            margin-bottom: 6px;
            font-weight: bold;
            color: #333;
        }

        input,
        textarea,
        select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 15px;
        }

        textarea {
            min-height: 100px;
            resize: vertical;
        }

        .botones {
            margin-top: 25px;
        }

        .guardar {
            padding: 10px 18px;
            background-color: #198754;
            color: white;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            font-size: 15px;
        }

        .guardar:hover {
            background-color: #157347;
        }

        .cancelar {
            display: inline-block;
            padding: 10px 18px;
            margin-left: 8px;
            background-color: #6c757d;
            color: white;
            text-decoration: none;
            border-radius: 6px;
        }

        .cancelar:hover {
            background-color: #5c636a;
        }

    </style>

</head>

<body>

<div class="contenedor">

    <h1>
        ${accion == 'registrar' ? 'Registrar Asignación' : 'Editar Asignación'}
    </h1>

    <form action="${pageContext.request.contextPath}/asignaciones"
          method="post">

        <input type="hidden"
               name="accion"
               value="${accion}">

        <input type="hidden"
               name="id_asignacion"
               value="${asignacion.id_asignacion}">


        <div class="campo">

            <label for="fecha_asignacion">
                Fecha de Asignación:
            </label>

            <input type="date"
                   id="fecha_asignacion"
                   name="fecha_asignacion"
                   value="${asignacion.fecha_asignacion}"
                   required>

        </div>


        <div class="campo">

            <label for="fecha_devolucion">
                Fecha de Devolución:
            </label>

            <input type="date"
                   id="fecha_devolucion"
                   name="fecha_devolucion"
                   value="${asignacion.fecha_devolucion}">

        </div>


        <div class="campo">

            <label for="motivo">
                Motivo:
            </label>

            <input type="text"
                   id="motivo"
                   name="motivo"
                   value="${asignacion.motivo}"
                   required>

        </div>


        <div class="campo">

            <label for="observaciones">
                Observaciones:
            </label>

            <textarea id="observaciones"
                      name="observaciones">${asignacion.observaciones}</textarea>

        </div>


        <div class="campo">

            <label for="estado">
                Estado:
            </label>

            <select id="estado"
                    name="estado"
                    required>

                <option value="">
                    -- Seleccione un estado --
                </option>

                <option value="Asignado"
                    ${asignacion.estado == 'Asignado' ? 'selected' : ''}>
                    Asignado
                </option>

                <option value="Devuelto"
                    ${asignacion.estado == 'Devuelto' ? 'selected' : ''}>
                    Devuelto
                </option>

            </select>

        </div>


        <div class="campo">

            <label for="id_equipo">
                Equipo:
            </label>

            <select id="id_equipo"
                    name="id_equipo"
                    required>

                <option value="">
                    -- Seleccione un equipo --
                </option>

                <c:forEach var="equipo"
                           items="${listaEquipos}">

                    <option value="${equipo.id_equipo}"
                        ${asignacion.equipo != null && asignacion.equipo.id_equipo == equipo.id_equipo ? 'selected' : ''}>

                        ${equipo.codigo_inventario}
                        - ${equipo.modelo}

                    </option>

                </c:forEach>

            </select>

        </div>


        <div class="campo">

            <label for="id_usuario">
                Usuario:
            </label>

            <select id="id_usuario"
                    name="id_usuario"
                    required>

                <option value="">
                    -- Seleccione un usuario --
                </option>

                <c:forEach var="usuario"
                           items="${listaUsuarios}">

                    <option value="${usuario.id_usuario}"
                        ${asignacion.usuario != null && asignacion.usuario.id_usuario == usuario.id_usuario ? 'selected' : ''}>

                        ${usuario.nombres}
                        ${usuario.apellidos}

                    </option>

                </c:forEach>

            </select>

        </div>


        <div class="botones">

            <button type="submit"
                    class="guardar">
                Guardar
            </button>

            <a href="${pageContext.request.contextPath}/asignaciones"
               class="cancelar">
                Cancelar
            </a>

        </div>

    </form>

</div>

</body>

</html>