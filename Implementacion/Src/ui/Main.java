package ui;

import java.util.Scanner;

import Model.Controller;

public class Main {
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
                    System.out.println("Ingrese el  nivel de prioridad en una escala de 0 al 10 (Donde 0 es la prioridad mas baja y 10 la mas alta))");

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

                    System.out.println("Eliminar");
                    System.out.println("Ingrese el id");
                    String id2 = scanner.next();
                    controller.delete(id2);

                    break;

                case 3:
                    System.out.println("Modificar");
                    System.out.println("Ingrese el id");
                    String id3 = scanner.next();
                    System.out.println("Que desea modificar (escriba)");
                    System.out.println("1. Nombre \n2. Descripcion \n3. Fecha limite \n4. Prioridad");
                    String m = scanner.next();
                    System.out.println("Ingrese el nuevo valor");
                    String modify = scanner.next();

                    controller.modify(modify, id3, m);

                    break;

                case 4:
                    counter = 1;
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        }
    }

}