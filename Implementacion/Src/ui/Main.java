package ui;

import java.util.Scanner;
import model.Central.Controller;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Controller controller = new Controller();

    public static void main(String[] args) {
        System.out.println("¡Bienvenido a la Aplicación de Gestión de Tareas!");
        menu();
    }

    public static void menu() {
        int counter = 0;

        while (counter != 1) {
            System.out.println("\n¿Qué acción desea realizar?");
            System.out.println("1. Insertar nueva tarea");
            System.out.println("2. Eliminar una tarea");
            System.out.println("3. Modificar una tarea");
            System.out.println("4. Deshacer última acción");
            System.out.println("5. Salir \n");


            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("\nInsertar nueva tarea:");
                    System.out.print("ID (3 números): ");
                    String id = scanner.next();
                    System.out.print("Nombre: ");
                    String name = scanner.next();
                    System.out.print("Descripción: ");
                    String description = scanner.next();
                    System.out.print("Fecha límite ( \"yyyy-MM-dd): ");
                    String dateLimit = scanner.next();
                    System.out.print("Prioridad (0-10): ");
                    int priority = scanner.nextInt();

                    System.out.println("\n¿Qué tipo de tarea desea insertar?");
                    System.out.println("1. Tarea estándar");
                    System.out.println("2. Recordatorio");
                    int option2 = scanner.nextInt();
                    switch (option2) {
                        case 1:
                            System.out.println(controller.addTask(id, name, description, dateLimit, priority));
                            break;
                        case 2:
                            System.out.println(controller.addReminder(id, name, description, dateLimit, priority));
                            break;
                        default:
                            System.out.println("Opción no válida");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("\nEliminar tarea:");
                    System.out.print("ID de la tarea a eliminar: ");
                    String id2 = scanner.next();
                    System.out.println(controller.deleteTask(id2)); // You might need to pass an argument here
                    break;
                case 3:
                    System.out.println("\nModificar tarea:");
                    System.out.print("ID de la tarea a modificar: ");
                    String id3 = scanner.next();
                    System.out.println("¿Qué desea modificar?");
                    System.out.println("1. Nombre\n2. Descripción\n3. Fecha límite\n4. Prioridad");
                    String m = scanner.next();
                    System.out.print("Ingrese el nuevo valor: ");
                    String modify = scanner.next();
                    controller.modify(modify, id3, m);
                    break;
                case 4:
                    System.out.println(controller.undone());
                    System.out.println("Estado actual de las tareas:");
                    System.out.println(controller.mostrarEstadoTareas());
                    break;
                case 5:
                    counter = 1;
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }


}
