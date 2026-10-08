<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">

    <title>SISTI - Registrar Tipo de Equipo</title>

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
            max-width: 600px;
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
        ${accion == 'registrar' ? 'Registrar Tipo de Equipo' : 'Editar Tipo de Equipo'}
    </h1>

    <form action="${pageContext.request.contextPath}/tipos"
          method="post">

        <input type="hidden"
               name="accion"
               value="${accion}">

        <input type="hidden"
               name="id_tipo"
               value="${tipoEquipo.id_tipo}">

        <div class="campo">

            <label for="nombre_tipo">
                Nombre del Tipo:
            </label>

            <input type="text"
                   id="nombre_tipo"
                   name="nombre_tipo"
                   value="${tipoEquipo.nombre_tipo}"
                   required>

        </div>

        <div class="campo">

            <label for="descripcion">
                Descripción:
            </label>

            <textarea id="descripcion"
                      name="descripcion"
                      required>${tipoEquipo.descripcion}</textarea>

        </div>

        <div class="campo">

            <label for="estado">
                Estado:
            </label>

            <select id="estado"
                    name="estado"
                    required>

                <option value="1"
                    ${tipoEquipo.estado == 1 ? 'selected' : ''}>
                    Activo
                </option>

                <option value="0"
                    ${tipoEquipo.estado == 0 ? 'selected' : ''}>
                    Inactivo
                </option>

            </select>

        </div>

        <div class="botones">

            <button type="submit"
                    class="guardar">
                Guardar
            </button>

            <a href="${pageContext.request.contextPath}/tipos"
               class="cancelar">
                Cancelar
            </a>

        </div>

    </form>

</div>

</body>

</html>