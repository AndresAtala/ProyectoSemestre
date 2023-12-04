<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mostrar Productos</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>

<h2>Lista de Productos</h2>

<c:choose>
    <c:when test="${not empty requestScope.Producto}">
        <table border="1">
            <tr>
                <th>Nombre</th>
                <th>Precio</th>
                <th>Categoría</th>
            </tr>
            <c:forEach var="producto" items="${requestScope.Producto}">
                <tr>
                    <td>${producto.nombre}</td>
                    <td>${producto.precio}</td>
                    <td>${producto.categoria}</td>
                </tr>
            </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
        <p>No hay productos para mostrar.</p>
    </c:otherwise>
</c:choose>

</body>
</html>

