package com.gestionEmpresa.model.data.DAO;

import com.gestionEmpresa.model.Construccion;
import org.jooq.DSLContext;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

public class ConstruccionDAO {

    private final DSLContext create;

    public ConstruccionDAO(DSLContext create) {
        this.create = create;
    }

    public void agregarConstruccion(Construccion construccion) {
        create.insertInto(table("Construccion"))
                .columns(field("tipoConstruccion"), field("construccionesAdicionales"), field("cantidadProductos"), field("presupuesto"))
                .values(construccion.getTipoConstruccion(), construccion.getConstruccionesAdicionales(), construccion.getCantidadProductos(), construccion.getPresupuesto())
                .execute();
    }

    public boolean modificarPresupuesto(String tipoConstruccion, double nuevoPresupuesto) {
        return create.update(table("Construccion"))
                .set(field("presupuesto"), nuevoPresupuesto)
                .where(field("tipoConstruccion").eq(tipoConstruccion))  // Corregir el nombre de la columna en la cláusula WHERE
                .execute() > 0;
    }
    public boolean eliminarConstruccion(String tipoConstruccion) {
        return create.deleteFrom(table("Construccion"))
                .where(field("tipoConstruccion").eq(tipoConstruccion))
                .execute() > 0;
    }

}


