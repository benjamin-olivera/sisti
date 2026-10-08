<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.sisti.model.Proveedor" %>

<%
    Proveedor proveedor =
            (Proveedor) request.getAttribute("proveedor");

    boolean editar = proveedor != null;
%>

<!DOCTYPE html>
<html lang="es">

<head>

    <meta charset="UTF-8">

    <title>
        SISTI - <%= editar ? "Editar Proveedor" : "Registrar Proveedor" %>
    </title>

    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

    <style>

        * {
            box-sizing: border-box;
        }

        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background: #f4f6f9;
        }

        .contenedor {
            width: 90%;
            max-width: 850px;
            margin: 40px auto;
        }

        .encabezado {
            background: #1f2937;
            color: white;
            padding: 25px;
            border-radius: 12px 12px 0 0;
        }

        .encabezado h1 {
            margin: 0;
        }

        .formulario {
            background: white;
            padding: 30px;
            border-radius: 0 0 12px 12px;
        }

        .campo {
            margin-bottom: 18px;
        }

        label {
            display: block;
            margin-bottom: 7px;
            font-weight: bold;
        }

        input,
        select {
            width: 100%;
            padding: 11px;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 15px;
        }

        .botones {
            margin-top: 25px;
        }

        button,
        .btn {
            display: inline-block;
            padding: 11px 18px;
            border: none;
            border-radius: 6px;
            color: white;
            font-weight: bold;
            text-decoration: none;
            cursor: pointer;
        }

        button {
            background: #2563eb;
        }

        .btn-cancelar {
            background: #6b7280;
            margin-left: 8px;
        }

    </style>

</head>

<body>

<div class="contenedor">

    <div class="encabezado">

        <h1>SISTI</h1>

        <p>
            <%= editar ? "Editar proveedor" : "Registrar proveedor" %>
        </p>

    </div>

    <div class="formulario">

        <form action="<%= request.getContextPath() %>/proveedores"
              method="post">

            <input type="hidden"
                   name="accion"
                   value="guardar">

            <% if (editar) { %>

                <input type="hidden"
                       name="id"
                       value="<%= proveedor.getId_proveedor() %>">

            <% } %>

            <div class="campo">

                <label>Razón social:</label>

                <input type="text"
                       name="razon_social"
                       value="<%= editar && proveedor.getRazon_social() != null
                               ? proveedor.getRazon_social() : "" %>"
                       required>

            </div>

            <div class="campo">

                <label>RUC:</label>

                <input type="text"
                       name="ruc"
                       value="<%= editar && proveedor.getRuc() != null
                               ? proveedor.getRuc() : "" %>"
                       maxlength="11"
                       required>

            </div>

            <div class="campo">

                <label>Teléfono:</label>

                <input type="text"
                       name="telefono"
                       value="<%= editar && proveedor.getTelefono() != null
                               ? proveedor.getTelefono() : "" %>">

            </div>

            <div class="campo">

                <label>Correo:</label>

                <input type="email"
                       name="correo"
                       value="<%= editar && proveedor.getCorreo() != null
                               ? proveedor.getCorreo() : "" %>">

            </div>

            <div class="campo">

                <label>Dirección:</label>

                <input type="text"
                       name="direccion"
                       value="<%= editar && proveedor.getDireccion() != null
                               ? proveedor.getDireccion() : "" %>">

            </div>

            <div class="campo">

                <label>Estado:</label>

                <select name="estado">

                    <option value="1"
                        <%= editar && proveedor.getEstado() == 1
                                ? "selected" : "" %>>

                        Activo

                    </option>

                    <option value="0"
                        <%= editar && proveedor.getEstado() == 0
                                ? "selected" : "" %>>

                        Inactivo

                    </option>

                </select>

            </div>

            <div class="botones">

                <button type="submit">

                    <%= editar ? "Actualizar proveedor"
                               : "Registrar proveedor" %>

                </button>

                <a class="btn btn-cancelar"
                   href="<%= request.getContextPath() %>/proveedores">

                    Cancelar

                </a>

            </div>

        </form>

    </div>

</div>

</body>

</html>