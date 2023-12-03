<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Eliminar Empleado</title>
</head>
<body>

<h1>Eliminar Empleado</h1>

<form action="EliminarEmpleadoServlet" method="post">
    <label for="rut">Rut del Empleado a Eliminar:</label>
    <input type="text" id="rut" name="rut" required><br>

    <input type="submit" value="Eliminar Empleado">
</form>

</body>
</html>
