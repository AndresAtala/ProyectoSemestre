package com.gestionEmpresa.controller;

import com.gestionEmpresa.model.Empleado;
import com.gestionEmpresa.model.data.DBGenerator;
import com.gestionEmpresa.model.data.DAO.EmpleadoDAO;
import org.jooq.DSLContext;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ModificarEmpleadoServlet")
public class ModificarEmpleadoServlet extends HttpServlet {
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("Proyecto");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener parámetros del formulario
        String rut = request.getParameter("rut");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        int telefono = Integer.parseInt(request.getParameter("telefono"));
        String rol = request.getParameter("rol");
        String estado = request.getParameter("estado");
        int salario = Integer.parseInt(request.getParameter("salario"));

        Empleado empleado = new Empleado(rut, nombre, apellido, telefono, rol, estado, salario);

        try {
            // Conectar a la base de datos
            DSLContext query = DBGenerator.conectarBD("Proyecto");

            // Crear una instancia del DAO
            EmpleadoDAO empleadoDAO = new EmpleadoDAO(query);

            // Lógica para modificar el empleado
            boolean modificacionExitosa = empleadoDAO.modificarEmpleado(empleado);

            // Redireccionar a una página de éxito o mostrar un mensaje
            if (modificacionExitosa) {
                response.sendRedirect("EmpleadoModificado.jsp");
            } else {
                // Puedes redirigir a una página de error personalizada si la modificación falla
                response.sendRedirect("Error.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Manejar la excepción según tus necesidades
            response.sendRedirect("Error.jsp");
        }
    }
}

