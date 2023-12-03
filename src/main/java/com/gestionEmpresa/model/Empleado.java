package com.gestionEmpresa.model;

public class Empleado extends Persona {
    public String estado;
    public int salario;

    public Empleado(String nombre, String apellido, String rut, int telefono, String rol, String estado, int salario) {
        super(nombre, apellido, rut, telefono, rol);
        this.estado = estado;
        this.salario = salario;
    }


    @Override
    public String toString() {
        return "Empleado{" +
                "estado='" + estado + '\'' +
                ", salario=" + salario +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", rut='" + rut + '\'' +
                ", telefono=" + telefono +
                ", rol='" + rol + '\'' +
                '}';
    }

    public String isEstado() {
        return estado;
    }

    public String getEstado() {
        return estado;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String[] getDatos(Empleado empleado) {
        String[] datos = new String[9]; //arrglo para almacenar y obtener los datos de cada trabajador
        datos[0] = empleado.getNombre();
        datos[1] = empleado.getApellido();
        datos[2] = empleado.getRut();
        datos[3] = Integer.toString(empleado.getTelefono());
        datos[4] = empleado.getRol();
        datos[5] = Integer.toString(empleado.getSalario());
        datos[6] = empleado.estado;
        return datos;
    }
}
