package vista;
import model.Curso;
import model.Estudiante;



import java.util.Scanner;


public class Menu {
    public static void main(String[] args) {
        Curso curso = new Curso();
        menuPrincipal(curso);
    }

    public static void menuPrincipal(Curso curso) {
        Scanner sc = new Scanner(System.in);

        int opcion = 0;
        do {
            System.out.println("Bienvenido al sistema de registro de estudiantes");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Mostrar estudiantes");
            System.out.println("3. Buscar estudiante");
            System.out.println("4. Eliminar estudiante");
            System.out.println("5. Salir");
            System.out.println("Ingrese una opción");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    agregarEstudiante(curso);
                    break;
                case 2:
                    buscarEstudiante(curso);
                    break;
                case 3:
                    eliminarEstudiante(curso);
                    break;
                case 4:
                    mostrarEstudiantes(curso);
                    break;
                case 5:
                    System.out.println("Gracias por utilizar el sistema");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 5);
    }

    //metodo agregar estudiante, con mensaje de exito o error
    public static void agregarEstudiante(Curso curso) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del estudiante");
        String nombre = sc.next();
        System.out.println("Ingrese el email del estudiante");
        String email = sc.next();
        System.out.println("Ingrese el rut del estudiante");
        String rut = sc.next();
        Estudiante estudiante = new Estudiante(nombre, email, rut);
        curso.agregarEstudiante(estudiante);
        System.out.println("Estudiante agregado con éxito");
    }

    //metodo buscar estudiante, con mensaje de exito o error
    public static void buscarEstudiante(Curso curso) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el rut del estudiante");
        String rut = sc.next();
        Estudiante estudiante = curso.buscarEstudiante(rut);
        if (estudiante != null) {
            System.out.println(estudiante.toString());
        } else {
            System.out.println("Estudiante no encontrado");
        }
    }

    //metodo eliminar estudiante, con mensaje de exito o error
    public static void eliminarEstudiante(Curso curso) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el rut del estudiante");
        String rut = sc.next();
        curso.eliminarEstudiante(rut);
        System.out.println("Estudiante eliminado con éxito");
    }

    //metodo mostrar lista estudiantes, con mensaje de exito o error
    public static void mostrarEstudiantes(Curso curso) {
        curso.mostrarEstudiantes();

    }
}
