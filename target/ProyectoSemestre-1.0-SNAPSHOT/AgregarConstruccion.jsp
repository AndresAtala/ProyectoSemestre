<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Agregar Construccion</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>

<body>
<h2>Agregar Construcción</h2>
<form action="AgregarConstruccionServlet" method="post">
    Tipo de Construcción: <input type="text" name="tipoConstruccion" required><br>
    Construcciones Adicionales: <input type="text" name="construccionesAdicionales"><br>
    Cantidad de Productos: <input type="number" name="cantidadProductos" required><br>
    Presupuesto: <input type="text" name="presupuesto" required><br>
    <input type="submit" value="Agregar Construcción">
</form>
</body>
</html>
