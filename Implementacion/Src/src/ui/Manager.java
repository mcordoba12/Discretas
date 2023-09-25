package ui;
import model.Controller;

import java.util.Scanner;
public class Manager {
    static Scanner scanner = new Scanner(System.in);
    static Controller controller = new Controller();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int counter = 0;

        while (counter != 1) {
            System.out.println("¿Que desea hacer?");
            System.out.println("1. Insertar");
            int option = scanner.nextInt();

            switch (option) {
                case 1:

                    System.out.println("Ingrese el id");
                    String id = scanner.next();
                    System.out.println("Ingrese el nombre");
                    String name = scanner.next();
                    System.out.println("Ingrese la descripcion");
                    String description = scanner.next();
                    System.out.println("Ingrese la fecha limite");
                    String dateLimit = scanner.next();
                    System.out.println("Ingrese la prioridad");
                    int priority = scanner.nextInt();

                    System.out.println("¿Que ingresaras?");
                    System.out.println("1. Tarea");
                    System.out.println("2. recordatorio");
                    int option2 = scanner.nextInt();
                    switch (option2) {
                        case 1:
                            controller.addTask(id, name, description, dateLimit, priority);
                            break;
                        case 2:
                            controller.addReminder(id, name, description, dateLimit, priority);
                            break;
                        default:
                            System.out.println("Opcion no valida");
                            break;
                    }

                    break;
                case 2:

                    break;

                case 3:
                    counter = 1;
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        }
    }
}

