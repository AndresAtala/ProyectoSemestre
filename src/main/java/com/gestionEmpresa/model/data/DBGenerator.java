package com.gestionEmpresa.model.data;

import org.jooq.DSLContext;
import org.jooq.DataType;
import org.jooq.impl.DSL;

import java.sql.Connection;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.*;

public class DBGenerator {

    public static void iniciarBD(String nombreBD) throws ClassNotFoundException {
        Connection connection = DBConnector.connection("root", "");
        DSLContext create = DSL.using(connection);
        crearBaseDato(create, nombreBD);
        create = actualizarConexion(connection, nombreBD);
        crearTablas(create);
        DBConnector.closeConnection();
    }

    public static DSLContext conectarBD(String nombre) throws ClassNotFoundException {
        Connection connection = DBConnector.connection(nombre, "root", "");
        DSLContext create = DSL.using(connection);
        return create;
    }

    private static void crearBaseDato(DSLContext create, String nombreBD) {
        create.createDatabaseIfNotExists(nombreBD).execute();
    }

    private static DSLContext actualizarConexion(Connection connection, String nombreBD) {
        DBConnector.closeConnection();
        connection = DBConnector.connection(nombreBD, "root", "");
        DSLContext create = DSL.using(connection);
        return create;
    }


    private static void crearTablas(DSLContext create) {
        // Crear tabla Construccion
        create.createTableIfNotExists("Construccion")
                .column("tipoConstruccion", VARCHAR(50))
                .column("construccionesAdicionales", VARCHAR(100))
                .column("cantidadProductos", INTEGER)
                .column("presupuesto", DOUBLE)
                .execute();


        // Crear tabla Empleado
        create.createTableIfNotExists("Empleado")
                .column("rut", VARCHAR(50))
                .column("nombre", VARCHAR(100))
                .column("apellido", VARCHAR(100))
                .column("telefono", INTEGER)
                .column("rol", VARCHAR(50))
                .column("estado", VARCHAR(50))
                .column("salario", INTEGER)
                .constraint(primaryKey("rut"))
                .execute();

        // Crear tabla Empresa
        create.createTableIfNotExists("Empresa")
                .column("nombre", VARCHAR(100))
                .constraint(primaryKey("nombre"))
                .execute();

        // Crear tabla Inventario
        create.createTableIfNotExists("Inventario")
                .column("productoNombre", VARCHAR(100)) // Por ejemplo, asumiendo que el nombre del producto es una columna
                .constraint(primaryKey("productoNombre"))
                .execute();


        // Crear tabla Persona
        create.createTableIfNotExists("Persona")
                .column("rut", VARCHAR(50))
                .column("nombre", VARCHAR(100))
                .column("apellido", VARCHAR(100))
                .column("telefono", INTEGER)
                .column("rol", VARCHAR(50))
                .constraint(primaryKey("rut"))
                .execute();

        // Crear tabla Producto
        create.createTableIfNotExists("Producto")
                .column("nombre", VARCHAR(100))
                .column("precio", DOUBLE)
                .column("categoria", VARCHAR(50))
                .constraint(primaryKey("nombre"))
                .execute();

        // Establecer relaciones
        relacionarTabla(create, "ProductoConstruccion", "productoNombre", "Producto");
        relacionarTabla(create, "ProductoConstruccion", "tipoConstruccion", "Construccion");
        // ... Puedes establecer relaciones adicionales según tus necesidades.
    }

    private static void crearTablaUsuario(DSLContext create) {
        create.createTableIfNotExists("Usuario").column("rut", VARCHAR(50))
                .column("nombre", VARCHAR(100))
                .column("edad", INTEGER)
                .constraint(primaryKey("rut")).execute();
    }

    private static void relacionarTabla(DSLContext create, String nombreTabla, String claveForanea, String nombreTablaRelacion) {
        create.alterTableIfExists(nombreTabla).alterConstraint(foreignKey(claveForanea).references(nombreTablaRelacion)).enforced();
    }

    private static void agregarColumnaTabla(DSLContext create, String nombreTabla, String columna, DataType tipoColumna) {
        create.alterTableIfExists(nombreTabla).addColumn(columna, tipoColumna);
    }
}
