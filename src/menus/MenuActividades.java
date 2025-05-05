package menus;

import models.Cultivo;
import models.Actividad;
import services.ActividadService;

import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

public class MenuActividades {
    public static void mostrarMenu(Scanner scanner, List<Cultivo> cultivos) {
        ActividadService servicio = new ActividadService();

        boolean volver = false;
        while (!volver) {
            System.out.println("\n-- Gestión de Actividades --");
            System.out.println("1. Registrar actividad");
            System.out.println("2. Listar actividades de un cultivo");
            System.out.println("3. Marcar actividad como completada");
            System.out.println("4. Eliminar actividad");
            System.out.println("5. Volver");
            System.out.print("Opción: ");
            int op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1:
                    System.out.print("Nombre del cultivo: ");
                    String nombreCultivo = scanner.nextLine();
                    Cultivo c1 = buscarCultivoPorNombre(cultivos, nombreCultivo);
                    if (c1 == null) {
                        System.out.println("Cultivo no encontrado.");
                        break;
                    }

                    System.out.print("Tipo de actividad (ej: RIEGO): ");
                    String tipo = scanner.nextLine();
                    System.out.print("Fecha (yyyy-mm-dd): ");
                    LocalDate fecha = LocalDate.parse(scanner.nextLine());

                    Actividad nueva = new Actividad(tipo, fecha, "PENDIENTE");
                    servicio.agregarActividad(c1, nueva);
                    System.out.println("Actividad registrada.");
                    break;

                case 2:
                    System.out.print("Nombre del cultivo: ");
                    String n = scanner.nextLine();
                    Cultivo c2 = buscarCultivoPorNombre(cultivos, n);
                    if (c2 != null) {
                        List<Actividad> acts = servicio.listarActividades(c2);
                        for (Actividad a : acts) {
                            System.out.println("- " + a.obtenerDescripcion());
                        }
                    } else {
                        System.out.println("Cultivo no encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Nombre del cultivo: ");
                    String nc = scanner.nextLine();
                    Cultivo c3 = buscarCultivoPorNombre(cultivos, nc);
                    if (c3 != null) {
                        System.out.print("Nombre exacto de la actividad: ");
                        String actividadNombre = scanner.nextLine();
                        Actividad objetivo = buscarActividadPorNombre(c3, actividadNombre);
                        if (objetivo != null && servicio.marcarCompletada(c3, objetivo)) {
                            System.out.println("Actividad marcada como completada.");
                        } else {
                            System.out.println("No se encontró la actividad.");
                        }
                    } else {
                        System.out.println("Cultivo no encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Nombre del cultivo: ");
                    String ce = scanner.nextLine();
                    Cultivo c4 = buscarCultivoPorNombre(cultivos, ce);
                    if (c4 != null) {
                        System.out.print("Nombre exacto de la actividad a eliminar: ");
                        String actividadEliminar = scanner.nextLine();
                        Actividad objetivo = buscarActividadPorNombre(c4, actividadEliminar);
                        if (objetivo != null && servicio.eliminarActividad(c4, objetivo)) {
                            System.out.println("Actividad eliminada.");
                        } else {
                            System.out.println("No se encontró la actividad.");
                        }
                    } else {
                        System.out.println("Cultivo no encontrado.");
                    }
                    break;

                case 5:
                    volver = true;
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private static Cultivo buscarCultivoPorNombre(List<Cultivo> cultivos, String nombre) {
        for (Cultivo c : cultivos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) return c;
        }
        return null;
    }

    private static Actividad buscarActividadPorNombre(Cultivo cultivo, String nombre) {
        for (Actividad a : cultivo.getActividades()) {
            if (a.getNombre().equalsIgnoreCase(nombre)) return a;
        }
        return null;
    }
}
