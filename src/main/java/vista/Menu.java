package vista;


import java.util.Scanner;


public class Menu {


    public static void menuPrincipal(){
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do{
            System.out.println("Bienvenido al sistema de gestion de estudiantes");
            System.out.println("1. Ingresar estudiante");
            System.out.println("2. Listar estudiantes");
            System.out.println("3. Buscar estudiante");
            System.out.println("4. Eliminar estudiante");
            System.out.println("5. Salir");
            System.out.println("Ingrese una opcion: ");
            opcion = sc.nextInt();
            switch(opcion){
                case 1: model.Curso.agregarEstudiante();
                    System.out.println("Agregar estudiante");
                    break;
                case 2: model.Curso.buscarEstudiante();
                    System.out.println("Buscar estudiante");
                case 3: model.Curso.mostrarEstudiantes();
                    System.out.println("Mostrar estudiantes");
                    break;
                case 4: model.Curso.eliminarEstudiante();
                    System.out.println("Eliminar estudiante");
                    break;
                case 5:
                    System.out.println("Salir");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }while(opcion != 5);
    }
}
