import java.util.Scanner;
public class Manager {
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
       menu();
    }

    public static void menu(){
        System.out.println("Bienvenido a la aplicacion de tareas");
        System.out.println("1. Crear tarea");
        System.out.println("2. Ver tareas");
        System.out.println("3. Salir");
        System.out.println("Ingrese una opcion: ");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        switch (option) {
            case 1:

                break;
            case 2:
  
                break;
            case 3:
                System.out.println("Gracias por usar la aplicacion");
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }

        
    }
}
