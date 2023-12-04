<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modificar Precio</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<h2>Modificar Precio del Producto</h2>
<form action="ModificarPrecioServlet" method="post">
    <label for="nombreProducto">Nombre del Producto:</label>
    <input type="text" id="nombreProducto" name="nombreProducto" required>
    <br>
    <label for="nuevoPrecio">Nuevo Precio:</label>
    <input type="number" id="nuevoPrecio" name="nuevoPrecio" step="0.01" required>
    <br>
    <input type="submit" value="Modificar Precio">
</form>
</body>
</html>
