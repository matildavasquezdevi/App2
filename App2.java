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

    private static void menuCultivos(Scanner scanner) {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- Gestión de Cultivos ---");
            System.out.println("1. Listar cultivos existentes");
            System.out.println("2. Crear un nuevo cultivo");
            System.out.println("3. Eliminar un cultivo");
            System.out.println("4. Editar información de un cultivo");
            System.out.println("5. Volver al menú principal");
            System.out.print("Selecciona una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("[Listar cultivos]"); // después lo conectamos
                    break;
                case 2:
                    System.out.println("[Crear cultivo]");
                    break;
                case 3:
                    System.out.println("[Eliminar cultivo]");
                    break;
                case 4:
                    System.out.println("[Editar cultivo]");
                    break;
                case 5:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private static void menuParcelas(Scanner scanner) {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- Gestión de Parcelas ---");
            System.out.println("1. Listar parcelas con sus cultivos");
            System.out.println("2. Agregar una parcela");
            System.out.println("3. Eliminar una parcela");
            System.out.println("4. Editar una parcela");
            System.out.println("5. Asignar un cultivo a una parcela");
            System.out.println("6. Volver al menú principal");
            System.out.print("Selecciona una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("[Listar parcelas]");
                    break;
                case 2:
                    System.out.println("[Agregar parcela]");
                    break;
                case 3:
                    System.out.println("[Eliminar parcela]");
                    break;
                case 4:
                    System.out.println("[Editar parcela]");
                    break;
                case 5:
                    System.out.println("[Asignar cultivo a parcela]");
                    break;
                case 6:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private static void menuActividades(Scanner scanner) {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- Gestión de Actividades ---");
            System.out.println("1. Registrar actividad para un cultivo");
            System.out.println("2. Listar actividades por cultivo");
            System.out.println("3. Eliminar actividad");
            System.out.println("4. Marcar actividad como completada");
            System.out.println("5. Volver al menú principal");
            System.out.print("Selecciona una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("[Registrar actividad]");
                    break;
                case 2:
                    System.out.println("[Listar actividades]");
                    break;
                case 3:
                    System.out.println("[Eliminar actividad]");
                    break;
                case 4:
                    System.out.println("[Marcar actividad como completada]");
                    break;
                case 5:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private static void menuBusquedaReporte(Scanner scanner) {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- Búsqueda/Reporte ---");
            System.out.println("1. Buscar cultivos por nombre o variedad");
            System.out.println("2. Reporte de cultivos activos, cosechados o en riesgo");
            System.out.println("3. Volver al menú principal");
            System.out.print("Selecciona una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.println("[Buscar cultivos]");
                    break;
                case 2:
                    System.out.println("[Reporte cultivos]");
                    break;
                case 3:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
