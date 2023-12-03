package com.gestionEmpresa.controller;

import com.gestionEmpresa.model.data.DBGenerator;
import com.gestionEmpresa.model.data.DAO.EmpleadoDAO;
import org.jooq.DSLContext;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/EliminarEmpleadoServlet")
public class EliminarEmpleadoServlet extends HttpServlet {
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("Proyecto");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener parámetros del formulario
        String rut = request.getParameter("rut");

        try {
            // Conectar a la base de datos
            DSLContext query = DBGenerator.conectarBD("Proyecto");

            // Crear una instancia del DAO para Empleado
            EmpleadoDAO empleadoDAO = new EmpleadoDAO(query);

            // Lógica para eliminar el empleado por su rut
            boolean eliminacionExitosa = empleadoDAO.borrarEmpleado(rut);

            // Redireccionar a una página de éxito o mostrar un mensaje
            if (eliminacionExitosa) {
                response.sendRedirect("exito.jsp");
            } else {
                // Puedes redirigir a una página de error personalizada si la eliminación falla
                response.sendRedirect("error.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Manejar la excepción según tus necesidades
            response.sendRedirect("error.jsp");
        }
    }
}
