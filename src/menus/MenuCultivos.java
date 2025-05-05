package menus;

import models.Cultivo;
import services.CultivoService;

import java.util.List;
import java.util.Scanner;

public class MenuCultivos {

    public static void mostrarMenu(Scanner scanner, List<Cultivo> cultivos) {
        CultivoService servicio = new CultivoService(cultivos);

        boolean volver = false;
        while (!volver) {
            System.out.println("\n-- Gestión de Cultivos --");
            System.out.println("1. Listar cultivos");
            System.out.println("2. Agregar cultivo");
            System.out.println("3. Volver");
            System.out.print("Opción: ");
            int op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1:
                    for (Cultivo c : servicio.listarCultivos()) {
                        System.out.println(c.obtenerDescripcion());
                    }
                    break;
                case 2:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Variedad: ");
                    String variedad = scanner.nextLine();
                    System.out.print("Superficie (ha): ");
                    double superficie = scanner.nextDouble(); scanner.nextLine();
                    System.out.print("Parcela: ");
                    String parcela = scanner.nextLine();
                    System.out.print("Fecha de siembra (yyyy-mm-dd): ");
                    String fechaStr = scanner.nextLine();
                    System.out.print("Estado (ACTIVO / EN_RIESGO / COSECHADO): ");
                    String estado = scanner.nextLine();

                    Cultivo nuevo = new Cultivo(nombre, variedad, superficie, parcela,
                            java.time.LocalDate.parse(fechaStr), estado);
                    servicio.agregarCultivo(nuevo);
                    System.out.println("Cultivo agregado.");
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
