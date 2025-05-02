package models;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Clase que representa un cultivo agrícola en el sistema.
 * Hereda los atributos comunes desde ElementoAgricola.
 */
public class Cultivo extends ElementoAgricola {
    // Variedad del cultivo, por ejemplo "Premium", "Cherry", etc.
    private String variedad;

    // Superficie sembrada en hectáreas
    private double superficie;

    // Código de la parcela donde se encuentra el cultivo
    private String codigoParcela;

    // Lista de actividades relacionadas al cultivo (riego, cosecha, etc.)
    private ArrayList<Actividad> actividades;

    /**
     * Constructor de Cultivo.
     *
     * @param nombre Nombre del cultivo (ej. "Trigo").
     * @param variedad Tipo o subtipo del cultivo (ej. "Dulce").
     * @param superficie Superficie sembrada en hectáreas.
     * @param codigoParcela Código de la parcela asociada (ej. "PARCELA-A01").
     * @param fechaSiembra Fecha en que se sembró el cultivo.
     * @param estado Estado del cultivo: "ACTIVO", "EN_RIESGO", "COSECHADO".
     */
    public Cultivo(String nombre, String variedad, double superficie, String codigoParcela,
                   LocalDate fechaSiembra, String estado) {
        super(nombre, fechaSiembra, estado); // inicializa los atributos heredados
        this.variedad = variedad;
        this.superficie = superficie;
        this.codigoParcela = codigoParcela;
        this.actividades = new ArrayList<>();
    }

    /**
     * Agrega una nueva actividad (riego, fertilización, etc.) al cultivo.
     *
     * @param act Actividad que se quiere agregar a la lista.
     */
    public void agregarActividad(Actividad act) {
        actividades.add(act);
    }

    /**
     * Retorna todas las actividades asociadas a este cultivo.
     *
     * @return Lista de actividades (ArrayList).
     */
    public ArrayList<Actividad> getActividades() {
        return actividades;
    }

    // Devuelve la variedad del cultivo
    public String getVariedad() {
        return variedad;
    }

    // Devuelve la superficie sembrada
    public double getSuperficie() {
        return superficie;
    }

    // Devuelve el código de la parcela asignada
    public String getCodigoParcela() {
        return codigoParcela;
    }

    /**
     * Implementación del método abstracto heredado.
     * Retorna una descripción simple del cultivo.
     *
     * @return Descripción textual del cultivo.
     */
    @Override
    public String obtenerDescripcion() {
        return nombre + " (" + variedad + ") - " + estado;
    }
}
