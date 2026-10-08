<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="org.sisti.model.Proveedor" %>

<!DOCTYPE html>
<html lang="es">
<head>

    <meta charset="UTF-8">

    <title>SISTI - Proveedores</title>

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
            color: #333;
        }

        .contenedor {
            width: 92%;
            max-width: 1200px;
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

        .encabezado p {
            margin-bottom: 0;
            color: #d1d5db;
        }

        .acciones {
            background: white;
            padding: 20px;
            border-bottom: 1px solid #ddd;
        }

        .btn {
            display: inline-block;
            padding: 10px 16px;
            border-radius: 6px;
            text-decoration: none;
            color: white;
            font-weight: bold;
            margin-right: 5px;
        }

        .btn-nuevo {
            background: #2563eb;
        }

        .btn-editar {
            background: #f59e0b;
        }

        .btn-eliminar {
            background: #dc2626;
        }

        .tabla-contenedor {
            background: white;
            padding: 20px;
            overflow-x: auto;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th {
            background: #374151;
            color: white;
            padding: 12px;
            text-align: left;
        }

        td {
            padding: 12px;
            border-bottom: 1px solid #ddd;
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

        .vacio {
            text-align: center;
            padding: 30px;
            color: #777;
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

        <h1>SISTI</h1>

        <p>
            Sistema de Inventario de Equipos TI
        </p>

        <p>
            Gestión de Proveedores
        </p>

    </div>

    <div class="acciones">

        <a class="btn btn-nuevo"
           href="<%= request.getContextPath() %>/proveedores?accion=nuevo">

            + Registrar proveedor

        </a>

        

    </div>

    <div class="tabla-contenedor">

        <%
            List<Proveedor> proveedores =
                    (List<Proveedor>) request.getAttribute("proveedores");

            if (proveedores != null && !proveedores.isEmpty()) {
        %>

        <table>

            <thead>

                <tr>

                    <th>ID</th>
                    <th>Razón Social</th>
                    <th>RUC</th>
                    <th>Teléfono</th>
                    <th>Correo</th>
                    <th>Dirección</th>
                    <th>Estado</th>
                    <th>Acciones</th>

                </tr>

            </thead>

            <tbody>

            <%
                for (Proveedor proveedor : proveedores) {
            %>

                <tr>

                    <td>
                        <%= proveedor.getId_proveedor() %>
                    </td>

                    <td>
                        <%= proveedor.getRazon_social() %>
                    </td>

                    <td>
                        <%= proveedor.getRuc() %>
                    </td>

                    <td>
                        <%= proveedor.getTelefono() %>
                    </td>

                    <td>
                        <%= proveedor.getCorreo() %>
                    </td>

                    <td>
                        <%= proveedor.getDireccion() %>
                    </td>

                    <td>

                        <%
                            if (proveedor.getEstado() == 1) {
                        %>

                            <span class="estado-activo">
                                Activo
                            </span>

                        <%
                            } else {
                        %>

                            <span class="estado-inactivo">
                                Inactivo
                            </span>

                        <%
                            }
                        %>

                    </td>

                    <td>

                        <a class="btn btn-editar"
                           href="<%= request.getContextPath() %>/proveedores?accion=editar&id=<%= proveedor.getId_proveedor() %>">

                            Editar

                        </a>

                        <a class="btn btn-eliminar"
                           href="<%= request.getContextPath() %>/proveedores?accion=eliminar&id=<%= proveedor.getId_proveedor() %>"
                           onclick="return confirm('¿Está seguro de eliminar este proveedor?');">

                            Eliminar

                        </a>

                    </td>

                </tr>

            <%
                }
            %>

            </tbody>

        </table>

        <%
            } else {
        %>

            <div class="vacio">

                <h3>No existen proveedores registrados.</h3>

                <p>
                    Registra el primer proveedor utilizando el botón
                    "Registrar proveedor".
                </p>

            </div>

        <%
            }
        %>

    </div>

</div>

</body>

</html>