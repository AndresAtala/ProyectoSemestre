<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Agregar Producto</title>
</head>
<body>

<h1>Agregar Producto</h1>

<form action="AgregarProductoServlet" method="post">
    <label>Nombre del Producto:</label>
    <input type="text" name="nombreProducto" required><br>

    <label>Precio:</label>
    <input type="number" name="precio" required><br>

    <label>Categoría:</label>
    <input type="text" name="categoria" required><br>

    <input type="submit" value="Agregar Producto">
</form>

</body>
</html>
