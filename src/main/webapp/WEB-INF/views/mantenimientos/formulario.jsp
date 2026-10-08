<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="es">

<head>

    <meta charset="UTF-8">

    <title>SISTI - Mantenimiento</title>

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
            max-width: 700px;
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
        ${accion == 'registrar' ? 'Registrar Mantenimiento' : 'Editar Mantenimiento'}
    </h1>

    <form action="${pageContext.request.contextPath}/mantenimientos"
          method="post">

        <input type="hidden"
               name="accion"
               value="${accion}">

        <input type="hidden"
               name="id_mantenimiento"
               value="${mantenimiento.id_mantenimiento}">


        <div class="campo">

            <label for="fecha_inicio">
                Fecha de Inicio:
            </label>

            <input type="date"
                   id="fecha_inicio"
                   name="fecha_inicio"
                   value="${mantenimiento.fecha_inicio}">

        </div>


        <div class="campo">

            <label for="fecha_fin">
                Fecha de Fin:
            </label>

            <input type="date"
                   id="fecha_fin"
                   name="fecha_fin"
                   value="${mantenimiento.fecha_fin}">

        </div>


        <div class="campo">

            <label for="tipo_mantenimiento">
                Tipo de Mantenimiento:
            </label>

            <select id="tipo_mantenimiento"
                    name="tipo_mantenimiento"
                    required>

                <option value="">
                    -- Seleccione un tipo --
                </option>

                <option value="Preventivo"
                    ${mantenimiento.tipo_mantenimiento == 'Preventivo' ? 'selected' : ''}>
                    Preventivo
                </option>

                <option value="Correctivo"
                    ${mantenimiento.tipo_mantenimiento == 'Correctivo' ? 'selected' : ''}>
                    Correctivo
                </option>

            </select>

        </div>


        <div class="campo">

            <label for="problema">
                Problema:
            </label>

            <textarea id="problema"
                      name="problema"
                      required>${mantenimiento.problema}</textarea>

        </div>


        <div class="campo">

            <label for="solucion">
                Solución:
            </label>

            <textarea id="solucion"
                      name="solucion">${mantenimiento.solucion}</textarea>

        </div>


        <div class="campo">

            <label for="tecnico_responsable">
                Técnico Responsable:
            </label>

            <input type="text"
                   id="tecnico_responsable"
                   name="tecnico_responsable"
                   value="${mantenimiento.tecnico_responsable}"
                   required>

        </div>


        <div class="campo">

            <label for="costo">
                Costo:
            </label>

            <input type="number"
                   id="costo"
                   name="costo"
                   value="${mantenimiento.costo}"
                   step="0.01"
                   min="0">

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

                <option value="Pendiente"
                    ${mantenimiento.estado == 'Pendiente' ? 'selected' : ''}>
                    Pendiente
                </option>

                <option value="En proceso"
                    ${mantenimiento.estado == 'En proceso' ? 'selected' : ''}>
                    En proceso
                </option>

                <option value="Finalizado"
                    ${mantenimiento.estado == 'Finalizado' ? 'selected' : ''}>
                    Finalizado
                </option>

            </select>

        </div>


        <div class="campo">

            <label for="observaciones">
                Observaciones:
            </label>

            <textarea id="observaciones"
                      name="observaciones">${mantenimiento.observaciones}</textarea>

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
                        ${mantenimiento.equipo != null && mantenimiento.equipo.id_equipo == equipo.id_equipo ? 'selected' : ''}>

                        ${equipo.codigo_inventario}
                        - ${equipo.modelo}

                    </option>

                </c:forEach>

            </select>

        </div>


        <div class="botones">

            <button type="submit"
                    class="guardar">
                Guardar
            </button>

            <a href="${pageContext.request.contextPath}/mantenimientos"
               class="cancelar">
                Cancelar
            </a>

        </div>

    </form>

</div>

</body>

</html>