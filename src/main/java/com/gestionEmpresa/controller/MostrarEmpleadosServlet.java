package com.gestionEmpresa.controller;

import com.gestionEmpresa.model.Empleado;
import com.gestionEmpresa.model.data.DAO.EmpleadoDAO;
import com.gestionEmpresa.model.data.DBGenerator;
import org.jooq.DSLContext;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "mostrarEmpleadosServlet", value = "/MostrarEmpleados")
public class MostrarEmpleadosServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("Proyecto");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Obtener el contexto DSL
            DSLContext create = DBGenerator.conectarBD("Proyecto");

            // Crear instancia de EmpleadoDAO fuera del bloque try
            EmpleadoDAO empleadoDAO = new EmpleadoDAO(create);

            // Obtener la lista de empleados
            List<Empleado> empleados = empleadoDAO.obtenerTodosEmpleados();

            // Agregar la lista de empleados al objeto request con el nombre correcto
            request.setAttribute("Empleado", empleados);

            // Enviar la solicitud al JSP para mostrar la lista
            request.getRequestDispatcher("/MostrarEmpleados.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}

