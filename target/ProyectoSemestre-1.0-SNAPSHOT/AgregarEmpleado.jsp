<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Agregar Empleado</title>
</head>
<body>

<h1>Agregar Empleado</h1>

<form action="AgregarEmpleadoServlet" method="post">
    <label for="nombre">Nombre:</label>
    <input type="text" id="nombre" name="nombre" required><br>

    <label for="apellido">Apellido:</label>
    <input type="text" id="apellido" name="apellido" required><br>

    <label for="rut">Rut:</label>
    <input type="text" id="rut" name="rut" required><br>

    <label for="telefono">Teléfono:</label>
    <input type="text" id="telefono" name="telefono" required><br>

    <label for="rol">Rol:</label>
    <input type="text" id="rol" name="rol" required><br>

    <label for="estado">Estado:</label>
    <input type="text" id="estado" name="estado" required><br>

    <label for="salario">Salario:</label>
    <input type="text" id="salario" name="salario" required><br>

    <input type="submit" value="Agregar Empleado">
</form>

</body>
</html>
