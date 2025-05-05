import java.util.Scanner;
import java.util.List;
import io.CSVHandler;
import models.Cultivo;

public class App2 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso correcto: java App2 cultivos.csv");
            return;
        }

        // --- BLOQUE TEMPORAL DE PRUEBA DE CSV ---
        List<Cultivo> cultivos = CSVHandler.leerCultivosDesdeCSV();
        System.out.println("\nCultivos cargados desde CSV:");
        for (Cultivo c : cultivos) {
            System.out.println(c.getId() + " - " + c.getNombre() + " - " + c.getVariedad() + " - " + c.getEstado() + " - " + c.getSuperficie());
        }

        // Vuelve a escribir el archivo para verificar que todo funcione correctamente
        CSVHandler.escribirCultivosEnCSV(cultivos);
        // --- FIN BLOQUE TEMPORAL ---

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

            int opcionPrincipal = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcionPrincipal) {
                case 1:
                    menuCultivos(scanner);
                    break;
                case 2:
                    menuParcelas(scanner);
                    break;
                case 3:
                    menuActividades(scanner);
                    break;
                case 4:
                    menuBusquedaReporte(scanner);
                    break;
                case 5:
                    System.out.println("Guardando datos y cerrando el programa...");
                    // Aquí después pondremos guardar los cambios al CSV
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }

        scanner.close();
    }
}
