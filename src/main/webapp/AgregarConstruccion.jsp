<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Agregar Construcción</title>
</head>
<body>

<h1>Agregar Construcción</h1>

<form action="AgregarConstruccionServlet" method="post">
    <label for="tipoConstruccion">Tipo de Construcción:</label>
    <input type="text" id="tipoConstruccion" name="tipoConstruccion" required><br>

    <label for="construccionesAdicionales">Construcciones Adicionales:</label>
    <input type="text" id="construccionesAdicionales" name="construccionesAdicionales"><br>

    <label for="cantidadProductos">Cantidad de Productos:</label>
    <input type="number" id="cantidadProductos" name="cantidadProductos" required><br>

    <label for="presupuesto">Presupuesto:</label>
    <input type="number" id="presupuesto" name="presupuesto" required><br>

    <input type="submit" value="Agregar Construcción">
</form>

</body>
</html>
