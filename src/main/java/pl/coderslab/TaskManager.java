package pl.coderslab;

import org.apache.commons.lang3.ArrayUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class TaskManager {
    final static String FILE_NAME = "tasks.csv";

    static String[][] tasks;


    public static void main(String[] args) {
        try {
            tasks = readTasks();
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
                        removeTask(getTaskNumber());
                        break;
                    case "list":
                        listTask();
                        break;
                    case "exit":
                        break;
                    default:
                        System.out.println(ConsoleColors.RED + "Incorrect selection!" + ConsoleColors.RESET);
                }
            }
            saveTasks();
            System.out.println(ConsoleColors.RED + "End of program" + ConsoleColors.RESET);
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }

    }

    public static void printMenu() {
        System.out.println(ConsoleColors.GREEN + "Please select an option:" + ConsoleColors.RESET);
        System.out.println("add");
        System.out.println("remove");
        System.out.println("list");
        System.out.println(ConsoleColors.BLUE + "exit" + ConsoleColors.RESET);
        System.out.print("Your choice: ");
    }

    public static String[][] readTasks() throws IOException {
        System.out.println(ConsoleColors.RED + "readTasks" + ConsoleColors.RESET);
        Path path = Paths.get(FILE_NAME);
        //Scanner fileSize = new Scanner(path);
        String[][] tab = new String[0][];
        for (String line : Files.readAllLines(path)) {
            tab = Arrays.copyOf(tab, tab.length + 1);
            tab[tab.length - 1] = line.split(",");
        }

        /*int rowNumber = 0;
        Scanner file = new Scanner(path);
        while (!file.hasNextLine()) {
            tab[rowNumber] = file.nextLine().split(",");
            rowNumber++;
        }*/
//        System.out.println(tab[0][0] + " / " +tab[1][1] +" / " + tab[2][2]);
        return tab;

    }

    public static void addTask() {
        System.out.println(ConsoleColors.RED + "addTask" + ConsoleColors.RESET);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please add task description");
        String desc = scanner.nextLine();
        System.out.println("Please add task due date");
        String date = scanner.nextLine();
        System.out.println("Is your task important: true/false");
        String impr = scanner.nextLine();
        tasks = Arrays.copyOf(tasks, tasks.length + 1);
        tasks[tasks.length - 1] = new String[3];
        tasks[tasks.length - 1][0] = desc;
        tasks[tasks.length - 1][1] = date;
        tasks[tasks.length - 1][2] = impr;

    }

    public static void listTask() {
        System.out.println(ConsoleColors.RED + "listTask" + ConsoleColors.RESET);
        for (int taskNumber = 0; taskNumber < tasks.length; taskNumber++) {
            System.out.println(taskNumber + ": " + Arrays.toString(tasks[taskNumber]));
        }

    }

    public static void removeTask(int taskNumberToDelete) {
        System.out.println(ConsoleColors.RED + "removeTask" + ConsoleColors.RESET);
        tasks= ArrayUtils.remove(tasks, taskNumberToDelete);
    }

    public static void saveTasks() {
        System.out.println(ConsoleColors.RED + "saveTasks" + ConsoleColors.RESET);
    }

    public static int getTaskNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select task number to remove: ");
        return Integer.parseInt(scanner.next());
    }
}