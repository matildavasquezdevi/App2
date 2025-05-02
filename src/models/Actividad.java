package models;

import java.time.LocalDate;

/**
 * Clase que representa una actividad asociada a un cultivo.
 * Por ejemplo: riego, fertilización, cosecha, fumigación, etc.
 * Hereda los atributos comunes desde ElementoAgricola.
 */
public class Actividad extends ElementoAgricola {

    /**
     * Constructor de Actividad.
     *
     * @param tipoActividad Tipo de la actividad (ej: "RIEGO", "COSECHA").
     * @param fecha Fecha en que se programó o realizó la actividad.
     * @param estado Estado de la actividad: "PENDIENTE" o "COMPLETADA".
     */
    public Actividad(String tipoActividad, LocalDate fecha, String estado) {
        // Se inicializa usando el constructor de la clase abstracta padre
        super(tipoActividad, fecha, estado);
    }

    /**
     * Implementación del método abstracto.
     * Devuelve una descripción completa de la actividad.
     * Ejemplo: "RIEGO - 2023-03-15 [PENDIENTE]"
     *
     * @return Descripción textual de la actividad.
     */
    @Override
    public String obtenerDescripcion() {
        return nombre + " - " + fecha.toString() + " [" + estado + "]";
    }
}
