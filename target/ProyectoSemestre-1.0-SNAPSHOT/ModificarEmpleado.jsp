<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modificar Empleado</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>

<h1>Modificar Empleado</h1>

<form action="ModificarEmpleadoServlet" method="post">
    <label for="rut">Rut del Empleado:</label>
    <input type="text" id="rut" name="rut" required><br>

    <label for="nombre">Nuevo Nombre:</label>
    <input type="text" id="nombre" name="nombre" required><br>

    <label for="apellido">Nuevo Apellido:</label>
    <input type="text" id="apellido" name="apellido" required><br>

    <label for="telefono">Nuevo Teléfono:</label>
    <input type="text" id="telefono" name="telefono" required><br>

    <label for="rol">Nuevo Rol:</label>
    <input type="text" id="rol" name="rol" required><br>

    <label for="estado">Nuevo Estado:</label>
    <input type="text" id="estado" name="estado" required><br>

    <label for="salario">Nuevo Salario:</label>
    <input type="text" id="salario" name="salario" required><br>

    <input type="submit" value="Modificar Empleado">
</form>

</body>
</html>

