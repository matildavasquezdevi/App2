package menus;

import models.Cultivo;
import models.Parcela;
import services.ParcelaService;

import java.util.List;
import java.util.Scanner;

public class MenuParcelas {

    private static final ParcelaService servicio = new ParcelaService();

    public static void mostrarMenu(Scanner scanner, List<Cultivo> cultivos) {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n-- Gestión de Parcelas --");
            System.out.println("1. Listar parcelas");
            System.out.println("2. Agregar parcela");
            System.out.println("3. Editar parcela");
            System.out.println("4. Eliminar parcela");
            System.out.println("5. Asignar cultivo a parcela");
            System.out.println("6. Volver");
            System.out.print("Opción: ");
            int op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1:
                    for (Parcela p : servicio.listarParcelas()) {
                        System.out.println("Parcela " + p.getCodigo() + " (" + p.getTamaño() + " ha, " + p.getUbicacion() + ")");
                        for (Cultivo c : p.getCultivos()) {
                            System.out.println("  ↳ " + c.obtenerDescripcion());
                        }
                    }
                    break;

                case 2:
                    System.out.print("Código único: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Tamaño (ha): ");
                    double tam = scanner.nextDouble(); scanner.nextLine();
                    System.out.print("Ubicación: ");
                    String ubic = scanner.nextLine();

                    Parcela nueva = new Parcela(codigo, tam, ubic);
                    servicio.agregarParcela(nueva);
                    System.out.println("Parcela agregada.");
                    break;

                case 3:
                    System.out.print("Código de la parcela: ");
                    String codEdit = scanner.nextLine();
                    System.out.print("Nuevo tamaño (ha): ");
                    double nuevoTam = scanner.nextDouble(); scanner.nextLine();
                    System.out.print("Nueva ubicación: ");
                    String nuevaUbic = scanner.nextLine();
                    boolean editado = servicio.editarParcela(codEdit, nuevoTam, nuevaUbic);
                    if (editado) {
                        System.out.println("Parcela actualizada.");
                    } else {
                        System.out.println("No se encontró o no se pudo editar.");
                    }
                    break;

                case 4:
                    System.out.print("Código de la parcela a eliminar: ");
                    String codDel = scanner.nextLine();
                    boolean eliminada = servicio.eliminarParcela(codDel);
                    System.out.println(eliminada ? "Parcela eliminada." : "No se puede eliminar (puede tener cultivos).");
                    break;

                case 5:
                    System.out.print("Código de la parcela: ");
                    String codPar = scanner.nextLine();
                    System.out.print("Nombre del cultivo a asignar: ");
                    String nomCult = scanner.nextLine();
                    Cultivo cultivo = buscarCultivoPorNombre(cultivos, nomCult);
                    if (cultivo == null) {
                        System.out.println("Cultivo no encontrado.");
                        break;
                    }
                    boolean asignado = servicio.asignarCultivo(codPar, cultivo);
                    if (asignado) {
                        cultivo.setCodigoParcela(codPar);
                        System.out.println("Cultivo asignado a la parcela.");
                    } else {
                        System.out.println("No se encontró la parcela.");
                    }
                    break;

                case 6:
                    volver = true;
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private static Cultivo buscarCultivoPorNombre(List<Cultivo> cultivos, String nombre) {
        for (Cultivo c : cultivos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) return c;
        }
        return null;
    }
}
