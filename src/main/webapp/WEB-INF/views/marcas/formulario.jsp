<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="es">

<head>

    <meta charset="UTF-8">

    <title>SISTI - Marca</title>

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
            max-width: 700px;
            margin: 40px auto;
        }

        .tarjeta {
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 3px 10px rgba(0,0,0,0.08);
        }

        .titulo {
            margin-top: 0;
            margin-bottom: 8px;
            color: #1f2937;
        }

        .subtitulo {
            margin-top: 0;
            margin-bottom: 25px;
            color: #6b7280;
        }

        .campo {
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-bottom: 7px;
            font-weight: bold;
            color: #374151;
        }

        input,
        select {
            width: 100%;
            padding: 11px;
            border: 1px solid #d1d5db;
            border-radius: 6px;
            font-size: 15px;
            font-family: Arial, Helvetica, sans-serif;
        }

        input:focus,
        select:focus {
            outline: none;
            border-color: #2563eb;
        }

        .botones {
            display: flex;
            gap: 10px;
            margin-top: 25px;
        }

        .boton {
            display: inline-block;
            padding: 11px 18px;
            border-radius: 6px;
            text-decoration: none;
            font-weight: bold;
            border: none;
            cursor: pointer;
            font-size: 14px;
        }

        .btn-guardar {
            background: #2563eb;
            color: white;
        }

        .btn-guardar:hover {
            background: #1d4ed8;
        }

        .btn-cancelar {
            background: #6b7280;
            color: white;
        }

        .btn-cancelar:hover {
            background: #4b5563;
        }

    </style>

</head>

<body>

<div class="contenedor">

    <div class="tarjeta">

        <h1 class="titulo">
            ${marca.id_marca == 0 ? 'Registrar Marca' : 'Editar Marca'}
        </h1>

        <p class="subtitulo">
            Complete la información de la marca
        </p>


        <form
            action="${pageContext.request.contextPath}/marcas"
            method="post">


            <input
                type="hidden"
                name="accion"
                value="${marca.id_marca == 0 ? 'registrar' : 'actualizar'}">


            <input
                type="hidden"
                name="id_marca"
                value="${marca.id_marca}">


            <div class="campo">

                <label for="nombre_marca">
                    Nombre de la Marca
                </label>

                <input
                    type="text"
                    id="nombre_marca"
                    name="nombre_marca"
                    value="${marca.nombre_marca}"
                    maxlength="100"
                    required>

            </div>


            <div class="campo">

                <label for="estado">
                    Estado
                </label>

                <select
                    id="estado"
                    name="estado"
                    required>

                    <option
                        value="1"
                        ${marca.estado == 1 ? 'selected' : ''}>
                        Activo
                    </option>

                    <option
                        value="0"
                        ${marca.estado == 0 ? 'selected' : ''}>
                        Inactivo
                    </option>

                </select>

            </div>


            <div class="botones">

                <button
                    type="submit"
                    class="boton btn-guardar">
                    Guardar
                </button>

                <a
                    href="${pageContext.request.contextPath}/marcas"
                    class="boton btn-cancelar">
                    Cancelar
                </a>

            </div>

        </form>

    </div>

</div>

</body>

</html>