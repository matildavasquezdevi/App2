package services;

import models.Cultivo;
import java.util.List;
import java.util.ArrayList;

public class CultivoService {

    private List<Cultivo> cultivos;

    public CultivoService() {
        this.cultivos = new ArrayList<>();
    }

    /** Crea/agrega un nuevo cultivo */
    public void agregarCultivo(Cultivo cultivo) {
        cultivos.add(cultivo);
    }

    /** Retorna la lista completa de cultivos */
    public List<Cultivo> listarCultivos() {
        return cultivos;
    }

    /** Busca un cultivo por nombre (exacto, case-insensitive) */
    public Cultivo buscarCultivo(String nombre) {
        for (Cultivo c : cultivos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Edita un cultivo existente.
     * @param nombreOriginal nombre del cultivo a modificar
     * @param cultivoActualizado datos nuevos (se preservan actividades antiguas)
     * @return true si se encontró y actualizó
     */
    public boolean editarCultivo(String nombreOriginal, Cultivo cultivoActualizado) {
        for (int i = 0; i < cultivos.size(); i++) {
            Cultivo antiguo = cultivos.get(i);
            if (antiguo.getNombre().equalsIgnoreCase(nombreOriginal)) {
                cultivoActualizado.getActividades().addAll(antiguo.getActividades());
                cultivos.set(i, cultivoActualizado);
                return true;
            }
        }
        return false;
    }

    /**
     * Elimina un cultivo (solo si no tiene actividades pendientes).
     * @return true si se eliminó
     */
    public boolean eliminarCultivo(String nombre) {
        return cultivos.removeIf(c ->
            c.getNombre().equalsIgnoreCase(nombre)
            && c.getActividades().isEmpty()
        );
    }
}
