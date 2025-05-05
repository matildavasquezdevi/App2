package models;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Clase que representa un cultivo agrícola en el sistema.
 * Hereda los atributos comunes desde ElementoAgricola.
 */
public class Cultivo extends ElementoAgricola {
    private int id;
    private String variedad;
    private double superficie;
    private String codigoParcela;
    private ArrayList<Actividad> actividades;

    /**
     * Constructor principal usado en la lógica del programa.
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
     * Constructor usado por CSVHandler para lectura.
     */
    public Cultivo(int id, String nombre, String variedad, String estado, double superficie,
                   String codigoParcela, LocalDate fechaSiembra) {
        super(nombre, fechaSiembra, estado);
        this.id = id;
        this.variedad = variedad;
        this.superficie = superficie;
        this.codigoParcela = codigoParcela;
        this.actividades = new ArrayList<>();
    }

    public int getId() {
        return id;
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

    public ArrayList<Actividad> getActividades() {
        return actividades;
    }

    public void agregarActividad(Actividad act) {
        actividades.add(act);
    }

    public void setCodigoParcela(String codigoParcela) {
        this.codigoParcela = codigoParcela;
    }

    @Override
    public String obtenerDescripcion() {
        return nombre + " (" + variedad + ") - " + estado + " - " + codigoParcela;
    }
}
