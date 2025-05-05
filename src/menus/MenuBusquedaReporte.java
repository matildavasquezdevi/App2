package menus;

import models.Cultivo;
import services.ReporteService;

import java.util.List;
import java.util.Scanner;

public class MenuBusquedaReporte {

    public static void mostrarMenu(Scanner scanner, List<Cultivo> cultivos) {
        ReporteService reporte = new ReporteService(cultivos);

        boolean volver = false;
        while (!volver) {
            System.out.println("\n-- Búsqueda y Reportes --");
            System.out.println("1. Buscar por nombre");
            System.out.println("2. Buscar por variedad");
            System.out.println("3. Cultivos ACTIVO");
            System.out.println("4. Cultivos EN_RIESGO");
            System.out.println("5. Cultivos COSECHADO");
            System.out.println("6. Volver");
            System.out.print("Opción: ");
            int op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1:
                    System.out.print("Nombre del cultivo: ");
                    String nombre = scanner.nextLine();
                    List<Cultivo> porNombre = reporte.buscarPorNombre(nombre);
                    if (porNombre.isEmpty()) {
                        System.out.println("No se encontraron cultivos.");
                    } else {
                        porNombre.forEach(c -> System.out.println(c.obtenerDescripcion()));
                    }
                    break;
                case 2:
                    System.out.print("Variedad del cultivo: ");
                    String variedad = scanner.nextLine();
                    List<Cultivo> porVariedad = reporte.buscarPorVariedad(variedad);
                    if (porVariedad.isEmpty()) {
                        System.out.println("No se encontraron cultivos.");
                    } else {
                        porVariedad.forEach(c -> System.out.println(c.obtenerDescripcion()));
                    }
                    break;
                case 3:
                    System.out.println("=== Cultivos ACTIVO ===");
                    reporte.obtenerCultivosActivos().forEach(c -> System.out.println(c.obtenerDescripcion()));
                    break;
                case 4:
                    System.out.println("=== Cultivos EN_RIESGO ===");
                    reporte.obtenerCultivosEnRiesgo().forEach(c -> System.out.println(c.obtenerDescripcion()));
                    break;
                case 5:
                    System.out.println("=== Cultivos COSECHADO ===");
                    reporte.obtenerCultivosCosechados().forEach(c -> System.out.println(c.obtenerDescripcion()));
                    break;
                case 6:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
