package com.gestionEmpresa.controller;

import com.gestionEmpresa.model.data.DBGenerator;
import com.gestionEmpresa.model.data.DAO.ProductoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;

import java.io.IOException;

@WebServlet(name = "ModificarPrecioServlet", value = "/ModificarPrecioServlet")
public class ModificarPrecioServlet extends HttpServlet {

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
        String nombreProducto = request.getParameter("nombreProducto");
        double nuevoPrecio = Double.parseDouble(request.getParameter("nuevoPrecio"));

        try {
            // Conectar a la base de datos
            DSLContext query = DBGenerator.conectarBD("Proyecto");

            // Crear una instancia del DAO
            ProductoDAO productoDAO = new ProductoDAO(query);

            // Lógica para modificar el precio
            boolean modificacionExitosa = productoDAO.modificarPrecio(nombreProducto, nuevoPrecio);

            // Redireccionar a una página de éxito o mostrar un mensaje
            if (modificacionExitosa) {
                response.sendRedirect("PrecioModificado.jsp");
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
