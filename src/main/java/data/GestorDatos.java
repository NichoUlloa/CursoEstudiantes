package data;

import model.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class GestorDatos {

    public static Estudiante leerArchivoEstudiante(Estudiante estudiante, String direccionArchivo) {
        try {
            if (Files.exists(Paths.get(direccionArchivo))) {
                List<String> lineas = Files.readAllLines(Paths.get(direccionArchivo));
                for (String linea : lineas) {
                    String[] data = linea.split(",");
                    if (data[0].equals(estudiante.getRut())) {
                        estudiante.setNombre(data[1]);
                        estudiante.setEmail(data[2]);
                        return estudiante;
                    }
                }
            } else {
                System.out.println("El archivo no existe.");
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo. Detalles: " + e.getMessage());
        }
        return null;
    }

    public static boolean registrarDato(Object objeto, String direccionArchivo) {
        try {
            File file = new File(direccionArchivo);
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file, true);
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                bw.newLine();
                bw.write(objeto.toString());
            }

            return true;
        } catch (IOException e) {
            System.out.println("Error al ingresar dato. Detalles: " + e.getMessage());
            return false;
        }
    }
}
