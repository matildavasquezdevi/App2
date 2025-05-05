package src.Menu;

import java.util.Scanner;

public class MenuCultivos {
    public static void mostrar(Scanner scanner) {
        System.out.println("\n--- Gestión de Cultivos ---");
        System.out.println("1. Listar cultivos existentes.");
        System.out.println("2. Crear un nuevo cultivo.");
        System.out.println("3. Eliminar un cultivo.");
        System.out.println("4. Editar un cultivo.");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        switch (opcion) {
            case 1:
                System.out.println("Listando cultivos...");
                // Lógica para listar cultivos
                break;
            case 2:
                System.out.println("Creando un nuevo cultivo...");
                // Lógica para crear un cultivo
                break;
            case 3:
                System.out.println("Eliminando un cultivo...");
                // Lógica para eliminar un cultivo
                break;
            case 4:
                System.out.println("Editando un cultivo...");
                // Lógica para editar un cultivo
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }
}
