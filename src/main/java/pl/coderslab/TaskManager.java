package pl.coderslab;

import java.util.Scanner;

public class TaskManager {
    public static void main(String[] args) {
        readTasks();
        Scanner scanner = new Scanner(System.in);
        String selectedOption = "";
        while (!selectedOption.equals("exit")) {
            printMenu();
            selectedOption = scanner.next();
            switch (selectedOption) {
                case "add":
                    addTask();
                    break;
                case "remove":
                    removeTask();
                    break;
                case "list":
                    listTask();
                    break;
                case "exit":
                    break;
                default:
                    System.out.println(ConsoleColors.RED + "Incorrect selection!" + ConsoleColors.RESET);
                    break;
            }
        }
        saveTasks();
        System.out.println(ConsoleColors.RED + "End of program" + ConsoleColors.RESET);
    }

    public static void printMenu() {
        System.out.println(ConsoleColors.GREEN + "Please select an option:" + ConsoleColors.RESET);
        System.out.println("add");
        System.out.println("remove");
        System.out.println("list");
        System.out.println(ConsoleColors.BLUE + "exit" + ConsoleColors.RESET);
        System.out.print("Your choice: ");
    }

    public static void readTasks() {
        System.out.println(ConsoleColors.RED + "readTasks" + ConsoleColors.RESET);
    }

    public static void addTask() {
        System.out.println(ConsoleColors.RED + "addTask" + ConsoleColors.RESET);
    }

    public static void listTask() {
        System.out.println(ConsoleColors.RED + "listTask" + ConsoleColors.RESET);
    }

    public static void removeTask() {
        System.out.println(ConsoleColors.RED + "removeTask" + ConsoleColors.RESET);
    }

    public static void saveTasks() {
        System.out.println(ConsoleColors.RED + "saveTasks" + ConsoleColors.RESET);
    }
}