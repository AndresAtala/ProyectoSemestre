package com.gestionEmpresa.model.data.DAO;

import com.gestionEmpresa.model.Producto;
import org.jooq.DSLContext;

import java.util.List;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

public class ProductoDAO {

    private final DSLContext create;

    public ProductoDAO(DSLContext create) {
        this.create = create;
    }

    public void agregarProducto(Producto producto) {
        create.insertInto(table("Producto"))
                .columns(field("nombre"), field("precio"), field("categoria"))
                .values(producto.getNombre(), producto.getPrecio(), producto.getCategoria())
                .execute();
    }

    public List<Producto> obtenerTodosProductos() {
        try {
            List<Producto> productos = create.selectFrom(table("Producto"))
                    .fetchInto(Producto.class);

            System.out.println("Número de productos encontrados: " + productos.size());

            for (Producto producto : productos) {
                System.out.println(producto);
            }

            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener todos los productos", e);
        }
    }
    public List<String> obtenerNombresProductos() {
        try {
            List<String> nombresProductos = create.select(field("nombre"))
                    .from(table("Producto"))
                    .fetchInto(String.class);

            System.out.println("Número de productos encontrados: " + nombresProductos.size());

            for (String nombreProducto : nombresProductos) {
                System.out.println(nombreProducto);
            }

            return nombresProductos;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener los nombres de productos", e);
        }
    }
}
