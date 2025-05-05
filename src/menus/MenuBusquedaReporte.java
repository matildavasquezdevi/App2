package src.Menu;

import java.util.Scanner;

public class MenuBusquedaReporte {
    public static void mostrar(Scanner scanner) {
        System.out.println("\n--- Búsqueda/Reporte ---");
        System.out.println("1. Buscar cultivos por nombre o variedad.");
        System.out.println("2. Reporte de cultivos activos, cosechados, o en riesgo.");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        switch (opcion) {
            case 1:
                System.out.println("Buscando cultivos...");
                // Lógica para buscar cultivos
                break;
            case 2:
                System.out.println("Generando reporte...");
                // Lógica para generar reporte
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }
}
