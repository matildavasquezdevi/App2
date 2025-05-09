import java.util.List;
import java.util.Scanner;

import io.CSVHandler;
import models.Cultivo;
import menus.MenuCultivos;
import menus.MenuActividades;
import menus.MenuParcelas;
import menus.MenuBusquedaReporte;

public class App2 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso correcto: java App2 cultivos.csv");
            return;
        }

        // Cargar datos del CSV
        List<Cultivo> cultivos = CSVHandler.leerCultivosDesdeCSV();

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== Menú Principal ===");
            System.out.println("1. Gestión de Cultivos");
            System.out.println("2. Gestión de Parcelas");
            System.out.println("3. Gestión de Actividades");
            System.out.println("4. Búsqueda/Reporte");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    MenuCultivos.mostrarMenu(scanner, cultivos);
                    break;
                case 2:
                    MenuParcelas.mostrarMenu(scanner, cultivos);
                    break;
                case 3:
                    MenuActividades.mostrarMenu(scanner, cultivos);
                    break;
                case 4:
                    MenuBusquedaReporte.mostrarMenu(scanner, cultivos);
                    break;
                case 5:
                    CSVHandler.escribirCultivosEnCSV(cultivos);
                    System.out.println("Datos guardados. Cerrando...");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }

        scanner.close();
    }
}
