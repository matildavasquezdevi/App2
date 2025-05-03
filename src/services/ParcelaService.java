package services;

import models.Parcela;
import models.Cultivo;
import java.util.List;
import java.util.ArrayList;

public class ParcelaService {

    private List<Parcela> parcelas;

    public ParcelaService() {
        this.parcelas = new ArrayList<>();
    }

    /** Agrega una nueva parcela */
    public void agregarParcela(Parcela parcela) {
        parcelas.add(parcela);
    }

    /** Devuelve todas las parcelas */
    public List<Parcela> listarParcelas() {
        return parcelas;
    }

    /** Busca una parcela por código (case-insensitive) */
    public Parcela buscarParcela(String codigo) {
        for (Parcela p : parcelas) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Edita tamaño y ubicación de una parcela existente.
     * Conserva los cultivos asignados.
     * @return true si encontró y actualizó
     */
    public boolean editarParcela(String codigoOriginal, double nuevoTamano, String nuevaUbicacion) {
        for (int i = 0; i < parcelas.size(); i++) {
            Parcela antigua = parcelas.get(i);
            if (antigua.getCodigo().equalsIgnoreCase(codigoOriginal)) {
                Parcela actualizada = new Parcela(antigua.getCodigo(), nuevoTamano, nuevaUbicacion);
                for (Cultivo c : antigua.getCultivos()) {
                    actualizada.agregarCultivo(c);
                }
                parcelas.set(i, actualizada);
                return true;
            }
        }
        return false;
    }

    /**
     * Elimina una parcela si no tiene cultivos.
     * @return true si se eliminó
     */
    public boolean eliminarParcela(String codigo) {
        return parcelas.removeIf(p ->
            p.getCodigo().equalsIgnoreCase(codigo)
            && p.getCultivos().isEmpty()
        );
    }

    /** Asigna un cultivo a la parcela indicada */
    public boolean asignarCultivo(String codigoParcela, Cultivo cultivo) {
        Parcela p = buscarParcela(codigoParcela);
        if (p != null) {
            p.agregarCultivo(cultivo);
            return true;
        }
        return false;
    }
}
