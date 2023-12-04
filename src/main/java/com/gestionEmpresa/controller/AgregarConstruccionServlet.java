package com.gestionEmpresa.controller;

import com.gestionEmpresa.model.Construccion;
import com.gestionEmpresa.model.data.DAO.ConstruccionDAO;
import com.gestionEmpresa.model.data.DBGenerator;
import org.jooq.DSLContext;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "agregarConstruccionServlet", value = "/AgregarConstruccionServlet")
public class AgregarConstruccionServlet extends HttpServlet {
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
            String tipoConstruccion = req.getParameter("tipoConstruccion");
            String construccionesAdicionales = req.getParameter("construccionesAdicionales");
            int cantidadProductos = Integer.parseInt(req.getParameter("cantidadProductos"));
            double presupuesto = Double.parseDouble(req.getParameter("presupuesto"));

            Construccion construccion = new Construccion(tipoConstruccion, construccionesAdicionales, cantidadProductos, presupuesto);

            DSLContext query = DBGenerator.conectarBD("Proyecto");
            ConstruccionDAO construccionDAO = new ConstruccionDAO(query);
            construccionDAO.agregarConstruccion(construccion);
            resp.sendRedirect("ConstruccionAgregada.jsp");

        } catch (NumberFormatException e) {
            e.printStackTrace();
            resp.sendRedirect("Error.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("Error.jsp");
        }
    }
}
