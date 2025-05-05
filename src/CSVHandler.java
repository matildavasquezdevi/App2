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
            int idCounter = 1;

            while ((linea = br.readLine()) != null) {
                if (!linea.startsWith("Cultivo")) continue;

                String[] campos = dividirLineaCSV(linea);
                if (campos.length < 8) continue;

                String nombre = campos[1];
                String variedad = campos[2];
                double superficie = Double.parseDouble(campos[3]);
                String codigoParcela = campos[4];
                LocalDate fechaSiembra = LocalDate.parse(campos[5]);
                String estado = campos[6];
                String listaActividades = campos[7];

                Cultivo cultivo = new Cultivo(idCounter++, nombre, variedad, estado, superficie);
                cultivo.setCodigoParcela(codigoParcela);
                cultivo.setFechaSiembra(fechaSiembra);

                // Parsear actividades tipo ["RIEGO:2023-03-10","COSECHA:2023-04-15"]
                if (!listaActividades.equals("[]")) {
                    listaActividades = listaActividades.substring(1, listaActividades.length() - 1); // quitar corchetes
                    String[] actividades = listaActividades.split("\",\"");

                    for (String act : actividades) {
                        act = act.replace("\"", "").trim();
                        if (act.contains(":")) {
                            String[] partes = act.split(":");
                            String tipo = partes[0];
                            LocalDate fecha = LocalDate.parse(partes[1]);
                            cultivo.agregarActividad(new Actividad(tipo, fecha, "PENDIENTE"));
                        }
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
                StringBuilder linea = new StringBuilder();
                linea.append("Cultivo").append(",")
                        .append("\"").append(c.getNombre()).append("\",")
                        .append("\"").append(c.getVariedad()).append("\",")
                        .append(c.getSuperficie()).append(",")
                        .append("\"").append(c.getCodigoParcela()).append("\",")
                        .append("\"").append(c.getFechaSiembra()).append("\",")
                        .append("\"").append(c.getEstado()).append("\",");

                // Actividades
                linea.append("[");
                List<Actividad> acts = c.getActividades();
                for (int i = 0; i < acts.size(); i++) {
                    Actividad a = acts.get(i);
                    linea.append("\"").append(a.getNombre()).append(":").append(a.getFecha()).append("\"");
                    if (i < acts.size() - 1) linea.append(",");
                }
                linea.append("]");

                bw.write(linea.toString());
                bw.newLine();
            }

        } catch (IOException e) {
            System.err.println("Error al escribir el archivo CSV: " + e.getMessage());
        }
    }

    // Divide una línea del CSV personalizada (con comillas y lista final)
    private static String[] dividirLineaCSV(String linea) {
        List<String> partes = new ArrayList<>();
        StringBuilder buffer = new StringBuilder();
        boolean dentroComillas = false;

        for (char c : linea.toCharArray()) {
            if (c == '"') {
                dentroComillas = !dentroComillas;
                continue;
            }
            if (c == ',' && !dentroComillas) {
                partes.add(buffer.toString().trim());
                buffer.setLength(0);
            } else {
                buffer.append(c);
            }
        }
        partes.add(buffer.toString().trim()); // último campo
        return partes.toArray(new String[0]);
    }
}
