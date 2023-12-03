<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mostrar Empleados</title>
</head>
<body>

<h2>Lista de Empleados</h2>

<c:choose>
    <c:when test="${not empty requestScope.Empleado}">
        <table border="1">
            <tr>
                <th>RUT</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Teléfono</th>
                <th>Rol</th>
                <th>Estado</th>
                <th>Salario</th>
            </tr>
            <c:forEach var="empleado" items="${requestScope.Empleado}">
                <tr>
                    <td>${empleado.rut}</td>
                    <td>${empleado.nombre}</td>
                    <td>${empleado.apellido}</td>
                    <td>${empleado.telefono}</td>
                    <td>${empleado.rol}</td>
                    <td>${empleado.estado}</td>
                    <td>${empleado.salario}</td>
                </tr>
            </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
        <p>No hay empleados para mostrar.</p>
    </c:otherwise>
</c:choose>

</body>
</html>
