<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="org.sisti.model.Equipo" %>

<%
    Equipo equipo = (Equipo) request.getAttribute("equipo");

    boolean editar = (equipo != null);
%>

<!DOCTYPE html>

<html lang="es">

<head>

    <meta charset="UTF-8">

    <title>
        SISTI - <%= editar ? "Editar Equipo" : "Registrar Equipo" %>
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
            background: #f4f6f8;
            color: #222;
        }

        .contenedor {
            width: 90%;
            max-width: 1000px;
            margin: 40px auto;
        }

        .encabezado {
            background: #1f2937;
            color: white;
            padding: 25px;
            border-radius: 10px 10px 0 0;
        }

        .encabezado h1 {
            margin: 0 0 8px 0;
        }

        .encabezado p {
            margin: 0;
            color: #d1d5db;
        }

        .formulario {
            background: white;
            padding: 30px;
            border-radius: 0 0 10px 10px;
            box-shadow: 0 3px 10px rgba(0,0,0,0.08);
        }

        .fila {
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 20px;
            margin-bottom: 20px;
        }

        .campo {
            display: flex;
            flex-direction: column;
        }

        .campo label {
            font-weight: bold;
            margin-bottom: 7px;
        }

        .campo input,
        .campo select,
        .campo textarea {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 14px;
        }

        .campo textarea {
            min-height: 100px;
            resize: vertical;
        }

        .botones {
            display: flex;
            gap: 10px;
            margin-top: 25px;
        }

        .btn {
            padding: 11px 18px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            text-decoration: none;
            font-size: 14px;
        }

        .btn-guardar {
            background: #2563eb;
            color: white;
        }

        .btn-cancelar {
            background: #6b7280;
            color: white;
        }

        @media (max-width: 700px) {

            .fila {
                grid-template-columns: 1fr;
            }

        }

    </style>

</head>

<body>

<div class="contenedor">

    <!-- ENCABEZADO -->

    <div class="encabezado">

        <h1>SISTI</h1>

        <p>

            <%= editar
                ? "Editar equipo TI"
                : "Registrar equipo TI" %>

        </p>

    </div>


    <!-- FORMULARIO -->

    <div class="formulario">

        <form
            action="<%= request.getContextPath() %>/equipos"
            method="post">

            <!-- ACCIÓN -->

            <input
                type="hidden"
                name="accion"
                value="guardar">


            <!-- ID -->

            <% if (editar) { %>

                <input
                    type="hidden"
                    name="id"
                    value="<%= equipo.getId_equipo() %>">

            <% } %>


            <!-- ================================= -->
            <!-- CÓDIGO Y MODELO -->
            <!-- ================================= -->

            <div class="fila">

                <div class="campo">

                    <label>
                        Código de inventario
                    </label>

                    <input
                        type="text"
                        name="codigo_inventario"
                        value="<%= editar && equipo.getCodigo_inventario() != null
                                ? equipo.getCodigo_inventario()
                                : "" %>"
                        required>

                </div>


                <div class="campo">

                    <label>
                        Modelo
                    </label>

                    <input
                        type="text"
                        name="modelo"
                        value="<%= editar && equipo.getModelo() != null
                                ? equipo.getModelo()
                                : "" %>"
                        required>

                </div>

            </div>


            <!-- ================================= -->
            <!-- SERIE Y PROCESADOR -->
            <!-- ================================= -->

            <div class="fila">

                <div class="campo">

                    <label>
                        Número de serie
                    </label>

                    <input
                        type="text"
                        name="numero_serie"
                        value="<%= editar && equipo.getNumero_serie() != null
                                ? equipo.getNumero_serie()
                                : "" %>">

                </div>


                <div class="campo">

                    <label>
                        Procesador
                    </label>

                    <input
                        type="text"
                        name="procesador"
                        value="<%= editar && equipo.getProcesador() != null
                                ? equipo.getProcesador()
                                : "" %>">

                </div>

            </div>


            <!-- ================================= -->
            <!-- RAM Y ALMACENAMIENTO -->
            <!-- ================================= -->

            <div class="fila">

                <div class="campo">

                    <label>
                        RAM
                    </label>

                    <input
                        type="text"
                        name="ram"
                        value="<%= editar && equipo.getRam() != null
                                ? equipo.getRam()
                                : "" %>">

                </div>


                <div class="campo">

                    <label>
                        Almacenamiento
                    </label>

                    <input
                        type="text"
                        name="almacenamiento"
                        value="<%= editar && equipo.getAlmacenamiento() != null
                                ? equipo.getAlmacenamiento()
                                : "" %>">

                </div>

            </div>


            <!-- ================================= -->
            <!-- SISTEMA OPERATIVO Y HOSTNAME -->
            <!-- ================================= -->

            <div class="fila">

                <div class="campo">

                    <label>
                        Sistema operativo
                    </label>

                    <input
                        type="text"
                        name="sistema_operativo"
                        value="<%= editar && equipo.getSistema_operativo() != null
                                ? equipo.getSistema_operativo()
                                : "" %>">

                </div>


                <div class="campo">

                    <label>
                        Hostname
                    </label>

                    <input
                        type="text"
                        name="hostname"
                        value="<%= editar && equipo.getHostname() != null
                                ? equipo.getHostname()
                                : "" %>">

                </div>

            </div>


            <!-- ================================= -->
            <!-- FECHA Y PRECIO -->
            <!-- ================================= -->

            <div class="fila">

                <div class="campo">

                    <label>
                        Fecha de adquisición
                    </label>

                    <input
                        type="date"
                        name="fecha_adquisicion"
                        value="<%= editar
                                && equipo.getFecha_adquisicion() != null
                                ? equipo.getFecha_adquisicion().toString()
                                : "" %>">

                </div>


                <div class="campo">

                    <label>
                        Precio de adquisición
                    </label>

                    <input
                        type="number"
                        name="precio_adquisicion"
                        step="0.01"
                        value="<%= editar
                                && equipo.getPrecio_adquisicion() != null
                                ? equipo.getPrecio_adquisicion().toString()
                                : "" %>">

                </div>

            </div>


            <!-- ================================= -->
            <!-- ESTADO -->
            <!-- ================================= -->

            <div class="fila">

                <div class="campo">

                    <label>
                        Estado del equipo
                    </label>

                    <select name="estado_equipo">

                        <option value="Disponible"
                            <%= editar
                                && "Disponible".equals(
                                    equipo.getEstado_equipo())
                                ? "selected"
                                : "" %>>

                            Disponible

                        </option>


                        <option value="Asignado"
                            <%= editar
                                && "Asignado".equals(
                                    equipo.getEstado_equipo())
                                ? "selected"
                                : "" %>>

                            Asignado

                        </option>


                        <option value="Mantenimiento"
                            <%= editar
                                && "Mantenimiento".equals(
                                    equipo.getEstado_equipo())
                                ? "selected"
                                : "" %>>

                            Mantenimiento

                        </option>


                        <option value="Baja"
                            <%= editar
                                && "Baja".equals(
                                    equipo.getEstado_equipo())
                                ? "selected"
                                : "" %>>

                            Baja

                        </option>

                    </select>

                </div>


                <div class="campo">

                    <label>
                        ID Tipo de equipo
                    </label>

                    <input
                        type="number"
                        name="id_tipo"
                        placeholder="ID del tipo">

                </div>

            </div>


            <!-- ================================= -->
            <!-- MARCA -->
            <!-- ================================= -->

            <div class="fila">

                <div class="campo">

                    <label>
                        ID Marca
                    </label>

                    <input
                        type="number"
                        name="id_marca"
                        placeholder="ID de la marca">

                </div>

            </div>


            <!-- ================================= -->
            <!-- OBSERVACIONES -->
            <!-- ================================= -->

            <div class="campo">

                <label>
                    Observaciones
                </label>

                <textarea
                    name="observaciones"><%= editar
                        && equipo.getObservaciones() != null
                        ? equipo.getObservaciones()
                        : "" %></textarea>

            </div>


            <!-- ================================= -->
            <!-- BOTONES -->
            <!-- ================================= -->

            <div class="botones">

                <button
                    type="submit"
                    class="btn btn-guardar">

                    <%= editar
                        ? "Actualizar equipo"
                        : "Guardar equipo" %>

                </button>


                <a
                    href="<%= request.getContextPath() %>/equipos"
                    class="btn btn-cancelar">

                    Cancelar

                </a>

            </div>

        </form>

    </div>

</div>

</body>

</html>