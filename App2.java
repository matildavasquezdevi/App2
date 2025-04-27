import java.io.File;

public class App2 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Error: debes pasar exactamente un argumento (el archivo CSV).");
            System.out.println("Uso correcto: java App2 cultivos.csv");
            return;
        }

        String nombreArchivo = args[0];
        System.out.println("Archivo recibido: " + nombreArchivo);

        File archivo = new File(nombreArchivo);
        if (!archivo.exists()) {
            System.out.println("Error: El archivo no existe.");
            return;
        }

        if (!archivo.canRead()) {
            System.out.println("Error: No se puede leer el archivo.");
            return;
        }

        System.out.println("Archivo verificado correctamente. 🎯");
        
        // Aquí seguirías leyendo el archivo...
    }
}
