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

@WebServlet(name = "AgregarProductoServlet", value = "/AgregarProductoServlet")
public class AgregarProductoServlet extends HttpServlet {
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
            // Recuperar información del formulario
            String nombreProducto = req.getParameter("nombreProducto");
            double precio = Double.parseDouble(req.getParameter("precio"));
            String categoria = req.getParameter("categoria");

            // Crear objeto Producto
            Producto producto = new Producto(nombreProducto, precio, categoria);

            // Conectar a la base de datos
            DSLContext query = DBGenerator.conectarBD("Proyecto");

            // Crear instancia de ProductoDAO y agregar producto
            ProductoDAO productoDAO = new ProductoDAO(query);
            productoDAO.agregarProducto(producto);

            // Redireccionar a la página principal o realizar alguna acción adicional
            resp.sendRedirect("ProductoAgregado.jsp");

        } catch (NumberFormatException e) {
            e.printStackTrace();
            resp.sendRedirect("Error.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("Error.jsp");
        }
    }
}
