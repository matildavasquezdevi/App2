package services;

import models.Cultivo;
import java.util.ArrayList;
import java.util.List;

public class ReporteService {

    private List<Cultivo> cultivos;

    public ReporteService(List<Cultivo> cultivos) {
        this.cultivos = cultivos;
    }

    public List<Cultivo> buscarPorNombre(String nombre) {
        List<Cultivo> resultados = new ArrayList<>();
        for (Cultivo cultivo : cultivos) {
            if (cultivo.getNombre().equalsIgnoreCase(nombre)) {
                resultados.add(cultivo);
            }
        }
        return resultados;
    }

    public List<Cultivo> buscarPorVariedad(String variedad) {
        List<Cultivo> resultados = new ArrayList<>();
        for (Cultivo cultivo : cultivos) {
            if (cultivo.getVariedad().equalsIgnoreCase(variedad)) {
                resultados.add(cultivo);
            }
        }
        return resultados;
    }

    public List<Cultivo> obtenerCultivosActivos() {
        List<Cultivo> activos = new ArrayList<>();
        for (Cultivo cultivo : cultivos) {
            if (cultivo.getEstado().equals("ACTIVO")) {
                activos.add(cultivo);
            }
        }
        return activos;
    }

    public List<Cultivo> obtenerCultivosEnRiesgo() {
        List<Cultivo> enRiesgo = new ArrayList<>();
        for (Cultivo cultivo : cultivos) {
            if (cultivo.getEstado().equals("EN_RIESGO")) {
                enRiesgo.add(cultivo);
            }
        }
        return enRiesgo;
    }

    public List<Cultivo> obtenerCultivosCosechados() {
        List<Cultivo> cosechados = new ArrayList<>();
        for (Cultivo cultivo : cultivos) {
            if (cultivo.getEstado().equals("COSECHADO")) {
                cosechados.add(cultivo);
            }
        }
        return cosechados;
    }
}