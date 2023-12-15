package pl.coderslab;

import java.util.Scanner;

public class TaskManager {
    public static void main(String[] args) {
        printMenu();
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNext("exit")) {
            switch (scanner.next()) {
                case "add":
                    addTask();
                    break;
                case "remove":
                    removeTask();
                    break;
                case "list":
                    listTask();
                    break;
                default:
                    break;
            }
            printMenu();
        }
        System.out.println("End of program");
    }

    public static void printMenu() {
        System.out.println(ConsoleColors.GREEN + "Please select an option:"+ ConsoleColors.RESET);
        System.out.println("add");
        System.out.println("remove");
        System.out.println("list");
        System.out.println(ConsoleColors.BLUE + "exit" + ConsoleColors.RESET);
        System.out.print("Your choice: ");
    }

    public static void readTaskFile() {
        System.out.printf(ConsoleColors.RED + "readTaskFile" + ConsoleColors.RESET);
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
}