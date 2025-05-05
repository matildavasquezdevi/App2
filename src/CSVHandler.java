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
                if (!linea.startsWith("Cultivo")) continue; // ignorar encabezados o líneas vacías

                // Separar por coma considerando comillas
                String[] partes = linea.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                String nombre = partes[1].replace("\"", "");
                String variedad = partes[2].replace("\"", "");
                double superficie = Double.parseDouble(partes[3]);
                String codigoParcela = partes[4].replace("\"", "");
                LocalDate fechaSiembra = LocalDate.parse(partes[5].replace("\"", ""));
                String estado = partes[6].replace("\"", "");
                String actividadesRaw = partes[7].trim();

                Cultivo cultivo = new Cultivo(nombre, variedad, superficie, codigoParcela, fechaSiembra, estado);

                // Parsear actividades tipo ["RIEGO:2023-03-10","FERTILIZACION:2023-03-20"]
                actividadesRaw = actividadesRaw.replace("[", "").replace("]", "");
                String[] actividades = actividadesRaw.split(",");

                for (String actividadTxt : actividades) {
                    actividadTxt = actividadTxt.replace("\"", "").trim();
                    if (actividadTxt.isEmpty()) continue;
                    String[] actPartes = actividadTxt.split(":");
                    if (actPartes.length == 2) {
                        String tipo = actPartes[0];
                        LocalDate fecha = LocalDate.parse(actPartes[1]);
                        Actividad act = new Actividad(tipo, fecha, "PENDIENTE");
                        cultivo.agregarActividad(act);
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
                sb.append("\"").append(c.getFecha().toString()).append("\",");
                sb.append("\"").append(c.getEstado()).append("\",");

                // Serializar actividades
                sb.append("[");
                var actividades = c.getActividades();
                for (int i = 0; i < actividades.size(); i++) {
                    sb.append("\"")
                      .append(actividades.get(i).getNombre())
                      .append(":")
                      .append(actividades.get(i).getFecha())
                      .append("\"");
                    if (i < actividades.size() - 1) {
                        sb.append(",");
                    }
                }
                sb.append("]");

                bw.write(sb.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo CSV: " + e.getMessage());
        }
    }
}
