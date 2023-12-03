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

@WebServlet(name = "agregarEmpleadoServlet", value = "/AgregarEmpleadoServlet")
public class AgregarEmpleadoServlet extends HttpServlet {
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("Proyecto");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String nombre = req.getParameter("nombre");
            String apellido = req.getParameter("apellido");
            String rut = req.getParameter("rut");
            int telefono = Integer.parseInt(req.getParameter("telefono"));
            String rol = req.getParameter("rol");
            String estado = req.getParameter("estado");
            int salario = Integer.parseInt(req.getParameter("salario"));

            Empleado empleado = new Empleado(nombre, apellido, rut, telefono, rol, estado, salario);

            DSLContext query = DBGenerator.conectarBD("Proyecto");
            EmpleadoDAO empleadoDAO = new EmpleadoDAO(query);
            empleadoDAO.agregarEmpleado(empleado);
            resp.sendRedirect("EmpleadoAgregado.jsp");

        } catch (NumberFormatException e) {
            e.printStackTrace();
            resp.sendRedirect("Error.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("Error.jsp");
        }
    }
}

