package services;

import models.Cultivo;
import models.Actividad;
import java.util.List;

public class ActividadService {

    /** Agrega una nueva actividad a un cultivo */
    public void agregarActividad(Cultivo cultivo, Actividad actividad) {
        cultivo.agregarActividad(actividad);
    }

    /** Lista todas las actividades de un cultivo */
    public List<Actividad> listarActividades(Cultivo cultivo) {
        return cultivo.getActividades();
    }

    /**
     * Edita una actividad existente.
     * @return true si se encontró y actualizó
     */
    public boolean editarActividad(Cultivo cultivo, Actividad original, Actividad actualizada) {
        List<Actividad> lista = cultivo.getActividades();
        int idx = lista.indexOf(original);
        if (idx >= 0) {
            lista.set(idx, actualizada);
            return true;
        }
        return false;
    }

    /**
     * Elimina una actividad de un cultivo.
     * @return true si se eliminó
     */
    public boolean eliminarActividad(Cultivo cultivo, Actividad actividad) {
        return cultivo.getActividades().remove(actividad);
    }

    /**
     * Marca una actividad como COMPLETADA.
     * @return true si se marcó
     */
    public boolean marcarCompletada(Cultivo cultivo, Actividad actividad) {
        List<Actividad> lista = cultivo.getActividades();
        int idx = lista.indexOf(actividad);
        if (idx >= 0) {
            Actividad act = lista.get(idx);
#--
    }
}
