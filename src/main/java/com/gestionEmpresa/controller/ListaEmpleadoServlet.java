package com.gestionEmpresa.controller;

import com.gestionEmpresa.model.Empleado;
import com.gestionEmpresa.model.data.DBGenerator;
import com.gestionEmpresa.model.data.DAO.EmpleadoDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "listaEmpleadoServlet", value = "/MostrarEmpleados")
public class ListaEmpleadoServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("Proyecto");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("empleados", agregarEmpleadosEjemplo());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        RequestDispatcher respuesta = req.getRequestDispatcher("/MostrarEmpleados.jsp");
        respuesta.forward(req, resp);
    }

    private List<Empleado> agregarEmpleadosEjemplo() throws ClassNotFoundException {
        return EmpleadoDAO.obtenerListaEmpleados(DBGenerator.conectarBD("Proyecto"));
    }

}
