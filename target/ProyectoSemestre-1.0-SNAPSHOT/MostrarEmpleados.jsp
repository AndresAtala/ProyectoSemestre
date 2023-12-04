<%@ page import="java.util.List" %>
<%@ page import="com.gestionEmpresa.model.Empleado" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mostrar Empleado</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>

<h2>Lista de Empleados</h2>

<%
    List<Empleado> empleados = (List<Empleado>) request.getAttribute("empleados");
%>

<% if (empleados != null && !empleados.isEmpty()) { %>

<table border="1">
    <thead>
    <tr>
        <th>Rut</th>
        <th>Nombre</th>
        <th>Apellido</th>
        <th>Teléfono</th>
        <th>Rol</th>
        <th>Estado</th>
        <th>Salario</th>
    </tr>
    </thead>
    <tbody>
    <% for (Empleado empleado : empleados) { %>
    <tr>
        <td><%= empleado.getRut() %></td>
        <td><%= empleado.getNombre() %></td>
        <td><%= empleado.getApellido() %></td>
        <td><%= empleado.getTelefono() %></td>
        <td><%= empleado.getRol() %></td>
        <td><%= empleado.getEstado() %></td>
        <td><%= empleado.getSalario() %></td>
    </tr>
    <% } %>
    </tbody>
</table>

<% } else { %>

<p>No hay empleados para mostrar.</p>

<% } %>

</body>
</html>
