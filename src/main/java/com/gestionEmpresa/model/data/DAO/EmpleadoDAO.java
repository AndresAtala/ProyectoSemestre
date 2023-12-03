package com.gestionEmpresa.model.data.DAO;

import com.gestionEmpresa.model.Empleado;
import org.jooq.DSLContext;

import java.util.List;

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

    public List<Empleado> obtenerTodosEmpleados() {
        try {
            List<Empleado> empleados = create.selectFrom(table("Empleado"))
                    .fetchInto(Empleado.class);

            System.out.println("Número de empleados encontrados: " + empleados.size());

            // Imprimir los empleados para depuración
            for (Empleado empleado : empleados) {
                System.out.println(empleado);
            }

            return empleados;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener todos los empleados", e);
        }
    }
}
