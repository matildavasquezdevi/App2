package models;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Clase que representa un cultivo agrícola en el sistema.
 * Hereda los atributos comunes desde ElementoAgricola.
 */
public class Cultivo extends ElementoAgricola {
    // Identificador único del cultivo
    private int id;

    // Variedad del cultivo, por ejemplo "Premium", "Cherry", etc.
    private String variedad;

    // Superficie sembrada en hectáreas
    private double superficie;

    // Código de la parcela donde se encuentra el cultivo
    private String codigoParcela;

    // Lista de actividades relacionadas al cultivo (riego, cosecha, etc.)
    private ArrayList<Actividad> actividades;

    /**
     * Constructor principal para crear cultivo desde App.
     */
    public Cultivo(String nombre, String variedad, double superficie, String codigoParcela,
                   LocalDate fechaSiembra, String estado) {
        super(nombre, fechaSiembra, estado);
        this.variedad = variedad;
        this.superficie = superficie;
        this.codigoParcela = codigoParcela;
        this.actividades = new ArrayList<>();
    }

    /**
     * Constructor secundario para uso desde CSVHandler.
     */
    public Cultivo(int id, String nombre, String variedad, String estado, double superficie) {
        super(nombre, null, estado);
        this.id = id;
        this.variedad = variedad;
        this.superficie = superficie;
        this.codigoParcela = "";
        this.actividades = new ArrayList<>();
    }

    // Agrega una nueva actividad
    public void agregarActividad(Actividad act) {
        actividades.add(act);
    }

    public ArrayList<Actividad> getActividades() {
        return actividades;
    }

    public String getVariedad() {
        return variedad;
    }

    public double getSuperficie() {
        return superficie;
    }

    public String getCodigoParcela() {
        return codigoParcela;
    }

    public int getId() {
        return id;
    }

    public void setCodigoParcela(String codigo) {
        this.codigoParcela = codigo;
    }

    public void setFechaSiembra(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String obtenerDescripcion() {
        return nombre + " (" + variedad + ") - " + estado;
    }
}
