package com.gestionEmpresa.controller;

import com.gestionEmpresa.model.data.DBGenerator;
import com.gestionEmpresa.model.data.DAO.ConstruccionDAO;
import org.jooq.DSLContext;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/EliminarConstruccionServlet")
public class EliminarConstruccionServlet extends HttpServlet {
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
        String tipoConstruccion = request.getParameter("tipoConstruccion");

        try {
            // Conectar a la base de datos
            DSLContext query = DBGenerator.conectarBD("Proyecto");

            // Crear una instancia del DAO para Construccion
            ConstruccionDAO construccionDAO = new ConstruccionDAO(query);

            // Lógica para eliminar la construcción por su tipo
            boolean eliminacionExitosa = construccionDAO.eliminarConstruccion(tipoConstruccion);

            // Redireccionar a una página de éxito o mostrar un mensaje
            if (eliminacionExitosa) {
                response.sendRedirect("index.jsp");
            } else {
                // Puedes redirigir a una página de error personalizada si la eliminación falla
                response.sendRedirect("Error.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Manejar la excepción según tus necesidades
            response.sendRedirect("Error.jsp");
        }
    }
}
