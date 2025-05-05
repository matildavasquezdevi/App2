package io;

import models.Cultivo;
import models.Actividad;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CSVHandler {

    private static final String CSV_PATH = "cultivos.csv";

    public static List<Cultivo> leerCultivosDesdeCSV() {
        List<Cultivo> cultivos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_PATH))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.startsWith("Cultivo")) continue;

                // Separar los 8 componentes esperados (excepto actividades, que se parsean por separado)
                int idx1 = linea.indexOf("[");
                String datosPrincipales = linea.substring(0, idx1 - 1);
                String actividadesStr = linea.substring(idx1);

                String[] partes = datosPrincipales.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                if (partes.length < 7) continue;

                String nombre = partes[1].replace("\"", "");
                String variedad = partes[2].replace("\"", "");
                double superficie = Double.parseDouble(partes[3]);
                String codigoParcela = partes[4].replace("\"", "");
                LocalDate fechaSiembra = LocalDate.parse(partes[5].replace("\"", ""));
                String estado = partes[6].replace("\"", "");

                Cultivo cultivo = new Cultivo(
                        cultivos.size() + 1, nombre, variedad, estado,
                        superficie, codigoParcela, fechaSiembra
                );

                // Parsear actividades tipo: ["RIEGO:2023-03-10","FERTILIZACION:2023-03-20"]
                actividadesStr = actividadesStr.replaceAll("[\\[\\]\"]", "");
                String[] actividades = actividadesStr.split(",");
                for (String act : actividades) {
                    if (act.contains(":")) {
                        String[] a = act.split(":");
                        String tipo = a[0];
                        LocalDate fecha = LocalDate.parse(a[1]);
                        cultivo.agregarActividad(new Actividad(tipo, fecha, "PENDIENTE"));
                    }
                }

                cultivos.add(cultivo);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        }
        return cultivos;
    }

    public static void escribirCultivosEnCSV(List<Cultivo> cultivos) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CSV_PATH))) {
            for (Cultivo c : cultivos) {
                StringBuilder sb = new StringBuilder();
                sb.append("Cultivo,");
                sb.append("\"").append(c.getNombre()).append("\",");
                sb.append("\"").append(c.getVariedad()).append("\",");
                sb.append(c.getSuperficie()).append(",");
                sb.append("\"").append(c.getCodigoParcela()).append("\",");
                sb.append("\"").append(c.getFecha()).append("\",");
                sb.append("\"").append(c.getEstado()).append("\",");

                // Serializar actividades: ["TIPO:FECHA","TIPO2:FECHA2"]
                List<Actividad> actividades = c.getActividades();
                List<String> actStr = new ArrayList<>();
                for (Actividad a : actividades) {
                    actStr.add("\"" + a.getNombre() + ":" + a.getFecha().toString() + "\"");
                }
                sb.append("[").append(String.join(",", actStr)).append("]");

                bw.write(sb.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo CSV: " + e.getMessage());
        }
    }
}
