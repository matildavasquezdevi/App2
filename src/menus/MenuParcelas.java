package src.Menu;

import java.util.Scanner;

public class MenuParcelas {
    public static void mostrar(Scanner scanner) {
        System.out.println("\n--- Gestión de Parcelas ---");
        System.out.println("1. Listar parcelas con cultivos.");
        System.out.println("2. Agregar una nueva parcela.");
        System.out.println("3. Eliminar una parcela.");
        System.out.println("4. Editar una parcela.");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        switch (opcion) {
            case 1:
                System.out.println("Listando parcelas...");
                // Lógica para listar parcelas
                break;
            case 2:
                System.out.println("Agregando una nueva parcela...");
                // Lógica para agregar una parcela
                break;
            case 3:
                System.out.println("Eliminando una parcela...");
                // Lógica para eliminar una parcela
                break;
            case 4:
                System.out.println("Editando una parcela...");
                // Lógica para editar una parcela
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }
}
