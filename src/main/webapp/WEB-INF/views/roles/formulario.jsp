<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>SISTI - Rol</title>

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
            max-width: 650px;
            margin: 40px auto;
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.10);
        }

        h1 {
            margin-top: 0;
            margin-bottom: 25px;
            color: #222;
        }

        .campo {
            margin-bottom: 18px;
        }

        label {
            display: block;
            margin-bottom: 7px;
            font-weight: bold;
            color: #333;
        }

        input,
        textarea,
        select {
            width: 100%;
            padding: 11px;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 14px;
        }

        textarea {
            resize: vertical;
            min-height: 100px;
        }

        .botones {
            margin-top: 25px;
        }

        .btn {
            display: inline-block;
            padding: 10px 18px;
            border: none;
            border-radius: 6px;
            text-decoration: none;
            color: white;
            cursor: pointer;
            font-size: 14px;
        }

        .btn-guardar {
            background: #198754;
        }

        .btn-volver {
            background: #6c757d;
            margin-left: 8px;
        }

        .btn:hover {
            opacity: 0.85;
        }
    </style>
</head>

<body>

<div class="container">

    <c:choose>

        <c:when test="${accion == 'registrar'}">
            <h1>Registrar Rol</h1>
        </c:when>

        <c:otherwise>
            <h1>Editar Rol</h1>
        </c:otherwise>

    </c:choose>

    <form action="${pageContext.request.contextPath}/roles"
          method="post">

        <input type="hidden"
               name="accion"
               value="${accion}">

        <c:if test="${accion == 'actualizar'}">

            <input type="hidden"
                   name="id_rol"
                   value="${rol.id_rol}">

        </c:if>

        <div class="campo">

            <label for="nombre_rol">
                Nombre del Rol:
            </label>

            <input type="text"
                   id="nombre_rol"
                   name="nombre_rol"
                   value="${rol.nombre_rol}"
                   required>

        </div>

        <div class="campo">

            <label for="descripcion">
                Descripción:
            </label>

            <textarea id="descripcion"
                      name="descripcion">${rol.descripcion}</textarea>

        </div>

        <div class="campo">

            <label for="estado">
                Estado:
            </label>

            <select id="estado"
                    name="estado"
                    required>

                <option value="1"
                    ${rol.estado == 1 ? 'selected' : ''}>
                    Activo
                </option>

                <option value="0"
                    ${rol.estado == 0 ? 'selected' : ''}>
                    Inactivo
                </option>

            </select>

        </div>

        <div class="botones">

            <button type="submit"
                    class="btn btn-guardar">
                Guardar
            </button>

            <a href="${pageContext.request.contextPath}/roles"
               class="btn btn-volver">
                Volver
            </a>

        </div>

    </form>

</div>

</body>
</html>