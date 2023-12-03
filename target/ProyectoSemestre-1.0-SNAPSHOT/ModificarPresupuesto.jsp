<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modificar Presupuesto</title>
</head>
<body>

<h1>Modificar Presupuesto</h1>

<form action="ModificarPresupuestoServlet" method="post">
    <label for="tipoConstruccion">Tipo de Construcción:</label>
    <input type="text" id="tipoConstruccion" name="tipoConstruccion" required><br>

    <label for="nuevoPresupuesto">Nuevo Presupuesto:</label>
    <input type="text" id="nuevoPresupuesto" name="nuevoPresupuesto" required><br>

    <input type="submit" value="Modificar Presupuesto">
</form>

</body>
</html>
