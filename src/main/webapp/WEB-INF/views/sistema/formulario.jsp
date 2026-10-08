<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">

    <title>SISTI - Usuario del Sistema</title>

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
            width: 90%;
            max-width: 700px;
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
        select {
            width: 100%;
            padding: 11px;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 14px;
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
            <h1>Registrar Usuario del Sistema</h1>
        </c:when>

        <c:otherwise>
            <h1>Editar Usuario del Sistema</h1>
        </c:otherwise>

    </c:choose>


    <form action="${pageContext.request.contextPath}/usuarios-sistema"
          method="post">

        <input type="hidden"
               name="accion"
               value="${accion}">


        <c:if test="${accion == 'actualizar'}">

            <input type="hidden"
                   name="id_usuario_sistema"
                   value="${usuarioSistema.id_usuario_sistema}">

        </c:if>


        <div class="campo">

            <label for="username">
                Username:
            </label>

            <input type="text"
                   id="username"
                   name="username"
                   value="${usuarioSistema.username}"
                   required>

        </div>


        <div class="campo">

            <label for="password">
                Contraseña:
            </label>

            <input type="password"
                   id="password"
                   name="password"
                   value="${usuarioSistema.password}"
                   required>

        </div>


        <div class="campo">

            <label for="nombres">
                Nombres:
            </label>

            <input type="text"
                   id="nombres"
                   name="nombres"
                   value="${usuarioSistema.nombres}"
                   required>

        </div>


        <div class="campo">

            <label for="apellidos">
                Apellidos:
            </label>

            <input type="text"
                   id="apellidos"
                   name="apellidos"
                   value="${usuarioSistema.apellidos}"
                   required>

        </div>


        <div class="campo">

            <label for="correo">
                Correo:
            </label>

            <input type="email"
                   id="correo"
                   name="correo"
                   value="${usuarioSistema.correo}"
                   required>

        </div>


        <div class="campo">

            <label for="estado">
                Estado:
            </label>

            <select id="estado"
                    name="estado"
                    required>

                <option value="1"
                    ${usuarioSistema.estado == 1 ? 'selected' : ''}>
                    Activo
                </option>

                <option value="0"
                    ${usuarioSistema.estado == 0 ? 'selected' : ''}>
                    Inactivo
                </option>

            </select>

        </div>


        <div class="campo">

            <label for="id_rol">
                Rol:
            </label>

            <select id="id_rol"
                    name="id_rol"
                    required>

                <option value="">
                    -- Seleccione un Rol --
                </option>

                <c:forEach var="rol"
                           items="${listaRoles}">

                    <option value="${rol.id_rol}"
                        ${usuarioSistema.rol != null
                          && usuarioSistema.rol.id_rol == rol.id_rol
                          ? 'selected' : ''}>

                        ${rol.nombre_rol}

                    </option>

                </c:forEach>

            </select>

        </div>


        <div class="botones">

            <button type="submit"
                    class="btn btn-guardar">
                Guardar
            </button>

            <a href="${pageContext.request.contextPath}/usuarios-sistema"
               class="btn btn-volver">
                Volver
            </a>

        </div>

    </form>

</div>

</body>

</html>