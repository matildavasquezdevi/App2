package src.Menu;

import java.util.Scanner;

public class MenuActividades {
    public static void mostrar(Scanner scanner) {
        System.out.println("\n--- Gestión de Actividades ---");
        System.out.println("1. Registrar actividad.");
        System.out.println("2. Listar actividades por cultivo.");
        System.out.println("3. Eliminar actividad.");
        System.out.println("4. Marcar actividad como completada.");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        switch (opcion) {
            case 1:
                System.out.println("Registrando actividad...");
                // Lógica para registrar actividad
                break;
            case 2:
                System.out.println("Listando actividades por cultivo...");
                // Lógica para listar actividades
                break;
            case 3:
                System.out.println("Eliminando actividad...");
                // Lógica para eliminar actividad
                break;
            case 4:
                System.out.println("Marcando actividad como completada...");
                // Lógica para marcar actividad como completada
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }
}
