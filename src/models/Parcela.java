package models;

import java.util.ArrayList;
import models.Cultivo;

/**
 * Clase que representa una parcela de tierra que puede contener múltiples cultivos.
 */
public class Parcela {
    // Código único que identifica la parcela (ej. "PARCELA-A01")
    private String codigo;

    // Tamaño de la parcela en hectáreas
    private double tamaño;

    // Descripción o nombre de la ubicación física de la parcela
    private String ubicacion;

    // Lista de cultivos asignados a esta parcela
    private ArrayList<Cultivo> cultivos;

    /**
     * Constructor de la clase Parcela.
     *
     * @param codigo Código único que identifica la parcela.
     * @param tamaño Tamaño en hectáreas.
     * @param ubicacion Descripción de la ubicación de la parcela.
     */
    public Parcela(String codigo, double tamaño, String ubicacion) {
        this.codigo = codigo;
        this.tamaño = tamaño;
        this.ubicacion = ubicacion;
        this.cultivos = new ArrayList<>();
    }

    /**
     * Asocia un cultivo a esta parcela.
     *
     * @param cultivo Cultivo que se va a agregar.
     */
    public void agregarCultivo(Cultivo cultivo) {
        cultivos.add(cultivo);
    }

    /**
     * Devuelve la lista completa de cultivos asignados a la parcela.
     *
     * @return Lista de objetos Cultivo.
     */
    public ArrayList<Cultivo> getCultivos() {
        return cultivos;
    }

    // Devuelve el código único de la parcela
    public String getCodigo() {
        return codigo;
    }

    // Devuelve el tamaño de la parcela en hectáreas
    public double getTamaño() {
        return tamaño;
    }

    // Devuelve la ubicación descriptiva de la parcela
    public String getUbicacion() {
        return ubicacion;
    }
}
