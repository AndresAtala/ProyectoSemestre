package com.gestionEmpresa.model.data.DAO;

import com.gestionEmpresa.model.Empleado;
import com.gestionEmpresa.model.data.DBConnector;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

public class EmpleadoDAO {

    private final DSLContext create;

    public EmpleadoDAO(DSLContext create) {
        this.create = create;
    }

    public void agregarEmpleado(Empleado empleado) {
        create.insertInto(table("Empleado"))
                .columns(field("rut"), field("nombre"), field("apellido"), field("telefono"), field("rol"), field("estado"), field("salario"))
                .values(empleado.getRut(), empleado.getNombre(), empleado.getApellido(), empleado.getTelefono(), empleado.getRol(), empleado.getEstado(), empleado.getSalario())
                .execute();
    }

    public boolean borrarEmpleado(String rut) {
        int filasBorradas = create.deleteFrom(table("Empleado"))
                .where(field("rut").eq(rut))
                .execute();

        return filasBorradas > 0;
    }

    public boolean modificarEmpleado(Empleado empleado) {
        int filasActualizadas = create.update(table("Empleado"))
                .set(field("nombre"), empleado.getNombre())
                .set(field("apellido"), empleado.getApellido())
                .set(field("telefono"), empleado.getTelefono())
                .set(field("rol"), empleado.getRol())
                .set(field("estado"), empleado.getEstado())
                .set(field("salario"), empleado.getSalario())
                .where(field("rut").eq(empleado.getRut()))
                .execute();
        return filasActualizadas > 0;
    }

    public static List<Empleado> obtenerListaEmpleados(DSLContext create) {
        Result resultados = create.select().from(table("Empleado")).fetch();
        List<Empleado> empleados = new ArrayList<>();

        for (int fila = 0; fila < resultados.size(); fila++) {
            String rut = (String) resultados.getValue(fila, "rut");
            String nombre = (String) resultados.getValue(fila, "nombre");
            String apellido = (String) resultados.getValue(fila, "apellido");
            int telefono = (Integer) resultados.getValue(fila, "telefono");
            String rol = (String) resultados.getValue(fila, "rol");
            String estado = (String) resultados.getValue(fila, "estado");
            int salario = (Integer) resultados.getValue(fila, "salario");

            empleados.add(new Empleado(rut, nombre, apellido, telefono, rol, estado, salario));
        }

        return empleados;
    }
}
