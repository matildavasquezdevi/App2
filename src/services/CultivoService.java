package services;

import models.Cultivo;

import java.util.List;
import java.util.ArrayList;

public class CultivoService {

    private List<Cultivo> cultivos;

    // El constructor ahora recibe la lista original (compartida con el main)
    public CultivoService(List<Cultivo> cultivos) {
        this.cultivos = cultivos;
    }

    /** Agrega un nuevo cultivo */
    public void agregarCultivo(Cultivo cultivo) {
        cultivos.add(cultivo);
    }

    /** Devuelve la lista de cultivos */
    public List<Cultivo> listarCultivos() {
        return cultivos;
    }

    /** Busca un cultivo por nombre (case-insensitive) */
    public Cultivo buscarCultivo(String nombre) {
        for (Cultivo c : cultivos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Edita un cultivo por nombre.
     * Reemplaza todos los datos excepto las actividades ya registradas.
     */
    public boolean editarCultivo(String nombreOriginal, Cultivo cultivoActualizado) {
        for (int i = 0; i < cultivos.size(); i++) {
            Cultivo actual = cultivos.get(i);
            if (actual.getNombre().equalsIgnoreCase(nombreOriginal)) {
                cultivoActualizado.getActividades().addAll(actual.getActividades());
                cultivos.set(i, cultivoActualizado);
                return true;
            }
        }
        return false;
    }

    /**
     * Elimina un cultivo solo si no tiene actividades pendientes
     */
    public boolean eliminarCultivo(String nombre) {
        return cultivos.removeIf(c -> 
            c.getNombre().equalsIgnoreCase(nombre) && c.getActividades().isEmpty()
        );
    }
}
