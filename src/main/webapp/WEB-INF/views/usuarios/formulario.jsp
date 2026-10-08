<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="es">

<head>

    <meta charset="UTF-8">

    <title>SISTI - Usuario</title>

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
        select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 15px;
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
        ${accion == 'registrar' ? 'Registrar Usuario' : 'Editar Usuario'}
    </h1>

    <form action="${pageContext.request.contextPath}/usuarios"
          method="post">

        <input type="hidden"
               name="accion"
               value="${accion}">

        <input type="hidden"
               name="id_usuario"
               value="${usuario.id_usuario}">


        <div class="campo">

            <label for="dni">
                DNI:
            </label>

            <input type="text"
                   id="dni"
                   name="dni"
                   value="${usuario.dni}"
                   required>

        </div>


        <div class="campo">

            <label for="nombres">
                Nombres:
            </label>

            <input type="text"
                   id="nombres"
                   name="nombres"
                   value="${usuario.nombres}"
                   required>

        </div>


        <div class="campo">

            <label for="apellidos">
                Apellidos:
            </label>

            <input type="text"
                   id="apellidos"
                   name="apellidos"
                   value="${usuario.apellidos}"
                   required>

        </div>


        <div class="campo">

            <label for="correo">
                Correo:
            </label>

            <input type="email"
                   id="correo"
                   name="correo"
                   value="${usuario.correo}"
                   required>

        </div>


        <div class="campo">

            <label for="telefono">
                Teléfono:
            </label>

            <input type="text"
                   id="telefono"
                   name="telefono"
                   value="${usuario.telefono}"
                   required>

        </div>


        <div class="campo">

            <label for="cargo">
                Cargo:
            </label>

            <input type="text"
                   id="cargo"
                   name="cargo"
                   value="${usuario.cargo}"
                   required>

        </div>


        <div class="campo">

            <label for="id_area">
                Área:
            </label>

            <select id="id_area"
                    name="id_area"
                    required>

                <option value="">
                    -- Seleccione un área --
                </option>

                <c:forEach var="area" items="${listaAreas}">

                    <option value="${area.id_area}"
                        ${usuario.area != null && usuario.area.id_area == area.id_area ? 'selected' : ''}>

                        ${area.nombre_area}

                    </option>

                </c:forEach>

            </select>

        </div>


        <div class="campo">

            <label for="estado">
                Estado:
            </label>

            <select id="estado"
                    name="estado"
                    required>

                <option value="1"
                    ${usuario.estado == 1 ? 'selected' : ''}>
                    Activo
                </option>

                <option value="0"
                    ${usuario.estado == 0 ? 'selected' : ''}>
                    Inactivo
                </option>

            </select>

        </div>


        <div class="botones">

            <button type="submit"
                    class="guardar">
                Guardar
            </button>

            <a href="${pageContext.request.contextPath}/usuarios"
               class="cancelar">
                Cancelar
            </a>

        </div>

    </form>

</div>

</body>

</html>