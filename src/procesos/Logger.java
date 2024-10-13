package procesos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    private static final String LOG_FILE = "log.txt";
    private static BufferedWriter writer;

    static {
        try {
            writer = new BufferedWriter(new FileWriter(LOG_FILE, true));
        } catch (IOException e) {
            System.out.println("Error al inicializar el BufferedWriter");
        }
    }

    public static void log(String message) {
        try {
            System.out.println(message); // Log to console
            writer.write(message);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo de log");
        }
    }

    public static void close() {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            System.out.println("Error al cerrar el BufferedWriter");
        }
    }
}
