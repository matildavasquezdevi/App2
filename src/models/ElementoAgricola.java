package models;

import java.time.LocalDate;

/**
 * Clase abstracta que representa un elemento agrícola genérico.
 * Base para Cultivo y Actividad.
 */
public abstract class ElementoAgricola {
    protected String nombre;
    protected LocalDate fecha;
    protected String estado;

    public ElementoAgricola(String nombre, LocalDate fecha, String estado) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Método abstracto que las clases hijas deben implementar.
     * Retorna una descripción textual del objeto.
     */
    public abstract String obtenerDescripcion();
}
