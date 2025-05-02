package models;

import java.time.LocalDate;

/**
 * Clase abstracta que representa un elemento agrícola genérico.
 * Será la base para clases como Cultivo y Actividad.
 */
public abstract class ElementoAgricola {
    // Nombre del cultivo o actividad
    protected String nombre;

    // Fecha asociada (por ejemplo, siembra o día de actividad)
    protected LocalDate fecha;

    // Estado del elemento ("ACTIVO", "COSECHADO", "COMPLETADA", etc.)
    protected String estado;

    /**
     * Constructor que inicializa los atributos comunes de cualquier elemento agrícola.
     *
     * @param nombre Nombre del cultivo o actividad.
     * @param fecha Fecha relevante del evento (siembra o acción).
     * @param estado Estado del elemento (ACTIVO, EN_RIESGO, COSECHADO, etc.).
     */
    public ElementoAgricola(String nombre, LocalDate fecha, String estado) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.estado = estado;
    }

    // Devuelve el nombre del elemento (cultivo o actividad)
    public String getNombre() {
        return nombre;
    }

    // Devuelve la fecha asociada
    public LocalDate getFecha() {
        return fecha;
    }

    // Devuelve el estado actual del elemento
    public String getEstado() {
        return estado;
    }

    /**
     * Método abstracto que obliga a las clases hijas a implementar una descripción personalizada.
     * Por ejemplo: "Trigo (Premium) - ACTIVO" o "FERTILIZACIÓN - 2023-03-20"
     */
    public abstract String obtenerDescripcion();
}
