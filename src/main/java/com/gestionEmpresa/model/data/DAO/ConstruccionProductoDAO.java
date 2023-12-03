package com.gestionEmpresa.model.data.DAO;

import org.jooq.DSLContext;

import java.util.List;

import static org.jooq.impl.DSL.*;

public class ConstruccionProductoDAO {

    private final DSLContext create;

    public ConstruccionProductoDAO(DSLContext create) {
        this.create = create;
    }

    public void asociarProductosAConstruccion(int construccionId, List<Integer> productoIds) {
        for (int productoId : productoIds) {
            create.insertInto(table("ConstruccionProducto"))
                    .columns(field("construccion_id"), field("producto_id"))
                    .values(construccionId, productoId)
                    .execute();
        }
    }
}
