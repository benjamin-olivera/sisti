<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="es">

<head>

    <meta charset="UTF-8">

    <title>SISTI - Sistema Integral</title>

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

        .header {
            background: #212529;
            color: white;
            padding: 25px 40px;
        }

        .header h1 {
            margin: 0;
            font-size: 30px;
        }

        .header p {
            margin: 8px 0 0;
            color: #d1d1d1;
        }

        .container {
            width: 92%;
            max-width: 1200px;
            margin: 35px auto;
        }

        .titulo {
            margin-bottom: 25px;
        }

        .titulo h2 {
            margin: 0;
        }

        .titulo p {
            color: #666;
        }

        .menu {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(220px, 1fr));
            gap: 20px;
        }

        .card {
            background: white;
            padding: 25px;
            border-radius: 10px;
            text-decoration: none;
            color: #222;
            box-shadow: 0 4px 12px rgba(0,0,0,0.08);
            transition: 0.2s;
            border: 1px solid #eee;
        }

        .card:hover {
            transform: translateY(-4px);
            box-shadow: 0 7px 18px rgba(0,0,0,0.15);
        }

        .icono {
            font-size: 32px;
            margin-bottom: 12px;
        }

        .card h3 {
            margin: 0 0 8px;
        }

        .card p {
            margin: 0;
            color: #666;
            font-size: 14px;
        }

        .footer {
            text-align: center;
            color: #777;
            margin: 40px 0 20px;
            font-size: 13px;
        }

    </style>

</head>

<body>

<header class="header">

    <h1>SISTI</h1>

    <p>
        Sistema Integral de Gestión de Equipos y Soporte TI
    </p>

</header>


<div class="container">

    <div class="titulo">

        <h2>Menú Principal</h2>

        <p>
            Seleccione el módulo que desea administrar.
        </p>

    </div>


    <div class="menu">


        <!-- EQUIPOS -->

        <a href="${pageContext.request.contextPath}/equipos"
           class="card">

            <div class="icono">💻</div>

            <h3>Equipos</h3>

            <p>
                Gestión de equipos informáticos.
            </p>

        </a>


        <!-- ÁREAS -->

        <a href="${pageContext.request.contextPath}/areas"
           class="card">

            <div class="icono">🏢</div>

            <h3>Áreas</h3>

            <p>
                Gestión de áreas de la organización.
            </p>

        </a>


        <!-- MARCAS -->

        <a href="${pageContext.request.contextPath}/marcas"
           class="card">

            <div class="icono">🏷️</div>

            <h3>Marcas</h3>

            <p>
                Administración de marcas de equipos.
            </p>

        </a>


        <!-- TIPOS -->

        <a href="${pageContext.request.contextPath}/tipos"
           class="card">

            <div class="icono">🖥️</div>

            <h3>Tipos de Equipo</h3>

            <p>
                Gestión de tipos y categorías de equipos.
            </p>

        </a>


        <!-- USUARIOS -->

        <a href="${pageContext.request.contextPath}/usuarios"
           class="card">

            <div class="icono">👤</div>

            <h3>Usuarios</h3>

            <p>
                Gestión de usuarios y personal.
            </p>

        </a>


        <!-- PROVEEDORES -->

        <a href="${pageContext.request.contextPath}/proveedores"
           class="card">

            <div class="icono">🏪</div>

            <h3>Proveedores</h3>

            <p>
                Administración de proveedores.
            </p>

        </a>


        <!-- GARANTÍAS -->

        <a href="${pageContext.request.contextPath}/garantias"
           class="card">

            <div class="icono">🛡️</div>

            <h3>Garantías</h3>

            <p>
                Control de garantías de equipos.
            </p>

        </a>


        <!-- ASIGNACIONES -->

        <a href="${pageContext.request.contextPath}/asignaciones"
           class="card">

            <div class="icono">📋</div>

            <h3>Asignaciones</h3>

            <p>
                Control de asignación y devolución.
            </p>

        </a>


        <!-- MANTENIMIENTOS -->

        <a href="${pageContext.request.contextPath}/mantenimientos"
           class="card">

            <div class="icono">🔧</div>

            <h3>Mantenimientos</h3>

            <p>
                Registro y seguimiento de mantenimientos.
            </p>

        </a>


        <!-- ROLES -->

        <a href="${pageContext.request.contextPath}/roles"
           class="card">

            <div class="icono">🔐</div>

            <h3>Roles</h3>

            <p>
                Administración de roles del sistema.
            </p>

        </a>


        <!-- USUARIOS DEL SISTEMA -->

        <a href="${pageContext.request.contextPath}/usuarios-sistema"
           class="card">

            <div class="icono">⚙️</div>

            <h3>Usuarios del Sistema</h3>

            <p>
                Administración de cuentas de acceso.
            </p>

        </a>


    </div>


    <div class="footer">

        SISTI - Sistema Integral de Gestión de Equipos y Soporte TI

    </div>

</div>

</body>

</html>