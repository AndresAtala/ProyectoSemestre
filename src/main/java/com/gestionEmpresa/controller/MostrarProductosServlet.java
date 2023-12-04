package com.gestionEmpresa.controller;

import com.gestionEmpresa.model.Producto;
import com.gestionEmpresa.model.data.DAO.ProductoDAO;
import com.gestionEmpresa.model.data.DBGenerator;
import org.jooq.DSLContext;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "mostrarProductosServlet", value = "/MostrarProductos")
public class MostrarProductosServlet extends HttpServlet {

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

            // Crear instancia de ProductoDAO fuera del bloque try
            ProductoDAO productoDAO = new ProductoDAO(create);

            // Obtener la lista de productos
            List<Producto> productos = productoDAO.obtenerTodosProductos();

            // Agregar la lista de productos al objeto request con el nombre correcto
            request.setAttribute("Producto", productos);

            // Antes de la redirección al JSP, agrega mensajes de depuración
            request.getRequestDispatcher("/MostrarProductos.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
