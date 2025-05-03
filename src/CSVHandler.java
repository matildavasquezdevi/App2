package io;

import models.Cultivo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVHandler {

    private static final String CSV_PATH = "cultivos.csv";

    public static List<Cultivo> leerCultivosDesdeCSV() {
        List<Cultivo> cultivos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_PATH))) {
            String linea;
            boolean primeraLinea = true;
            while ((linea = br.readLine()) != null) {
                if (primeraLinea) {
                    primeraLinea = false; // Saltar encabezado
                    continue;
                }
                String[] datos = linea.split(",");
                if (datos.length >= 5) {
                    int id = Integer.parseInt(datos[0]);
                    String nombre = datos[1];
                    String variedad = datos[2];
                    String estado = datos[3];
                    double superficie = Double.parseDouble(datos[4]);

                    Cultivo cultivo = new Cultivo(id, nombre, variedad, estado, superficie);
                    cultivos.add(cultivo);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        }
        return cultivos;
    }

    public static void escribirCultivosEnCSV(List<Cultivo> cultivos) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CSV_PATH))) {
            bw.write("id,nombre,variedad,estado,superficie");
            bw.newLine();
            for (Cultivo c : cultivos) {
                bw.write(c.getId() + "," + c.getNombre() + "," + c.getVariedad() + "," + c.getEstado() + "," + c.getSuperficie());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo CSV: " + e.getMessage());
        }
    }
}

