import java.util.Scanner;

public class App2 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso correcto: java App2 cultivos.csv");
            return;
        }

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
